/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho1.AcessoArquivo;

import trabalho1.AcessoArquivo.acessoArquivoComissaoTXT;
import trabalho1.AcessoArquivo.acessoArquivoException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import trabalho1.ObjetosNegocio.Comissao;

/**
 *
 * @author Roberta
 */
public class acessoArquivoComissaoTest {
    
    public static final String arquivoComissao = ("Arquivos de testes\\acessoArquivoComissaoOkTest.txt");
    public static final String arquivoComissaoResultado = ("Arquivos de testes\\acessoArquivoComissaoResultadoTest.txt");
    public static final String arquivoComissaoResultadoXML = ("Arquivos de testes\\acessoArquivoComissaoResultadoTest.xml");
    
    
    @Test
    public void escreverXMLOkTest() {
        try{
            HashMap<String, Comissao> comissoes = new HashMap<String, Comissao>();
            comissoes.put("1234", new Comissao(05, "0020", "MANOEL", 2, 1, 1, 1, 1000, 500, 1000, 2500, 500));
            
            acessoArquivoComissaoXML calculo = new acessoArquivoComissaoXML();
            calculo.escrever(comissoes, arquivoComissaoResultadoXML);
            
            //(arquivoComissao, arquivoComissaoResultadoXML);
             
        } catch(acessoArquivoException ex){
            Assert.fail();
        }
    }
    
    @Test
    public void escreverOkTest() {
        try{
            HashMap<String, Comissao> comissoes = new HashMap<String, Comissao>();
            comissoes.put("1234", new Comissao(05, "0020", "MANOEL", 2, 1, 1, 1, 1000, 500, 1000, 2500, 500));
            
            acessoArquivoComissaoTXT calculo = new acessoArquivoComissaoTXT();
            calculo.escrever(comissoes, arquivoComissaoResultado);
            
            compararArquivos(arquivoComissao, arquivoComissaoResultado);
             
        } catch(acessoArquivoException ex){
            Assert.fail();
        }
    }
    
    public void compararArquivos(String arquivo1, String arquivo2) throws acessoArquivoException {
        BufferedReader reader1 = null;
        BufferedReader reader2 = null;
        
        List listaComissoes1 = new ArrayList<Comissao>();
        List listaComissoes2 = new ArrayList<Comissao>();
        
        try {
            try {
                reader1 = new BufferedReader(new FileReader(arquivoComissao));
                reader2 = new BufferedReader(new FileReader(arquivoComissaoResultado));
                String linha;
                String[] camposArquivo1 = null;
                String[] camposArquivo2 = null;
                
                while (reader1.ready() && reader2.ready()) {
                    camposArquivo1 = reader1.readLine().split(";");
                    camposArquivo2 = reader2.readLine().split(";");
                    if (camposArquivo1.length != camposArquivo2.length){
                        throw new acessoArquivoException();
                    }
                    
                    for (int i=0;i<camposArquivo1.length;i++){
                        if (!( camposArquivo1[i].equals(camposArquivo2[i]))){
                            throw new acessoArquivoException();
                        }
                    }
                }
            
            } finally {
                if(reader1 != null && reader2 != null){
                    reader1.close();
                    reader2.close();
                }
            }
        } catch(IOException ex){
            throw new acessoArquivoException(ex.getMessage());
        } catch(acessoArquivoException ex){
            throw new acessoArquivoException(ex.getMessage());
        }
    }
}
