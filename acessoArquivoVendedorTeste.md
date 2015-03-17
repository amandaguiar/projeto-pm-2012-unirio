# Casos de teste para a classe acessoArquivoVendedorTeste #


---


### Casos de teste para validação de entrada pelo arquivo ###


| Teste | Entrada | Saída Esperada |
|:------|:--------|:----------------|
| 1| 0020;MANOEL DA SILVA;1 | Lista contendo dois vendedores|
|  | 0021","JOANA ANGELICA",2 |    |
| 2 | 0020;MANOEL DA SILVA | acessoArquivoException   |
|   | 0019;MANOEL DA COSTA;2|  |
|   |0001;JOÃO DA SILVA;1  |     |
| 3 | 0020;MANOEL DA SILVA;2;5 | acessoArquivoException   |
| 4 |     ;MANOEL DA SILVA;2 | acessoArquivoException   |
|   | 0019;MANOEL DA COSTA;2|  |
|   |0001;JOÃO DA SILVA;1  |     |
|  5 |0020;MANOEL JOÃO DA SILVA;45| acessoArquivoException |


---


O teste 1 verifica se ao inserir um arquivo válido, com campos válidos, irão ser criados os objetos Vendedores. No caso, como temos duas linhas totais no arquivo e as duas são válidas, o resultado esperado é uma lista com dois objetos Vendedores.

O teste 2 verifica a quantidade de campos informadas em uma linha do arquivo. O valor limite de campos é 3. Foram feitos testes com valor limite - 1 no teste 2 e valor limite + 1 no teste 3.
O teste com o valor limite é correspondente ao teste 1.

O teste 4 verifica a detecção de campos nulos/espaços.

O teste 5 verifica a validade do campo categoria, que somente pode ser 1 ou 2. Caso seja informado um valor diferente de 1 ou 2 deve ser lançada uma exceção.