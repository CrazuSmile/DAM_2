#include <unistd.h>
#include <stdio.h>
#include <sys/wait.h>

int main()
{

    pid_t pid_padre;

    printf("Soy %d y mi PID padre es %d\n", getpid(), getppid());

    for (size_t i = 0; i < 2; i++)
    {
        pid_padre = fork();
    }

    printf("Soy %d y mi PID padre es %d\n", getpid(), getppid());

    return 0;
}