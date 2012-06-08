/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package trabalho1;

import java.util.GregorianCalendar;
import java.util.regex.Pattern;

/**
 *
 * @author Jean
 */
public class DataUtil {
    public static final String MSG_DATA_INVALIDA = "Data Inv\u00e1lida";

    public DataUtil() {
    }

    //Verifica se a data contida na String é válida e gera um novo GregorianCalendar.
    public static GregorianCalendar stringToCalendar(String valor, String delimitadorData, String formatoData ) throws DataUtilException {
        
        GregorianCalendar newGregCal = null;
        try{
            verificarFormatoData(valor,formatoData);
            String[] split = valor.split(delimitadorData);

            newGregCal = new GregorianCalendar(Integer.parseInt(split[2]), Integer.parseInt(split[1]) - 1 , Integer.parseInt(split[0]));
            newGregCal.setLenient(false);

            verificarValidadeData(newGregCal);
        } catch(NumberFormatException ex){
            throw new DataUtilException(MSG_DATA_INVALIDA);
        } catch(ArrayIndexOutOfBoundsException ex){
            throw new DataUtilException(MSG_DATA_INVALIDA);
        }

        return newGregCal;
    }

    //Verifica o formato da data
    private static void verificarFormatoData(String data, String formatoData) throws DataUtilException{

        if(!Pattern.matches(formatoData,data))
            throw new DataUtilException(MSG_DATA_INVALIDA);

    }

    //Verifica se a data é válida
    private static void verificarValidadeData(GregorianCalendar newGregCal) throws DataUtilException{
        try{
            newGregCal.get(GregorianCalendar.MONTH); /*Inicializa todos os demais campos da Classe
                                                       GregorianCalendar e os valida*/

        }catch(IllegalArgumentException ex){
            throw new DataUtilException(MSG_DATA_INVALIDA);
        }
    }
}
