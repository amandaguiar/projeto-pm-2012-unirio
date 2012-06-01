/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package trabalho1;

import java.io.File;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Jean
 */
public interface IAcessoArquivo {

    public abstract List ler(File file) throws acessoArquivoException;
    public abstract void escrever(Map<String, Comissao> comissoes, String ARQUIVO_COMISSAO) throws acessoArquivoException;
    
}
