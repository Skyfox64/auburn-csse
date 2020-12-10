TITLE COMP 3350 Homework 3 (Fa14) - John Carroll
INCLUDE Irvine32.inc
.data
	values SWORD  10 DUP(?)						;The array of signed integer Values
	promptMsg BYTE "Enter a value: ", 0			;The message prompt given to the user
	errorMsg BYTE "Out of range", 0				;The error message if the user input is bad
	spaceChar BYTE 20h, 0						;The ASCII char for a space

.code
main PROC
	;Initialize program counter for use, starting at 0
		mov ecx, 0
;(1) Repeat the following 10 times:
	;(a)Display Enter a value:
promptValue:
		mov edx, offset promptMsg			;Move the prompting message into EDX
		call WriteString					;Display the prompt from EDX
	
	;(b)Read a signed value from the keyboard into EAX
		call ReadInt
	;(c)If the integer is less than -32768 or greater than 32767, display "Out of range" and exit
		;Use compare CMP to see if the value in EAX is within range
		cmp eax, -32768
		jl errorExit
		cmp eax, 32767
		jg errorExit	
	;(d) Store the values of AX
	; Add new values until an array of size 10 is achieved.
		mov [values + ecx*SIZEOF WORD], ax
		inc ecx
		cmp ecx, 10
		je displayValue
		jmp promptValue

;After Step 1 has completed, values should contain the 10 integer values entered by the user.

;(2) Display the 10 values in reverse order, on one line, separated by spaces. 
; Do not reverse the array in memory; just display it in reverse order.
displayValue:	
	;Decrement ecx, then move the next value into EAX
		dec ecx
		movsx eax, [values + ecx*SIZEOF WORD]   ; Display value

	;Display the value
		call WriteInt

	;Follow it with a space
		mov edx, offset spaceChar
		call WriteString

	;See if it is time to move on to prefixSum
	    jecxz displayPrefixSum                  ; Done displaying when ECX = 0

	;If not, keep displaying the values
		jmp displayValue
	
	
;(3) Display the prefix sum of the values array, on one line, with values separated by spaces.
; Use 32-bit values when computing the prefix sum, so it will not overflow.
prefixSumBeginning:
	; Drop a line
		call crlf

	; Load first value into EAX
		movsx eax, [values]

displayPrefixSum:
	;Displays the prefix sum
		call WriteInt
	;Add a space
		mov edx, OFFSET spaceChar
		call WriteString
	;Increment ecx, which is 0 from part 2, then cmp if it is 10, if so then the program is done.
		inc ecx
		cmp ecx, 10
		je done; THIS IS THE EXIT

	;Move the next value into EBX, add EBX to EAX, then repeat the displayPrefixSum loop
		movsx ebx, [values + 2 * ecx]
		add eax, ebx
		jmp displayPrefixSum
		
errorExit:
	;Displays the error message and then continues to exit the program
		mov edx, offset errorMsg
		call WriteString
done:
	;Exit the program
		call crlf
		exit
main ENDP
END main