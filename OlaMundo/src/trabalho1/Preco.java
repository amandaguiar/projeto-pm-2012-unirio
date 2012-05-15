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
public class Preco {
    private String data;
    private List<Double> precos;

    public Preco(String data, List<Double> precos) {
        this.data = data;
        this.precos = precos;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public List<Double> getPrecos() {
        return precos;
    }

    public void setPrecos(List<Double> precos) {
        this.precos = precos;
    }

}
