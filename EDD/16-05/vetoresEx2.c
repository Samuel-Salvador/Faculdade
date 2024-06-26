#include <stdlib.h>
#include <stdio.h>

int main(){
    int vet[5];
    int soma=0;
    float media;
    for (int i=0;i<5;i++){
        printf("Digite o %do valor a ser salvo: ",i+1);
        scanf("%d",&vet[i]);
        soma+=vet[i];
    }
    media=soma/5;
    printf("%d\n",soma);
    printf("%.2f\n",media);
    printf("Valores menores que a media:\n");
    for(int i=0;i<5;i++){
        if(vet[i]<media)
        printf("%d ",vet[i]); 
    }              
    printf("\n");
    printf("Valores maiores que a media:\n");
    for(int i=0;i<5;i++){
        if(vet[i]>media){
            printf("%d ",vet[i]);
        }
    }
    return 0;
}