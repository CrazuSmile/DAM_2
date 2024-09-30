#include <unistd.h>
#include <stdio.h>
#include <sys/wait.h>

int main (void){
    pid_t pid;

    pid = fork();

    if (pid == 0)
    {
        if (fork() == 0)
        {
            fork();
        }
        
    }
    printf("Soy %d y mi padre %d\n",getpid(), getppid());

    if (pid > 0)
    {
        wait(NULL);
    }
    return 0;
}