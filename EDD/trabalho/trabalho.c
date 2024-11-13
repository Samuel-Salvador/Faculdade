#include <stdlib.h>
#include <stdio.h>
#include <time.h>
#include <stdbool.h>
#include <locale.h>
#include <string.h>

    int numComparacao=0;
    int numMovimento=0;

    int vec100Aleatorio[100];
    int vec1000Aleatorio[1000];
    int vec10000Aleatorio[10000];
    int vec100000Aleatorio[100000];    

void resetarNum(){
    numComparacao=0;
    numMovimento=0;
}
char bubbleSort(int tamanho, int vec[tamanho]){
    bool troca=false;
    do{
        if (troca){
            numMovimento++;
        }
        troca=false;      
        for(int j=0;j<tamanho-1;j++){
            if(vec[j]>vec[j+1]){
                numComparacao++;
                int aux=vec[j];
                vec[j]=vec[j+1];
                vec[j+1]=aux;
                troca=true;
                numMovimento+=4;
            }
            numComparacao++;
        }
        numComparacao++;       
    }while(troca);
    return 'b';
}

char insertionSort(int tamanho, int vec[tamanho]){
    int copia, indice;
    for(int i=1;i<tamanho;i++){
        numComparacao++;
        indice=i;
		copia=vec[i];
        numMovimento+=2;
		while(indice>0 && vec[indice-1]>copia) {
                numComparacao++;
				vec[indice]=vec[indice-1];
				indice--;
                numMovimento+=2;
			}
            numComparacao++;
			vec[indice]=copia;
            numMovimento++;
    }
    numComparacao++;
    return 'i';
}

char selectionSort(int tamanho, int vec[tamanho]){
    int j=0;
    int menor=vec[0];
    int aux,indiceMenor;
    while(j<tamanho){
        numComparacao++;
        menor=vec[j];
        numMovimento++;
        for(int i=j;i<tamanho;i++){
            numComparacao++;
            if(vec[i]<=menor){
                numComparacao++;
                menor=vec[i];
                indiceMenor=i;
                numMovimento+=2;
            }
            numComparacao++;
        }
        numComparacao++;
        aux=vec[j];
        vec[j]=menor;
        vec[indiceMenor]=aux;
        j++;
        numMovimento+=4;
    }
    numComparacao++;
    return 's';
}

void iniciarVetores(){
    
    for(int i=0;i<100;i++){
        bool podeContinuar=false;
        int random=rand()%100;
        while(!podeContinuar){
            for(int j=0;j<i;j++){
                if(random==vec100Aleatorio[j]){
                    podeContinuar=true;
                }
            }
        }
        vec100Aleatorio[i]=random;
    }
    for(int i=0;i<1000;i++){
        vec1000Aleatorio[i]=rand()%1000;
    }    
    for(int i=0;i<10000;i++){
        vec10000Aleatorio[i]=rand()%10000;
    }
    for(int i=0;i<100000;i++){
        vec100000Aleatorio[i]=rand()%100000;
    }
}

char *setString(char sort){
    char *string=malloc(25*sizeof(char));
    if(sort=='b'){
        char stringi[]="BubbleSort";
        strcpy(string,stringi);
    }
    if(sort=='i'){
        char stringi[]="InsertionSort";
        strcpy(string,stringi);
    }
    if(sort=='s'){
        char stringi[]="SelectionSort";
        strcpy(string,stringi);
    }
    return string;
}

void imprimir(clock_t inicio, clock_t final, char sort, int tamanho){
    double tempo = (double)(final-inicio)/CLOCKS_PER_SEC;
    char *string = setString(sort);
    for(int i=0;i<tamanho;i++) {
        printf("%d ",vec100Aleatorio[i]);
    }
    
    printf("\n---------------------------------------\n\n");
    printf("Tempo para %s de um vetor Aleatório: %f segundos\n",string,tempo);
    printf("Quantidade de movimentações para %s de um vetor Aleatório: %d\n",string,numMovimento);
    printf("Quantidade de comparações para %s de um vetor Aleatório: %d\n",string,numComparacao);
    printf("---------------------------------------\n\n");
}

int main(){
    setlocale(LC_ALL,"");
    iniciarVetores();

    clock_t inicio = clock();
    char sort = insertionSort(100,vec100Aleatorio);      
    clock_t final = clock();

    imprimir(inicio,final,sort,100);
    
    return 0;
}