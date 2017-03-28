
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.print.PrinterException;
import java.io.IOException;
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
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;



public class payment_voucher extends javax.swing.JFrame {

     Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
   private static payment_voucher obj=null;
    
    //current date
       DateFormat dF = new SimpleDateFormat("yyyy-MM-dd");
       Date date = new Date();
       String td=dF.format(date);
       
       int rno = (int) Math.floor((Math.random() * 1000000) + 1)+(int) Math.floor((Math.random() * 10000)+1);
       String receipt_no = "PV"+rno;
 
    private payment_voucher() {
        initComponents();
        conn = DbConnect.connecrDb();
        setResizable(false);
        current_date();
          logo();
    }
      public final void current_date(){
             current_date.setText(td);
       }
         public static payment_voucher getObj() {
        if (obj== null){
            obj = new payment_voucher();
        }
      else{
         obj.setExtendedState(JFrame.NORMAL);
         obj.setAlwaysOnTop(true);
         obj.requestFocus();
       }
       return obj;
 }
      public void close(){
        WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
         }
    
    private void logo(){
    setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("images/LOG.png")));
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
public void dreceipt(){
    conn = DbConnect.connecrDb();
     if(conn==null){
            JOptionPane.showMessageDialog(this, "Could not connect to the server");
        }
     else if(!jtp.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "<html><h4><font color='red'>print current receipt</font></h4></html>");
            }
     else{
        try{
                   String searchuser = "select *from [user] where password=?";
                   pst=conn.prepareStatement(searchuser);
                   pst.setString(1, md5(pwd.getText().trim()));
                   
                   rs = pst.executeQuery();
                    if(rs.next()){
                    String nme=payee_name.getText();
                    String branch=rs.getString("branch");
                    String fname =rs.getString("fname"); 
                    String lname =rs.getString("lname"); 
                    String name = fname+" "+lname;
                    String typeoftrans=choose.getSelectedItem().toString();
                    String ReceiptNo = String.valueOf(receipt_no);
                    String Desc=description.getText();
                    
                    int n = Integer.parseInt(amount.getText().replaceAll(",",""));
                    String Englishword = EnglishNumber(n);
                    String amntw = " " + Englishword+ " "+"Kenya Shillings Only";
                    
                    
                    String Amount=amount.getText();
                    String Amountw=String.valueOf(amntw);
                    String sg = "...........................";
                    String servedby=" ";
                    String ttl="\t\tPAYMENT VOUCHER RECEIPT ";
                    
                    StyledDocument doc = (StyledDocument) jtp.getDocument();
                    Style style = doc.addStyle("Tahoma", null);
                    StyleConstants.setFontSize(style, 12);
                    jtp.setPage(getClass().getResource("logo.html"));
                    jtp.getStyledDocument().insertString(1, ttl+"\n\nBranch\t\t\t"+" "+branch+" . "+ " "+"\nDate Of Transaction\t\t"+" "+td+"\nName Of Payee\t\t"+nme+"\nVoucher No\t\t\t"+ReceiptNo+"\nMode Of Payment\t\t"+typeoftrans+"\nDescription\t\t\t"+Desc+"\nAmount\t\t\t"+Amount+ "\nAmount in Words:"+Amountw+""
                                    + "\n\nPayee Signature:"+sg+"\t"+""+"Served by"+servedby+""+name+"\n\t\t Where Trust Meets Your Vision",style);
               }
                   
        }
         catch (IOException | BadLocationException | SQLException ex) {
         }
            finally {
    try { rs.close(); } catch (SQLException e) {  }
    try { pst.close(); } catch (SQLException e) { }
    try { conn.close(); System.out.println("Connection closed");} catch (SQLException e) {}
}
         JOptionPane.showMessageDialog(null, "Saved");
         
     }           
  }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        payee_name = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        description = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        amount = new javax.swing.JTextField();
        choose = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        save = new javax.swing.JButton();
        current_date = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        pwd = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtp = new javax.swing.JTextPane();
        jLabel6 = new javax.swing.JLabel();

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
        setTitle("Payment Voucher");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "PAYMENT VOUCHER / EXPENSES", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        jLabel1.setText("NAME OF PAYEE");

        payee_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payee_nameActionPerformed(evt);
            }
        });

        jLabel3.setText("DESCRIPTION");

        description.setColumns(20);
        description.setRows(5);
        jScrollPane1.setViewportView(description);

        jLabel4.setText("AMOUNT");

        amount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                amountKeyTyped(evt);
            }
        });

        choose.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CASH", "CHEQUE" }));

        jLabel5.setText("CHOOSE");

        save.setText("SAVE");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        current_date.setText("Date");

        jLabel2.setText("INPUT PASSWORD");

        jButton1.setText("PRINT RECIEPT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(save))
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(choose, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(amount, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(payee_name, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(33, 33, 33)
                                    .addComponent(current_date)))
                            .addComponent(pwd, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(payee_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(current_date))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(amount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(choose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(pwd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(save))
                .addGap(274, 274, 274))
        );

        jtp.setEditable(false);
        jScrollPane2.setViewportView(jtp);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 359, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/gakuyo.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(328, 328, 328)
                        .addComponent(jLabel6)))
                .addContainerGap(65, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(1012, 549));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void payee_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payee_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_payee_nameActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        
        if(payee_name.getText().isEmpty()||amount.getText().isEmpty()||description.getText().isEmpty() )
            
       {    JOptionPane.showMessageDialog(null, "<html><h4><font color='red'>Kindly Fill all the fields Correctly!</font></h4></html>");
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
            if (!pwd.getText().isEmpty()){
           try{
               
                    String searchuser = "select *from [user] where password=?";
                   pst=conn.prepareStatement(searchuser);
                   pst.setString(1, md5(pwd.getText().trim()));
                   rs = pst.executeQuery();
                    if(rs.next()){
                    String branch=rs.getString("branch");
                    String fname =rs.getString("fname"); 
                    String lname =rs.getString("lname"); 
                    String name = fname+" "+lname;
                 
                 
                  String payment_voucher = "insert into payment_voucher(date_of_payment,payee_name,description,amount,payment_mode,receipt_no,servedby,branch)"
                         + "values(?,?,?,?,?,?,?,?)";
                  try {
                
                pst = conn.prepareStatement(payment_voucher);
                pst.setString(1, td);
                pst.setString(2,  payee_name.getText().trim());
                pst.setString(3, description.getText().trim());
                pst.setString(4, amount.getText().trim());
                pst.setString(5,  choose.getSelectedItem().toString()); 
                pst.setString(6, String.valueOf(receipt_no));
                pst.setString(7, name);
                pst.setString(8, branch);
                pst.execute();
                dreceipt();
                
                  } catch (SQLException ex) {
                   Logger.getLogger(payment_voucher.class.getName()).log(Level.SEVERE, null, ex);
               }
                    }
                    else{
                    JOptionPane.showMessageDialog(null, "incorrect password" );
                    }
           
           }
           catch (NumberFormatException | HeadlessException e) {
                JOptionPane.showMessageDialog(null, e);

            } catch (SQLException ex) {
                Logger.getLogger(payment_voucher.class.getName()).log(Level.SEVERE, null, ex);
            }
   finally {
    try { rs.close(); } catch (SQLException e) {  }
    try { pst.close(); } catch (SQLException e) { }
    try { conn.close(); System.out.println("Connection closed");} catch (SQLException e) {}
}
        }}
            
        }
    }//GEN-LAST:event_saveActionPerformed

    private void amountKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_amountKeyTyped
           char c = evt.getKeyChar();
        if (!(Character.isDigit(c)
                || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)) {
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_amountKeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
              if(jtp.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "<html><h4><font color='red'>Cannot print empty receipt!</font></h4></html>");
            }
            else {
         try {
                    jtp.print();
                   
            close();
                } catch (PrinterException ex) {
                    Logger.getLogger(payment_voucher.class.getName()).log(Level.SEVERE, null, ex);
                }
}  
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
            java.util.logging.Logger.getLogger(payment_voucher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(payment_voucher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(payment_voucher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(payment_voucher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new payment_voucher().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField amount;
    private javax.swing.JComboBox<String> choose;
    private javax.swing.JLabel current_date;
    private javax.swing.JTextArea description;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextPane jtp;
    private javax.swing.JTextField payee_name;
    private javax.swing.JPasswordField pwd;
    private javax.swing.JButton save;
    // End of variables declaration//GEN-END:variables
}
