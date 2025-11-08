class UsinaNuclear {
    private EstadoUsina estadoAtual;
    private ContextoUsina contexto;
    
    public UsinaNuclear() {
        this.estadoAtual = new Desligada();
        this.contexto = new ContextoUsina();
    }
    
    public void mudarEstado(EstadoUsina novoEstado) {
        System.out.println("** TRANSIÇÃO: " + estadoAtual.getNome() + 
                         " -> " + novoEstado.getNome() + " **");
        
        // Marca tempo quando entra em alerta amarelo
        if (novoEstado instanceof AlertaAmarelo) {
            contexto.setTempoAlertaAmarelo(System.currentTimeMillis());
        }
        
        this.estadoAtual = novoEstado;
    }
    
    public void verificarSistema() {
        System.out.println("\n[Estado Atual: " + estadoAtual.getNome() + "]");
        estadoAtual.verificarCondicoes(this);
    }
    
    public void ligar() {
        estadoAtual.ligar(this);
    }
    
    public void desligar() {
        estadoAtual.desligar(this);
    }
    
    public void entrarManutencao() {
        estadoAtual.entrarManutencao(this);
    }
    
    public ContextoUsina getContexto() {
        return contexto;
    }
    
    public String getEstadoAtual() {
        return estadoAtual.getNome();
    }
}