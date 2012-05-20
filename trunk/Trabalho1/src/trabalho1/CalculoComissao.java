/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package trabalho1;

import java.util.Iterator;
import java.util.List;

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
}
