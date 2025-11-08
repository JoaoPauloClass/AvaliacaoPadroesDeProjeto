# AvaliacaoPadroesDeProjeto

## Questão 01
O Strategy é ideal porque permite definir uma família de algoritmos intercambiáveis (VaR, Expected Shortfall, Stress Testing) e trocar entre eles em tempo de execução sem alterar o código cliente. Ele encapsula cada algoritmo em classes separadas com interface comum, permitindo que o contexto financeiro seja passado para qualquer estratégia sem que o cliente conheça detalhes de implementação.

## Questão 02
O Adapter foi utilizado porque sua responsabilidade específica é tornar duas interfaces incompatíveis trabalharem juntas sem modificá-las. Ele encapsula toda a lógica de conversão (tipos, formatos, mapeamentos) em um único lugar, evitando poluir o código cliente ou o sistema legado. Permite adicionar campos obrigatórios do legado (como idTerminal) de forma transparente, sem que a interface moderna precise conhecê-los. Além disso, facilita a manutenção e testes, pois todas as conversões bidirecionais ficam centralizadas no adapter, tornando o código mais limpo e profissional.

## Questão 03
O State é ideal porque permite que um objeto altere seu comportamento quando seu estado interno muda, encapsulando as transições e validações complexas dentro de cada classe de estado. Ele evita estruturas condicionais gigantes (if/else) e garante que transições perigosas sejam impedidas através da lógica específica de cada estado.

## Questão 04
O Chain of Responsibility é ideal porque permite passar uma requisição por uma cadeia de handlers, onde cada validador pode processar, rejeitar ou passar adiante. Ele suporta validações condicionais, permite interromper a cadeia (circuit breaker) e possibilita rollback de validadores anteriores quando necessário.