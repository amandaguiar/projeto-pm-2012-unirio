/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package trabalho1;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 *
 * @author Jean
 */
public class Venda {
    private GregorianCalendar data;
    private String codVendedor;
    private List<Integer> qtdeProdutos;

    public Venda(GregorianCalendar data, String codVendedor, List<Integer> qtdeProdutos) {
        this.data = data;
        this.data.setLenient(false);     
        this.data.get(Calendar.MONTH);  //Inicializar todos os demais campos da Classe GregorianCalendar
        
        this.codVendedor = codVendedor;
        this.qtdeProdutos = qtdeProdutos;
    }

    Venda() {
        this.data = null;
        this.codVendedor = null;
        this.qtdeProdutos = null;
    }

    public String getCodVendedor() {
        return codVendedor;
    }

    public void setCodVendedor(String codVendedor) {
        this.codVendedor = codVendedor;
    }

    public GregorianCalendar getData() {
        return data;
    }

    public int getDia(){
        return data.get(Calendar.DAY_OF_MONTH);
    }

    public int getMes(){
        return data.get(Calendar.MONTH) + 1;
    }

    public int getAno(){
        return data.get(Calendar.YEAR);
    }

    public int getQtdeProdutoA(){
        return qtdeProdutos.get(0);
    }

    public int getQtdeProdutoB(){
        return qtdeProdutos.get(1);
    }

    public int getQtdeProdutoC(){
        return qtdeProdutos.get(2);
    }

    public void setData(GregorianCalendar data) {
        this.data = data;
    }

    public List<Integer> getQtdeProdutos() {
        return qtdeProdutos;
    }

    public void setQtdeProdutos(List<Integer> qtdeProdutos) {
        this.qtdeProdutos = qtdeProdutos;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Venda other = (Venda) obj;
        if (this.data != other.data && (this.data == null || !this.data.equals(other.data))) {
            return false;
        }
        if ((this.codVendedor == null) ? (other.codVendedor != null) : !this.codVendedor.equals(other.codVendedor)) {
            return false;
        }
        if (this.qtdeProdutos != other.qtdeProdutos && (this.qtdeProdutos == null || !this.qtdeProdutos.equals(other.qtdeProdutos))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + (this.data != null ? this.data.hashCode() : 0);
        hash = 61 * hash + (this.codVendedor != null ? this.codVendedor.hashCode() : 0);
        hash = 61 * hash + (this.qtdeProdutos != null ? this.qtdeProdutos.hashCode() : 0);
        return hash;
    }


}
