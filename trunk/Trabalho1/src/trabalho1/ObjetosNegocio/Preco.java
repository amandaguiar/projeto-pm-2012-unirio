/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package trabalho1.ObjetosNegocio;


import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;



/**
 *
 * @author Amanda
 */
public class Preco {

    private GregorianCalendar data;
    private List<Double> precos;

    public static final int POS_CAT_A = 0;
    public static final int POS_CAT_B = 1;
    public static final int POS_CAT_C = 2;

    public Preco() {
        
    }
    
    public Preco(GregorianCalendar data, List<Double> precos) {
        this.data = data;
        this.data.setLenient(false);
        this.data.get(Calendar.MONTH);  //Inicializar todos os demais campos da Classe GregorianCalendar

        this.precos = precos;
    }

    public GregorianCalendar getData() {
        return data;
    }

    public void setData(GregorianCalendar data) {
        this.data = data;
    }

    public List<Double> getPrecos() {
        return precos;
    }

    public void setPrecos(List<Double> precos) {
        this.precos = precos;
    }

    public int getDia(){
        return this.data.get(GregorianCalendar.DAY_OF_MONTH);
    }

    public int getMes(){
        return (this.data.get(GregorianCalendar.MONTH) + 1);
    }

    public int getAno(){
        return this.data.get(GregorianCalendar.YEAR);
    }

    public Double getPrecoProdA(){
        return this.precos.get(POS_CAT_A);
    }

    public Double getPrecoProdB(){
        return this.precos.get(POS_CAT_B);
    }

    public Double getPrecoProdC(){
        return this.precos.get(POS_CAT_C);
    }
    
    public Double getPrecoPorCategoria(String categoria) {
        if (categoria.equals("A"))
            return this.precos.get(POS_CAT_A);
        if (categoria.equals("B"))
            return this.precos.get(POS_CAT_B);
        if (categoria.equals("C"))
            return this.precos.get(POS_CAT_C);
        return 0.0;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Preco other = (Preco) obj;
        if (this.data != other.data && (this.data == null || !this.data.equals(other.data))) {
            return false;
        }
        if (this.precos != other.precos && (this.precos == null || !this.precos.equals(other.precos))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + (this.data != null ? this.data.hashCode() : 0);
        hash = 61 * hash + (this.precos != null ? this.precos.hashCode() : 0);
        return hash;
    }
}
