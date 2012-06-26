/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho1.RegrasCalculo;

import java.text.DecimalFormat;
import java.util.GregorianCalendar;
import java.util.List;
import trabalho1.ObjetosNegocio.Preco;

/**
 *
 * @author Bianca
 */
public class CalculoUtils {
    
        public static double roundTwoDecimals(double d) {
        
            DecimalFormat twoDForm = new DecimalFormat(".00");
            String format = twoDForm.format(d);
            String replace = format.replace(",", ".");
            return Double.valueOf(replace);
        
        }
        
        public static Preco obterPrecoEmData(List<Preco> precos, GregorianCalendar data) {
            for (Preco preco : precos) {
                if (preco.getData().equals(data)) {
                    return preco;
                } else {
                    return obterUltimoPreco(precos, data);
                }
            }
            return null;
        }
        
        private static Preco obterUltimoPreco(List<Preco> precos, GregorianCalendar data) {
            Preco ultimoPreco = precos.get(0);
            for (Preco preco : precos) {
                if (preco.getData().before(data)) {
                    ultimoPreco = preco;
                }
            }
            return ultimoPreco;
       }
    
}
