class Manutencao extends EstadoUsina {
    private EstadoUsina estadoAnterior;
    
    public Manutencao(EstadoUsina estadoAnterior) {
        super("MANUTENCAO");
        this.estadoAnterior = estadoAnterior;
    }
    
    @Override
    public void verificarCondicoes(UsinaNuclear usina) {
        System.out.println("🔧 Modo manutenção ativo. Verificações automáticas desabilitadas.");
    }
    
    @Override
    public void ligar(UsinaNuclear usina) {
        System.out.println("→ Saindo do modo manutenção e retornando ao estado anterior...");
        usina.mudarEstado(estadoAnterior);
    }
    
    @Override
    public void desligar(UsinaNuclear usina) {
        System.out.println("→ Desligando durante manutenção...");
        usina.mudarEstado(new Desligada());
    }
    
    @Override
    public void entrarManutencao(UsinaNuclear usina) {
        System.out.println("Já está em modo manutenção.");
    }
}