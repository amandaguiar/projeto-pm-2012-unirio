/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Roberta
 */
public class acessoArquivoVendedorTest {
    public static final String fileOk = ("Arquivos de testes\\acessoArquivoVendedorOkTest.txt");
    public static final String fileNumCamposIncorretoTest = ("Arquivos de testes\\acessoArquivoVendedorNumCamposIncorretoTest.txt");
    public static final String fileEspacosCamposTest = ("Arquivos de testes\\acessoArquivoVendedorEspacosCamposTest.txt");
   
    @Test
    public void LerOkTest() {
        try{
            acessoArquivo arquivoVendedor = new acessoArquivoVendedor();
            List<Vendedor> resultadoObtido = arquivoVendedor.ler(new File(fileOk));
            List<Vendedor> resultadoEsperado = new ArrayList<Vendedor>();
            resultadoEsperado.add(gerarResultadoEsperado("0020","MANOEL DA SILVA",1));
            resultadoEsperado.add(gerarResultadoEsperado("0021","JOANA ANGELICA",2));
                      
            Assert.assertEquals(resultadoEsperado.get(0), resultadoObtido.get(0));
            Assert.assertEquals(resultadoEsperado.get(1), resultadoObtido.get(1));

        } catch(acessoArquivoException ex){
            Assert.fail();
        }
    }
    
    public Vendedor gerarResultadoEsperado(String codigoVendedor, String nomeVendedor, int categoriaVendedor) {
        Vendedor vendedor = new Vendedor(codigoVendedor, nomeVendedor, categoriaVendedor);
        return vendedor;
    }
    
    @Test
    public void lerNumeroDeCamposIncorretoTest() {
        try{
            acessoArquivo acessoArquivoVendedor = new acessoArquivoVendedor();
            List<Vendedor> resultadoObtido = acessoArquivoVendedor.ler(new File(fileNumCamposIncorretoTest));
            Assert.fail();
            
        } catch(acessoArquivoException ex){
            Assert.assertEquals(acessoArquivo.MSG_NUMERO_DE_CAMPOS_INCORRETO, ex.getMessage());
        }
    }
    
    @Test
    public void lerCamposComEspacosTest() {
        try{
            acessoArquivo acessoArquivoVendedor = new acessoArquivoVendedor();
            List<Vendedor> resultadoObtido = acessoArquivoVendedor.ler(new File(fileEspacosCamposTest));
            Assert.fail();
            
        } catch(acessoArquivoException ex){
            Assert.assertEquals(acessoArquivo.MSG_NUMERO_DE_CAMPOS_INCORRETO, ex.getMessage());
        }
    }
    
    
   
}