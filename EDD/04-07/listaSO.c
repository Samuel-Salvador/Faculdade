#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

int contagemDeNos=0;
float media;
typedef struct No{
        int num;
        struct No *prox;
    } no;

void menu(no *lista,no *lista2){
    int opcao,num;
    while(opcao!=6){
        printf("\t Menu:\n");
    printf("1- Inserir bloco de memoria\n");
    printf("2- Inserir processo\n");
   // printf("3- Inserir de forma ordenada na lista\n");
    printf("3- Imprimir tabela\n");
    printf("4- Impressao lista\n");
    printf("5- Libere todos os elementos da lista\n");
   // printf("7- Quantidade de nos\n");
   // printf("8- Media dos numeros inseridos\n");
    printf("6- Sair\n");   
    scanf("%d",&opcao);
    switch(opcao){

        case 1:     printf("Digite o tamanho do bloco de memoria: ");
                    scanf("%d", &num);
                    inserir_blocoMemoria(&lista,num);
                    system("cls");
                    break;

        case 2:     printf("Digite o tamanho de um processo: ");
                    scanf("%d", &num);
                    inserir_processo(&lista2,num);
                    system("cls");
                    break;

        
        case 3:     printarTabela(lista,lista2);
                    printf("\n");
                    system("pause");
                    system("cls");
                    break;

        case 4:     imprimirLista(lista,lista2);
                    printf("\n");
                    system("pause");
                    system("cls");
                    break;

        case 5:     excluirTodosElementosLista(lista);
                    lista=NULL;
                    printf("Elementos da lista excluidos!\n");
                    system("pause");
                    system("cls");
                    break;

        case 6:     break;
    }
    }
    
}

void inserir_blocoMemoria(no **lista,int num){
    no *novo = malloc(sizeof(no));
    novo->num=num;
    novo->prox=*lista;
    *lista=novo;
    contagemDeNos++;
}

void inserir_processo(no **lista2,int num){
    no *novo = malloc(sizeof(no));
    novo->num=num;
    novo->prox=*lista2;
    *lista2=novo;
    contagemDeNos++;
}


void imprimirLista(no *lista, no *lista2){
    no *aux=lista;

    printf("Lista 1: ");

    while (aux!=NULL){
        printf("%d ",aux->num);
        aux=aux->prox;
    }
    printf("\nLista 2: ");

    aux=lista2;
    while (aux!=NULL){
        printf("%d ",aux->num);
        aux=aux->prox;
    }
}

void printarTabela(no *lista, no *lista2){
    no *prox_aux;
    no *aux=lista;
    no *aux2=lista2;
    int contagemdeNosParaBuscarElemento=1;
    system("cls");
    printf("Process No. \t Process Size \t Block no.\n");
    int i=1;
    while (aux2!=NULL){       
       
        if(aux->num > aux2->num){
            printf("%d \t\t %d \t\t %d\n",i,aux2->num,contagemdeNosParaBuscarElemento);
            prox_aux = aux->prox;
            lista=aux->prox;
            free(aux);
            
            aux2=aux2->prox;
        }
        contagemdeNosParaBuscarElemento++;
        aux=aux->prox;
        i++; 
    }   
}
void excluirTodosElementosLista(no *lista){
    no *aux=lista;
    

    while(aux!=NULL){
        
    }
}


int main(){
    
    no *lista=NULL;
    no *lista2=NULL;
    
    system("cls");

    menu(lista,lista2); 

    return 0;
}