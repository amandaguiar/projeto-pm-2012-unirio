# Casos de teste do arquivo acessoArquivoComissaoTest #

| Teste | Entrada |  Resultado Esperado |
|:------|:--------|:--------------------|
| 1 | HashMap com os atributos "1234", new Comissao(05, "0020", "MANOEL", 2, 1, 1, 1, 1000, 500, 1000, 2500, 500)) | Arquivo Texto com o conteúdo = 5;0020;MANOEL;1000.0;500.0;1000.0;2500.0;500.0 |

No teste 1 temos como entrada um HashMap e espera-se que tenhamos como saída um arquivo texto com os atributos deste HashMap separado por ";". Foi usado um arquivo de referência para verificar a validade deste arquivo gerado.