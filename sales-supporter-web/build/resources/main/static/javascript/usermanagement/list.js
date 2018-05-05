
/* ユーザ情報のプロパティ */
var userListProperties = new Array("userId", "userName", "createDate");

/**
 * 初期表示処理
 */
$(function() {
	var container = $("#userList").get(0);
	var hot = new Handsontable(container, {
		data : new Array(),
		currentRowClassName : 'currentRow',
		currentColClassName : 'currentCol',
		rowHeaders : true,
		colHeaders : true,
		columnSorting: true,
		contextMenu: true,
		contextMenu: {
		    items: {
		        'row_above': {name: '１行挿入(上)'},
		        'row_below': {name: '１行挿入(下)'},
		        'hsep1': '---------',
		        'col_left':  {name: '１列挿入(左)'},
		        'col_right': {name: '１列挿入(右)'},
		        'hsep2': '---------',
		        'remove_row': {name: '行削除'},
		        'remove_col': {name: '列削除'},
		        'hsep3': '---------',
		        'undo': {name: '戻る'},
		        'redo': {name: '進む'},
		        'hsep4': '---------',
		        'make_read_only': {name: '読み取り専用'},
		        'alignment': {name: '文字'},
		    }
		},
		colHeaders : [ 'ID', '氏名', '作成日時' ],
		columns: [
		          {userList: 'ID'},
		          {userList: '氏名'},
		          {userList: '作成日', type: 'date', dateFormat: 'YYYY/MM/DD' }
		],
		afterChange: function(change, source){
			if (source === 'loadData') {
                return;
            }
			// オートセーブのチェックボックス対応
			if(!$("#autosave").prop('checked')){
				return;
			}
			var changeUserList = new Array();
			for(var i = 0; i < change.length; i++){
				var changeUser = {};
				var row = change[i][0];
				var column = change[i][1];
				// 初期化
				changeUser.userId = userList[row][0];
				changeUser.userName = userList[row][1];
				changeUser.createDate = userList[row][2];
				// 必須項目が無い場合は変更対象としない
				if(changeUser.userId == null){
					continue;
				}
				//変更値の取得
				if(column == 1){
					changeUser.userName = change[i][3];
				}
				if(column == 2){
					changeUser.createDate = change[i][3];
				}
				changeUserList.push(changeUser);
			}

			// 変更対象が0件の場合は通信しない
			if(changeUserList.length == 0){
				return;
			}

			$.ajax({
				url: "userlist/update",
				contentType: 'application/json',
				dataType: "text",
				type: "POST",
				data: JSON.stringify(changeUserList),
				success: function (data) {
					redrawForUserList(hot, data, userListProperties, "Save completed. (Auto)");
				},
				error:function(){
					setErrorMessage("Failed to save.");
				}
			});
		 }
	});

	// ロードボタン
	$("#load").click(function(){
		$.ajax({
			url: "userlist/load",
			contentType: 'application/json',
			dataType: "text",
			type: "POST",
			data: JSON.stringify(changeAssociativeForUserList(hot.getData())),
			success: function (data) {
				var message = "Load completed."
				if(hot.getData().length == 0){
					message = "";
				}
				redrawForUserList(hot, data, userListProperties, message);
			},
			error:function(){
				setErrorMessage("Failed to save.");
			}
		});
	});

	// セーブボタン
	$("#save").click(function(){
		$.ajax({
			url: "userlist/save",
			contentType: 'application/json',
			dataType: "text",
			type: "POST",
			data: JSON.stringify(changeAssociativeForUserList(hot.getData())),
			success: function (data) {
				redrawForUserList(hot, data, userListProperties, "Save completed.");
			},
			error:function(){
				setErrorMessage("Failed to save.");
			}
		});
	});

	$("#load").click();
});

/**
 *
 * REST用に連想配列変換
 * @param data ユーザ情報リスト
 * @returns 連想配列
 */
function changeAssociativeForUserList(data){
	var userList = new Array();
	for(var i = 0; i < data.length; i++){
		var user = {};
		user.userId = data[i][0];
		user.userName = data[i][1];
		user.createDate = data[i][2];
		userList.push(user);
	}
	return userList;
}

/**
 * ユーザ情報リスト再描画
 * @param target 対象HandsonTable
 * @param data ユーザ情報のJSON文字列
 * @param properties プロパティ（並び順）
 * @param message 描画時のメッセージ
 */
function redrawForUserList(target, data, properties, message){
	setTimeout(function(){
		var jsonObject = JSON.parse(data);
		var dataArray = toArrayForHandsonTable(jsonObject, properties);
		target.loadData(dataArray);
		if(message != ""){
			setInfomationMessage(message);
		}
		fadeIn();
	}, 500);

	setTimeout(function(){
		fadeOut();
	}, 4000);
}

