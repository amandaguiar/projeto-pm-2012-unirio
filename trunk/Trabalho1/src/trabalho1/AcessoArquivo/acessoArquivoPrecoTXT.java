/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package trabalho1.AcessoArquivo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;
import java.io.IOException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Map;
import trabalho1.ObjetosNegocio.Comissao;
import trabalho1.DataUtil.DataUtil;
import trabalho1.DataUtil.DataUtilException;
import trabalho1.ObjetosNegocio.Preco;

/**
 *
 * @author Amanda
 */
public class acessoArquivoPrecoTXT extends acessoArquivoTXT {

    public static final String DELIMITADOR = ";";  //Delimitador de cada campo no arquivo.
    public static final int POS_DATA = 0;  //Posição da data.
    public static final int POS_PRECO_PROD_A = 1; //Posição do preço do produto A no arquivo.
    public static final int POS_PRECO_PROD_B = 2; //Posição do preço do produto B no arquivo.
    public static final int POS_PRECO_PROD_C = 3; //Posição do preço do produto C no arquivo.
    public static final int PRIMEIRA_POSICAO_PRECO = 1; //Posição do primeiro preço no arquivo.
    public static final int NUM_CAMPOS = 4; //Quantidade de campos em uma linha do arquivo.
    public static final String MSG_PRECO_INVALIDO = "Preço de um produto é inválido.";
    
    
    @Override
    public void escrever(Map<String, Comissao> comissoes, String ARQUIVO_COMISSAO) throws acessoArquivoException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    protected void verificarPreCondicoes(String[] campos) throws acessoArquivoException{
        verificarQtdeCamposValidos(campos, NUM_CAMPOS);
        verificarValidadeCampos(campos);
    }

    //Verifica se os campos são válidos.
    protected void verificarValidadeCampos(String[] campos) throws acessoArquivoException{

        try{
            DataUtil.stringToCalendar(campos[0], DELIMITADOR_DATA, FORMATO_DATA); //Essa função chama outras funções que validam a data
            verificarPrecos(campos);
        } catch(DataUtilException ex){
            throw new acessoArquivoException(ex.getMessage());
        }
    }

    //Verifica se os preços dos produtos são válidos.
    public void verificarPrecos(String[] campos)throws acessoArquivoException{
        try{
            for(int i = PRIMEIRA_POSICAO_PRECO; i < campos.length; i++){
                if(Double.parseDouble(campos[i].replace(",",".")) < 0)
                    throw new acessoArquivoException(MSG_PRECO_INVALIDO);
            }
        } catch(NumberFormatException ex){
            throw new acessoArquivoException(MSG_PRECO_INVALIDO);
        }
    }
    
    //Retorna uma lista dos preços dos produtos em um array.
    public List<Double> getPrecosArray(String[] campos){
        List<Double> listaPrecos = new ArrayList<Double>();
        
        for(int i=PRIMEIRA_POSICAO_PRECO; i < campos.length; i++)
            listaPrecos.add(Double.parseDouble(campos[i].replace(",",".")));
        return listaPrecos;
    }

    //Cria um objeto Preco a partir de um array de strings
    @Override
    protected Object criarObjeto(String[] campos) throws DataUtilException {
        Preco preco = null;
        GregorianCalendar data = DataUtil.stringToCalendar(campos[POS_DATA], DELIMITADOR_DATA, FORMATO_DATA);
        preco = new Preco(data, getPrecosArray(campos));

        return preco;
    }
    
    
}
