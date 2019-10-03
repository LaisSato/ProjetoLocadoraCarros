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
public class Cadastro_vendas extends javax.swing.JDialog {

    float diaria, valor, total;
     
    /**
     * Creates new form Cadastro_vendas
     */
    public Cadastro_vendas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    private void cadastrar(){
        try{

            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection
            ("jdbc:mysql://127.0.0.1/Project","root","root");
            String query ="insert into tbAluguel(pagamento,codCliente,codFuncionario) values(?,?,?)";
            PreparedStatement CAD= con.prepareStatement(query);
            CAD.setString(1,(String)jComboBox1.getSelectedItem());
            CAD.setString(2,jF_CPF.getText());
            CAD.setString(3,jT_CODFUNC.getText());
           
            CAD.executeUpdate();
            JOptionPane.showMessageDialog(null,"DADOS GRAVADOS");
            CAD.close();
            con.close();

        }catch(ClassNotFoundException e){
            System.out.println("DRIVE NÃO ENCONTRADO"+e);
        }catch(SQLException ex){
            System.out.println("ERRO DE GRAVAÇÃO NO BD"+ex);

        }
    }
   
    private void cadastrar2(){
        try{

            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection
            ("jdbc:mysql://127.0.0.1/Project","root","root");
            String query ="insert into tbAluguel(pagamento,codCliente,codFuncionario,codProduto,diaria,nf,valorUni,total)values(?,?,?,?,?,?,?,?)";
            PreparedStatement CAD= con.prepareStatement(query);
            
                diaria = Float.valueOf(jT_Diaria.getText());
                valor = Float.valueOf(jT_ValorUnit.getText());
                total = diaria * valor;
                jT_Total.setText(String.valueOf(total));
                
                  CAD.setString(1,(String)jComboBox1.getSelectedItem());
            CAD.setString(2,jF_CPF.getText());
            CAD.setString(3,jT_CODFUNC.getText());
           
             CAD.setString(4,jT_CodProduto.getText());
             CAD.setString(5,jT_Diaria.getText());
             CAD.setString(6,jT_Nota.getText());
             CAD.setString(7,jT_ValorUnit.getText());
             CAD.setString(8,jT_Total.getText());
    
               
             
            CAD.executeUpdate();
            
            CAD.close();
            con.close();

        }catch(ClassNotFoundException e){
            System.out.println("DRIVE NÃO ENCONTRADO"+e);
        }catch(SQLException ex){
            System.out.println("ERRO DE GRAVAÇÃO NO BD"+ex);

        }
    }
   
    private void select(){
        try{

            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection
            ("jdbc:mysql://127.0.0.1/project","root","root");
            String query ="select preco from tbProduto where idProduto like ?";
           PreparedStatement CAD= con.prepareStatement(query);
            
           CAD.setString(1,"%"+jT_CodProduto.getText()+"%");
           
            ResultSet rs; 
            
           rs=CAD.executeQuery(); 
           
            while(rs.next()){
            int Mat = rs.getInt("preco");
            jT_ValorUnit.setText(String.valueOf(Mat));
         }
             
            CAD.executeUpdate();
            
            CAD.close();
            con.close();

        }catch(ClassNotFoundException e){
            System.out.println("DRIVE NÃO ENCONTRADO"+e);
        }catch(SQLException ex){
            System.out.println("ERRO DE GRAVAÇÃO NO BD"+ex);

        }
    }
    
        public void selecao(){
     try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection
                        ("jdbc:mysql://127.0.0.1/project","root","root");
                
                String query = "select tbProduto.idProduto,tbProduto.nomecarro,tbProduto.preco,tbAluguel.diaria "
                        +"from tbProduto "
                        +"inner join tbAluguel ON tbAluguel.codProduto = tbProduto.idProduto "
                        +"where tbAluguel.idAluguel = ?";
                
                PreparedStatement stmp = con.prepareStatement(query);
                stmp.setString(1, jT_Nota.getText());
                ResultSet rs = stmp.executeQuery();
                DefaultTableModel model = (DefaultTableModel)jTable_Venda.getModel();
                model.setNumRows(0);
                
                while(rs.next()){
                  model.addRow(new Object[]{
                    rs.getString("tbProduto.idProduto"),
                    rs.getString("tbProduto.nomecarro"),
                    rs.getString("tbProduto.preco"),
                    rs.getString("tbAluguel.diaria")
                });}}  
             
              catch(ClassNotFoundException e){
           System.out.println("DRIVER NÃO ENCONTRADO"+e);
       }catch(SQLException ex){
           System.out.println("ERRO DE GRAVAÇÃO NO BD"+ex);
        }
    
    }
    
        public void total(){
            
             try{

            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection
            ("jdbc:mysql://127.0.0.1/project","root","root");
            String query ="select sum(total) AS total from tbAluguel where idAluguel like ?";
            PreparedStatement CAD= con.prepareStatement(query);
               
                CAD.setString(1,"%"+jT_Nota.getText()+"%");
                
                ResultSet  rs = CAD.executeQuery();
                
                if(rs.next()) {
                    String add0 = rs.getString("total");
                    jT_TotalFinal.setText("R$"+add0);
                }
            
        }catch(ClassNotFoundException e){
            System.out.println("DRIVE NÃO ENCONTRADO"+e);
        }catch(SQLException ex){
            System.out.println("ERRO DE GRAVAÇÃO NO BD"+ex);

        }
            
        }
        
        private void limpar(){
            jF_CPF.setText("");
            jT_CODFUNC.setText("");
            jT_Nota.setText("");
            jT_Diaria.setText("");
            jT_Total.setText("");
            jT_TotalFinal.setText("");
            jT_CodProduto.setText("");
            jT_ValorUnit.setText("");
        }
    
     private void estoque(){
     
     try{
         
         String cod_barras2=jT_CodProduto.getText();
         
         Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection
            ("jdbc:mysql://127.0.0.1/project","root","root");
            String query ="UPDATE tbProduto set quantidade = quantidade-1 WHERE idProduto='"+cod_barras2+"'";
            
            PreparedStatement CAD= con.prepareStatement(query);
            CAD.executeUpdate();
       
     }catch(ClassNotFoundException e){
            System.out.println("DRIVE NÃO ENCONTRADO"+e);
        }catch(SQLException ex){
            System.out.println("ERRO DE GRAVAÇÃO NO BD"+ex);

        }
            
        }
     
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jT_CodProduto = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jB_Venda = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_Venda = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jT_Diaria = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jT_Nota = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jT_TotalFinal = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jT_Total = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jT_ValorUnit = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jF_CPF = new javax.swing.JTextField();
        jT_CODFUNC = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CADASTRO DE VENDAS", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 36))); // NOI18N

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Realizar Venda", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 34))); // NOI18N

        jT_CodProduto.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                jT_CodProdutoCaretUpdate(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel1.setText("COD DO PRODUTO");

        jB_Venda.setBackground(new java.awt.Color(255, 255, 255));
        jB_Venda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/venda.jpg"))); // NOI18N
        jB_Venda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_VendaActionPerformed(evt);
            }
        });

        jTable_Venda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "COD", "PRODUTO", "PREÇO", "DIÁRIAS"
            }
        ));
        jScrollPane1.setViewportView(jTable_Venda);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel7.setText("DIARIA");

        jT_Diaria.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                jT_DiariaCaretUpdate(evt);
            }
        });
        jT_Diaria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jT_DiariaActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel11.setText("NOTA FISCAL");

        jT_Nota.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                jT_NotaCaretUpdate(evt);
            }
        });
        jT_Nota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jT_NotaActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel6.setText("TOTAL A PAGAR ");

        jT_TotalFinal.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jT_TotalFinal.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel4.setText("TOTAL");

        jT_Total.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jT_Total.setEnabled(false);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setText("VALOR DIARIA");

        jT_ValorUnit.setEnabled(false);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/images (2).jpg"))); // NOI18N
        jButton1.setText("CONCLUIR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel8.setText("MEIO DE PAGAMENTO");

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel10.setText("COD DO FUNCIONÁRIO");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("COD CLIENTE");

        jComboBox1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Escolher", "Dinheiro", "Cartão de Crédito", "Cartão de Débito" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 705, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel6)
                        .addGap(48, 48, 48)
                        .addComponent(jT_TotalFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(38, 38, 38)
                                .addComponent(jT_CodProduto))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jT_Nota, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGap(73, 73, 73)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jT_ValorUnit)
                                    .addComponent(jT_Diaria)
                                    .addComponent(jT_Total)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel10)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jF_CPF)
                            .addComponent(jT_CODFUNC)
                            .addComponent(jComboBox1, 0, 151, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jB_Venda, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(jLabel2))
                            .addComponent(jF_CPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jT_CODFUNC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jT_Nota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jT_CodProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jT_Diaria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jT_ValorUnit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jT_Total, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)))
                    .addComponent(jB_Venda, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(22, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jT_TotalFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)))))
        );

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/adf4ca102500cf7947b2b3a32e0585b3.jpg"))); // NOI18N

        jButton2.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jButton2.setText("NOVA VENDA");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jB_VendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_VendaActionPerformed
        
        
        cadastrar2();
         
        selecao();

        estoque();
        
        
    }//GEN-LAST:event_jB_VendaActionPerformed

    private void jT_CodProdutoCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_jT_CodProdutoCaretUpdate
       
        
        
        
        
    }//GEN-LAST:event_jT_CodProdutoCaretUpdate

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        total();
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      
        limpar();
        
        DefaultTableModel tableModel =
                (DefaultTableModel) jTable_Venda.getModel();
        tableModel.setNumRows(0);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jT_NotaCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_jT_NotaCaretUpdate
        
        
        
    }//GEN-LAST:event_jT_NotaCaretUpdate

    private void jT_NotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jT_NotaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jT_NotaActionPerformed

    private void jT_DiariaCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_jT_DiariaCaretUpdate
        // TODO add your handling code here:
        select ();
    }//GEN-LAST:event_jT_DiariaCaretUpdate

    private void jT_DiariaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jT_DiariaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jT_DiariaActionPerformed

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
            java.util.logging.Logger.getLogger(Cadastro_vendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cadastro_vendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cadastro_vendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cadastro_vendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Cadastro_vendas dialog = new Cadastro_vendas(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jB_Venda;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JTextField jF_CPF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jT_CODFUNC;
    private javax.swing.JTextField jT_CodProduto;
    private javax.swing.JTextField jT_Diaria;
    private javax.swing.JTextField jT_Nota;
    private javax.swing.JTextField jT_Total;
    private javax.swing.JTextField jT_TotalFinal;
    private javax.swing.JTextField jT_ValorUnit;
    private javax.swing.JTable jTable_Venda;
    // End of variables declaration//GEN-END:variables
}
