class DocumentoFiscal {
    private String numeroNFe;
    private String xml;
    private String certificado;
    private double valorTotal;
    private double impostos;
    private boolean inseridoBanco;
    
    public DocumentoFiscal(String numeroNFe, String xml, String certificado, 
                          double valorTotal, double impostos) {
        this.numeroNFe = numeroNFe;
        this.xml = xml;
        this.certificado = certificado;
        this.valorTotal = valorTotal;
        this.impostos = impostos;
        this.inseridoBanco = false;
    }
    
    // Getters e Setters
    public String getNumeroNFe() { return numeroNFe; }
    public String getXml() { return xml; }
    public String getCertificado() { return certificado; }
    public double getValorTotal() { return valorTotal; }
    public double getImpostos() { return impostos; }
    public boolean isInseridoBanco() { return inseridoBanco; }
    public void setInseridoBanco(boolean inserido) { this.inseridoBanco = inserido; }
}