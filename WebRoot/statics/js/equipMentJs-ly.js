$(function(){
	$(".mentClassify-ly div").click(function(){
		$(this).parent().children().css("background-color","whitesmoke");
		$(this).css("background-color","lightsteelblue");
		var neirong=$(this).children().text();
		$(".heroList-ly span").text(neirong+">>");
	});
	
	$(".managementHome1-ly").click(function(){
		$(".heroTableDiv-ly").css("display","block");
		$(".heroAddDiv-ly").css("display","none");
	});
	
	$(".managementHome2-ly").click(function(){
		$(".heroTableDiv-ly").css("display","none");
		$(".heroAddDiv-ly").css("display","block");
	});
	
	
});