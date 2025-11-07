import java.util.HashMap;

public class SistemaBancarioLegado {
   
    public HashMap<String, Object> processarTransacao(HashMap<String, Object> parametros) {
   
        HashMap<String, Object> resposta = new HashMap<>();
        
        try {

            if (!parametros.containsKey("numeroCartao")) {
                resposta.put("statusCode", 400);
                resposta.put("errorMessage", "Campo obrigatorio: numeroCartao");
                return resposta;
            }
            
            if (!parametros.containsKey("idTerminal")) {
                resposta.put("statusCode", 400);
                resposta.put("errorMessage", "Campo obrigatorio: idTerminal");
                return resposta;
            }
            
            String cartao = (String) parametros.get("numeroCartao");
            Double valorCentavos = (Double) parametros.get("valorCentavos");
            Integer codigoMoeda = (Integer) parametros.get("codigoMoeda");
            String terminal = (String) parametros.get("idTerminal");
            
            if (valorCentavos > 1000000) {
                resposta.put("statusCode", 403);
                resposta.put("errorMessage", "Valor acima do limite permitido");
                resposta.put("codigoRetorno", "LIM_EXCEDIDO");
            } else {
                resposta.put("statusCode", 200);
                resposta.put("mensagemRetorno", "Transacao aprovada");
                resposta.put("codigoRetorno", "APR_" + System.currentTimeMillis());
            }
            
        } catch (Exception e) {
            resposta.put("statusCode", 500);
            resposta.put("errorMessage", "Erro interno: " + e.getMessage());
        }
        
        return resposta;
    }

}
