#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

int main() {
    int vec[7]={7,5,1,4,8,2,9};
    bool troca=false;
    do{
        troca=false;
        for(int j=0;j<6;j++){
            if(vec[j]>vec[j+1]){
                int aux=vec[j];
                vec[j]=vec[j+1];
                vec[j+1]=aux;
                troca=true;
            }
        }       
    }while(troca);

    for(int i=0;i<7;i++){
        printf("%d ",vec[i]);
    }
    return 0;
}