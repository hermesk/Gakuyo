 

import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;


public class Edit_Gakuyozerodeposit extends javax.swing.JFrame {

    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    private static Edit_Gakuyozerodeposit obj=null;
    
              //current date
   DateFormat dF = new SimpleDateFormat("yyyy-MM-dd");
       Date date = new Date();
       String td=dF.format(date);
    
    private Edit_Gakuyozerodeposit() {
        
        initComponents();
         conn = DbConnect.connecrDb();
        ComboPmode();
        ProperyDetails();
       logo();
    }
     private void ProperyDetails(){
       
    if(conn==null){
            JOptionPane.showMessageDialog(this, "Could not connect to the server");
        }  
    else{
          try{
         String sql = "select ptype from property_location WHERE ptype IS NOT NULL";
         pst = conn.prepareStatement(sql);
         rs =pst.executeQuery();
         while(rs.next()){
          
          String ptp = rs.getString("ptype");
                deposit.addItem(ptp);
                  }
       }
          
     catch(SQLException e)
     {
                 JOptionPane.showMessageDialog(null, e);
    }
 
    }
          }
        public static Edit_Gakuyozerodeposit getObj() {
        if (obj== null){
            obj = new Edit_Gakuyozerodeposit();
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
     private void ComboPmode(){
         conn = DbConnect.connecrDb();
          try{
         String sql = "select *from payment_mode";
         pst = conn.prepareStatement(sql);
         rs =pst.executeQuery();
         while(rs.next()){
          String paymode = rs.getString("mode");         
          payment_mode.addItem(paymode);
          String dbt = rs.getString("debit");         
          account_debit.addItem(dbt);
                  }
       }
     catch(SQLException e)
     {
                 JOptionPane.showMessageDialog(null, e);
    }
   
          }


  
   
    @SuppressWarnings("unchecked")
     
    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        gakuyo_zero_deposit_edit_details = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        search_edit = new javax.swing.JButton();
        text_search = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        clear_gzd = new javax.swing.JButton();
        delete_gzd = new javax.swing.JButton();
        update_gzd = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        AmtFig = new javax.swing.JTextField();
        RefNo = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        account_debit = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        deposit = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        transaction_date = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        payment_mode = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        type_of_house = new javax.swing.JComboBox<>();
        id = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        receipt_no = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        pwd = new javax.swing.JPasswordField();
        jLabel12 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

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
        setResizable(false);

        gakuyo_zero_deposit_edit_details.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "GAKUYO ZERO DEPOSIT ACCOUNT DETAILS EDIT SECTION", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N
        gakuyo_zero_deposit_edit_details.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        gakuyo_zero_deposit_edit_details.setPreferredSize(new java.awt.Dimension(1588, 454));

        jLabel11.setText("SEARCH BY REFRENCE NO");

        search_edit.setText("Search");
        search_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_editActionPerformed(evt);
            }
        });

        text_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_searchActionPerformed(evt);
            }
        });
        text_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                text_searchKeyTyped(evt);
            }
        });

        clear_gzd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Clear-icon.png"))); // NOI18N
        clear_gzd.setText("Clear");
        clear_gzd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clear_gzdActionPerformed(evt);
            }
        });

        delete_gzd.setText("Delete");
        delete_gzd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_gzdActionPerformed(evt);
            }
        });

        update_gzd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/update.png"))); // NOI18N
        update_gzd.setText("Update");
        update_gzd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_gzdActionPerformed(evt);
            }
        });

        jLabel9.setText("Amount");

        AmtFig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AmtFigActionPerformed(evt);
            }
        });
        AmtFig.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                AmtFigKeyTyped(evt);
            }
        });

        RefNo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                RefNoKeyTyped(evt);
            }
        });

        jLabel10.setText("Reference No.");

        account_debit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                account_debitActionPerformed(evt);
            }
        });

        jLabel8.setText("Account Debit");

        deposit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                depositActionPerformed(evt);
            }
        });

        jLabel7.setText("Choose");

        transaction_date.setDateFormatString("yyyy-MM-dd");

        jLabel4.setText("Date Of Transaction");

        jLabel6.setText("Payment Mode");

        payment_mode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payment_modeActionPerformed(evt);
            }
        });

        jLabel5.setText("Type Of House");

        type_of_house.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2 Bedroom", "3 Bedroom" }));
        type_of_house.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                type_of_houseActionPerformed(evt);
            }
        });

        id.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                idKeyTyped(evt);
            }
        });

        jLabel3.setText("ID Passsport");

        jLabel14.setText("RECEIPT NO:");

        jLabel1.setText("Password");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(id))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(type_of_house, 0, 157, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, 55))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(AmtFig)
                            .addComponent(payment_mode, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(65, 65, 65)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(180, 180, 180))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(transaction_date, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(clear_gzd)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(account_debit, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(RefNo)
                            .addComponent(deposit, 0, 166, Short.MAX_VALUE))))
                .addGap(37, 37, 37))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(pwd)
                    .addComponent(receipt_no, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(delete_gzd)
                .addGap(18, 18, 18)
                .addComponent(update_gzd)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(transaction_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(deposit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(type_of_house, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(payment_mode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(account_debit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(RefNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10)
                        .addComponent(jLabel9))
                    .addComponent(AmtFig, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(receipt_no, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(pwd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(update_gzd)
                    .addComponent(delete_gzd)
                    .addComponent(clear_gzd))
                .addContainerGap(77, Short.MAX_VALUE))
        );

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/gakuyo.png"))); // NOI18N

        javax.swing.GroupLayout gakuyo_zero_deposit_edit_detailsLayout = new javax.swing.GroupLayout(gakuyo_zero_deposit_edit_details);
        gakuyo_zero_deposit_edit_details.setLayout(gakuyo_zero_deposit_edit_detailsLayout);
        gakuyo_zero_deposit_edit_detailsLayout.setHorizontalGroup(
            gakuyo_zero_deposit_edit_detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gakuyo_zero_deposit_edit_detailsLayout.createSequentialGroup()
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addComponent(text_search, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(search_edit)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        gakuyo_zero_deposit_edit_detailsLayout.setVerticalGroup(
            gakuyo_zero_deposit_edit_detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gakuyo_zero_deposit_edit_detailsLayout.createSequentialGroup()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(gakuyo_zero_deposit_edit_detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(gakuyo_zero_deposit_edit_detailsLayout.createSequentialGroup()
                        .addGroup(gakuyo_zero_deposit_edit_detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(search_edit))
                        .addGap(3, 3, 3))
                    .addComponent(text_search, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(gakuyo_zero_deposit_edit_details, javax.swing.GroupLayout.DEFAULT_SIZE, 676, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(gakuyo_zero_deposit_edit_details, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 21, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(692, 530));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void type_of_houseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_type_of_houseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_type_of_houseActionPerformed

    private void AmtFigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AmtFigActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AmtFigActionPerformed

    private void payment_modeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payment_modeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_payment_modeActionPerformed

    private void depositActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_depositActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_depositActionPerformed

    private void account_debitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_account_debitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_account_debitActionPerformed

    private void update_gzdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_gzdActionPerformed
         if(id.getText().isEmpty()||((JTextField)transaction_date.getDateEditor().getUiComponent()).getText().isEmpty()||AmtFig.getText().isEmpty()||RefNo.getText().isEmpty())
        {
           JOptionPane.showMessageDialog(null, "<html>Fill all the fields!</html>");
        }
     else if(conn==null){
            JOptionPane.showMessageDialog(null, "Could not connect to the server");
        }
      else if(pwd.getText().isEmpty()){
               JOptionPane.showMessageDialog(null,"Kindly Input Your Password ");
                  }
        else if(id.getText().length()>8)
        {
           JOptionPane.showMessageDialog(null, "<html>Invalid Id Number!</html>");
        }
       
        else{
            try{
                    // check for user
            String searchuser = "select *from [user] where [user].password=?";
                          
                   pst=conn.prepareStatement(searchuser);
                   pst.setString(1, md5(pwd.getText().trim()));
                   rs = pst.executeQuery();
                   
                    if(rs.next()){
                    String branch=rs.getString("branch");
                    String fname =rs.getString("fname"); 
                    String lname =rs.getString("lname"); 
                    String uname = fname+" "+lname;
                
                String  value1 = id.getText().toUpperCase().trim();
                
                String  value2 = ((JTextField)transaction_date.getDateEditor().getUiComponent()).getText().toUpperCase().trim();
                String  value3 = type_of_house.getSelectedItem().toString().toUpperCase().trim();
                String  value4 = deposit.getSelectedItem().toString().toUpperCase().trim();
                String  value5 =payment_mode.getSelectedItem().toString().toUpperCase().trim();
                String  value6 = account_debit.getSelectedItem().toString().toUpperCase().trim();
                String  value7 = AmtFig.getText().toUpperCase().trim();
                String  value = RefNo.getText().toUpperCase().trim();

                
                String sql = "update gakuyo_zero_deposit set id= '"+value1+"',transaction_date='"+value2+"',type_of_house='"+value3+"',ptype='"+value4+"',payment_mode='"+value5+"',account_debit='"+value6+"',"
                + "amount='"+value7+"' where ref_no ='"+value+"'";

                pst = conn.prepareStatement(sql);
                pst.execute();
                
                //update receipt
                 String upd ="update receipt set pdate='"+td+"',tdate='"+value2+"',ptype='"+value4+"',pmode='"+value5+"',amount='"+value7+"',"
                        + "servedby='"+uname+"',branch='"+branch+"' where receiptno ='"+receipt_no.getText()+"'";
                      pst = conn.prepareStatement(upd);
                      pst.execute();
              
                JOptionPane.showMessageDialog(null, "Successfully Updated");

                    }}
               catch(NumberFormatException | SQLException e){
        JOptionPane.showMessageDialog(null, e);
        }
 
       
        
    } 
    }//GEN-LAST:event_update_gzdActionPerformed
 private String md5(String c) 
      {
       try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[]messageDigest =md.digest(c.getBytes());
            BigInteger number =new BigInteger(1,messageDigest);
            String hashtext = number.toString(16);
            while(hashtext.length()<32){
            hashtext ="0"+hashtext;
            }
            return hashtext;
          }
          catch(NoSuchAlgorithmException ex){
          }
        return null;

       }
    
    private void clear_gzdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clear_gzdActionPerformed
        id.setText("");
        ((JTextField)transaction_date.getDateEditor().getUiComponent()).setText("");
        RefNo.setText("");
        AmtFig.setText("");
       
    }//GEN-LAST:event_clear_gzdActionPerformed

    private void text_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text_searchActionPerformed

    private void search_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_editActionPerformed
         
        if(text_search.getText().isEmpty()){
                   
              JOptionPane.showMessageDialog(null, "<html><h4><font color='red'>Enter ID or Passport no!</font></h4></html>");       
                }
                else{
                         if(conn==null){
            JOptionPane.showMessageDialog(null, "Could not connect to the server");
        }
                        else{
                     try{
              String gakuyo_zero_deposit= "select  * from gakuyo_zero_deposit where ref_no=?";

                        pst = conn.prepareStatement(gakuyo_zero_deposit);
                        pst.setString(1, text_search.getText());
                        rs=pst.executeQuery();
                              if(rs.next()){
                 
              String add1 = rs.getString("transaction_date");
             Date dt = new SimpleDateFormat("yyyy-MM-dd").parse(add1);
             transaction_date.setDate(dt);
              
                account_debit.setSelectedItem(rs.getString("account_debit"));
                type_of_house.setSelectedItem(rs.getString("type_of_house"));
                payment_mode.setSelectedItem(rs.getString("payment_mode"));
                deposit.setSelectedItem(rs.getString("ptype"));
                receipt_no.setText(rs.getString("receipt_no"));
                receipt_no.setEnabled(false);
                AmtFig.setText(rs.getString("amount"));
                id.setText(rs.getString("id"));
                RefNo.setText(rs.getString("ref_no"));
                         }
                        else{
                           JOptionPane.showMessageDialog(null, "Transaction with reference No"+" "+text_search.getText()+" "+"does not exist");

                              }}
                
           catch(SQLException e){
        JOptionPane.showMessageDialog(null, e);
    }           catch (ParseException ex) {   
                    Logger.getLogger(Edit_Gakuyozerodeposit.class.getName()).log(Level.SEVERE, null, ex);
                }   
                                                
                        }          
         
       }
        
        
        
    }//GEN-LAST:event_search_editActionPerformed

    private void delete_gzdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_gzdActionPerformed
        if(id.getText().isEmpty()||((JTextField)transaction_date.getDateEditor().getUiComponent()).getText().isEmpty()||AmtFig.getText().isEmpty()||RefNo.getText().isEmpty() )
                
                {
            JOptionPane.showMessageDialog(null, "<html>Fill all the fields!</html>");

        }
           else if(conn==null){
            JOptionPane.showMessageDialog(null, "Could not connect to the server");
        }
        else{
            int d = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete", "Delete", JOptionPane.YES_NO_OPTION);

            if(d==0){    
              
               
                try {
                    String sql = "delete from gakuyo_zero_deposit where ref_no =?";
                    pst=conn.prepareStatement(sql);
                    pst.setString(1, text_search.getText());
                    pst.execute();
                    
                    JOptionPane.showMessageDialog(null, "deleted");

                } catch (SQLException ex) {
                    Logger.getLogger(Edit_Gakuyozerodeposit.class.getName()).log(Level.SEVERE, null, ex);
                }
       
            }
    
        }
    }//GEN-LAST:event_delete_gzdActionPerformed

    private void idKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_idKeyTyped
    char c=evt.getKeyChar();
        if(!(Character.isAlphabetic(c) ||  (c==KeyEvent.VK_BACK_SPACE)||  c==KeyEvent.VK_DELETE ||Character.isDigit(c))){
        evt.consume();
        getToolkit().beep();}
    }//GEN-LAST:event_idKeyTyped

    private void AmtFigKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AmtFigKeyTyped
        char c = evt.getKeyChar(); 
    if(Character.isLetter(c) || Character.isISOControl(c)||Character.isDigit(c))
    {
    }
    else   evt.consume(); 
         getToolkit().beep();
    }//GEN-LAST:event_AmtFigKeyTyped

    private void RefNoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RefNoKeyTyped
        char c = evt.getKeyChar(); 
    if(Character.isLetter(c) || Character.isISOControl(c)||Character.isDigit(c))
    {
    }
    else   evt.consume(); 
         getToolkit().beep();
    }//GEN-LAST:event_RefNoKeyTyped

    private void text_searchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_text_searchKeyTyped
        char c = evt.getKeyChar(); 
    if(Character.isLetter(c) || Character.isISOControl(c)||Character.isDigit(c))
    {
    }
    else   evt.consume(); 
         getToolkit().beep();
    }//GEN-LAST:event_text_searchKeyTyped
//export to excel
            public void toExcel(JTable tablevt, File file){
               
                    try (FileWriter excel = new FileWriter(file)) {
                        for(int i = 0; i < tablevt.getColumnCount(); i++){
                            excel.write(tablevt.getColumnName(i) + "\t");
                                               }
                          excel.write("\n");
                       
                          for(int i=0; i< tablevt.getRowCount(); i++) {
                            for(int j=0; j < tablevt.getColumnCount(); j++) {
                            excel.write(tablevt.getValueAt(i,j).toString()+"\t");                           

                            }
                           excel.write("\n");
                        }
                    

                }catch(IOException e){ 
                 JOptionPane.showMessageDialog(null,e);
 }
            }
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
            java.util.logging.Logger.getLogger(Edit_Gakuyozerodeposit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Edit_Gakuyozerodeposit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Edit_Gakuyozerodeposit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Edit_Gakuyozerodeposit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Edit_Gakuyozerodeposit().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AmtFig;
    private javax.swing.JTextField RefNo;
    private javax.swing.JComboBox<String> account_debit;
    private javax.swing.JButton clear_gzd;
    private javax.swing.JButton delete_gzd;
    private javax.swing.JComboBox<String> deposit;
    private javax.swing.JPanel gakuyo_zero_deposit_edit_details;
    private javax.swing.JTextField id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox<String> payment_mode;
    private javax.swing.JPasswordField pwd;
    private javax.swing.JTextField receipt_no;
    private javax.swing.JButton search_edit;
    private javax.swing.JTextField text_search;
    private com.toedter.calendar.JDateChooser transaction_date;
    private javax.swing.JComboBox<String> type_of_house;
    private javax.swing.JButton update_gzd;
    // End of variables declaration//GEN-END:variables
}
