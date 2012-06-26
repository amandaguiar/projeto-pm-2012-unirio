/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package trabalho1.RegrasCalculo;

import trabalho1.AcessoArquivo.acessoArquivoException;
import java.io.File;
import java.util.*;
import java.util.ArrayList;
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

    @Override
    public Map<String,Comissao> gerarComissoes(int mes, String arqVendas, String arqPrecos, String arqVendedores, String arqComissao) throws acessoArquivoException{

        List<Venda> vendas = accArqVenda.ler(new File(arqVendas));
        List<Preco> precos = accArqPreco.ler(new File(arqPrecos));
        List<Vendedor> vendedores = accArqVendedor.ler(new File(arqVendedores));
        
        Map<String,Comissao> comissoes = new HashMap<String,Comissao>();

        addVendedores(vendedores, comissoes, mes);
        setVendasVendedorNoMes(vendas, mes, comissoes);
        setValorTotalPrecos(comissoes, vendas, precos, mes);
        CalcularComissoes(comissoes);

        return comissoes;
    }

    private void CalcularComissoes(Map<String, Comissao> comissoes) {
        Set<String> codigosVendedores = comissoes.keySet();
        for (String s : codigosVendedores) {
            if (comissoes.get(s).getCategoria() == 1) {
                comissoes.get(s).setComissao(calculaComissao(1, comissoes.get(s).getValorTotalGeral()));
            } else if (comissoes.get(s).getCategoria() == 2) {
                comissoes.get(s).setComissao(calculaComissao(2, comissoes.get(s).getValorTotalGeral()));
            }
        }
    }

    public void addVendedores(List<Vendedor> listaVendedor, Map<String, Comissao> comissoes, int mes) {
        for (Vendedor v : listaVendedor) {
            comissoes.put(v.getCodigo(), new Comissao(mes, v.getCodigo(), v.getNome(), v.getCategoria()));
        }
    }

    public void setVendasVendedorNoMes(List<Venda> listaVenda, int mes, Map<String, Comissao> comissoes) {
        for (Venda venda : listaVenda) {
            if (venda.getMes() == mes) {
               String codVendedor = venda.getCodVendedor();
               Comissao comissaoVendedor = comissoes.get(codVendedor);
               setQtdeTotalProdutos(comissaoVendedor, venda);
            }
        }
    }

    private void setQtdeTotalProdutos(Comissao comissaoVendedor, Venda venda) {
        setTotalProdutoAVendido(comissaoVendedor, venda);
        setTotalProdutoBVendido(comissaoVendedor, venda);
        setTotalProdutoCVendido(comissaoVendedor, venda);
    }
    
    private void setTotalProdutoAVendido(Comissao comissaoVendedor, Venda venda) {
        int quantidadeTotaldoProdutoA = comissaoVendedor.getQtdeTotalProdutoA();
        int quantidadeProdutoAEmUmaVenda = venda.getQtdeProdutoA();
        comissaoVendedor.setQtdeTotalProdutoA(quantidadeTotaldoProdutoA + quantidadeProdutoAEmUmaVenda);
    }
    
    private void setTotalProdutoBVendido(Comissao comissaoVendedor, Venda venda) {
        int quantidadeTotaldoProdutoB = comissaoVendedor.getQtdeTotalProdutoB();
        int quantidadeProdutoBEmUmaVenda = venda.getQtdeProdutoB();
        comissaoVendedor.setQtdeTotalProdutoB(quantidadeTotaldoProdutoB + quantidadeProdutoBEmUmaVenda);
    }
    
    private void setTotalProdutoCVendido(Comissao comissaoVendedor, Venda venda) {
        int quantidadeTotaldoProdutoC = comissaoVendedor.getQtdeTotalProdutoC();
        int quantidadeProdutoCEmUmaVenda = venda.getQtdeProdutoC();
        comissaoVendedor.setQtdeTotalProdutoC(quantidadeTotaldoProdutoC + quantidadeProdutoCEmUmaVenda);
    }
    
    public List getPrecosNoMes(List<Preco> listaPrecos, int mes) {
        List listaPrecoNoMes = new ArrayList<Preco>();

        for (Preco p : listaPrecos) {
            if (p.getMes() <= mes) {
                listaPrecoNoMes.add(p);
            }
        }
        return listaPrecoNoMes;
    }

    public List getVendasNoMes(List<Venda> listaVendas, int mes) {
        List listaPrecoNoMes = new ArrayList<Venda>();

        for (Venda p : listaVendas) {
            if (p.getMes() <= mes) {
                listaPrecoNoMes.add(p);
            }
        }
        return listaPrecoNoMes;
    }

    public void setValorTotalPrecos(Map<String, Comissao> comissoes, List<Venda> vendas, List<Preco> precos, int mes) {
        List listaVendasNoMes = getVendasNoMes(vendas, mes);
        List listaPrecosNoMes = getPrecosNoMes(precos, mes);

        Set<String> codigosVendedores = comissoes.keySet();
        for (String codigoVendedor : codigosVendedores) {
            List<Double> valoresVendas = getValoresVendas(listaVendasNoMes, listaPrecosNoMes, codigoVendedor);
            setValorTotalProdutos(comissoes, codigoVendedor, valoresVendas);
        }
    }

    private void setValorTotalProdutos(Map<String, Comissao> comissoes, String codigoVendedor, List<Double> valoresVendas) {
        comissoes.get(codigoVendedor).setValorTotalProdutoA(valoresVendas.get(0));
        comissoes.get(codigoVendedor).setValorTotalProdutoB(valoresVendas.get(1));
        comissoes.get(codigoVendedor).setValorTotalProdutoC(valoresVendas.get(2));
        comissoes.get(codigoVendedor).setValorTotalGeral(valoresVendas.get(3));
    }

    public List<Double> getValoresVendas(List<Venda> listaVenda, List<Preco> listaPreco, String codVendedor){
        List<Double> valoresVendaNoDia = new ArrayList<Double>();
        double ultimoPrecoA = 0.0;
        double ultimoPrecoB = 0.0;
        double ultimoPrecoC = 0.0;

        double valorTotalProdutoA = 0.0;
        double valorTotalProdutoB = 0.0;
        double valorTotalProdutoC = 0.0;
        double valorTotalProdutoGeral = 0.0;

        for(Venda vend: listaVenda){
            if(vend.getCodVendedor().equals(codVendedor)){
                for(Preco prec : listaPreco){
                    if(vend.getDia() >= prec.getDia()){
                        ultimoPrecoA = prec.getPrecoProdA();
                        ultimoPrecoB = prec.getPrecoProdB();
                        ultimoPrecoC = prec.getPrecoProdC();
                    }
                }

                valorTotalProdutoA += ultimoPrecoA * vend.getQtdeProdutoA();
                valorTotalProdutoB += ultimoPrecoB * vend.getQtdeProdutoB();
                valorTotalProdutoC += ultimoPrecoC * vend.getQtdeProdutoC();
            }
        }
        valorTotalProdutoGeral = valorTotalProdutoA + valorTotalProdutoB + valorTotalProdutoC;
        
        valoresVendaNoDia.add(CalculoUtils.roundTwoDecimals(valorTotalProdutoA));
        valoresVendaNoDia.add(CalculoUtils.roundTwoDecimals(valorTotalProdutoB));
        valoresVendaNoDia.add(CalculoUtils.roundTwoDecimals(valorTotalProdutoC));
        valoresVendaNoDia.add(CalculoUtils.roundTwoDecimals(valorTotalProdutoGeral));
        
        return valoresVendaNoDia;
    }
}
