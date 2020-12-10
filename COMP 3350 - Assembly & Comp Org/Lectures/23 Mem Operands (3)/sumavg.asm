INCLUDE Irvine32.inc

.data
ordered SDWORD -3, -2, -1, 0, 1, 2, 3
reverse SDWORD 3, 1, -1, -5
random  SDWORD 4, 8, 2, 7
single  SDWORD 3

.code
main PROC
    mov esi, OFFSET random
    mov ecx, LENGTHOF random

    call sumFirstLast
    call WriteInt

    call avgFirstLast
    call WriteInt

    exit
main ENDP

; Sums the first and last elements in a SDWORD array
; Receives: ESI -- Pointer to SDWORD array
;           ECX -- Number of elements in the array (must be >= 1)
; Returns:  EAX -- Sum of first and last elements (SDWORD)
sumFirstLast PROC
    mov eax, DWORD PTR [esi]
    ;add eax, [esi + (ecx-1)*SIZEOF DWORD]    ; Why doesn't this work?
    add eax, DWORD PTR [esi + ecx*SIZEOF DWORD - SIZEOF DWORD]
    ret
sumFirstLast ENDP

; Averages the first and last elements in a SDWORD array
; Receives: ESI -- Pointer to SDWORD array
;           ECX -- Number of elements in the array (must be >= 1)
; Returns:  EAX -- Average of first and last elements (SDWORD)
avgFirstLast PROC
    push ecx
    push edx   ; Why?

    mov eax, DWORD PTR [esi]
    add eax, DWORD PTR [esi + ecx*SIZEOF DWORD - SIZEOF DWORD]

    mov ecx, 2
    cdq
    idiv ecx

    pop edx
    pop ecx
    ret
avgFirstLast ENDP

END main
