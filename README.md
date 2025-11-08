# AvaliacaoPadroesDeProjeto

## Questão 01 - Justificativa do padrão
O Strategy é ideal porque permite definir uma família de algoritmos intercambiáveis (VaR, Expected Shortfall, Stress Testing) e trocar entre eles em tempo de execução sem alterar o código cliente. Ele encapsula cada algoritmo em classes separadas com interface comum, permitindo que o contexto financeiro seja passado para qualquer estratégia sem que o cliente conheça detalhes de implementação.

## Questão 02 - Justificativa do padrão
O Adapter foi utilizado porque sua responsabilidade específica é tornar duas interfaces incompatíveis trabalharem juntas sem modificá-las. Ele encapsula toda a lógica de conversão (tipos, formatos, mapeamentos) em um único lugar, evitando poluir o código cliente ou o sistema legado. Permite adicionar campos obrigatórios do legado (como idTerminal) de forma transparente, sem que a interface moderna precise conhecê-los. Além disso, facilita a manutenção e testes, pois todas as conversões bidirecionais ficam centralizadas no adapter, tornando o código mais limpo e profissional.

## Questão 03 - Justificativa do padrão
O State é ideal porque encapsula cada estado da usina em classes separadas com comportamentos específicos, eliminando estruturas condicionais gigantes que seriam difíceis de manter. Cada estado controla suas próprias transições e validações complexas de temperatura, pressão e radiação, garantindo que transições perigosas sejam impedidas através da lógica interna de cada classe. O padrão permite que a usina mude seu comportamento dinamicamente conforme o estado interno se altera, facilitando a adição de novos estados sem modificar código existente. O modo manutenção consegue sobrescrever temporariamente os estados normais e retornar ao estado anterior, algo complexo de implementar sem o padrão. Além disso, centraliza a lógica de segurança crítica em cada estado, tornando o sistema mais robusto, testável e fácil de auditar para aplicações que exigem alta confiabilidade como usinas nucleares.


## Questão 04 - Justificativa do padrão
O Chain of Responsibility é ideal porque permite passar uma requisição por uma cadeia de handlers, onde cada validador pode processar, rejeitar ou passar adiante. Ele suporta validações condicionais, permite interromper a cadeia (circuit breaker) e possibilita rollback de validadores anteriores quando necessário.