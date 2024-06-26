#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

int tamanho,qnt_pedidos;

void reordenarPedidos(int *pedidos){
    int aux,indiceMenorDif=100,menorDif=100;

    for (int j=0;j<qnt_pedidos;j++){
        if(j==qnt_pedidos-1){
            break;
        }
            for (int i=j+1;i<qnt_pedidos;i++){
                if (abs(pedidos[j]-pedidos[i])<menorDif){
                    menorDif=abs(pedidos[j]-pedidos[i]);
                    indiceMenorDif=i;
                }
            }
            aux=pedidos[j+1];
            pedidos[j+1]=pedidos[indiceMenorDif];
            pedidos[indiceMenorDif]=aux;

            menorDif = 100;
            indiceMenorDif = 100;
        }

}

void imprimirCilindro(int *memoria,int *pedidos){
    for (int i=0;i<tamanho;i++){
        memoria[i]=0;
    }
    for (int j=0;j<qnt_pedidos;j++){
            printf("\n=-=-= %dª modificação no cilindro =-=-=\n", j+1);
            for(int i=0;i<tamanho;i++){
                printf("[%.2d]",i);
            }
            printf("\n");
            for (int i=0;i<tamanho;i++){
                memoria[pedidos[j]]=2;                                                        
                if(memoria[i]==0){
                    printf("[--]");
                } else{
                    printf("[XX]");
                }
            }

            printf("\n");
        }
        
}


int main (){
    setlocale(LC_ALL,"");
    int *memoria,*pedidos;

    printf("Digite o tamanho do cilindro: ");
    scanf("%d",&tamanho);
    memoria=malloc(tamanho*sizeof(int));


    printf("Digite a quantidade de pedidos do cilindro: ");
    scanf("%d",&qnt_pedidos);
    pedidos=malloc(qnt_pedidos*sizeof(int));

    for (int i =0;i<qnt_pedidos;i++){
        printf("Informe o %dº pedido de cilindro: ", i+1);
        scanf("%d",&pedidos[i]);
    }

    printf("\n-------- FCFS --------\n");
    imprimirCilindro(memoria,pedidos);
    printf("\n-------- SSF --------\n");
    reordenarPedidos(pedidos);
    imprimirCilindro(memoria,pedidos);
            
    return 0;
}