/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Bianca e Filipe
 */
public class acessoArquivoComissao extends acessoArquivo {

    public static final String DELIMITADOR = ";";
    public static final int NUM_CAMPOS = 8;

    @Override
    public List<CalculoComissao> ler(File file) throws acessoArquivoException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public void escrever(Map<String, Comissao> comissoes, String ARQUIVO_COMISSAO) throws acessoArquivoException {
        BufferedWriter writer = null;

        try {
            try {
                writer = new BufferedWriter(new FileWriter(new File(ARQUIVO_COMISSAO)), 4096);
                
                Set<String> keySet = comissoes.keySet();
                for(String s: keySet){
                    Comissao comissao = comissoes.get(s); 
                    
                    int mes = comissao.getMes();
                    String codigo = comissao.getCodigo();
                    String nome = comissao.getNome();
                    Double valorTotalA = comissao.getValorTotalProdutoA();
                    Double valorTotalB = comissao.getValorTotalProdutoB();
                    Double valorTotalC = comissao.getValorTotalProdutoC();
                    Double valorTotalGeral = comissao.getValorTotalGeral();
                    Double valorComissao = comissao.getComissao();
                    
                    writer.write(Integer.toString(mes) + ";" + 
                                codigo + ";" + nome + ";" + 
                                Double.toString(valorTotalA) + ";" +
                                Double.toString(valorTotalB) + ";" + 
                                Double.toString(valorTotalC) + ";" + 
                                Double.toString(valorTotalGeral) + ";" + 
                                Double.toString(valorComissao));
                    
                    writer.newLine();
                }

            } finally {
                if (writer != null) {
                    writer.close();
                }
            }
        } catch (IOException e) {
            throw new acessoArquivoException("Erro ao escrever arquivo!");
        }
    }

    @Override
    protected void verificarPreCondicoes(String[] campos, int numCampos) throws acessoArquivoException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
