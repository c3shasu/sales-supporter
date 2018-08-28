function RadioValue(name) {
	// ラジオボタンオブジェクトを取得する
	var radios = document.getElementsByName('Check');
	var name = document.getElementsByName('Name');
	var cost = document.getElementsByName('Cost');
	// 取得したラジオボタンオブジェクトから選択されたものを探し出す
	var result1;
	var result2;
	var result3;
	for (var i = 0; i < radios.length; i++) {
		if (radios[i].checked) {
			// 選択されたラジオボタンのvalue値を取得する
			result1 = radios[i].value;
			result2 = name[i].value;
			result3 = cost[i].value;
			break;
		}
	}
	// value値を表示する
	 alert("value値は" + result1 + "です");
	//document.getElementById("target").value = result;

	// value値を表示する
	window.opener.document.getElementById("employeeCode").value = result1;
	window.opener.document.getElementById("engineerName").value = result2;
	window.opener.document.getElementById("Wcost").value = result3;
	window.close();
}