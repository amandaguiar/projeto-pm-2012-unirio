/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package trabalho1;

import java.text.DecimalFormat;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

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

    public void gerarComissao(int mes, String arqVendas, String arqPrecos, String arqVendedores, String arqComissao) throws acessoArquivoException{      
        
        acessoArquivoVenda accArqVenda = new acessoArquivoVenda();
        acessoArquivoPreco accArqPreco = new acessoArquivoPreco();        
        acessoArquivoVendedor accArqVendedor = new acessoArquivoVendedor();
        //acessoArquivoComissao accArqComissao = new acessoArquivoComissao();
        
        List<Venda> listaVenda = new ArrayList<Venda>();
        List<Preco> listaPreco = new ArrayList<Preco>();
        List<Vendedor> listaVendedor = new ArrayList<Vendedor>();               
        //Comissao comissao = new Comissao();        
        
        listaVenda = accArqVenda.ler(new File(arqVendas));                
        for (int i = 0; i < listaVenda.size(); i++)
            if (mes != listaVenda.get(i).getMes())
            listaVenda.remove(listaVenda.get(i));
        
        listaPreco = accArqPreco.ler(new File(arqPrecos));
        for (int i = 0; i < listaPreco.size(); i++)
            if (mes != listaPreco.get(i).getMes())
            listaPreco.remove(listaPreco.get(i));        
        
        listaVendedor = accArqVendedor.ler(new File(arqVendedores));
        
        int categoria = 0;
        String codigo = "";
        for (int i = 0; i < listaVendedor.size(); i++){
            categoria = listaVendedor.get(i).getCategoria();
            codigo = listaVendedor.get(i).getCodigo();
            if (categoria == 1){
                //comissao.calculaComissaoCat1();
            }                       
            if (categoria == 2) {
                //comissao.calculaComissaoCat2();
            }
        }
    }
    
}
