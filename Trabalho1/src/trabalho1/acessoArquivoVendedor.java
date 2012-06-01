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
import java.util.Map;

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
    public static final int NUM_CAMPOS = 3;   //Número de campos contidos em uma linha do arquivo.

    @Override
    public List<Vendedor> ler(File file) throws acessoArquivoException{
        
        BufferedReader reader = null;
        List listaVendedores = new ArrayList<Vendedor>();
        String[] campos = null;
        try {
            try {
                reader = new BufferedReader(new FileReader(file));
                while (reader.ready()) {
                    campos = reader.readLine().split(DELIMITADOR);
                    verificarPreCondicoes(campos, NUM_CAMPOS);
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
    protected void verificarPreCondicoes(String[] campos, int numCampos) throws acessoArquivoException{
        verificarQtdeCamposValidos(campos, numCampos);
        verificarValidadeCampos(campos);
    }

    //Verifica se os campos são válidos.
    protected void verificarValidadeCampos(String[] campos) throws acessoArquivoException{
        verificarValor(campos);
    }

    //Verifica se as categorias informadas são válidas (1 ou 2).
    public void verificarValor(String[] campos) throws acessoArquivoException{
        String categoria = campos[POS_CATEGORIA];
        if (!( Integer.parseInt(categoria) == 1 || Integer.parseInt(categoria) == 2)) {
            throw new acessoArquivoException(MSG_ERRO_VENDEDOR_INVALIDO);
        }
    }

    @Override
    public void escrever(Map<String, Comissao> comissoes, String ARQUIVO_COMISSAO) throws acessoArquivoException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}