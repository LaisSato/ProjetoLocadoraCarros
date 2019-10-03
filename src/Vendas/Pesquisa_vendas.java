    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vendas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Adriana
 */
public class Pesquisa_vendas extends javax.swing.JDialog {

    /**
     * Creates new form Pesquisa_vendas
     */
    public Pesquisa_vendas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    private void pesquisar(){
        try{

            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection
            ("jdbc:mysql://127.0.0.1/project","root","root");
            
                String query = "select tbCliente.cpf, tbAluguel.nf, tbAluguel.codFuncionario, tbAluguel.pagamento "
                        +"from tbCliente "
                        +" inner join tbAluguel ON tbAluguel.codCliente = tbCliente.idCliente "
                        +"where tbAluguel.idAluguel = ?";
                
            PreparedStatement stmp= conn.prepareStatement(query);
            //stmp.setString(1,"%"+jT_Pesquisar.getText()+"%" );
             stmp.setString(1, jT_Pesquisar.getText());
            ResultSet rs = stmp.executeQuery();
            DefaultTableModel model =(DefaultTableModel)jT_Vendas.getModel();
            model.setNumRows(0);

            while(rs.next()){

                model.addRow(new Object[]{
                    rs.getString("tbAluguel.nf"),
                    rs.getString("tbAluguel.codFuncionario"),
                    rs.getString("tbCliente.cpf"),
                    rs.getString("tbAluguel.pagamento"),
                    

                } ); }

            }catch(ClassNotFoundException EX ){
                JOptionPane.showMessageDialog(null,"DRIVE NÃO ENCONTRADO "+EX);
            }
            catch(SQLException E){
                JOptionPane.showMessageDialog(null," ERRO DE SQL" +E);
            }
    }
   
    private void pesquisar2(){
        try{

            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection
            ("jdbc:mysql://127.0.0.1/project","root","root");
            String query = "select * from tbAluguel where nf like ?";
            PreparedStatement stmp= conn.prepareStatement(query);
            stmp.setString(1,"%"+jT_Pesquisar.getText()+"%" );
            ResultSet rs = stmp.executeQuery();
            DefaultTableModel model =(DefaultTableModel)jT_Vendas2.getModel();
            model.setNumRows(0);

            while(rs.next()){

                model.addRow(new Object[]{
                    rs.getString("codProduto"),
                    rs.getString("diaria"),
                    rs.getString("valoruni"),
                    rs.getString("total"),

                } ); }

            }catch(ClassNotFoundException EX ){
                JOptionPane.showMessageDialog(null,"DRIVE NÃO ENCONTRADO "+EX);
            }
            catch(SQLException E){
                JOptionPane.showMessageDialog(null," ERRO DE SQL" +E);
            }
    }

   
    
        
    
    
    
    
              
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jB_Consultar = new javax.swing.JButton();
        jT_Pesquisar = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jT_Vendas = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jT_Vendas2 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "PESQUISA DE VENDAS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 36))); // NOI18N

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
        jLabel41.setText("COD DA VENDA");

        jT_Vendas.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jT_Vendas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "COD", "COD(FUNCIONÁRIO)", "CPF(CLIENTE)", "MEIO DE PAGAMENTO"
            }
        ));
        jT_Vendas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jT_VendasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jT_Vendas);

        jT_Vendas2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "PRODUTO", "QUANTIDADE", "VALOR UNITÁRIO", "VALOR TOTAL"
            }
        ));
        jT_Vendas2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jT_Vendas2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jT_Vendas2);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/LADOS.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/LADO.png"))); // NOI18N
        jLabel2.setText("jLabel2");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel41)
                        .addGap(26, 26, 26)
                        .addComponent(jT_Pesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jB_Consultar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 645, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 645, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel41)
                                    .addComponent(jT_Pesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jB_Consultar))
                                .addGap(29, 29, 29)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(213, 213, 213)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jB_ConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_ConsultarActionPerformed
        
        pesquisar();
        
        pesquisar2();
        
    }//GEN-LAST:event_jB_ConsultarActionPerformed

    private void jT_VendasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jT_VendasMouseClicked
  
    }//GEN-LAST:event_jT_VendasMouseClicked

    private void jT_Vendas2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jT_Vendas2MouseClicked
  
  
    }//GEN-LAST:event_jT_Vendas2MouseClicked

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
            java.util.logging.Logger.getLogger(Pesquisa_vendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pesquisa_vendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pesquisa_vendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pesquisa_vendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Pesquisa_vendas dialog = new Pesquisa_vendas(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jB_Consultar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jT_Pesquisar;
    private javax.swing.JTable jT_Vendas;
    private javax.swing.JTable jT_Vendas2;
    // End of variables declaration//GEN-END:variables
}