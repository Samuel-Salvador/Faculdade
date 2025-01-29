package entities;

import java.util.ArrayList;

public class Grafo<TIPO> {

	private ArrayList<Vertice<TIPO>> listaVertices;
	private ArrayList<Aresta<TIPO>> listaArestas;
	
	
	//atributos para busca
	private ArrayList<Vertice<TIPO>> visitados;
	private ArrayList<Vertice<TIPO>> pilha;
	private ArrayList<Vertice<TIPO>> fila;
	private TIPO dadoOrigem;
	private boolean jaEntrou = false;
	private boolean primeiraExecucao = true;
	
	public Grafo() {
		this.listaVertices = new ArrayList<Vertice<TIPO>>();
		this.listaArestas = new ArrayList<Aresta<TIPO>>();
		this.visitados = new ArrayList<>();
		this.pilha = new ArrayList<>();
	}
	
	/* NOTA-SE QUE NÃO PODE ADICIONAR VÉRTICES COM VALORES IGUAIS! 
	 * vide método getVertice();*/
	public void adicionarVertice(TIPO valor) {
		Vertice<TIPO> novoVertice = new Vertice<TIPO>(valor);
		this.listaVertices.add(novoVertice);
	}
	
	// Caso o grafo não for ponderado utilizar Peso "1.0" para todas as arestas.
	// Nota-se que o dijkstra não funcionará direito se ele não for ponderado.
	// SE FOR UM GRAFO COM CICLO, A BUSCA EM PROFUNDIDADE NÃO FUNCIONARÁ (ficará em loop infinito)!
	public void adicionarAresta(Double peso, TIPO dadoInicio, TIPO dadoFim) {
		Vertice<TIPO> inicio = this.getVertice(dadoInicio);
		Vertice<TIPO> fim = this.getVertice(dadoFim);
		Aresta<TIPO> arestaIndo = new Aresta<TIPO>(peso, inicio, fim);
		Aresta<TIPO> arestaVoltando = new Aresta<TIPO>(peso, fim, inicio);
		
		// Caso fosse direcionado usaria somente esses dois métodos:
		inicio.adicionarArestaSaida(arestaIndo);
		fim.adicionarArestaEntrada(arestaIndo);
		
		/* Os próximos dois métodos são necessários para grafos não direcionados.
		 * Estes dois métodos farão com que a primeira aresta de todos os vértices
		 * (menos da raiz original) seja em direção ao vértice pai.
		 * Isso causará um problema durante as buscas que deve ser levado em conta.*/
		inicio.adicionarArestaEntrada(arestaVoltando);
		fim.adicionarArestaSaida(arestaVoltando);
		
		this.listaArestas.add(arestaIndo);
		this.listaArestas.add(arestaVoltando);
	}
	
	/* 	Procura o vértice que contém um determinado dado, para poder adicionar as Arestas 
	 	no método adicionarAresta(); 
	 	NOTA-SE QUE NÃO PODE ADICIONAR VÉRTICES COM VALORES IGUAIS! */
	public Vertice<TIPO> getVertice(TIPO dado) {
		Vertice<TIPO> vertice = null;
		for(int i=0; i<this.listaVertices.size(); i++) {
			if(this.listaVertices.get(i).getDado().equals(dado)) {
				vertice = this.listaVertices.get(i);
				break;
			}
		}
		return vertice;
	}
	
	public void buscaEmLargura(TIPO dado) {
		visitados = new ArrayList<>();
		fila = new ArrayList<>();
		
		Vertice<TIPO> raiz = getVertice(dado);
		
		fila.add(raiz);
		visitados.add(raiz);
		System.out.println(raiz.getDado());	
		
		while(fila.size()>0) {
			Vertice<TIPO> atual = fila.get(0);
			for(int i = 0; i<atual.getArestasSaida().size();i++) {
				Vertice<TIPO> proximo = atual.getArestasSaida().get(i).getFim();
				if(!visitados.contains(proximo)) {
					fila.add(proximo);
					visitados.add(proximo);
					System.out.println(proximo.getDado());		
				}
			}
			fila.remove(0);			
		}
		visitados = new ArrayList<>();
		fila = new ArrayList<>();
	}
	
	public void buscaEmProfundidade(TIPO dado){
		
		//somente para salvar o valor da raiz original.
		if(primeiraExecucao) {
			primeiraExecucao = false;
			dadoOrigem = dado;
		}
		
		Vertice<TIPO> raiz = getVertice(dado);
		
		pilha.add(raiz);
		boolean isFolha = false;
		
		while(!isFolha) {
			
			for(int i = 0; i<raiz.getArestasSaida().size();i++) {
				
				// verifica se o vértice é folha
				if(raiz.getArestasSaida().size()==1) {
					isFolha=true;
					break;
				}		
				
				// verifica se a lista de visitados contém o vértice filho mais a direita da raiz
				if(visitados.contains(raiz.getArestasSaida().get(raiz.getArestasSaida().size()-1).getFim())) {
					isFolha=true;
					
					// verifica se o vértice pai do atual vértice é a raiz original
					if(raiz.getArestasSaida().get(0).getFim().getDado()==dadoOrigem) {
						
						// muda o atributo pois por recursividade o próximo vértice a ser checado 
						// é a raiz original {checar problema descrito no método adicionarArestas()}
						jaEntrou=false; 
					}
					break;
				}	
				
				// verifica se o vértice em questão (iterador) não está presente na lista de visitados
				// e se este vértice é a raiz original
				if(!visitados.contains(raiz.getArestasSaida().get(i).getFim()) && !jaEntrou) {
					jaEntrou=true;
					isFolha=false;
					buscaEmProfundidade(raiz.getArestasSaida().get(i).getFim().getDado());	
				}	
				
				// verifica se o vértice em questão (iterador) não está presente na lista de visitados
				// e se este vértice NÃO é a raiz original
				// o get(i+1) resolve o problema descrito no método adicionarArestas();
				if(jaEntrou) {
					if(!visitados.contains(raiz.getArestasSaida().get(i+1).getFim())) {								
						isFolha=false;
						buscaEmProfundidade(raiz.getArestasSaida().get(i+1).getFim().getDado());
					}
				}		
			}
			
			// Printa o conteúdo do vértice e adiciona a lista de visitados
			if(isFolha) {
				visitados.add(raiz);
				System.out.println(raiz.getDado());
				pilha.remove(pilha.size()-1);
			}
		}	
	}
	
	public void dijkstra(TIPO dado) {
		fila = new ArrayList<>();
		visitados = new ArrayList<>(); 
		ArrayList<Vertice<TIPO>> relaxados = new ArrayList<>();
		
		Vertice<TIPO> raiz = getVertice(dado);
		
		fila.add(raiz);
		visitados.add(raiz);
		raiz.setDistanciaRaiz(0.0);	
		raiz.getMenorCaminho().add(raiz);
		
		while(fila.size()>0) {
			Vertice<TIPO> atual = fila.get(0);
			for(int i = 0; i<atual.getArestasSaida().size();i++) {
				Vertice<TIPO> proximo = atual.getArestasSaida().get(i).getFim();
				if(!relaxados.contains(proximo)) {
					fila.add(proximo);
					visitados.add(proximo);
					if(proximo.getDistanciaRaiz()==null||proximo.getDistanciaRaiz()>atual.getArestasSaida().get(i).getPeso()+atual.getDistanciaRaiz()) {
						if(proximo.getMenorCaminho().size()!=0 && proximo.getMenorCaminho().get(proximo.getMenorCaminho().size()-1).getDado()==proximo.getDado()) {
							proximo.getMenorCaminho().clear();
						}
						proximo.setDistanciaRaiz(atual.getArestasSaida().get(i).getPeso()+atual.getDistanciaRaiz());
						if(!proximo.getMenorCaminho().contains(raiz)){
							proximo.getMenorCaminho().add(raiz);
						}
						if(atual!= raiz) {
							proximo.getMenorCaminho().add(atual);
						}
						proximo.getMenorCaminho().add(proximo);
					}							
				}
			}
			relaxados.add(atual);
			fila.remove(0);		
		}
		System.out.println("Vértice : Distância da Raiz -> Caminho");
		for(Vertice<TIPO> vertice: listaVertices) {
			System.out.print(vertice.getDado()+" : "+  vertice.getDistanciaRaiz()+" -> ");
			for(Vertice<TIPO> verticeDoCaminho: vertice.getMenorCaminho()) {
				System.out.print(verticeDoCaminho.getDado());
				System.out.print("-");
			}
			System.out.println();
			
		}
		
		
	}	
}
