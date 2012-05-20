/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho1;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Amandaa
 */
public class Main {
    
    public void main(String[] args) throws acessoArquivoException{
        
        int mes;
        String arqVendas = "";
        String arqPrecos = "";
        String arqVendedores = "";
        String arqComissao = "";       
        Scanner scanner = new Scanner(System.in);        
        
        acessoArquivoVenda accArqVenda = new acessoArquivoVenda();
        acessoArquivoPreco accArqPreco = new acessoArquivoPreco();        
        acessoArquivoVendedor accArqVendedor = new acessoArquivoVendedor();
        acessoArquivoComissao accArqComissao = new acessoArquivoComissao();
        
        Comissao com = new Comissao();
        
        List<Venda> listaVenda = new ArrayList<Venda>();
        List<Preco> listaPreco = new ArrayList<Preco>();
        List<Vendedor> listaVendedor = new ArrayList<Vendedor>();               
        List<Comissao> comissao = new ArrayList<Comissao>();
        
        mes = Integer.parseInt(scanner.nextLine());
        arqVendas = scanner.nextLine();
        arqPrecos = scanner.nextLine();
        arqVendedores = scanner.nextLine();
        arqComissao = scanner.nextLine();
        
        listaVenda = accArqVenda.ler(new File(arqVendas));
        getVendasNoMes(mes, listaVenda);
        listaPreco = accArqPreco.ler(new File(arqPrecos));
        listaVendedor = accArqVendedor.ler(new File(arqVendedores));
        
        int categoria = 0;
        for (int i = 0; i < listaVendedor.size(); i++){
            categoria = listaVendedor.get(i).getCategoria();
            if (categoria == 1){
                //com.calculaComissaoCat1();
            }                       
            if (categoria == 2) {
                //com.calculaComissaoCat2();
            }            
            comissao.add(com);
        }
        
    }
    
    /* Essa função compara o mês entrado com os meses presentes no arquivo de venda.
    * Para cada ocorrência de igualdade, a linha de venda é adicionada em um array.
    */
    public void getVendasNoMes(int mes, List<Venda> listaVenda) throws acessoArquivoException {        
                
        for (int i = 0; i < listaVenda.size(); i++)
            if (mes == listaVenda.get(i).getMes())
            listaVenda.remove(listaVenda.get(i));          
    }
}
