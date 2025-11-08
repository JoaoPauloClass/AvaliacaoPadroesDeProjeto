// class Main {
//     public static void main(String[] args) throws InterruptedException {
//         UsinaNuclear usina = new UsinaNuclear();
        
//         System.out.println("=== SIMULAÇÃO DE CONTROLE DE USINA NUCLEAR ===\n");
        
//         // Cenário 1: Ligar usina
//         System.out.println("1. Ligando usina...");
//         usina.ligar();
//         usina.verificarSistema();
        
//         // Cenário 2: Temperatura sobe para alerta amarelo
//         System.out.println("\n2. Temperatura aumentando...");
//         usina.getContexto().setTemperatura(350);
//         usina.verificarSistema();
        
//         // Cenário 3: Temperatura continua subindo
//         System.out.println("\n3. Temperatura crítica!");
//         usina.getContexto().setTemperatura(420);
//         Thread.sleep(100); // Simula tempo
//         usina.verificarSistema();
        
//         // Aguarda 30s (simulado)
//         usina.getContexto().setTempoAlertaAmarelo(System.currentTimeMillis() - 31000);
//         usina.verificarSistema();
        
//         // Cenário 4: Sistema de resfriamento falha
//         System.out.println("\n4. Sistema de resfriamento falhou!");
//         usina.getContexto().setSistemaResfriamentoFuncionando(false);
//         usina.verificarSistema();
        
//         // Cenário 5: Desligamento de emergência
//         System.out.println("\n5. Iniciando desligamento...");
//         usina.desligar();
//         usina.verificarSistema();
        
//         // Cenário 6: Modo manutenção
//         System.out.println("\n6. Entrando em manutenção...");
//         usina.entrarManutencao();
//         usina.verificarSistema();
        
//         System.out.println("\n7. Saindo da manutenção...");
//         usina.ligar(); // Retorna ao estado anterior
//         usina.verificarSistema();
//     }
// }