class ValueAtRisk implements IEstrategiaRisco {
    @Override
    public String calcularRisco(ContextoFinanceiro contexto) {
        
        double var = contexto.getValorPortfolio() * contexto.getVolatilidade() * 0.15;
        
        return String.format(
            "=== VALUE AT RISK (VaR) ===\n" +
            "Portfolio: R$ %.2f\n" +
            "Volatilidade: %.2f%%\n" +
            "Período: %d dias\n" +
            "VaR Calculado (95%%): R$ %.2f\n" +
            "Interpretação: Perda máxima esperada em %d dias com 95%% de confiança",
            contexto.getValorPortfolio(),
            contexto.getVolatilidade() * 100,
            contexto.getPeriodoAnalise(),
            var,
            contexto.getPeriodoAnalise()
        );
    }
}
