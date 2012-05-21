/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho1;

import junit.framework.Assert;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 *
 * @author Bianca
 */

@RunWith(value = Parameterized.class)
public class CalculoComissaoTest {
    
    private int categoriaVendedor;
    private double valorTotalGeral;
    private double comissao;

    public CalculoComissaoTest(int categoriaVendedor, double valorTotalGeral, double comissao) {
        this.categoriaVendedor = categoriaVendedor;
        this.valorTotalGeral = valorTotalGeral;
        this.comissao = comissao;
    }

     @Parameterized.Parameters
    public static Collection<Object []> data() {
            Object[][] testCalculoComissao = new Object[][] {
            {1,1.00,0.10},
            {1,999.99,100.00},
            {1,1000.0,100.00},
            {1,1001.00,100.15},
            {1,1799.99,220.00},
            {1,1800.00,220.00},
            {1,1801.00,220.20},
            {1,2000.00,260.00},
            {1,4000.00,660.00},
            {1,10000.00,1860.00},
            {2,1.00,0.10},
            {2,1000.00,100.00},
            {2,1999.99,200.00},
            {2,2000.00,400.00},
            {2,3000.00,600.00},
            {2,4000.00,800.00},
            {2,4001.00,1200.30},
            {2,5000.00,1500.00},
            {2,10000.00,3000.00}
        };
        return Arrays.asList(testCalculoComissao);
    }
    
    /**
     * Test of calculaComissao method, of class CalculoComissao.
     */
    @Test
    public void testCalculaComissao() {
        try{
            CalculoComissao calculoComissao = new CalculoComissao();
            double resultado = calculoComissao.calculaComissao(categoriaVendedor, valorTotalGeral);
            Assert.assertEquals(comissao,resultado);
        }catch(Exception ex){
            Assert.fail();
        }
    }
}

