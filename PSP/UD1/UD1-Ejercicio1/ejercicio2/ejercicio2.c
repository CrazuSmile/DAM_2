#include <unistd.h>
#include <stdio.h>
#include <sys/wait.h>

int main()
{

    pid_t pid_hijo1, pid_hijo2;

    printf("Soy %d\n", getpid());

    pid_hijo1 = fork();

    if (pid_hijo1 == 0)
    {
        printf("Soy el hijo 1 con el PID %d y mi padre tiene el PID %d\n", getpid(), getppid());

        pid_t pid_nieto1 = fork();

        if (pid_nieto1 == 0)
        {
            printf("Soy el nieto 1 con el PID %d y mi padre tiene el PID %d\n", getpid(), getppid());
            return 0;
        }

        wait(NULL);
        return 0;
    }

    pid_hijo2 = fork();

    if (pid_hijo2 == 0)
    {
        printf("Soy el hijo 2 con el PID %d y mi padre tiene el PID %d\n", getpid(), getppid());

        pid_t pid_nieto2 = fork();

        if (pid_nieto2 == 0)
        {
            printf("Soy el nieto 2 con el PID %d y mi padre tiene el PID %d\n", getpid(), getppid());
            return 0;
        }

        wait(NULL);
        return 0;
    }


    wait(NULL);
    wait(NULL);

    return 0;
}