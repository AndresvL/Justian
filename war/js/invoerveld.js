$("document").ready(function(){
	$("#msgs").write("hello");
	$('#submit').click(function() {
		var invoer = $("#antwoord");
		if(invoer == null || invoer == ""){
			$("#msgs").val("Vul een antwoord in");
		}
	}
}