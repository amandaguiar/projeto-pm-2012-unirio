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
    
    public static void main(String[] args) throws acessoArquivoException{
        
        int mes;
        String arqVendas = "";
        String arqPrecos = "";
        String arqVendedores = "";
        String arqComissao = "";       
        Scanner scanner = new Scanner(System.in);        
        
        mes = Integer.parseInt(scanner.nextLine());
        arqVendas = scanner.nextLine();
        arqPrecos = scanner.nextLine();
        arqVendedores = scanner.nextLine();
        arqComissao = scanner.nextLine();        
        
        CalculoComissao cc = new CalculoComissao();        
        cc.gerarComissao(mes, arqVendas, arqPrecos, arqVendedores, arqComissao);        
        
        
    }
    
    /* Essa função compara o mês entrado com os meses presentes no arquivo de venda.
    * Para cada ocorrência de igualdade, a linha de venda é adicionada em um array.
    */
//    public List<Venda> getVendasNoMes(int mes, List<Venda> listaVenda) throws acessoArquivoException {        
//        List<Venda> vendasNoMes = null;       
//        
//        for (int i = 0; i < listaVenda.size(); i++)
//            if (mes == listaVenda.get(i).getMes())
//            vendasNoMes.add(listaVenda.get(i));
//        return vendasNoMes;  
//    }
}
