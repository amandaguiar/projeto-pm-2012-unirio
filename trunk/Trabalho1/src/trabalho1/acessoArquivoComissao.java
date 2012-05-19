/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package trabalho1;

import java.io.FileReader;
import java.util.List;

/**
 *
 * @author Jean
 */
public class acessoArquivoComissao extends acessoArquivo{

    public static final String DELIMITADOR = ";";
    public static final int numCampos = 8;
    public static final int POS_MES = 0;
    public static final int POS_COD_VENDEDOR = 1;
    public static final int POS_NOME_VENDEDOR = 2;
    public static final int PRIMEIRA_POS_TOTAL = 3;
    
    Comissao c = new Comissao();
   
    /* Essa função compara o mês entrado com os meses presentes no arquivo de venda.
     * Para cada ocorrência de igualmente, a linha de venda é adicionada em um array.
     */
    public List<String> getVendasMes(String[] campos) {
        try {
            if (c.getMes() ==  /*Mes do arquivo de vendas*/)
                /*Bianca, parei aqui pq eu tô mt cansado! Quando eu acordar eu começo a fazer de novo!
             * Mas a ideia é o que eu escrevi no comentário mesmo, pega o Mes que o usuário vai entrar,
                 * compara com os meses do arquivo de venda e traz só as linhas que vão importar pro cálculo,
                 * ou seja, as linhas do mês que o cara entrar!
             */
        }
        
    }
    
    @Override
    public void verificarPreCondicoes(String[] campos) throws acessoArquivoException {
        verificarQtdeCamposValidos(campos, numCampos);
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    
    @Override
    public List<IAcessoArquivo> ler(FileReader file) throws acessoArquivoException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
