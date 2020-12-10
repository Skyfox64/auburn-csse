; Demo of the Current Location Counter
INCLUDE Irvine32.inc

.data
mystery1 = $
something DWORD 0
mystery2 = $
moreStuff BYTE 1, 2, 3, 4, 5
mystery3 = $

.code
main PROC
	mov eax, mystery1
	call WriteHex
	call crlf

	mov eax, mystery2
	call WriteHex
	call crlf

	mov eax, mystery3
	call WriteHex
	exit
main ENDP

END main