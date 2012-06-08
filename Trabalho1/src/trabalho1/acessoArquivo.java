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
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Amandaa
 */
public abstract class acessoArquivo implements IAcessoArquivo{

    public static final String FORMATO_DATA = "\\d\\d/\\d\\d/\\d\\d\\d\\d";
    public static final String DELIMITADOR_DATA = "/";
    public static final String DELIMITADOR_CAMPOS = ";";  //Delimitador de cada campo no arquivo.
    public static final String MSG_FORMATO_DATA_INVALIDO = "Formato da data inválido.";
    public static final String MSG_DATA_INVALIDA = "Data inválida";
    public static final String MSG_NUMERO_DE_CAMPOS_INCORRETO = "Número de campos incorreto";
    public static final String MSG_ERRO_ACESSO_ARQUIVO = "Erro no acesso ao arquivo";
    public static final String MSG_CATEGORIA_VENDEDOR_INVALIDA = "Categoria do vendedor inválida";

    //Lê um arquivo e retorna uma lista de objetos.
    @Override
    public List ler(File file) throws acessoArquivoException {
        List lista = new ArrayList();
        BufferedReader reader = null;
        String[] campos = null;
        try{
            try{
                reader = new BufferedReader(new FileReader(file));
                while(reader.ready()){
                    campos = reader.readLine().split(DELIMITADOR_CAMPOS);
                    verificarPreCondicoes(campos);
                    Object objeto = criarObjeto(campos);
                    lista.add(objeto);
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
        } catch(DataUtilException ex){
            lista = null;
            throw new acessoArquivoException(ex.getMessage());
        }
        return lista;
    }

    @Override
    public void escrever(Map<String, Comissao> comissoes, String ARQUIVO_COMISSAO) throws acessoArquivoException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    //Verifica as pré-condições
    protected abstract void verificarPreCondicoes(String[] campos) throws acessoArquivoException;

    //Cria um objeto (usado na função ler)
    protected abstract Object criarObjeto(String[] campos) throws DataUtilException;

    //Verifica se todos os campos são válidos e quantos campos o array possui
    protected void verificarQtdeCamposValidos(String campos[], int numCampos) throws acessoArquivoException{
        String[] copiaCampos = Arrays.copyOf(campos, campos.length); //cria uma cópia do array
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
