#include <stdio.h>
#include <stdlib.h>

int main(void){
    //valor é a variável que será apontada pelo ponteiro
    int valor=27;

    //declaração de variável ponteiro
    int *ptr;

    //atribuindo o endereço da variável valor ao ponteiro
    ptr=&valor;
    printf("Utilizando ponteiros\n\n");
    printf("Conteudo da variavel valor: %d\n",valor);
    printf("Endereco da variavel valor: %p\n",&valor); //x mostra hexadecimal
    printf("Conteudo da variavel ponteiro ptr: %p\n",ptr); // conteudo da variavel ptr
return 0;
}