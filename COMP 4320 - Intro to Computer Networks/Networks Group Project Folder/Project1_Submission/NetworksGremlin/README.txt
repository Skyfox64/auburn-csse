COMP 4320 Intro to Computer Networks
Project 1
Group Members:
	John Carroll
	Allison Macdonald
	Cesar Sanchez

Compilation and run instructions for Networks Project 1
	Download NetworksGremlin.zip.
	Unzip NetworksGremlin.zip into working directory.
	While inside of ./NetworksGremlin, run 'make'.
	Now that compilation is done, type './server' to start the server.
	The server should now be awaiting on the port we have been assigned.
	To start the client type './client' followed by three parameters.
		<TUX COMPUTER as INTEGER>
		<PROBABILITY OF CORRUPTION as INTEGER in range 0-100>
		<PROBABILITY OF LOSS as INTEGER in range 0-100>
	i.e $./client 190 0 0
		$./client 176 33 83
		$./client 175 19 100
	The client should now communicate with the server.