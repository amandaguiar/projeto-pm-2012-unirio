/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package trabalho1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Roberta
 */
public class acessoArquivoVendedor extends acessoArquivo{
    public static final String DELIMITADOR = ";";  //Delimitador de cada campo no arquivo.
    public static final String MSG_ERRO_VENDEDOR_INVALIDO = "Arquivo inválido!";
    public static final int POS_COD = 0;  //Posição do código do vendedor no arquivo.
    public static final int POS_NOME = 1; // Posição do nome do vendedor no arquivo.
    public static final int POS_CATEGORIA = 2; //Posição categoria do vendedor no arquivo.
    public static final int numCampos = 3;   //Número de campos contidos em uma linha do arquivo.

    @Override
    public List<Vendedor> ler(File file) throws acessoArquivoException{
        
        BufferedReader reader = null;
        List listaVendedores = new ArrayList<Vendedor>();
        String[] campos = null;
        try {
            try {
                reader = new BufferedReader(new FileReader(file));
                String linha;
                while (reader.ready()) {
                    campos = reader.readLine().split(DELIMITADOR);
                    verificarPreCondicoes(campos);
                    listaVendedores.add(new Vendedor(campos[POS_COD],
                                        campos[POS_NOME], 
                                        Integer.parseInt(campos[POS_CATEGORIA])));
                }
            } finally{
                if(reader != null)
                    reader.close();
            }
        } catch(IOException ex){
            listaVendedores = null;
            throw new acessoArquivoException(MSG_ERRO_VENDEDOR_INVALIDO);
        } catch(acessoArquivoException ex){
            listaVendedores = null;
            throw new acessoArquivoException(ex.getMessage());
        }
        
        return listaVendedores;
    }
    
    @Override
    public void verificarPreCondicoes(String[] campos) throws acessoArquivoException{
        verificarQtdeCamposValidos(campos, numCampos);
        verificarCategoria(campos[POS_CATEGORIA]);
    }
    
    //Verifica se as categorias informadas são válidas (1 ou 2).
    public void verificarCategoria(String categoria) throws acessoArquivoException{
        if (Integer.parseInt(categoria) != 1 || Integer.parseInt(categoria) != 2 ) {
            throw new acessoArquivoException(MSG_ERRO_VENDEDOR_INVALIDO);
        }
    }
    
}