/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho1.RegrasCalculo;

/**
 *
 * @author Bianca
 */
public class FaixasValores {
    private double valorLimite;
    private double percentual;
    private double somaParcial;

    public FaixasValores(double valorLimite, double percentual, double somaParcial) {
        this.valorLimite = valorLimite;
        this.percentual = percentual;
        this.somaParcial = somaParcial;
    }
    
    public FaixasValores(double valorLimite, double percentual) {
        this.valorLimite = valorLimite;
        this.percentual = percentual;
        this.somaParcial = 0;
    }
    public double getPercentual() {
        return percentual;
    }

    public void setPercentual(double percentual) {
        this.percentual = percentual;
    }

    public double getValorLimite() {
        return valorLimite;
    }

    public void setValorLimite(double valorLimite) {
        this.valorLimite = valorLimite;
    }

    public double getSomaParcial() {
        return somaParcial;
    }
    
}
