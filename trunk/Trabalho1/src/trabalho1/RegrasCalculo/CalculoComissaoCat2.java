/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho1.RegrasCalculo;

/**
 *
 * @author Bianca
 */
public class CalculoComissaoCat2 {
    
    public static final int NUM_FAIXAS = 3;
    private FaixasValores[] faixasCat2 = new FaixasValores[NUM_FAIXAS];
    
    public void criaFaixas(){
        faixasCat2[0] = new FaixasValores(2000.00, 0.1);
        faixasCat2[1] = new FaixasValores(4001.00, 0.2);
        faixasCat2[2] = new FaixasValores(Double.MAX_VALUE, 0.3);
    }

    public double calculaComissao(double valorTotalGeral) {
        this.criaFaixas();
        double valorComissao = 0.0;
        for(int i=0; i < faixasCat2.length; i++){
            if(valorTotalGeral < faixasCat2[i].getValorLimite())
                return CalculoUtils.roundTwoDecimals(valorTotalGeral * faixasCat2[i].getPercentual());
        }
        return CalculoUtils.roundTwoDecimals(valorComissao);
    }
    
}
