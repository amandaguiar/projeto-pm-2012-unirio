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
public class Venda {
    private String data;
    private String codVendedor;
    private List<Integer> qtdeProdutos;

    public Venda(String data, String codVendedor, List<Integer> qtdeProdutos) {
        this.data = data;
        this.codVendedor = codVendedor;
        this.qtdeProdutos = qtdeProdutos;
    }

    public String getCodVendedor() {
        return codVendedor;
    }

    public void setCodVendedor(String codVendedor) {
        this.codVendedor = codVendedor;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public List<Integer> getQtdeProdutos() {
        return qtdeProdutos;
    }

    public void setQtdeProdutos(List<Integer> qtdeProdutos) {
        this.qtdeProdutos = qtdeProdutos;
    }


}
