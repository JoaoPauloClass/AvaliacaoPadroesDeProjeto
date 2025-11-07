public interface ProcessarTransacoes{
    ResultadoTransacao autorizar(String cartao, double valor, String moeda);
}