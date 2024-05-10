public class Aresta {
    private double tempoViagem;
    private Vertice inicio;
    private Vertice fim;

    public Aresta(double tempoViagem, Vertice inicio, Vertice fim){
        this.tempoViagem = tempoViagem;
        this.inicio = inicio;
        this.fim = fim;
    }

    public double getTempoViagem() {
        return tempoViagem;
    }

    public void setTempoViagem(double tempoViagem) {
        this.tempoViagem = tempoViagem;
    }

    public Vertice getInicio() {
        return inicio;
    }

    public void setInicio(Vertice inicio) {
        this.inicio = inicio;
    }

    public Vertice getFim() {
        return fim;
    }

    public void setFim(Vertice fim) {
        this.fim = fim;
    }
}
