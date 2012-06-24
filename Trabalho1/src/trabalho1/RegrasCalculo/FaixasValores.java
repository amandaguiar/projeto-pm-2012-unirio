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
    private double SomaParcial;

    public FaixasValores(double valorLimite, double percentual, double SomaParcial) {
        this.valorLimite = valorLimite;
        this.percentual = percentual;
        this.SomaParcial = SomaParcial;
    }
    
    public FaixasValores(double valorLimite, double percentual) {
        this.valorLimite = valorLimite;
        this.percentual = percentual;
        this.SomaParcial = 0;
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
        return SomaParcial;
    }
    
}
