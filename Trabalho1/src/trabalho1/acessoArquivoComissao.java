/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package trabalho1;

import java.io.File;
import java.io.FileWriter;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Bianca e Filipe
 */
public class acessoArquivoComissao extends acessoArquivo{

    public static final String DELIMITADOR = ";";
    public static final int numCampos = 8;
    public static final int POS_MES = 0;
    public static final int POS_COD_VENDEDOR = 1;
    public static final int POS_NOME_VENDEDOR = 2;
    public static final int PRIMEIRA_POS_TOTAL = 3;
   
    
    
        public List<Venda> getVendasNoMes(int mes, String ARQ_VENDAS) throws acessoArquivoException {
        /* Essa função compara o mês entrado com os meses presentes no arquivo de venda.
     * Para cada ocorrência de igualdade, a linha de venda é adicionada em um array.
     */
            Scanner input = new Scanner(System.in);
            Comissao c = new Comissao();
            List<Venda> vendasNoMes = null;
            List<Venda> vendas = getVendas(ARQ_VENDAS);
            c.setMes(mes);
 
            for (int i=0;i<=vendas.size();i++)
                if (c.getMes() == vendas.get(i).getMes())
                vendasNoMes.add(vendas.get(i));
            return vendasNoMes;  
 }
        
    public List<Venda> getVendasDeVendedores(String codigo, int mes,String ARQ_VENDEDORES, String ARQ_VENDAS) throws acessoArquivoException {
        /* Essa função retorna uma lista das vendas correspondentes aos vendedores com o código informado no paramêtro*/
            List<Venda> vendas = getVendasNoMes(mes,ARQ_VENDAS);
            List<Venda> vendasDeVendedores = null;
            List<Vendedor> vendedores = getVendedores(ARQ_VENDEDORES);
            
            for (int i=0;i<=vendas.size();i++)
                if (codigo.equals(vendedores.get(i).getCodigo()))
                    vendasDeVendedores.add(vendas.get(i));
             return vendasDeVendedores; 
    }
    
    public List<Venda> getVendas(String ARQ_VENDAS) throws acessoArquivoException {
            acessoArquivo accArqVenda = new acessoArquivoVenda();
            List<Venda> listVendas = accArqVenda.ler(new File(ARQ_VENDAS));
            return listVendas;
}
    
    public List<Preco> getPrecos(String ARQ_PRECOS) throws acessoArquivoException {
            acessoArquivo accArqPreco = new acessoArquivoPreco();
            List<Preco> listPrecos = accArqPreco.ler(new File(ARQ_PRECOS));
            return listPrecos;
}
   
    public List<Vendedor> getVendedores(String ARQ_VENDEDORES) throws acessoArquivoException {
            acessoArquivo accArqVendedor = new acessoArquivoVendedor();       
            List<Vendedor> listVendedores = accArqVendedor.ler(new File(ARQ_VENDEDORES));
            return listVendedores;
}
    
    
    @Override
    public void verificarPreCondicoes(String[] campos) throws acessoArquivoException {
        verificarQtdeCamposValidos(campos, numCampos);
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    
    @Override
    public List<Comissao> ler(File file) throws acessoArquivoException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    }
