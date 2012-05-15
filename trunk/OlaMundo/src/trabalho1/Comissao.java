/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package trabalho1;

import java.util.List;

/**
 *
 * @author Jean
 */
public class Comissao {
    private int mes;
    private String codVendedor;
    private String nomeVendedor;
    private List<Double> valorTotalProdutos;
    private double valorTotalGeral;
    private double comissao;

    public Comissao(int mes, String codVendedor, String nomeVendedor, List<Double> valorTotalProdutos, double valorTotalGeral, double comissao) {
        this.mes = mes;
        this.codVendedor = codVendedor;
        this.nomeVendedor = nomeVendedor;
        this.valorTotalProdutos = valorTotalProdutos;
        this.valorTotalGeral = valorTotalGeral;
        this.comissao = comissao;
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
}
