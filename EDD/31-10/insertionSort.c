#include <stdio.h>
#include <stdlib.h>

int main(){
    int vec[25]={45,5,72,19,28,61,37,45,47,89,66,33,55,57,1};
    int copia, indice;
    for(int i=1;i<15;i++){
        indice=i;
		copia=vec[i];
		while(indice>0 && vec[indice-1]>copia) {
				vec[indice]=vec[indice-1];
				indice--;
			}
			vec[indice]=copia;
    }

    for(int i=0;i<15;i++){
        printf("%d ",vec[i]);
    }
    return 0;
}