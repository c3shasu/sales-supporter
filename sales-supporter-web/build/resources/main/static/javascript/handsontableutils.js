/**
 * HandsonTable用にJSON文字列をJavascriptの配列に変換する。
 * @param json JSON（2次元）
 * @param properties プロパティ名を表示順で指定（Array）
 * @returns 変換後の配列
 */
function toArrayForHandsonTable(json, properties){
	var array = new Array();
	for(var i = 0; i<json.length; i++){
		var item = new Array();
		for(var j = 0; j < properties.length; j++){
			item.push(json[i][properties[j]]);
		}
		array.push(item);
	}
	return array;
}