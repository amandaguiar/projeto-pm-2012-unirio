/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package trabalho1.ObjetosNegocio;

public class Vendedor {
    
    private String codigo;
    private String nome;
    private int categoria;
    
    public Vendedor() {
        
    }
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

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vendedor other = (Vendedor) obj;
        if ((this.codigo == null) ? (other.codigo != null) : !this.codigo.equals(other.codigo)) {
            return false;
        }
        if ((this.nome == null) ? (other.nome != null) : !this.nome.equals(other.nome)) {
            return false;
        }
        if (this.categoria != other.categoria) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + (this.codigo != null ? this.codigo.hashCode() : 0);
        hash = 53 * hash + (this.nome != null ? this.nome.hashCode() : 0);
        hash = 53 * hash + this.categoria;
        return hash;
    }
}
