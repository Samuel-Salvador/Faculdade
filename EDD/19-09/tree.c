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

No *remover(No *raiz, int valor){
    if (raiz == NULL)
    {
        printf("Valor nao encontrado.\n");
        return NULL;
    }
    else
    {
        if (raiz->conteudo == valor)
        {
            if (raiz->esquerda == NULL && raiz->direita == NULL){
                free(raiz);
                printf("Elemento %d removido!\n", valor);
                return NULL;
            }
            else{

                if(raiz->esquerda != NULL && raiz->direita == NULL){
                    No *aux;
                    aux=raiz->esquerda;
                    free(raiz);
                    printf("Elemento %d removido!\n", valor);
                    return aux;
                }

                if(raiz->direita != NULL && raiz->esquerda == NULL){
                    No *aux;
                    aux=raiz->direita;
                    free(raiz);
                    printf("Elemento %d removido!\n", valor);
                    return aux;
                }
                if(raiz->direita!=NULL && raiz->esquerda!=NULL){
                    No *aux=raiz->esquerda;
                    while(aux->direita!=NULL){
                        aux = aux->direita;
                    }
                    raiz->conteudo = aux->conteudo;
                    aux->conteudo = valor;
                    raiz->esquerda = remover(raiz->esquerda,valor);
                    return raiz;
                }
            }
        }
        else
        {
            if (valor < raiz->conteudo){
                raiz->esquerda = remover(raiz->esquerda, valor);
            }
            if (valor > raiz->conteudo){
                raiz->direita = remover(raiz->direita, valor);
            }      
        }
        return raiz;
    }
}
int main()
{
    int op;
    ArvB arv;
    arv.raiz = NULL;
    int valor;
    do
    {
        printf("1 - Inserir\n");
        printf("2 - Imprimir Em Ordem\n");
        printf("3 - Imprimir Pre Ordem\n");
        printf("4 - Imprimir Pos Ordem\n");
        printf("5 - Remover\n");
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
            printf("\nQuantidade numeros pares: %d \n", numPares);
            break;
        case 3:
            system("cls");
            printf("Arvore Binaria: ");
            imprimirPreOrdem(arv.raiz);
            printf("\nQuantidade numeros pares: %d \n", numPares);
            break;
        case 4:
            system("cls");
            printf("Arvore Binaria: ");
            imprimirPosOrdem(arv.raiz);
            printf("\nQuantidade numeros pares: %d \n", numPares);
            break;
        case 5:
            system("cls");
            printf("Qual valor deseja remover?\n");
            scanf("%d",&valor);
            arv.raiz=remover(arv.raiz,valor);
            break;  
        }
    } while (op != 0);

    return 0;
}