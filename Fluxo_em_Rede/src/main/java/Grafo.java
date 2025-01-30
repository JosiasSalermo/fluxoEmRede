public class Grafo {
    private int V; // Número de vértices
    private int[][] capacidade; // Matriz de adjacência representando a capacidade das arestas

    // Construtor: Inicializa o grafo com V vértices e matriz de capacidade
    public Grafo(int vertices) {
        this.V = vertices;
        this.capacidade = new int[vertices][vertices];
    }

    // Adiciona uma aresta ao grafo, informando sua capacidade
    public void adicionarAresta(int origem, int destino, int cap) {
        capacidade[origem][destino] = cap;
    }

    // Retorna a matriz de capacidade do grafo
    public int[][] getCapacidade() {
        return capacidade;
    }

    // Retorna o número de vértices do grafo
    public int getNumVertices() {
        return V;
    }
}
