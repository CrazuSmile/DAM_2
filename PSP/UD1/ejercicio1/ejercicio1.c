#include <unistd.h>
#include <stdio.h>
#include <sys/wait.h>

int main(void)
{
    pid_t pid_padre;
  

    pid_padre = fork() && fork() && fork();

    printf("Soy %d y mi PID padre es %d\n", getpid(), getppid());

    return 0;
}