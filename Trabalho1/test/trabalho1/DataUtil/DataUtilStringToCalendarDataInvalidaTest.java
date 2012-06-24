/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho1.DataUtil;

import trabalho1.DataUtil.DataUtilException;
import trabalho1.DataUtil.DataUtil;
import trabalho1.AcessoArquivo.acessoArquivoVendaTXT;
import trabalho1.AcessoArquivo.acessoArquivoTXT;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 *
 * @author cpmbraxis
 */
@RunWith(value = Parameterized.class)
public class DataUtilStringToCalendarDataInvalidaTest {
    
    private String data;
    
    public DataUtilStringToCalendarDataInvalidaTest(String data) {
        this.data = data;
    }

    @Parameterized.Parameters
    public static Collection<Object []> data() {
        Object[][] testData = new Object[][] {
            {"00/12/2011"},
            {"01/00/2011"},
            {"01/12/0000"},
            {"01/13/2011"}
        };
        return Arrays.asList(testData);
    }

    @Test
    public void dataUtilStringToCalendarDataInvalidaTest() {
        try{
            DataUtil.stringToCalendar(data,acessoArquivoVendaTXT.DELIMITADOR_DATA, acessoArquivoTXT.FORMATO_DATA);
            Assert.fail();
        }catch(DataUtilException ex){
            Assert.assertEquals(DataUtil.MSG_DATA_INVALIDA, ex.getMessage());
        }
    }
}
