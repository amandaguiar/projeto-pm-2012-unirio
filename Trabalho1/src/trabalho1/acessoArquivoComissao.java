/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package trabalho1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Bianca e Filipe
 */
public class acessoArquivoComissao extends acessoArquivo {

public static final String DELIMITADOR = ";";
public static final int numCampos = 8;

public List<Venda> getVendasNoMes(int mes, String ARQ_VENDAS) throws acessoArquivoException {
    /* Essa função compara o mês entrado com os meses presentes no arquivo de venda.
    * Para cada ocorrência de igualdade, a linha de venda é adicionada em um array.
    */
        List<Venda> vendasNoMes = null;
        List<Venda> vendas = getVendas(ARQ_VENDAS);

        for (int i=0;i<vendas.size();i++)
            if (mes == vendas.get(i).getMes())
            vendasNoMes.add(vendas.get(i));
        return vendasNoMes;  
}

//public List<Double> getPrecosTotaisDeVenda(int mes,String ARQ_VENDAS,String ARQ_PRECOS) throws acessoArquivoException {
//    List<Venda> vendas = getVendas(ARQ_VENDAS);
//    List<Preco> preco = getPrecos(ARQ_PRECOS);
//    List<Preco> precoNoMes = null;
//    List<Double> precosTotais = null;
//    double precoTotalA;
//    double precoTotalB;
//    double precoTotalC;
//
//    for (int i=0;i<preco.size();i++) 
//        if(mes == preco.get(i).getMes())
//            precoNoMes.add(preco.get(i));
//
//    for(int i=0;i<vendas.size();i++)
//        if(vendas.get(i).getMes() == precoNoMes.get(0).getMes()){
//            precoTotalA = vendas.get(i).getQtdeProdutoA()*precoNoMes.get(0).getPrecoProdA();
//            precoTotalB = vendas.get(i).getQtdeProdutoB()*precoNoMes.get(0).getPrecoProdB();
//            precoTotalC = vendas.get(i).getQtdeProdutoC()*precoNoMes.get(0).getPrecoProdC();
//
//            precosTotais.add(precoTotalA);
//            precosTotais.add(precoTotalB);
//            precosTotais.add(precoTotalC);
//
//    }
//        return precosTotais;
//}


public List<Integer> getQuantidadeProdutosVendidosMes(int mes,String codigo, String ARQ_VENDAS, String ARQ_VENDEDORES) throws acessoArquivoException {
    List<Venda> vendas = getVendasDeVendedoresNoMes(mes,codigo,ARQ_VENDEDORES,ARQ_VENDAS);
    List<Integer> qtdTotalProd = null;
    
    int quantidadeTotalA = 0;
    int quantidadeTotalB = 0;
    int quantidadeTotalC = 0;
    
    for(int i=0;i<vendas.size();i++) {
        quantidadeTotalA += vendas.get(i).getQtdeProdutoA();
        quantidadeTotalB += vendas.get(i).getQtdeProdutoB();
        quantidadeTotalC += vendas.get(i).getQtdeProdutoC();
    } 
    
        qtdTotalProd.add(quantidadeTotalA);
        qtdTotalProd.add(quantidadeTotalB);
        qtdTotalProd.add(quantidadeTotalC);
        
        return qtdTotalProd;
}

public List<Double> getPrecosTotaisDeVendaDosVendedores(int mes,String codigo, String ARQ_VENDAS,String ARQ_PRECOS, String ARQ_VENDEDORES) throws acessoArquivoException {
    List<Venda> vendas = getVendasDeVendedoresNoMes(mes,codigo,ARQ_VENDEDORES,ARQ_VENDAS);
    List<Integer> qtdTotalProd = getQuantidadeProdutosVendidosMes(mes,codigo,ARQ_VENDAS,ARQ_VENDEDORES);
    List<Preco> preco = getPrecos(ARQ_PRECOS);
    List<Preco> precoNoMes = null;
    List<Double> precosTotais = null;
    double precoTotalA = 0.0;
    double precoTotalB = 0.0;
    double precoTotalC = 0.0;

    for (int i=0;i<preco.size();i++) 
        if(mes == preco.get(i).getMes())
            precoNoMes.add(preco.get(i));

    for(int i=0;i<qtdTotalProd.size();i++)
        if(vendas.get(i).getMes() == precoNoMes.get(0).getMes()){
            precoTotalA = qtdTotalProd.get(i)*precoNoMes.get(0).getPrecoProdA();
            precoTotalB = qtdTotalProd.get(i)*precoNoMes.get(0).getPrecoProdB();
            precoTotalC = qtdTotalProd.get(i)*precoNoMes.get(0).getPrecoProdC();
    }
            precosTotais.add(precoTotalA);
            precosTotais.add(precoTotalB);
            precosTotais.add(precoTotalC);
           
        return precosTotais;
}
        
public List<Venda> getVendasDeVendedoresNoMes(int mes,String codigo,String ARQ_VENDEDORES, String ARQ_VENDAS) throws acessoArquivoException {
    /* Essa função retorna uma lista das vendas correspondentes aos vendedores com o código informado no paramêtro*/
        List<Venda> vendas = getVendasNoMes(mes,ARQ_VENDAS);
        List<Venda> vendasDeVendedores = null;
        List<Vendedor> vendedores = getVendedores(ARQ_VENDEDORES);

        for (int i=0;i<vendas.size();i++)
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
}


@Override
public List<Comissao> ler(File file) throws acessoArquivoException {
    throw new UnsupportedOperationException("Not supported yet.");
}


     public void escrever(int mes, String ARQ_VENDAS, String ARQ_PRECOS, String ARQ_VENDEDORES,String ARQ_COMISSAO) throws acessoArquivoException {
         BufferedWriter writer = null;
     
         try {
              try {
                  writer = new BufferedWriter(new FileWriter(new File(ARQ_COMISSAO)),4096);
                
                 
              } finally {
                  if (writer != null)
                      writer.close();
              }
          } catch (IOException e) {
              throw new acessoArquivoException("Erro ao escrever arquivo!");
          }
     }
}
    
