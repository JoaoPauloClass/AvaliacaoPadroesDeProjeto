abstract class ValidadorNFe {
    protected ValidadorNFe proximo;
    protected String nome;
    protected long timeout; // em milissegundos
    
    public ValidadorNFe(String nome, long timeout) {
        this.nome = nome;
        this.timeout = timeout;
    }
    
    public void setProximo(ValidadorNFe proximo) {
        this.proximo = proximo;
    }
    
    public ResultadoValidacao validar(DocumentoFiscal doc, ResultadoValidacao resultado) {
        // Circuit Breaker: interrompe após 3 falhas
        if (resultado.getFalhasAcumuladas() >= 3) {
            resultado.adicionarMensagem("XX CIRCUIT BREAKER: Cadeia interrompida após 3 falhas");
            return resultado;
        }
        
        System.out.println("\n-> Executando: " + nome);
        resultado.adicionarValidador(nome);
        
        // Simula timeout
        long inicio = System.currentTimeMillis();
        boolean validacaoOk = executarValidacao(doc);
        long duracao = System.currentTimeMillis() - inicio;
        
        if (duracao > timeout) {
            System.out.println("XX TIMEOUT excedido (" + duracao + "ms > " + timeout + "ms)");
            resultado.setSucesso(false);
            resultado.incrementarFalhas();
            resultado.adicionarMensagem("✗ " + nome + ": TIMEOUT");
            return resultado;
        }
        
        if (validacaoOk) {
            System.out.println("Validação OK (" + duracao + "ms)");
        } else {
            System.out.println("XX Validação FALHOU");
            resultado.incrementarFalhas();
            resultado.adicionarMensagem("XX " + nome + ": Falhou");
            
            
            if (deveInterromperCadeia()) {
                resultado.setSucesso(false);
                return resultado;
            }
        }
        
        if (proximo != null && deveContinuar(validacaoOk)) {
            return proximo.validar(doc, resultado);
        }
        
        if (resultado.getFalhasAcumuladas() > 0) {
            resultado.setSucesso(false);
        }
        
        return resultado;
    }
    
    protected abstract boolean executarValidacao(DocumentoFiscal doc);
    
    protected boolean deveContinuar(boolean validacaoAtualOk) {
        return validacaoAtualOk;
    }
    
    protected boolean deveInterromperCadeia() {
        return false;
    }
    
    protected void rollback(DocumentoFiscal doc) {
        // Implementado por validadores que precisam desfazer operações
    }
}