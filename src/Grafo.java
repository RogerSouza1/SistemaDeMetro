import java.util.ArrayList;
import java.util.Comparator;

public class Grafo {
    private final ArrayList<Vertice> estacoes;
    private final ArrayList<Aresta> conexoes;

    public Grafo() {
        this.conexoes = new ArrayList<>();
        this.estacoes = new ArrayList<>();
    }

    public void adicionarEstacao(String nomeEstacao) {
        if (buscarEstacao(nomeEstacao) != null) {
            throw new IllegalArgumentException("Estação já existente");
        } else {
            estacoes.add(new Vertice(nomeEstacao));
        }
    }

    public void adicionarConexao(double tempoViagem, String nomeEstacaoInicio, String nomeEstacaoFim) {
        Vertice inicio = buscarEstacao(nomeEstacaoInicio);
        Vertice fim = buscarEstacao(nomeEstacaoFim);

        if (inicio == null || fim == null) {
            throw new IllegalArgumentException("Estação de origem ou destino não encontrada");
        }

        Aresta novaConexao = new Aresta(tempoViagem, inicio, fim);
        if (!conexoes.contains(novaConexao)) {
            conexoes.add(novaConexao);
            conexoes.add(new Aresta(tempoViagem, fim, inicio));
        } else {
            throw new IllegalArgumentException("Conexão já existente");
        }
    }

    public ArrayList<Caminho> escontrar5CaminhosMaisRapidos(String nomeEstacaoOrigem, String nomeEstacaoDestino) {
        ArrayList<Caminho> caminhos = encontrarTodosOsCaminhosMaisRapidos(nomeEstacaoOrigem, nomeEstacaoDestino);
        if (caminhos.isEmpty()) {
            System.out.printf("Não foi possível encontrar caminho entre as estações: %s e %s%n", nomeEstacaoOrigem, nomeEstacaoDestino);
        }

        int tamanhoSublista = Math.min(5, caminhos.size());
        return new ArrayList<>(caminhos.subList(0, tamanhoSublista));
    }

    private ArrayList<Caminho> encontrarTodosOsCaminhosMaisRapidos(String nomeEstacaoOrigem, String nomeEstacaoDestino) {
        Vertice origem = buscarEstacao(nomeEstacaoOrigem);
        Vertice destino = buscarEstacao(nomeEstacaoDestino);
        if (origem == null || destino == null) {
            throw new IllegalArgumentException("Estação de origem ou destino não encontrada");
        }

        ArrayList<Caminho> todosCaminhos = new ArrayList<>();
        ArrayList<Vertice> caminhoAtual = new ArrayList<>();
        boolean[] visitados = new boolean[estacoes.size()];

        // Inicia a busca em profundidade
        buscaEmProfundidade(origem, destino, 0, todosCaminhos, caminhoAtual, visitados);

        // Ordena os caminhos pelo tempo de viagem
        todosCaminhos.sort(Comparator.comparingDouble(Caminho::getTempoViagem));

        return todosCaminhos;
    }

    private void buscaEmProfundidade(Vertice atual, Vertice destino, double tempoAtual, ArrayList<Caminho> todosCaminhos, ArrayList<Vertice> caminhoAtual, boolean[] visitados) {
    // Adiciona o vértice atual ao caminho atual
    caminhoAtual.add(atual);
    visitados[estacoes.indexOf(atual)] = true;

    // Se chegarmos ao destino, adicionamos o caminho atual à lista de caminhos
    if (atual.equals(destino)) {
        todosCaminhos.add(new Caminho(new ArrayList<>(caminhoAtual), tempoAtual)); // cria um clone do caminhoAtual
    } else {
        // Continua a busca em profundidade
        for (Aresta aresta : getConexoesSaindoDe(atual)) {
            if (!visitados[estacoes.indexOf(aresta.getFim())]) {
                double tempoViagem = aresta.getTempoViagem();
                buscaEmProfundidade(aresta.getFim(), destino, tempoAtual + tempoViagem, todosCaminhos, caminhoAtual, visitados);
            }
        }
    }

    // Remove o vértice atual do caminho atual e marca como não visitado
    if (!caminhoAtual.isEmpty()) {
        caminhoAtual.removeLast();
    }
    if (estacoes.contains(atual)) {
        visitados[estacoes.indexOf(atual)] = false;
    }
}


    private ArrayList<Aresta> getConexoesSaindoDe(Vertice vertice) {
        ArrayList<Aresta> conexoesSaindoDe = new ArrayList<>();

        for (Aresta conexao : conexoes) {
            if (conexao.getInicio().equals(vertice)) {
                conexoesSaindoDe.add(conexao);
            }
        }
        return conexoesSaindoDe;
    }

    private Vertice buscarEstacao(String nomeEstacao) {
        for (Vertice estacao : estacoes) {
            if (estacao.getNomeEstacao().equals(nomeEstacao)) {
                return estacao;
            }
        }
        return null;
    }


}
