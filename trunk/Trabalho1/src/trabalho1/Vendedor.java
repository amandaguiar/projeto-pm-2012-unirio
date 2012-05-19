/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package trabalho1;

public class Vendedor {
    
    private String codigo;
    private String nome;
    private int categoria;

    public Vendedor(String codigo, String nome, int categoria) {
        this.codigo = codigo;
        this.nome = nome;
        this.categoria = categoria;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
