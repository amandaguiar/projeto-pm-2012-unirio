/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho1.AcessoArquivo;

import trabalho1.AcessoArquivo.acessoArquivo;
import trabalho1.AcessoArquivo.acessoArquivoException;
import trabalho1.AcessoArquivo.acessoArquivoVendedor;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import trabalho1.ObjetosNegocio.Vendedor;

/**
 *
 * @author Roberta
 */
public class acessoArquivoVendedorTest {
    public static final String fileOk = ("Arquivos de testes\\acessoArquivoVendedorOkTest.txt");
    public static final String fileNumCamposMinIncorretoTest = ("Arquivos de testes\\acessoArquivoVendedorNumCamposMinIncorretoTest.txt");
    public static final String fileNumCamposMaxIncorretoTest = ("Arquivos de testes\\acessoArquivoVendedorNumCamposMaxIncorretoTest.txt");
    public static final String fileEspacosCamposTest = ("Arquivos de testes\\acessoArquivoVendedorEspacosCamposTest.txt");
    public static final String fileCategoriaInvalidaTest = ("Arquivos de testes\\acessoArquivoVendedorCategoriaInvalidaTest.txt");

    @Test
    public void lerOkTest() {
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
    public void lerNumeroDeCamposMinIncorretoTest() {
        try{
            acessoArquivo acessoArquivoVendedor = new acessoArquivoVendedor();
            acessoArquivoVendedor.ler(new File(fileNumCamposMinIncorretoTest));
            Assert.fail();
            
        } catch(acessoArquivoException ex){
            Assert.assertEquals(acessoArquivo.MSG_NUMERO_DE_CAMPOS_INCORRETO, ex.getMessage());
        }
    }
    
    @Test
    public void lerNumeroDeCamposMaxIncorretoTest() {
        try{
            acessoArquivo acessoArquivoVendedor = new acessoArquivoVendedor();
            acessoArquivoVendedor.ler(new File(fileNumCamposMaxIncorretoTest));
            Assert.fail();
            
        } catch(acessoArquivoException ex){
            Assert.assertEquals(acessoArquivo.MSG_NUMERO_DE_CAMPOS_INCORRETO, ex.getMessage());
        }
    }
    
    @Test
    public void lerCamposComEspacosTest() {
        try{
            acessoArquivo acessoArquivoVendedor = new acessoArquivoVendedor();
            acessoArquivoVendedor.ler(new File(fileEspacosCamposTest));
            Assert.fail();
            
        } catch(acessoArquivoException ex){
            Assert.assertEquals(acessoArquivo.MSG_NUMERO_DE_CAMPOS_INCORRETO, ex.getMessage());
        }
    }
    
    @Test
    public void lerCamposComCategoriaInvalidaTest() {
        try{
            acessoArquivo acessoArquivoVendedor = new acessoArquivoVendedor();
            acessoArquivoVendedor.ler(new File(fileCategoriaInvalidaTest));
            Assert.fail();
            
        } catch(acessoArquivoException ex){
            Assert.assertEquals(acessoArquivo.MSG_CATEGORIA_VENDEDOR_INVALIDA, ex.getMessage());
        }
    }   
}
