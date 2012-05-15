/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package trabalho1;

import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author Jean
 */
public interface acessoArquivo {

    public void ler(File file);
    public void escrever(ArrayList<Object> obj, File saida);

}
