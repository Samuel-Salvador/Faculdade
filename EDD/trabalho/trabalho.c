#include <stdlib.h>
#include <stdio.h>
#include <time.h>
#include <stdbool.h>
#include <locale.h>
#include <string.h>

    unsigned long int numComparacao=0;
    unsigned long int numMovimento=0;

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
        troca=false;      
        for(int j=0;j<tamanho-1;j++){
            if(vec[j]>vec[j+1]){
                numComparacao++;
                int aux=vec[j];
                vec[j]=vec[j+1];
                vec[j+1]=aux;
                troca=true;
                numMovimento+=3;
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
		while(indice>0 && vec[indice-1]>copia) {
            numComparacao++;
			vec[indice]=vec[indice-1];
			indice--;
            numMovimento++;
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
        for(int i=j;i<tamanho;i++){
            numComparacao++;
            if(vec[i]<=menor){
                numComparacao++;
                menor=vec[i];
                indiceMenor=i;
                numMovimento++;
            }
            numComparacao++;
        }
        numComparacao++;
        aux=vec[j];
        vec[j]=menor;
        vec[indiceMenor]=aux;
        j++;
        numMovimento+=2;
    }
    numComparacao++;
    return 's';
}

void startVetores(){

    for(int i=0;i<100;i++){
        vec100Aleatorio[i]=i;
    }
    for(int i=0;i<1000;i++){
        vec1000Aleatorio[i]=i;
    }    
    for(int i=0;i<10000;i++){
        vec10000Aleatorio[i]=i;
    }
    for(int i=0;i<100000;i++){
        vec100000Aleatorio[i]=i;
    }
}

void ordenarMaiorMenor(){
    int cres=0;
    for(int i=100-1;i>=0;i--){
        vec100Aleatorio[i]=cres;
        cres++;
    }
    cres=0;
    for(int i=1000-1;i>=0;i--){
        vec1000Aleatorio[i]=cres;
        cres++;
    }    
    cres=0;
    for(int i=10000-1;i>=0;i--){
        vec10000Aleatorio[i]=cres;
        cres++;
    }
    cres=0;
    for(int i=100000-1;i>=0;i--){
        vec100000Aleatorio[i]=cres;
        cres++;
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

void imprimirNaoOrdenado(int tamanho, int vec[tamanho]){
    printf("\nVetor antes da ordenação:  ");
    for (int i=0;i<tamanho;i++){
        printf("%d ",vec[i]);
    }
}

void imprimir(clock_t inicio, clock_t final, char *string,int tamanho,int vec[tamanho]){
    

    double tempo = (double)(final-inicio)/CLOCKS_PER_SEC;

    printf("\n\nVetor Ordenado:  ");
    for(int i=0;i<tamanho;i++) {
        printf("%d ",vec[i]);
    }
    
    printf("\n\nTempo para %s de um vetor Aleatório: %f segundos\n",string,tempo);
    printf("Quantidade de movimentações para %s de um vetor Aleatório: %ld\n",string,numMovimento);
    printf("Quantidade de comparações para %s de um vetor Aleatório: %ld\n",string,numComparacao);
    printf("\n---------------------------------------\n\n");
}


void embaralhar(int *vec,int tamanho) {
    for (int i = tamanho - 1; i > 0; i--) {
        int j = rand() % (i + 1);
        int aux = vec[j];
        vec[j] = vec[i];
        vec[i] = aux;
    }
}

void executar(char sort,int tamanho,int *vec,char tipo){
    char *string = setString(sort);
    clock_t inicio, final;
    if(tipo=='s'){
        printf("\n\t\t %s de %d Posições \n\n",string,tamanho);
        startVetores();   
    }
    if(tipo=='m'){
        ordenarMaiorMenor();   
    }
    if(tipo=='e'){
        embaralhar(vec,tamanho);
    }
    imprimirNaoOrdenado(tamanho,vec);

    if(sort=='i'){
        inicio=clock();
        insertionSort(tamanho,vec);      
        final = clock();
    }
    if(sort=='b'){
        inicio=clock();
        bubbleSort(tamanho,vec);      
        final = clock();
    }
    if(sort=='s'){
        inicio=clock();
        selectionSort(tamanho,vec);      
        final = clock();
    }

    imprimir(inicio, final, string, tamanho, vec);
    resetarNum();

}

int main(){

    setlocale(LC_ALL,"");

     
    //-------------------- INSERTION SORT DE 100 POSIÇÕES ------------------------
    executar('i',100,vec100Aleatorio,'s');
    system("pause");
    
    executar('i',100,vec100Aleatorio,'m');
    system("pause");
    
    executar('i',100,vec100Aleatorio,'e');
    system("pause");
    
    //-------------------- INSERTION SORT DE 1000 POSIÇÕES ------------------------
    executar('i',1000,vec1000Aleatorio,'s');
    system("pause");

    executar('i',1000,vec1000Aleatorio,'m');
    system("pause");
    
    executar('i',1000,vec1000Aleatorio,'e');
    system("pause");

    //-------------------- INSERTION SORT DE 10000 POSIÇÕES ------------------------
    executar('i',10000,vec10000Aleatorio,'s');
    system("pause");

    executar('i',10000,vec10000Aleatorio,'m');
    system("pause");
    
    executar('i',10000,vec10000Aleatorio,'e');
    system("pause");

    //-------------------- INSERTION SORT DE 100000 POSIÇÕES ------------------------
    executar('i',100000,vec100000Aleatorio,'s');
    system("pause");

    executar('i',100000,vec100000Aleatorio,'m');
    system("pause");
    
    executar('i',100000,vec100000Aleatorio,'e');
    system("pause");

    //-------------------- SELECTION SORT DE 100 POSIÇÕES ------------------------
    executar('s',100,vec100Aleatorio,'s');
    system("pause");
    
    executar('s',100,vec100Aleatorio,'m');
    system("pause");
    
    executar('s',100,vec100Aleatorio,'e');
    system("pause");
    
    //-------------------- SELECTION SORT DE 1000 POSIÇÕES ------------------------
    executar('s',1000,vec1000Aleatorio,'s');
    system("pause");

    executar('s',1000,vec1000Aleatorio,'m');
    system("pause");
    
    executar('s',1000,vec1000Aleatorio,'e');
    system("pause");

    //-------------------- SELECTION SORT DE 10000 POSIÇÕES ------------------------
    executar('s',10000,vec10000Aleatorio,'s');
    system("pause");

    executar('s',10000,vec10000Aleatorio,'m');
    system("pause");
    
    executar('s',10000,vec10000Aleatorio,'e');
    system("pause");

    //-------------------- SELECTION SORT DE 100000 POSIÇÕES ------------------------
    executar('s',100000,vec100000Aleatorio,'s');
    system("pause");

    executar('s',100000,vec100000Aleatorio,'m');
    system("pause");
    
    executar('s',100000,vec100000Aleatorio,'e');
    system("pause");

    //-------------------- BUBBLE SORT DE 100 POSIÇÕES ------------------------
    executar('b',100,vec100Aleatorio,'s');
    system("pause");
    
    executar('b',100,vec100Aleatorio,'m');
    system("pause");
    
    executar('b',100,vec100Aleatorio,'e');
    system("pause");
    
    //-------------------- BUBBLE SORT DE 1000 POSIÇÕES ------------------------
    executar('b',1000,vec1000Aleatorio,'s');
    system("pause");

    executar('b',1000,vec1000Aleatorio,'m');
    system("pause");
    
    executar('b',1000,vec1000Aleatorio,'e');
    system("pause");

    //-------------------- BUBBLE SORT DE 10000 POSIÇÕES ------------------------
    executar('b',10000,vec10000Aleatorio,'s');
    system("pause");

    executar('b',10000,vec10000Aleatorio,'m');
    system("pause");
    
    executar('b',10000,vec10000Aleatorio,'e');
    system("pause");

    //-------------------- BUBBLE SORT DE 100000 POSIÇÕES ------------------------
    executar('b',100000,vec100000Aleatorio,'s');
    system("pause");

    executar('b',100000,vec100000Aleatorio,'m');
    system("pause");
    
    executar('b',100000,vec100000Aleatorio,'e');
    system("pause");
    return 0;
}