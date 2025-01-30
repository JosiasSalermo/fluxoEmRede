import java.util.LinkedList;
import java.util.Queue;

public class FordFulkerson {
    private int V; // Número de vértices

    public FordFulkerson(int vertices) {
        this.V = vertices;
    }

    // Método auxiliar: Realiza BFS para encontrar um caminho aumentante
    private boolean bfs(int[][] grafoResidual, int s, int t, int[] pai) {
        boolean[] visitado = new boolean[V]; // Marca os nós visitados
        Queue<Integer> fila = new LinkedList<>();

        fila.add(s);  // Começa a busca a partir da origem (s)
        visitado[s] = true;
        pai[s] = -1;  // O nó de origem não tem pai

        // Enquanto houver nós na fila, continuamos a busca
        while (!fila.isEmpty()) {
            int u = fila.poll(); // Pega o primeiro elemento da fila

            // Verifica todos os vizinhos de 'u'
            for (int v = 0; v < V; v++) {
                // Se houver capacidade residual e o nó ainda não foi visitado
                if (!visitado[v] && grafoResidual[u][v] > 0) {
                    fila.add(v);
                    pai[v] = u;  // Salva o caminho
                    visitado[v] = true;

                    // Se chegou ao destino, retorna true (existe caminho aumentante)
                    if (v == t) return true;
                }
            }
        }
        return false; // Não há mais caminhos aumentantes
    }

    // Método principal: Calcula o fluxo máximo de s -> t
    public int calcularFluxoMaximo(int[][] grafo, int s, int t) {
        int[][] grafoResidual = new int[V][V]; // Cópia do grafo original

        // Inicializa a matriz residual com as capacidades originais
        for (int u = 0; u < V; u++) {
            for (int v = 0; v < V; v++) {
                grafoResidual[u][v] = grafo[u][v];
            }
        }

        int[] pai = new int[V]; // Array para armazenar os caminhos aumentantes
        int fluxoMaximo = 0; // Variável para armazenar o fluxo máximo encontrado

        // Enquanto existir um caminho aumentante
        while (bfs(grafoResidual, s, t, pai)) {
            int fluxoCaminho = Integer.MAX_VALUE; // Define um fluxo inicial grande

            // Percorre o caminho aumentante e encontra a capacidade mínima
            for (int v = t; v != s; v = pai[v]) {
                int u = pai[v];
                fluxoCaminho = Math.min(fluxoCaminho, grafoResidual[u][v]);
            }

            // Atualiza a rede residual subtraindo o fluxo encontrado
            for (int v = t; v != s; v = pai[v]) {
                int u = pai[v];
                grafoResidual[u][v] -= fluxoCaminho;
                grafoResidual[v][u] += fluxoCaminho; // Fluxo reverso para representar corte mínimo
            }

            // Acumula o fluxo máximo
            fluxoMaximo += fluxoCaminho;
        }

        return fluxoMaximo;
    }
}
