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
            resultado.adicionarMensagem("⚠ CIRCUIT BREAKER: Cadeia interrompida após 3 falhas");
            return resultado;
        }
        
        System.out.println("\n→ Executando: " + nome);
        resultado.adicionarValidador(nome);
        
        // Simula timeout
        long inicio = System.currentTimeMillis();
        boolean validacaoOk = executarValidacao(doc);
        long duracao = System.currentTimeMillis() - inicio;
        
        if (duracao > timeout) {
            System.out.println("  ✗ TIMEOUT excedido (" + duracao + "ms > " + timeout + "ms)");
            resultado.setSucesso(false);
            resultado.incrementarFalhas();
            resultado.adicionarMensagem("✗ " + nome + ": TIMEOUT");
            return resultado;
        }
        
        if (validacaoOk) {
            System.out.println("  ✓ Validação OK (" + duracao + "ms)");
        } else {
            System.out.println("  ✗ Validação FALHOU");
            resultado.incrementarFalhas();
            resultado.adicionarMensagem("✗ " + nome + ": Falhou");
            
            // Se deve interromper a cadeia
            if (deveInterromperCadeia()) {
                resultado.setSucesso(false);
                return resultado;
            }
        }
        
        // Continua para o próximo validador
        if (proximo != null && deveContinuar(validacaoOk)) {
            return proximo.validar(doc, resultado);
        }
        
        // Define sucesso final
        if (resultado.getFalhasAcumuladas() > 0) {
            resultado.setSucesso(false);
        }
        
        return resultado;
    }
    
    // Métodos abstratos/sobrescritíveis
    protected abstract boolean executarValidacao(DocumentoFiscal doc);
    
    protected boolean deveContinuar(boolean validacaoAtualOk) {
        return validacaoAtualOk; // Padrão: só continua se passou
    }
    
    protected boolean deveInterromperCadeia() {
        return false; // Padrão: não interrompe
    }
    
    protected void rollback(DocumentoFiscal doc) {
        // Implementado por validadores que precisam desfazer operações
    }
}