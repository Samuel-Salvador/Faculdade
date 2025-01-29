package main;
import entities.Grafo;


public class App {

	public static void main(String[] args){
		
		//se quiser grafos de outros tipos, só mudar o Generics para o tipo desejado
		Grafo<Integer> grafoInteger = new Grafo<>();
		Grafo<String> grafoString = new Grafo<>();
		
		//exemplos de criação de vértice
		grafoInteger.adicionarVertice(0);
		grafoInteger.adicionarVertice(1);
		grafoInteger.adicionarVertice(2);
		grafoString.adicionarVertice("Samuel");
		grafoString.adicionarVertice("Professor");
		
		
		//exemplos de criação de aresta 
		grafoInteger.adicionarAresta(2.0, 0, 1);
		grafoInteger.adicionarAresta(6.0, 0, 2);
		grafoString.adicionarAresta(1.0, "Professor", "Samuel");
		
		//exemplo método dijkstra
		grafoInteger.dijkstra(0);
		System.out.println("------------");
		
		//exemplo método Largura
		grafoInteger.buscaEmLargura(0);
		System.out.println("------------");
		
		//exemplo método Profundidade
		grafoInteger.buscaEmProfundidade(0);
		
		
		
	}
}
