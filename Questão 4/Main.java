class Main {
    public static void main(String[] args) {
        GerenciadorValidacao gerenciador = new GerenciadorValidacao();
        
        // Teste 1: Documento válido
        System.out.println("\n### TESTE 1: Documento Válido ###");
        DocumentoFiscal doc1 = new DocumentoFiscal(
            "NFe001", 
            "<?xml version='1.0'?>", 
            "CERT_VALIDO",
            1000.00,
            150.00
        );
        gerenciador.validarDocumento(doc1);
        
        // Teste 2: Certificado expirado (interrompe cadeia)
        System.out.println("\n\n### TESTE 2: Certificado Expirado ###");
        DocumentoFiscal doc2 = new DocumentoFiscal(
            "NFe002", 
            "<?xml version='1.0'?>", 
            "EXPIRADO",
            1000.00,
            150.00
        );
        gerenciador.validarDocumento(doc2);
        
        // Teste 3: XML inválido (primeira validação falha)
        System.out.println("\n\n### TESTE 3: XML Inválido ###");
        DocumentoFiscal doc3 = new DocumentoFiscal(
            "NFe003", 
            "texto invalido", 
            "CERT_VALIDO",
            1000.00,
            150.00
        );
        gerenciador.validarDocumento(doc3);
        
        // Teste 4: Impostos calculados errado
        System.out.println("\n\n### TESTE 4: Erro no Cálculo de Impostos ###");
        DocumentoFiscal doc4 = new DocumentoFiscal(
            "NFe004", 
            "<?xml version='1.0'?>", 
            "CERT_VALIDO",
            1000.00,
            100.00  // Deveria ser 150
        );
        gerenciador.validarDocumento(doc4);
        
        // Teste 5: NFe duplicada (rollback)
        System.out.println("\n\n### TESTE 5: NFe Duplicada ###");
        DocumentoFiscal doc5a = new DocumentoFiscal(
            "NFe005", 
            "<?xml version='1.0'?>", 
            "CERT_VALIDO",
            1000.00,
            150.00
        );
        gerenciador.validarDocumento(doc5a);
        
        // Tenta inserir novamente
        DocumentoFiscal doc5b = new DocumentoFiscal(
            "NFe005", 
            "<?xml version='1.0'?>", 
            "CERT_VALIDO",
            1000.00,
            150.00
        );
        gerenciador.validarDocumento(doc5b);
    }
}