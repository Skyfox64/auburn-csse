function validateLogin() {
	var username = $("#usernameForm").val();
	var password = $("#passwordForm").val();
	var firstVisit = true;
	if(username.toLowerCase().trim() == "maria")
	{
		window.location="../views/Student/welcome.html";
	}
	else if(username.toLowerCase().trim() == "james")
	{
		$(".securedLogin").css("display", "table-cell");
		$(".haveMercy").css("display", "table");
		console.log("Password: " + password);
		if(password == "admin")
		{
			window.location="../views/Admin/welcome.html";
		}
		else if(!firstVisit)
		{
			alert("WRONG");
			$("#passwordErrorMsg, #passwordErrorMsg>span").css("visibility", "visible");
		}
	}
	else
	{
		$("#usernameErrorMsg, #usernameErrorMsg>span").css("visibility", "visible");
	}
	firstVisit = false;
	console.log("set to false");
}

