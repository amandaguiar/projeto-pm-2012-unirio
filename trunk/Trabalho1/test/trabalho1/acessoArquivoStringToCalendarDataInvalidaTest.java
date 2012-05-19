/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho1;

import java.util.Arrays;
import java.util.Collection;
import java.util.GregorianCalendar;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 *
 * @author cpmbraxis
 */
@RunWith(value = Parameterized.class)
public class acessoArquivoStringToCalendarDataInvalidaTest {
    
    private GregorianCalendar resultEsperado;
    private String data;
    
    public acessoArquivoStringToCalendarDataInvalidaTest(String data) {
        this.data = data;
        this.resultEsperado = null;
    }

    @Parameterized.Parameters
    public static Collection<Object []> data() {
        Object[][] testData = new Object[][] {
            {"00/12/2011"},
            {"01/00/2011"},
            {"01/12/0000"}
        };
        return Arrays.asList(testData);
    }

    @Test
    public void acessoArquivoStringToCalendarDataInvalidaTest_Venda() {
        try{
            acessoArquivo accArqVenda = new acessoArquivoVenda();
            GregorianCalendar resultadoObtido = accArqVenda.stringToCalendar(data);
            Assert.fail();
        }catch(acessoArquivoException ex){
            Assert.assertEquals(acessoArquivo.MSG_DATA_INVALIDA, ex.getMessage());
        }
    }
    
    @Test
    public void acessoArquivoStringToCalendarDataInvalidaTest_Preco() {
        try{
            acessoArquivo accArqPreco = new acessoArquivoPreco();
            GregorianCalendar resultadoObtido = accArqPreco.stringToCalendar(data);
            Assert.fail();
        }catch(acessoArquivoException ex){
            Assert.assertEquals(acessoArquivo.MSG_DATA_INVALIDA, ex.getMessage());
        }
    }
}
