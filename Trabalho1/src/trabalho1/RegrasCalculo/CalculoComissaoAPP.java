/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package trabalho1.RegrasCalculo;

import java.util.Map;
import trabalho1.AcessoArquivo.AcessoArquivoAPP;
import trabalho1.AcessoArquivo.acessoArquivoException;
import trabalho1.ObjetosNegocio.Comissao;

/**
 *
 * @author Jean
 */
public class CalculoComissaoAPP {

    public ICalculoComissao ativarCalculoComissao(String tipoAcessoArquivo){
        AcessoArquivoAPP acessoArquivo = new AcessoArquivoAPP();
        ICalculoComissao calculoComissao = acessoArquivo.ativarCalculoComissao(tipoAcessoArquivo);

        return calculoComissao;
    }

    public Map<String,Comissao> ativarGerarComissoes(int mes, String arqVendas, String arqPrecos,
                                                     String arqVendedores, String arqComissao,
                                                     String tipoAcessoArquivo) throws acessoArquivoException{

        AcessoArquivoAPP acessoArquivo = new AcessoArquivoAPP();
        ICalculoComissao calculoComissao = acessoArquivo.ativarCalculoComissao(tipoAcessoArquivo);
        return calculoComissao.gerarComissoes(mes, arqVendas, arqPrecos, arqVendedores, arqComissao);
    }
}
