/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho1.AcessoArquivo;

import com.thoughtworks.xstream.XStream;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import trabalho1.ObjetosNegocio.Comissao;

/**
 *
 * @author Amandaa
 */
public abstract class acessoArquivoXML implements IAcessoArquivo {    
      
    public static final String MSG_NUMERO_DE_CAMPOS_INCORRETO = "Número de campos incorreto";
    public static final String FORMATO_DATA = "\\d\\d/\\d\\d/\\d\\d\\d\\d";
    public static final String DELIMITADOR_DATA = "/";
    public static final String DELIMITADOR_CAMPOS = ";";  //Delimitador de cada campo no arquivo.
    public static final String MSG_FORMATO_DATA_INVALIDO = "Formato da data inválido.";
    public static final String MSG_DATA_INVALIDA = "Data inválida";    
    public static final String MSG_ERRO_ACESSO_ARQUIVO = "Erro no acesso ao arquivo";
    public static final String MSG_CATEGORIA_VENDEDOR_INVALIDA = "Categoria do vendedor inválida";
        
    //Lê um arquivo e retorna uma lista de objetos.
    @Override
    public List ler(File file) throws acessoArquivoException {
        List lista = new ArrayList();        
        XStream xstream = null;     
        try { 
            try {                
                lista = (ArrayList)xstream.fromXML(file);                
            } finally{
                
            }
        } catch(Exception ex){
            lista = null;
            throw new acessoArquivoException(MSG_ERRO_ACESSO_ARQUIVO);
        } 
        return lista;
    }
    
    @Override
    public abstract void escrever(Map<String, Comissao> comissoes, String ARQUIVO_COMISSAO) throws acessoArquivoException;
    
    //Verifica as pré-condições   
    //protected abstract void verificarPreCondicoes() throws acessoArquivoException;

        
}
