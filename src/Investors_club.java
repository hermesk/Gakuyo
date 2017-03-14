
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
import javax.swing.JTextField;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
public class Investors_club extends javax.swing.JFrame  {

    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    private static Investors_club obj=null;
  
            //current date
   DateFormat dF = new SimpleDateFormat("yyyy-MM-dd");
       Date date = new Date();
       String td=dF.format(date);
                
    
    Investors_club() {
        
       initComponents();
     
       conn = DbConnect.connecrDb();
       ComboPmode();
     
      
        logo();
    }
       public static Investors_club getObj() {
        if (obj== null){
            obj = new Investors_club();
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
     
     private void display() {
         conn = DbConnect.connecrDb();
         if(conn==null){
            JOptionPane.showMessageDialog(null, "Could not connect to the server");
        }
          else{
        try {
            String searchclient = "select *from investors where id=?";

            pst = conn.prepareStatement(searchclient);
            pst.setString(1, invid.getText());
            rs = pst.executeQuery();

            if (rs.next()) {
                kra_pin.setText(rs.getString("krapin"));
                bkacc.setText(rs.getString("acc_no"));
                bkname.setText(rs.getString("bname"));
                cname.setText(rs.getString("name"));
                ptype.setSelectedItem("Top up");
                kra_pin.setEnabled(false);
                bkacc.setEnabled(true);
                bkname.setEnabled(true);
               
            } else {
                JOptionPane.showMessageDialog(null, "No investment Found For Client ID" + " " + invid.getText());
                
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
                                    finally {
    try { rs.close(); } catch (SQLException e) {JOptionPane.showMessageDialog(null, e);   }
    try { pst.close(); } catch (SQLException e) { JOptionPane.showMessageDialog(null, e); }
    try { conn.close(); System.out.println("Connection closed");} catch (SQLException e) {JOptionPane.showMessageDialog(null, e); }
}
          }
    }
   public void close(){
        WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
         }
      private void ComboPmode(){
          conn = DbConnect.connecrDb();
          if(conn==null){
            JOptionPane.showMessageDialog(null, "Could not connect to the server");
        } 
          else{
          try{
         String sql = "select *from payment_mode";
         pst = conn.prepareStatement(sql);
         rs =pst.executeQuery();
         while(rs.next()){
          String pmode = rs.getString("mode");         
          payment_mode.addItem(pmode);
           String dbt = rs.getString("debit");         
          accounts.addItem(dbt);
                  }
       }
     catch(SQLException e)
     {
                 JOptionPane.showMessageDialog(null, e);
    }
                                      finally {
    try { rs.close(); } catch (SQLException e) {  }
    try { pst.close(); } catch (SQLException e) { }
    try { conn.close(); System.out.println("Connection closed");} catch (SQLException e) {}
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
 
  
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rctpanel = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        reference_no = new javax.swing.JTextField();
        interest = new javax.swing.JTextField();
        accounts = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        rate = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        invid = new javax.swing.JTextField();
        kra_pin = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        ptype = new javax.swing.JComboBox<>();
        payment_mode = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        cmd_save = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        bkacc = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        bkname = new javax.swing.JTextField();
        getdetailt = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        pwd = new javax.swing.JPasswordField();
        transaction_date = new com.toedter.calendar.JDateChooser();
        cname = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        Amount_invested = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        paymnt = new javax.swing.JFormattedTextField();
        govtw = new javax.swing.JFormattedTextField();
        print = new javax.swing.JButton();
        rctpn = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtp = new javax.swing.JTextPane();

        javax.swing.GroupLayout rctpanelLayout = new javax.swing.GroupLayout(rctpanel);
        rctpanel.setLayout(rctpanelLayout);
        rctpanelLayout.setHorizontalGroup(
            rctpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 620, Short.MAX_VALUE)
        );
        rctpanelLayout.setVerticalGroup(
            rctpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 304, Short.MAX_VALUE)
        );

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
        setTitle("Investors Club");

        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/gakuyo.png"))); // NOI18N

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "INVESTORS CLUB", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel2.setPreferredSize(new java.awt.Dimension(1046, 438));

        reference_no.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                reference_noKeyTyped(evt);
            }
        });

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

        jLabel2.setText("Rate");

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

        jLabel7.setText("KRA Pin");

        jLabel9.setText("Transaction Date");

        jLabel16.setText("PAYMENT TYPE");

        invid.setText(null);
        invid.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                invidFocusGained(evt);
            }
        });
        invid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                invidKeyTyped(evt);
            }
        });

        kra_pin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                kra_pinKeyTyped(evt);
            }
        });

        jLabel1.setText("Amount");

        jLabel4.setText("Payment mode");

        ptype.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Deposit", "Installments", "Top up", "Balance Carried Forward" }));

        payment_mode.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                payment_modeFocusLost(evt);
            }
        });
        payment_mode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payment_modeActionPerformed(evt);
            }
        });

        jLabel5.setText("Account to Debit");

        jLabel3.setText("Interest");

        jLabel14.setText("Reference No");

        jLabel15.setText("I.D/Passport No.");

        cmd_save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Save-icon.png"))); // NOI18N
        cmd_save.setText("Save");
        cmd_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd_saveActionPerformed(evt);
            }
        });

        jLabel10.setText("Bank Acc No");

        bkacc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                bkaccKeyTyped(evt);
            }
        });

        jLabel11.setText("Bank Name");

        getdetailt.setText("Get Client Details");
        getdetailt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getdetailtActionPerformed(evt);
            }
        });

        jLabel19.setText("Payment");

        transaction_date.setDateFormatString(" yyyy-MM-dd");

        cname.setEditable(false);
        cname.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cname.setText("CLIENT NAME");

        jLabel6.setText("Password");

        Amount_invested.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        Amount_invested.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                Amount_investedKeyTyped(evt);
            }
        });

        jLabel8.setText("Govt W Tax");

        paymnt.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));

        govtw.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 532, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel3)
                            .addComponent(jLabel15)
                            .addComponent(jLabel14)
                            .addComponent(jLabel1)
                            .addComponent(jLabel11))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(297, 297, 297)
                                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(Amount_invested, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel4))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(157, 157, 157)
                                                .addComponent(jLabel5)))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(rate, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(bkacc)
                                                        .addComponent(invid, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                                                        .addComponent(reference_no)
                                                        .addComponent(interest)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel19)
                                                    .addComponent(getdetailt)
                                                    .addComponent(jLabel16)
                                                    .addComponent(jLabel8)))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(bkname, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel7)))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(kra_pin)
                                            .addComponent(payment_mode, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(accounts, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(transaction_date, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(ptype, 0, 146, Short.MAX_VALUE)
                                                    .addComponent(paymnt)
                                                    .addComponent(govtw))
                                                .addGap(0, 0, Short.MAX_VALUE)))))
                                .addGap(27, 27, 27))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(36, 36, 36)
                                .addComponent(pwd, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(cname, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(216, 216, 216)
                        .addComponent(cmd_save)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(invid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel15)
                        .addComponent(getdetailt))
                    .addComponent(transaction_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(payment_mode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Amount_invested, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(reference_no, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(accounts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel16)
                    .addComponent(ptype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(interest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel19)
                        .addComponent(paymnt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(bkacc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(govtw, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(bkname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(kra_pin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pwd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmd_save)
                .addGap(84, 84, 84))
        );

        print.setText("Print");
        print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printActionPerformed(evt);
            }
        });

        jtp.setEditable(false);
        jtp.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jScrollPane2.setViewportView(jtp);

        javax.swing.GroupLayout rctpnLayout = new javax.swing.GroupLayout(rctpn);
        rctpn.setLayout(rctpnLayout);
        rctpnLayout.setHorizontalGroup(
            rctpnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rctpnLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 557, Short.MAX_VALUE)
                .addContainerGap())
        );
        rctpnLayout.setVerticalGroup(
            rctpnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rctpnLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 591, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rctpn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(210, 210, 210)
                        .addComponent(print)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(rctpn, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(print))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(58, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(1227, 594));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void payment_modeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payment_modeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_payment_modeActionPerformed

    private void invidFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_invidFocusGained
   
    }//GEN-LAST:event_invidFocusGained

    @SuppressWarnings("empty-statement")
   
    private void cmd_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_saveActionPerformed
      
       if(!jtp.getText().isEmpty())
           {
        JOptionPane.showMessageDialog(null,"Print current receipt");
        }
      else  if(invid.getText().isEmpty()|| ((JTextField)transaction_date.getDateEditor().getUiComponent()).getText().isEmpty()
          ||Amount_invested.getText().isEmpty()||reference_no.getText().isEmpty()||rate.getText().isEmpty()||kra_pin.getText().isEmpty()
                ||bkacc.getText().isEmpty() )
        {    JOptionPane.showMessageDialog(null, "<html><h4><font color='red'>Fill all the fields!</font></h4></html>");
        }
        else if(pwd.getText().isEmpty()){
               JOptionPane.showMessageDialog(null,"Kindly Input Your Password ");
                  }
        else{  
          conn = DbConnect.connecrDb();
       if(conn==null){
            JOptionPane.showMessageDialog(null, "Could not connect to the server");
        }
       else{
            
               if (!pwd.getText().isEmpty()){
               
    try{
                     //check whether client exist
            String searchcl = "SELECT COUNT(*) AS total FROM [investors] where id =?";
            pst=conn.prepareStatement(searchcl);
            pst.setString(1,  invid.getText().trim());
            rs = pst.executeQuery();
            while(rs.next()){
             if(rs.getInt("total")>0){
         
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
           
           
                 //check for reference number
            String searchrefno = "SELECT COUNT(*) AS total FROM [investors_club] where reference =?";
            pst=conn.prepareStatement(searchrefno);
            pst.setString(1,  reference_no.getText().trim());
            rs = pst.executeQuery();
           
            while(rs.next()){
             if(rs.getInt("total")<1){
           
             //check receipt no
         String checkrn ="SELECT TOP 1 rno FROM receipt ORDER BY rno DESC";
         pst = conn.prepareStatement(checkrn);
         rs =pst.executeQuery();
       
         while(rs.next()){
          int b = Integer.parseInt(rs.getString(1));
          int n =(b+1);
         
           String receiptno = "GINVC"+n; 
            
              String addinvestor = "insert into investors_club(id,tdate,pdate,amount,mode,reference,debitacc,ptype,rate,"
                         + "interest,pkra,receiptno,bank_name,bank_account,payment,govtw,servedby) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                                  
                     pst = conn.prepareStatement(addinvestor);
             
                pst.setString(1, invid.getText().trim());
                pst.setString(2, ((JTextField)transaction_date.getDateEditor().getUiComponent()).getText().trim());           
                pst.setString(3, td);
                pst.setString(4, Amount_invested.getText().trim().replaceAll(",",""));           
                pst.setString(5, payment_mode.getSelectedItem().toString());
                pst.setString(6, reference_no.getText().trim());
                pst.setString(7, accounts.getSelectedItem().toString()); 
                pst.setString(8, ptype.getSelectedItem().toString());                                              
                pst.setString(9, rate.getText().trim());
                pst.setString(10,interest.getText().trim());
                pst.setString(11,kra_pin.getText().trim());  
                pst.setString(12, String.valueOf(receiptno));
                pst.setString(13, bkname.getText().trim());
                pst.setString(14, bkacc.getText().trim());
                pst.setString(15, paymnt.getText().trim() );
                pst.setString(16, govtw.getText());
                pst.setString(17, uname);
                pst.execute();

                //display receipt
                int nm = Integer.parseInt(Amount_invested.getText().replaceAll(",",""));
                    String Englishword = EnglishNumber(nm);
                    String amntw = " " + Englishword+ " "+"Kenya Shillings Only";
                    
                    String transactionDate=((JTextField)transaction_date.getDateEditor().getUiComponent()).getText();
                    String payment= paymnt.getText();
                    String gv= govtw.getText();
                    String Deposit_Type= ptype.getSelectedItem().toString();
                    String Payment_mode=payment_mode.getSelectedItem().toString();
                    String Amount=Amount_invested.getText();
                    String Amountw=String.valueOf(amntw);
                    String sg = ".............";
                    String Deposited=".................";
                    String servedby=" ";
                    String ttl="\t\tGAKUYO INVESTORS CLUB ";
                    
                    StyledDocument doc = (StyledDocument) jtp.getDocument();
                    Style style = doc.addStyle("Tahoma", null);
                    StyleConstants.setFontSize(style, 11);
                    
                    jtp.setPage(getClass().getResource("logo.html"));
                    jtp.getStyledDocument().insertString(1, ttl+"\nBranch"+" "+branch+" . "+ " "+"Date Of Posting"+" "+td+  " . "+ " "+"Transaction Date"+"  "+transactionDate+" ."+" "+"\nClient Name\t\t\t\t"+name+"\nReceiptNo\t\t\t\t"+receiptno+"\nMonthly Payment\t\t\t"
                    +payment+"\nType Of Deposit\t\t\t"+Deposit_Type+"\nMode Of Payment\t\t\t"+Payment_mode+ "\nWithhoding tax\t\t\t"+gv+"\nAmount\t\t\t\t"+Amount+"\nAmount in Words:"+Amountw+"\nDepositedBy:"+Deposited+""
                    + "Client Signature:"+sg+"Served by"+servedby+""+uname+"\n\t\t Where Trust Meets Your Vision",style);
           
              
              //save in receipt 
              String inv = "insert into receipt(cname,pdate,tdate,ptype,pmode,amount,receiptno,servedby,branch,client_id,rno)"
                        + "values(?,?,?,?,?,?,?,?,?,?,?)";
                     
                    pst = conn.prepareStatement(inv);
                    
                    pst.setString(1,name);
                    pst.setString(2, td);
                   
                    pst.setString(3, ((JTextField)transaction_date.getDateEditor().getUiComponent()).getText().trim());
                    
                    pst.setString(4, ptype.getSelectedItem().toString());
                    pst.setString(5, payment_mode.getSelectedItem().toString());
                   
                    pst.setString(6, Amount_invested.getText().trim().replaceAll(",",""));
                   
                    pst.setString(7, String.valueOf(receiptno));
                    pst.setString(8,uname);
                    pst.setString(9, branch);
                    pst.setString(10,invid.getText().trim());
                    pst.setString(11,String.valueOf(n)); //increment receipt numbers
                    pst.execute();
               JOptionPane.showMessageDialog(null, "Saved");
                
             }
            }
            else {
                 JOptionPane.showMessageDialog(null, "<html><h4><font color='red'>The reference number already exist!</font></h4></html>");
             }
            }
             
             }
               
            else{
             JOptionPane.showMessageDialog(null, "Incorrect  password");}    
          }
             else {
             JOptionPane.showMessageDialog(null, "<html><h4><font color='red'>Client with ID " +invid.getText().trim()+ " does not exist! Please register the client</font></h4></html>");
             }
            }}
                catch (SQLException ex) {
                      Logger.getLogger(Investors_club.class.getName()).log(Level.SEVERE, null, ex);
                  } catch (IOException ex) {
                       Logger.getLogger(Investors_club.class.getName()).log(Level.SEVERE, null, ex);
                   } catch (BadLocationException ex) {
                       Logger.getLogger(Investors_club.class.getName()).log(Level.SEVERE, null, ex);
                   }
                               finally {
    try { rs.close(); } catch (SQLException e) {  }
    try { pst.close(); } catch (SQLException e) { }
    try { conn.close(); System.out.println("Connection closed");} catch (SQLException e) {}
}
               }
             }
        } 
        
    }//GEN-LAST:event_cmd_saveActionPerformed

    private void rateKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rateKeyReleased
       
                
    }//GEN-LAST:event_rateKeyReleased

    private void invidKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_invidKeyTyped
       char c=evt.getKeyChar();
        if(!(Character.isAlphabetic(c) ||  (c==KeyEvent.VK_BACK_SPACE)||  c==KeyEvent.VK_DELETE ||Character.isDigit(c))){
        evt.consume();
        getToolkit().beep();}
     
    }//GEN-LAST:event_invidKeyTyped

    private void kra_pinKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_kra_pinKeyTyped
      char c=evt.getKeyChar();
        if(!(Character.isAlphabetic(c) ||  (c==KeyEvent.VK_BACK_SPACE)||  c==KeyEvent.VK_DELETE ||Character.isDigit(c))){
        evt.consume();
        getToolkit().beep();}
     
    }//GEN-LAST:event_kra_pinKeyTyped

    private void rateKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rateKeyTyped
             char c = evt.getKeyChar();
        if (!(Character.isDigit(c)
                || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE || evt.getKeyChar() == '.')) {
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_rateKeyTyped

    private void reference_noKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_reference_noKeyTyped
       char c=evt.getKeyChar();
        if(!(Character.isAlphabetic(c) ||  (c==KeyEvent.VK_BACK_SPACE)||  c==KeyEvent.VK_DELETE ||Character.isDigit(c))){
        evt.consume();
        getToolkit().beep();}
        
     
    }//GEN-LAST:event_reference_noKeyTyped

    private void transaction_dateKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_transaction_dateKeyTyped
       
    }//GEN-LAST:event_transaction_dateKeyTyped

    private void rateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rateActionPerformed

    private void interestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_interestActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_interestActionPerformed

    private void getdetailtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getdetailtActionPerformed
        if (invid.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Enter ID number");
        } else {
          display();
        }
    }//GEN-LAST:event_getdetailtActionPerformed

    private void printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printActionPerformed
        
                  if(jtp.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "<html><h4><font color='red'>Cannot print empty receipt!</font></h4></html>");
            }
                  else{

        try{
            
            jtp.print();
            close();
             Investors_club iv = new Investors_club();
                 iv .setVisible(true);
            
        }
        catch(java.awt.print.PrinterException e)
        {
            PrintStream format = System.err.format("Cannot print %s%n");
      }
        
                  } 
            
    }//GEN-LAST:event_printActionPerformed

    private void bkaccKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bkaccKeyTyped
       
        char c=evt.getKeyChar();
        if(!(Character.isAlphabetic(c) ||  (c==KeyEvent.VK_BACK_SPACE)||  c==KeyEvent.VK_DELETE ||Character.isDigit(c))){
        evt.consume();
        getToolkit().beep();}
     
    }//GEN-LAST:event_bkaccKeyTyped

    private void rateFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_rateFocusLost
     
                 //calculating interest
                int amnt = Integer.parseInt(Amount_invested.getText().replaceAll(",",""));
                double rt = Double.parseDouble(rate.getText().trim());
                double intst = amnt*(rt/100);
             
                //govt withholding fee
                double tax =0.05*intst;
                double pymnt = intst -tax;
                     
                paymnt.setText(String.valueOf(pymnt));
                interest.setText(String.valueOf(intst));
                govtw.setText(String.valueOf(tax));
                interest.setEnabled(false); 
                paymnt.setEnabled(false); 
                govtw.setEnabled(false);
      
    }//GEN-LAST:event_rateFocusLost

    private void Amount_investedKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Amount_investedKeyTyped
       char c = evt.getKeyChar();
        if (!(Character.isDigit(c)
                || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE || evt.getKeyChar() == '.')) {
            evt.consume();
            getToolkit().beep();
        }    }//GEN-LAST:event_Amount_investedKeyTyped

    private void interestFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_interestFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_interestFocusLost

    private void payment_modeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_payment_modeFocusLost
        if("Cash".equals(payment_mode.getSelectedItem().toString())||"Transfer".equals(payment_mode.getSelectedItem().toString())||
            "Standing order".equals(payment_mode.getSelectedItem().toString())||"Defaced Agent Slip".equals(payment_mode.getSelectedItem().toString())){
         conn = DbConnect.connecrDb();
        if(conn==null){
            JOptionPane.showMessageDialog(null, "Could not connect to the server");
        }
        else{
        try{
                     //check receipt no
         String checkrn ="SELECT TOP 1 rno FROM receipt ORDER BY rno DESC";
         pst = conn.prepareStatement(checkrn);
         rs =pst.executeQuery();
       
         if(rs.next()){
          int b = Integer.parseInt(rs.getString(1));
          int n =(b+1);
      
           reference_no.setText(String.valueOf(n));
           reference_no.setEnabled(false);

         }
          else{
         JOptionPane.showMessageDialog(null, "null rtc");
         }
          }
       
       catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        }
        
        }
      
        
    }//GEN-LAST:event_payment_modeFocusLost
    
    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(() -> {
            new Investors_club().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField Amount_invested;
    private javax.swing.JComboBox<String> accounts;
    public static javax.swing.JTextField bkacc;
    public static javax.swing.JTextField bkname;
    private javax.swing.JButton cmd_save;
    public static javax.swing.JTextField cname;
    private javax.swing.JButton getdetailt;
    private javax.swing.JFormattedTextField govtw;
    private javax.swing.JTextField interest;
    public static javax.swing.JTextField invid;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextPane jtp;
    public static javax.swing.JTextField kra_pin;
    private javax.swing.JComboBox<String> payment_mode;
    private javax.swing.JFormattedTextField paymnt;
    private javax.swing.JButton print;
    private javax.swing.JComboBox<String> ptype;
    private javax.swing.JPasswordField pwd;
    private javax.swing.JTextField rate;
    private javax.swing.JPanel rctpanel;
    private javax.swing.JPanel rctpn;
    private javax.swing.JTextField reference_no;
    private com.toedter.calendar.JDateChooser transaction_date;
    // End of variables declaration//GEN-END:variables
}
