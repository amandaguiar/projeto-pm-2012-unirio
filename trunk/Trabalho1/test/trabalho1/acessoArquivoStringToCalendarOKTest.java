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
public class acessoArquivoStringToCalendarOKTest {
    
    private GregorianCalendar resultEsperado;
    private String data;

    public acessoArquivoStringToCalendarOKTest(String data, GregorianCalendar resultEsperado) {
        this.data = data;
        this.resultEsperado = resultEsperado;
        this.resultEsperado.setLenient(false);
        this.resultEsperado.get(GregorianCalendar.DAY_OF_MONTH); //Computar os campos restantes da classe
    }

    @Parameterized.Parameters
    public static Collection<Object []> data() {
        Object[][] testData = new Object[][] {
            {"01/12/2011", new GregorianCalendar(2011,11,1)},
            {"02/12/2011", new GregorianCalendar(2011,11,2)},
            {"31/01/2011", new GregorianCalendar(2011,0,31)},
            {"28/02/2011", new GregorianCalendar(2011,1,28)},
            {"30/11/2011", new GregorianCalendar(2011,10,30)}
        };
        return Arrays.asList(testData);
    }

    @Test
    public void acessoArquivoStringToCalendarTestOK_Venda() {
        try{
            acessoArquivo accArqVenda = new acessoArquivoVenda();
            GregorianCalendar resultadoObtido = accArqVenda.stringToCalendar(data);
            Assert.assertEquals(resultEsperado, resultadoObtido);
        }catch(Exception ex){
            Assert.fail();
        }
    }
    
    @Test
    public void acessoArquivoStringToCalendarTestOK_Preco() {
        try{
            acessoArquivo accArqPreco = new acessoArquivoPreco();
            GregorianCalendar resultadoObtido = accArqPreco.stringToCalendar(data);
            Assert.assertEquals(resultEsperado, resultadoObtido);
        }catch(Exception ex){
            Assert.fail();
        }
    }
}
