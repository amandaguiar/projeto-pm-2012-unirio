/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package trabalho1;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

/**
 *
 * @author Jean
 */
public interface acessoArquivo {

    public void ler(FileReader file);
    public void escrever(ArrayList<Object> obj, FileWriter saida);

}
