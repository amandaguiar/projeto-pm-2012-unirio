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
 * @author Amanda
 */

public class acessoArquivoPrecoTest {
    
    public static final String ARQUIVO_OK = ("Arquivos de testes\\acessoArquivoPrecoOkTest.txt");
    public static final String arquivoNumCamposIncorretoTest = ("Arquivos de testes\\acessoArquivoPrecoNumCamposIncorretoTest.txt");
    public static final String arquivoNegativoTest = ("Arquivos de testes\\acessoArquivoPrecoNegativoTest.txt");
    public static final String arquivoNaoNumeroTest = ("Arquivos de testes\\acessoArquivoPrecoNaoNumeroTest.txt");
    public static final String arquivoCampoNuloTest = ("Arquivos de testes\\acessoArquivoPrecoCampoNuloTest.txt");
    
    @Test
    public void lerOkTest() {
        try{
            acessoArquivo accArqPreco = new acessoArquivoPreco();
            List<Preco> resultObtido = accArqPreco.ler(new File(ARQUIVO_OK));
            List<Preco> resultEsperado = ResultadoEsperado(2011,(03-1),10,5.5,7.1,2.3);                      
            Assert.assertEquals(resultEsperado.get(0), resultObtido.get(0));
        } catch(acessoArquivoException ex){
            Assert.fail();
        }
    }
    
    public List<Preco> ResultadoEsperado(int ano, int mes, int dia, Double precoA, Double precoB, Double precoC) {
        List<Preco> resultEsperado = new ArrayList<Preco>();
        List<Double> listaPrecos = new ArrayList<Double>();
        listaPrecos.add(precoA);
        listaPrecos.add(precoB);
        listaPrecos.add(precoC);

        resultEsperado.add(new Preco(new GregorianCalendar(ano, mes, dia), listaPrecos));
        return resultEsperado;
    }

    @Test
    public void LerNumCamposIncorretoTest() {
        try{
            acessoArquivo accArqPreco = new acessoArquivoPreco();
            List<Preco> resultadoObtido = accArqPreco.ler(new File(arquivoNumCamposIncorretoTest));
            Assert.fail();
            
        } catch(acessoArquivoException ex){
            Assert.assertEquals(acessoArquivo.MSG_NUMERO_DE_CAMPOS_INCORRETO, ex.getMessage());
        }
    }
    
    @Test
    public void LerCampoNuloTest() {
        try{
            acessoArquivo accArqPreco = new acessoArquivoPreco();
            List<Preco> resultadoObtido = accArqPreco.ler(new File(arquivoCampoNuloTest));
            Assert.fail();
            
        } catch(acessoArquivoException ex){
            Assert.assertEquals(acessoArquivo.MSG_NUMERO_DE_CAMPOS_INCORRETO, ex.getMessage());
        }
    }

    @Test
    public void LerPrecoNegativoTest() {
        try{
            acessoArquivo accArqPreco = new acessoArquivoPreco();
            List<IAcessoArquivo> resultadoObtido = accArqPreco.ler(new File(arquivoNegativoTest));
            Assert.fail();
        } catch(acessoArquivoException ex){
            Assert.assertEquals(acessoArquivoPreco.MSG_PRECO_INVALIDO, ex.getMessage());
        }
    }

    @Test
    public void LerQtdeNaoNumeroTest() {
        try{
            acessoArquivo accArqPreco = new acessoArquivoPreco();
            List<IAcessoArquivo> resultadoObtido = accArqPreco.ler(new File(arquivoNaoNumeroTest));
            Assert.fail();
        } catch(acessoArquivoException ex){
            Assert.assertEquals(acessoArquivoPreco.MSG_PRECO_INVALIDO, ex.getMessage());
        }
    }
}