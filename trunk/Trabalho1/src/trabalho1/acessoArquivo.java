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
 * @author Amandaa
 */
public abstract class acessoArquivo implements IAcessoArquivo{
    
    
    @Override
    public abstract void ler(FileReader file);    
        
    @Override
    public void escrever(ArrayList<Object> obj, FileWriter saida) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public Calendar stringToCalendar(String valor){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
