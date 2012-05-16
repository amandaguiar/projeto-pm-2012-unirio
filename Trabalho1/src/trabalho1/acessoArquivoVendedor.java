/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package trabalho1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Jean
 */
public class acessoArquivoVendedor implements acessoArquivo{

    @Override
    public void ler(FileReader file) {
        BufferedReader reader = null;
        try {
            try {
                reader = new BufferedReader(new FileReader("Vendedor.txt"));
                String linha;
                while (reader.ready()) {
                    linha = reader.readLine();
                    linha.split(";");
                    
                    }
                    
                
            } finally {
                if (reader != null)
                    reader.close();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
        }
        
        throw new UnsupportedOperationException("Not supported yet.");
    }
    

    @Override
    public void escrever(ArrayList<Object> obj, FileWriter saida) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
