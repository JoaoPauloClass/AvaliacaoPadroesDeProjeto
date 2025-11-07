import java.util.HashMap;
import java.util.Map;

class AdaptadorSistemaBancario implements ProcessarTransacoes {
    
    private SistemaBancarioLegado sistemaLegado;
    private String idTerminal;
    
    private static final Map<String, Integer> CODIGO_MOEDAS = Map.of(
        "USD", 1,
        "EUR", 2,
        "BRL", 3
    );
    
    private static final Map<Integer, String> MOEDAS_POR_CODIGO = Map.of(
        1, "USD",
        2, "EUR",
        3, "BRL"
    );
    
    public AdaptadorSistemaBancario(SistemaBancarioLegado sistemaLegado, String idTerminal) {
        this.sistemaLegado = sistemaLegado;
        this.idTerminal = idTerminal;
    }
    
    @Override
    public ResultadoTransacao autorizar(String cartao, double valor, String moeda) {

        HashMap<String, Object> parametrosLegado = converterParaLegado(cartao, valor, moeda);

        HashMap<String, Object> respostaLegado = sistemaLegado.processarTransacao(parametrosLegado);
        
        return converterParaModerno(respostaLegado);
    }
    
    /**
     * Converte requisição moderna para formato do sistema legado
     */
    private HashMap<String, Object> converterParaLegado(String cartao, double valor, String moeda) {
        HashMap<String, Object> parametros = new HashMap<>();
        
        parametros.put("numeroCartao", cartao);
        parametros.put("valorCentavos", valor * 100); // Converte para centavos
        

        Integer codigoMoeda = CODIGO_MOEDAS.get(moeda.toUpperCase());
        if (codigoMoeda == null) {
            throw new IllegalArgumentException("Moeda não suportada: " + moeda);
        }
        parametros.put("codigoMoeda", codigoMoeda);
        
        parametros.put("idTerminal", idTerminal);
        
        parametros.put("timestampRequisicao", System.currentTimeMillis());
        
        return parametros;
    }
    
    /**
     * Converte resposta do legado para formato moderno
     */
    private ResultadoTransacao converterParaModerno(HashMap<String, Object> respostaLegado) {
        Integer statusCode = (Integer) respostaLegado.get("statusCode");
        
        if (statusCode == 200) {
            String mensagem = (String) respostaLegado.get("mensagemRetorno");
            String codigo = (String) respostaLegado.get("codigoRetorno");
            return new ResultadoTransacao(true, mensagem, codigo);
        } else {
            String mensagemErro = (String) respostaLegado.get("errorMessage");
            String codigoErro = (String) respostaLegado.getOrDefault("codigoRetorno", "ERRO");
            return new ResultadoTransacao(false, mensagemErro, codigoErro);
        }
    }
    
    /**
     * Método auxiliar para converter código de moeda
     */
    public String obterMoedaPorCodigo(int codigo) {
        return MOEDAS_POR_CODIGO.getOrDefault(codigo, "DESCONHECIDA");
    }
    
    /**
     * Método auxiliar para obter código de moeda
     */
    public Integer obterCodigoPorMoeda(String moeda) {
        return CODIGO_MOEDAS.get(moeda.toUpperCase());
    }
}