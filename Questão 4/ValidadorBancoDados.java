import java.util.ArrayList;
import java.util.List;

class ValidadorBancoDados extends ValidadorNFe {
    private List<String> nfesInseridas;
    
    public ValidadorBancoDados() {
        super("Validador de Banco de Dados", 2000);
        this.nfesInseridas = new ArrayList<>();
    }
    
    @Override
    protected boolean executarValidacao(DocumentoFiscal doc) {
        // Verifica duplicidade
        if (nfesInseridas.contains(doc.getNumeroNFe())) {
            System.out.println("XX NFe duplicada!");
            return false;
        }
        
        // Insere no banco (simulado)
        nfesInseridas.add(doc.getNumeroNFe());
        doc.setInseridoBanco(true);
        System.out.println("NFe inserida no banco");
        return true;
    }
    
    @Override
    protected void rollback(DocumentoFiscal doc) {
        if (doc.isInseridoBanco()) {
            nfesInseridas.remove(doc.getNumeroNFe());
            doc.setInseridoBanco(false);
            System.out.println("<- ROLLBACK: NFe removida do banco");
        }
    }
    
    @Override
    public ResultadoValidacao validar(DocumentoFiscal doc, ResultadoValidacao resultado) {
        ResultadoValidacao res = super.validar(doc, resultado);
        
        // Se validações subsequentes falharem, faz rollback
        if (!res.isSucesso() && doc.isInseridoBanco()) {
            System.out.println("\nXX Detectada falha após inserção no banco");
            rollback(doc);
        }
        
        return res;
    }
}