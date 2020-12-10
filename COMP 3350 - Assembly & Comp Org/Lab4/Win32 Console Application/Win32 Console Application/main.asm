.model flat, stdcall

STD_INPUT_HANDLE = -10
STD_OUTPUT_HANDLE = -11
STD_ERROR_HANDLE = -12

GetStdHandle PROTO,  ; Get handle for stdin/stdout/stderr
	nStdHandle:DWORD

ReadConsoleA PROTO,  ; Read input from the console
	handle:DWORD,			;1|Input handle
	pBuffer:PTR BYTE,		;2|Pointer to buffer to store input
	maxBytes:DWORD,			;3|Max number of bytes to read
	pBytesRead:PTR DWORD,	;4|Pointer to store number of bytes read
	unused:DWORD			;5|Unused (set to 0)

WriteConsoleA PROTO,  ; Display output on the console
	hConsoleOutput:DWORD,             ; 1|Console handle
	lpBuffer:PTR BYTE,                ; 2|Output buffer
	nNumberOfCharsToWrite:DWORD,      ; 3|Size of buffer
	lpNumberOfCharsWritten:PTR DWORD, ; 4|Num bytes written
	lpReserved:DWORD                  ; 5|(Not used)

Sleep PROTO,		; Places the console to sleep/wait, milliseconds
	dwMilliseconds:DWORD	;Specified amount of time in ms

ExitProcess PROTO,	; Calls to exit the console
	dwExitCode:DWORD
;________________________________________________________________________
.data
input			BYTE 100 DUP(?)
;helloWorld         BYTE "Hello, world!"

hStdin			DWORD ?
numCharsRead	DWORD ?

hStdout         DWORD ?
numCharsWritten DWORD ?


.code
main PROC
	;================================================
	; Part 5
	;================================================

	;Get handle for reading input
		push STD_INPUT_HANDLE
		call GetStdHandle
		mov hStdin, eax

	; Read in the user input
		push 0							;5 Unused
		push OFFSET numCharsRead		;4 place to store number of bytes read
		push 100						;3 Max bytes
		push OFFSET input				;2 Place to store input
		push hStdin						;1 Input Handle
		call ReadConsoleA
	
	; Get a handle for standard output
		push STD_OUTPUT_HANDLE
		call GetStdHandle
		mov hStdout, eax

	; Write hello to standard output
		push 0							;5 Unused
		push OFFSET numCharsWritten		;4 num bytes written
		push LENGTHOF input				;3 Size of buffer
		push OFFSET input				;2 output buffer
		push hStdout					;1 Output handle
		call WriteConsoleA
	
	;Place console to sleep for 5 seconds
		push 5000
		call Sleep

	; Exit Program
		push 0
		call ExitProcess
main ENDP
END main