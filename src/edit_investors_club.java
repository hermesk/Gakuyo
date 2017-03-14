
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

public class edit_investors_club extends javax.swing.JFrame {

   Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
     private static edit_investors_club obj=null;
     
               //current date
   DateFormat dF = new SimpleDateFormat("yyyy-MM-dd");
       Date date = new Date();
       String td=dF.format(date);
    private edit_investors_club() {
        
        initComponents();
        conn = DbConnect.connecrDb();
         ComboPmode();
    
    logo();
    }
      public static edit_investors_club getObj() {
        if (obj== null){
            obj = new edit_investors_club();
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
         if(conn==null){
            JOptionPane.showMessageDialog(this, "Could not connect to the server");
        }    
         else
         {try{
         String sql = "select *from payment_mode";
         pst = conn.prepareStatement(sql);
         rs =pst.executeQuery();
         while(rs.next()){
          String paymode = rs.getString("mode");         
          payment_mode.addItem(paymode);
          String dbt = rs.getString("debit");         
          account_debit.addItem(dbt);
                  }
       } catch (SQLException ex) {
           Logger.getLogger(edit_investors_club.class.getName()).log(Level.SEVERE, null, ex);
       }
     finally {
    try { rs.close(); } catch (SQLException e) {  }
    try { pst.close(); } catch (SQLException e) { }
    try { conn.close(); System.out.println("Connection closed");} catch (SQLException e) {}
}
                 }
     }
 public void close(){
        WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
         }
       
    @SuppressWarnings("unchecked")
    
    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        bank_account = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        account_debit = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        invid = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        rate = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        search_ref_no = new javax.swing.JTextField();
        kra_pin = new javax.swing.JTextField();
        amount = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        receiptno = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        payment_type = new javax.swing.JComboBox<>();
        bank_name = new javax.swing.JTextField();
        paymnt = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        payment_mode = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        clear = new javax.swing.JButton();
        search_investors = new javax.swing.JButton();
        ref_no = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        update_investors_club = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        pwd = new javax.swing.JPasswordField();
        jLabel18 = new javax.swing.JLabel();
        interest = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        govtw = new javax.swing.JFormattedTextField();
        transaction_date = new com.toedter.calendar.JDateChooser();

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
        setTitle("EDIT INVESTORS PAYMENTS");
        setResizable(false);

        jLabel5.setText("REF NO:");

        jLabel7.setText("PAYMENT TYPE");

        jLabel9.setText("PAYMENT ");

        invid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                invidKeyTyped(evt);
            }
        });

        jLabel3.setText("AMOUNT");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("TRANSACTION DATE");

        rate.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                rateFocusLost(evt);
            }
        });
        rate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rateActionPerformed(evt);
            }
        });
        rate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                rateKeyReleased(evt);
            }
        });

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("RATE");

        search_ref_no.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                search_ref_noKeyTyped(evt);
            }
        });

        kra_pin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                kra_pinKeyTyped(evt);
            }
        });

        amount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                amountKeyTyped(evt);
            }
        });

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/gakuyo.png"))); // NOI18N

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("PAYMENT MODE");

        receiptno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                receiptnoKeyTyped(evt);
            }
        });

        jLabel21.setText("BANK ACCOUNT");

        jLabel19.setText("BANK NAME");

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("RECEIPT NO:");

        payment_type.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Deposit", "Installments", "Top up", "Balance Carried Forward" }));

        paymnt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                paymntKeyTyped(evt);
            }
        });

        jLabel1.setText("I.D NO:");

        jLabel17.setText("SEARCH BY RECEIPT NO:");

        clear.setText("CLEAR");
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });

        search_investors.setText("SEARCH");
        search_investors.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_investorsActionPerformed(evt);
            }
        });

        ref_no.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ref_noKeyTyped(evt);
            }
        });

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("KRA PIN");

        update_investors_club.setText("UPDATE");
        update_investors_club.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_investors_clubActionPerformed(evt);
            }
        });

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("ACCOUNT DEBIT");

        jLabel13.setText("Password");

        jLabel18.setText("Interest");

        interest.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                interestFocusLost(evt);
            }
        });
        interest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                interestActionPerformed(evt);
            }
        });

        jLabel22.setText("Govt W Tax");

        govtw.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));

        transaction_date.setDateFormatString("yyyy-MM-dd");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel17)
                .addGap(58, 58, 58)
                .addComponent(search_ref_no, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(search_investors)
                .addGap(185, 187, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(43, 43, 43))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel18)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel19)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(interest, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(paymnt, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bank_name, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(receiptno, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pwd, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(payment_type, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ref_no, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(amount, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(invid, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(update_investors_club)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(clear)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(account_debit, javax.swing.GroupLayout.Alignment.LEADING, 0, 126, Short.MAX_VALUE)
                        .addComponent(rate, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(govtw, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(kra_pin, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(bank_account)
                        .addComponent(payment_mode, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(transaction_date, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(148, 148, 148))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {amount, bank_name, interest, invid, payment_type, paymnt, pwd, receiptno, ref_no});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(search_ref_no, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(search_investors)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(invid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(amount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(payment_mode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(account_debit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(ref_no, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(payment_type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(interest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18)
                            .addComponent(jLabel22)
                            .addComponent(govtw, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(4, 4, 4)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(paymnt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(kra_pin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(bank_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21)
                            .addComponent(bank_account, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(receiptno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(pwd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(update_investors_club)
                            .addComponent(clear)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(transaction_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(73, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(725, 539));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void update_investors_clubActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_investors_clubActionPerformed
        
         if(invid.getText().isEmpty()||pwd.getText().isEmpty()||((JTextField)transaction_date.getDateEditor().getUiComponent()).getText().isEmpty()||amount.getText().isEmpty()||ref_no.getText().isEmpty()
            ||paymnt.getText().isEmpty()||kra_pin.getText().isEmpty()||receiptno.getText().isEmpty())
        {
           JOptionPane.showMessageDialog(null, "<html>Fill all the fields!</html>");
        }
         else if(invid.getText().length()>8)
        {
           JOptionPane.showMessageDialog(null, "<html>Invalid Id Number!</html>");
        }
        
          else{
              conn = DbConnect.connecrDb();
              
              if(conn==null){
            JOptionPane.showMessageDialog(this, "Could not connect to the server");
        }  
              else{
            try{
                 // check for user
            String searchuser = "select [user].branch,[user].fname,[user].lname from [user],[investors_club] where [user].password=?"
                           + " and [investors_club].id=?";
                   pst=conn.prepareStatement(searchuser);
                   pst.setString(1, md5(pwd.getText().trim()));
                   pst.setString(2, invid.getText());
                   rs = pst.executeQuery();
                   
                    if(rs.next()){
                    String branch=rs.getString("branch");
                    String fname =rs.getString("fname"); 
                    String lname =rs.getString("lname"); 
                    String uname = fname+" "+lname;
                
                String  value1 = invid.getText().toUpperCase().trim();
                
                String  value2 = ((JTextField)transaction_date.getDateEditor().getUiComponent()).getText().toUpperCase().trim();
                String  value3 = amount.getText().toUpperCase().trim();
                String  value4 = payment_type.getSelectedItem().toString().toUpperCase().trim();
                String  value5 = payment_mode.getSelectedItem().toString().toUpperCase().trim();
                String  value6 = account_debit.getSelectedItem().toString().toUpperCase().trim();
                String  value7 = rate.getText().toUpperCase().trim();
                String  value8=paymnt.getText().toUpperCase().trim();
                String  value9=kra_pin.getText().toUpperCase().trim();
                String  value12=ref_no.getText().toUpperCase().trim();
                String  value13=bank_name.getText().toUpperCase().trim();
                
                String  value14=bank_account.getText().toUpperCase().trim();
                
                String  value = receiptno.getText().toUpperCase().trim();

                
                String sql = "update investors_club  set id= '"+value1+"',tdate='"+value2+"',amount='"+value3+"',investors_club.ptype='"+value4+"',investors_club.mode='"+value5+"',investors_club.debitacc='"+value6+"',"
                + "investors_club.rate='"+value7+"',investors_club.interest= '"+value8+"',investors_club.pkra= '"+value9+"',"
                        + "investors_club.bank_name= '"+value13+"',investors_club.bank_account='"+value14+"',investors_club.servedby='"+uname+"',investors_club.reference='"+value12+"' where investors_club.receiptno ='"+value+"'";

                pst = conn.prepareStatement(sql);
                pst.execute();
                
                //update receipt
                String upd ="update receipt set pdate='"+td+"',tdate='"+value2+"',ptype='"+value4+"',pmode='"+value5+"',amount='"+value3+"',"
                        + "servedby='"+uname+"',branch='"+branch+"' where receiptno ='"+receiptno.getText()+"'";
                      pst = conn.prepareStatement(upd);
                      pst.execute();
                JOptionPane.showMessageDialog(null, "Successfully Updated");

                     }}
               catch(NumberFormatException | SQLException e){
        JOptionPane.showMessageDialog(null, e);
        }
                                     finally {
    try { rs.close(); } catch (SQLException e) { JOptionPane.showMessageDialog(null, e); }
    try { pst.close(); } catch (SQLException e) {JOptionPane.showMessageDialog(null, e); }
    try { conn.close(); System.out.println("Connection closed");} catch (SQLException e) {JOptionPane.showMessageDialog(null, e);}
}
       
              }
    } 
    }//GEN-LAST:event_update_investors_clubActionPerformed

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
    private void search_investorsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_investorsActionPerformed
        
        if(search_ref_no.getText().isEmpty()){
                   
              JOptionPane.showMessageDialog(null, "<html><h4><font color='red'>Enter reference no!</font></h4></html>");       
                }
       else{
                 conn = DbConnect.connecrDb();
                 if(conn==null){
            JOptionPane.showMessageDialog(this, "Could not connect to the server");
        }  
                 else{
       try{
                       
           String check ="SELECT COUNT(*) AS total FROM investors_club where receiptno = '"+search_ref_no.getText()+"'"; 
                            pst=conn.prepareStatement(check);
                            rs = pst.executeQuery();
                
                          while(rs.next()){
                              
           if(rs.getInt("total")>0){
            String sql = "select * from investors_club where investors_club.receiptno ='"+search_ref_no.getText()+"'";
            pst=conn.prepareStatement(sql);
            rs = pst.executeQuery();

            while(rs.next()){
                invid.setText(rs.getString("id"));
                String add2 = rs.getString("tdate");
                 Date dt = new SimpleDateFormat("yyyy-MM-dd").parse(add2);
                 transaction_date.setDate(dt);
                amount.setText(rs.getString("amount"));
                payment_type.setSelectedItem(rs.getString("ptype"));
                payment_mode.setSelectedItem(rs.getString("mode"));
                ref_no.setText(rs.getString("reference"));
                account_debit.setSelectedItem(rs.getString("debitacc"));
                rate.setText(rs.getString("rate"));
                interest.setText(rs.getString("interest"));
                govtw.setText(rs.getString("govtw"));
                paymnt.setText(rs.getString("payment"));
                kra_pin.setText(rs.getString("pkra"));
                receiptno.setText(rs.getString("receiptno"));
                receiptno.setEnabled(false);
                bank_name.setText(rs.getString("bank_name"));
                bank_account.setText(rs.getString("bank_account"));

            } }
                        else{
                           JOptionPane.showMessageDialog(null, "Client with That ID No"+" "+search_ref_no.getText()+" "+"does not exist");

                              }}}
                
           catch(SQLException e){
        JOptionPane.showMessageDialog(null, e);
    }        catch (ParseException ex) {   
                 Logger.getLogger(edit_investors_club.class.getName()).log(Level.SEVERE, null, ex);
             }   
       finally {
    try { rs.close(); } catch (SQLException e) { JOptionPane.showMessageDialog(null, e);  }
    try { pst.close(); } catch (SQLException e) { JOptionPane.showMessageDialog(null, e); }
    try { conn.close(); System.out.println("Connection closed");} catch (SQLException e) { JOptionPane.showMessageDialog(null, e);}
}
                    
                 }   
       }
    }//GEN-LAST:event_search_investorsActionPerformed

    private void rateKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rateKeyReleased
       
    }//GEN-LAST:event_rateKeyReleased

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        // TODO add your handling code here:
        invid.setText("");
        ((JTextField)transaction_date.getDateEditor().getUiComponent()).setText("");
        ref_no.setText("");
        amount.setText("");
        rate.setText("");
        paymnt.setText("");
        kra_pin.setText("");
      
        receiptno.setText("");
       
    }//GEN-LAST:event_clearActionPerformed
    
    private void save_investors_clubActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save_investors_clubActionPerformed
    
    }//GEN-LAST:event_save_investors_clubActionPerformed

    
    private void rateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rateActionPerformed

    private void invidKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_invidKeyTyped
   char c=evt.getKeyChar();
        if(!(Character.isAlphabetic(c) ||  (c==KeyEvent.VK_BACK_SPACE)||  c==KeyEvent.VK_DELETE ||Character.isDigit(c))){
        evt.consume();
        getToolkit().beep();}
    }//GEN-LAST:event_invidKeyTyped

    private void amountKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_amountKeyTyped
     char c=evt.getKeyChar();
        if(!((c==KeyEvent.VK_BACK_SPACE)||  c==KeyEvent.VK_DELETE ||Character.isDigit(c))){
        evt.consume();
        getToolkit().beep();}
    }//GEN-LAST:event_amountKeyTyped

    private void ref_noKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ref_noKeyTyped
      char c=evt.getKeyChar();
        if(!(Character.isAlphabetic(c) ||  (c==KeyEvent.VK_BACK_SPACE)||  c==KeyEvent.VK_DELETE ||Character.isDigit(c))){
        evt.consume();
        getToolkit().beep();}
    }//GEN-LAST:event_ref_noKeyTyped

    private void paymntKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_paymntKeyTyped
        char c = evt.getKeyChar();
        if(Character.isLetter(c) || Character.isISOControl(c)||Character.isDigit(c))
        {
        }
        else   evt.consume();
        getToolkit().beep();
    }//GEN-LAST:event_paymntKeyTyped

    private void kra_pinKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_kra_pinKeyTyped
        char c = evt.getKeyChar();
        if(Character.isLetter(c) || Character.isISOControl(c)||Character.isDigit(c))
        {
        }
        else   evt.consume();
        getToolkit().beep();
    }//GEN-LAST:event_kra_pinKeyTyped

    private void receiptnoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_receiptnoKeyTyped
      char c=evt.getKeyChar();
        if(!(Character.isAlphabetic(c) ||  (c==KeyEvent.VK_BACK_SPACE)||  c==KeyEvent.VK_DELETE ||Character.isDigit(c))){
        evt.consume();
        getToolkit().beep();}
    }//GEN-LAST:event_receiptnoKeyTyped

    private void search_ref_noKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search_ref_noKeyTyped
      char c=evt.getKeyChar();
        if(!(Character.isAlphabetic(c) ||  (c==KeyEvent.VK_BACK_SPACE)||  c==KeyEvent.VK_DELETE ||Character.isDigit(c))){
        evt.consume();
        getToolkit().beep();}
    }//GEN-LAST:event_search_ref_noKeyTyped

    private void rateFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_rateFocusLost
        // TODO add your handling code here:
        
          //calculating interest
                double amnt = Double.parseDouble(amount.getText());
                double rt = Double.parseDouble(rate.getText().trim());
                double intst = amnt*(rt/100);
             
                //govt withholding fee
                double tax =0.05*intst;
                double pymnt = intst -tax;
                     
                paymnt.setText(String.valueOf(pymnt));
                interest.setText(String.valueOf(intst));
                govtw.setText(String.valueOf(tax));
                paymnt.setEnabled(false); 
                paymnt.setEnabled(false); 
                govtw.setEnabled(false);
    }//GEN-LAST:event_rateFocusLost

    private void interestFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_interestFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_interestFocusLost

    private void interestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_interestActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_interestActionPerformed
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
     
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(() -> {
            new edit_investors_club().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> account_debit;
    private javax.swing.JTextField amount;
    private javax.swing.JTextField bank_account;
    private javax.swing.JTextField bank_name;
    private javax.swing.JButton clear;
    private javax.swing.JFormattedTextField govtw;
    private javax.swing.JTextField interest;
    private javax.swing.JTextField invid;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField kra_pin;
    private javax.swing.JComboBox<String> payment_mode;
    private javax.swing.JComboBox<String> payment_type;
    private javax.swing.JTextField paymnt;
    private javax.swing.JPasswordField pwd;
    private javax.swing.JTextField rate;
    private javax.swing.JTextField receiptno;
    private javax.swing.JTextField ref_no;
    private javax.swing.JButton search_investors;
    private javax.swing.JTextField search_ref_no;
    private com.toedter.calendar.JDateChooser transaction_date;
    private javax.swing.JButton update_investors_club;
    // End of variables declaration//GEN-END:variables

   

    

 
}
