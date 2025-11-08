class AlertaAmarelo extends EstadoUsina {
    public AlertaAmarelo() {
        super("ALERTA_AMARELO");
    }
    
    @Override
    public void verificarCondicoes(UsinaNuclear usina) {
        ContextoUsina ctx = usina.getContexto();
        
        // REGRA: temperatura > 400°C por mais de 30s → ALERTA_VERMELHO
        if (ctx.getTemperatura() > 400) {
            long tempoDecorrido = System.currentTimeMillis() - ctx.getTempoAlertaAmarelo();
            
            if (tempoDecorrido > 30000) { // 30 segundos
                System.out.println("⚠⚠ CRÍTICO: Temperatura extrema por tempo prolongado!");
                usina.mudarEstado(new AlertaVermelho());
            } else {
                System.out.println("⚠ Temperatura alta. Aguardando estabilização...");
            }
        } else if (ctx.getTemperatura() < 300) {
            // Pode voltar para operação normal
            System.out.println("✓ Temperatura normalizada. Retornando à operação.");
            usina.mudarEstado(new OperacaoNormal());
        } else {
            System.out.println("⚠ Alerta amarelo mantido. Monitorando...");
        }
    }
    
    @Override
    public void ligar(UsinaNuclear usina) {
        System.out.println("ERRO: Não pode ligar em estado de alerta.");
    }
    
    @Override
    public void desligar(UsinaNuclear usina) {
        System.out.println("→ Desligamento de emergência iniciado...");
        usina.mudarEstado(new Desligada());
    }
    
    @Override
    public void entrarManutencao(UsinaNuclear usina) {
        System.out.println("ERRO: Não pode entrar em manutenção durante alerta!");
    }
}