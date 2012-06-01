/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package trabalho1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Jean
 */
public class acessoArquivoVenda extends acessoArquivo{

    public static final String DELIMITADOR = ";";  //Delimitador de cada campo no arquivo.
    public static final String MSG_QTDE_INVALIDA = "Arquivo contém produto com quantidade inválida";
    public static final int POS_DATA = 0;  //Posição da data.
    public static final int POS_COD_VENDEDOR = 1;  //Posição do código do vendedor.
    public static final int PRIMEIRA_POSICAO_QTDE = 2; //Primeira posição das quantidades de produtos vendidos.
    public static final int NUM_CAMPOS = 5;   //Número de campos contidos em uma linha do arquivo.

    //Lê um arquivo e retorna uma lista de objetos Venda.
    @Override
    public List<Venda> ler(File file) throws acessoArquivoException {
        List lista = new ArrayList<Venda>();
        BufferedReader reader = null;
        String[] campos = null;
        try{
            try{
                reader = new BufferedReader(new FileReader(file));
                while(reader.ready()){
                    campos = reader.readLine().split(DELIMITADOR);
                    verificarPreCondicoes(campos, NUM_CAMPOS);
                    GregorianCalendar data = DataUtil.stringToCalendar(campos[POS_DATA], DELIMITADOR_DATA, FORMATO_DATA);
                    lista.add(new Venda(data,campos[POS_COD_VENDEDOR],
                                        getQtdesDoArray(campos)));
                }
            } finally{
                if(reader != null)
                    reader.close();
            }
        }  catch (IOException ex) {
            lista = null;
            throw new acessoArquivoException(MSG_ERRO_ACESSO_ARQUIVO);
        } catch(acessoArquivoException ex){
            lista = null;
            throw new acessoArquivoException(ex.getMessage());
        } catch(DataUtilException ex){
            lista = null;
            throw new acessoArquivoException(ex.getMessage());
        }
        return lista;
    }

    @Override
    protected void verificarPreCondicoes(String[] campos, int numCampos) throws acessoArquivoException{
        verificarQtdeCamposValidos(campos, numCampos);
        verificarValidadeCampos(campos);
    }

    //Verifica se os campos são válidos.
    protected void verificarValidadeCampos(String[] campos) throws acessoArquivoException{

        try{
            DataUtil.stringToCalendar(campos[0], DELIMITADOR_DATA, FORMATO_DATA); //Essa função chama outras funções que validam a data
            verificarQtdes(campos);
        } catch(DataUtilException ex){
            throw new acessoArquivoException(ex.getMessage());
        }
    }

    //Verifica se as quantidades dos produtos são válidas
    public void verificarQtdes(String[] campos)throws acessoArquivoException{
        try{
            for(int i=PRIMEIRA_POSICAO_QTDE; i < campos.length; i++){
                if(Integer.parseInt(campos[i]) < 0)
                    throw new acessoArquivoException(MSG_QTDE_INVALIDA);
            }
        } catch(NumberFormatException ex){
            throw new acessoArquivoException(MSG_QTDE_INVALIDA);
        }
    }

    //Retorna uma lista das quantidades dos produtos vendidos contidos em um array.
    public List<Integer> getQtdesDoArray(String[] campos){
        List<Integer> listaQtdes = new ArrayList<Integer>();

        for(int i=PRIMEIRA_POSICAO_QTDE; i < campos.length; i++)
            listaQtdes.add(Integer.parseInt(campos[i]));

        return listaQtdes;
    }
    
    @Override
    public void escrever(Map<String, Comissao> comissoes, String ARQUIVO_COMISSAO) throws acessoArquivoException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    
}
