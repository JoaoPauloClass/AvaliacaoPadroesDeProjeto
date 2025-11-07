class CalculadoraRisco {
    private IEstrategiaRisco estrategia;
    
    public CalculadoraRisco(IEstrategiaRisco estrategia) {
        this.estrategia = estrategia;
    }
    
    // Permite trocar algoritmo em tempo de execução
    public void setEstrategia(IEstrategiaRisco estrategia) {
        this.estrategia = estrategia;
        System.out.println("→ Estratégia alterada para: " + 
                         estrategia.getClass().getSimpleName() + "\n");
    }
    
    public String executarAnalise(ContextoFinanceiro contexto) {
        return estrategia.calcularRisco(contexto);
    }
}