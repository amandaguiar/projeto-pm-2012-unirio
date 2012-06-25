/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package trabalho1.RegrasCalculo;

import trabalho1.AcessoArquivo.acessoArquivoException;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import trabalho1.AcessoArquivo.IAcessoArquivo;
import trabalho1.ObjetosNegocio.Comissao;
import trabalho1.ObjetosNegocio.Preco;
import trabalho1.ObjetosNegocio.Venda;
import trabalho1.ObjetosNegocio.Vendedor;

/**
 *
 * @author Jean
 */
public class CalculoComissao implements ICalculoComissao{

    private double precoProdutoANoMes = 0.0;
    private double precoProdutoBNoMes = 0.0;
    private double precoProdutoCNoMes = 0.0;

    private IAcessoArquivo accArqVenda;
    private IAcessoArquivo accArqPreco;
    private IAcessoArquivo accArqVendedor;

    public CalculoComissao() {
    }

    public CalculoComissao(IAcessoArquivo accArqVenda, IAcessoArquivo accArqPreco, IAcessoArquivo accArqVendedor) {
        this.accArqVenda = accArqVenda;
        this.accArqPreco = accArqPreco;
        this.accArqVendedor = accArqVendedor;
    }

    public double calculaComissao(int categoriaVendedor, double valorTotalGeral){
        switch(categoriaVendedor){
            case 1:
                return new CalculoComissaoCat1().calculaComissao(valorTotalGeral);
            case 2:
                return new CalculoComissaoCat2().calculaComissao(valorTotalGeral);
            default:
                return 0.0;
        }
    }

    public Map<String,Comissao> gerarComissoes(int mes, String arqVendas, String arqPrecos, String arqVendedores, String arqComissao) throws acessoArquivoException{


        List<Venda> listaVenda = accArqVenda.ler(new File(arqVendas));
        List<Preco> listaPreco = accArqPreco.ler(new File(arqPrecos));
        List<Vendedor> listaVendedor = accArqVendedor.ler(new File(arqVendedores));
        Map<String,Comissao> comissoes = new HashMap<String,Comissao>();

        addVendedores(listaVendedor, comissoes, mes);

        setVendasVendedorNoMes(listaVenda, mes, comissoes);

        getPrecosNoMes(listaPreco, mes);

        setValorTotalReais(comissoes);

        Set<String> codigosVendedores = comissoes.keySet();
        for(String s : codigosVendedores){
            if(comissoes.get(s).getCategoria() == 1){
                comissoes.get(s).setComissao(calculaComissao(1, comissoes.get(s).getValorTotalGeral()));
            }
            else if(comissoes.get(s).getCategoria() == 2){
                comissoes.get(s).setComissao(calculaComissao(2, comissoes.get(s).getValorTotalGeral()));
            }
        }

        return comissoes;
    }

    public void setValorTotalReais(Map<String, Comissao> comissoes) {
        Set<String> codigosVendedores = comissoes.keySet();
        for (String s : codigosVendedores) {
            comissoes.get(s).setValorTotalProdutoA(CalculoUtils.roundTwoDecimals(precoProdutoANoMes * comissoes.get(s).getQtdeTotalProdutoA()));
            comissoes.get(s).setValorTotalProdutoB(CalculoUtils.roundTwoDecimals(precoProdutoBNoMes * comissoes.get(s).getQtdeTotalProdutoB()));
            comissoes.get(s).setValorTotalProdutoC(CalculoUtils.roundTwoDecimals(precoProdutoCNoMes * comissoes.get(s).getQtdeTotalProdutoC()));
            comissoes.get(s).setValorTotalGeral(CalculoUtils.roundTwoDecimals(comissoes.get(s).getValorTotalProdutoA() + comissoes.get(s).getValorTotalProdutoB() + comissoes.get(s).getValorTotalProdutoC()));
        }
    }

    public void addVendedores(List<Vendedor> listaVendedor, Map<String, Comissao> comissoes, int mes) {
        for (Vendedor v : listaVendedor) {
            comissoes.put(v.getCodigo(), new Comissao(mes, v.getCodigo(), v.getNome(), v.getCategoria()));
        }
    }

    public void setVendasVendedorNoMes(List<Venda> listaVenda, int mes, Map<String, Comissao> comissoes) {
        for (Venda v : listaVenda) {
            if (v.getMes() == mes) {
                comissoes.get(v.getCodVendedor()).setQtdeTotalProdutoA(comissoes.get(v.getCodVendedor()).getQtdeTotalProdutoA() + v.getQtdeProdutoA());
                comissoes.get(v.getCodVendedor()).setQtdeTotalProdutoB(comissoes.get(v.getCodVendedor()).getQtdeTotalProdutoB() + v.getQtdeProdutoB());
                comissoes.get(v.getCodVendedor()).setQtdeTotalProdutoC(comissoes.get(v.getCodVendedor()).getQtdeTotalProdutoC() + v.getQtdeProdutoC());
            }
        }
    }

    public void getPrecosNoMes(List<Preco> listaPreco, int mes) {
        //get Preco do Produto no Mes
        for (Preco p : listaPreco) {
            int mes1 = p.getMes();
            if (p.getMes() <= mes) {
                precoProdutoANoMes = p.getPrecoProdA();
                precoProdutoBNoMes = p.getPrecoProdB();
                precoProdutoCNoMes = p.getPrecoProdC();
            }
        }
    }

    public void imprimir(Map<String, Comissao> comissoes){
        Set<String> codigosVendedores = comissoes.keySet();
        for (String s : codigosVendedores) {
            System.out.println("Código: " + comissoes.get(s).getCodigo());
            System.out.println("Nome: " + comissoes.get(s).getNome());
            System.out.println("Categoria: " + comissoes.get(s).getCategoria());
            System.out.println("Mes: " + comissoes.get(s).getMes());
            System.out.println("QtdeTotalA: " + comissoes.get(s).getQtdeTotalProdutoA());
            System.out.println("QtdeTotalB: " + comissoes.get(s).getQtdeTotalProdutoB());
            System.out.println("QtdeTotalC: " + comissoes.get(s).getQtdeTotalProdutoC());
            System.out.println("ValorTotalA: " + comissoes.get(s).getValorTotalProdutoA());
            System.out.println("ValorTotalB: " + comissoes.get(s).getValorTotalProdutoB());
            System.out.println("ValorTotalC: " + comissoes.get(s).getValorTotalProdutoC());
            System.out.println("TotalGeral: " + comissoes.get(s).getValorTotalGeral());
            System.out.println("Comissao: " + comissoes.get(s).getComissao());
            System.out.println();
        }
    }
}
