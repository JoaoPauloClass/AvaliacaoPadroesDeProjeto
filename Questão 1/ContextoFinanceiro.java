public class ContextoFinanceiro {
    private double valorPortfolio;
    private double volatilidade;
    private int periodoAnalise;
    private String tipoAtivo;
    
    public ContextoFinanceiro(double valorPortfolio, double volatilidade, 
                              int periodoAnalise, String tipoAtivo) {
        this.valorPortfolio = valorPortfolio;
        this.volatilidade = volatilidade;
        this.periodoAnalise = periodoAnalise;
        this.tipoAtivo = tipoAtivo;
    }
    
    public double getValorPortfolio() { return valorPortfolio; }
    public double getVolatilidade() { return volatilidade; }
    public int getPeriodoAnalise() { return periodoAnalise; }
    public String getTipoAtivo() { return tipoAtivo; }
}
