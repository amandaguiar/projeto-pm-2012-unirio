/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho1.AcessoArquivo;


import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import trabalho1.ObjetosNegocio.Comissao;
import trabalho1.ObjetosNegocio.Venda;
import trabalho1.ObjetosNegocio.Vendedor;

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
        List lista = null;     
        XMLDecoder xmldecoder = null;        
        try {
            
            xmldecoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(file)));                  
            lista = (ArrayList)xmldecoder.readObject();                        
            
        } catch (FileNotFoundException ex) {
            throw new acessoArquivoException(MSG_ERRO_ACESSO_ARQUIVO);
        } catch(Exception ex){            
            throw new acessoArquivoException(MSG_ERRO_ACESSO_ARQUIVO);
        } finally {
            xmldecoder.close();
        } 
        
        return lista;
    }
    
    @Override
    public abstract void escrever(Map<String, Comissao> comissoes, String ARQUIVO_COMISSAO) throws acessoArquivoException;
    
    //Verifica as pré-condições   
    //protected abstract void verificarPreCondicoes() throws acessoArquivoException;

        
}
