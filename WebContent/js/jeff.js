$(document).ready(function(){
	$('#payButton').click(function(){
		var obj = {allactors : "yes"};
		
		$.ajax({
			url: "AjaxServlet",
			data: obj,
			dataType: "json",
			success:createTable,
			complete: function() {
				$("#actor").fadeIn("slow");
			}
		});
	});

}); // end of ready

function createTable(data) {
	$("#accountBalance").html("");
	var table = $("#accountBalance");
//	table.append("Account Balance:" + obj.balance);
	$.each(data,function(index, obj){
		table.append("Account Balance:" + obj.balance);
		
	});
 }