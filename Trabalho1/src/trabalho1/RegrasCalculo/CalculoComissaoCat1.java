/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho1.RegrasCalculo;

/**
 *
 * @author Bianca
 */
public class CalculoComissaoCat1{

    public static final int NUM_FAIXAS = 3;
    private FaixasValores[] faixasCat1 = new FaixasValores[NUM_FAIXAS];
    
    void criarFaixas(){
        faixasCat1[0] = new FaixasValores(1000.0, 0.1, 0.0);
        faixasCat1[1] = new FaixasValores(1800.0, 0.15, 100.0);
        faixasCat1[2] = new FaixasValores(Double.MAX_VALUE, 0.2, 220);
    }

    public double calculaComissao(double valorTotalGeral) {
        this.criarFaixas();
        double valorComissao = 0.0;
        int tam = faixasCat1.length;
        for(int i = 0; i < tam; i++){
            if(valorTotalGeral < faixasCat1[i].getValorLimite()){
                if(i==0){
                    valorComissao = valorTotalGeral * faixasCat1[0].getPercentual();
                    break;
                }
                else if(valorTotalGeral >= faixasCat1[i-1].getValorLimite()){
                    valorComissao = (valorTotalGeral - faixasCat1[i-1].getValorLimite()) * faixasCat1[i].getPercentual() + faixasCat1[i].getSomaParcial();
                    break;
                }
            }
        }
        return CalculoUtils.roundTwoDecimals(valorComissao);
        }
        
    }
