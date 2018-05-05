$(function() {
	var nav = $('.nav');
	$('li', nav).mouseover(function(e) {
		$('ul', this).stop().slideDown('fast');
	}).mouseout(function(e) {
		$('ul', this).stop().slideUp('fast');
	});

	$('#menu_top').on('click', function() {
		var base_url = window.location.origin;
		location.href = base_url + $('#base_url').val() + 'top';
	});
});
