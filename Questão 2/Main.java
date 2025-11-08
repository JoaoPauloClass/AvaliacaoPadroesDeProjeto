// public class Main {
//      public static void main(String[] args) {
//         // Sistema legado (não pode ser modificado)
//         SistemaBancarioLegado sistemaLegado = new SistemaBancarioLegado();
        
//         // Adapter que permite usar interface moderna
//         ProcessarTransacoes processador = new AdaptadorSistemaBancario(
//             sistemaLegado, 
//             "TERM_001" // ID do terminal (campo obrigatório do legado)
//         );
        
//         System.out.println("=== Teste 1: Transação aprovada ===");
//         ResultadoTransacao resultado1 = processador.autorizar(
//             "4111111111111111", 
//             150.50, 
//             "BRL"
//         );
//         System.out.println(resultado1);
        
//         System.out.println("\n=== Teste 2: Transação com valor alto ===");
//         ResultadoTransacao resultado2 = processador.autorizar(
//             "4111111111111111", 
//             15000.00, 
//             "USD"
//         );
//         System.out.println(resultado2);
        
//         System.out.println("\n=== Teste 3: Moeda EUR ===");
//         ResultadoTransacao resultado3 = processador.autorizar(
//             "5500000000000004", 
//             99.99, 
//             "EUR"
//         );
//         System.out.println(resultado3);
        
//         System.out.println("\n=== Teste 4: Moeda inválida ===");
//         try {
//             ResultadoTransacao resultado4 = processador.autorizar(
//                 "4111111111111111", 
//                 100.00, 
//                 "JPY" // Moeda não suportada
//             );
//             System.out.println(resultado4);
//         } catch (IllegalArgumentException e) {
//             System.out.println("Erro: " + e.getMessage());
//         }
//     }
// }
