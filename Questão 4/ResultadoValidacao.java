import java.util.ArrayList;
import java.util.List;

class ResultadoValidacao {
    private boolean sucesso;
    private String mensagem;
    private int falhasAcumuladas;
    private List<String> validadoresExecutados;
    
    public ResultadoValidacao() {
        this.sucesso = true;
        this.mensagem = "";
        this.falhasAcumuladas = 0;
        this.validadoresExecutados = new ArrayList<>();
    }
    
    public boolean isSucesso() { return sucesso; }
    public void setSucesso(boolean sucesso) { this.sucesso = sucesso; }
    
    public String getMensagem() { return mensagem; }
    public void adicionarMensagem(String msg) { 
        if (!this.mensagem.isEmpty()) this.mensagem += "\n";
        this.mensagem += msg; 
    }
    
    public int getFalhasAcumuladas() { return falhasAcumuladas; }
    public void incrementarFalhas() { this.falhasAcumuladas++; }
    
    public void adicionarValidador(String nome) { 
        validadoresExecutados.add(nome); 
    }
    
    public List<String> getValidadoresExecutados() { 
        return validadoresExecutados; 
    }
}