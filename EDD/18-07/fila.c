#include <stdlib.h>
#include <stdio.h>

typedef struct{
    int num;
    struct no *prox;
    int prioridade;
}no;

typedef struct{
    no *prim;
    no *fim;
    int tamanho;
}fila;

void inserir_no(fila *fila){
    no *novo = malloc(sizeof(no));
    printf("Digite o numero a ser inserido na fila: ");
    scanf("%d",&novo->num);
    novo->prox=NULL;
    printf("Digite a prioridade: (1 - Normal) (2 - Com prioridade)");
    scanf("%d",&novo->prioridade);
    if(fila->prim==NULL){
        fila->prim=novo;
        fila->fim=novo;
        fila->tamanho++;
    }else{
        fila->fim->prox=novo;
        fila->fim=novo; 
        fila->tamanho++;
    }
}

void remover_elemento(fila *fila){
    no *aux_remocao=NULL;
    if(fila->prim){
        aux_remocao=fila->prim;
        fila->prim=fila->prim->prox;
        fila->tamanho--;
        free(aux_remocao);
    }
    else printf("Fila vazia!");
}

void criar_fila(fila *fila){
    fila->prim=NULL;
    fila->fim=NULL;
    fila->tamanho=0;
}

void imprimir(fila *fila){
    no *aux_impressao=fila->prim;
    printf("Fila: ");
    while(aux_impressao){
        printf("%d ",aux_impressao->num);
        aux_impressao=aux_impressao->prox;
    }
    printf("\n");
}

void imprimir_com_prioridade(fila *fila){
    no *aux_impressao=fila->prim;
    printf("Fila: ");
    while(aux_impressao){
        if(aux_impressao->prioridade==2){
             printf("%d ",aux_impressao->num);
        }
        aux_impressao=aux_impressao->prox;
    }
    aux_impressao=fila->prim;
    while(aux_impressao){
        if(aux_impressao->prioridade==1){
             printf("%d ",aux_impressao->num);
        }
        aux_impressao=aux_impressao->prox;
    }
    printf("\n");
}

int main(){
    fila fila;
    criar_fila(&fila);
    int opcao;
    while(opcao!=0){
        printf("MENU\n");
        printf("1 - Inserir na fila\n");
        printf("2 - Remover elemento\n");
        printf("3 - Imprimir sem prioridade\n");
        printf("4 - Imprimir com prioridade\n");
        printf("0 - Sair\n");
        scanf("%d",&opcao);
        switch(opcao){
            case 1: inserir_no(&fila);
                    system("cls");
                    break;
            case 2: remover_elemento(&fila);
                    system("cls");
                    break;
            case 3: imprimir(&fila);
                    system("pause");
                    system("cls");
                    break;
            case 4: imprimir_com_prioridade(&fila);
                    system("pause");
                    system("cls");
                    break;
            case 0: break;
        }
    }
    return 0;
}