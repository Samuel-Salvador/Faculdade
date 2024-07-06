#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

/*  Bom dia(Boa tarde ou Boa noite) professor! 
    Fiz o exercício usando duas listas,
    uma para o tamanho de bloco de memória
    e outra para o tamanho do processo,
    fiz assim pois queria treinar listas.*/

int contagemDeNosBlocoMemoria=0;
int contagemDeNosProcessos=0;

typedef struct No{
        int num;
        struct No *prox;
    } no;

void menu(no *lista,no *lista2){
    int opcao,num;
    bool sair;
    while(!sair){
        printf("\t Menu:\n");
    printf("1- Inserir bloco de memoria\n");
    printf("2- Inserir processo\n");
    printf("3- Imprimir tabela de alocacao de memoria\n");
    printf("4- Impressao das duas listas\n");
    printf("5- Sair\n");   
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

        
        case 3:     sair=true;
                    printarTabela(lista,lista2);
                    printf("\n");
                    system("pause");
                    system("cls");
                    printf("Program terminated!");
                    break;

        case 4:     imprimirLista(lista,lista2);
                    printf("\n");
                    system("pause");
                    system("cls");
                    break;

        case 5:     sair=true;
                    system("cls");
                    printf("Program terminated!");
                    break;
    }
    }
    
}

void inserir_blocoMemoria(no **lista,int num){
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
   
    contagemDeNosBlocoMemoria++;

}

void inserir_processo(no **lista2,int num){
    no *aux, *novo = malloc(sizeof(no));
    novo->num=num;
    novo->prox=NULL;

    if (*lista2==NULL){
        *lista2 = novo;
        
    }
    else{
        aux=*lista2;
        while (aux->prox){
            aux = aux->prox;
        }
        aux->prox=novo;
    }
   
    contagemDeNosProcessos++;
}


void imprimirLista(no *lista, no *lista2){
    no *aux=malloc(sizeof(no));
    aux=lista;

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

    no *aux=malloc(sizeof(no));
    no *aux2=malloc(sizeof(no));
    int atualaux=0 , atualaux2=0 , contagemdeNosParaBuscarBlocoDeMemoria=1,processoAtual=1;
    aux=lista;   
    aux2=lista2;

    system("cls");
    printf("Process No. \t Process Size \t Block no.\n");

    while (aux2!=NULL){  
        while(aux->num==0 && contagemdeNosParaBuscarBlocoDeMemoria<contagemDeNosBlocoMemoria){
            if(aux->prox!=NULL){
                aux=aux->prox;
            }           
            contagemdeNosParaBuscarBlocoDeMemoria++;
        }
        atualaux=aux->num;
        atualaux2=aux2->num;      
        if(aux->num > aux2->num){            
            printf("%d \t\t %d \t\t %d\n",processoAtual,aux2->num,contagemdeNosParaBuscarBlocoDeMemoria);
            contagemdeNosParaBuscarBlocoDeMemoria=0;
            aux2=aux2->prox;
            processoAtual++;

            /*Na linha abaixo escolhi por mudar para '0' o bloco de memoria,
            pois quando eu removia o bloco de memoria da lista,
            o 'Block No.' mostrado na tabela vinha errado. Desta forma eu forço ele a percorrer
            um valor que ele não irá utilizar, nesse caso o 0, e assim aumentar o 'Block No.' em '1'*/
            
            aux->num=0;
            aux=lista;
        }
        else if(contagemdeNosParaBuscarBlocoDeMemoria>=contagemDeNosBlocoMemoria){
            printf("%d \t\t %d \t\t Memory Not Allocated\n",processoAtual,aux2->num);
            processoAtual++;
            aux2=aux2->prox;
        }
        contagemdeNosParaBuscarBlocoDeMemoria++;
        if(!(atualaux > atualaux2))
            aux=aux->prox;        
        }   
}


int main(){
    
    no *lista=NULL;
    no *lista2=NULL;
    
    system("cls");

    menu(lista,lista2); 

    return 0;
}