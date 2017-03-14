
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class edit_payment_voucher extends javax.swing.JFrame {

    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
  private static edit_payment_voucher obj=null;

    private edit_payment_voucher() {
        initComponents();
        conn = DbConnect.connecrDb();
        setResizable(false);
        
    logo();
    }
        public static edit_payment_voucher getObj() {
        if (obj== null){
            obj = new edit_payment_voucher();
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
    public void close() {
        String ObjButtons[] = {"Yes", "No"};
        int PromptResult = JOptionPane.showOptionDialog(null, "Are you sure you want to exit the system?", "Confirm", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, ObjButtons, ObjButtons[1]);
        if (PromptResult == JOptionPane.YES_OPTION) {
            System.exit(0);

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        payee_name = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        description = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        amount = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        choose = new javax.swing.JComboBox<>();
        delete = new javax.swing.JButton();
        update_payment_voucher = new javax.swing.JButton();
        clear = new javax.swing.JButton();
        transaction_date = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        receipt_no = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        spvrec = new javax.swing.JTextField();
        search_receipt_by_pv = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        pwd = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we)
            { 

                dispose();
                try {
                    rs.close();
                    pst.close();
                    conn.close();

                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null,e);
                }

            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "EDIT PAYMENT VOUCHER", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        jLabel1.setText("PAYEE NAME");

        payee_name.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel2.setText("DESCRIPTION");

        description.setColumns(20);
        description.setRows(5);
        jScrollPane1.setViewportView(description);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("RECEIPT NO");

        amount.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        amount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                amountKeyTyped(evt);
            }
        });

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("PAYMENT DATE");

        jLabel5.setText("CHOOSE");

        choose.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CASH", "CHEQUE" }));

        delete.setText("DELETE");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        update_payment_voucher.setText("UPDATE");
        update_payment_voucher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_payment_voucherActionPerformed(evt);
            }
        });

        clear.setText("CLEAR");
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });

        transaction_date.setDateFormatString("dd-MM-yyyy");

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("AMOUNT");

        receipt_no.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        receipt_no.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                receipt_noKeyTyped(evt);
            }
        });

        jLabel9.setText("SEARCH BY RECEIPT NO.");

        search_receipt_by_pv.setText("SEARCH");
        search_receipt_by_pv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_receipt_by_pvActionPerformed(evt);
            }
        });

        jLabel6.setText("Password");

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/gakuyo.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(265, 265, 265)
                .addComponent(amount))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(receipt_no, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(jLabel8)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(payee_name)
                        .addGap(80, 80, 80)
                        .addComponent(transaction_date, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(spvrec, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(search_receipt_by_pv)
                                .addGap(60, 60, 60))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(46, 46, 46))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(clear)
                                .addGap(126, 126, 126)
                                .addComponent(update_payment_voucher)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(40, 40, 40)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(choose, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(pwd, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(137, 137, 137)
                .addComponent(jLabel7)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(spvrec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(search_receipt_by_pv))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(payee_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(transaction_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(receipt_no, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel8))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(choose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(amount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(pwd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(delete)
                    .addComponent(update_payment_voucher)
                    .addComponent(clear))
                .addGap(36, 36, 36))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(82, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

  
    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        payee_name.setText("");
        ((JTextField) transaction_date.getDateEditor().getUiComponent()).setText("");
        description.setText("");
        amount.setText("");

        receipt_no.setText("");

    }//GEN-LAST:event_clearActionPerformed

    private void update_payment_voucherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_payment_voucherActionPerformed
       
        if (payee_name.getText().isEmpty() || ((JTextField) transaction_date.getDateEditor().getUiComponent()).getText().isEmpty() || amount.getText().isEmpty() || description.getText().isEmpty()
                || receipt_no.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "<html>Fill all the fields!</html>");
        } 
    
        else if(pwd.getText().isEmpty()){
               JOptionPane.showMessageDialog(null,"Kindly Input Your Password ");
                  }
         
        else {
            conn = DbConnect.connecrDb();
             if(conn==null){
            JOptionPane.showMessageDialog(this, "Could not connect to the server");
        }  
             else{
            try {
                String value1 = payee_name.getText().trim();

                String value2 = ((JTextField) transaction_date.getDateEditor().getUiComponent()).getText().trim();
                String value3 = amount.getText().trim();
                String value4 = choose.getSelectedItem().toString().trim();
                String value = receipt_no.getText().trim();
                String value5 = description.getText().trim();

                String sql = "update payment_voucher set payee_name= '" + value1 + "',date_of_payment='" + value2 + "',amount='" + value3 + "',payment_mode='" + value4 + "',description='" + value5 + "' where receipt_no ='" + value + "'";
                pst = conn.prepareStatement(sql);
                pst.execute();
                JOptionPane.showMessageDialog(null, "Successfully Updated");

            } catch (SQLException ex) {
                Logger.getLogger(edit_payment_voucher.class.getName()).log(Level.SEVERE, null, ex);
            }
 finally {
    try { rs.close(); } catch (SQLException e) {  }
    try { pst.close(); } catch (SQLException e) { }
    try { conn.close(); System.out.println("Connection closed");} catch (SQLException e) {}
}
        }}
       
    }//GEN-LAST:event_update_payment_voucherActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
      
        if (payee_name.getText().isEmpty() || ((JTextField) transaction_date.getDateEditor().getUiComponent()).getText().isEmpty() || amount.getText().isEmpty() || description.getText().isEmpty()
                || receipt_no.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "<html>Fill all the fields!</html>");
        } 
     
        else {
             conn = DbConnect.connecrDb();
                 if(conn==null){
            JOptionPane.showMessageDialog(this, "Could not connect to the server");
        }  
                else{
            int d = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete", "Delete", JOptionPane.YES_NO_OPTION);

            if (d == 0) {
                
                String sql = "delete from payment_voucher where receipt_no =?";
                try {

                    pst = conn.prepareStatement(sql);
                    pst.setString(1, spvrec.getText());
                    pst.execute();

                    JOptionPane.showMessageDialog(null, "deleted");

                } catch (SQLException ex) {
                    Logger.getLogger(edit_investors_club.class.getName()).log(Level.SEVERE, null, ex);
                }
                finally {
    try { rs.close(); } catch (SQLException e) {  }
    try { pst.close(); } catch (SQLException e) { }
    try { conn.close(); System.out.println("Connection closed");} catch (SQLException e) {}
}
            }
        }}
       
    }//GEN-LAST:event_deleteActionPerformed

    private void amountKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_amountKeyTyped
        
         char c=evt.getKeyChar();
        if(!((c==KeyEvent.VK_BACK_SPACE)||  c==KeyEvent.VK_DELETE ||Character.isDigit(c))){
        evt.consume();
        getToolkit().beep();}
    }//GEN-LAST:event_amountKeyTyped

    private void receipt_noKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_receipt_noKeyTyped
      
         char c=evt.getKeyChar();
        if(!(Character.isAlphabetic(c) ||  (c==KeyEvent.VK_BACK_SPACE)||  c==KeyEvent.VK_DELETE ||Character.isDigit(c))){
        evt.consume();
        getToolkit().beep();}
    }//GEN-LAST:event_receipt_noKeyTyped

    private void search_receipt_by_pvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_receipt_by_pvActionPerformed
        
        if(spvrec.getText().isEmpty()){

            JOptionPane.showMessageDialog(null, "<html><h4><font color='red'>Enter reference no!</font></h4></html>");
        }
         
          else{
             conn = DbConnect.connecrDb();
                  if(conn==null){
            JOptionPane.showMessageDialog(this, "Could not connect to the server");
        }
                  else{
            try{
                String check  = "select receipt_no,date_of_payment,amount,payment_mode,payee_name,description "
                            + "from payment_voucher where receipt_no=? ";
                     
                    pst = conn.prepareStatement(check);
                    pst.setString(1,spvrec.getText());
                    rs = pst.executeQuery();
               
                if (rs.next()) {
                  
                payee_name.setText(rs.getString("payee_name"));
                String add2 = rs.getString("date_of_payment");
                java.util.Date date = new SimpleDateFormat("dd-MM-yyy").parse(add2);
                transaction_date.setDate(date);
                transaction_date.setEnabled(false);
                amount.setText(rs.getString("amount"));
                description.setText(rs.getString("description"));
                choose.setSelectedItem(rs.getString("payment_mode"));
                receipt_no.setText(rs.getString("receipt_no"));
                receipt_no.setEnabled(false);
                } 
                else {
                    JOptionPane.showMessageDialog(null, "Client with This Receipt No"+" "+spvrec.getText()+" "+"does not exist");
                }
            
            } catch (SQLException ex) {
                 Logger.getLogger(edit_payment_voucher.class.getName()).log(Level.SEVERE, null, ex);
             } catch (ParseException ex) {
                Logger.getLogger(edit_payment_voucher.class.getName()).log(Level.SEVERE, null, ex);
            }
                  }
         }

                   
    }//GEN-LAST:event_search_receipt_by_pvActionPerformed
    public void toExcel(JTable tablevt, File file) {

        try (FileWriter excel = new FileWriter(file)) {
            for (int i = 0; i < tablevt.getColumnCount(); i++) {
                excel.write(tablevt.getColumnName(i) + "\t");
            }
            excel.write("\n");

            for (int i = 0; i < tablevt.getRowCount(); i++) {
                for (int j = 0; j < tablevt.getColumnCount(); j++) {
                    excel.write(tablevt.getValueAt(i, j).toString() + "\t");

                }
                excel.write("\n");
            }

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

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
            java.util.logging.Logger.getLogger(edit_payment_voucher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(edit_payment_voucher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(edit_payment_voucher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(edit_payment_voucher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new edit_payment_voucher().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField amount;
    private javax.swing.JComboBox<String> choose;
    private javax.swing.JButton clear;
    private javax.swing.JButton delete;
    private javax.swing.JTextArea description;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField payee_name;
    private javax.swing.JPasswordField pwd;
    private javax.swing.JTextField receipt_no;
    private javax.swing.JButton search_receipt_by_pv;
    private javax.swing.JTextField spvrec;
    private com.toedter.calendar.JDateChooser transaction_date;
    private javax.swing.JButton update_payment_voucher;
    // End of variables declaration//GEN-END:variables
}
