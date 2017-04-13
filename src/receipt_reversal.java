
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class receipt_reversal extends javax.swing.JFrame {

    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    private static receipt_reversal obj=null;
    
     //current date
       DateFormat dF = new SimpleDateFormat("yyyy-MM-dd");
       Date date = new Date();
       
    private receipt_reversal() {
        initComponents();
         conn = DbConnect.connecrDb();
         logo();
         current_date();
    }
       public static receipt_reversal getObj() {
        if (obj== null){
            obj = new receipt_reversal();
        }
      else{
         obj.setExtendedState(JFrame.NORMAL);
         obj.setAlwaysOnTop(true);
         obj.requestFocus();
       }
       return obj;
 }

     private void logo(){
    setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("images/LOG.png")));
    }
      public final void current_date(){
    
             String td=dF.format(date);
             current_date.setText(td);
    
    }
      private void reversereceipt(){
          if(rec_no.getText().isEmpty()|| amount.getText().isEmpty()||id.getText().isEmpty()){
                   
              JOptionPane.showMessageDialog(null, "<html><h4><font color='red'>Cannot Reverse </font></h4></html>");       
                }
       else{
          if(rec_no.getText().isEmpty()){
                   
              JOptionPane.showMessageDialog(null, "<html><h4><font color='red'>The Receipt No Cannot Be Found In Land Payments </font></h4></html>");       
                }
          else if(conn==null){
                 JOptionPane.showMessageDialog(null, "Could not connect to the server");
                     }
                else{
                        int a = Integer.parseInt(amount.getText());
                         
                         int currentbalance=a-a;
                         String  value1 = String.valueOf(currentbalance);
                 try {
                        
                         
                         String sql = "update receipt set amount= '"+value1+"'where receiptno='"+rec_no.getText().trim()+"'" ;
                         pst = conn.prepareStatement(sql);
                         pst.execute();
                      
                         String reversal="insert into [reversal](receiptno,initialamnt,reverseamnt,id)"
                                 + " values(?,?,?,?)";
                         
                             pst = conn.prepareStatement(reversal);
                             pst.setString(1, rec_no.getText().trim());
                             pst.setString(2, amount.getText().trim());
                             pst.setString(3, value1);
                             pst.setString(4, id.getText().trim());
                             pst.execute();
                            }
                         catch (SQLException ex) {
                             Logger.getLogger(receipt_reversal.class.getName()).log(Level.SEVERE, null, ex);
                         }
                        
           }
      }}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        amount = new javax.swing.JTextField();
        reverse_amount = new javax.swing.JButton();
        rec_no = new javax.swing.JTextField();
        property = new javax.swing.JComboBox<>();
        id = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        searchbyrec = new javax.swing.JButton();
        receipt_no = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        current_date = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Reversals");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("RECEIPT REVERSAL"));
        jPanel1.setToolTipText("");

        reverse_amount.setText("REVERSE");
        reverse_amount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reverse_amountActionPerformed(evt);
            }
        });

        property.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Land", "House", "Investment", "GZD" }));
        property.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                propertyActionPerformed(evt);
            }
        });

        jLabel1.setText("Id");

        jLabel2.setText("Receiptno");

        jLabel3.setText("Amount");

        searchbyrec.setText("SEARCH ");
        searchbyrec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchbyrecActionPerformed(evt);
            }
        });

        jLabel5.setText(" RECEITP NO:");

        jLabel6.setText("Property");

        current_date.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        current_date.setText("REVERSAL DATE");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(current_date, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(receipt_no, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(property, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addGap(29, 29, 29)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(id, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                                    .addComponent(rec_no)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(25, 25, 25)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(searchbyrec, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(amount, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(reverse_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(property, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(current_date))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(receipt_no, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchbyrec))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(rec_no, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(amount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(reverse_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/gakuyo.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE)
                        .addGap(22, 22, 22))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void searchbyrecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchbyrecActionPerformed
        if(receipt_no.getText().isEmpty()){
              JOptionPane.showMessageDialog(null, "<html><h4><font color='red'>Enter Receipt No!</font></h4></html>");       
                }
        else{
               if(conn==null){
            JOptionPane.showMessageDialog(null, "Could not connect to the server");
        }
                else{
                     try{
                         String check ="SELECT COUNT(*) AS total FROM receipt where receiptno = '"+receipt_no.getText()+"'"; 
                            pst=conn.prepareStatement(check);
                            rs = pst.executeQuery();
                            
                          while(rs.next()){
                              
                              if(rs.getInt("total")>0){
                                         
                              String gakuyo_zero_deposit= "select receiptno,cname,tdate,client_id,pdate,amount,branch,servedby from receipt where receiptno=?";

                        pst = conn.prepareStatement(gakuyo_zero_deposit);
                        pst.setString(1, receipt_no.getText());
                        rs=pst.executeQuery();
                        
                         while(rs.next()){
                             
                        rec_no.setText(rs.getString("receiptno"));
                        rec_no.setEnabled(false);
                        amount.setText(rs.getString("amount"));
                        amount.setEnabled(false);
                        id.setText(rs.getString("client_id"));
                        id.setEnabled(false);
                      }
                        
                         }
                        else{
                           JOptionPane.showMessageDialog(null, " No Transaction with Receipt No"+" "+receipt_no.getText());

                              }}}
                
           catch(SQLException e){
        JOptionPane.showMessageDialog(null, e);
    }   
       }}
        
    }//GEN-LAST:event_searchbyrecActionPerformed

    private void reverse_amountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reverse_amountActionPerformed
        if(rec_no.getText().isEmpty()|| amount.getText().isEmpty()||id.getText().isEmpty()){
              JOptionPane.showMessageDialog(null, "<html><h4><font color='red'>Cannot Reverse </font></h4></html>");       
                }
        else{
           if(conn==null){
            JOptionPane.showMessageDialog(null, "Could not connect to the server");
           }
         else{
               int a = Integer.parseInt(amount.getText());
                         int currentbalance=a-a;
                         
                         String  value1 = String.valueOf(currentbalance);
           if (property.getSelectedItem() == "Land"){
              
            if(rec_no.getText().isEmpty()){
                   
              JOptionPane.showMessageDialog(null, "<html><h4><font color='red'>The Receipt No Cannot Be Found In Land Payments </font></h4></html>");       
                }
             else{
               
                 try {   
                        String bal = "select balance from land where receiptno='"+rec_no.getText().trim()+"' ";
                         pst = conn.prepareStatement(bal);
                         rs = pst.executeQuery();
                         rs.next();
                         
                         int bl = Integer.parseInt(rs.getString("balance"));
                         int cbal = bl-a;
                         String  v = String.valueOf(cbal);
                         
                         String sql = "update land set amount= '"+value1+"',balance='"+v+"' where receiptno='"+rec_no.getText().trim()+"'" ;
                         pst = conn.prepareStatement(sql);
                         pst.execute();
                         
                     } catch (SQLException ex) {
                         Logger.getLogger(receipt_reversal.class.getName()).log(Level.SEVERE, null, ex);
                     }
            }
           
           }
            else if (property.getSelectedItem() == "House"){
                 if(rec_no.getText().isEmpty()){
                   
              JOptionPane.showMessageDialog(null, "<html><h4><font color='red'>The Receipt No Cannot Be Found In House Payments </font></h4></html>");       
                }
             else{
                      
                try {
                        String bal = "select balance from house where receiptno='"+rec_no.getText().trim()+"' ";
                         pst = conn.prepareStatement(bal);
                         rs = pst.executeQuery();
                         rs.next();
                         
                         int bl = Integer.parseInt(rs.getString("balance"));
                         int cbal = bl-a;
                         String  v = String.valueOf(cbal);
                       
                         
                         String sql = "update house set amount= '"+value1+"' balance= '"+v+"' where receiptno='"+rec_no.getText().trim()+"'" ;
                         pst = conn.prepareStatement(sql);
                         pst.execute();
                         
                     } catch (SQLException ex) {
                         Logger.getLogger(receipt_reversal.class.getName()).log(Level.SEVERE, null, ex);
                     }
            }
                }
           else if (property.getSelectedItem() == "GZD"){
                 if(rec_no.getText().isEmpty()){
                   
              JOptionPane.showMessageDialog(null, "<html><h4><font color='red'>The Receipt No Cannot Be Found In GZD Payments </font></h4></html>");       
                }
             else{
                      
                     try {
                       
                         
                         String sql = "update gakuyo_zero_deposit set amount= '"+value1+"'where receipt_no='"+rec_no.getText().trim()+"'" ;
                         pst = conn.prepareStatement(sql);
                         pst.execute();
                         
                     } catch (SQLException ex) {
                         Logger.getLogger(receipt_reversal.class.getName()).log(Level.SEVERE, null, ex);
                     }
                    
                } 
                 
                 
            
                }
           else if (property.getSelectedItem() == "Investment"){
                 if(rec_no.getText().isEmpty()){
                   
              JOptionPane.showMessageDialog(null, "<html><h4><font color='red'>The Receipt No Cannot Be Found In GZD Payments </font></h4></html>");       
                }
             else{
                      
                     try {
                       
                         
                         String sql = "update investors_club set amount= '"+value1+"'where receiptno='"+rec_no.getText().trim()+"'" ;
                         pst = conn.prepareStatement(sql);
                         pst.execute();
                         
                     } catch (SQLException ex) {
                         Logger.getLogger(receipt_reversal.class.getName()).log(Level.SEVERE, null, ex);
                     }
                     
                    
                } 
              
                }
           reversereceipt();
           JOptionPane.showMessageDialog(null, "Reversed Successfully");
           }
       
        }
    }//GEN-LAST:event_reverse_amountActionPerformed

    private void propertyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_propertyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_propertyActionPerformed

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
            java.util.logging.Logger.getLogger(receipt_reversal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(receipt_reversal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(receipt_reversal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(receipt_reversal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new receipt_reversal().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField amount;
    private javax.swing.JLabel current_date;
    private javax.swing.JTextField id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> property;
    private javax.swing.JTextField rec_no;
    private javax.swing.JTextField receipt_no;
    private javax.swing.JButton reverse_amount;
    private javax.swing.JButton searchbyrec;
    // End of variables declaration//GEN-END:variables
}
