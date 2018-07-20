$(function() {
	$('.datepicker')
			.datepicker(
					{
						dateFormat : "yy/mm/dd",
						dayNamesMin : [ '日', '月', '火', '水', '木', '金', '土' ],
						showOn : "button",
						buttonImageOnly : true,
						buttonImage : "https://www.softel.co.jp/blogs/jquery/wp/wp-content/uploads/2012/01/calendar.gif",
						beforeShow : function(input, inst) {
							// 開く前に日付を上書き
							var year = $(this).parent().find(".year").val();
							var month = $(this).parent().find(".month").val();
							var date = $(this).parent().find(".date").val();
							$(this).datepicker("setDate",
									year + "/" + month + "/" + date)
						},
						onSelect : function(dateText, inst) {
							var dates = dateText.split('/');
							$(this).parent().find(".year").val(dates[0]);
							$(this).parent().find(".month").val(dates[1]);
							$(this).parent().find(".date").val(dates[2]);
						}
					});
});