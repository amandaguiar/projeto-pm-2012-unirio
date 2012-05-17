/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package trabalho1;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author Jean
 */
public interface IAcessoArquivo {

    public abstract void ler(FileReader file);
    public void escrever(ArrayList<Object> obj, FileWriter saida);
    public Calendar stringToCalendar(String valor);
}
