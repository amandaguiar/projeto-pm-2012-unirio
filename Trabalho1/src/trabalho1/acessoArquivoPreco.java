/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package trabalho1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Amanda
 */
public class acessoArquivoPreco extends acessoArquivo{

    public static final String DELIMITADOR = ";";  //Delimitador de cada campo no arquivo.
    public static final int POS_DATA = 0;  //Posição da data.
    public static final int POS_PRECO_PROD_A = 1; //Posição do preço do produto A no arquivo.
    public static final int POS_PRECO_PROD_B = 2; //Posição do preço do produto B no arquivo.
    public static final int POS_PRECO_PROD_C = 3; //Posição do preço do produto C no arquivo.
    public static final int PRIMEIRA_POSICAO_PRECO = 1; //Posição do primeiro preço no arquivo.
    public static final int QUANT_CAMPOS = 4; //Quantidade de campos em uma linha do arquivo.
    public static final String MSG_PRECO_INVALIDO = "Preço de um produto é inválido.";
    
    
    //Lê um arquivo e retorna uma lista de objetos Preco.
    @Override
    public List<Preco> ler(File file) throws acessoArquivoException {
        List lista = new ArrayList<Preco>();
        BufferedReader reader = null;
        String[] campos = null;
        try{
            try{
                reader = new BufferedReader(new FileReader(file));
                while(reader.ready()){
                    campos = reader.readLine().split(DELIMITADOR);
                    verificarPreCondicoes(campos);
                    lista.add(new Preco(stringToCalendar(campos[POS_DATA]), getPrecosArray(campos)));
                }
            } finally{
                if(reader != null)
                    reader.close();
            }
        } catch(IOException ex){
            lista = null;
            throw new acessoArquivoException(MSG_ERRO_ACESSO_ARQUIVO);
        } catch(acessoArquivoException ex){
            lista = null;
            throw new acessoArquivoException(ex.getMessage());
        }
        return lista;
    }

    @Override
    public void verificarPreCondicoes(String[] campos) throws acessoArquivoException{
        verificarQtdeCamposValidos(campos, QUANT_CAMPOS);
        verificarValidadeCampos(campos);
    }
    
    //Verifica se os campos são válidos.
    public void verificarValidadeCampos(String[] campos) throws acessoArquivoException{
        stringToCalendar(campos[0]); //Verificar data
        verificarPrecos(campos);
    }
    
    //Verifica se os preços dos produtos são válidos.
    public void verificarPrecos(String[] campos)throws acessoArquivoException{
        try{
            for(int i = PRIMEIRA_POSICAO_PRECO; i < campos.length; i++){
                if(Double.parseDouble(campos[i]) < 0)
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
            listaPrecos.add(Double.parseDouble(campos[i]));
        return listaPrecos;
    }
}
