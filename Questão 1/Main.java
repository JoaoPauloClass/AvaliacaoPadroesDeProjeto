// class Main {
//     public static void main(String[] args) {
//         // Contexto financeiro complexo
//         ContextoFinanceiro contexto = new ContextoFinanceiro(
//             1000000.0,  // R$ 1 milhão
//             0.18,       // 18% volatilidade
//             30,         // 30 dias
//             "Ações"
//         );
        
//         // Calculadora começa com Value at Risk
//         CalculadoraRisco calculadora = new CalculadoraRisco(new ValueAtRisk());
        
//         System.out.println("ANÁLISE 1 - Value at Risk:");
//         System.out.println(calculadora.executarAnalise(contexto));
        
//         System.out.println("\n" + "=".repeat(60) + "\n");
        
//         // Troca para Expected Shortfall em tempo de execução
//         calculadora.setEstrategia(new ExpectedShortfall());
//         System.out.println("ANÁLISE 2 - Expected Shortfall:");
//         System.out.println(calculadora.executarAnalise(contexto));
        
//         System.out.println("\n" + "=".repeat(60) + "\n");
        
//         // Troca para Stress Testing em tempo de execução
//         calculadora.setEstrategia(new StressTesting());
//         System.out.println("ANÁLISE 3 - Stress Testing:");
//         System.out.println(calculadora.executarAnalise(contexto));
        
//         System.out.println("\n" + "=".repeat(60) + "\n");
        
//         // Demonstra que pode voltar para qualquer estratégia
//         calculadora.setEstrategia(new ValueAtRisk());
//         System.out.println("ANÁLISE 4 - Volta para VaR:");
//         System.out.println(calculadora.executarAnalise(contexto));
//     }
// }