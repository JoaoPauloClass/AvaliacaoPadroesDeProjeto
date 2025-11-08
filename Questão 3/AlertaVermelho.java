class AlertaVermelho extends EstadoUsina {
    public AlertaVermelho() {
        super("ALERTA_VERMELHO");
    }
    
    @Override
    public void verificarCondicoes(UsinaNuclear usina) {
        ContextoUsina ctx = usina.getContexto();
        
        // REGRA: sistema de resfriamento falhar → EMERGÊNCIA
        if (!ctx.isSistemaResfriamentoFuncionando()) {
            System.out.println("🚨 EMERGÊNCIA: Sistema de resfriamento falhou!");
            usina.mudarEstado(new Emergencia());
        } else if (ctx.getTemperatura() < 400) {
            System.out.println("⚠ Temperatura reduzindo. Baixando para alerta amarelo.");
            usina.mudarEstado(new AlertaAmarelo());
        } else {
            System.out.println("⚠⚠ Alerta vermelho ativo. Situação crítica!");
        }
    }
    
    @Override
    public void ligar(UsinaNuclear usina) {
        System.out.println("ERRO: Não pode ligar em estado crítico.");
    }
    
    @Override
    public void desligar(UsinaNuclear usina) {
        System.out.println("→ Desligamento de emergência total...");
        usina.mudarEstado(new Desligada());
    }
    
    @Override
    public void entrarManutencao(UsinaNuclear usina) {
        System.out.println("ERRO: Não pode entrar em manutenção durante alerta crítico!");
    }
}