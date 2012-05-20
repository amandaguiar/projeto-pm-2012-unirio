/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho1;

import java.util.List;

/**
 *
 * @author Bianca
 */
public class Comissao {
    private int mes;
    private String codigo;
    private String nome;
    private List<Integer> qtdTotalProduto;
    private List<Double> valorTotalProduto;
    private double valorTotalGeral;
    private double comissao;

    public Comissao(int mes, String codigo, String nome, List<Double> valorTotalProduto, double valorTotalGeral, double comissao) {
        this.mes = mes;
        this.codigo = codigo;
        this.nome = nome;
        this.valorTotalProduto = valorTotalProduto;
        this.valorTotalGeral = valorTotalGeral;
        this.comissao = comissao;
    }

    public Comissao() {
        this.mes = 0;
        this.codigo = "";
        this.nome = "";
        this.valorTotalProduto = null;
        this.valorTotalGeral = 0.0;
        this.comissao = 0.0;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Integer> getQtdTotalProduto() {
        return qtdTotalProduto;
    }

    public void setQtdTotalProduto(List<Integer> qtdTotalProduto) {
        this.qtdTotalProduto = qtdTotalProduto;
    }
    
    public double getValorTotalGeral() {
        return valorTotalGeral;
    }

    public void setValorTotalGeral(double valorTotalGeral) {
        this.valorTotalGeral = valorTotalGeral;
    }

    public List<Double> getValorTotalProduto() {
        return valorTotalProduto;
    }

    public void setValorTotalProduto(List<Double> valorTotalProduto) {
        this.valorTotalProduto = valorTotalProduto;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Comissao other = (Comissao) obj;
        if ((this.codigo == null) ? (other.codigo != null) : !this.codigo.equals(other.codigo)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + (this.codigo != null ? this.codigo.hashCode() : 0);
        return hash;
    }
       
}
