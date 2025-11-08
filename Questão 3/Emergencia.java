class Emergencia extends EstadoUsina {
    public Emergencia() {
        super("EMERGENCIA");
    }
    
    @Override
    public void verificarCondicoes(UsinaNuclear usina) {
        System.out.println("🚨🚨 ESTADO DE EMERGÊNCIA! Protocolos de segurança ativados!");
        System.out.println("Evacuação recomendada. Aguardando intervenção manual.");
    }
    
    @Override
    public void ligar(UsinaNuclear usina) {
        System.out.println("ERRO: Impossível ligar em estado de emergência!");
    }
    
    @Override
    public void desligar(UsinaNuclear usina) {
        System.out.println("→ Desligamento total e selamento do reator...");
        usina.mudarEstado(new Desligada());
    }
    
    @Override
    public void entrarManutencao(UsinaNuclear usina) {
        System.out.println("ERRO: Não pode entrar em manutenção durante emergência!");
    }
}