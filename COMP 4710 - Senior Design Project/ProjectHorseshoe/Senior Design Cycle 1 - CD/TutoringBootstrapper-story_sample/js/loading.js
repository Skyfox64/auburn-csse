function connectToTutor()
{
	$(".loadingMsg").fadeOut();
	$(".connectingMsg").delay(800).css("visibility", "visible").fadeIn("slow");
}

function lessonReady()
{
	$(".connectingMsg").fadeOut();
	$(".readyMsg").delay(800).css("visibility", "visible").fadeIn();
}

//after 2 seconds, call connectToTutor
setTimeout(connectToTutor, 2000);
setTimeout(loadReading, 5000);

function loadReading()
{
	window.location="http://read.amazon.com";
}