INCLUDE Irvine32.inc
.data
start=$
BYTE 0, 0, 0
arr1 DWORD 1, 2, 3
arr2 DWORD 0AABBCCDDh, 0FFEEDDCCh
BYTE 0, 0, 0

.code
main PROC
	COMMENT!
	; Displays the last element of arr1: 00000003
	mov esi, OFFSET arr1
	mov ecx, LENGTHOF arr1
	call lastElement 
	call WriteHex
	call Crlf



	;Displays the last element of arr2: FFEEDDCC
	mov esi, OFFSET arr2
	mov ecx, LENGTHOF arr2
	call lastElement
	call WriteHex
	call Crlf
	!


	push OFFSET x ; 2
	call foo ; 3
	mov eax, 1 ; 4
	call WriteDec ; 5
	ret ; 6
	x: mov eax, 2 ; 7
	call WriteDec ; 8


	exit
main ENDP

foo PROC ; 11
	mov eax, 3 ; 12
	call WriteDec ; 13
	push OFFSET bar ; 14
	ret ; 15
foo ENDP ; 16
bar PROC ; 17
	pop eax ; 18
	call eax ; 19
	mov eax, 4 ; 20
	call WriteDec ; 21
	ret ; 22
bar ENDP ; 23

	; Returns the value of the last element in an DWORD array
	; Receives: ESI - Pointer to a DWORD array
	; ECX -Total # of elements in array (must be >= 1) 
	; Returns: EAX -Value of the last element 

	lastElement PROC
		;mov eax, DWORD PTR [esi + ecx*SIZEOF SDWORD - SIZEOF SDWORD]
		;mov eax, DWORD PTR [esi + ecx*SIZEOF SDWORD]
		;mov eax, DWORD PTR [esi + ecx -SIZEOF SDWORD]
		mov eax, DWORD PTR [esi + ecx*SIZEOF SDWORD - 2*SIZEOF SDWORD]
		ret
	lastElement ENDP 

END main