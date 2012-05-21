/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho1;

/**
 *
 * @author Bianca
 */
public class Comissao {
    private int mes;
    private String codigo;
    private String nome;
    private int categoria;
    private int qtdeTotalProdutoA;
    private int qtdeTotalProdutoB;
    private int qtdeTotalProdutoC;
    private double valorTotalProdutoA;
    private double valorTotalProdutoB;
    private double valorTotalProdutoC;
    private double valorTotalGeral;
    private double comissao;



    public Comissao(int mes, String codigo, String nome, int categoria){
        this.mes = mes;
        this.codigo = codigo;
        this.nome = nome;
        this.categoria = categoria;
        this.qtdeTotalProdutoA = 0;
        this.qtdeTotalProdutoB = 0;
        this.qtdeTotalProdutoC = 0;
        this.valorTotalProdutoA = 0.0;
        this.valorTotalProdutoB = 0.0;
        this.valorTotalProdutoC = 0.0;
        this.valorTotalGeral = 0.0;
        this.comissao = 0.0;
    }

    public Comissao(int mes, String codigo, String nome, int categoria, int qtdeTotalProdutoA, int qtdeTotalProdutoB, int qtdeTotalProdutoC, double valorTotalProdutoA, double valorTotalProdutoB, double valorTotalProdutoC, double valorTotalGeral, double comissao) {
        this.mes = mes;
        this.codigo = codigo;
        this.nome = nome;
        this.categoria = categoria;
        this.qtdeTotalProdutoA = qtdeTotalProdutoA;
        this.qtdeTotalProdutoB = qtdeTotalProdutoB;
        this.qtdeTotalProdutoC = qtdeTotalProdutoC;
        this.valorTotalProdutoA = valorTotalProdutoA;
        this.valorTotalProdutoB = valorTotalProdutoB;
        this.valorTotalProdutoC = valorTotalProdutoC;
        this.valorTotalGeral = valorTotalGeral;
        this.comissao = comissao;
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

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }


    public int getQtdeTotalProdutoA() {
        return qtdeTotalProdutoA;
    }

    public void setQtdeTotalProdutoA(int qtdeTotalProdutoA) {
        this.qtdeTotalProdutoA = qtdeTotalProdutoA;
    }

    public int getQtdeTotalProdutoB() {
        return qtdeTotalProdutoB;
    }

    public void setQtdeTotalProdutoB(int qtdeTotalProdutoB) {
        this.qtdeTotalProdutoB = qtdeTotalProdutoB;
    }

    public int getQtdeTotalProdutoC() {
        return qtdeTotalProdutoC;
    }

    public void setQtdeTotalProdutoC(int qtdeTotalProdutoC) {
        this.qtdeTotalProdutoC = qtdeTotalProdutoC;
    }

    public double getValorTotalProdutoA() {
        return valorTotalProdutoA;
    }

    public void setValorTotalProdutoA(double valorTotalProdutoA) {
        this.valorTotalProdutoA = valorTotalProdutoA;
    }

    public double getValorTotalProdutoB() {
        return valorTotalProdutoB;
    }

    public void setValorTotalProdutoB(double valorTotalProdutoB) {
        this.valorTotalProdutoB = valorTotalProdutoB;
    }

    public double getValorTotalProdutoC() {
        return valorTotalProdutoC;
    }

    public void setValorTotalProdutoC(double valorTotalProdutoC) {
        this.valorTotalProdutoC = valorTotalProdutoC;
    }
   
    public double getValorTotalGeral() {
        return valorTotalGeral;
    }

    public void setValorTotalGeral(double valorTotalGeral) {
        this.valorTotalGeral = valorTotalGeral;
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
