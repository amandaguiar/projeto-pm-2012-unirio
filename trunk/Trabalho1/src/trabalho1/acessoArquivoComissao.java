/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Bianca e Filipe
 */
public class acessoArquivoComissao extends acessoArquivo {

    public static final String DELIMITADOR = ";";
    public static final int numCampos = 8;

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
//    public List<Integer> getQuantidadeProdutosVendidosMes(int mes, String codigo, String ARQ_VENDAS, String ARQ_VENDEDORES) throws acessoArquivoException {
//        List<Venda> vendas = getVendasDeVendedoresNoMes(mes, codigo, ARQ_VENDEDORES, ARQ_VENDAS);
//        List<Integer> qtdTotalProd = null;
//
//        int quantidadeTotalA = 0;
//        int quantidadeTotalB = 0;
//        int quantidadeTotalC = 0;
//
//        for (int i = 0; i < vendas.size(); i++) {
//            quantidadeTotalA += vendas.get(i).getQtdeProdutoA();
//            quantidadeTotalB += vendas.get(i).getQtdeProdutoB();
//            quantidadeTotalC += vendas.get(i).getQtdeProdutoC();
//        }
//
//        qtdTotalProd.add(quantidadeTotalA);
//        qtdTotalProd.add(quantidadeTotalB);
//        qtdTotalProd.add(quantidadeTotalC);
//
//        return qtdTotalProd;
//    }
//
//    public List<Double> getPrecosTotaisDeVendaDosVendedores(int mes, String codigo, String ARQ_VENDAS, String ARQ_PRECOS, String ARQ_VENDEDORES) throws acessoArquivoException {
//        List<Venda> vendas = getVendasDeVendedoresNoMes(mes, codigo, ARQ_VENDEDORES, ARQ_VENDAS);
//        List<Integer> qtdTotalProd = getQuantidadeProdutosVendidosMes(mes, codigo, ARQ_VENDAS, ARQ_VENDEDORES);
//        List<Preco> preco = getPrecos(ARQ_PRECOS);
//        List<Preco> precoNoMes = null;
//        List<Double> precosTotais = null;
//        double precoTotalA = 0.0;
//        double precoTotalB = 0.0;
//        double precoTotalC = 0.0;
//
//        for (int i = 0; i < preco.size(); i++) {
//            if (mes == preco.get(i).getMes()) {
//                precoNoMes.add(preco.get(i));
//            }
//        }
//
//        for (int i = 0; i < qtdTotalProd.size(); i++) {
//            if (vendas.get(i).getMes() == precoNoMes.get(0).getMes()) {
//                precoTotalA = qtdTotalProd.get(i) * precoNoMes.get(0).getPrecoProdA();
//                precoTotalB = qtdTotalProd.get(i) * precoNoMes.get(0).getPrecoProdB();
//                precoTotalC = qtdTotalProd.get(i) * precoNoMes.get(0).getPrecoProdC();
//            }
//        }
//        precosTotais.add(precoTotalA);
//        precosTotais.add(precoTotalB);
//        precosTotais.add(precoTotalC);
//
//        return precosTotais;
//    }

    @Override
    public void verificarPreCondicoes(String[] campos) throws acessoArquivoException {
        verificarQtdeCamposValidos(campos, numCampos);
    }

    @Override
    public List<CalculoComissao> ler(File file) throws acessoArquivoException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void escrever(Map<String, Comissao> comissoes, String ARQUIVO_COMISSAO) throws acessoArquivoException {
        BufferedWriter writer = null;

        try {
            try {
                writer = new BufferedWriter(new FileWriter(new File(ARQUIVO_COMISSAO)), 4096);
                
                Set<String> keySet = comissoes.keySet();
                for(String s: keySet){
                    Comissao comissao = comissoes.get(s); 
                    
                    int mes = comissao.getMes();
                    String codigo = comissao.getCodigo();
                    String nome = comissao.getNome();
                    Double valorTotalA = comissao.getValorTotalProdutoA();
                    Double valorTotalB = comissao.getValorTotalProdutoB();
                    Double valorTotalC = comissao.getValorTotalProdutoC();
                    Double valorTotalGeral = comissao.getValorTotalGeral();
                    Double valorComissao = comissao.getComissao();
                    
                    writer.write(Integer.toString(mes) + ";" + 
                                codigo + ";" + nome + ";" + 
                                Double.toString(valorTotalA) + ";" +
                                Double.toString(valorTotalB) + ";" + 
                                Double.toString(valorTotalC) + ";" + 
                                Double.toString(valorTotalGeral) + ";" + 
                                Double.toString(valorComissao));
                    
                    writer.newLine();
                }

            } finally {
                if (writer != null) {
                    writer.close();
                }
            }
        } catch (IOException e) {
            throw new acessoArquivoException("Erro ao escrever arquivo!");
        }
    }
}
