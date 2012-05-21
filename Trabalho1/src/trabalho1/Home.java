/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Home.java
 *
 * Created on 20/05/2012, 22:44:21
 */
package trabalho1;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Amandaa
 */
public class Home extends javax.swing.JPanel {

    /** Creates new form Home */
    public Home() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        lblMes = new javax.swing.JLabel();
        lblVenda = new javax.swing.JLabel();
        lblComissao = new javax.swing.JLabel();
        lblVendedor = new javax.swing.JLabel();
        lblPreco = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        btnCalcular = new javax.swing.JButton();
        txtMes = new javax.swing.JTextField();
        txtVenda = new javax.swing.JTextField();
        txtPreco = new javax.swing.JTextField();
        txtVendedor = new javax.swing.JTextField();
        txtComissao = new javax.swing.JTextField();

        jTextField1.setText("jTextField1");

        setBackground(new java.awt.Color(102, 102, 102));
        setForeground(new java.awt.Color(255, 255, 255));

        lblMes.setFont(new java.awt.Font("Tahoma", 0, 12));
        lblMes.setForeground(new java.awt.Color(255, 255, 255));
        lblMes.setText("Mês:");

        lblVenda.setFont(new java.awt.Font("Tahoma", 0, 12));
        lblVenda.setForeground(new java.awt.Color(255, 255, 255));
        lblVenda.setText("Nome arquivo Vendas:");

        lblComissao.setFont(new java.awt.Font("Tahoma", 0, 12));
        lblComissao.setForeground(new java.awt.Color(255, 255, 255));
        lblComissao.setText("Nome arquivo Comissão:");

        lblVendedor.setFont(new java.awt.Font("Tahoma", 0, 12));
        lblVendedor.setForeground(new java.awt.Color(255, 255, 255));
        lblVendedor.setText("Nome arquivo Vendedor:");

        lblPreco.setFont(new java.awt.Font("Tahoma", 0, 12));
        lblPreco.setForeground(new java.awt.Color(255, 255, 255));
        lblPreco.setText("Nome arquivo Preço:");

        lblTitulo.setBackground(new java.awt.Color(0, 102, 102));
        lblTitulo.setFont(new java.awt.Font("Tahoma", 0, 18));
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setText("Cálculo de Comissão");

        btnCalcular.setBackground(new java.awt.Color(102, 102, 102));
        btnCalcular.setFont(new java.awt.Font("Tahoma", 0, 12));
        btnCalcular.setText("Calcular");
        btnCalcular.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCalcularMouseClicked(evt);
            }
        });

        txtPreco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblVendedor)
                            .addComponent(lblVenda)
                            .addComponent(lblPreco)
                            .addComponent(lblMes)
                            .addComponent(lblComissao))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTitulo)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtVendedor)
                                    .addComponent(txtComissao)
                                    .addComponent(txtVenda)
                                    .addComponent(txtMes, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPreco, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(186, 186, 186)
                        .addComponent(btnCalcular, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMes)
                    .addComponent(txtMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPreco)
                    .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblVenda)
                    .addComponent(txtVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblVendedor)
                    .addComponent(txtVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtComissao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblComissao))
                .addGap(33, 33, 33)
                .addComponent(btnCalcular)
                .addContainerGap(45, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtPrecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecoActionPerformed

    private void btnCalcularMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCalcularMouseClicked
        
        int mes = Integer.parseInt(txtMes.getText());
        String arqVendas = txtVenda.getText();
        String arqPrecos = txtPreco.getText();
        String arqVendedores = txtVendedor.getText();
        String arqComissao = txtComissao.getText();    
        
        Map<String, Comissao> comissoes = new HashMap<String,Comissao>();
        acessoArquivoComissao accArqComissao = new acessoArquivoComissao();
        CalculoComissao cc = new CalculoComissao();        
        try {
            comissoes = cc.gerarComissoes(mes, arqVendas, arqPrecos, arqVendedores, arqComissao);
        } catch (acessoArquivoException ex) {
            MostraMensagemErro(ex.getMessage());
        }
        try {
            accArqComissao.escrever(comissoes, new File(arqComissao));
        } catch (acessoArquivoException ex) {
            MostraMensagemErro(ex.getMessage());
        }
        
    }//GEN-LAST:event_btnCalcularMouseClicked

    private void MostraMensagemErro(String message){
        JOptionPane.showMessageDialog(this, "Erro: " + message, "Erro", JOptionPane.ERROR_MESSAGE);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCalcular;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lblComissao;
    private javax.swing.JLabel lblMes;
    private javax.swing.JLabel lblPreco;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblVenda;
    private javax.swing.JLabel lblVendedor;
    private javax.swing.JTextField txtComissao;
    private javax.swing.JTextField txtMes;
    private javax.swing.JTextField txtPreco;
    private javax.swing.JTextField txtVenda;
    private javax.swing.JTextField txtVendedor;
    // End of variables declaration//GEN-END:variables
}
