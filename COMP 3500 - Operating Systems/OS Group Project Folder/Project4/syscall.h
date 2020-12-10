#ifndef _SYSCALL_H_
#define _SYSCALL_H_


struct trapframe; /* from <machine/trapframe.h> */

/*
 * The system call dispatcher.
 */

void syscall(struct trapframe *tf);

/*
 * Support functions.
 */

/* Helper for fork(). You write this. */
void enter_forked_process(struct trapframe *tf);

/* Enter user mode. Does not return. */
void enter_new_process(int argc, userptr_t argv, vaddr_t stackptr,
		       vaddr_t entrypoint);


/*
 * Prototypes for IN-KERNEL entry points for system call implementations.
 */
 
int sys_open(userptr_t filename, int flags, int mode, int *retval);
int sys_read(int fd, userptr_t buf, size_t size, int *retval);
int sys_write(int fd, userptr_t buf, size_t size, int *retval);
int sys_close(int fd);
int sys_lseek(int fd, off_t offset, int32_t whence, off_t *retval);
int sys_dup2(int oldfd, int newfd, int *retval);
int sys_chdir(userptr_t path);
int sys___getcwd(userptr_t buf, size_t buflen, int *retval);

int sys_reboot(int code);
int sys___time(userptr_t user_seconds, userptr_t user_nanoseconds);

void sys__exit(int code);
int sys_execv(userptr_t prog, userptr_t args);
int sys_fork(struct trapframe *tf, pid_t *retval);
int sys_waitpid(pid_t pid, userptr_t returncode, int flags, pid_t *retval);
int sys_getpid(pid_t *retval);
void execv_bootstrap(void);
void execv_shutdown(void);
void *sys_sbrk(intptr_t amount);
 
#endif /* _SYSCALL_H_ */