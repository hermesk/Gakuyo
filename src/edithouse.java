
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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
import javax.swing.JTextField;


public class edithouse extends javax.swing.JFrame {

    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    private static edithouse obj=null;
       //current date
       DateFormat dF = new SimpleDateFormat("yyyy-MM-dd");
       Date date = new Date();
      String td=dF.format(date);
    
    private edithouse() {
        initComponents();
         conn = DbConnect.connecrDb();
           ComboPmode();
        ProperyDetails();
    logo();
    }
       public static edithouse getObj() {
        if (obj== null){
            obj = new edithouse();
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
           pmode.addItem(paymode);
            String dbt = rs.getString("debit");         
             account.addItem(dbt);
                  }
       }
     catch(SQLException e)
     {
                 JOptionPane.showMessageDialog(null, e);
    }
 
                   }}
        private void ProperyDetails(){
   conn = DbConnect.connecrDb();
            if(conn==null){
            JOptionPane.showMessageDialog(this, "Could not connect to the server");
        }
            else
            {try{
         String sql = "select *from property_location ";
         pst = conn.prepareStatement(sql);
         rs =pst.executeQuery();
         while(rs.next()){
             
          String lctn = rs.getString("location");         
          location.addItem(lctn);
          String sz = rs.getString("size");         
          size.addItem(sz);
          
                  }
         String ptpc = "select ptype from property_location where ptype IS NOT NULL ";
            pst = conn.prepareStatement(ptpc);
            rs = pst.executeQuery();
             while (rs.next()) {
                String ptp = rs.getString("ptype");
                ptype.addItem(ptp);
            }
       }
     catch(SQLException e)
     {
                 JOptionPane.showMessageDialog(null, e);
    }
 
                    }}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel12 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        cost = new javax.swing.JTextField();
        ptype = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        search_house = new javax.swing.JButton();
        tdate = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        size = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        pmode = new javax.swing.JComboBox<>();
        ref = new javax.swing.JTextField();
        id = new javax.swing.JTextField();
        location = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        Size = new javax.swing.JLabel();
        amount = new javax.swing.JTextField();
        account = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        house_no = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        search_ref_no = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        pwd = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        update = new javax.swing.JButton();
        clear = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        receiptno = new javax.swing.JTextField();

        jLabel12.setText("jLabel12");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("EDIT HOUSE PAYMENT");
        setResizable(false);

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/gakuyo.png"))); // NOI18N

        cost.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                costKeyTyped(evt);
            }
        });

        ptype.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Deposit", "Installments", "Full Amount", "Balance Carried Forward" }));

        jLabel1.setText("Account");

        search_house.setText("SEARCH");
        search_house.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_houseActionPerformed(evt);
            }
        });

        tdate.setDateFormatString(" yyyy-MM-dd");

        jLabel10.setText("houseno");

        jLabel6.setText("Payment Type");

        jLabel4.setText("ID");

        ref.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                refKeyTyped(evt);
            }
        });

        id.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                idKeyTyped(evt);
            }
        });

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("SEARCH BY RECEIPT NO:");

        Size.setText("Size");

        amount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                amountKeyTyped(evt);
            }
        });

        jLabel2.setText("Cost");

        house_no.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                house_noKeyTyped(evt);
            }
        });

        jLabel5.setText("Location");

        jLabel8.setText("Transaction Date");

        jLabel11.setText("Refno");

        search_ref_no.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                search_ref_noKeyTyped(evt);
            }
        });

        jLabel3.setText("Amount");

        jLabel7.setText("Payment mode");

        jLabel13.setText("Password");

        update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/update.png"))); // NOI18N
        update.setText("UPDATE");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        clear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Clear-icon.png"))); // NOI18N
        clear.setText("CLEAR");
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });

        jLabel14.setText("Receipt no");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(update)
                        .addGap(36, 36, 36)
                        .addComponent(clear))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(jLabel10)
                            .addComponent(jLabel8)
                            .addComponent(Size)
                            .addComponent(jLabel13)
                            .addComponent(jLabel11)
                            .addComponent(jLabel14)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ref)
                            .addComponent(account, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(amount)
                            .addComponent(cost)
                            .addComponent(id)
                            .addComponent(location, 0, 106, Short.MAX_VALUE)
                            .addComponent(pmode, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ptype, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(size, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pwd)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(receiptno, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(house_no, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(search_ref_no, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(search_house)))))
                .addContainerGap(113, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {Size, jLabel1, jLabel10, jLabel11, jLabel2, jLabel3, jLabel4, jLabel5, jLabel6, jLabel7, jLabel8});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {account, amount, cost, house_no, id, location, pmode, ptype, pwd, ref, size, tdate});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(search_ref_no, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(search_house))
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(13, 13, 13)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(46, 46, 46)
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(13, 13, 13)
                        .addComponent(Size, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(account, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(amount, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                        .addGap(5, 5, 5)
                        .addComponent(cost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(id, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(location, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pmode, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ptype, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(ref, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                        .addGap(4, 4, 4)
                        .addComponent(receiptno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(house_no, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(size, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pwd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(update)
                    .addComponent(clear))
                .addGap(41, 41, 41))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(465, 465, 465))
            .addGroup(layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {                                           
       
         if(id.getText().isEmpty()||((JTextField)tdate.getDateEditor().getUiComponent()).getText().isEmpty()||amount.getText().isEmpty()||ref.getText().isEmpty())
        {
           JOptionPane.showMessageDialog(null, "<html>Fill all the fields!</html>");
        }

        else if(id.getText().length()>12)
        {
           JOptionPane.showMessageDialog(null, "<html>Invalid Id Number!</html>");
        }
        else if(pwd.getText().isEmpty()){
               JOptionPane.showMessageDialog(null,"Kindly Input Your Password ");
                  }
      
        else{
             conn = DbConnect.connecrDb();
             if(conn==null){
            JOptionPane.showMessageDialog(this, "Could not connect to the server");
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
            
           
                String  mno = receiptno.getText();
                String  value1 = id.getText().toUpperCase().trim();
                String  value2 = ((JTextField)tdate.getDateEditor().getUiComponent()).getText().toUpperCase().trim();
                String  value3 = size.getSelectedItem().toString().toUpperCase().trim();
                String  value4 = ptype.getSelectedItem().toString().toUpperCase().trim();
                String  value5 =pmode.getSelectedItem().toString().toUpperCase().trim();
                String  value6 = account.getSelectedItem().toString().toUpperCase().trim();
                String  value7 = amount.getText().toUpperCase().trim();
                String  value8 = house_no.getText().toUpperCase().trim();
                String  value9 = location.getSelectedItem().toString().toUpperCase().trim();
              
                String sql = "update house set id= '"+value1+"',transaction_date='"+value2+"',house_size='"+value3+"',payment_type='"+value4+"',payment_mode='"+value5+"',account_debit='"+value6+"',"
                + "amount='"+value7+"',plotno='"+value8+"',location='"+value9+"' where receiptno ='"+mno+"'";

                pst = conn.prepareStatement(sql);
                pst.execute();
                //update receipt 
                
                //update receipt
                 String upd ="update receipt set pdate='"+td+"',tdate='"+value2+"',ptype='"+value4+"',pmode='"+value5+"',amount='"+value7+"',"
                        + "servedby='"+uname+"',branch='"+branch+"' where receiptno ='"+receiptno.getText()+"'";
                      pst = conn.prepareStatement(upd);
                      pst.execute();
                
                JOptionPane.showMessageDialog(null, "Successfully Updated");

            }
                else{
             JOptionPane.showMessageDialog(null, "Incorrect  password");}  
            }
               catch(NumberFormatException | SQLException e){
        JOptionPane.showMessageDialog(null, e);
        }
             }
    } 
    } 
    
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
    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        // TODO add your handling code here:id.setText("");
        ((JTextField)tdate.getDateEditor().getUiComponent()).setText("");
        ref.setText("");
        amount.setText("");
        cost.setText("");
        house_no.setText("");
        id.setText("");
     
   // }                            

   // private void deleteActionPerformed(java.awt.event.ActionEvent evt) {                                           
     
    }//GEN-LAST:event_clearActionPerformed
/****/
    private void amountKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_amountKeyTyped
    char c=evt.getKeyChar();
        if(!((c==KeyEvent.VK_BACK_SPACE)||  c==KeyEvent.VK_DELETE ||Character.isDigit(c))){
        evt.consume();
        getToolkit().beep();}
    }//GEN-LAST:event_amountKeyTyped

    private void costKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_costKeyTyped
       char c=evt.getKeyChar();
        if(!((c==KeyEvent.VK_BACK_SPACE)||  c==KeyEvent.VK_DELETE ||Character.isDigit(c))){
        evt.consume();
        getToolkit().beep();}
    }//GEN-LAST:event_costKeyTyped

    private void idKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_idKeyTyped
       char c=evt.getKeyChar();
        if(!(Character.isAlphabetic(c) ||  (c==KeyEvent.VK_BACK_SPACE)||  c==KeyEvent.VK_DELETE ||Character.isDigit(c))){
        evt.consume();
        getToolkit().beep();}
    }//GEN-LAST:event_idKeyTyped

    private void refKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_refKeyTyped
     char c=evt.getKeyChar();
        if(!(Character.isAlphabetic(c) ||  (c==KeyEvent.VK_BACK_SPACE)||  c==KeyEvent.VK_DELETE ||Character.isDigit(c))){
        evt.consume();
        getToolkit().beep();}
    }//GEN-LAST:event_refKeyTyped

    private void house_noKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_house_noKeyTyped
       char c=evt.getKeyChar();
        if(!(Character.isAlphabetic(c) ||  (c==KeyEvent.VK_BACK_SPACE)||  c==KeyEvent.VK_DELETE ||Character.isDigit(c))){
        evt.consume();
        getToolkit().beep();}
    }//GEN-LAST:event_house_noKeyTyped

//GEN-FIRST:event_updateActionPerformed
 
//GEN-LAST:event_updateActionPerformed

    private void search_ref_noKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search_ref_noKeyTyped
        char c=evt.getKeyChar();
        if(!(Character.isAlphabetic(c) ||  (c==KeyEvent.VK_BACK_SPACE)||  c==KeyEvent.VK_DELETE ||Character.isDigit(c))){
            evt.consume();
            getToolkit().beep();}
    }//GEN-LAST:event_search_ref_noKeyTyped

    private void search_houseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_houseActionPerformed
      
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
       String house= "select house.refno,house.id,house.transaction_date,posting_date,house.house_size,house.payment_type,house.payment_mode,"
                        + "house.amount,house.location,house.account_debit,house.receiptno,house.amount,house.cost,house.plotno  from house where house.receiptno=? ";

                        pst = conn.prepareStatement(house);
                        pst.setString(1,search_ref_no.getText());

                        rs=pst.executeQuery();
                  if(rs.next()){
                       String add1 = rs.getString("transaction_date");
                       Date dt = new SimpleDateFormat("yyyy-MM-dd").parse(add1);
                       tdate.setDate(dt);
          
                account.setSelectedItem(rs.getString("account_debit"));
                location.setSelectedItem(rs.getString("location"));
                pmode.setSelectedItem(rs.getString("payment_mode"));
                ptype.setSelectedItem(rs.getString("payment_type"));
                size.setSelectedItem(rs.getString("house_size"));
                cost.setText(rs.getString("cost"));
                id.setText(rs.getString("id"));
                ref.setText(rs.getString("refno"));
                receiptno.setText(rs.getString("receiptno"));
                house_no.setText(rs.getString("plotno"));
                amount.setText(rs.getString("amount"));
                        
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Transaction with That Reference No"+" "+search_ref_no.getText()+" "+"does not exist");

                    }}

                    catch(SQLException e){
                        JOptionPane.showMessageDialog(null, e);
                    } catch (ParseException ex) {
               Logger.getLogger(edithouse.class.getName()).log(Level.SEVERE, null, ex);
           }
  
                    search_ref_no.setText("");

                }}
    }//GEN-LAST:event_search_houseActionPerformed
public void close(){
        WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
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
            java.util.logging.Logger.getLogger(edithouse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(edithouse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(edithouse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(edithouse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new edithouse().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Size;
    private javax.swing.JComboBox<String> account;
    private javax.swing.JTextField amount;
    private javax.swing.JButton clear;
    private javax.swing.JTextField cost;
    private javax.swing.JTextField house_no;
    private javax.swing.JTextField id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> location;
    private javax.swing.JComboBox<String> pmode;
    private javax.swing.JComboBox<String> ptype;
    private javax.swing.JPasswordField pwd;
    private javax.swing.JTextField receiptno;
    private javax.swing.JTextField ref;
    private javax.swing.JButton search_house;
    private javax.swing.JTextField search_ref_no;
    private javax.swing.JComboBox<String> size;
    private com.toedter.calendar.JDateChooser tdate;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
