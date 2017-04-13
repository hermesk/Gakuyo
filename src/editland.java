
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


public class editland extends javax.swing.JFrame {

    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    private static editland obj=null;
          //current date
       DateFormat dF = new SimpleDateFormat("yyyy-MM-dd");
       Date date = new Date();
      String td=dF.format(date);
    
    private editland() {
        initComponents();
        conn = DbConnect.connecrDb();
         ComboPmode();
         ProperyDetails();
         setResizable(false);
    logo();
    }
        public static editland getObj() {
        if (obj== null){
            obj = new editland();
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
         try{
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
         
          }
        private void ProperyDetails(){
            conn = DbConnect.connecrDb();
  if(conn==null){
         JOptionPane.showMessageDialog(this, "Could not connect to the server");
        } 
            try{
         String sql = "select *from property_location";
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
            
          }
  
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        id = new javax.swing.JTextField();
        cost = new javax.swing.JTextField();
        plotno = new javax.swing.JTextField();
        amount = new javax.swing.JTextField();
        ref_no = new javax.swing.JTextField();
        ptype = new javax.swing.JComboBox<>();
        size = new javax.swing.JComboBox<>();
        location = new javax.swing.JComboBox<>();
        account = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        pmode = new javax.swing.JComboBox<>();
        tdate = new com.toedter.calendar.JDateChooser();
        update = new javax.swing.JButton();
        clear = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        pwd = new javax.swing.JPasswordField();
        jLabel16 = new javax.swing.JLabel();
        search_ref_no = new javax.swing.JTextField();
        search_investors = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        receiptno = new javax.swing.JTextField();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("EDIT LAND PAYMENTS");

        jLabel2.setText("ID/PASSPORT");

        jLabel3.setText("TRANSACTION DATE");

        jLabel4.setText("PAYMENT TYPE");

        jLabel5.setText("LOCATION");

        jLabel6.setText("SIZE");

        jLabel7.setText("COST");

        jLabel8.setText("PAYMENT MODE");

        jLabel9.setText("AMOUNT");

        jLabel11.setText("PLOT NO");

        jLabel12.setText("REF NO");

        id.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                idKeyTyped(evt);
            }
        });

        plotno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                plotnoKeyTyped(evt);
            }
        });

        amount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                amountKeyTyped(evt);
            }
        });

        ref_no.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ref_noKeyTyped(evt);
            }
        });

        ptype.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Deposit", "Installments", "Full Amount", "Balance Carried Forward" }));

        jLabel13.setText("account");

        tdate.setDateFormatString("yyyy-MM-dd");

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

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/gakuyo.png"))); // NOI18N

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("SEARCH BY REF NO:");

        search_ref_no.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                search_ref_noKeyTyped(evt);
            }
        });

        search_investors.setText("SEARCH");
        search_investors.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_investorsActionPerformed(evt);
            }
        });

        jLabel10.setText("Password");

        jLabel15.setText("Receipt no");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(search_ref_no, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(search_investors, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                        .addGap(657, 657, 657))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jLabel10))
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(update)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(150, 150, 150)
                                .addComponent(clear)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pwd, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(38, 38, 38)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel7)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel8))
                                    .addGap(27, 27, 27)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(size, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cost)
                                        .addComponent(pmode, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel2))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(id)
                                        .addComponent(tdate, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                                        .addComponent(location, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel9)
                                        .addComponent(jLabel11)
                                        .addComponent(jLabel12))
                                    .addGap(32, 32, 32)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(receiptno)
                                        .addComponent(ptype, 0, 152, Short.MAX_VALUE)
                                        .addComponent(amount)
                                        .addComponent(plotno)
                                        .addComponent(ref_no)))))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(36, 36, 36)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel15)
                                    .addGap(0, 0, Short.MAX_VALUE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(8, 8, 8)
                                    .addComponent(jLabel13)
                                    .addGap(67, 67, 67)
                                    .addComponent(account, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addGap(747, 747, 747))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(search_ref_no, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(search_investors))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(tdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(location, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(size, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(pmode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(ptype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addComponent(amount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(plotno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(ref_no, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(account, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel15)
                    .addComponent(receiptno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pwd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(update)
                    .addComponent(clear))
                .addContainerGap(150, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleName("EDIT LAND");

        setSize(new java.awt.Dimension(459, 719));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        // TODO add your handling code here:
        ((JTextField)tdate.getDateEditor().getUiComponent()).setText("");
        ref_no.setText("");
        amount.setText("");
        cost.setText("");
        plotno.setText("");
        
        id.setText("");
        
    }//GEN-LAST:event_clearActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        
              if(id.getText().isEmpty()||((JTextField)tdate.getDateEditor().getUiComponent()).getText().isEmpty()||amount.getText().isEmpty()||ref_no.getText().isEmpty())
        {
           JOptionPane.showMessageDialog(null, "<html>Fill all the fields!</html>");
        }

        else if(id.getText().length()>6)
        {
           JOptionPane.showMessageDialog(null, "<html>Invalid Id Number!</html>");
        }
         else if(pwd.getText().isEmpty()){
               JOptionPane.showMessageDialog(null,"Kindly Input Your Password ");
                  }
    
        else{
                 if(conn==null){
         JOptionPane.showMessageDialog(this, "Could not connect to the server");
        }
                 else{
            try{
              
                
          //check for user
            String searchuser = "select [user].branch,[user].fname,[user].lname,[client_detail].name from [user],[client_detail] where [user].password=?"
                           + " and [client_detail].id=?";
                   pst=conn.prepareStatement(searchuser);
                   pst.setString(1, md5(pwd.getText().trim()));
                   pst.setString(2, id.getText());
                   rs = pst.executeQuery();
                   
                    if(rs.next()){
                        
                    String name=rs.getString("name");
                    String branch=rs.getString("branch");
                    String fname =rs.getString("fname"); 
                    String lname =rs.getString("lname"); 
                    String uname = fname+" "+lname;
                    
                String  value1 = id.getText().toUpperCase().trim();
                String  value2 = ((JTextField)tdate.getDateEditor().getUiComponent()).getText().toUpperCase().trim();
                String  value3 = size.getSelectedItem().toString().toUpperCase().trim();
                String  value4 = ptype.getSelectedItem().toString().toUpperCase().trim();
                String  value5 =pmode.getSelectedItem().toString().toUpperCase().trim();
                String  value6 = account.getSelectedItem().toString().toUpperCase().trim();
                String  value7 = amount.getText().toUpperCase().trim();
                String  value9 = location.getSelectedItem().toString().toUpperCase().trim();
                String  value10 = cost.getText().toUpperCase().trim();
               
                String  value = ref_no.getText().toUpperCase().trim();
               
                  String sql = "update land set id= '"+value1+"',tdate='"+value2+"',size='"+value3+"',ptype='"+value4+"',pmode='"+value5+"',debitacc='"+value6+"',"
                + "amount='"+value7+"',location='"+value9+"',cost='"+value10+"' where ref_no ='"+value+"'";

                pst = conn.prepareStatement(sql);
                pst.execute();
                
               
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
    }//GEN-LAST:event_updateActionPerformed
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
    private void idKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_idKeyTyped
       
         char c=evt.getKeyChar();
        if(!(Character.isAlphabetic(c) ||  (c==KeyEvent.VK_BACK_SPACE)||  c==KeyEvent.VK_DELETE ||Character.isDigit(c))){
        evt.consume();
        getToolkit().beep();}
    }//GEN-LAST:event_idKeyTyped

    private void ref_noKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ref_noKeyTyped
        char c=evt.getKeyChar();
        if(!(Character.isAlphabetic(c) ||  (c==KeyEvent.VK_BACK_SPACE)||  c==KeyEvent.VK_DELETE ||Character.isDigit(c))){
        evt.consume();
        getToolkit().beep();}
    }//GEN-LAST:event_ref_noKeyTyped

    private void plotnoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_plotnoKeyTyped
        char c=evt.getKeyChar();
        if(!(Character.isAlphabetic(c) ||  (c==KeyEvent.VK_BACK_SPACE)||  c==KeyEvent.VK_DELETE ||Character.isDigit(c))){
        evt.consume();
        getToolkit().beep();}
    }//GEN-LAST:event_plotnoKeyTyped

    private void amountKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_amountKeyTyped
       char c=evt.getKeyChar();
        if(!((c==KeyEvent.VK_BACK_SPACE)||  c==KeyEvent.VK_DELETE ||Character.isDigit(c))){
        evt.consume();
        getToolkit().beep();}
    }//GEN-LAST:event_amountKeyTyped

    private void search_ref_noKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search_ref_noKeyTyped
        char c=evt.getKeyChar();
        if(!(Character.isAlphabetic(c) ||  (c==KeyEvent.VK_BACK_SPACE)||  c==KeyEvent.VK_DELETE ||Character.isDigit(c))){
            evt.consume();
            getToolkit().beep();}
    }//GEN-LAST:event_search_ref_noKeyTyped

    private void search_investorsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_investorsActionPerformed
       
        if(search_ref_no.getText().isEmpty()){

            JOptionPane.showMessageDialog(null, "<html><h4><font color='red'>Enter reference no!</font></h4></html>");
        }
      
        else{
                if(conn==null){
            JOptionPane.showMessageDialog(this, "Could not connect to the server");
        }
                else{
            try{
                
                        String house= "select *from land where land.ref_no=? ";

                        pst = conn.prepareStatement(house);
                        pst.setString(1,search_ref_no.getText());

                        rs=pst.executeQuery();


                    if(rs.next()){
                      
               String add1 = rs.getString("tdate");
                java.util.Date dt= new SimpleDateFormat("dd-MM-yyy").parse(add1);
                tdate.setDate(dt);

                account.setSelectedItem(rs.getString("debitacc"));

                location.setSelectedItem(rs.getString("location"));
                account.setSelectedItem(rs.getString("pmode"));
                ptype.setSelectedItem(rs.getString("ptype"));
                size.setSelectedItem(rs.getString("size"));
                cost.setText(rs.getString("cost"));
                id.setText(rs.getString("id"));
                ref_no.setText(rs.getString("ref_no"));
                plotno.setText(rs.getString("plot_no"));
                amount.setText(rs.getString("amount"));
                receiptno.setText(rs.getString("receiptno"));
                receiptno.setEnabled(false);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Client with That Reference No"+" "+search_ref_no.getText()+" "+"does not exist");

                    }}

                    catch(SQLException e){
                        JOptionPane.showMessageDialog(null, e);
                    } catch (ParseException ex) {
               Logger.getLogger(editland.class.getName()).log(Level.SEVERE, null, ex);
           }
           
                    search_ref_no.setText("");
                }
                }
    }//GEN-LAST:event_search_investorsActionPerformed
public void close(){
        WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
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
            java.util.logging.Logger.getLogger(editland.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(editland.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(editland.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(editland.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new editland().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> account;
    private javax.swing.JTextField amount;
    private javax.swing.JButton clear;
    private javax.swing.JTextField cost;
    private javax.swing.JTextField id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JComboBox<String> location;
    private javax.swing.JTextField plotno;
    private javax.swing.JComboBox<String> pmode;
    private javax.swing.JComboBox<String> ptype;
    private javax.swing.JPasswordField pwd;
    private javax.swing.JTextField receiptno;
    private javax.swing.JTextField ref_no;
    private javax.swing.JButton search_investors;
    private javax.swing.JTextField search_ref_no;
    private javax.swing.JComboBox<String> size;
    private com.toedter.calendar.JDateChooser tdate;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables

}