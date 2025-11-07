class ExpectedShortfall implements IEstrategiaRisco {
    @Override
    public String calcularRisco(ContextoFinanceiro contexto) {

        double es = contexto.getValorPortfolio() * contexto.getVolatilidade() * 0.22;
        
        return String.format(
            "=== EXPECTED SHORTFALL (ES) ===\n" +
            "Portfolio: R$ %.2f\n" +
            "Volatilidade: %.2f%%\n" +
            "Ativo: %s\n" +
            "ES Calculado (CVaR): R$ %.2f\n" +
            "Interpretação: Perda média esperada quando VaR é excedido\n" +
            "Risco de cauda capturado: %.2f%% do portfolio",
            contexto.getValorPortfolio(),
            contexto.getVolatilidade() * 100,
            contexto.getTipoAtivo(),
            es,
            (es / contexto.getValorPortfolio()) * 100
        );
    }
}