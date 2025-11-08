class ValidadorSEFAZ extends ValidadorNFe {
    public ValidadorSEFAZ() {
        super("Validador de Serviço SEFAZ", 5000);
    }
    
    @Override
    protected boolean executarValidacao(DocumentoFiscal doc) {
        // Simula consulta online à SEFAZ
        try {
            Thread.sleep(100); // Simula latência de rede
        } catch (InterruptedException e) {}
        
        // 80% de chance de sucesso
        return Math.random() > 0.2;
    }
}