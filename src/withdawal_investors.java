
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


public class withdawal_investors extends javax.swing.JFrame {

    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    private static withdawal_investors obj=null;
    
            
       DateFormat dF = new SimpleDateFormat("yyyy-MM-dd");
       Date date = new Date();
       String td=dF.format(date);
       
    private withdawal_investors() {
       
        initComponents();
        conn = DbConnect.connecrDb();

        setResizable(false);

        logo();
        current_date();
  }
        public static withdawal_investors getObj() {
        if (obj== null){
            obj = new withdawal_investors();
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
   

    private void logo() {
    setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("images/LOG.png")));
    }
    
     private void display() {
      if(conn==null){
            JOptionPane.showMessageDialog(this, "Could not connect to the server");
        }
      else{
         try {
            String searchclient = "select sum(amount) from investors_club where id=?";
            pst = conn.prepareStatement(searchclient);
            pst.setString(1, invid.getText());
            rs = pst.executeQuery();

            if (rs.next()) {
                String amntpd = rs.getString(1);
                initial_amount.setText(amntpd);
                initial_amount.setEnabled(false);
                } 
            else {
                JOptionPane.showMessageDialog(null, "No INVESTMENT Found For Client ID" + " " + invid.getText());
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
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
        invid = new javax.swing.JTextField();
        search = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        type_of_withdrawal = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        initial_amount = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        withdrawal_amount = new javax.swing.JTextField();
        save_investors = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        deductamnt = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        rate = new javax.swing.JTextField();
        pwd = new javax.swing.JPasswordField();
        cname = new javax.swing.JTextField();
        current_date = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtp = new javax.swing.JTextPane();
        print_receipt = new javax.swing.JButton();
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
        setTitle("Investors Refunds");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, " INVESTORS CLUB REFUND", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        invid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                invidKeyTyped(evt);
            }
        });

        search.setText("GET DETAILS");
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("CHOOSE");

        type_of_withdrawal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PARTIAL_WITHDRAWAL", "FULL_WITHDRAWAL" }));
        type_of_withdrawal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                type_of_withdrawalFocusLost(evt);
            }
        });

        jLabel3.setText("INVESTORS AMOUNT");

        initial_amount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                initial_amountKeyTyped(evt);
            }
        });

        jLabel4.setText("WITHDRAWAL AMOUNT");

        withdrawal_amount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                withdrawal_amountKeyTyped(evt);
            }
        });

        save_investors.setText("SAVE");
        save_investors.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save_investorsActionPerformed(evt);
            }
        });

        jLabel1.setText("INPUT PASSWORD");

        jLabel5.setText("AMOUNT TO DEDUCT FROM");

        jLabel6.setText("Rate ");

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
            public void keyTyped(java.awt.event.KeyEvent evt) {
                rateKeyTyped(evt);
            }
        });

        cname.setEditable(false);
        cname.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cname.setText("CLIENT NAME");

        current_date.setText("Date");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(invid, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(current_date, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cname, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(initial_amount, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(deductamnt)
                            .addComponent(type_of_withdrawal, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(withdrawal_amount, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(save_investors)
                                .addGap(22, 22, 22))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)))
                        .addComponent(pwd)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rate, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(invid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(search)
                    .addComponent(current_date))
                .addGap(9, 9, 9)
                .addComponent(cname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(type_of_withdrawal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(rate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(initial_amount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deductamnt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(withdrawal_amount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(pwd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(save_investors)
                .addGap(36, 36, 36))
        );

        jtp.setEditable(false);
        jScrollPane1.setViewportView(jtp);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)
                .addContainerGap())
        );

        print_receipt.setText("PRINT");
        print_receipt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                print_receiptActionPerformed(evt);
            }
        });

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/gakuyo.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(263, 263, 263)
                        .addComponent(print_receipt)
                        .addContainerGap(278, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGap(315, 315, 315)
                .addComponent(jLabel7)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(print_receipt)))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        if (invid.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Enter ID number");
        }
        else if(conn==null){
            JOptionPane.showMessageDialog(this, "Could not connect to the server");
        }
        else{
             try {
                 
                 String searchclient = "select name from investors where id=?";
                 pst = conn.prepareStatement(searchclient);
                 pst.setString(1, invid.getText());
                 rs = pst.executeQuery();
                 if(rs.next()){
                      display();
                 cname.setText(rs.getString("name"));
                     
                 }    } catch (SQLException ex) {
                 Logger.getLogger(house.class.getName()).log(Level.SEVERE, null, ex);
             }
  
        }
    }//GEN-LAST:event_searchActionPerformed

    private void save_investorsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save_investorsActionPerformed
        if (invid.getText().isEmpty() || withdrawal_amount.getText().isEmpty()||pwd.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "<html><h4><font color='red'>Kindly Fill all the fields Correctly!</font></h4></html>");
          double a = Double.parseDouble(deductamnt.getText());
          double c = Double.parseDouble(withdrawal_amount.getText());
            
      if (c>a){
        JOptionPane.showMessageDialog(null,"Amount being withdrawn cannot exceed amount invested");
        }}
       else if(pwd.getText().isEmpty()){
               JOptionPane.showMessageDialog(null,"Kindly Input Your Password ");
                  } 
       
        else if(!jtp.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "<html><h4><font color='red'>print current receipt first!</font></h4></html>");
            }
        else {
             if(conn==null){
            JOptionPane.showMessageDialog(this, "Could not connect to the server");
          }
             else if (!pwd.getText().isEmpty()){
         
          try{
             //check whether investor exist
            String searchcl = "SELECT COUNT(*) AS total FROM [investors] where id =?";
            pst=conn.prepareStatement(searchcl);
            pst.setString(1,  invid.getText().trim());
            rs = pst.executeQuery();
            while(rs.next()){
             if(rs.getInt("total")>0){
        
                  //check receipt no
         String checkrn ="SELECT TOP 1 rno FROM receipt ORDER BY rno DESC";
         pst = conn.prepareStatement(checkrn);
         rs =pst.executeQuery();
       
         while(rs.next()){
          int b = Integer.parseInt(rs.getString(1));
          int n =(b+1);
         
           String receiptno = "WINV"+n; 
             // check for user
            String searchuser = "select [user].branch,[user].fname,[user].lname,[investors].name from [user],[investors] where [user].password=?"
                           + " and [investors].id=?";
                   pst=conn.prepareStatement(searchuser);
                   pst.setString(1, md5(pwd.getText().trim()));
                   pst.setString(2, invid.getText());
                   rs = pst.executeQuery();
                   
                    if(rs.next()){
                        
                    String name=rs.getString("name");
                    String branch=rs.getString("branch");
                    String fname =rs.getString("fname"); 
                    String lname =rs.getString("lname"); 
                    String uname = fname+" "+lname;
             
                 
                double inamnt =Double.parseDouble(deductamnt.getText().trim()); 
                double  wamnt =Double.parseDouble(withdrawal_amount.getText().trim()); 
                double  bal = inamnt-wamnt;
               //
                 //calculating interest
                double rt = Double.parseDouble(rate.getText().trim());
                double intst = bal*(rt/100);
             
                //govt withholding fee
                double tax =0.05*intst;
                double pymnt = intst -tax;
                
             String ptp ="investors";
                 //record withdrawal
                String withdrawals = "insert into investor_withdrawal(id,initial_amount,withdrawal_type,withdrawal_amount,pdate,refno,balance,ptype,servedby)"
                        + "values(?,?,?,?,?,?,?,?,?)";
                
                pst = conn.prepareStatement(withdrawals);
                pst.setString(1, invid.getText().trim());
                pst.setString(2,String.valueOf(inamnt));
                pst.setString(3, type_of_withdrawal.getSelectedItem().toString());
                pst.setString(4, String.valueOf(wamnt));
                pst.setString(5, td);
                pst.setString(6, String.valueOf(receiptno));
                pst.setString(7, String.valueOf(bal));
                pst.setString(8, ptp);
                pst.setString(9, uname);
                pst.execute();
                
                //update investors
                String v1  = invid.getText().trim();
                String v2 = rate.getText().trim();
                 double v3 = intst;
                 double v4 =pymnt;
                 double v5=bal;
                 String v6 ="withdrawal";
                
                String updateinv = "update investors_club set amount='"+v5+"',interest='"+v3+"',payment='"+v4+"',pdate='"+td+"',ptype='"+v6+"'"
                        + "where id='"+v1+"' and rate='"+v2+"'";
                
                pst = conn.prepareStatement(updateinv);
                pst.execute();
                
                //display receipt number
          int nm = Integer.parseInt(withdrawal_amount.getText());
          String Englishword = EnglishNumber(nm);
          String amntw = " " + Englishword+ " "+"Kenya Shillings Only";
          String postingDate= String.valueOf(td);
          String Amount=withdrawal_amount.getText();
          String Amountw=String.valueOf(amntw);
          String sg = "...............................";
          String servedby=" ";
          String ttl="\t\t\tGAKUYO INVESTORS CLUB REFUND ";
          
          
          jtp.setPage(getClass().getResource("logo.html"));
          jtp.getStyledDocument().insertString(1, ttl+"\nBranch Name\t\t\t"+branch+"\nClient Name\t\t\t\t"+name+"\nRefNo\t\t\t\t"+receiptno+
           "\nWithdrawal Date\t\t\t"+postingDate+"\nWithdrawal Amount\t\t\t"+Amount+"\nAmount in Words:"+Amountw+""
            + "\nClient Signature:"+sg+" "+"Served by"+" "+servedby+""+name+"\n\t\t\t Where Trust Meets Your Vision",null); 
         
         
           
           JOptionPane.showMessageDialog(null,"Withdrawal recorded");
        
                }
            else{
                 JOptionPane.showMessageDialog(null,"Incorrect password");
            }
         }
            }
            }
          }      catch (SQLException ex) {
                     Logger.getLogger(withdawal_investors.class.getName()).log(Level.SEVERE, null, ex);
                 } catch (IOException ex) {
                    Logger.getLogger(withdawal_investors.class.getName()).log(Level.SEVERE, null, ex);
                } catch (BadLocationException ex) {
                    Logger.getLogger(withdawal_investors.class.getName()).log(Level.SEVERE, null, ex);
                }

             }
        }
    }//GEN-LAST:event_save_investorsActionPerformed

    
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
    private void invidKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_invidKeyTyped
     char c=evt.getKeyChar();
        if(!(Character.isAlphabetic(c) ||  (c==KeyEvent.VK_BACK_SPACE)||  c==KeyEvent.VK_DELETE ||Character.isDigit(c))){
        evt.consume();
        getToolkit().beep();}
    }//GEN-LAST:event_invidKeyTyped

    private void withdrawal_amountKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_withdrawal_amountKeyTyped
         char c=evt.getKeyChar();
        if(!((c==KeyEvent.VK_BACK_SPACE)||  c==KeyEvent.VK_DELETE ||Character.isDigit(c))){
        evt.consume();
        getToolkit().beep();}
    }//GEN-LAST:event_withdrawal_amountKeyTyped

    private void initial_amountKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_initial_amountKeyTyped
       char c = evt.getKeyChar(); 
    if(Character.isLetter(c) || Character.isISOControl(c)||Character.isDigit(c))
    {
    }
    else   evt.consume(); 
         getToolkit().beep();
    }//GEN-LAST:event_initial_amountKeyTyped

    private void print_receiptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_print_receiptActionPerformed
        if(jtp.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "<html><h4><font color='red'>Cannot print empty receipt!</font></h4></html>");
            }
          else if(conn==null){
            JOptionPane.showMessageDialog(this, "Could not connect to the server");
        }
            else {
        
               try{
            
            jtp.print();
            close();
           
        }
        catch(java.awt.print.PrinterException e)
        {
            PrintStream format = System.err.format("Cannot print %s%n");
        }
        }
    }//GEN-LAST:event_print_receiptActionPerformed

    private void rateKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rateKeyReleased
     
    }//GEN-LAST:event_rateKeyReleased

    private void rateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rateActionPerformed

    private void rateFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_rateFocusLost
        if(conn==null){
            JOptionPane.showMessageDialog(this, "Could not connect to the server");
        }
      else{
          try {
           
            String searchcl = "SELECT COUNT(*) AS total FROM [investors_club] where id =? and rate='"+rate.getText()+"'";
            
            pst=conn.prepareStatement(searchcl);
            pst.setString(1,  invid.getText().trim());
            rs = pst.executeQuery();
            while(rs.next()){
             if(rs.getInt("total")<2){
            
            String mr = "select amount from investors_club where rate='"+rate.getText()+"' and id='"+invid.getText()+"'";

            pst = conn.prepareStatement(mr);
            rs = pst.executeQuery();

            if (rs.next()) {
               String hamntpd = rs.getString("amount");
               deductamnt.setText(hamntpd);
               deductamnt.setEnabled(false);}

            } 
             else if(rs.getInt("total")>=2){
             JOptionPane.showMessageDialog(null,"More than 1 investiment found with rate "+rate.getText()+".\nTo be withdrawn by system admin");
             }
             
             else if(rs.getInt("total")==0){
                JOptionPane.showMessageDialog(null, "No INVESTMENT Found For Client ID" + " " + invid.getText() +" "+ "with rate"+ " " + rate.getText());
               }
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
 }
    }//GEN-LAST:event_rateFocusLost

    private void type_of_withdrawalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_type_of_withdrawalFocusLost

    }//GEN-LAST:event_type_of_withdrawalFocusLost

    private void rateKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rateKeyTyped
      char c = evt.getKeyChar();
        if (!(Character.isDigit(c)
                || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE || evt.getKeyChar() == '.')) {
            evt.consume();
            getToolkit().beep();
        }    }//GEN-LAST:event_rateKeyTyped

    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(() -> {
            new withdawal_investors().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cname;
    private javax.swing.JLabel current_date;
    private javax.swing.JTextField deductamnt;
    private javax.swing.JTextField initial_amount;
    private javax.swing.JTextField invid;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jtp;
    private javax.swing.JButton print_receipt;
    private javax.swing.JPasswordField pwd;
    private javax.swing.JTextField rate;
    private javax.swing.JButton save_investors;
    private javax.swing.JButton search;
    private javax.swing.JComboBox<String> type_of_withdrawal;
    private javax.swing.JTextField withdrawal_amount;
    // End of variables declaration//GEN-END:variables
}
