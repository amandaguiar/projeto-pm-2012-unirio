/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package trabalho1.AcessoArquivo;

import java.util.Map;
import trabalho1.ObjetosNegocio.Comissao;
import trabalho1.RegrasCalculo.CalculoComissao;
import trabalho1.RegrasCalculo.ICalculoComissao;

/**
 *
 * @author Jean
 */
public class AcessoArquivoAPP {

    public ICalculoComissao ativarCalculoComissao(String tipoAcessoArquivo){
        
        return criarCalculoComissao(tipoAcessoArquivo);
    }

    public CalculoComissao criarCalculoComissao(String tipoAcessoArquivo){

        if(tipoAcessoArquivo.toUpperCase().contains("XML")){
            CalculoComissao calculoComissao = new CalculoComissao(new acessoArquivoVendaXML(),
                                              new acessoArquivoPrecoXML(),
                                              new acessoArquivoVendedorXML());
            return calculoComissao;
        }
        else if(tipoAcessoArquivo.toUpperCase().contains("PONTO E VÍRGULA")){
            CalculoComissao calculoComissao = new CalculoComissao(new acessoArquivoVendaTXT(),
                                              new acessoArquivoPrecoTXT(),
                                              new acessoArquivoVendedorTXT());
            return calculoComissao;
        }
        else
            return null;
    }

    public void ativarEscreverComissao(Map<String, Comissao> comissoes, String arqComissao, String tipoAcessoArquivo) throws acessoArquivoException{

        if(tipoAcessoArquivo.toUpperCase().contains("XML")){
            IAcessoArquivo accArquivoComissaoXML=  new acessoArquivoComissaoXML();
            accArquivoComissaoXML.escrever(comissoes, arqComissao);
        }
        else if(tipoAcessoArquivo.toUpperCase().contains("PONTO E VÍRGULA")){
            IAcessoArquivo accArquivoComissaoTXT =  new acessoArquivoComissaoTXT();
            accArquivoComissaoTXT.escrever(comissoes, arqComissao);
        }
    }
}
