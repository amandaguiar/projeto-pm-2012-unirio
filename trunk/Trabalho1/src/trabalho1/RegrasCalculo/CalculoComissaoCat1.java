/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho1.RegrasCalculo;

import java.util.ListIterator;


/**
 *
 * @author Bianca
 */
public class CalculoComissaoCat1{

//    public CalculoComissaoCat1() {
//    }
    public static final int NUM_FAIXAS = 3;
    private FaixasValores[] faixasCat1 = new FaixasValores[NUM_FAIXAS];
    
    void criarFaixas(){
        faixasCat1[0] = new FaixasValores(1000.0, 0.1, 100.0);
        faixasCat1[1] = new FaixasValores(1800.0, 0.15, 120.0);
        faixasCat1[2] = new FaixasValores(Double.MAX_VALUE, 0.2, ((Double.MAX_VALUE-1800)*0.2) );
    }

    public double calculaComissao(double valorTotalGeral) {
        this.criarFaixas();
        double somaParcial = 0.0;
        double auxiliar = 0;
        int tam = faixasCat1.length;
        for(int i = 0; i < tam; i++){
            if(valorTotalGeral <= faixasCat1[i].getValorLimite()){
                if(i==0){
                    somaParcial = valorTotalGeral * faixasCat1[0].getPercentual();
                }
                else{
                    auxiliar = (valorTotalGeral - faixasCat1[i-1].getValorLimite()) * faixasCat1[i].getPercentual();
                    for(int j=i-1; j==0; j--){
                    somaParcial = somaParcial + faixasCat1[j].getSomaParcial();
                    }
                    somaParcial = somaParcial + auxiliar;
                }
            }
        }
        return CalculoUtils.roundTwoDecimals(somaParcial);
        }
        
    }
