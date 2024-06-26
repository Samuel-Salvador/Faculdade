#include <stdlib.h>
#include <stdio.h>

int main(){
    int vet[5];
    int soma=0;
    for (int i=0;i<5;i++){
        printf("Digite o %do valor a ser salvo: ",i+1);
        scanf("%d",&vet[i]);
        soma+=vet[i];
    }
    printf("%d",soma);
    return 0;
}