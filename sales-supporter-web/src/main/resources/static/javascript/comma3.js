
function num3(){

	var excessPrice = document.getElementById("excessPrice");
	var price = document.getElementById("price");
	var deductionPrice = document.getElementById("deductionPrice");
	var cost = document.getElementById("cost");
	var excessCost = document.getElementById("excessCost");
	var deductionCost = document.getElementById("deductionCost");
	var manHours = document.getElementById("manHours");
	excessPrice.value;
	const separateNum = (num) => {
		  return String(num).replace(/(\d)(?=(\d\d\d)+(?!\d))/g, "$1,")
		}
	document.getElementById( "excessPrice" ).defaultValue  =separateNum(excessPrice.value);
	document.getElementById( "price" ).defaultValue  =separateNum(price.value);
	document.getElementById( "deductionPrice" ).defaultValue  =separateNum(deductionPrice.value);
	document.getElementById( "cost" ).defaultValue  =separateNum(cost.value);
	document.getElementById( "excessCost" ).defaultValue  =separateNum(excessCost.value);
	document.getElementById( "deductionCost" ).defaultValue  =separateNum(deductionCost.value);
	document.getElementById( "manHours" ).defaultValue  =separateNum(manHours.value);
}