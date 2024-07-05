#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

int contagemDeNos=0;
float media;
typedef struct No{
        int num;
        struct No *prox;
    } no;

void menu(no *lista){
    int opcao,num;
    while(opcao!=9){
        printf("\t Menu:\n");
    printf("1- Inserir no inicio da lista\n");
    printf("2- Inserir no fim da lista\n");
    printf("3- Inserir de forma ordenada na lista\n");
    printf("4- Buscar elemento na lista\n");
    printf("5- Impressao lista\n");
    printf("6- Libere todos os elementos da lista\n");
    printf("7- Quantidade de nos\n");
    printf("8- Media dos numeros inseridos\n");
    printf("9- Sair\n");   
    scanf("%d",&opcao);
    switch(opcao){

        case 1:     printf("Digite o numero a ser inserido: ");
                    scanf("%d", &num);
                    inserir_no_inicio(&lista,num);
                    system("cls");
                    break;

        case 2:     printf("Digite o numero a ser inserido: ");
                    scanf("%d", &num);
                    inserir_no_fim(&lista,num);
                    system("cls");
                    break;

        case 3:     printf("Digite o numero a ser inserido: ");
                    scanf("%d", &num);
                    inserirOrdenado(&lista,num);
                    system("cls");
                    break;

        case 4:     buscarElemento(lista);
                    printf("\n");
                    system("pause");
                    system("cls");
                    break;

        case 5:     imprimirLista(lista);
                    printf("\n");
                    system("pause");
                    system("cls");
                    break;

        case 6:     excluirTodosElementosLista(lista);
                    lista=NULL;
                    printf("Elementos da lista excluidos!\n");
                    system("pause");
                    system("cls");
                    break;

        case 7:     quantidadeDeNos();
                    system("pause");
                    system("cls");
                    break;

        case 8:     mediaNum(lista);
                    system("pause");
                    system("cls");
                    break;

        case 9:     break;
    }
    }
    
}

void inserir_no_inicio(no **lista,int num){
    no *novo = malloc(sizeof(no));
    novo->num=num;
    novo->prox=*lista;
    *lista=novo;
    contagemDeNos++;
}

void inserir_no_fim(no **lista,int num){
    no *aux, *novo = malloc(sizeof(no));
    novo->num=num;
    novo->prox=NULL;

    if (*lista==NULL){
        *lista = novo;
        
    }
    else{
        aux=*lista;
        while (aux->prox){
            aux = aux->prox;
        }
        aux->prox=novo;
    }
   
    contagemDeNos++;
}

void inserirOrdenado(no **lista,int num){
    no *novo = malloc(sizeof(no));
    no *aux = *lista;
    novo->num=num;

    if (*lista==NULL){
        novo->prox=NULL;
        *lista=novo;
    }
    else if(novo->num <(*lista)->num){
        novo->prox=*lista;
        *lista=novo;
    }
    else {
        while(aux->prox&& novo->num > aux->prox->num){
            aux = aux->prox;        
        }
        novo->prox = aux->prox;
        aux->prox=novo;
    }
}

void imprimirLista(no *lista){
    no *aux=lista;

    printf("Lista: ");

    while (aux!=NULL){
        printf("%d ",aux->num);
        aux=aux->prox;
    }
}

void buscarElemento(no *lista){
    
    no *aux=lista;
    int elemento=0;
    int contagemdeNosParaBuscarElemento=0;
    bool encontrouElemento=false;

    printf("Elemento que deseja buscar: ");    
    scanf("%d",&elemento);

    while (aux!=NULL){
        contagemdeNosParaBuscarElemento++;
        if((aux->num)==elemento){
            encontrouElemento=true;
        }
        if(encontrouElemento){
            printf("Elemento encontrado: %do no",contagemdeNosParaBuscarElemento);
            break;
        }
        aux=aux->prox; 
    }
    if(!encontrouElemento){
            printf("Elemento nao encontrado");}
        
}
void excluirTodosElementosLista(no *lista){
    no *aux=lista;
    no *prox_aux;

    while(aux!=NULL){
        prox_aux=aux->prox;
        free(aux);
        aux=prox_aux;
    }
}
void quantidadeDeNos(){
    printf("Quantidade de nos inseridos na lista: %d \n",contagemDeNos);
}

void mediaNum(no *lista){
    no *aux=lista;
    int soma=0;

    while (aux!=NULL){
        soma+=aux->num;
        aux=aux->prox;
    }
    media = (float)soma/contagemDeNos;
    printf("Media: %.2f\n",media);
}

int main(){
    no *lista=NULL;
    system("cls");

    menu(lista); 

    return 0;
}