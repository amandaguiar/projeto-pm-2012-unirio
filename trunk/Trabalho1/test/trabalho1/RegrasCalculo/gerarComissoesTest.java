/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package trabalho1.RegrasCalculo;

import trabalho1.ObjetosNegocio.Comissao;
import trabalho1.RegrasCalculo.CalculoComissao;
import trabalho1.AcessoArquivo.acessoArquivoException;
import java.util.HashMap;
import java.util.Map;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Jean
 */

public class gerarComissoesTest {

    private static final String arqVendas1 = "Arquivos de testes\\Vendas_F.txt";
    private static final String arqPrecos1 = "Arquivos de testes\\Precos_F.txt";
    private static final String arqVendedores1 = "Arquivos de testes\\Vendedores_F.txt";
    private static final String arqComissao1 = "Arquivos de testes\\Comissao_F.txt";

    private static final String arqVendas2 = "Arquivos de testes\\VendasB.txt";
    private static final String arqPrecos2 = "Arquivos de testes\\PrecosB.txt";
    private static final String arqVendedores2 = "Arquivos de testes\\VendedorB.txt";
    private static final String arqComissao2 = "Arquivos de testes\\ComissaoB.txt";

    @Test
    public void gerarComissoesTest_F(){
        try{
            CalculoComissao calculo = new CalculoComissao();
            Map<String, Comissao> gerarComissoes = null;
            gerarComissoes = calculo.gerarComissoes(11, arqVendas1, arqPrecos1, arqVendedores1, arqComissao1);
            HashMap<String, Comissao> resultadoEsperado = gerarResultadoEsperado_F();
            Assert.assertEquals(resultadoEsperado, gerarComissoes);
        } catch(acessoArquivoException ex){
            Assert.fail();
        }
    }

    public HashMap<String, Comissao> gerarResultadoEsperado_F(){
        HashMap<String, Comissao> comissoesEsperada = new HashMap<String, Comissao>();
        comissoesEsperada.put("021", new Comissao(11,"021","BILLIE JOE",2,45,45,90,517.50,594.00,3627.00,4738.50,1421.55));
        comissoesEsperada.put("182", new Comissao(11,"182","DAVE GROHL",1,47,106,163,540.50,1399.20,6568.90,8508.60,1561.72));
        comissoesEsperada.put("044", new Comissao(11,"044","ALEX TURNER",2,55,105,132,632.50,1386.00,5319.60,7338.10,2201.43));

        return comissoesEsperada;
    }

    @Test
    public void gerarComissoesTest_B(){
        try{
            CalculoComissao calculo = new CalculoComissao();
            Map<String, Comissao> comissoesObtidas = null;
            comissoesObtidas = calculo.gerarComissoes(5, arqVendas2, arqPrecos2, arqVendedores2, arqComissao2);
            HashMap<String, Comissao> resultadoEsperado = gerarResultadoEsperado_B();
            
            Assert.assertEquals(resultadoEsperado, comissoesObtidas);
        } catch(acessoArquivoException ex){
            Assert.fail();
        }
    }

    public HashMap<String, Comissao> gerarResultadoEsperado_B(){
        HashMap<String, Comissao> comissoesEsperada = new HashMap<String, Comissao>();
        comissoesEsperada.put("0124", new Comissao(5,"0124","ZECA DA SILVA",1,31,32,36,5580.00,3964.80,4680.00,14224.80,2704.96));
        comissoesEsperada.put("0062", new Comissao(5,"0062","MARIA DA PENHA",2,17,26,26,3060.00,3221.40,3380.00,9661.40,2898.42));
        comissoesEsperada.put("0120", new Comissao(5,"0120","ANA JULIA",1,29,23,29,5220.00,2849.70,3770.00,11839.70,2227.94));

        return comissoesEsperada;
    }
}
