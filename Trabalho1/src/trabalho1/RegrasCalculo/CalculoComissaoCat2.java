/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho1.RegrasCalculo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Bianca
 */
public class CalculoComissaoCat2 {
    
    private FaixasValores[] faixasCat2;
    
    public void criaFaixas(){
    faixasCat2[0] = new FaixasValores(2000.0, 0.1);
    faixasCat2[1] = new FaixasValores(4000.0, 0.2);
    faixasCat2[2] = new FaixasValores(Double.MAX_VALUE, 0.3);
    }

    public double CalculaComissao(double valorTotalGeral) {
        this.criaFaixas();
        double valorComissao = 0.0;
        for(int i=0; i< faixasCat2.length; i++){
        if(valorTotalGeral <= faixasCat2[i].getValorLimite())
            return CalculoUtils.roundTwoDecimals(valorTotalGeral * faixasCat2[i].getPercentual());
        }
        return CalculoUtils.roundTwoDecimals(valorComissao);
    }
    
}
