class StressTesting implements IEstrategiaRisco {
    @Override
    public String calcularRisco(ContextoFinanceiro contexto) {
        double cenarioLeve = contexto.getValorPortfolio() * 0.10;
        double cenarioModerado = contexto.getValorPortfolio() * 0.25;
        double cenarioSevero = contexto.getValorPortfolio() * 0.45;
        
        return String.format(
            "=== STRESS TESTING ===\n" +
            "Portfolio: R$ %.2f\n" +
            "Ativo: %s\n" +
            "Período: %d dias\n\n" +
            "CENÁRIOS DE STRESS:\n" +
            "  • Leve (queda 10%%):     R$ %.2f de perda\n" +
            "  • Moderado (queda 25%%): R$ %.2f de perda\n" +
            "  • Severo (queda 45%%):   R$ %.2f de perda\n\n" +
            "Recomendação: Revisar exposição em ativos de risco",
            contexto.getValorPortfolio(),
            contexto.getTipoAtivo(),
            contexto.getPeriodoAnalise(),
            cenarioLeve,
            cenarioModerado,
            cenarioSevero
        );
    }
}