/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package trabalho1;

import java.text.DecimalFormat;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Jean
 */
public class CalculoComissao {
    private static final double cat1ValorLimite1 = 1000.00;
    private static final double cat1ValorLimite2 = 1800.00;
    private static final double cat2ValorLimite1 = 2000.00;
    private static final double cat2ValorLimite2 = 4000.00;

    public static double getValorTotalGeral(List<Double> valorTotalProdutos) {
        double valorTotalGeral = 0.0;
        Iterator it = valorTotalProdutos.iterator();
        while(it.hasNext()){
            valorTotalGeral = valorTotalGeral + Double.parseDouble(it.next().toString());
        }
        return valorTotalGeral;
    }

    public static double calculaComissaoCat1(double valorTotalGeral){
        double comissao;
        if(valorTotalGeral >= cat1ValorLimite2){
            double valorRestante = valorTotalGeral - cat1ValorLimite2;
            comissao = 220 + (valorRestante*0.2);
            return comissao;
        }
        else if(valorTotalGeral >= cat1ValorLimite1){
            double valorRestante = valorTotalGeral - cat1ValorLimite1;
            comissao = 100 + (valorRestante*0.15);
            return comissao;
        }
        else{
            comissao = valorTotalGeral * 0.1;
            return comissao;
        }
    }

    public static double calculaComissaoCat2(double valorTotalGeral){
        double comissao;
        if(valorTotalGeral > cat2ValorLimite2){
        comissao = valorTotalGeral * 0.3;
        return comissao;
        }
        else if(valorTotalGeral >= cat2ValorLimite1){
        comissao = valorTotalGeral * 0.2;
        return comissao;
        }
        else{
        comissao = valorTotalGeral * 0.1;
        return comissao;
        }
    }

    public static double calculaComissao(int categoriaVendedor, double valorTotalGeral){
        switch (categoriaVendedor){
            case 1:
                return calculaComissaoCat1(valorTotalGeral);
            case 2:
                return calculaComissaoCat2(valorTotalGeral);
            default:
                return 0;
        }
    }

    public static double roundTwoDecimals(double d) {
            DecimalFormat twoDForm = new DecimalFormat("#.##");
        return Double.valueOf(twoDForm.format(d));
    }

    public Map<String,Comissao> gerarComissoes(int mes, String arqVendas, String arqPrecos, String arqVendedores, String arqComissao) throws acessoArquivoException{

        acessoArquivoVenda accArqVenda = new acessoArquivoVenda();
        acessoArquivoPreco accArqPreco = new acessoArquivoPreco();
        acessoArquivoVendedor accArqVendedor = new acessoArquivoVendedor();
        acessoArquivoComissao accArqComissao = new acessoArquivoComissao();

        List<Venda> listaVenda = new ArrayList<Venda>();
        List<Preco> listaPreco = new ArrayList<Preco>();
        List<Vendedor> listaVendedor = new ArrayList<Vendedor>();
        Map<String,Comissao> comissoes = new HashMap<String,Comissao>();



        listaVenda = accArqVenda.ler(new File(arqVendas));
        for (int i = 0; i < listaVenda.size(); i++)
            if (mes != listaVenda.get(i).getMes())
            listaVenda.remove(listaVenda.get(i));

        listaPreco = accArqPreco.ler(new File(arqPrecos));
        for (int i = 0; i < listaPreco.size(); i++)
            if (mes != listaPreco.get(i).getMes())
            listaPreco.remove(listaPreco.get(i));

        listaVendedor = accArqVendedor.ler(new File(arqVendedores));


        int quantidadeTotalA = 0;
        int quantidadeTotalB = 0;
        int quantidadeTotalC = 0;

        int categoria = 0;
        String codigo = "";
        for (int i = 0; i < listaVendedor.size(); i++){
            categoria = listaVendedor.get(i).getCategoria();
            codigo = listaVendedor.get(i).getCodigo();
            Comissao com = new Comissao();
            for (Iterator<Venda> it = listaVenda.iterator(); it.hasNext();) {
                Venda v = it.next();
                if(codigo.equals(v.getCodVendedor())) {
                    quantidadeTotalA += v.getQtdeProdutoA();
                    quantidadeTotalB += v.getQtdeProdutoB();
                    quantidadeTotalC += v.getQtdeProdutoC();
                }
            }
                com.getQtdTotalProduto().add(quantidadeTotalA);
                com.getQtdTotalProduto().add(quantidadeTotalB);
                com.getQtdTotalProduto().add(quantidadeTotalC);
                com.setMes(mes);
                com.setCodigo(codigo);
                com.setNome(listaVendedor.get(i).getNome());
        }
        return comissoes;
    }

}
