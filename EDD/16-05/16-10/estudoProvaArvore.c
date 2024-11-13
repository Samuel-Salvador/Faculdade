#include <stdlib.h>
#include <stdio.h>

typedef struct no{
    int conteudo;
    struct no *direita;
    struct no *esquerda;
}No;

typedef struct Arvb{
    No *raiz;
}ArvB;

void inserir(ArvB *arv){
    No *novo = (No*)malloc(sizeof(No));
    int valor;
    printf("Digite o valor a ser inserido: ");
    scanf("%d",&valor);
    if(arv->raiz==NULL){
        novo->esquerda=NULL;
        novo->direita=NULL;
        novo->conteudo=valor;
        arv->raiz=novo;
    }
    else{
        if(valor<arv->raiz->conteudo){
            inserirEsquerda(arv->raiz,valor);
        }
        else{
            inserirDireita(arv->raiz,valor);
        }
    }
}

void inserirEsquerda(No *no, int valor){
    No *novo = (No*)malloc(sizeof(No));
    if(no->esquerda==NULL){
        novo->direita=NULL;
        novo->esquerda=NULL;
        novo->conteudo=valor;
        no->esquerda=novo;
    }
    else{
        if(valor<no->esquerda->conteudo){
            inserirEsquerda(no->esquerda,valor);
        }
        else{
            inserirDireita(no->esquerda,valor);
        }
    }
}

void inserirDireita(No *no, int valor){
    No *novo = (No*)malloc(sizeof(No));
    if(no->direita==NULL){
        novo->esquerda=NULL;
        novo->direita=NULL;
        novo->conteudo=valor;
        no->direita=novo;
    }
    else{
        if(valor<no->direita->conteudo){
            inserirEsquerda(no->direita,valor);
        }
        else{
            inserirDireita(no->direita,valor);
        }
    }
}
void imprimirEmOrdem(No *raiz){
    if(raiz!=NULL){
        imprimirEmOrdem(raiz->esquerda);
        printf("%d ", raiz->conteudo);
        imprimirEmOrdem(raiz->direita);
    }
}

int main(){
    ArvB arv;
    arv.raiz=NULL;
    int op=1;
    while(op!=0){
        inserir(&arv);
        printf("\ncontinua?");
        scanf("%d",&op);
    }
    imprimirEmOrdem(arv.raiz);
    return 0;
}
