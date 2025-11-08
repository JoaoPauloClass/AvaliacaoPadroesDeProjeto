class ValidadorCertificado extends ValidadorNFe {
    public ValidadorCertificado() {
        super("Validador de Certificado Digital", 2000);
    }
    
    @Override
    protected boolean executarValidacao(DocumentoFiscal doc) {
        // Simula verificação de expiração e revogação
        String cert = doc.getCertificado();
        return cert != null && !cert.equals("EXPIRADO") && !cert.equals("REVOGADO");
    }
    
    @Override
    protected boolean deveInterromperCadeia() {
        return true; // Certificado inválido = não pode prosseguir
    }
}