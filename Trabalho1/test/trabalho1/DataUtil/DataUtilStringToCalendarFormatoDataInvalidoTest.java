/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho1.DataUtil;

import trabalho1.AcessoArquivo.acessoArquivoVendaTXT;
import trabalho1.AcessoArquivo.acessoArquivoTXT;
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
public class DataUtilStringToCalendarFormatoDataInvalidoTest {
    
    private GregorianCalendar resultEsperado;
    private String data;
    
    public DataUtilStringToCalendarFormatoDataInvalidoTest(String data) {
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
    public void DataUtilStringToCalendarFormatoDataInvalidoTest() {
        try{
            DataUtil.stringToCalendar(data,acessoArquivoVendaTXT.DELIMITADOR_DATA, acessoArquivoTXT.FORMATO_DATA);
            Assert.fail();
        }catch(DataUtilException ex){
            Assert.assertEquals(DataUtil.MSG_DATA_INVALIDA, ex.getMessage());
        }
    }
}
