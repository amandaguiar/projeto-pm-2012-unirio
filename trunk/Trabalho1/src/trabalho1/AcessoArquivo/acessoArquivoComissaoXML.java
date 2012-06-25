/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho1.AcessoArquivo;

import java.beans.XMLEncoder;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import trabalho1.ObjetosNegocio.Comissao;

/**
 *
 * @author Amandaa
 */
public class acessoArquivoComissaoXML extends acessoArquivoXML {

    @Override
    public void escrever(Map<String, Comissao> comissoes, String ARQUIVO_COMISSAO) throws acessoArquivoException {               
        XMLEncoder encoder = null;
        try {
            try {                               
                encoder = new XMLEncoder(new FileOutputStream(ARQUIVO_COMISSAO));                        
                encoder.writeObject(comissoes);    
            } finally {
                if (encoder != null) {
                    encoder.close();
                }
            }
        } catch (IOException e) {
            throw new acessoArquivoException("Erro ao escrever arquivo!");
        }
        
    }

    
}
