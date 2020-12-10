function continueWelcome() 
{
	//transition to 'today' section
	$(".welcomeSummary").fadeOut("fast");
	$(".welcomeToday").css("visibility", "visible").fadeIn("slow");
}

function beginSetup()
{
	window.location="../Student/loading.html";
}