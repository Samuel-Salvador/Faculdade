#include <stdlib.h>
#include <stdio.h>
//Aluno Samuel Salvador dos Santos
int main(){
    int num;
    printf("Digite um numero: ");
    scanf("%d",&num);
    if(num<10){
        printf("Numero menor que 10");
    }
    else if(num>10){
        printf("Numero maior que 10");
    }else{
        printf("Numero igual a 10");
    }
    return 0;
}