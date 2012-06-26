/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho1.RegrasCalculo;

import java.text.DecimalFormat;

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
}
