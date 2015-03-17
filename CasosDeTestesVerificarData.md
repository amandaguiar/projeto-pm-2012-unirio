Testes para verificar a integridade de uma data

|Teste|Entrada|Saída|
|:----|:------|:-----|
|1 |01/12/2011|Data válida|
|2 |02/12/2011|Data válida|
|3 |31/01/2011|Data válida|
|4 |28/02/2011|Data válida|
|5 |30/11/2011|Data válida|
|6 |00/12/2011|Data inválida|
|7 |01/00/2011|Data inválida|
|8 |01/13/2011|Data inválida|
|9 |01/12/0000|Data inválida|
|10|1/01/2011|Formato da data inválido|
|11|01/7/2011|Formato da data inválido|
|12|01/07/201|Formato da data inválido|
|13|01/07/20|Formato da data inválido|
|14|01/07/2|Formato da data inválido|
|15|01/07/|Formato da data inválido|
|16|01/07/20111|Formato da data inválido|
|17|01//2011|Formato da data inválido|
|18|/07/201|Formato da data inválido|
|19|01/07/2011/|Formato da data inválido|
|20|/01/07/2011|Formato da data inválido|
|21|01-07-2011|Formato da data inválido|


Os testes 1 até 9 verificam os valores limites para o dia do mês, mês e ano.
Valor limite inferior dia do mês = 1;
Valor limite inferior mês = 1;
Valor limite superior mês = 12;
Valor limite inferior ano = 0000;
Foram feitos testes para o valor limite inferior, inferior - 1, inferior + 1 para o dia do mês e mês.
Foi feito um teste para o valor limite inferior do ano.

Utilizamos a classe GregorianCalendar do java para armazenar as datas. Esta classe já possui validações internas. Por isso não foram criados testes para o valor limite superior de dias de um determinado mês.
A utilização de uma classe nativa do Java reduz ainda mais as chances de serem encontrados erros de verificação nas datas.

Os testes 10 até 21 verificam se o formato da data está correto. O formato correto é dd/MM/AAAA.
Foi usado uma expressão regular para validar o formato da data.
Foram criados testes para campos com número incorreto dígitos, campos nulos e data com separador de campos incorretos.