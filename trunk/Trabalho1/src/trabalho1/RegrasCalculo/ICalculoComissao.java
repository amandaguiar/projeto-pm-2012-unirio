/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package trabalho1.RegrasCalculo;

import java.util.Map;
import trabalho1.AcessoArquivo.acessoArquivoException;
import trabalho1.ObjetosNegocio.Comissao;

/**
 *
 * @author Jean
 */
public interface ICalculoComissao {

    public abstract Map<String,Comissao> gerarComissoes(int mes, String arqVendas, String arqPrecos, String arqVendedores, String arqComissao) throws acessoArquivoException;

}
