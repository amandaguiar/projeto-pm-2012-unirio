# Testes para a classe acessoArquivoVenda #


---


## Testes para verificação de integridade de um arquivo ##

|Teste|Entrada|Resultado Esperado|
|:----|:------|:-----------------|
|1 |10/03/2011;40;20;60|acessoArquivoException|
|2 |10/03/2011;0020;40;20;60;90|acessoArquivoException|
|3 |10/03/2011;0020;40;;60|acessoArquivoException|
|4 |10/03/2011;;40;20;60|acessoArquivoException|
|5 |11/03/2011;0018;-1;20;60|acessoArquivoException|
|6 |11/03/2011;0018;40;0;60|Lista contendo uma Venda|
|7 |11/03/2011;0018;40;20;1|Lista contendo uma Venda|
|8 |10/03/2011;0020;10;asd;50|acessoArquivoException|
|9 |10/03/2011;0020;    ;20;60|acessoArquivoException|

Os testes 1 e 2 verificam a quantidade de campos de uma linha do arquivo. O valor limite de campos é 5. Foram feitos testes com valor limite - 1 e valor limite + 1. O teste com o próprio valor limite é equivalente ao teste 6.

Os testes 3 e 4 verificam a detecção de campos nulos. Foram feitos testes com uma quantidade de produtos vendidos nula e código do vendedor nulo.

Os testes 5, 6 e 7 verificam a integridade das quantidades de produtos vendidos. O valor limite da quantidade é 0. Foram feitos testes com valor limite - 1, valor limite, e valor limite + 1.

Os testes 8 e 9 verificam se a quantidade vendida é um valor numérico.


---


## Testes de acesso ao arquivo ##

|Teste|Entrada|Resultado Esperado|
|:----|:------|:-----------------|
|1 |Arquivo Válido|Lista de Vendas|
|2 |Arquivo Inválido|acessoArquivoExcpetion|
|3 |Arquivo Inexistente|acessoArquivoExcpetion|