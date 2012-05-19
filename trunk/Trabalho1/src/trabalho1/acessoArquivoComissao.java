/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package trabalho1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
   
    
    
    public List<Venda> getVendasNoMes() throws FileNotFoundException, acessoArquivoException {
        /* Essa função compara o mês entrado com os meses presentes no arquivo de venda.
     * Para cada ocorrência de igualdade, a linha de venda é adicionada em um array.
     */
            Scanner input = new Scanner(System.in);
            Comissao c = new Comissao();
            List<Venda> vendasNoMes = null;
            List<Venda> vendas = getVendas();
            System.out.println("Mes: ");
            int mes = input.nextInt();
            c.setMes(mes);
 
            for (int i=0;i<=vendas.size();i++)
                if (c.getMes() == vendas.get(i).getMes())
                vendasNoMes.add(vendas.get(i));
            return vendasNoMes;  
 }
    
    public List<Venda> getVendasDeVendedores(String codigo) throws FileNotFoundException, acessoArquivoException {
        /* Essa função retorna uma lista das vendas correspondentes aos vendedores com o código informado no paramêtro*/
            List<Venda> vendas = getVendasNoMes();
            List<Venda> vendasDeVendedores = null;
            List<Vendedor> vendedores = getVendedores();
            
            for (int i=0;i<=vendas.size();i++)
                if (codigo.equals(vendedores.get(i).getCodigo()))
                    vendasDeVendedores.add(vendas.get(i));
             return vendasDeVendedores; 
    }
    
    public List<Venda> getVendas() throws FileNotFoundException, acessoArquivoException {
            acessoArquivo accArqVenda = new acessoArquivoVenda();
            Scanner input = new Scanner(System.in);
            System.out.println("Nome do arquivo de vendas: ");
            String ARQ_VENDAS = input.nextLine();
         try {
            List<Venda> listVendas = accArqVenda.ler(new FileReader(new File(ARQ_VENDAS)));
            return listVendas;       
        }catch (acessoArquivoException ex) {
            throw new acessoArquivoException("Erro ao tentar acessar o arquivo de Vendas");
        }catch (FileNotFoundException ex) {
            throw new FileNotFoundException("Arquivo nao encontrado");
    }
}
    
    public List<Preco> getPrecos() throws FileNotFoundException, acessoArquivoException {
            acessoArquivo accArqPreco = new acessoArquivoPreco();
            Scanner input = new Scanner(System.in);
            System.out.println("Nome do arquivo de precos: ");
            String ARQ_PRECOS = input.nextLine();
        try {
            List<Preco> listPrecos = accArqPreco.ler(new FileReader(new File(ARQ_PRECOS)));
            return listPrecos;       
        }catch (acessoArquivoException ex) {
            throw new acessoArquivoException("Erro ao tentar acessar o arquivo de Precos");
        }catch (FileNotFoundException ex) {
            throw new FileNotFoundException("Arquivo nao encontrado");
    }
}
   
    public List<Vendedor> getVendedores() throws FileNotFoundException, acessoArquivoException {
            acessoArquivo accArqVendedor = new acessoArquivoVendedor();
            Scanner input = new Scanner(System.in);
            System.out.println("Nome do arquivo de vendedores: ");
            String ARQ_VENDEDORES = input.nextLine();
        try {
            List<Vendedor> listVendedores = accArqVendedor.ler(new FileReader(new File(ARQ_VENDEDORES)));
            return listVendedores;       
    }catch (acessoArquivoException ex) {
        throw new acessoArquivoException("Erro ao tentar acessar o arquivo de Vendedores");
    }catch (FileNotFoundException ex) {
        throw new FileNotFoundException("Arquivo nao encontrado");
    }
}
    
    @Override
    public void verificarPreCondicoes(String[] campos) throws acessoArquivoException {
        verificarQtdeCamposValidos(campos, numCampos);
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    
    @Override
    public List<Comissao> ler(FileReader file) throws acessoArquivoException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}