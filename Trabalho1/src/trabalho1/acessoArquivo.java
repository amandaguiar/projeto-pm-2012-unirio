/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho1;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.regex.Pattern;

/**
 *
 * @author Amandaa
 */
public abstract class acessoArquivo implements IAcessoArquivo{
    
    public static final String FORMATODATA = "\\d\\d/\\d\\d/\\d\\d\\d\\d";
    public static final String MSGFORMATODATAINVALIDO = "Formato da data inválido.";
    public static final String MSGDATAINVALIDA = "Data inválida";
            
    @Override
    public abstract void ler(FileReader file);    
        
    @Override
    public void escrever(ArrayList<Object> obj, FileWriter saida) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public GregorianCalendar stringToCalendar(String valor) throws acessoArquivoException {

        formatoDataValido(valor);
        String[] split = valor.split("/");
        
        GregorianCalendar newGregCal = null;
        newGregCal = new GregorianCalendar(Integer.parseInt(split[2]), Integer.parseInt(split[1]) - 1 , Integer.parseInt(split[0]));
        newGregCal.setLenient(false);
        
        verificarValidadeData(newGregCal);
        return newGregCal;
    }
    
    public void formatoDataValido(String data) throws acessoArquivoException{
        
        if(!Pattern.matches(FORMATODATA,data))
            throw new acessoArquivoException(MSGFORMATODATAINVALIDO);
        
    }
    
    public void verificarValidadeData(GregorianCalendar newGregCal) throws acessoArquivoException{
        try{
            newGregCal.get(GregorianCalendar.DAY_OF_MONTH);
            newGregCal.get(GregorianCalendar.MONTH);
            newGregCal.get(GregorianCalendar.YEAR);
        }catch(IllegalArgumentException ex){
            throw new acessoArquivoException(MSGDATAINVALIDA);
        }
    }
}
