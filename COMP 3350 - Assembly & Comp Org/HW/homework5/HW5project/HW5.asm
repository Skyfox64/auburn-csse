TITLE Homework 5 (COMP 3350 Fa14) - John Carroll

INCLUDE Irvine32.inc

.data
; DO NOT PUT ANYTHING IN THE .DATA SECTION

.code

; IsOdd -- Receives a 32-bit signed integer and determines if it is odd or even.
; Uses the STDCALL calling convention.
; Receives: [ebp+8]  32-bit signed integer
; Returns:    EAX    1 if the integer is odd, and 0 if it is even
IsOdd PROC
	;Create Stack
		enter 0, 0							
		mov eax, [ebp + 8]				;Get 32-bit signed integer, place into EAX
		shr eax, 1						;Shift the bits right by 1

	;Set to 1 if carry is set
		jc integerIsOdd		

	;Set to 0 if carry is not			
		mov eax, 0		

	;IsOdd is complete, proceed to epilogue				
		jmp epilogue						

integerIsOdd:							
		mov eax, 1						

epilogue:									
	;Destroy stack frame
		leave					
	;return		
		ret 4						

IsOdd ENDP

; Pack -- Receives an array of n bytes, where each byte is a value in the
;         range [0h, Fh].  Packs consecutive pairs of values, two per byte,
;         storing them in an array of ceil(n/2) bytes.
; Uses the STDCALL calling convention.
; Receives: [ebp+8]  Pointer to BYTE array of input values
;           [ebp+12] Number of bytes in the input array
;           [ebp+16] Pointer to BYTE array to store output values
; Returns:    EAX    Number of bytes stored in the output array
Pack PROC

	;PROLOGUE
	;create stack frame
		enter 0, 0			

	;push ebx, ecx, edx, edi, esi onto the stack
		push ebx			
		push ecx
		push edx							
		push edi					
		push esi						
										
	;Initialize counters and get arguments
		mov esi, 0							;ESI - counter for bytes received
		mov edi, 0							;EDI - counter for bytes packed
		mov ebx, [ebp + 8]					;Pointer to BYTE array of input values
		mov ecx, [ebp + 12]					;Number of bytes in the input array
		mov eax, [ebp + 16]					;Pointer to BYTE array to store output values

readIn:									
	;Exit Loop and get to packing if the input array is empty
	;This is the end of a full BYTE
		jecxz getReturn					
		mov edx, 0							;Clear edx
	
	;Move the next available byte of the array into DH
		mov dh, BYTE PTR [ebx + esi]		
		inc esi								;Count bytes received
		dec ecx								;Count down the bytes in the input array

	;If the input array is empty here at the nibble mark, go to add a 0 into the lower nibble
		jecxz addNibble					
	
	;Move the next available byte of the array into DL
		mov dl, BYTE PTR [ebx + esi]		
		inc esi								;Count bytes received
		dec ecx								;Count down the bytes in the input array

packArray:									;label to come back into the loop
	;Something is in DH and DL. Shift DL left, then DX(DH:DL) right.
		shl dl, 4						
		shr dx, 4					
	;Write the packed byte to the next open slot of the output array
		mov BYTE PTR[eax + edi], dl			
		inc edi								;Count bytes packed
	;Jump to try and read in more bytes from input array
		jmp readIn												

addNibble:								;label for if the loop ended on a nibble
		mov dl, 0							;set dl to 0 as a place holder
		jmp packArray							;jump to back

getReturn:								;label to get the output array size
	;Take the size of the input array, divide by 2, see if it is odd, if so then add 1.
		mov eax, [ebp + 12]					
		shr eax, 1							
		jc itIsOdd						
		jmp epilogue	

itIsOdd:							
		add eax, 1							;Add another nibble to complete a byte
		jmp epilogue	
		
epilogue:
	;pop ebx, ecx, edx, edi, esi off the stack
		pop esi							
		pop edi							
		pop edx							
		pop ecx							
		pop ebx								

	;Destroy stack frame
		leave	

	;return
		ret 12								
Pack ENDP


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;                 DO NOT MODIFY ANYTHING BELOW THIS LINE
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

.data
TAB = 09h
msgTesting   BYTE   "Is odd? ", 0
msgArrow     BYTE   " => ", 0
msgInput     BYTE   "Input (", 0
msgResult    BYTE   "Result (", 0
msgBytes     BYTE   " bytes):", TAB, 0
msgStackErr  BYTE   "SOLUTION IS INCORRECT: Stack frames have not been completely destroyed (ESP incorrect)", 0
msgDataErr   BYTE   "SOLUTION IS INCORRECT: Data segment has been modified", 0
topPtr       DWORD  ?
copy         DWORD  ?
result       SBYTE  5 DUP(?)
START = $
			 BYTE   100 DUP(0)
even1        BYTE   01h, 02h, 03h, 04h, 0Fh, 0Eh, 0Dh, 0Ch, 0Bh, 0Ah
odd1         BYTE   0Bh, 02h, 0Dh
odd2         BYTE   0Ah
even2        BYTE   0Ch, 00h, 0Eh, 03h, 06h, 04h
empty        LABEL BYTE
			 BYTE   100 DUP(0)
DATASIZE = $ - START

.code
main PROC
	; Save ESP and copy the input data to compare against later
	call Prepare

	; Test IsOdd on several input values
	mov eax, 3
	call RunIsOddTest
	call Check

	mov eax, 2
	call RunIsOddTest
	call Check

	mov eax, 1
	call RunIsOddTest
	call Check

	mov eax, 0
	call RunIsOddTest
	call Check

	mov eax, 1
	call RunIsOddTest
	call Check

	mov eax, 2
	call RunIsOddTest
	call Check

	mov eax, 3
	call RunIsOddTest
	call Check

	mov eax, 80000000h
	call RunIsOddTest
	call Check

	mov eax, 80000009h
	call RunIsOddTest
	call Check

	mov eax, 7FFFFFFeh
	call RunIsOddTest
	call Check

	mov eax, 7FFFFFFdh
	call RunIsOddTest
	call Check

	; Test Pack on several arrays
	mov esi, OFFSET even1
	mov ecx, LENGTHOF even1
	call RunPackTest
	call Check

	mov esi, OFFSET odd1
	mov ecx, LENGTHOF odd1
	call RunPackTest
	call Check

	mov esi, OFFSET odd2
	mov ecx, LENGTHOF odd2
	call RunPackTest
	call Check

	mov esi, OFFSET even2
	mov ecx, LENGTHOF even2
	call RunPackTest
	call Check

	mov esi, OFFSET empty
	mov ecx, 0
	call RunPackTest
	call Check

	exit
main ENDP

; Runs IsOdd on a test value, displaying the input and result
; Receives: EAX -- 32-bit signed integer value to test
; Returns: (none)
RunIsOddTest PROC
	push edx

	mov edx, OFFSET msgTesting
	call WriteString

	call WriteInt

	push eax
	call IsOdd

	mov edx, OFFSET msgArrow
	call WriteString

	call WriteInt

	call Crlf

	pop edx
	ret
RunIsOddTest ENDP

; Runs Pack on a test array, displaying the input and result
; Receives: ESI -- Pointer to BYTE input array
;           ECX -- Length of input array
; Returns: (none)
RunPackTest PROC
	push eax
	push ecx
	push edx
	push esi

	mov edx, OFFSET msgInput
	call WriteString
	mov eax, ecx
	call WriteDec
	mov edx, OFFSET msgBytes
	call WriteString

	call ShowArray

	push OFFSET result
	push ecx
	push esi
	call Pack

	mov edx, OFFSET msgResult
	call WriteString
	call WriteDec
	mov edx, OFFSET msgBytes
	call WriteString

	mov esi, OFFSET result
	mov ecx, eax
	call ShowArray

	pop esi
	pop edx
	pop ecx
	pop eax
	ret
RunPackTest ENDP

; Displays values in a BYTE array in hexadecimal
; Receives: ESI -- Pointer to BYTE input array
;           ECX -- Length of input array
; Returns: (none)
ShowArray PROC
	push esi
	push ecx

	jecxz done

show:
	movsx ebx, SBYTE PTR [esi]
	call ShowByte
	mov al, ' '
	call WriteChar
	inc esi
	loop show

done:
	call Crlf

	pop ecx
	pop esi
	ret
ShowArray ENDP

; Displays the byte value in BL in hexadecimal
ShowByte PROC
	push eax
	push ebx

	; Store upper and lower nibbles in BH, BL
	mov bh, bl
	shr bh, 4
	and bl, 00001111b

	cmp bh, 0
	je show_low
	mov ah, bh
	call ShowNibble

show_low:
	mov ah, bl
	call ShowNibble

	pop ebx
	pop eax
	ret
ShowByte ENDP

; Shows the hex digit corresponding to the 4-bit value in AH
ShowNibble PROC
	push eax

	cmp ah, 10
	jb show_digit

	cmp ah, 16
	jb show_letter

	mov al, '?'
	call WriteChar
	jmp done

show_digit:
	mov al, '0'
	add al, ah
	call WriteChar
	jmp done

show_letter:
	mov al, 'A'
	sub ah, 0Ah
	add al, ah
	call WriteChar

done:
	pop eax
	ret
ShowNibble ENDP

; Prepare -- copies the input data onto the heap
Prepare PROC
	mov topptr, esp

	call GetProcessHeap

	mov esi, DATASIZE
	push esi
	push 0
	push eax
	call HeapAlloc
	mov copy, eax

	mov esi, START
	mov edi, copy
	mov ecx, DATASIZE
	cld
	rep movsb

	ret
Prepare ENDP

; Check -- compares the .data segment to the copy on the heap
;          and checks that stack frames have been destroyed
Check PROC
	cmp topptr, esp
	jne stack_error

	mov esi, START
	mov edi, copy
	mov ecx, DATASIZE
	cld
	repz cmpsb
	jnz data_error

	ret

stack_error:
	mov edx, OFFSET msgStackErr
	call WriteString
	ret

data_error:
	mov edx, OFFSET msgDataErr
	call WriteString
	ret
Check ENDP

END main
