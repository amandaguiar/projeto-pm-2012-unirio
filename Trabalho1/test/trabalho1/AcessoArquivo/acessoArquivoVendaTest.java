/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package trabalho1.AcessoArquivo;


import java.io.File;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import trabalho1.ObjetosNegocio.Venda;

/**
 *
 * @author Jean
 */

public class acessoArquivoVendaTest {

    public static final String arquivoOK = ("Arquivos de testes\\acessoArquivoVendaOkTest.txt");
    public static final String arquivoNaoOK = ("Arquivos de testes\\acessoArquivoVendaNOKTest.txt");
    public static final String arquivoNaoEncontrado = ("Arquivos de testes\\arquivoNaoEncontrado.txt");

    //Testar a função "ler" passando uma entrada válida.
    @Test
    public void lerOKTest() {
        try{
            acessoArquivoTXT accArqVenda = new acessoArquivoVendaTXT();
            List<Venda> resultObtido = accArqVenda.ler(new File(arquivoOK));
            List<Venda> resultEsperado = gerarResultEsperado(2011,(03-1),10,"0020",10,30,50);
                      
            Assert.assertEquals(resultEsperado.get(0), resultObtido.get(0));
        } catch(acessoArquivoException ex){
            Assert.fail();
        }
    }

    //Função para gerar o resultado esperado de um teste.
    public List<Venda> gerarResultEsperado(int ano, int mes, int dia, String codVendedor,
                                                    int qtdeA, int qtdeB, int qtdeC) {
        List<Venda> resultEsperado = new ArrayList<Venda>();
        List<Integer> listaQtdes = new ArrayList<Integer>();
        listaQtdes.add(qtdeA);
        listaQtdes.add(qtdeB);
        listaQtdes.add(qtdeC);

        resultEsperado.add(new Venda(new GregorianCalendar(ano, mes, dia), codVendedor, listaQtdes));
        return resultEsperado;
    }

    //Testar a função "ler" passando uma entrada com número de campos incorretos
    @Test
    public void lerNaoOKTest() {
        try{
            acessoArquivoTXT accArqVenda = new acessoArquivoVendaTXT();
            accArqVenda.ler(new File(arquivoNaoOK));
            Assert.fail();
        } catch(acessoArquivoException ex){
            Assert.assertEquals(acessoArquivoTXT.MSG_NUMERO_DE_CAMPOS_INCORRETO, ex.getMessage());
        }
    }

    @Test
    public void lerArquivoNaoEncontrado() {
        try{
            acessoArquivoTXT accArqVenda = new acessoArquivoVendaTXT();
            accArqVenda.ler(new File(arquivoNaoEncontrado));
            Assert.fail();
        } catch(acessoArquivoException ex){
            Assert.assertEquals(acessoArquivoTXT.MSG_ERRO_ACESSO_ARQUIVO, ex.getMessage());
        }
    }


    //Testes para a função "verificarPreCondicoes"

    @Test
    public void verificarPreCondicoesNumCamposMenosUmTest() {
        try{
            acessoArquivoTXT accArqVenda = new acessoArquivoVendaTXT();
            String[] campos = "10/03/2011;40;20;60".split(acessoArquivoVendaTXT.DELIMITADOR);
            accArqVenda.verificarPreCondicoes(campos);
            Assert.fail();
            
        } catch(acessoArquivoException ex){
            Assert.assertEquals(acessoArquivoTXT.MSG_NUMERO_DE_CAMPOS_INCORRETO, ex.getMessage());
        }
    }

    @Test
    public void verificarPreCondicoesNumCamposMaisUmTest() {
        try{
            acessoArquivoTXT accArqVenda = new acessoArquivoVendaTXT();
            String[] campos = "10/03/2011;0020;40;20;60;90".split(acessoArquivoVendaTXT.DELIMITADOR);
            accArqVenda.verificarPreCondicoes(campos);
            Assert.fail();

        } catch(acessoArquivoException ex){
            Assert.assertEquals(acessoArquivoTXT.MSG_NUMERO_DE_CAMPOS_INCORRETO, ex.getMessage());
        }
    }

    @Test
    public void verificarPreCondicoesQtdeNuloTest() {
        try{
            acessoArquivoTXT accArqVenda = new acessoArquivoVendaTXT();
            String[] campos = "10/03/2011;0020;40;;60".split(acessoArquivoVendaTXT.DELIMITADOR);
            accArqVenda.verificarPreCondicoes(campos);
            Assert.fail();
            
        } catch(acessoArquivoException ex){
            Assert.assertEquals(acessoArquivoTXT.MSG_NUMERO_DE_CAMPOS_INCORRETO, ex.getMessage());
        }
    }

    @Test
    public void verificarPreCondicoesCodVendedorNuloTest() {
        try{
            acessoArquivoTXT accArqVenda = new acessoArquivoVendaTXT();
            String[] campos = "10/03/2011;;40;20;60".split(acessoArquivoVendaTXT.DELIMITADOR);
            accArqVenda.verificarPreCondicoes(campos);
            Assert.fail();

        } catch(acessoArquivoException ex){
            Assert.assertEquals(acessoArquivoTXT.MSG_NUMERO_DE_CAMPOS_INCORRETO, ex.getMessage());
        }
    }

    @Test
    public void verificarPreCondicoesValorLimiteQtdeMenosUmTest() {
        try{
            acessoArquivoTXT accArqVenda = new acessoArquivoVendaTXT();
            String[] campos = "11/03/2011;0018;-1;20;60".split(acessoArquivoVendaTXT.DELIMITADOR);
            accArqVenda.verificarPreCondicoes(campos);
            Assert.fail();
        } catch(acessoArquivoException ex){
            Assert.assertEquals(acessoArquivoVendaTXT.MSG_QTDE_INVALIDA, ex.getMessage());
        }
    }
    
    @Test
    public void verificarPreCondicoesValorLimiteQtdeTest() {
        try{
            acessoArquivoTXT accArqVenda = new acessoArquivoVendaTXT();
            String[] campos = "11/03/2011;0018;40;0;60".split(acessoArquivoVendaTXT.DELIMITADOR);
            accArqVenda.verificarPreCondicoes(campos);
        } catch(acessoArquivoException ex){
            Assert.fail();
        }
    }

    @Test
    public void verificarPreCondicoesValorLimiteQtdeMaisUmTest() {
        try{
            acessoArquivoTXT accArqVenda = new acessoArquivoVendaTXT();
            String[] campos = "11/03/2011;0018;40;20;1".split(acessoArquivoVendaTXT.DELIMITADOR);
            accArqVenda.verificarPreCondicoes(campos);
        } catch(acessoArquivoException ex){
            Assert.fail();
        }
    }

    @Test
    public void verificarPreCondicoesQtdeNaoNumeroTest() {
        try{
            acessoArquivoTXT accArqVenda = new acessoArquivoVendaTXT();
            String[] campos = "10/03/2011;0020;10;asd;50".split(acessoArquivoVendaTXT.DELIMITADOR);
            accArqVenda.verificarPreCondicoes(campos);
            Assert.fail();
        } catch(acessoArquivoException ex){
            Assert.assertEquals(acessoArquivoVendaTXT.MSG_QTDE_INVALIDA, ex.getMessage());
        }
    }

    @Test
    public void verificarPreCondicoesCampoContendoEspacosTest() {
        try{
            acessoArquivoTXT accArqVenda = new acessoArquivoVendaTXT();
            String[] campos = "10/03/2011;0020;    ;20;60".split(acessoArquivoVendaTXT.DELIMITADOR);
            accArqVenda.verificarPreCondicoes(campos);
            Assert.fail();
        } catch(acessoArquivoException ex){
            Assert.assertEquals(acessoArquivoVendaTXT.MSG_NUMERO_DE_CAMPOS_INCORRETO, ex.getMessage());
        }
    }
}