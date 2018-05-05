function setInfomationMessage(message){
	resetMessage();
	$("#message").text(message);
	$(".fa").addClass("fa-info-circle");
	$('#messageArea').addClass('isa_info');
	$("#messageArea").css("visibility", "");
}
function setSuccessMessage(message){
	resetMessage();
	$("#message").text(message);
	$(".fa").addClass("fa-check");
	$('#messageArea').addClass('isa_success');
	$("#messageArea").css("visibility", "");
}
function setWarningMessage(message){
	resetMessage();
	$("#message").text(message);
	$(".fa").addClass("fa-warning");
	$('#messageArea').addClass('isa_warning');
	$("#messageArea").css("visibility", "");
}
function setErrorMessage(message){
	resetMessage();
	$("#message").text(message);
	$(".fa").addClass("fa-times-circle");
	$('#messageArea').addClass('isa_error');
	$("#messageArea").css("visibility", "");
}

function resetMessage(){
	$("#messageArea").css("visibility", "visibility");
	$("#message").text("");
	$(".fa").removeClass("fa-info-circle");
	$(".fa").removeClass("fa-check");
	$(".fa").removeClass("fa-warning");
	$(".fa").removeClass("fa-times-circle");
	$('#messageArea').removeClass('isa_info');
	$('#messageArea').removeClass('isa_success');
	$('#messageArea').removeClass('isa_warning');
	$('#messageArea').removeClass('isa_error');
}

function fadeIn(){
	$("#messageArea").removeClass("fadeOut");
	$("#messageArea").addClass("fadeIn");
}

function fadeOut(){
	$("#messageArea").removeClass("fadeIn");
	$("#messageArea").addClass("fadeOut");
}