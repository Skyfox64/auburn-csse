INCLUDE Irvine32.inc

.data
ordered SDWORD -3, -2, -1, 0, 1, 2, 3
reverse SDWORD 3, 1, -1, -5
random  SDWORD 4, 8, 2, 7
single  SDWORD 3

.code
min PROC
; Returns the minimum value in an SDWORD array
; Receives: ESI -- Pointer to array
;           ECX -- Length of array (must be >= 1)
; Returns:  EAX -- Minimum value

      push esi
      push ecx

      cmp ecx, 0
      je done   ; Invalid argument

      mov eax, [esi]          ; Store min value in EAX, initially first value
next: dec ecx                 ; Store # elements that still need to be processed in ECX
      cmp ecx, 0              ; while elements still need to be processed {
      je done

      add esi, SIZEOF SDWORD  ;     Point ESI at the next element
      cmp [esi], eax          ;     If it's NOT less than the current min in EAX
      jnl next                ;         Handle the next element
      mov eax, [esi]          ;     Otherwise, it's the new minimum
      jmp next                ;         Handle the next element

done: pop ecx
      pop esi
      ret
min ENDP

main PROC
      mov esi, OFFSET ordered
      mov ecx, LENGTHOF ordered
      call min
      call WriteInt

      mov esi, OFFSET reverse
      mov ecx, LENGTHOF reverse
      call min
      call WriteInt

      mov esi, OFFSET random
      mov ecx, LENGTHOF random
      call min
      call WriteInt

      mov esi, OFFSET single
      mov ecx, LENGTHOF single
      call min
      call WriteInt

      exit
main ENDP

END main
