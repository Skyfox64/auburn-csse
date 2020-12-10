INCLUDE Irvine32.inc

.data
	; ASCII Characters
space BYTE 20h, 0							; space
doubleSpace BYTE 20h, 20h, 0				; two spaces
forwardSlash BYTE 2Fh, 0Dh, 0Ah, 0			; forward slash
backSlash BYTE 5Ch, 0						; backward slash
	
placeHolder DWORD 0		                    ; Place holder for value

.code
main PROC
		  call Clrscr

		  mov ebp, 0							; Counter - ebp will be the number of times the loop has iterated
		  call ReadDec							; Gets n and stores in eax
		  mov ecx, eax						    ; Move n to ecx

beginning:										; Enter primary loop sequence
		  jecxz ending							; This marks the final exit condition
		  mov placeHolder, ecx					; Placeholder will hold the value of ecx
		  mov ecx, ebp						    ; Set ecx for loop to setting leading spaces

	loop1:									    ; Loop for creating spaces before backslashes
		  jecxz endloop1					    ; This is the exit condition for loop1
		  mov edx, offset space
		  call WriteString						; Creates and prints the leading spaces
		  dec ecx   							; Decrement ecx
		  jmp loop1						        ; Repeat loop1

 endloop1:  								    ; Last iteration of loop1
		  mov ecx, placeHolder					; Reset ecx to the current value of n
		  mov edx, offset backSlash
		  call WriteString						; Prints the baskslash(es)
		  dec ecx       						; Decrements ecx
		  mov edi, ecx						    ; Stores the value of ecx in edi

	loop2:										; Loop to make spaces inbetween slashes
		  jecxz endloop2					    ; Exit condition
		  mov edx, offset doubleSpace
		  call WriteString						; Creates and prints spaces
		  dec ecx            					; Decrements ecx
		  jmp loop2						        ; Repeat loop2

endloop2:									    ; Last iteration of loop2
		  mov ecx, edi  						; Restore ecx to previous value
		  mov edx, offset forwardSlash
		  call WriteString						; Prints the forwardSlash(es)
		  inc ebp    						    ; Increment ebp by 1
		  jmp beginning							; Repeat main loop

   ending:										; End of primary program loop (main)
		  nop;									; Do nothing and exit
		  exit

main ENDP
END main