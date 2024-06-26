#include <stdlib.h>
#include <stdio.h>
#include <math.h>
#include <time.h>

FILE *arq;

void stress_cpu(){                  //função para estressar a CPU
    int tab;
    for (int i=0;i<=100000;i++){     
        tab=pow(8,i);               //calcula 8 elevado a 'i' com 'i' aumentando até 10000
        }
        tab=tab;                    //linha executada somente para utilizar a varíavel e sair o aviso da IDE
}
void stress_mem(){                  //função para estressar a memória
    char *tab_s;                    
    int ip[100000];
    tab_s=(char*)malloc(sizeof(char));
    arq=fopen("testeDeMemoria.txt","w");   //'w' porque irei somente escrever 
    for(int i=0;i<=100000;i++){
        sprintf(tab_s,"%d",i);              //printa 'i' em 'tab_s'
        tab_s=(char*)realloc(tab_s,1+i*sizeof(char));
        }
    fputs(tab_s,arq);                       //coloca tab_s no arquivo
    fclose(arq);
    arq=fopen("testeDeMemoria.txt","r");    //'r' porque irei somente ler
    fread(&ip,sizeof(char),100000,arq);       //lê o arquivo e salva o conteúdo em 'ip'
    fclose(arq);
    free(tab_s);
}

int main(){       
    stress_cpu();
    clock_t clock_cpu=clock();      //salva a quantidade de clocks feitos em 'stress_cpu'
    stress_mem();
    clock_t clock_mem=clock();      //salva a quantidade de clocks feitos em 'stress_mem'
    double tempo_mem=(double)(clock_mem-clock_cpu)/CLOCKS_PER_SEC;  //divide a quantidade de clocks para obter os segundos gastos
    double tempo_cpu=(double)clock_cpu/CLOCKS_PER_SEC;
    printf("A funcao de estresse do CPU foi executada em %lf segundos\n",tempo_cpu);    //mostra na tela os segundos gastos pela função 'stress_cpu' 
    printf("A funcao de estresse da memoria foi executada em %lf segundos",tempo_mem);  //mostra na tela os segundos gastos pela função 'stress_mem'
    return 0;
}