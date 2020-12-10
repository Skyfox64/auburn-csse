TITLE Allocate 8 bytes of heap memory, set all 8 bytes to FFh, then deallocate
INCLUDE Irvine32.inc

.code
main PROC
	; Store heap handle in EBX
	call GetProcessHeap
	mov ebx, eax
	cmp eax, 0
	je error

	; Allocate 8 bytes on the heap
	push 8		; Bytes to allocate
	push 0		; Flags (0)
	push ebx	; Heap handle
	call HeapAlloc	; => Pointer returned in EAX
	cmp eax, 0
	je error

	; Set the bytes to FFh
	mov DWORD PTR [eax], 0FFFFFFFFh
	mov DWORD PTR [eax+4], 0FFFFFFFFh

	; Free the heap memory
	push eax	; Pointer to allocation
	push 0		; Flags (0)
	push ebx	; Heap handle
	call HeapFree	; => Result in EAX
	cmp eax, 0
	je error

	jmp done
error:
	push 1		; Exit with error
	call ExitProcess
done:
	push 0		; Exit without error
	call ExitProcess
main ENDP

END main
