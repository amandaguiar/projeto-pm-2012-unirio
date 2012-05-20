/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho1;

import junit.framework.Assert;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.*;

/**
 *
 * @author Bianca
 */

@RunWith(Parameterized.class)
public class ComissaoTest {
    
    private int categoriaVendedor;
    private double valorTotalGeral;
    private double comissao;

    public ComissaoTest(int categoriaVendedor, double valorTotalGeral, double comissao) {
        this.categoriaVendedor = categoriaVendedor;
        this.valorTotalGeral = valorTotalGeral;
        this.comissao = comissao;
    }

     @Parameterized.Parameters
    public static Collection<Object []> data() {
            Object[][] testCalculoComissao = new Object[][] {
            {1,1.00,0.10},
            {1,999.99,99.99},
            {1,1000.0,100.00},
            {1,1001.00,100.15},
            {1,1799.99,220.00},
            {1,1800.00,220.00},
            {1,1801.00,220.20},
            {1,2000.00,260.00},
            {1,4000.00,300.00},
            {1,10000.00,1840.00},
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
     * Test of getValorTotalGeral method, of class Comissao.
     */
    @Ignore
    public void testGetValorTotalGeral() {
        System.out.println("getValorTotalGeral");
        List<Double> valorTotalProdutos = null;
        double expResult = 0.0;
        double result = Comissao.getValorTotalGeral(valorTotalProdutos);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calculaComissaoCat1 method, of class Comissao.
     */
    @Ignore
    public void testCalculaComissaoCat1() {
        System.out.println("calculaComissaoCat1");
        double valorTotalGeral = 0.0;
        double expResult = 0.0;
        double result = Comissao.calculaComissaoCat1(valorTotalGeral);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calculaComissaoCat2 method, of class Comissao.
     */
    @Ignore
    public void testCalculaComissaoCat2() {
        System.out.println("calculaComissaoCat2");
        double valorTotalGeral = 0.0;
        double expResult = 0.0;
        double result = Comissao.calculaComissaoCat2(valorTotalGeral);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calculaComissao method, of class Comissao.
     */
    @Test
    public void testCalculaComissao() {
        try{
            double resultado = Comissao.calculaComissao(categoriaVendedor, valorTotalGeral);
            Assert.assertEquals(resultado, comissao);
        }catch(Exception ex){
            Assert.fail();
        }
    }
}

