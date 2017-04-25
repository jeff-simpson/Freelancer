//$(document).ready(function(){
//	$('#payButton').click(function(){
//		
//	});
//
//}); // end of ready
//
//



function payUser(receiverID, giverID, taskID) {
    var name = "topic";
    var obj = {receiverID : receiverID, giverID: giverID, taskID: taskID};
	
	$.ajax({
		url: "AjaxBoundary",
		data: obj,
		dataType: "json",
		success:updateBalance,
		complete: function() {
//			$("#actor").fadeIn("slow");
		}
	});
}

function updateBalance(data) {
	$("#accountBalance").html("");
	var table = $("#accountBalance");
//	table.append("Account Balance:" + obj.balance);
	$.each(data,function(index, obj){
		table.append("Account Balance:" + obj.balance);
		
	});
 }




