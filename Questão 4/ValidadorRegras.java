class ValidadorRegrasFiscais extends ValidadorNFe {
    public ValidadorRegrasFiscais() {
        super("Validador de Regras Fiscais", 3000);
    }
    
    @Override
    protected boolean executarValidacao(DocumentoFiscal doc) {
        // Simula calculo de impostos
        double impostosCalculados = doc.getValorTotal() * 0.15;
        return Math.abs(doc.getImpostos() - impostosCalculados) < 0.01;
    }
}