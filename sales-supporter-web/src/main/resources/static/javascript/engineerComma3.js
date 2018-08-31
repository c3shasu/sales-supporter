$(function() {
	let isIME = false;

  $('#price').on('keydown', function(e) {
  	isIME = true;
  });

  $('#price').on('keypress', function(e) {
  	isIME = false;
  });

  $('#price').on('keyup', function(e) {
  	if (isIME === false)
    	$(this).val(addFigure($(this).val()));
  });

  $('#price').on('blur', function() {
  	$(this).val(addFigure($(this).val()));
  });

  $('#excessPrice').on('keydown', function(e) {
  	isIME = true;
  });

  $('#excessPrice').on('keypress', function(e) {
  	isIME = false;
  });

  $('#excessPrice').on('keyup', function(e) {
  	if (isIME === false)
    	$(this).val(addFigure($(this).val()));
  });

  $('#excessPrice').on('blur', function() {
  	$(this).val(addFigure($(this).val()));
  });

  $('#deductionPrice').on('keydown', function(e) {
  	isIME = true;
  });

  $('#deductionPrice').on('keypress', function(e) {
  	isIME = false;
  });

  $('#deductionPrice').on('keyup', function(e) {
  	if (isIME === false)
    	$(this).val(addFigure($(this).val()));
  });

  $('#deductionPrice').on('blur', function() {
  	$(this).val(addFigure($(this).val()));
  });

  $('#cost').on('keydown', function(e) {
  	isIME = true;
  });

  $('#cost').on('keypress', function(e) {
  	isIME = false;
  });

  $('#cost').on('keyup', function(e) {
  	if (isIME === false)
    	$(this).val(addFigure($(this).val()));
  });

  $('#cost').on('blur', function() {
  	$(this).val(addFigure($(this).val()));
  });

  $('#excessCost').on('keydown', function(e) {
  	isIME = true;
  });

  $('#excessCost').on('keypress', function(e) {
  	isIME = false;
  });

  $('#excessCost').on('keyup', function(e) {
  	if (isIME === false)
    	$(this).val(addFigure($(this).val()));
  });

  $('#excessCost').on('blur', function() {
  	$(this).val(addFigure($(this).val()));
  });

  $('#deductionCost').on('keydown', function(e) {
  	isIME = true;
  });

  $('#deductionCost').on('keypress', function(e) {
  	isIME = false;
  });

  $('#deductionCost').on('keyup', function(e) {
  	if (isIME === false)
    	$(this).val(addFigure($(this).val()));
  });

  $('#deductionCost').on('blur', function() {
  	$(this).val(addFigure($(this).val()));
  });

  $('#manHours').on('keydown', function(e) {
  	isIME = true;
  });

  $('#manHours').on('keypress', function(e) {
  	isIME = false;
  });

  $('#manHours').on('keyup', function(e) {
  	if (isIME === false)
    	$(this).val(addFigure($(this).val()));
  });

  $('#manHours').on('blur', function() {
  	$(this).val(addFigure($(this).val()));
  });
});


const addFigure = function (value) {
  let originValue = value;
  value = removeFigure(value);
  value = parseInt(value, 10);
  if (isNaN(value)) return originValue;
  return value.toString().replace(/(\d)(?=(\d{3})+$)/g, '$1,');
};
const removeFigure = function (value) {
  if (value.length === 0) return '';
  let num = Number(value.toString().replace(/,/g, ''));
  if (isNaN(num)) return value;
  return num;

};