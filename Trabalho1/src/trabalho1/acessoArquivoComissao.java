/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package trabalho1;

import java.io.FileReader;
import java.util.List;

/**
 *
 * @author Jean
 */
public class acessoArquivoComissao extends acessoArquivo{

    @Override
    public void verificarPreCondicoes(String[] campos) throws acessoArquivoException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<IAcessoArquivo> ler(FileReader file) throws acessoArquivoException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
