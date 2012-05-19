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
public class Comissao {
    private int mes;
    private String codVendedor;
    private String nomeVendedor;
    private int categoriaVendedor;
    private List<Double> valorTotalProdutos;
    private double valorTotalGeral;
    private double comissao;
    private final double cat1ValorLimite1 = 1000;
    private final double cat1ValorLimite2 = 1800;
    private final double cat2ValorLimite1 = 2000;
    private final double cat2ValorLimite2 = 4000;

    public Comissao(int mes, String codVendedor, String nomeVendedor, int categoriaVendedor, List<Double> valorTotalProdutos, double valorTotalGeral, double comissao) {
        this.mes = mes;
        this.codVendedor = codVendedor;
        this.nomeVendedor = nomeVendedor;
        this.valorTotalProdutos = valorTotalProdutos;
        this.valorTotalGeral = valorTotalGeral;
        this.comissao = comissao;
        this.categoriaVendedor = categoriaVendedor;
    }
    
    public Comissao(){
        this.mes = 0;
        this.codVendedor = null;
        this.nomeVendedor = null;
        this.valorTotalProdutos = null;
        this.valorTotalGeral = 0.0;
        this.comissao = 0.0;
        this.categoriaVendedor = 0;
    }

    public String getCodVendedor() {
        return codVendedor;
    }

    public void setCodVendedor(String codVendedor) {
        this.codVendedor = codVendedor;
    }

    public double getComissao() {
        return comissao;
    }

    public void setComissao(double comissao) {
        this.comissao = comissao;
    }

    public int getCategoriaVendedor() {
        return categoriaVendedor;
    }

    public void setCategoriaVendedor(int categoriaVendedor) {
        this.categoriaVendedor = categoriaVendedor;
    }
    
    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public String getNomeVendedor() {
        return nomeVendedor;
    }

    public void setNomeVendedor(String nomeVendedor) {
        this.nomeVendedor = nomeVendedor;
    }

    public double getValorTotalGeral() {
        valorTotalGeral = 0.0;
        Iterator it = valorTotalProdutos.iterator();
        while(it.hasNext()){
            valorTotalGeral = valorTotalGeral + Double.parseDouble(it.next().toString());
        }
        return valorTotalGeral;
    }

    public void setValorTotalGeral(double valorTotalGeral) {
        this.valorTotalGeral = valorTotalGeral;
    }

    public List<Double> getValorTotalProdutos() {
        return valorTotalProdutos;
    }

    public void setValorTotalProdutos(List<Double> valorTotalProdutos) {
        this.valorTotalProdutos = valorTotalProdutos;
    }
    
    public double calculaComissaoCat1(){
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
    
    public double calculaComissaoCat2(){
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
    
    public double calculaComissao(){
        switch (categoriaVendedor){
            case 1:
                return calculaComissaoCat1();
            case 2:
                return calculaComissaoCat2();
            default:
                return 0;
        }
    }
}
