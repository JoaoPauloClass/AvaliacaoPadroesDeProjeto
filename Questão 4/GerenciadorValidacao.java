class GerenciadorValidacao {
    private ValidadorNFe primeiroValidador;
    
    public GerenciadorValidacao() {
        construirCadeia();
    }
    
    private void construirCadeia() {
        // Monta a cadeia: 1 → 2 → 3 → 4 → 5
        ValidadorNFe v1 = new ValidadorSchemaXML();
        ValidadorNFe v2 = new ValidadorCertificado();
        ValidadorNFe v3 = new ValidadorRegrasFiscais();
        ValidadorNFe v4 = new ValidadorBancoDados();
        ValidadorNFe v5 = new ValidadorSEFAZ();
        
        v1.setProximo(v2);
        v2.setProximo(v3);
        v3.setProximo(v4);
        v4.setProximo(v5);
        
        primeiroValidador = v1;
    }
    
    public ResultadoValidacao validarDocumento(DocumentoFiscal doc) {
        System.out.println("=== INICIANDO VALIDAÇÃO DA NF-e: " + doc.getNumeroNFe() + " ===");
        
        ResultadoValidacao resultado = new ResultadoValidacao();
        resultado = primeiroValidador.validar(doc, resultado);
        
        System.out.println("\n=== RESULTADO FINAL ===");
        System.out.println("Status: " + (resultado.isSucesso() ? "✓ APROVADO" : "✗ REJEITADO"));
        System.out.println("Validadores executados: " + resultado.getValidadoresExecutados().size());
        System.out.println("Falhas: " + resultado.getFalhasAcumuladas());
        
        if (!resultado.getMensagem().isEmpty()) {
            System.out.println("\nDetalhes:");
            System.out.println(resultado.getMensagem());
        }
        
        return resultado;
    }
}