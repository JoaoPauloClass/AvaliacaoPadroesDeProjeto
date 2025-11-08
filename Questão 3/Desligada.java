class Desligada extends EstadoUsina {
    public Desligada() {
        super("DESLIGADA");
    }
    
    @Override
    public void verificarCondicoes(UsinaNuclear usina) {
        System.out.println("Usina desligada. Nenhuma verificação necessária.");
    }
    
    @Override
    public void ligar(UsinaNuclear usina) {
        System.out.println("-> Iniciando procedimento de ativação...");
        usina.mudarEstado(new OperacaoNormal());
    }
    
    @Override
    public void desligar(UsinaNuclear usina) {
        System.out.println("Usina já está desligada.");
    }
    
    @Override
    public void entrarManutencao(UsinaNuclear usina) {
        System.out.println("-> Entrando em modo manutenção...");
        usina.mudarEstado(new Manutencao(this));
    }
}