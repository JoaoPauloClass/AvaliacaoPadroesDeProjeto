# AvaliacaoPadroesDeProjeto


## Questão 02
O Adapter foi utilizado porque sua responsabilidade específica é tornar duas interfaces incompatíveis trabalharem juntas sem modificá-las. Ele encapsula toda a lógica de conversão (tipos, formatos, mapeamentos) em um único lugar, evitando poluir o código cliente ou o sistema legado. Permite adicionar campos obrigatórios do legado (como idTerminal) de forma transparente, sem que a interface moderna precise conhecê-los. Além disso, facilita a manutenção e testes, pois todas as conversões bidirecionais ficam centralizadas no adapter, tornando o código mais limpo e profissional.