#include <stdio.h>
#include <stdlib.h>

int main() {
    int vec[7]={7,5,1,4,8,2,9};
    int j=0;
    int menor=vec[0];
    int aux,indiceMenor;
    while(j<7){
        menor=vec[j];
        for(int i=j;i<7;i++){
            if(vec[i]<=menor){
                menor=vec[i];
                indiceMenor=i;
            }
        }
        aux=vec[j];
        vec[j]=menor;
        vec[indiceMenor]=aux;
        j++;
    }
    for(int i=0;i<7;i++){
        printf("%d ",vec[i]);
    }
    return 0;
}