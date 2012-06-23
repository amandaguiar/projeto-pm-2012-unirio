/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package trabalho1.AcessoArquivo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import trabalho1.ObjetosNegocio.Comissao;
import trabalho1.DataUtil.DataUtilException;
import trabalho1.ObjetosNegocio.Vendedor;

/**
 *
 * @author Roberta
 */
public class acessoArquivoVendedor extends acessoArquivo{
    public static final int POS_COD = 0;  //Posição do código do vendedor no arquivo.
    public static final int POS_NOME = 1; // Posição do nome do vendedor no arquivo.
    public static final int POS_CATEGORIA = 2; //Posição categoria do vendedor no arquivo.
    public static final int NUM_CAMPOS = 3;   //Número de campos contidos em uma linha do arquivo.

    @Override
    protected void verificarPreCondicoes(String[] campos) throws acessoArquivoException{
        verificarQtdeCamposValidos(campos, NUM_CAMPOS);
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
            throw new acessoArquivoException(acessoArquivo.MSG_CATEGORIA_VENDEDOR_INVALIDA);
        }
    }

    @Override
    public void escrever(Map<String, Comissao> comissoes, String ARQUIVO_COMISSAO) throws acessoArquivoException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    //Cria um objeto Vendedor a partir de um array de strings
    @Override
    protected Object criarObjeto(String[] campos) throws DataUtilException {
        Vendedor vendedor = null;
        vendedor = new Vendedor(campos[POS_COD],campos[POS_NOME],Integer.parseInt(campos[POS_CATEGORIA]));
        
        return vendedor;
    }
}