/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modulobugs;

import java.io.BufferedReader;
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

/**
 *
 * @author joaoflorao
 */
public class Icadastro_bug extends javax.swing.JFrame {
    private String filepath;
    private JFileChooser filename;
    
    /**
     * Creates new form Ipessoa
     */
    public Icadastro_bug() {
        this.filepath = "src/modulobugs/relatorio/bugs.csv";
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

        lbl_titulo_bug = new javax.swing.JLabel();
        lbl_status_bug = new javax.swing.JLabel();
        lbl_descricao_bug = new javax.swing.JLabel();
        lbl_passos_reproducao = new javax.swing.JLabel();
        lbl_classificacao_bug = new javax.swing.JLabel();
        bt_cadastrar_bug = new javax.swing.JButton();
        txt_titulo_bug = new javax.swing.JTextField();
        btn_limpar_campos_bug = new javax.swing.JButton();
        jcombo_status_bug = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_descricao_bug = new javax.swing.JTextArea();
        jcombo_classificacao_bug = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_passos_reproducao = new javax.swing.JTextArea();
        btn_anexar_arquivo = new javax.swing.JButton();
        lbl_anexar_arquivo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbl_titulo_bug.setText("Título do Bug:");

        lbl_status_bug.setText("Status:");
        lbl_status_bug.setToolTipText("");

        lbl_descricao_bug.setText("Descrição:");

        lbl_passos_reproducao.setText("Passos de Reprodução:");

        lbl_classificacao_bug.setText("Classificação:");

        bt_cadastrar_bug.setText("Cadastrar");
        bt_cadastrar_bug.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cadastrar_bugActionPerformed(evt);
            }
        });

        txt_titulo_bug.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_titulo_bugActionPerformed(evt);
            }
        });

        btn_limpar_campos_bug.setText("Limpar");
        btn_limpar_campos_bug.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_limpar_campos_bugActionPerformed(evt);
            }
        });

        jcombo_status_bug.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Aberto", "Em andamento", "Em teste", "Fechado", "Reaberto" }));
        jcombo_status_bug.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcombo_status_bugActionPerformed(evt);
            }
        });

        txt_descricao_bug.setColumns(20);
        txt_descricao_bug.setRows(5);
        jScrollPane1.setViewportView(txt_descricao_bug);

        jcombo_classificacao_bug.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Não definido", "Desenvolvimento", "Ambiente", "Especificação", "Usabilidade", "Teste", "Melhoria" }));

        txt_passos_reproducao.setColumns(20);
        txt_passos_reproducao.setRows(5);
        jScrollPane2.setViewportView(txt_passos_reproducao);

        btn_anexar_arquivo.setText("Choose a file...");
        btn_anexar_arquivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_anexar_arquivoActionPerformed(evt);
            }
        });

        lbl_anexar_arquivo.setText("Anexar arquivo:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(203, 203, 203)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbl_passos_reproducao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_descricao_bug, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_status_bug, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_titulo_bug, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_titulo_bug)
                            .addComponent(jcombo_status_bug, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btn_limpar_campos_bug, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bt_cadastrar_bug))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_classificacao_bug, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_anexar_arquivo, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcombo_classificacao_bug, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_anexar_arquivo))))
                .addContainerGap(273, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(145, 145, 145)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_titulo_bug)
                    .addComponent(txt_titulo_bug, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_status_bug)
                    .addComponent(jcombo_status_bug, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_descricao_bug)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_passos_reproducao)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_anexar_arquivo)
                    .addComponent(lbl_anexar_arquivo))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcombo_classificacao_bug, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_classificacao_bug))
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_cadastrar_bug)
                    .addComponent(btn_limpar_campos_bug))
                .addContainerGap(71, Short.MAX_VALUE))
        );

        lbl_passos_reproducao.getAccessibleContext().setAccessibleName("Passos de reprodução:");
        lbl_anexar_arquivo.getAccessibleContext().setAccessibleName("Anexar arquivo:");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_cadastrar_bugActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cadastrar_bugActionPerformed
        File directory = new File(this.filepath).getParentFile();
        if (!directory.exists()) {
            directory.mkdirs(); // Crie o diretório se ele não existir
        }
        
        String titulo = txt_titulo_bug.getText();
        String status = (String) jcombo_status_bug.getSelectedItem();
        String descricao = txt_descricao_bug.getText();
        String reproducao = txt_passos_reproducao.getText();
        String filename = "teste";
        String classificacao = (String) jcombo_classificacao_bug.getSelectedItem();
        
        try {
            
            BugManager manager = new BugManager(this.filepath);
            
            List<Bug> bugs = manager.Ler();
            
            manager.Cadastrar(bugs, titulo, status, descricao, reproducao, filename, classificacao);
            
            
        } catch (IOException ex) {
            Logger.getLogger(Icadastro_bug.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.btn_limpar_campos_bugActionPerformed(evt);
    }//GEN-LAST:event_bt_cadastrar_bugActionPerformed

    private void txt_titulo_bugActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_titulo_bugActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_titulo_bugActionPerformed

    private void btn_limpar_campos_bugActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limpar_campos_bugActionPerformed
        // TODO add your handling code here:
        txt_titulo_bug.setText("");
        txt_passos_reproducao.setText("");
        txt_descricao_bug.setText("");
        jcombo_status_bug.setSelectedItem("Aberto");
        jcombo_classificacao_bug.setSelectedItem("Não definido");
    }//GEN-LAST:event_btn_limpar_campos_bugActionPerformed

    private void jcombo_status_bugActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcombo_status_bugActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jcombo_status_bugActionPerformed

    private void btn_anexar_arquivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_anexar_arquivoActionPerformed
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(this);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            java.io.File selectedFile = fileChooser.getSelectedFile();
            System.out.println(selectedFile);
        }
    }//GEN-LAST:event_btn_anexar_arquivoActionPerformed

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
            java.util.logging.Logger.getLogger(Icadastro_bug.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Icadastro_bug.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Icadastro_bug.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Icadastro_bug.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Icadastro_bug().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_cadastrar_bug;
    private javax.swing.JButton btn_anexar_arquivo;
    private javax.swing.JButton btn_limpar_campos_bug;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> jcombo_classificacao_bug;
    private javax.swing.JComboBox<String> jcombo_status_bug;
    private javax.swing.JLabel lbl_anexar_arquivo;
    private javax.swing.JLabel lbl_classificacao_bug;
    private javax.swing.JLabel lbl_descricao_bug;
    private javax.swing.JLabel lbl_passos_reproducao;
    private javax.swing.JLabel lbl_status_bug;
    private javax.swing.JLabel lbl_titulo_bug;
    private javax.swing.JTextArea txt_descricao_bug;
    private javax.swing.JTextArea txt_passos_reproducao;
    private javax.swing.JTextField txt_titulo_bug;
    // End of variables declaration//GEN-END:variables
}