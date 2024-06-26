#include <stdlib.h>
#include <stdio.h>
/*Aluno: Samuel Salvador dos Santos*/

int main(){
    int idade;
    printf("Digite a idade da pessoa: ");
    scanf("%d",&idade);
    if(idade<30){
        printf("Pessoa nova");
    }else{
        printf("Pessoa velha");
    }
    return 0;
}