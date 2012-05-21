/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package trabalho1;

import java.text.DecimalFormat;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Jean
 */
public class CalculoComissao {
    private static final double cat1ValorLimite1 = 1000.00;
    private static final double cat1ValorLimite2 = 1800.00;
    private static final double cat2ValorLimite1 = 2000.00;
    private static final double cat2ValorLimite2 = 4000.00;

    private double precoProdutoANoMes = 0.0;
    private double precoProdutoBNoMes = 0.0;
    private double precoProdutoCNoMes = 0.0;

    public double calculaComissaoCat1(double valorTotalGeral){
        if(valorTotalGeral > cat1ValorLimite2){
            double valorRestante = valorTotalGeral - cat1ValorLimite2;
            return roundTwoDecimals(220 + (valorRestante*0.2));
        }
        else if(valorTotalGeral >= cat1ValorLimite1){
            double valorRestante = valorTotalGeral - cat1ValorLimite1;
            return roundTwoDecimals(100 + (valorRestante*0.15));
        }
        else
            return roundTwoDecimals(valorTotalGeral * 0.1);
        
    }

    public double calculaComissaoCat2(double valorTotalGeral){
        
        if(valorTotalGeral > cat2ValorLimite2)
            return roundTwoDecimals(valorTotalGeral * 0.3);
        
        else if(valorTotalGeral >= cat2ValorLimite1)
            return roundTwoDecimals(valorTotalGeral * 0.2);
        
        else
            return roundTwoDecimals(valorTotalGeral * 0.1);
    }

    public double calculaComissao(int categoriaVendedor, double valorTotalGeral){
        switch (categoriaVendedor){
            case 1:
                return calculaComissaoCat1(valorTotalGeral);
            case 2:
                return calculaComissaoCat2(valorTotalGeral);
            default:
                return 0;
        }
    }

    public double roundTwoDecimals(double d) {
        
        DecimalFormat twoDForm = new DecimalFormat(".00");
        String format = twoDForm.format(d);
        String replace = format.replace(",", ".");
        return Double.valueOf(replace);
        
    }

    public Map<String,Comissao> gerarComissoes(int mes, String arqVendas, String arqPrecos, String arqVendedores, String arqComissao) throws acessoArquivoException{

        acessoArquivoVenda accArqVenda = new acessoArquivoVenda();
        acessoArquivoPreco accArqPreco = new acessoArquivoPreco();
        acessoArquivoVendedor accArqVendedor = new acessoArquivoVendedor();

        List<Venda> listaVenda = accArqVenda.ler(new File(arqVendas));
        List<Preco> listaPreco = accArqPreco.ler(new File(arqPrecos));
        List<Vendedor> listaVendedor = accArqVendedor.ler(new File(arqVendedores));
        Map<String,Comissao> comissoes = new HashMap<String,Comissao>();

        addVendedores(listaVendedor, comissoes, mes);

        setVendasVendedorNoMes(listaVenda, mes, comissoes);

        getPrecosNoMes(listaPreco, mes);

        setValorTotalReais(comissoes);

        Set<String> codigosVendedores = comissoes.keySet();
        for(String s : codigosVendedores){
            if(comissoes.get(s).getCategoria() == 1){
                comissoes.get(s).setComissao(calculaComissao(1, comissoes.get(s).getValorTotalGeral()));
            }
            else if(comissoes.get(s).getCategoria() == 2){
                comissoes.get(s).setComissao(calculaComissao(2, comissoes.get(s).getValorTotalGeral()));
            }
        }
        
        return comissoes;
    }

    public void setValorTotalReais(Map<String, Comissao> comissoes) {
        Set<String> codigosVendedores = comissoes.keySet();
        for (String s : codigosVendedores) {
            comissoes.get(s).setValorTotalProdutoA(roundTwoDecimals(precoProdutoANoMes * comissoes.get(s).getQtdeTotalProdutoA()));
            comissoes.get(s).setValorTotalProdutoB(roundTwoDecimals(precoProdutoBNoMes * comissoes.get(s).getQtdeTotalProdutoB()));
            comissoes.get(s).setValorTotalProdutoC(roundTwoDecimals(precoProdutoCNoMes * comissoes.get(s).getQtdeTotalProdutoC()));
            comissoes.get(s).setValorTotalGeral(roundTwoDecimals(comissoes.get(s).getValorTotalProdutoA() + comissoes.get(s).getValorTotalProdutoB() + comissoes.get(s).getValorTotalProdutoC()));
        }
    }

    public void addVendedores(List<Vendedor> listaVendedor, Map<String, Comissao> comissoes, int mes) {
        for (Vendedor v : listaVendedor) {
            comissoes.put(v.getCodigo(), new Comissao(mes, v.getCodigo(), v.getNome(), v.getCategoria()));
        }
    }

    public void setVendasVendedorNoMes(List<Venda> listaVenda, int mes, Map<String, Comissao> comissoes) {
        for (Venda v : listaVenda) {
            if (v.getMes() == mes) {
                comissoes.get(v.getCodVendedor()).setQtdeTotalProdutoA(comissoes.get(v.getCodVendedor()).getQtdeTotalProdutoA() + v.getQtdeProdutoA());
                comissoes.get(v.getCodVendedor()).setQtdeTotalProdutoB(comissoes.get(v.getCodVendedor()).getQtdeTotalProdutoB() + v.getQtdeProdutoB());
                comissoes.get(v.getCodVendedor()).setQtdeTotalProdutoC(comissoes.get(v.getCodVendedor()).getQtdeTotalProdutoC() + v.getQtdeProdutoC());
            }
        }
    }

    public void getPrecosNoMes(List<Preco> listaPreco, int mes) {
        //get Preco do Produto no Mes
        for (Preco p : listaPreco) {
            int mes1 = p.getMes();
            if (p.getMes() <= mes) {
                precoProdutoANoMes = p.getPrecoProdA();
                precoProdutoBNoMes = p.getPrecoProdB();
                precoProdutoCNoMes = p.getPrecoProdC();
            }
        }
    }
}
