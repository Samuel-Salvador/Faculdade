#include <stdlib.h>
#include <stdio.h>

int main (){
    int a,b;                        //cria duas variáveis inteiras (a,b)

    a=10;b=20;                      //variável 'a' recebe 10 e variável 'b' recebe 20
    
    int *p,*q;                      //cria dois ponteiros do tipo inteiro

    p=&a;                           //ponteiro 'p' recebe endereço de varíavel 'a'
    q=&b;                           //ponteiro 'q' recebe endereço de varíavel 'b'

    *p=30;                          //muda o valor da variável 'a' para 30
    *q=40;                          //muda o valor da variável 'b' para 40
    
    printf("%p %d\n",&a,a);         //mostra na tela o endereço de 'a' e o valor de 'a'
    printf("%p %d\n",&b,b);         //mostra na tela o endereço de 'b' e o valor de 'b'
    printf("%p %p %d\n",&p,p,*p);   //mostra na tela o endereço de 'p',o endereço de 'a' e o valor de 'p'
    printf("%p %p %d\n",&q,q,*q);   //mostra na tela o endereço de 'q',o endereço de 'b' e o valor de 'q'
}