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
public class acessoArquivoStringToCalendarFormatoDataInvalidoTest {
    
    private GregorianCalendar resultEsperado;
    private String data;
    
    public acessoArquivoStringToCalendarFormatoDataInvalidoTest(String data) {
        this.data = data;
        this.resultEsperado = null;
    }

    @Parameterized.Parameters
    public static Collection<Object []> data() {
        Object[][] testData = new Object[][] {
            {"1/01/2011"},
            {"01/7/2011"},
            {"01/07/201"},
            {"01/07/20"},
            {"01/07/2"},
            {"01/07/"},
            {"01/07/20111"},
            {"01//2011"},
            {"/07/201"},
            {"01/07/2011/"},
            {"/01/07/2011"},
            {"01-07-2011"}
        };
        return Arrays.asList(testData);
    }

    @Test
    public void acessoArquivoStringToCalendarFormatoDataInvalidoTest() {
        try{
            acessoArquivo accArqVenda = new acessoArquivoVenda();
            GregorianCalendar resultadoObtido = accArqVenda.stringToCalendar(data);
            Assert.fail();
        }catch(acessoArquivoException ex){
            Assert.assertEquals(acessoArquivo.MSGFORMATODATAINVALIDO, ex.getMessage());
        }
    }
}
