/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho1.DataUtil;

import trabalho1.DataUtil.DataUtil;
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
public class dataUtilStringToCalendarOKTest {
    
    private GregorianCalendar resultEsperado;
    private String data;

    public dataUtilStringToCalendarOKTest(String data, GregorianCalendar resultEsperado) {
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
    public void dataUtilStringToCalendarTestOK_Preco() {
        try{
            GregorianCalendar resultadoObtido = DataUtil.stringToCalendar(data,acessoArquivoVendaTXT.DELIMITADOR_DATA, acessoArquivoTXT.FORMATO_DATA);
            Assert.assertEquals(resultEsperado, resultadoObtido);
        }catch(Exception ex){
            Assert.fail();
        }
    }
}
