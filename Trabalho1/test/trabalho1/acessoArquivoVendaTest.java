/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package trabalho1;

import java.io.File;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

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
            acessoArquivo accArqVenda = new acessoArquivoVenda();
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
            acessoArquivo accArqVenda = new acessoArquivoVenda();
            accArqVenda.ler(new File(arquivoNaoOK));
            Assert.fail();
        } catch(acessoArquivoException ex){
            Assert.assertEquals(acessoArquivo.MSG_NUMERO_DE_CAMPOS_INCORRETO, ex.getMessage());
        }
    }

    @Test
    public void lerArquivoNaoEncontrado() {
        try{
            acessoArquivo accArqVenda = new acessoArquivoVenda();
            accArqVenda.ler(new File(arquivoNaoEncontrado));
            Assert.fail();
        } catch(acessoArquivoException ex){
            Assert.assertEquals(acessoArquivo.MSG_ERRO_ACESSO_ARQUIVO, ex.getMessage());
        }
    }


    //Testes para a função "verificarPreCondicoes"

    @Test
    public void verificarPreCondicoesNumCamposMenosUmTest() {
        try{
            acessoArquivo accArqVenda = new acessoArquivoVenda();
            String[] campos = "10/03/2011;40;20;60".split(acessoArquivoVenda.DELIMITADOR);
            accArqVenda.verificarPreCondicoes(campos);
            Assert.fail();
            
        } catch(acessoArquivoException ex){
            Assert.assertEquals(acessoArquivo.MSG_NUMERO_DE_CAMPOS_INCORRETO, ex.getMessage());
        }
    }

    @Test
    public void verificarPreCondicoesNumCamposMaisUmTest() {
        try{
            acessoArquivo accArqVenda = new acessoArquivoVenda();
            String[] campos = "10/03/2011;0020;40;20;60;90".split(acessoArquivoVenda.DELIMITADOR);
            accArqVenda.verificarPreCondicoes(campos);
            Assert.fail();

        } catch(acessoArquivoException ex){
            Assert.assertEquals(acessoArquivo.MSG_NUMERO_DE_CAMPOS_INCORRETO, ex.getMessage());
        }
    }

    @Test
    public void verificarPreCondicoesQtdeNuloTest() {
        try{
            acessoArquivo accArqVenda = new acessoArquivoVenda();
            String[] campos = "10/03/2011;0020;40;;60".split(acessoArquivoVenda.DELIMITADOR);
            accArqVenda.verificarPreCondicoes(campos);
            Assert.fail();
            
        } catch(acessoArquivoException ex){
            Assert.assertEquals(acessoArquivo.MSG_NUMERO_DE_CAMPOS_INCORRETO, ex.getMessage());
        }
    }

    @Test
    public void verificarPreCondicoesCodVendedorNuloTest() {
        try{
            acessoArquivo accArqVenda = new acessoArquivoVenda();
            String[] campos = "10/03/2011;;40;20;60".split(acessoArquivoVenda.DELIMITADOR);
            accArqVenda.verificarPreCondicoes(campos);
            Assert.fail();

        } catch(acessoArquivoException ex){
            Assert.assertEquals(acessoArquivo.MSG_NUMERO_DE_CAMPOS_INCORRETO, ex.getMessage());
        }
    }

    @Test
    public void verificarPreCondicoesValorLimiteQtdeMenosUmTest() {
        try{
            acessoArquivo accArqVenda = new acessoArquivoVenda();
            String[] campos = "11/03/2011;0018;-1;20;60".split(acessoArquivoVenda.DELIMITADOR);
            accArqVenda.verificarPreCondicoes(campos);
            Assert.fail();
        } catch(acessoArquivoException ex){
            Assert.assertEquals(acessoArquivoVenda.MSG_QTDE_INVALIDA, ex.getMessage());
        }
    }
    
    @Test
    public void verificarPreCondicoesValorLimiteQtdeTest() {
        try{
            acessoArquivo accArqVenda = new acessoArquivoVenda();
            String[] campos = "11/03/2011;0018;40;0;60".split(acessoArquivoVenda.DELIMITADOR);
            accArqVenda.verificarPreCondicoes(campos);
        } catch(acessoArquivoException ex){
            Assert.fail();
        }
    }

    @Test
    public void verificarPreCondicoesValorLimiteQtdeMaisUmTest() {
        try{
            acessoArquivo accArqVenda = new acessoArquivoVenda();
            String[] campos = "11/03/2011;0018;40;20;1".split(acessoArquivoVenda.DELIMITADOR);
            accArqVenda.verificarPreCondicoes(campos);
        } catch(acessoArquivoException ex){
            Assert.fail();
        }
    }

    @Test
    public void verificarPreCondicoesQtdeNaoNumeroTest() {
        try{
            acessoArquivo accArqVenda = new acessoArquivoVenda();
            String[] campos = "10/03/2011;0020;10;asd;50".split(acessoArquivoVenda.DELIMITADOR);
            accArqVenda.verificarPreCondicoes(campos);
            Assert.fail();
        } catch(acessoArquivoException ex){
            Assert.assertEquals(acessoArquivoVenda.MSG_QTDE_INVALIDA, ex.getMessage());
        }
    }

    @Test
    public void verificarPreCondicoesCampoContendoEspacosTest() {
        try{
            acessoArquivo accArqVenda = new acessoArquivoVenda();
            String[] campos = "10/03/2011;0020;    ;20;60".split(acessoArquivoVenda.DELIMITADOR);
            accArqVenda.verificarPreCondicoes(campos);
            Assert.fail();
        } catch(acessoArquivoException ex){
            Assert.assertEquals(acessoArquivoVenda.MSG_NUMERO_DE_CAMPOS_INCORRETO, ex.getMessage());
        }
    }
}