/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package trabalho1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Jean
 */

public class acessoArquivoVendaTest {

    public static final String fileOk = ("Arquivos de testes\\acessoArquivoVendaOkTest.txt");
    public static final String fileNumCamposIncorretoTest = ("Arquivos de testes\\acessoArquivoVendaNumCamposIncorretoTest.txt");
    public static final String fileQtdeNegativoTest = ("Arquivos de testes\\acessoArquivoQtdeNegativoTest.txt");
    public static final String fileQtdeNaoNumeroTest = ("Arquivos de testes\\acessoArquivoVendaQtdeNaoNumeroTest.txt");
    public static final String fileCampoNuloTest = ("Arquivos de testes\\acessoArquivoVendaCampoNuloTest.txt");
    
    @Test
    public void LerOkTest() {
        try{
            acessoArquivo accArqVenda = new acessoArquivoVenda();
            List<Venda> resultObtido = accArqVenda.ler(new FileReader(new File(fileOk)));
            List<Venda> resultEsperado = gerarResultEsperado(2011,(03-1),10,"0020",10,30,50);
                      
            Assert.assertEquals(resultEsperado.get(0), resultObtido.get(0));
        } catch(acessoArquivoException ex){
            Assert.fail();
        } catch(FileNotFoundException ex){
            Assert.fail();
        }
    }

    
    public List<Venda> gerarResultEsperado(int ano, int mes, int dia, String codVendedor,
                                                    int qtdeA, int qtdeB, int qtdeC) {
        List<Venda> resultEsperado = new ArrayList<Venda>();
        List<Integer> listaQtdes = new ArrayList<Integer>();
        listaQtdes.add(qtdeA);
        listaQtdes.add(qtdeB);
        listaQtdes.add(qtdeC);

        resultEsperado.add(new Venda(new GregorianCalendar(ano, mes, dia), codVendedor, listaQtdes));
        return resultEsperado;
    }

    @Test
    public void LerNumCamposIncorretoTest() {
        try{
            acessoArquivo accArqVenda = new acessoArquivoVenda();
            List<Venda> resultObtido = accArqVenda.ler(new FileReader(new File(fileNumCamposIncorretoTest)));
            Assert.fail();
            
        } catch(acessoArquivoException ex){
            Assert.assertEquals(acessoArquivo.MSG_NUMERO_DE_CAMPOS_INCORRETO, ex.getMessage());
        } catch(FileNotFoundException ex){
            Assert.fail();
        }
    }
    
    @Test
    public void LerCampoNuloTest() {
        try{
            acessoArquivo accArqVenda = new acessoArquivoVenda();
            List<Venda> resultObtido = accArqVenda.ler(new FileReader(new File(fileCampoNuloTest)));
            Assert.fail();
            
        } catch(acessoArquivoException ex){
            Assert.assertEquals(acessoArquivo.MSG_NUMERO_DE_CAMPOS_INCORRETO, ex.getMessage());
        } catch(FileNotFoundException ex){
            Assert.fail();
        }
    }

    @Test
    public void LerQtdeNegativoTest() {
        try{
            acessoArquivo accArqVenda = new acessoArquivoVenda();
            List<IAcessoArquivo> resultObtido = accArqVenda.ler(new FileReader(new File(fileQtdeNegativoTest)));
            Assert.fail();
        } catch(acessoArquivoException ex){
            Assert.assertEquals(acessoArquivoVenda.MSG_QTDE_INVALIDA, ex.getMessage());
        } catch(FileNotFoundException ex){
            Assert.fail();
        }
    }

    @Test
    public void LerQtdeNaoNumeroTest() {
        try{
            acessoArquivo accArqVenda = new acessoArquivoVenda();
            List<IAcessoArquivo> resultObtido = accArqVenda.ler(new FileReader(new File(fileQtdeNaoNumeroTest)));
            Assert.fail();
        } catch(acessoArquivoException ex){
            Assert.assertEquals(acessoArquivoVenda.MSG_QTDE_INVALIDA, ex.getMessage());
        } catch(FileNotFoundException ex){
            Assert.fail();
        }
    }
    
}