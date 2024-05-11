public class Vertice {
    private String nomeEstacao;

    public Vertice(String nomeEstacao){
        this.nomeEstacao = nomeEstacao;
    }

    public String getNomeEstacao() {
        return nomeEstacao;
    }

    @Override
    public String toString(){
        return nomeEstacao;
    }
}
