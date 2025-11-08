abstract class EstadoUsina {
    protected String nome;
    
    public EstadoUsina(String nome) {
        this.nome = nome;
    }
    
    public String getNome() { return nome; }
    
    // Métodos que cada estado deve implementar
    public abstract void verificarCondicoes(UsinaNuclear usina);
    public abstract void ligar(UsinaNuclear usina);
    public abstract void desligar(UsinaNuclear usina);
    public abstract void entrarManutencao(UsinaNuclear usina);
}