#include <stdlib.h>
#include <stdio.h>
#include <stdbool.h>

int tam_p,ei,qnt_e,qnt_ef,*ef,qnt_s,**tab;
char *sim,*palavra;
// Função que coleta todos os dados necessários para a criação do autômato
void coletarDados(){
    printf("\t======= Dados para criacao do Automato =======\n\n");
    printf("Digite a quantidade de estados: ");
    scanf("%d",&qnt_e);
    while(qnt_e<=0){    //tratamento de erro 
        printf("Quantidade invalida!\n");
        printf("Digite a quantidade de estados (>0):");
        scanf("%d",&qnt_e);
    }
    printf("Digite o estado inicial: ");
    scanf("%d",&ei);
    while(ei<=0 && ei>qnt_e){   //tratamento de erro
        printf("Estado invalido\n");
        printf("Digite o estado inicial (>0 e <Quantidade de estados): ");
        scanf("%d",&ei);
    }
    printf("Digite a quantidade de estados finais: ");
    scanf("%d",&qnt_ef);
    while(qnt_ef>qnt_e){    //tratamento de erro
        printf("Quantidade de estados finais invalida.\n");
        printf("Digite um numero de estados finais menor que a quantidade de estados total: ");
        scanf("%d",&qnt_ef);
    }
    ef=malloc(qnt_ef*sizeof(int));
    for (int i=0;i<qnt_ef;i++){
        printf("Digite o %do estado final: ",i+1);
        scanf("%d",&ef[i]);        
        while(ef[i]<=0 && ef[i]>qnt_e){     //tratamento de erro
            printf("Estado invalido!\n");
            printf("Digite o %do estado final (>0 e <Quantidade de estados): ",i+1);
            scanf("%d",&ef[i]);
        }
    }
    printf("Digite a quantidade de simbolos no alfabeto: ");
    scanf("%d",&qnt_s);
    while(qnt_s<0){         //tratamento de erro
        printf("Quantidade invalida!\n");
        printf("Digite a quantidade de simbolos no alfabeto (<0): ");
        scanf("%d",&qnt_s);
    }
    sim=malloc(qnt_s*sizeof(char));
    for (int i=0;i<qnt_s;i++){
        printf("Digite o %do simbolo: ",i+1);
        scanf("%s",&sim[i]);
    }
    printf("\n---------------------------------------------\n");
}
//Função para preencher a tabela de transição
void preencherTabela(){
    tab = malloc (qnt_e * sizeof (int));
    if(qnt_s!=0){
        for (int i = 0; i < qnt_e; i++){
            tab[i] = malloc (qnt_s * sizeof (int));
        }
        printf("\n======= TABELA DE TRANSICAO =======\n");
        for(int i=0;i<=qnt_s;i++){                  //mostra a tabela sem preenchimento
            printf("\t %c", sim[i]);
        }
        for (int i=0;i<qnt_e;i++){
            printf("\nq%d",i+1);
            for(int j=0;j<qnt_s;j++){
                printf("\t %d,%d",i+1,j+1);
            }
        }
        printf("\n\nPreenchendo as transicoes: \n");
        printf("Utilize '-1' para 'sem transicao'\n\n");
        for (int i=0;i<qnt_e;i++){                  
            for(int j=0;j<qnt_s;j++){
                printf("Preencha a transicao (%d,%d): ",i+1,j+1);
                scanf("%d",&tab[i][j]);                 //prenche a tabela
            }
        }
        printf("\n---------------------------------------------\n");
    }
}
//mostra a tabela preenchida
void mostrarTabela(){
    if(qnt_s!=0){
        printf("\n======= TABELA DE TRANSICAO =======\n");
        for(int i=0;i<=qnt_s;i++){
            printf("\t %c", sim[i]);
        }
        for (int i=0;i<qnt_e;i++){
            printf("\nq%d",i+1);
            for(int j=0;j<qnt_s;j++){
                printf("\t %d",tab[i][j]);                    
            }
        }
        printf("\n\n---------------------------------------------\n");
    }
}
//recolhe o tamanho máximo de todas as palavras que serão inseridas pelo usuário
void tamanhoMaximo(){
    printf("Qual o tamanho maximo das palavras que serao digitadas? \n");
    scanf("%d",&tam_p);
    palavra=malloc(tam_p*sizeof(char));
}
//recolhe a palavra que será testada posteriormente
void coletarPalavra(){
    printf("Digite a palavra a ser testada ('-2' para palavra vazia): ");
    scanf("%s",palavra);
}
//função para testar a palavra
void testarPalavra(){
    int k=0,j=0,i=0;                        //variáveis de incremento para estrutura 'for'
    bool e_err=true,pis=false;              //pis=palavra igual simbolo     e_err=estado errado
    for(int l=0;l<=qnt_ef;l++){             
        if(palavra[0]=='-' && palavra[1]=='2' && ei==ef[l]){        //tratamento para palavra vazia
            e_err=false;
            printf("Palavra aceita!\n");
            break;
        }
    }
    if(palavra[0]!='-' && palavra[1]!='2'){
        for (i=(ei-1);i<qnt_e;i++){    
            if(((palavra[k]=='\0')&&(pis==false))){           //tratamento de erro (não repetir o for mais vezes)
                break;
            }
            for(j=0;j<qnt_s;j++){
                pis=false;
                if(palavra[k]==sim[j]){
                    pis=true;
                    if(tab[i][j]==(i+1)){               //tratamento de transição para o mesmo estado
                        k++;
                        j=-1;
                    }
                    else{
                        if((tab[i][j]>0)&&(tab[i][j]<=qnt_e)){      //tratamento de transição para estado diferente
                            i=-2+tab[i][j];
                            j=0;
                            k++;
                            break;
                        }
                        if(tab[i][j]==-1){
                            printf("Palavra nao aceita\n");
                            i=100;
                            j=100;
                        }
                    }                   
                }                   
            }  
            if((pis==false)&&(palavra[k]!='\0')){               //tratamento para símbolos que não fazem parte do alfabeto
                printf("Palavra nao aceita!\n");
                break;
            }
        }        
    }
    if((palavra[k])=='\0' || (palavra[0]=='-' && palavra[1]=='2')){     //tratamento para palavra vazia quando há mais de um estado final
        for(int l=0;l<qnt_ef;l++){                                      //tratamento para verificar se a palavra terminou em um estado final
            if(i==ef[l]){
                e_err=false;
                printf("Palavra aceita!\n");
                break;
            }
        }
        if(e_err==true){                                                
            printf("Palavra nao aceita!\n");
        }                    
    }  
}

int main (){
    printf("-=-=-=-=-=- Simulador de Automato Finito Deterministico -=-=-=-=-=-\n");
    coletarDados(); 
    preencherTabela();
    mostrarTabela();
    tamanhoMaximo();
    do{
        coletarPalavra();
        testarPalavra();
    }while (palavra[0]!='*');
    free(tab);
    free(ef);
    free(sim);
    free(palavra);
    return 0;
}