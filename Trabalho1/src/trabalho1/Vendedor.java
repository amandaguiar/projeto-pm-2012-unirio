/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package trabalho1;

/**
 *
 * @author Jean
 */
public class Vendedor {
    private String cod;
    private String nome;
    private int categoria;

    public Vendedor(String cod, String nome, int categoria) {
        this.cod = cod;
        this.nome = nome;
        this.categoria = categoria;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
