#include <stdlib.h>
#include <stdio.h>

typedef struct no{
    int num;
    struct no *prox;
}  no;

void inserir_na_pilha(no *pilha){
    no *novo,*aux = malloc(sizeof(no));
    scanf("%d",&novo->num);
    novo->prox=NULL;
    
    if(pilha==NULL){
        pilha=novo;
    }
    else{
        aux = pilha;
        while(aux->prox){
            aux=aux->prox;
        }
        aux->prox=novo;
    }    
}

void imprimir(no *pilha){
    no *aux=pilha;
    while(aux->prox!=NULL){
        printf("%d",aux->num);
        aux=aux->prox;
    }
}

void remover(no **pilha){
    no *aux = malloc(sizeof(no));
    aux=*pilha;
    while(aux->prox){
        aux=aux->prox;
    }
    free(aux);
}
int main(){
    no *pilha=NULL;
    inserir_na_pilha(&pilha);
    inserir_na_pilha(&pilha);
    inserir_na_pilha(&pilha);
    inserir_na_pilha(&pilha);
    imprimir(pilha);
    remover(&pilha);
    imprimir(pilha);
}