#include <stdlib.h>
#include <stdio.h>

typedef struct no
{
    int conteudo;
    struct no *direita;
    struct no *esquerda;
} No;

typedef struct arvb
{
    No *raiz;
} ArvB;
void inserirDireita(No *no, int valor)
{
    No *novo = (No *)malloc(sizeof(No));
    if (no->direita == NULL)
    {
        novo->conteudo = valor;
        novo->direita = NULL;
        novo->esquerda = NULL;
        no->direita = novo;
    }
    else
    {
        if (valor < no->direita->conteudo)
        {
            inserirEsquerda(no->direita, valor);
        }
        if (valor > no->direita->conteudo)
        {
            inserirDireita(no->direita, valor);
        }
    }
}
void inserirEsquerda(No *no, int valor)
{
    No *novo = (No *)malloc(sizeof(No));
    if (no->esquerda == NULL)
    {
        novo->conteudo = valor;
        novo->direita = NULL;
        novo->esquerda = NULL;
        no->esquerda = novo;
    }
    else
    {
        if (valor < no->esquerda->conteudo)
        {
            inserirEsquerda(no->esquerda, valor);
        }
        if (valor > no->esquerda->conteudo)
        {
            inserirDireita(no->esquerda, valor);
        }
    }
}

void inserir(ArvB *arv)
{
    int valor;
    printf("Digite o numero a ser inserido: ");
    scanf("%d", &valor);
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
        if (valor > arv->raiz->conteudo)
        {
            inserirDireita(arv->raiz, valor);
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

int main()
{
    int op;
    ArvB arvb;
    arvb.raiz = NULL;
    do
    {

        switch (op)
        {
        case 1:
            inserir(&arvb);
            system("cls");
            break;
        case 2:
            printf("Arvore Binaria: ");
            imprimir(arvb.raiz);
            printf("\n");
            break;
        case 0:
            break;
        }

        printf("1 - Inserir");
        printf("\n2 - Imprimir");
        printf("\n0 - Sair\n");
        scanf("%d", &op);
    } while (op != 0);
    return 0;
}