/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modulobugs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author joaoflorao
 */
public class IListaBugs extends javax.swing.JFrame {
    private String filename;
    
    /**
     * Creates new form Ipessoa
     */
    public IListaBugs() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        txt_status = new javax.swing.JComboBox<>();
        lbl_status = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btn_mostar_tela = new javax.swing.JButton();
        teste = new javax.swing.JButton();

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txt_status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Aberto", "Em andamento", "Em teste", "Fechado", "Reaberto" }));

        lbl_status.setText("Filtrar por: ");

        jLabel1.setText("Relatório de Bugs");

        btn_mostar_tela.setText("Mostrar relatório");
        btn_mostar_tela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_mostar_telaActionPerformed(evt);
            }
        });

        teste.setText("Relatório em csv");
        teste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                testeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(403, 403, 403))
            .addGroup(layout.createSequentialGroup()
                .addGap(277, 277, 277)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(teste)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_mostar_tela))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbl_status)
                        .addGap(18, 18, 18)
                        .addComponent(txt_status, 0, 266, Short.MAX_VALUE)))
                .addGap(341, 341, 341))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jLabel1)
                .addGap(104, 104, 104)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_status))
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_mostar_tela)
                    .addComponent(teste))
                .addContainerGap(432, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_mostar_telaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_mostar_telaActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = new DefaultTableModel();
        JTable table = new JTable(model);

        model.addColumn("ID");
        model.addColumn("Titulo");
        model.addColumn("Status");
        model.addColumn("Descricao");
        model.addColumn("Reprodução");
        model.addColumn("File");
        model.addColumn("Classificacao");
        model.addColumn("Prioridade");
        model.addColumn("Data Cadastro");

        String status = (String) txt_status.getSelectedItem();

        
        BugManager manager = new BugManager();
            
        try{
            ResultSet rs = manager.ListarBugs(status);
            
            while (rs.next())
            {
                System.out.println(rs.getString("id"));
                model.addRow(new Object[]{
                    rs.getString("id"),
                    rs.getString("titulo"),
                    rs.getString("status"),
                    rs.getString("descricao"),
                    rs.getString("reproducao"),
                    rs.getString("file"),
                    rs.getString("classificacao"),
                    rs.getString("prioridade"),
                    rs.getString("data_cadastro")
                });
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        
        JFrame frame = new JFrame("Lista de bugs");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane);

        frame.pack();
        frame.setVisible(true);
    }//GEN-LAST:event_btn_mostar_telaActionPerformed

    private void testeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_testeActionPerformed
        // TODO add your handling code here:
        String status = (String) txt_status.getSelectedItem();
        String filepath = "src/modulobugs/relatorio/bugs.csv";
        
        BugManager manager = new BugManager();
        
        File file = new File(filepath);
        
        if (file.exists())
        {
            file.delete();
        }
         
        try{
            BufferedWriter buffWrite = new BufferedWriter(new FileWriter(filepath, true));
            ResultSet rs = manager.ListarBugs(status);
            
            while (rs.next())
            {
                String row = rs.getString("id") + ";" + rs.getString("titulo") + ";" + rs.getString("status") + ";" 
                + rs.getString("descricao") + ";" + rs.getString("reproducao") + ";" + rs.getString("file") + ";" 
                + rs.getString("classificacao") + ";" + rs.getString("prioridade") + ";"
                + rs.getString("data_cadastro");
                
                buffWrite.write(row);
                buffWrite.newLine();
            }
            buffWrite.close();
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        JOptionPane.showMessageDialog(null, 
                "Relatorio gerado em: " + filepath);
    }//GEN-LAST:event_testeActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(IListaBugs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IListaBugs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IListaBugs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IListaBugs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IListaBugs().setVisible(true);
            }
        });
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_mostar_tela;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbl_status;
    private javax.swing.JButton teste;
    private javax.swing.JComboBox<String> txt_status;
    // End of variables declaration//GEN-END:variables
}
