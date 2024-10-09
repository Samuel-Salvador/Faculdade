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

int numPares = 0;

void inserir(ArvB *arv)
{

    No *novo = (No *)malloc(sizeof(No));
    printf("Digite o valor a ser inserido: ");
    int valor;
    scanf("%d", &valor);
    if (valor % 2 == 0)
    {
        numPares++;
    }
    if (arv->raiz == NULL)
    {
        novo->esquerda = NULL;
        novo->direita = NULL;
        novo->conteudo = valor;
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

void inserirEsquerda(No *no, int valor)
{
    No *novo = (No *)malloc(sizeof(No));
    if (no->esquerda == NULL)
    {
        novo->direita = NULL;
        novo->esquerda = NULL;
        novo->conteudo = valor;
        no->esquerda = novo;
    }
    else
    {
        if (valor < no->esquerda->conteudo)
        {
            inserirEsquerda(no->esquerda, valor);
        }
        else
            inserirDireita(no->esquerda, valor);
    }
}

void inserirDireita(No *no, int valor)
{
    No *novo = (No *)malloc(sizeof(No));
    if (no->direita == NULL)
    {
        novo->direita = NULL;
        novo->esquerda = NULL;
        novo->conteudo = valor;
        no->direita = novo;
    }
    else
    {
        if (valor < no->direita->conteudo)
        {
            inserirEsquerda(no->direita, valor);
        }
        else
            inserirDireita(no->direita, valor);
    }
}

void imprimirEmOrdem(No *raiz)
{
    if (raiz != NULL)
    {
        imprimirEmOrdem(raiz->esquerda);
        printf("%d ", raiz->conteudo);
        imprimirEmOrdem(raiz->direita);
    }
}

void imprimirPreOrdem(No *raiz)
{
    if (raiz != NULL)
    {
        printf("%d ", raiz->conteudo);
        imprimirPreOrdem(raiz->esquerda);
        imprimirPreOrdem(raiz->direita);
    }
}

void imprimirPosOrdem(No *raiz)
{
    if (raiz != NULL)
    {
        imprimirPosOrdem(raiz->esquerda);
        imprimirPosOrdem(raiz->direita);
        printf("%d ", raiz->conteudo);
    }
}
int main()
{
    int op;
    ArvB arv;
    arv.raiz = NULL;

    do
    {
        printf("1 - Inserir\n");
        printf("2 - Imprimir Em Ordem\n");
        printf("3 - Imprimir Pre Ordem\n");
        printf("4 - Imprimir Pos Ordem\n");
        printf("0 - Sair\n");
        scanf("%d", &op);
        switch (op)
        {
        case 0:
            break;
        case 1:
            system("cls");
            inserir(&arv);
            break;
        case 2:
            system("cls");
            printf("Arvore Binaria: ");
            imprimirEmOrdem(arv.raiz);
            printf("\nQuantidade numeros pares: %d \n",numPares);
            break;
        case 3:
            system("cls");
            printf("Arvore Binaria: ");
            imprimirPreOrdem(arv.raiz);
            printf("\nQuantidade numeros pares: %d \n",numPares);
            break;
        case 4:
            system("cls");
            printf("Arvore Binaria: ");
            imprimirPosOrdem(arv.raiz);
            printf("\nQuantidade numeros pares: %d \n",numPares);
            break;
        }
    } while (op != 0);

    return 0;
}