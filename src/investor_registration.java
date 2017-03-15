
import java.awt.Font;
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


public class investor_registration extends javax.swing.JFrame {
    
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    private static investor_registration obj=null; 
    //current date
       DateFormat dF = new SimpleDateFormat("yyyy-MM-dd");
       Date date = new Date();
       String td=dF.format(date);
      
                //autogen receipt  no
    int rno = (int) Math.floor((Math.random() * 1000000) + 1)+(int) Math.floor((Math.random() * 100000)+1);
            String receipt_no = "INVCR"+rno;
                
    private investor_registration() {
        initComponents();
        conn = DbConnect.connecrDb();
        logo();
        ComboPmode();
        current_date();
          Font font = new Font("Serif", Font.ITALIC, 5);
                    jtp.setFont(font);
    }
      public static investor_registration getObj() {
       if (obj== null){
         obj = new investor_registration();
        }
      else{
         obj.setExtendedState(JFrame.NORMAL);
         obj.setAlwaysOnTop(true);
         obj.requestFocus();
       }
       return obj;
 }
     public final void current_date(){
             today.setText(td);
        } 
     
   private void logo(){
    setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("images/LOG.png")));
    }
   public void nxtkin(){
 if(conn==null){
            JOptionPane.showMessageDialog(this, "Could not connect to the server");
        } 
       else{
      try{
           String searchkin = "select *from investors_club where id=?";
           
            pst=conn.prepareStatement(searchkin);
            pst.setString(1, invid.getText());
            rs=pst.executeQuery();
            
            if(rs.next()){
                                
                nxtname.setText(rs.getString("kin"));
                idk.setText(rs.getString("idkin"));
               }
            else{
            }
        }
        catch(SQLException e){
        JOptionPane.showMessageDialog(null, e);}
      
     }}
    private void ComboPmode(){
   if(conn==null){
            JOptionPane.showMessageDialog(this, "Could not connect to the server");
        } 
        else{
        try{
         String sql = "select *from payment_mode";
         pst = conn.prepareStatement(sql);
         rs =pst.executeQuery();
         while(rs.next()){
          String pmode = rs.getString("mode");         
          payment_mode.addItem(pmode);
           
                  }
       }
     catch(SQLException e)
     {
                 JOptionPane.showMessageDialog(null, e);
    }
  }
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
    
public void receipt(){
   if(conn==null){
            JOptionPane.showMessageDialog(this, "Could not connect to the server");
        } 
         else{
      try {
                  String ReceiptNo = String.valueOf(receipt_no);
                    
                    int r = Integer.parseInt(regfee.getText().replaceAll(",",""));
                    int l = Integer.parseInt(legalfee.getText().replaceAll(",",""));
                    int n = r+l;
                    String Englishword = EnglishNumber(n);
                    String amntw = " " + Englishword+ " "+"Kenya Shillings Only";
                    
                   String searchuser = "select *from [user] where password=?";
                   pst=conn.prepareStatement(searchuser);
                   pst.setString(1, md5(pwd.getText().trim()));
                   rs = pst.executeQuery();
                    rs.next();
                     String branch=rs.getString("branch");
                     String fname =rs.getString("fname"); 
                     String lname =rs.getString("lname"); 
                     String uname = fname+" "+lname;
                
                    String nme=name.getText();
                    String lfee=legalfee.getText();
                    String Payment_mode=payment_mode.getSelectedItem().toString();
                    String Amountw=String.valueOf(amntw);
                    String sg = "...........";
                    String Deposited="............";
                    String servedby=" ";
                    String ptype = "registration";
                    String ttl="\tGAKUYO INVESTORS CLUB REGISTRATION ";
                    
                  
                    Font font = new Font("Tahoma", Font.PLAIN, 12);
                    jtp.setFont(font);
                    jtp.setPage(getClass().getResource("logo.html"));
                     
                    jtp.getStyledDocument().insertString(1, ttl+ "\nBranch"+" "+branch+" . "+ " "+"Date Of Posting"+" "+td+
                            " . "+ " "+"Transaction Date"+"  "+td+" ."+" "+"\nClient Name\t\t\t\t"+nme+"\nReceiptNo\t\t\t\t"+
                            ReceiptNo+"\nRegistration fee\t\t\t"
                            +r+"\nLegal fee\t\t\t\t"+lfee+"\nMode Of Payment\t\t\t"+Payment_mode+"\nPayment Type\t\t\t"+ptype+
                            "\nAmount in Words:"+Amountw+"\nDepositedBy:"+Deposited+""
                            + "Client Signature:"+sg+"Served by"+servedby+""+uname+"\n\t\t Where Trust Meets Your Vision",null);
                    
              
                } catch (IOException ex) {
                    
                } catch (BadLocationException ex) {
            Logger.getLogger(investor_registration.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
           Logger.getLogger(investor_registration.class.getName()).log(Level.SEVERE, null, ex);
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
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        title = new javax.swing.JComboBox<>();
        name = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        invid = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        phoneNo = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        bkacc = new javax.swing.JTextField();
        kra_pin = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        bkname = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        nxtname = new javax.swing.JTextField();
        idk = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        pwd = new javax.swing.JPasswordField();
        jLabel9 = new javax.swing.JLabel();
        today = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        rctpanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtp = new javax.swing.JTextPane();
        print = new javax.swing.JButton();
        save = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        payment_mode = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        reference_no = new javax.swing.JTextField();
        sid = new javax.swing.JTextField();
        searchinv = new javax.swing.JButton();
        update = new javax.swing.JButton();
        regfee = new javax.swing.JFormattedTextField();
        idp = new javax.swing.JComboBox<>();
        idp1 = new javax.swing.JComboBox<>();
        legalfee = new javax.swing.JTextField();
        bank_branch = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Register Investor");
        setResizable(false);

        title.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mr.", "Mrs", "Ms", "Sir" }));

        name.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        name.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                nameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                nameFocusLost(evt);
            }
        });
        name.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                nameMouseReleased(evt);
            }
        });
        name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameActionPerformed(evt);
            }
        });
        name.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nameKeyTyped(evt);
            }
        });

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("NAME");

        invid.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        invid.setText(null);
        invid.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                invidFocusGained(evt);
            }
        });
        invid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invidActionPerformed(evt);
            }
        });
        invid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                invidKeyTyped(evt);
            }
        });

        jLabel5.setText(" Phone No.");

        phoneNo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        phoneNo.setText(null);
        phoneNo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                phoneNoFocusGained(evt);
            }
        });
        phoneNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phoneNoActionPerformed(evt);
            }
        });
        phoneNo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                phoneNoKeyTyped(evt);
            }
        });

        jLabel10.setText("Bank Acc No");

        bkacc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                bkaccKeyTyped(evt);
            }
        });

        kra_pin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                kra_pinKeyTyped(evt);
            }
        });

        jLabel7.setText("KRA Pin");

        jLabel11.setText("Bank Name");

        jLabel8.setText("Next of Kin   Details");

        jLabel13.setText("Name");

        nxtname.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        nxtname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                nxtnameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                nxtnameFocusLost(evt);
            }
        });
        nxtname.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                nxtnameMouseReleased(evt);
            }
        });
        nxtname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nxtnameActionPerformed(evt);
            }
        });
        nxtname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nxtnameKeyTyped(evt);
            }
        });

        idk.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        idk.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                idkFocusGained(evt);
            }
        });
        idk.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                idkKeyTyped(evt);
            }
        });

        jLabel2.setText("Registration fee");

        jLabel3.setText("legal fee");

        jLabel20.setText(" Password");

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/gakuyo.png"))); // NOI18N

        today.setText("today");

        jLabel1.setText("Investors Club Registration");

        jtp.setEditable(false);
        jtp.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jScrollPane1.setViewportView(jtp);

        print.setText("Print");
        print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout rctpanelLayout = new javax.swing.GroupLayout(rctpanel);
        rctpanel.setLayout(rctpanelLayout);
        rctpanelLayout.setHorizontalGroup(
            rctpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rctpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(rctpanelLayout.createSequentialGroup()
                .addGap(241, 241, 241)
                .addComponent(print)
                .addContainerGap(345, Short.MAX_VALUE))
        );
        rctpanelLayout.setVerticalGroup(
            rctpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rctpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(print, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        save.setText("Save");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        jLabel14.setText("Payment mode");

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

        jLabel15.setText("Reference No");

        reference_no.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                reference_noKeyTyped(evt);
            }
        });

        searchinv.setText("Search by ID");
        searchinv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchinvActionPerformed(evt);
            }
        });

        update.setText("Update");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        regfee.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        regfee.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                regfeeKeyTyped(evt);
            }
        });

        idp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID", "PASSPORT" }));

        idp1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID", "PASSPORT" }));

        legalfee.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                legalfeeKeyTyped(evt);
            }
        });

        jLabel12.setText("Bank Branch");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(idp1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(idk, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(pwd, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(79, 79, 79))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nxtname, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(11, 11, 11)
                                        .addComponent(idp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel11))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(bkacc, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(bkname)
                                            .addComponent(bank_branch)
                                            .addComponent(legalfee)
                                            .addComponent(reference_no))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel14))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(phoneNo, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(regfee)
                                            .addComponent(kra_pin)
                                            .addComponent(payment_mode, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(invid, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(sid)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(searchinv)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel8)
                                .addGap(247, 247, 247))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addComponent(jLabel9)
                                .addGap(116, 116, 116)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(135, 135, 135)
                                .addComponent(save)
                                .addGap(45, 45, 45)
                                .addComponent(update)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rctpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(today)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {bank_branch, bkname, kra_pin, legalfee, payment_mode, phoneNo, reference_no, regfee});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(38, 38, 38)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(invid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(bkacc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bkname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bank_branch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(legalfee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(16, 16, 16)
                                        .addComponent(idp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(searchinv)
                                            .addComponent(sid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel5)
                                            .addComponent(phoneNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel7)
                                            .addComponent(kra_pin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel2)
                                            .addComponent(regfee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel14)
                                            .addComponent(payment_mode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel11)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel12)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel15)
                                            .addComponent(reference_no, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGap(7, 7, 7)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nxtname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(idp1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(idk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20)
                            .addComponent(pwd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(save)
                            .addComponent(update)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(today)
                        .addGap(18, 18, 18)
                        .addComponent(rctpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(1155, 578));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void nameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nameFocusGained
     
    }//GEN-LAST:event_nameFocusGained

    private void nameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nameFocusLost
        // TODO add your handling code here:

    }//GEN-LAST:event_nameFocusLost

    private void nameMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nameMouseReleased
        // TODO add your handling code here:
        String sname = name.getText();
        if(sname.isEmpty()){
            name.setText("");
        }
    }//GEN-LAST:event_nameMouseReleased

    private void nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameActionPerformed

    private void nameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameKeyTyped

        char c = evt.getKeyChar();
        if ((Character.isDigit(c)
            || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE || evt.getKeyChar() == '+')) {
        evt.consume();
        getToolkit().beep();
        }
    }//GEN-LAST:event_nameKeyTyped

    private void invidFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_invidFocusGained
        
    }//GEN-LAST:event_invidFocusGained

    private void invidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_invidActionPerformed

    private void invidKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_invidKeyTyped
       char c=evt.getKeyChar();
        if(!(Character.isAlphabetic(c) ||  (c==KeyEvent.VK_BACK_SPACE)||  c==KeyEvent.VK_DELETE ||Character.isDigit(c))){
        evt.consume();
        getToolkit().beep();}
    }//GEN-LAST:event_invidKeyTyped

    private void phoneNoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_phoneNoFocusGained
        // TODO add your handling code here:
        phoneNo.setText("");
    }//GEN-LAST:event_phoneNoFocusGained

    private void phoneNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phoneNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phoneNoActionPerformed

    private void phoneNoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_phoneNoKeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c)
            || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE || evt.getKeyChar() == '+')) {
        evt.consume();

        }
    }//GEN-LAST:event_phoneNoKeyTyped

    private void bkaccKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bkaccKeyTyped

        char c=evt.getKeyChar();
        if(!(Character.isAlphabetic(c) ||  (c==KeyEvent.VK_BACK_SPACE)||  c==KeyEvent.VK_DELETE ||Character.isDigit(c))){
            evt.consume();
            getToolkit().beep();}

    }//GEN-LAST:event_bkaccKeyTyped

    private void kra_pinKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_kra_pinKeyTyped
        char c=evt.getKeyChar();
        if(!(Character.isAlphabetic(c) ||  (c==KeyEvent.VK_BACK_SPACE)||  c==KeyEvent.VK_DELETE ||Character.isDigit(c))){
            evt.consume();
            getToolkit().beep();}

    }//GEN-LAST:event_kra_pinKeyTyped

    private void nxtnameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nxtnameFocusGained
        // TODO add your handling code here:
        nxtname.setText("");
    }//GEN-LAST:event_nxtnameFocusGained

    private void nxtnameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nxtnameFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_nxtnameFocusLost

    private void nxtnameMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nxtnameMouseReleased
        // TODO add your handling code here:
        String sname = nxtname.getText();
        if(sname.isEmpty()){
            nxtname.setText("");
        }
    }//GEN-LAST:event_nxtnameMouseReleased

    private void nxtnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nxtnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nxtnameActionPerformed

    private void nxtnameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nxtnameKeyTyped

    }//GEN-LAST:event_nxtnameKeyTyped

    private void idkFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_idkFocusGained
      
    }//GEN-LAST:event_idkFocusGained

    private void idkKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_idkKeyTyped
        char c=evt.getKeyChar();
        if(!(Character.isAlphabetic(c) ||  (c==KeyEvent.VK_BACK_SPACE)||  c==KeyEvent.VK_DELETE ||Character.isDigit(c))){
            evt.consume();
            getToolkit().beep();}

    }//GEN-LAST:event_idkKeyTyped

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        if(invid.getText().isEmpty()||name.getText().isEmpty()||phoneNo.getText().isEmpty()||reference_no.getText().isEmpty()||kra_pin.getText().isEmpty()
                ||nxtname.getText().isEmpty()||idk.getText().isEmpty()||bkacc.getText().isEmpty() )
        {    JOptionPane.showMessageDialog(null, "<html><h4><font color='red'>Fill all the fields!</font></h4></html>");
        }
        
       else if(pwd.getText().isEmpty()){
               JOptionPane.showMessageDialog(null,"Kindly Input Your Password ");
                  }
   if(conn==null){
            JOptionPane.showMessageDialog(this, "Could not connect to the server");
        } 
         else{
       
        if(idp.getSelectedItem()=="ID"){
            if(invid.getText().length()!=8){
            JOptionPane.showMessageDialog(null, "ID must be 8 digits");
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
             if(rs.getInt("total")<1){
                 
            try{ 
             // check for user
           String searchuser = "select *from [user] where password=?";
            pst=conn.prepareStatement(searchuser);
            pst.setString(1, md5(pwd.getText().trim()));
            rs = pst.executeQuery();
            
            if(rs.next()){
                     String branch=rs.getString("branch");
                     String fname =rs.getString("fname"); 
                     String lname =rs.getString("lname"); 
                     String uname = fname+" "+lname;
             try{
                 //check for reference number
            String searchrefno = "SELECT COUNT(*) AS total FROM [investors] where refno =?";
            pst=conn.prepareStatement(searchrefno);
            pst.setString(1,  reference_no.getText().trim());
            rs = pst.executeQuery();
           
            while(rs.next()){
                   
             if(rs.getInt("total")<1){
            // do inserts here
        try {
               String addinv = "insert into investors(title,name,phone,acc_no,krapin,bname,regfee,legalfee,pmode,refno,nxtkin,kinid,pdate,id,servedby,bank_branch)"
                    + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                  
                                 pst = conn.prepareStatement(addinv);
                            pst.setString(1, title.getSelectedItem().toString());                               
                            pst.setString(2, name.getText().toUpperCase().trim());
                            pst.setString(3, phoneNo.getText().toUpperCase().trim());
                            pst.setString(4, bkacc.getText().toUpperCase().trim());
                            pst.setString(5, kra_pin.getText().toUpperCase().trim());
                            pst.setString(6, bkname.getText().toUpperCase().trim());
                            pst.setString(7, regfee.getText().toUpperCase().trim().replaceAll(",",""));
                            pst.setString(8, legalfee.getText().toUpperCase().trim().replaceAll(",",""));
                            pst.setString(9, payment_mode.getSelectedItem().toString()); 
                            pst.setString(10, reference_no.getText().toUpperCase().trim());
                            pst.setString(11, nxtname.getText().toUpperCase().trim());
                            pst.setString(12, idk.getText().toUpperCase().trim());
                            pst.setString(13, td);
                            pst.setString(14, invid.getText().toUpperCase().trim());
                            pst.setString(15, uname);
                            pst.setString(16,bank_branch.getText().toUpperCase().trim());
                            pst.execute();
                            
                            
                    int r = Integer.parseInt(regfee.getText().replaceAll(",",""));
                    int l = Integer.parseInt(legalfee.getText().replaceAll(",",""));
                    int n = r+l;
                    String ptype = "registration";
                    
                  
                
               String gakuyo_zero_deposit = "insert into receipt(cname,pdate,tdate,pmode,amount,receiptno,servedby,ptype,client_id,branch)"
                        + "values(?,?,?,?,?,?,?,?,?,?)";
                     
                    pst = conn.prepareStatement(gakuyo_zero_deposit);
                    
                    pst.setString(1,name.getText().trim());
                    pst.setString(2, td);
                   
                    pst.setString(3, td);
                    
                    pst.setString(4, payment_mode.getSelectedItem().toString());
                   
                    pst.setString(5, String.valueOf(n));
                   
                    pst.setString(6, String.valueOf(receipt_no));
                    pst.setString(7,uname);
                    pst.setString(8, ptype);
                    pst.setString(9,invid.getText().trim());
                    pst.setString(10, branch);
                    pst.execute();
                          
                       receipt();
                       JOptionPane.showMessageDialog(null, "Saved");       
             
               } catch (SQLException ex) {
                   Logger.getLogger(Investors_club.class.getName()).log(Level.SEVERE, null, ex);
               }   
            
            }
            else {
                 JOptionPane.showMessageDialog(null, "<html><h4><font color='red'>The reference number already exist!</font></h4></html>");
             }
            }
             }
            
             catch (SQLException ex) {
                      Logger.getLogger(investor_registration.class.getName()).log(Level.SEVERE, null, ex);
                  }
             }
               
            else{
             JOptionPane.showMessageDialog(null, "Incorrect  password");}    
            
                }
            catch (SQLException ex) {
                      Logger.getLogger(investor_registration.class.getName()).log(Level.SEVERE, null, ex);
                  }
           
           }
             else {
             JOptionPane.showMessageDialog(null, name.getText().trim()+ " " + "already exist!");
             }
            }}
                catch (SQLException ex) {
                      Logger.getLogger(investor_registration.class.getName()).log(Level.SEVERE, null, ex);
                  }
               
               
               
               }
            }
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
             if(rs.getInt("total")<1){
                 
            try{ 
             // check for user
           String searchuser = "select *from [user] where password=?";
            pst=conn.prepareStatement(searchuser);
            pst.setString(1, md5(pwd.getText().trim()));
            rs = pst.executeQuery();
            
            if(rs.next()){
                     String branch=rs.getString("branch");
                     String fname =rs.getString("fname"); 
                     String lname =rs.getString("lname"); 
                     String uname = fname+" "+lname;
             try{
                 //check for reference number
            String searchrefno = "SELECT COUNT(*) AS total FROM [investors] where refno =?";
            pst=conn.prepareStatement(searchrefno);
            pst.setString(1,  reference_no.getText().trim());
            rs = pst.executeQuery();
           
            while(rs.next()){
                   
             if(rs.getInt("total")<1){
            // do inserts here
        try {
               String addinv = "insert into investors(title,name,phone,acc_no,krapin,bname,regfee,legalfee,pmode,refno,nxtkin,kinid,pdate,id,servedby,bank_branch)"
                    + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                  
                                 pst = conn.prepareStatement(addinv);
                            pst.setString(1, title.getSelectedItem().toString());                               
                            pst.setString(2, name.getText().toUpperCase().trim());
                            pst.setString(3, phoneNo.getText().toUpperCase().trim());
                            pst.setString(4, bkacc.getText().toUpperCase().trim());
                            pst.setString(5, kra_pin.getText().toUpperCase().trim());
                            pst.setString(6, bkname.getText().toUpperCase().trim());
                            pst.setString(7, regfee.getText().toUpperCase().trim().replaceAll(",",""));
                            pst.setString(8, legalfee.getText().toUpperCase().trim().replaceAll(",",""));
                            pst.setString(9, payment_mode.getSelectedItem().toString()); 
                            pst.setString(10, reference_no.getText().toUpperCase().trim());
                            pst.setString(11, nxtname.getText().toUpperCase().trim());
                            pst.setString(12, idk.getText().toUpperCase().trim());
                            pst.setString(13, td);
                            pst.setString(14, invid.getText().toUpperCase().trim());
                            pst.setString(15, uname);
                            pst.setString(16,bank_branch.getText().toUpperCase().trim());
                            pst.execute();
                            
                            
                    int r = Integer.parseInt(regfee.getText().replaceAll(",",""));
                    int l = Integer.parseInt(legalfee.getText().replaceAll(",",""));
                    int n = r+l;
                    String ptype = "registration";
                    
                  
                
               String gakuyo_zero_deposit = "insert into receipt(cname,pdate,tdate,pmode,amount,receiptno,servedby,ptype,client_id,branch)"
                        + "values(?,?,?,?,?,?,?,?,?,?)";
                     
                    pst = conn.prepareStatement(gakuyo_zero_deposit);
                    
                    pst.setString(1,name.getText().trim());
                    pst.setString(2, td);
                   
                    pst.setString(3, td);
                    
                    pst.setString(4, payment_mode.getSelectedItem().toString());
                   
                    pst.setString(5, String.valueOf(n));
                   
                    pst.setString(6, String.valueOf(receipt_no));
                    pst.setString(7,uname);
                    pst.setString(8, ptype);
                    pst.setString(9,invid.getText().trim());
                    pst.setString(10, branch);
                    pst.execute();
                          
                       receipt();
                       JOptionPane.showMessageDialog(null, "Saved");       
             
               } catch (SQLException ex) {
                   Logger.getLogger(Investors_club.class.getName()).log(Level.SEVERE, null, ex);
               }   
            
            }
            else {
                 JOptionPane.showMessageDialog(null, "<html><h4><font color='red'>The reference number already exist!</font></h4></html>");
             }
            }
             }
            
             catch (SQLException ex) {
                      Logger.getLogger(investor_registration.class.getName()).log(Level.SEVERE, null, ex);
                  }
             }
               
            else{
             JOptionPane.showMessageDialog(null, "Incorrect  password");}    
            
                }
            catch (SQLException ex) {
                      Logger.getLogger(investor_registration.class.getName()).log(Level.SEVERE, null, ex);
                  }
  
           }
             else {
             JOptionPane.showMessageDialog(null, name.getText().trim()+ " " + "already exist!");
             }
            }}
                catch (SQLException ex) {
                      Logger.getLogger(investor_registration.class.getName()).log(Level.SEVERE, null, ex);
                  }
              }
        
        }
   }
    }//GEN-LAST:event_saveActionPerformed

    private void payment_modeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payment_modeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_payment_modeActionPerformed

    private void reference_noKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_reference_noKeyTyped
        char c=evt.getKeyChar();
        if(!(Character.isAlphabetic(c) ||  (c==KeyEvent.VK_BACK_SPACE)||  c==KeyEvent.VK_DELETE ||Character.isDigit(c))){
            evt.consume();
            getToolkit().beep();}

    }//GEN-LAST:event_reference_noKeyTyped

    private void searchinvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchinvActionPerformed
     if(sid.getText().isEmpty()){
     JOptionPane.showMessageDialog(null,"Enter ID number");
    } 
       else  if(sid.getText().length()!=8){
            JOptionPane.showMessageDialog(null, "ID must be 8 digits");
            }
   
         else{
               if(conn==null){
            JOptionPane.showMessageDialog(this, "Could not connect to the server");
        }
               else{
        try{
        
            String sinv = "select *from investors where id=?";
             pst = conn.prepareStatement(sinv);
             pst.setString(1, sid.getText());
             rs = pst.executeQuery();
              if (rs.next()) {
               title.setSelectedItem(rs.getString("title"));
                name.setText(rs.getString("name"));
                invid.setText(rs.getString("id"));
                phoneNo.setText(rs.getString("phone"));
                bkname.setText(rs.getString("bname"));
                legalfee.setText(rs.getString("legalfee"));
                regfee.setText(rs.getString("regfee"));
                reference_no.setText(rs.getString("refno")); 
                payment_mode.setSelectedItem(rs.getString("pmode"));
                kra_pin.setText(rs.getString("krapin"));
                bkacc.setText(rs.getString("acc_no"));
                nxtname.setText(rs.getString("nxtkin"));
                idk.setText(rs.getString("kinid"));
                bank_branch.setText(rs.getString("bank_branch"));
               
            } else {
                JOptionPane.showMessageDialog(null, "No investor Found with ID" + " " + sid.getText());
                
            }
            
            
        }
        catch(SQLException e){
        JOptionPane.showMessageDialog(null, e);
        }
    }
         }
    }//GEN-LAST:event_searchinvActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        if(invid.getText().isEmpty()||name.getText().isEmpty()||phoneNo.getText().isEmpty()||reference_no.getText().isEmpty()||kra_pin.getText().isEmpty()
                ||nxtname.getText().isEmpty()||idk.getText().isEmpty()||bkacc.getText().isEmpty() )
        {    JOptionPane.showMessageDialog(null, "<html><h4><font color='red'>Fill all the fields!</font></h4></html>");
        }
          else if(invid.getText().isEmpty()!=sid.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "You cannot edit id number");
                  } 
         
       else if(pwd.getText().isEmpty()){
               JOptionPane.showMessageDialog(null,"Kindly Input Your Password ");
                  } 
         else if(conn==null){
            JOptionPane.showMessageDialog(this, "Could not connect to the server");
        }  
          else{
            try{
               
                String  value1 = title.getSelectedItem().toString().toUpperCase().trim();
                String  value2 = payment_mode.getSelectedItem().toString().toUpperCase().trim();
                String  value3 = name.getText().toUpperCase().trim();
                String  value4 = bkacc.getText().toUpperCase().trim();
                String  value5 = phoneNo.getText().toUpperCase().trim();
                String  value6 = bkname.getText().toUpperCase().trim(); 
                String  value7 = kra_pin.getText().toUpperCase().trim(); 
                String  value8 = legalfee.getText().toUpperCase().trim(); 
                String  value9 = regfee.getText().toUpperCase().trim(); 
                String  value10 = reference_no.getText().toUpperCase().trim(); 
                String  value11= nxtname.getText().toUpperCase().trim(); 
                String  value12= idk.getText().toUpperCase().trim();
                String value13=bank_branch.getText().toUpperCase().trim();
               
                
                String  value = invid.getText().toUpperCase().trim();
               
                
                 String sql = "update investors set title = '"+value1+"',pmode='"+value2+"',name='"+value3+"',acc_no='"+value4+"',phone='"+value5+"',"
                         + "bname='"+value6+"',krapin ='"+value7+"',legalfee='"+value8+"',regfee='"+value9+"',refno='"+value10+"',nxtkin='"+value11+"',kinid='"+value12+"',bank_branch='"+value13+"' where id ='"+value+"'";
                 
                 pst = conn.prepareStatement(sql);
                pst.execute();
                JOptionPane.showMessageDialog(null, "Successfully Updated");
            } catch (SQLException ex) {
                Logger.getLogger(investor_registration.class.getName()).log(Level.SEVERE, null, ex);
            }
 
        }
    }//GEN-LAST:event_updateActionPerformed
 public void close(){
        WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
         }
    private void printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printActionPerformed
        if(jtp.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "<html><h4><font color='red'>Cannot print empty receipt!</font></h4></html>");
            }
    else{
      try{
          
          jtp.print();
          Investors_club i = new Investors_club();
          Investors_club.invid.setText(invid.getText().trim());
          Investors_club.cname.setText(name.getText().trim());
          Investors_club.bkacc.setText(bkacc.getText().trim());
          Investors_club.bkname.setText(bkname.getText().trim());
          Investors_club.kra_pin.setText(kra_pin.getText().trim());
          Investors_club.bkacc.setEnabled(false);
          Investors_club.bkname.setEnabled(false);
          Investors_club.kra_pin.setEnabled(false);
          Investors_club.invid.setEnabled(false);
          Investors_club.cname.setEnabled(false);
          i.setVisible(true);
          close();
        }
        catch(java.awt.print.PrinterException e)
        {
            PrintStream format = System.err.format("Cannot print %s%n");
        }
            }
    }//GEN-LAST:event_printActionPerformed

    private void legalfeeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_legalfeeKeyTyped
        // TODO add your handling code here:
        
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c)
                || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE || evt.getKeyChar() == '.')) {
            evt.consume();
            getToolkit().beep();}
    }//GEN-LAST:event_legalfeeKeyTyped

    private void regfeeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_regfeeKeyTyped
       char c = evt.getKeyChar();
        if (!(Character.isDigit(c)
                || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE || evt.getKeyChar() == '.')) {
            evt.consume();
            getToolkit().beep();}
    }//GEN-LAST:event_regfeeKeyTyped

    private void payment_modeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_payment_modeFocusLost
        if("Cash".equals(payment_mode.getSelectedItem().toString())||"Transfer".equals(payment_mode.getSelectedItem().toString())||
            "Standing order".equals(payment_mode.getSelectedItem().toString())||"Defaced Agent Slip".equals(payment_mode.getSelectedItem().toString())){
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
        }}
        }
    }//GEN-LAST:event_payment_modeFocusLost

    
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(() -> {
            new investor_registration().setVisible(true);

        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField bank_branch;
    private javax.swing.JTextField bkacc;
    private javax.swing.JTextField bkname;
    private javax.swing.JTextField idk;
    private javax.swing.JComboBox<String> idp;
    private javax.swing.JComboBox<String> idp1;
    public static javax.swing.JTextField invid;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jtp;
    public static javax.swing.JTextField kra_pin;
    private javax.swing.JTextField legalfee;
    private javax.swing.JTextField name;
    public static javax.swing.JTextField nxtname;
    private javax.swing.JComboBox<String> payment_mode;
    private javax.swing.JTextField phoneNo;
    private javax.swing.JButton print;
    private javax.swing.JPasswordField pwd;
    private javax.swing.JPanel rctpanel;
    private javax.swing.JTextField reference_no;
    private javax.swing.JFormattedTextField regfee;
    private javax.swing.JButton save;
    private javax.swing.JButton searchinv;
    private javax.swing.JTextField sid;
    private javax.swing.JComboBox<String> title;
    private javax.swing.JLabel today;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
