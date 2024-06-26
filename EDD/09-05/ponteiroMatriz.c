#include <stdio.h>
#include <stdlib.h>

int main (){
    int x,*ptrx,**pptrx;      //cria variável x, ponteiro ptrx e ponteiro de ponteiro pptrx
    x=0;    //atribui valor 0 para variavel x
    printf("\nvalor de x=%d\n",x);      //mostra na tela o valor de x
    printf("Endereco de x: %p\n\n",&x); //mostra na tela o endereço de x

    ptrx=&x;        //atribui ao ponteiro ptrx o endereço de x
    pptrx=&ptrx;    //ponteiro pptrx recebe o endereço do ponteiro prtx
    
    *ptrx=*ptrx+10; //valor de ptrx que é = 'x', recebe ele mesmo mais  10
    printf("\nvalor de x = %d",x);  //mostra na tela o valor de x
    printf("\nEndereco apontado por ptrx: %p\n",ptrx);      //mostra na tela o endereço de ptrx
    printf("Valor da variavel X que esta sendo apontada por ptrx: %d\n",*ptrx);     //mostra na tela o valor de ptrx que é o valor de 'x'
    printf("Endereco de memoria da variavel ptrx %p\n",&ptrx); //mostra na tela o endereço de memoria da variavel ptrx

    **pptrx = **pptrx+10;   //soma 10 no valor apontado por pptrx, que é o valor apontado por ptrx, que é x
    printf("\n\nvalor de x = %d",x);    //mostra o valor de x
    printf("\nEndereco apontado por **pptrx: %p",pptrx);    //mostra o endereço de ptrx
    printf("\nValor da variavel para a qual pptrx faz referencia: %d",**pptrx); //mostra o valor de x
    printf("\nEndereco de memoria da variavel **pptrx %p\n\n",&pptrx);      //mostra o endereço de pptrx
    return 0;
}