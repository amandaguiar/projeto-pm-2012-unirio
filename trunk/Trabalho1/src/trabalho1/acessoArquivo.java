/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho1;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.regex.Pattern;

/**
 *
 * @author Amandaa
 */
public abstract class acessoArquivo implements IAcessoArquivo{

    public static final String FORMATO_DATA = "\\d\\d/\\d\\d/\\d\\d\\d\\d";
    
    public static final String MSG_FORMATO_DATA_INVALIDO = "Formato da data inv�lido.";
    public static final String MSG_DATA_INVALIDA = "Data inv�lida";
    public static final String MSG_NUMERO_DE_CAMPOS_INCORRETO = "N�mero de campos incorreto";

    public static final String MSG_ERRO_ACESSO_ARQUIVO = "Erro no acesso ao arquivo";

    @Override
    public abstract List ler(File file) throws acessoArquivoException;

    @Override
    public void escrever(ArrayList<Object> obj, FileWriter saida) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    //Verifica se a data contida na String � v�lida e gera um novo GregorianCalendar.
    @Override
    public GregorianCalendar stringToCalendar(String valor) throws acessoArquivoException {

        verificarFormatoData(valor);
        String[] split = valor.split("/");
        
        GregorianCalendar newGregCal = null;
        newGregCal = new GregorianCalendar(Integer.parseInt(split[2]), Integer.parseInt(split[1]) - 1 , Integer.parseInt(split[0]));
        newGregCal.setLenient(false);
        
        verificarValidadeData(newGregCal);
        return newGregCal;
    }
    
    public void verificarFormatoData(String data) throws acessoArquivoException{
        
        if(!Pattern.matches(FORMATO_DATA,data))
            throw new acessoArquivoException(MSG_FORMATO_DATA_INVALIDO);
        
    }
    
    public void verificarValidadeData(GregorianCalendar newGregCal) throws acessoArquivoException{
        try{
            newGregCal.get(GregorianCalendar.MONTH); /*Inicializa todos os demais campos da Classe 
                                                       GregorianCalendar e os valida*/
        
        }catch(IllegalArgumentException ex){
            throw new acessoArquivoException(MSG_DATA_INVALIDA);
        }
    }

    @Override
    public abstract void verificarPreCondicoes(String[] campos) throws acessoArquivoException;

    //Verifica se todos os campos s�o v�lidos e quantos campos o array possui
    public void verificarQtdeCamposValidos(String campos[], int numCampos) throws acessoArquivoException{
        String[] copiaCampos = Arrays.copyOf(campos, campos.length); //criando uma c�pia do array
        Arrays.sort(copiaCampos);  //� necess�rio organizar o array para a busca bin�ria funcionar
        
        int binarySearchNulo = Arrays.binarySearch(copiaCampos, ""); //Buscar campo nulo
        
        //Buscar espa�o
        String[] espacos = null;
        for (int i=0;i<copiaCampos.length;i++){
            espacos = copiaCampos[i].split(" ");
            if (espacos.length == 0){
                break;
            }
        }
        
        if(copiaCampos.length != numCampos || binarySearchNulo >= 0 || espacos.length == 0)
            throw new acessoArquivoException(MSG_NUMERO_DE_CAMPOS_INCORRETO);
        
    }
}
