/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho1;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
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

        Map<String, Comissao> comissoes = new HashMap<String,Comissao>();
        acessoArquivoComissao accArqComissao = new acessoArquivoComissao();

        mes = Integer.parseInt(scanner.nextLine());
        arqVendas = scanner.nextLine();
        arqPrecos = scanner.nextLine();
        arqVendedores = scanner.nextLine();
        arqComissao = scanner.nextLine();        
        
        CalculoComissao cc = new CalculoComissao();        
        comissoes = cc.gerarComissoes(mes, arqVendas, arqPrecos, arqVendedores, arqComissao);        
        
        accArqComissao.escrever(comissoes, new File(arqComissao));
    }
}
