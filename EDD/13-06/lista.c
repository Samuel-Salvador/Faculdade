#include <stdio.h>
#include <stdlib.h>

typedef struct no{
        int num;
        struct no *prox;
    } no;

no criar_no(){
        no *novo = (no*) malloc(sizeof(no));
        return  *novo;
    }

int main(){
    no nos;
    no *aux;
    aux->num=2;
    while (aux!=NULL){
        aux->num;
        aux=aux->prox;
    }

    
    return 0;
}