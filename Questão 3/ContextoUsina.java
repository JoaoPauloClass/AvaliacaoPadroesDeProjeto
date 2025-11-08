class ContextoUsina {
    private double temperatura;
    private double pressao;
    private double nivelRadiacao;
    private boolean sistemaResfriamentoFuncionando;
    private long tempoAlertaAmarelo;
    
    public ContextoUsina() {
        this.temperatura = 25.0;
        this.pressao = 1.0;
        this.nivelRadiacao = 0.1;
        this.sistemaResfriamentoFuncionando = true;
        this.tempoAlertaAmarelo = 0;
    }
    
    // Getters e Setters
    public double getTemperatura() { return temperatura; }
    public void setTemperatura(double temperatura) { this.temperatura = temperatura; }
    
    public double getPressao() { return pressao; }
    public void setPressao(double pressao) { this.pressao = pressao; }
    
    public double getNivelRadiacao() { return nivelRadiacao; }
    public void setNivelRadiacao(double nivelRadiacao) { this.nivelRadiacao = nivelRadiacao; }
    
    public boolean isSistemaResfriamentoFuncionando() { 
        return sistemaResfriamentoFuncionando; 
    }
    public void setSistemaResfriamentoFuncionando(boolean funcionando) { 
        this.sistemaResfriamentoFuncionando = funcionando; 
    }
    
    public long getTempoAlertaAmarelo() { return tempoAlertaAmarelo; }
    public void setTempoAlertaAmarelo(long tempo) { this.tempoAlertaAmarelo = tempo; }
}