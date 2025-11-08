class OperacaoNormal extends EstadoUsina {
    public OperacaoNormal() {
        super("OPERACAO_NORMAL");
    }
    
    @Override
    public void verificarCondicoes(UsinaNuclear usina) {
        ContextoUsina ctx = usina.getContexto();
        
        // REGRA: temperatura > 300°C → ALERTA_AMARELO
        if (ctx.getTemperatura() > 300) {
            System.out.println("⚠ AVISO: Temperatura crítica detectada!");
            usina.mudarEstado(new AlertaAmarelo());
        } else {
            System.out.println("✓ Operação normal. Todos os sistemas OK.");
        }
    }
    
    @Override
    public void ligar(UsinaNuclear usina) {
        System.out.println("Usina já está em operação.");
    }
    
    @Override
    public void desligar(UsinaNuclear usina) {
        System.out.println("→ Desligando usina de forma segura...");
        usina.mudarEstado(new Desligada());
    }
    
    @Override
    public void entrarManutencao(UsinaNuclear usina) {
        System.out.println("→ Entrando em modo manutenção...");
        usina.mudarEstado(new Manutencao(this));
    }
}