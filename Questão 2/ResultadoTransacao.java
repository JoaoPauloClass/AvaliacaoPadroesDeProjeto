public class ResultadoTransacao {
    private boolean sucesso;
    private String mensagem;
    private String codigoAutorizacao;

    public ResultadoTransacao(boolean sucesso, String mensagem, String codigoAutorizacao) {
        this.sucesso = sucesso;
        this.mensagem = mensagem;
        this.codigoAutorizacao = codigoAutorizacao;
    }

    public boolean isSucesso(){ return sucesso;  }
    public String getMensagem() { return mensagem; }
    public String getCodidoAutorizacao() { return codigoAutorizacao; }

    @Override
    public String toString() {
        return String.format("ResultadoTransacao{sucesso=%s, mensagem='%s', codigo='%s'}", 
                           sucesso, mensagem, codigoAutorizacao);
    }
}
