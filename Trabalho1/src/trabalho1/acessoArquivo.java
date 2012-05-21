/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho1;

import java.io.File;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 *
 * @author Amandaa
 */
public abstract class acessoArquivo implements IAcessoArquivo{

    public static final String FORMATO_DATA = "\\d\\d/\\d\\d/\\d\\d\\d\\d";
    
    public static final String MSG_FORMATO_DATA_INVALIDO = "Formato da data inválido.";
    public static final String MSG_DATA_INVALIDA = "Data inválida";
    public static final String MSG_NUMERO_DE_CAMPOS_INCORRETO = "Número de campos incorreto";

    public static final String MSG_ERRO_ACESSO_ARQUIVO = "Erro no acesso ao arquivo";

    @Override
    public abstract List ler(File file) throws acessoArquivoException;

    @Override
    public void escrever(Map<String, Comissao> comissoes, String ARQUIVO_COMISSAO) throws acessoArquivoException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    //Verifica se a data contida na String é válida e gera um novo GregorianCalendar.
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

    //Verifica se todos os campos são válidos e quantos campos o array possui
    public void verificarQtdeCamposValidos(String campos[], int numCampos) throws acessoArquivoException{
        String[] copiaCampos = Arrays.copyOf(campos, campos.length); //criando uma cópia do array
        Arrays.sort(copiaCampos);  //É necessário organizar o array para a busca binária funcionar
        
        int binarySearchNulo = Arrays.binarySearch(copiaCampos, ""); //Buscar campo nulo
        
        //Buscar espaço
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
