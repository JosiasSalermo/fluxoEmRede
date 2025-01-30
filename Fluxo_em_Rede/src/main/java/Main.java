public class Main {
    public static void main(String[] args) {
        Grafo grafo = new Grafo(6);

        grafo.adicionarAresta(0, 1, 16);
        grafo.adicionarAresta(0, 2, 13);
        grafo.adicionarAresta(1, 2, 10);
        grafo.adicionarAresta(1, 3, 12);
        grafo.adicionarAresta(2, 1, 4);
        grafo.adicionarAresta(2, 4, 14);
        grafo.adicionarAresta(3, 2, 9);
        grafo.adicionarAresta(3, 5, 20);
        grafo.adicionarAresta(4, 3, 7);
        grafo.adicionarAresta(4, 5, 4);

        FordFulkerson fordFulkerson = new FordFulkerson(6);
        int fluxoMaximo = fordFulkerson.calcularFluxoMaximo(grafo.getCapacidade(), 0, 5);

        System.out.println("O fluxo máximo da rede é: " + fluxoMaximo);
    }
}
