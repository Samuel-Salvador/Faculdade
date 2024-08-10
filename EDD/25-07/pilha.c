#include <stdio.h>
#include <stdlib.h>

typedef struct data
{
    int dia, mes, ano;
} Data;

typedef struct pessoa
{
    char nome[50];
    Data data;
} Pessoa;

typedef struct No
{
    Pessoa p;
    int num;
    struct No *prox;
} no;

typedef struct pilha
{
    no *topo;
    int tamanho;

} Pilha;

Pessoa ler_pessoa()
{
    Pessoa p;
    printf("\nDigite nome e data de nascimento dd mm aaaa:\n");
    scanf("%49[^\n]%d%d%d", p.nome, &p.data.dia, &p.data.mes, &p.data.ano);
    return p;
}

void imprimir_pessoa(Pessoa p)
{
    printf("\n Nome: %s \nData: %2d/%2d/%4d\n", p.nome, p.data.dia, p.data.mes, p.data.ano);
}

void criar_pilha(Pilha *p)
{
    p->topo = NULL;
    p->tamanho = 0;
}

void empilhar(Pilha *p)
{
    no *novo = malloc(sizeof(no));
    if (novo)
    {
        novo->p = ler_pessoa();
        novo->prox = p->topo;   
        p->topo = novo;
        p->tamanho++;
    }
    else
        printf("\n Erro ao alocar memoria!");
}

no desempilhar(Pilha *p)
{
    no *remover;
    if (p->topo)
    {
        remover = p->topo;
        p->topo = remover->prox;
        p->tamanho--;
        return remover;
    }
    else
        printf("\nPilha esta vazia!");
    return remover;
}

void imprimir_pilha(Pilha *p)
{
    no *aux = p->topo;
    printf("\n------- Size of Pilha: %d -------\n", p->tamanho);
    while (aux!=NULL)
    {
        imprimir_pessoa(aux->p);
        aux = aux->prox;
    }
    printf("------- Fim Pilha -------\n\n");
}

int main()
{
    no *remover;
    Pilha p;
    int opcao;
    criar_pilha(&p);
    do
    {
        printf("1 - Empilhar\n");
        printf("2 - Remover\n");
        printf("3 - Imprimir\n");
        printf("4 - Sair\n");
        scanf("%d", &opcao);
        getchar();
        switch (opcao)
        {
        case 1:
            empilhar(&p);
            break;
        case 2:
            remover = desempilhar(&p);
            if (remover)
            {
                printf("\n Elemento removido com sucesso!\n");
                imprimir_pessoa(remover->p);
                free(remover);
            }
            else
                printf("\n Sem no a remover. \n");
            break;
        case 3:
            imprimir_pilha(&p);
            break;
        case 4:
            break;
        }
    } while (opcao != 5);

    return 0;
}