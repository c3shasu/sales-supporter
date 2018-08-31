
function num3(){

	var deductionPrice = document.getElementById("deductionPrice").textContent;
	var price = document.getElementById("price").textContent;
	var excessPrice = document.getElementById("excessPrice").textContent;
	var cost = document.getElementById("cost").textContent;
	var excessCost = document.getElementById("excessCost").textContent;
	var deductionCost = document.getElementById("deductionCost").textContent;
	var manHours = document.getElementById("manHours").textContent;

	const separateNum = (num) => {
		  return String(num).replace(/(\d)(?=(\d\d\d)+(?!\d))/g, "$1,")
		}
	document.getElementById("deductionPrice").textContent=separateNum(deductionPrice);
	document.getElementById("price").textContent=separateNum(price);
	document.getElementById("excessPrice").textContent=separateNum(excessPrice);
	document.getElementById("cost").textContent=separateNum(cost);
	document.getElementById("excessCost").textContent=separateNum(excessCost);
	document.getElementById("deductionCost").textContent=separateNum(deductionCost);
	document.getElementById("manHours").textContent=separateNum(manHours);
}