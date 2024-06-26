#include <stdlib.h>
#include <stdio.h>

int main (){
    int *v;
    int n;
    
    printf("Digite a quantidade de vetores: \n");
    scanf("%d",&n);
    v=malloc(n*sizeof(int)); //aloca memoria para o vetor
    ///printf("%d",sizeof(*v));
    printf("---------------------------------\n");

    printf("Insercao de vetores \n");

    for(int i=0;i<n;++i){
        scanf("%d",&v[i]);
    }
    printf("---------------------------------\n");
    printf("Impressao dos vetores\n");
    for(int i=0;i<n;++i){
        printf("%d\n",v[i]);
    }
    free(v); //libera memória alocada


    return 0;
}