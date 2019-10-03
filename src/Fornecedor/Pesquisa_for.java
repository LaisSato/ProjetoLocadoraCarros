/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Fornecedor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 66873
 */
public class Pesquisa_for extends javax.swing.JDialog {

    /**
     * Creates new form Pesquisa_for
     */
    public Pesquisa_for(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
  private void deletar() {  
    try{
            Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Project","root","root");
            String query = "delete from tbFornecedor where idFornecedor = ?";
            PreparedStatement stmp = con.prepareStatement(query);
                stmp.setString(1,jTfor_cod.getText());

            String index;
            index = (String)tFornecedor.getModel().getValueAt(tFornecedor.getSelectedRow(), 0);
            stmp.setString(1, index);
            stmp.executeUpdate();
            JOptionPane.showMessageDialog(null,"Dados Excluídos com Sucesso!");
            
           jT_Pesquisar.setText("");
           jTempresa.setText("");
           jF_pes_cnpj.setText("");
           jTfor_cod.setText("");
           jTendereco_for.setText("");
           jF_pes_tel.setText("");
           jTuf_for.setText("");
           jModelo.setText("");
           jF_pes_cep.setText("");
          
          
        }
        catch (ClassNotFoundException EX){
            JOptionPane.showMessageDialog(null,"Driver não encontrado!" +EX);
        }
        catch(SQLException E){
            JOptionPane.showMessageDialog(null,"Erro de gravação no banco" +E);
        }}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel6 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jB_Consultar = new javax.swing.JButton();
        jLabel41 = new javax.swing.JLabel();
        jT_Pesquisar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tFornecedor = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTempresa = new javax.swing.JTextField();
        jTfor_cod = new javax.swing.JTextField();
        jTendereco_for = new javax.swing.JTextField();
        jB_Alterar = new javax.swing.JButton();
        jTuf_for = new javax.swing.JTextField();
        jModelo = new javax.swing.JTextField();
        jF_pes_cnpj = new javax.swing.JFormattedTextField();
        jF_pes_tel = new javax.swing.JFormattedTextField();
        jF_pes_cep = new javax.swing.JFormattedTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "PESQUISA DO FORNECEDOR", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 36))); // NOI18N

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jB_Consultar.setBackground(new java.awt.Color(255, 255, 255));
        jB_Consultar.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jB_Consultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/images (3).jpg"))); // NOI18N
        jB_Consultar.setText("CONSULTAR");
        jB_Consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_ConsultarActionPerformed(evt);
            }
        });

        jLabel41.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel41.setText("COD DO FORNECEDOR");

        jT_Pesquisar.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                jT_PesquisarCaretUpdate(evt);
            }
        });
        jT_Pesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jT_PesquisarKeyReleased(evt);
            }
        });

        tFornecedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "EMPRESA", "CNPJ", "COD", "ENDEREÇO", "TELEFONE", "UF", "MODELO", "CEP"
            }
        ));
        tFornecedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tFornecedorMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tFornecedor);

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel2Layout.createSequentialGroup()
                .add(74, 74, 74)
                .add(jLabel41)
                .add(31, 31, 31)
                .add(jT_Pesquisar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 297, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(jB_Consultar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 233, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(42, 42, 42))
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 865, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(34, 34, 34))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel41)
                    .add(jB_Consultar)
                    .add(jT_Pesquisar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DADOS DO FORNECEDOR", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 24))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        jLabel1.setText("EMPRESA");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        jLabel2.setText("CNPJ");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        jLabel3.setText("COD");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        jLabel4.setText("TELEFONE");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        jLabel5.setText("ENDEREÇO");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        jLabel6.setText("UF");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        jLabel7.setText("MODELO");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        jLabel8.setText("CEP");

        jB_Alterar.setBackground(new java.awt.Color(255, 255, 255));
        jB_Alterar.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jB_Alterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/images (2).jpg"))); // NOI18N
        jB_Alterar.setText("ALTERAR CADASTRO");
        jB_Alterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_AlterarActionPerformed(evt);
            }
        });

        jTuf_for.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTuf_forActionPerformed(evt);
            }
        });

        try {
            jF_pes_cnpj.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###/##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            jF_pes_tel.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            jF_pes_cep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/edit_delete.png"))); // NOI18N
        jButton1.setText("EXCLUIR CADASTRO");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                        .add(20, 20, 20)
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel5)
                            .add(jLabel2)
                            .add(jLabel1)
                            .add(jLabel3))
                        .add(22, 22, 22)
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jF_pes_cnpj, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 239, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, jTempresa, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 239, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(149, 149, 149))
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(122, 122, 122)
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(jTfor_cod)
                            .add(jTendereco_for)
                            .add(jB_Alterar, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .add(143, 143, 143)))
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel4)
                            .add(jLabel6)
                            .add(jLabel7)
                            .add(jLabel8))
                        .add(18, 18, 18)
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(jTuf_for)
                            .add(jModelo)
                            .add(jF_pes_tel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                            .add(jF_pes_cep)))
                    .add(jButton1))
                .add(0, 39, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(53, 53, 53)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                        .add(jLabel1)
                        .add(jTempresa, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                        .add(jLabel4)
                        .add(jF_pes_tel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .add(38, 38, 38)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel2)
                    .add(jLabel6)
                    .add(jTuf_for, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jF_pes_cnpj, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(40, 40, 40)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel3)
                    .add(jTfor_cod, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel7)
                    .add(jModelo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(36, 36, 36)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel5)
                    .add(jTendereco_for, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel8)
                    .add(jF_pes_cep, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 55, Short.MAX_VALUE)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jB_Alterar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 35, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jButton1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 35, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(32, 32, 32))
        );

        org.jdesktop.layout.GroupLayout jPanel6Layout = new org.jdesktop.layout.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel6Layout.createSequentialGroup()
                        .add(43, 43, 43)
                        .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(1050, 1050, 1050))
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel6, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(jPanel6, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 712, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(0, 2, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(999, 752));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jB_ConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_ConsultarActionPerformed
     
        try{
            
            Class.forName("com.mysql.jdbc.Driver");
           Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Project","root","root");
          String query = "select * from tbFornecedor where idFornecedor like ?";   
          PreparedStatement stmp= con.prepareStatement(query); 
          
          stmp.setString(1,"%"+jT_Pesquisar.getText()+"%" );
          
          ResultSet rs = stmp.executeQuery();
          
    DefaultTableModel model =(DefaultTableModel)tFornecedor.getModel();
    
          model.setNumRows(0);
          
          while(rs.next()){
              
            model.addRow(new Object[]{
                
                rs.getString("empresa"),
                rs.getString("cnpj"),
                rs.getString("idFornecedor"),
                rs.getString("endereco"),
                rs.getString("telefone"),
                rs.getString("uf"),
                rs.getString("modelo"),
                rs.getString("cep"),
                
            } ); }
              
       }catch(ClassNotFoundException EX ){
        JOptionPane.showMessageDialog(null,"DRIVE NÃO ENCONTRADO "+EX);
    }
        catch(SQLException E){
            JOptionPane.showMessageDialog(null," ERRO DE SQL" +E);
      }
    }//GEN-LAST:event_jB_ConsultarActionPerformed

    private void jTuf_forActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTuf_forActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTuf_forActionPerformed

    private void jB_AlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_AlterarActionPerformed
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/project", "root", "root");

            String query= " update tbFornecedor set idFornecedor='"+jTfor_cod.getText()+"',"
            +" empresa='"+jTempresa.getText()+"',"
            +" cnpj='"+jF_pes_cnpj.getText()+"',"
            +" endereco='"+jTendereco_for.getText()+"',"
            +"telefone='"+jF_pes_tel.getText()+"',"
            +" uf='"+jTuf_for.getText()+"',"
            +" modelo='"+jModelo.getText()+"',"
            +" cep='"+jF_pes_cep.getText()+"'"
            +" where idFornecedor='"+jTfor_cod.getText()+"'";

            PreparedStatement alterar = con.prepareStatement(query);
            alterar.executeUpdate();
            JOptionPane.showMessageDialog(null, "DADOS ALTERADOS!");
            alterar.close();
            con.close();
            
            jT_Pesquisar.setText("");
           jTempresa.setText("");
           jF_pes_cnpj.setText("");
           jTfor_cod.setText("");
           jTendereco_for.setText("");
           jF_pes_tel.setText("");
           jTuf_for.setText("");
           jModelo.setText("");
           jF_pes_cep.setText("");
          
           
        } catch (ClassNotFoundException ES) {
            JOptionPane.showMessageDialog(null, "ERRO DE DRIVER" + ES);
        } catch (SQLException E) {
            JOptionPane.showMessageDialog(null, "ERRO DE SQL" + E);
        }
    }//GEN-LAST:event_jB_AlterarActionPerformed

    private void tFornecedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tFornecedorMouseClicked
        int row = tFornecedor. getSelectedRow();
   jTempresa.setText(tFornecedor.getModel().getValueAt(row,0).toString()); 
   jF_pes_cnpj.setText(tFornecedor.getModel().getValueAt(row,1).toString());
   jTfor_cod.setText(tFornecedor.getModel().getValueAt(row,2).toString());
   jTendereco_for.setText(tFornecedor.getModel().getValueAt(row,3).toString());
   jF_pes_tel.setText(tFornecedor.getModel().getValueAt(row,4).toString());
   jTuf_for.setText(tFornecedor.getModel().getValueAt(row,5).toString());
   jModelo.setText(tFornecedor.getModel().getValueAt(row,6).toString());
   jF_pes_cep.setText(tFornecedor.getModel().getValueAt(row,7).toString());
  
    }//GEN-LAST:event_tFornecedorMouseClicked

    private void jT_PesquisarCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_jT_PesquisarCaretUpdate
   
    }//GEN-LAST:event_jT_PesquisarCaretUpdate

    private void jT_PesquisarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jT_PesquisarKeyReleased

    }//GEN-LAST:event_jT_PesquisarKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
 deletar();      
        DefaultTableModel tableModel =
                (DefaultTableModel) tFornecedor.getModel();
        tableModel.setNumRows(0);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Pesquisa_for.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pesquisa_for.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pesquisa_for.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pesquisa_for.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Pesquisa_for dialog = new Pesquisa_for(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jB_Alterar;
    private javax.swing.JButton jB_Consultar;
    private javax.swing.JButton jButton1;
    private javax.swing.JFormattedTextField jF_pes_cep;
    private javax.swing.JFormattedTextField jF_pes_cnpj;
    private javax.swing.JFormattedTextField jF_pes_tel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField jModelo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jT_Pesquisar;
    private javax.swing.JTextField jTempresa;
    private javax.swing.JTextField jTendereco_for;
    private javax.swing.JTextField jTfor_cod;
    private javax.swing.JTextField jTuf_for;
    private javax.swing.JTable tFornecedor;
    // End of variables declaration//GEN-END:variables
}
