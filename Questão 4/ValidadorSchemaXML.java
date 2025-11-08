class ValidadorSchemaXML extends ValidadorNFe {
    public ValidadorSchemaXML() {
        super("Validador de Schema XML", 1000);
    }
    
    @Override
    protected boolean executarValidacao(DocumentoFiscal doc) {
        // Simula validacao XSD
        return doc.getXml() != null && doc.getXml().contains("<?xml");
    }
    
    @Override
    protected boolean deveInterromperCadeia() {
        return true; // Se XML invalido, nao adianta continuar
    }
}
