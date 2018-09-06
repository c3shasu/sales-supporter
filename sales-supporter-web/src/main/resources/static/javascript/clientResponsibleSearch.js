function RadioValue(name) {
	// ラジオボタンオブジェクトを取得する
	alert("開始");
	var radios = document.getElementsByName('Check');
	var name = document.getElementsByName("name");
	//var branchNo = document.getElementsByName("Check");
	alert("1"+name.value);
	//alert(branchNo.value);
	// 取得したラジオボタンオブジェクトから選択されたものを探し出す
	var result1;
	var result2;
	for (var i = 0; i < name.length; i++) {
		alert(name[i].value);
		if (radios[i].checked) {
			// 選択されたラジオボタンのvalue値を取得する
			result1 = name[i].value;
			//result2 = branchNo[i].value;
			break;
		}
	}
	// value値を表示する
	alert("2"+result1);
	//document.getElementById("target").value = result;

	// value値を表示する
	window.opener.document.getElementById("name").value = result1;
	//window.opener.document.getElementById("branchNo").value = result2;

	window.close();
}