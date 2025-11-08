class CalculadoraRisco {
    private IEstrategiaRisco estrategia;
    
    public CalculadoraRisco(IEstrategiaRisco estrategia) {
        this.estrategia = estrategia;
    }

    public void setEstrategia(IEstrategiaRisco estrategia) {
        this.estrategia = estrategia;
        System.out.println("-> Estratégia alterada para: " + 
                         estrategia.getClass().getSimpleName() + "\n");
    }
    
    public String executarAnalise(ContextoFinanceiro contexto) {
        return estrategia.calcularRisco(contexto);
    }
}