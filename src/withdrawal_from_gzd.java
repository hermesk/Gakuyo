
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.PrintStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
import javax.swing.text.BadLocationException;

public class withdrawal_from_gzd extends javax.swing.JFrame {

    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    private static withdrawal_from_gzd obj=null;
   
               //current date
       DateFormat dF = new SimpleDateFormat("yyyy-MM-dd");
       Date date = new Date();
        String td=dF.format(date);
        
   private withdrawal_from_gzd() {
        initComponents();
        conn = DbConnect.connecrDb();
        current_date();
        logo();
    }
       public static withdrawal_from_gzd getObj() {
        if (obj== null){
            obj = new withdrawal_from_gzd();
        }
      else{
         obj.setExtendedState(JFrame.NORMAL);
         obj.setAlwaysOnTop(true);
         obj.requestFocus();
       }
       return obj;
 }
    public final void current_date(){
             current_date.setText(td);
    }

    private void logo() {
    setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("images/LOG.png")));
    }

    private void display() {
       if(conn==null){
            JOptionPane.showMessageDialog(this, "Could not connect to the server");
        }
       else{
        try {
                 
                 String search = "select sum(gakuyo_zero_deposit.amount),client_detail.name,gakuyo_zero_deposit.type_of_house"
                         + " from client_detail,gakuyo_zero_deposit where gakuyo_zero_deposit.id=? and client_detail.id=gakuyo_zero_deposit.id "
                         + "GROUP BY gakuyo_zero_deposit.type_of_house,client_detail.name";

                    pst = conn.prepareStatement(search);
                    pst.setString(1, id.getText());
                    rs = pst.executeQuery();

            if (rs.next()) {
                String amntpd = rs.getString(1);
                cname.setText(rs.getString("name"));
                type_of_property.setSelectedItem(rs.getString("type_of_house"));
                type_of_property.setEnabled(false);
                gzd_amount.setText(amntpd);
                gzd_amount.setEnabled(false);
                
                } 
            else {
                JOptionPane.showMessageDialog(null, "No GAKUYO ZERO DEPOSIT Found For Client ID" + " " + id.getText());

            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
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
      private static final String[] ones =
{
" One",
" Two",
" Three",
" Four",
" Five",
" Six",
" Seven",
" Eight",
" Nine",
" Ten",
" Eleven",
" Twelve",
" Thirteen",
" Fourteen",
" Fifteen",
" Sixteen",
" Seventeen",
" Eighteen",
" Nineteen" };
  private static final String[] tens =
{
" Twenty",
" Thirty",
" Forty",
" Fifty",
" Sixty",
" Seventy",
" Eighty",
" Ninety" };
private static final String[] groups =
{
"",
" Thousand",
" Million",
" Billion",
" Trillion",
" Quadrillion",
" Quintillion" };
private String string = new String();

public String getString() {
return string;
}

public String EnglishNumber(long enteredNo) {


for (int i = groups.length - 1; i >= 0; i--) {



long cutoff = (long) Math.pow((double) 10, (double) (i * 3));

if (enteredNo >= cutoff) {
int thisPart = (int) (enteredNo / cutoff);



if (thisPart >= 100) {
string += ones[(thisPart / 100) - 1] + " Hundred ";

thisPart = thisPart % 100;
}
if (thisPart >= 20) {
string += tens[(thisPart / 10) - 2];
thisPart = thisPart % 10;
}
if (thisPart >= 1) {
string += ones[thisPart - 1];
}

string += groups[i];

enteredNo = enteredNo % cutoff;
}
}

if (string.length() == 0) {
string = "Zero";
} else {

string = string.substring(1);
}
return string;
}

     public void close(){
        WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
         }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        id = new javax.swing.JTextField();
        get_details = new javax.swing.JButton();
        current_date = new javax.swing.JLabel();
        gzd_amount = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        type_of_withdrawals = new javax.swing.JComboBox<>();
        save_withdrawal_gzd = new javax.swing.JButton();
        type_of_property = new javax.swing.JComboBox<>();
        pwd = new javax.swing.JPasswordField();
        cname = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        withdrawal_amount = new javax.swing.JFormattedTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtp = new javax.swing.JTextPane();
        print_gzd = new javax.swing.JButton();

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
        setTitle("GZD Refunds");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "GZD REFUND", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        jLabel1.setText("I.D PASSPORT NO.");

        id.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                idKeyTyped(evt);
            }
        });

        get_details.setText("GET DETAILS");
        get_details.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                get_detailsActionPerformed(evt);
            }
        });

        current_date.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        current_date.setText("DATE");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("CHOOSE");

        type_of_withdrawals.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PARTIAL_WITHDRAWAL", "FULL_WITHDRAWAL" }));

        save_withdrawal_gzd.setText("SAVE");
        save_withdrawal_gzd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save_withdrawal_gzdActionPerformed(evt);
            }
        });

        type_of_property.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2 Bedroom", "3 Bedroom", "Land" }));

        cname.setEditable(false);
        cname.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cname.setText("CLIENT NAME");

        jLabel7.setText("INPUT PASSWORD");

        jLabel8.setText("AMOUNT WITHDRAWN");

        jLabel9.setText("GZD AMOUNT");

        jLabel2.setText("TYPE OF PROPERTY");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/gakuyo.png"))); // NOI18N

        withdrawal_amount.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(save_withdrawal_gzd, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(type_of_property, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(type_of_withdrawals, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(gzd_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(withdrawal_amount, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(38, 38, 38)
                                .addComponent(current_date, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(146, 146, 146)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(pwd, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(108, 108, 108)
                                .addComponent(cname, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(48, 48, 48)
                                .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(get_details, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {gzd_amount, type_of_property, type_of_withdrawals});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(current_date)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(get_details)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gzd_amount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(withdrawal_amount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(type_of_property, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(type_of_withdrawals, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pwd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(save_withdrawal_gzd)
                .addContainerGap())
        );

        jScrollPane1.setViewportView(jtp);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE))
        );

        print_gzd.setText("PRINT");
        print_gzd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                print_gzdActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(229, 229, 229)
                        .addComponent(print_gzd)))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(print_gzd)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void get_detailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_get_detailsActionPerformed
        if (id.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Enter ID number");
        } 
          else if(conn==null){
            JOptionPane.showMessageDialog(this, "Could not connect to the server");
        }else {
                 display();
              
        }
    }//GEN-LAST:event_get_detailsActionPerformed

    private void save_withdrawal_gzdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save_withdrawal_gzdActionPerformed
         
        if (id.getText().isEmpty() || withdrawal_amount.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "<html><h4><font color='red'>Kindly Fill all the fields Correctly!</font></h4></html>");
        
          int a = Integer.parseInt(gzd_amount.getText().replaceAll(",",""));
          int b = Integer.parseInt(withdrawal_amount.getText().replaceAll(",",""));
         if (b>a){
        JOptionPane.showMessageDialog(null,"Amount being withdrawn cannot exceed total amount deposited");
        }
         else if(pwd.getText().isEmpty()){
               JOptionPane.showMessageDialog(null,"Kindly Input Your Password ");
                  } 
        }
         
           else if(!jtp.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "<html><h4><font color='red'>print current receipt first!</font></h4></html>");
            }
            if(conn==null){
            JOptionPane.showMessageDialog(this, "Could not connect to the server");
        }
    
        else {
             if (!pwd.getText().isEmpty()){
                 
            try {
                 //check whether client exist
            String searchcl = "SELECT COUNT(*) AS total FROM [client_detail] where id =?";
            pst=conn.prepareStatement(searchcl);
            pst.setString(1,  id.getText().trim());
            rs = pst.executeQuery();
            while(rs.next()){
             if(rs.getInt("total")>0){ 
           
          // check for user
            String searchuser = "select [user].branch,[user].fname,[user].lname,[client_detail].name from "
                            + "[user],[client_detail] where [user].password=? and [client_detail].id=? ";
                   pst=conn.prepareStatement(searchuser);
                   pst.setString(1, md5(pwd.getText().trim()));
                   pst.setString(2, id.getText());
                   rs = pst.executeQuery();
        
            if(rs.next()){
                     
                    String name=rs.getString("name");//client
                    String branch=rs.getString("branch");
                    String fname =rs.getString("fname"); 
                    String lname =rs.getString("lname"); 
                    String uname = fname+" "+lname;
                 
      int rno =(int) Math.floor((Math.random() * 1000000) + 1)+(int) Math.floor((Math.random() * 100000)+1);
         
           String receiptno = "WDGZD"+rno; 
       
           
                //calculating Withdrawal
                    int tamnt = Integer.parseInt(gzd_amount.getText().trim().replaceAll(",",""));
                    int wamnt = Integer.parseInt(withdrawal_amount.getText().trim().replaceAll(",",""));
                    int bal = tamnt-wamnt;
                    int wmnt =  -(wamnt);
                    String tp = "gzd";
                    
            
                String withdrawals = "insert into gzd_withdrawals(id,inamount,ptype,wtype,"
                        + "wamount,pdate,receipt_no,balance,trtype,servedby)"
                        + "values(?,?,?,?,?,?,?,?,?,?)";

                pst = conn.prepareStatement(withdrawals);

                pst.setString(1, id.getText().trim());
                pst.setString(2, gzd_amount.getText().trim().replaceAll(",",""));
                pst.setString(3, type_of_property.getSelectedItem().toString());
                pst.setString(4, type_of_withdrawals.getSelectedItem().toString());
                pst.setString(5, withdrawal_amount.getText().trim().replaceAll(",",""));
                pst.setString(6, td);
                pst.setString(7, String.valueOf(receiptno));
                pst.setString(8, String.valueOf(bal));
                pst.setString(9, tp);
                pst.setString(10, uname);
                pst.execute();
               
                    
                   
                    String gakuyo_zero_deposit = "insert into gakuyo_zero_deposit(amount,posting_date,id,type_of_house,ref_no,receipt_no)"
                            + "values(?,?,?,?,?,?)";
                    
                    
                    pst = conn.prepareStatement(gakuyo_zero_deposit);
                    pst.setString(1, String.valueOf(wmnt));
                    pst.setString(2, td);
                    pst.setString(3, id.getText().trim());
                    pst.setString(4, type_of_property.getSelectedItem().toString());
                    pst.setString(5, String.valueOf(rno));
                    pst.setString(6, String.valueOf(receiptno));
                    pst.execute();
                   
                     //display receipt no
                    
                    int nm = Integer.parseInt(withdrawal_amount.getText().replaceAll(",",""));
                    String Englishword = EnglishNumber(nm);
                    String amntw = " " + Englishword+ " "+"Kenya Shillings Only";
                    
                    String postingDate= String.valueOf(td);
                    
                   
                    String Amount=withdrawal_amount.getText();
                    String Amountw=String.valueOf(amntw);
                    String sg = ".......................";
                    String servedby=" ";
                    String ttl="\t\tGAKUYO ZERO DEPOSIT REFUND ";
                  
                    
                    jtp.setPage(getClass().getResource("logo.html"));
                    jtp.getStyledDocument().insertString(1, ttl+"\nBranch Name\t\t\t"+branch+"\nClient Name\t\t\t\t"+name+"\nRefundNo\t\t\t\t"+receiptno+
                   "\nDate Of Refund\t\t\t"+postingDate+"\nRefund Amount\t\t\t"+Amount+"\nAmount in Words:"+Amountw+""
                    + "\nClient Signature:"+sg+"Served by"+servedby+""+uname+"\n\n\t\t Where Trust Meets Your Vision",null);
             
                //update breceipt
              JOptionPane.showMessageDialog(null, "Withdrawal Recorded");
            
            }
            else{
              JOptionPane.showMessageDialog(this, "Incorrect password");

            }
            
            }
            }
            }
                 catch (SQLException ex) {
                     Logger.getLogger(withdrawal_from_gzd.class.getName()).log(Level.SEVERE, null, ex);
                 } catch (IOException ex) {
                     Logger.getLogger(withdrawal_from_gzd.class.getName()).log(Level.SEVERE, null, ex);
                 } catch (BadLocationException ex) {
                     Logger.getLogger(withdrawal_from_gzd.class.getName()).log(Level.SEVERE, null, ex);
                 }
 
            }}
    }//GEN-LAST:event_save_withdrawal_gzdActionPerformed

    private void idKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_idKeyTyped
         char c=evt.getKeyChar();
        if(!(Character.isAlphabetic(c) ||  (c==KeyEvent.VK_BACK_SPACE)||  c==KeyEvent.VK_DELETE ||Character.isDigit(c))){
        evt.consume();
        getToolkit().beep();}
        
    }//GEN-LAST:event_idKeyTyped
       
    
    private void print_gzdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_print_gzdActionPerformed
       if(jtp.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "<html><h4><font color='red'>Cannot print empty receipt!</font></h4></html>");
            }
      
            else {
        try {
                   jtp.print();
                  close();
                
        }
        catch(java.awt.print.PrinterException e)
        {
            PrintStream format = System.err.format("Cannot print %s%n");
        }
        }
    
    }//GEN-LAST:event_print_gzdActionPerformed

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
            java.util.logging.Logger.getLogger(withdrawal_from_gzd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(withdrawal_from_gzd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(withdrawal_from_gzd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(withdrawal_from_gzd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new withdrawal_from_gzd().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cname;
    private javax.swing.JLabel current_date;
    private javax.swing.JButton get_details;
    private javax.swing.JTextField gzd_amount;
    private javax.swing.JTextField id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jtp;
    private javax.swing.JButton print_gzd;
    private javax.swing.JPasswordField pwd;
    private javax.swing.JButton save_withdrawal_gzd;
    private javax.swing.JComboBox<String> type_of_property;
    private javax.swing.JComboBox<String> type_of_withdrawals;
    private javax.swing.JFormattedTextField withdrawal_amount;
    // End of variables declaration//GEN-END:variables
}
