#include <stdio.h>
#include <stdlib.h>

typedef struct no
{
    int conteudo;
    struct no *esquerda;
    struct no *direita;
} No;

typedef struct arvb
{
    No *raiz;
} ArvB;

void inserir(ArvB *arv, int valor)
{
    if (arv->raiz == NULL)
    {
        No *novo = (No *)malloc(sizeof(No));
        novo->conteudo = valor;
        novo->esquerda = NULL;
        novo->direita = NULL;
        arv->raiz = novo;
    }
    else
    {
        if (valor < arv->raiz->conteudo)
        {
            inserirEsquerda(arv->raiz, valor);
        }
        else
        {
            inserirDireita(arv->raiz, valor);
        }
    }
}

void inserirEsquerda(No *no, int valor)
{
    No *novo = (No *)malloc(sizeof(No));
    if (no->esquerda == NULL)
    {
        novo->conteudo = valor;
        novo->esquerda = NULL;
        novo->direita = NULL;
        no->esquerda = novo;
    }
    else
    {
        if (valor < no->esquerda->conteudo)
        {
            inserirEsquerda(no->esquerda, valor);
        }
        else
        {
            if (valor > no->esquerda->conteudo)
            {
                inserirDireita(no->esquerda, valor);
            }
        }
    }
}

void inserirDireita(No *no, int valor)
{
    No *novo = (No *)malloc(sizeof(No));
    if (no->direita == NULL)
    {
        novo->conteudo = valor;
        novo->esquerda = NULL;
        novo->direita = NULL;
        no->direita = novo;
    }
    else
    {
        if (valor > no->direita->conteudo)
        {
            inserirDireita(no->direita, valor);
        }
        else
        {
            if (valor < no->direita->conteudo)
            {
                inserirEsquerda(no->direita, valor);
            }
        }
    }
}

void imprimir(No *raiz)
{
    if (raiz != NULL)
    {
        imprimir(raiz->esquerda);
        printf("%d ", raiz->conteudo);
        imprimir(raiz->direita);
    }
}

int main(){
    int op,valor;
    ArvB arv;
    arv.raiz=NULL;
    
    do{  
        printf("1 - Inserir\n");
        printf("2 - Imprimir\n");
        printf("0 - Sair\n");
        scanf("%d",&op);
        switch(op){
            case 0: break;
            case 1: system("cls");
                    printf("Digite o valor a ser inserido:");
                    scanf("%d",&valor);
                    inserir(&arv,valor);
                    break;
            case 2: system("cls");
                    printf("Arvore Binaria: ");
                    imprimir(arv.raiz);
                    printf("\n");
                    break;

        }
    }while(op!=0);

    return 0;
}