/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package trabalho1;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

/**
 *
 * @author Jean
 */
public interface IAcessoArquivo {

    public abstract List<IAcessoArquivo> ler(FileReader file) throws acessoArquivoException;
    public void escrever(ArrayList<Object> obj, FileWriter saida);
    public GregorianCalendar stringToCalendar(String valor) throws acessoArquivoException;
    public abstract void verificarPreCondicoes(String[] campos) throws acessoArquivoException;

}
