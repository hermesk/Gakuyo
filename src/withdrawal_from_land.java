
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


public class withdrawal_from_land extends javax.swing.JFrame {

    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
private static withdrawal_from_land obj=null;    
    // autgen receipt no
                int rno = (int) Math.floor((Math.random() * 1000000) + 1)+(int) Math.floor((Math.random() * 100000)+1);
                String receipt_no = "WD" + rno+ "LND";
                     //current date
       DateFormat dF = new SimpleDateFormat("yyyy-MM-dd");
       Date date = new Date();
        String td=dF.format(date);
    
    private withdrawal_from_land() {
        initComponents();
        conn = DbConnect.connecrDb();

        setResizable(false);
        ProperyDetails();
        current_date();
        logo();
    }
        public static withdrawal_from_land getObj() {
        if (obj== null){
            obj = new withdrawal_from_land();
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
        conn = DbConnect.connecrDb();
      if(conn==null){
            JOptionPane.showMessageDialog(this, "Could not connect to the server");
        }
      else{
        try {
            String searchclient = "select sum(land.amount),client_detail.name, land.location,land.cost,land.size,land.plot_no from"
                    + " land,client_detail where land.id=? and land.id=client_detail.id GROUP BY client_detail.name,land.location,land.cost,land.size,plot_no";

            pst = conn.prepareStatement(searchclient);
            pst.setString(1, id.getText());
            rs = pst.executeQuery();
            
                if(rs.next()){
                cname.setText(rs.getString("name"));
                String amntpd = rs.getString(1);
                initial_amount.setText(amntpd);
                initial_amount.setEnabled(false);
                pc.setText(rs.getString("cost"));
                pc.setEnabled(false);
                psize.setSelectedItem(rs.getString("size"));
                psize.setEnabled(false);
              
                plot_no.setText(rs.getString("plot_no"));
                plot_no.setEnabled(false);
                pl.setSelectedItem(rs.getString("location"));
                pl.setEnabled(true);
                }
               
             else {
                JOptionPane.showMessageDialog(null, "No LAND PURCHASE Found For Client ID" + " " + id.getText());

            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        finally {
    try { rs.close(); } catch (SQLException e) {  }
    try { pst.close(); } catch (SQLException e) { }
    try { conn.close(); System.out.println("Connection closed");} catch (SQLException e) {}
}
      }
    }
    public void dreceipt() throws SQLException{
        conn = DbConnect.connecrDb();
     if(conn==null){
            JOptionPane.showMessageDialog(this, "Could not connect to the server");
        }    
     else{        
                try {
                   
                
                  String searchuser = "select[user].branch,[user].fname,[user].lname   "
                            + "from [user] where password=?";
                    
                   pst=conn.prepareStatement(searchuser);
                   pst.setString(1, md5(pwd.getText().trim()));
                   rs = pst.executeQuery();
                    rs.next();
                    
                    String fname =rs.getString("fname"); 
                    String lname =rs.getString("lname"); 
                    String name = fname+" "+lname;
                    String branch=rs.getString("branch");
                    
                    String nme= cname.getText();
                    
                    String ReceiptNo = String.valueOf(receipt_no);
                    
                    int n = Integer.parseInt(withdrawal_amount.getText());
                    String Englishword = EnglishNumber(n);
                    String amntw = " " + Englishword+ " "+"Kenya Shillings Only";
                    
                    String postingDate= String.valueOf(td);
                    String penalty=penalty_charge_fee.getText();
                    String Amountrec=amount_received.getText();
                    String Amountw=String.valueOf(amntw);
                    String sg = "..............";
                    String servedby=" ";
                    String ttl="\t\t\tGAKUYO LAND REFUND ";
                  
                    
                    jtp.setPage(getClass().getResource("logo.html"));
                    jtp.getStyledDocument().insertString(1, ttl+"\nBranch Name\t\t\t"+branch+"\nClient Name\t\t\t\t"+nme+"\nrefno\t\t\t\t"
                            +ReceiptNo+"\nDate Of withdrawal\t\t\t"+postingDate+"\nWithdrawal Amount Recievd\t\t"+Amountrec+
                            "\nPenalty Fee\t\t\t\t"+penalty+"\nAmount withdrawn:\t\t\t"+n+"\nAmount in Words:"+Amountw+""
                                    + " "+"Client Signature:"+sg+"\nServed by"+servedby+""+name+"\n\n\t\t\t Where Trust Meets Your Vision",null);
             
                } catch (IOException | BadLocationException ex) {
                    Logger.getLogger(withdrawal_from_land.class.getName()).log(Level.SEVERE, null, ex);
                }
     finally {
    try { rs.close(); } catch (SQLException e) {  }
    try { pst.close(); } catch (SQLException e) { }
    try { conn.close(); System.out.println("Connection closed");} catch (SQLException e) {}
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
      private void ProperyDetails() {
        conn = DbConnect.connecrDb();
          if(conn==null){
            JOptionPane.showMessageDialog(this, "Could not connect to the server");
        }
                  else{
          try {
            String sql = "select *from property_location";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                String lctn = rs.getString("location");
                pl.addItem(lctn);
                String sz = rs.getString("size");
                psize.addItem(sz);
                
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
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
        private void displayptno() {
       conn = DbConnect.connecrDb();
      if(conn==null){
            JOptionPane.showMessageDialog(this, "Could not connect to the server");
        }
      else{
          try {
            String searchld = "select client_detail.name,land.location,land.amount,land.cost,land.plot_no,land.size from client_detail,land where land.id=client_detail.id and land.plot_no=?";

            pst = conn.prepareStatement(searchld );
            pst.setString(1, sbplotno.getText());
            rs = pst.executeQuery();

            if (rs.next()) {

                initial_amount.setText(rs.getString("amount"));
                initial_amount.setEnabled(false);
                pc.setText(rs.getString("cost"));
                cname.setText(rs.getString("name"));
                pc.setEnabled(false);
                psize.setSelectedItem(rs.getString("size"));
                psize.setEnabled(false);
                cname.setEnabled(false);
              
                plot_no.setText(rs.getString("plot_no"));
                plot_no.setEnabled(false);
                pl.setSelectedItem(rs.getString("location"));
             
            } else {
                JOptionPane.showMessageDialog(null, "No Land Payments Found For Client ID" + " " + id.getText());
                
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
      finally {
    try { rs.close(); } catch (SQLException e) {  }
    try { pst.close(); } catch (SQLException e) { }
    try { conn.close(); System.out.println("Connection closed");} catch (SQLException e) {}
}
      }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rctpanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtp = new javax.swing.JTextPane();
        print_receipt = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        psize = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        pwd = new javax.swing.JPasswordField();
        jLabel8 = new javax.swing.JLabel();
        id = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        save_withdrawal_amount = new javax.swing.JButton();
        plot_no = new javax.swing.JTextField();
        amount_received = new javax.swing.JTextField();
        pc = new javax.swing.JTextField();
        penalty_charge_fee = new javax.swing.JTextField();
        Search = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        current_date = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        withdrawal_amount = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cname = new javax.swing.JTextField();
        pl = new javax.swing.JComboBox<>();
        initial_amount = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        sbplotno = new javax.swing.JTextField();
        penalty_charge_rate = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        idsearch = new javax.swing.JButton();

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
        setTitle("Land Refunds");

        jScrollPane1.setViewportView(jtp);

        javax.swing.GroupLayout rctpanelLayout = new javax.swing.GroupLayout(rctpanel);
        rctpanel.setLayout(rctpanelLayout);
        rctpanelLayout.setHorizontalGroup(
            rctpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rctpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 551, Short.MAX_VALUE)
                .addContainerGap())
        );
        rctpanelLayout.setVerticalGroup(
            rctpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rctpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE)
                .addContainerGap())
        );

        print_receipt.setText("PRINT");
        print_receipt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                print_receiptActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Land refund", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/gakuyo.png"))); // NOI18N

        jLabel8.setText("PENALTY CHARGE %");

        id.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                idKeyTyped(evt);
            }
        });

        jLabel5.setText("SEARCH BY HOUSE");

        save_withdrawal_amount.setText("SAVE");
        save_withdrawal_amount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save_withdrawal_amountActionPerformed(evt);
            }
        });

        plot_no.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                plot_noKeyTyped(evt);
            }
        });

        amount_received.setEditable(false);
        amount_received.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        pc.setEditable(false);
        pc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pcActionPerformed(evt);
            }
        });
        pc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pcKeyTyped(evt);
            }
        });

        penalty_charge_fee.setEditable(false);
        penalty_charge_fee.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                penalty_charge_feeKeyTyped(evt);
            }
        });

        Search.setText("SEARCH BY PLOT NO:");
        Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchActionPerformed(evt);
            }
        });

        jLabel6.setText("INPUT PASSWORD");

        jLabel1.setText("ID");

        current_date.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        current_date.setText("DATE");

        jLabel10.setText("PENALTY CHARGE FEE");

        withdrawal_amount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                withdrawal_amountKeyTyped(evt);
            }
        });

        jLabel3.setText("COST OF PROPERTY");

        jLabel2.setText("LOCATION");

        cname.setEditable(false);
        cname.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cname.setText("client name");

        initial_amount.setEditable(false);
        initial_amount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                initial_amountKeyTyped(evt);
            }
        });

        jLabel4.setText("PROPERTY SIZE");

        jLabel7.setText("TOTAL AMOUNT");

        penalty_charge_rate.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                penalty_charge_rateFocusLost(evt);
            }
        });
        penalty_charge_rate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                penalty_charge_rateKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                penalty_charge_rateKeyTyped(evt);
            }
        });

        jLabel11.setText("WITHDRAWAL AMOUNT");

        jLabel12.setText("AMOUNT RECIEVED");

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("PLOT N0:");

        idsearch.setText("GET DETAILS");
        idsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idsearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(withdrawal_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(penalty_charge_fee, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(initial_amount, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(23, 23, 23)
                                        .addComponent(pwd, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 113, Short.MAX_VALUE))
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addGap(51, 51, 51))))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(jLabel8)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(pc, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(plot_no, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(penalty_charge_rate, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(amount_received, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(sbplotno, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                                    .addComponent(psize, javax.swing.GroupLayout.Alignment.TRAILING, 0, 104, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addComponent(Search))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44)
                                .addComponent(pl, 0, 104, Short.MAX_VALUE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(75, 75, 75)
                                .addComponent(current_date, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(id, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(idsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(cname, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(194, 194, 194)
                        .addComponent(save_withdrawal_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel10, jLabel12});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {id, initial_amount, penalty_charge_fee, pl, psize, sbplotno});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {current_date, pc, penalty_charge_rate, plot_no});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(current_date)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(idsearch)
                            .addComponent(jLabel2))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(sbplotno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Search)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(psize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(17, 17, 17))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel7)
                            .addComponent(initial_amount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(withdrawal_amount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(penalty_charge_fee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(pc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(plot_no, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(penalty_charge_rate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(amount_received, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(cname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(pwd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(save_withdrawal_amount)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(rctpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(print_receipt)
                        .addGap(240, 240, 240))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rctpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(print_receipt))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void idsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idsearchActionPerformed
        if (id.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Enter ID number");
        } 
          else if(conn==null){
            JOptionPane.showMessageDialog(this, "Could not connect to the server");
        }
          else {
                display();
        }
    }//GEN-LAST:event_idsearchActionPerformed

    private void penalty_charge_rateKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_penalty_charge_rateKeyReleased
              
               
    }//GEN-LAST:event_penalty_charge_rateKeyReleased

    private void save_withdrawal_amountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save_withdrawal_amountActionPerformed
         conn = DbConnect.connecrDb();
        if (id.getText().isEmpty() || withdrawal_amount.getText().isEmpty()||pc.getText().isEmpty()||initial_amount.getText().isEmpty()||penalty_charge_rate.getText().isEmpty()
               ||penalty_charge_fee.getText().isEmpty()||amount_received.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "<html><h2><font color='red'>Kindly Fill all the required fields Correctly!</font></h2></html>");}
          
            else if(pwd.getText().isEmpty()){
               JOptionPane.showMessageDialog(null,"Kindly Input Your Password ");
                  } 
            
           else if(conn==null){
            JOptionPane.showMessageDialog(this, "Could not connect to the server");
        }
        
       else {
               int a = Integer.parseInt(initial_amount.getText());
          int b = Integer.parseInt(withdrawal_amount.getText());
          
            
            if (b>a){
        JOptionPane.showMessageDialog(null,"Amount being withdrawn cannot exceed total amount deposited");
        }
             else if(!jtp.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "<html><h4><font color='red'>print current receipt first!</font></h4></html>");
            }
               else if (!pwd.getText().isEmpty()){
                    
             try {
                 //check whether client exist
            String searchcl = "SELECT COUNT(*) AS total FROM [client_detail] where id =?";
            pst=conn.prepareStatement(searchcl);
            pst.setString(1,  id.getText().trim());
            rs = pst.executeQuery();
            while(rs.next()){
             if(rs.getInt("total")>0){ 
                 
                  try{ 
             // check for user
           String searchuser = "select username from [user] where password=?";
            pst=conn.prepareStatement(searchuser);
            pst.setString(1, md5(pwd.getText().trim()));
            rs = pst.executeQuery();
            if(rs.next()){
                
                try {
                   String srchuser = "select [user].fname,[user].lname from [user] where [user].password=?";
                   pst=conn.prepareStatement(srchuser);
                   pst.setString(1, md5(pwd.getText().trim()));
                   rs = pst.executeQuery();
                   rs.next();
                   
                   String fname =rs.getString("fname"); 
                   String lname =rs.getString("lname"); 
                   String uname = fname+" "+lname;
                    
                   String ptp ="land";
                   int wamnt= Integer.parseInt(withdrawal_amount.getText().trim());
                
        
                String propertywithdrawals = "insert into property_withdrawals(id,amount_withdrawn,pdate,receipt_no,property_location,plot_no,"
                        + "property_size,property_cost,amount_payed,penalty_rate,penalty_fee,amount_received,ptype,servedby)"
                        + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                
                 pst = conn.prepareStatement(propertywithdrawals);

                pst.setString(1, id.getText().trim());
                pst.setString(2, withdrawal_amount.getText().trim());
                pst.setString(3, td);
                pst.setString(4, receipt_no);
                pst.setString(5, pl.getSelectedItem().toString());
                pst.setString(6, plot_no.getText().trim());
                pst.setString(7, psize.getSelectedItem().toString());
                pst.setString(8, pc.getText().trim());
                pst.setString(9, initial_amount.getText().trim());
                pst.setString(10, penalty_charge_rate.getText().trim());
                pst.setString(11, penalty_charge_fee.getText().trim());
                pst.setString(12, String.valueOf(wamnt));
                pst.setString(13, ptp);
                pst.setString(14, uname);
                pst.execute();
                
                      //subracting from the database
                int wamnt1= -(wamnt);
                int bal  =a+wamnt1;
                 String w = "withdrawals from"+" "+pl.getSelectedItem().toString();
                
                
                String tland = "insert into land(id,size,location,cost,amount,tdate,ref_no,receiptno,pmode,balance)"
                            + "values(?,?,?,?,?,?,?,?,?,?)";
                
                   pst = conn.prepareStatement(tland);
                    pst.setString(1, id.getText().trim());
                    pst.setString(2, psize.getSelectedItem().toString());
                    pst.setString(3, pl.getSelectedItem().toString());
                    pst.setString(4, pc.getText().trim());
                    pst.setString(5, String.valueOf(wamnt1));
                    pst.setString(6, td);
                    pst.setString(7, String.valueOf(receipt_no));
                    pst.setString(8, String.valueOf(receipt_no));
                    pst.setString(9, w);
                    pst.setString(10, String.valueOf(bal));
                    pst.execute();
                    
                    dreceipt();
                    savrct();
                    JOptionPane.showMessageDialog(null, "Saved");
                } 
                catch (SQLException ex) {
                    Logger.getLogger(withdrawal_from_gzd.class.getName()).log(Level.SEVERE, null, ex);
                }
        
                }
        } catch (SQLException ex) {
                        Logger.getLogger(withdrawal_from_land.class.getName()).log(Level.SEVERE, null, ex);
                    }
    }
}
}                   catch (SQLException ex) {
                        Logger.getLogger(withdrawal_from_land.class.getName()).log(Level.SEVERE, null, ex);
                    }
 finally {
    try { rs.close(); } catch (SQLException e) {  }
    try { pst.close(); } catch (SQLException e) { }
    try { conn.close(); System.out.println("Connection closed");} catch (SQLException e) {}
}
        }   
       }
    }//GEN-LAST:event_save_withdrawal_amountActionPerformed

    private void pcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pcActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pcActionPerformed

    private void idKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_idKeyTyped
      char c=evt.getKeyChar();
        if(!(Character.isAlphabetic(c) ||  (c==KeyEvent.VK_BACK_SPACE)||  c==KeyEvent.VK_DELETE ||Character.isDigit(c))){
        evt.consume();
        getToolkit().beep();}
    }//GEN-LAST:event_idKeyTyped

    private void pcKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pcKeyTyped
        char c=evt.getKeyChar();
        if(!((c==KeyEvent.VK_BACK_SPACE)||  c==KeyEvent.VK_DELETE ||Character.isDigit(c))){
        evt.consume();
        getToolkit().beep();}
    }//GEN-LAST:event_pcKeyTyped

    private void plot_noKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_plot_noKeyTyped
       char c=evt.getKeyChar();
        if(!(Character.isAlphabetic(c) ||  (c==KeyEvent.VK_BACK_SPACE)||  c==KeyEvent.VK_DELETE ||Character.isDigit(c))){
        evt.consume();
        getToolkit().beep();}
    }//GEN-LAST:event_plot_noKeyTyped

    private void initial_amountKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_initial_amountKeyTyped
        char c=evt.getKeyChar();
        if(!((c==KeyEvent.VK_BACK_SPACE)||  c==KeyEvent.VK_DELETE ||Character.isDigit(c))){
        evt.consume();
        getToolkit().beep();}
    }//GEN-LAST:event_initial_amountKeyTyped

    private void withdrawal_amountKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_withdrawal_amountKeyTyped
     char c=evt.getKeyChar();
        if(!((c==KeyEvent.VK_BACK_SPACE)||  c==KeyEvent.VK_DELETE ||Character.isDigit(c))){
        evt.consume();
        getToolkit().beep();}
    }//GEN-LAST:event_withdrawal_amountKeyTyped

    private void penalty_charge_rateKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_penalty_charge_rateKeyTyped
         char c = evt.getKeyChar();
        if (!(Character.isDigit(c)
                || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE || evt.getKeyChar() == '.')) {
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_penalty_charge_rateKeyTyped

    private void penalty_charge_feeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_penalty_charge_feeKeyTyped
         char c=evt.getKeyChar();
        if(!((c==KeyEvent.VK_BACK_SPACE)||  c==KeyEvent.VK_DELETE ||Character.isDigit(c))){
        evt.consume();
        getToolkit().beep();}
    }//GEN-LAST:event_penalty_charge_feeKeyTyped

    private void SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchActionPerformed
        if (sbplotno.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Enter plot number");
        } 
        else { 
          displayptno(); 
        } 
    }//GEN-LAST:event_SearchActionPerformed

    public void savrct(){
        conn = DbConnect.connecrDb();
    if(conn==null){
            JOptionPane.showMessageDialog(this, "Could not connect to the server");
        }
         else {
            try {
                String searchclient = "select client_detail.name,[user].branch,[user].fname,[user].lname from client_detail,[user] where client_detail.id=? "
                        + "and [user].password=? ";
                    pst = conn.prepareStatement(searchclient);
                    pst.setString(1, id.getText());
                    pst.setString(2, md5(pwd.getText().trim()));
                    rs = pst.executeQuery();
                    rs.next();
                    String nme=rs.getString("name");
                    String branch=rs.getString("branch");
                    String fname =rs.getString("fname"); 
                    String lname =rs.getString("lname"); 
                    String name = fname+" "+lname;
              
               
                
                     String gakuyo_zero_deposit = "insert into property_withdrawal_receipt(cname,pdate,penalty_charge_fee,withdrawal_amount_recieved,withdrawal_amount,receiptno,served_by,branch)"
                        + "values(?,?,?,?,?,?,?,?)";
                     
                    pst = conn.prepareStatement(gakuyo_zero_deposit);
                    
                    pst.setString(1,nme);
                    pst.setString(2, td);
                    pst.setString(3, initial_amount.getText().trim());
                    pst.setString(4, amount_received.getText().trim());
                    pst.setString(5, withdrawal_amount.getText().trim());
                    pst.setString(6, String.valueOf(receipt_no));
                    pst.setString(7,name);
                    pst.setString(8,branch);
                    pst.execute();
                  

                } catch (SQLException ex) {
                    Logger.getLogger(withdrawal_from_land.class.getName()).log(Level.SEVERE, null, ex);
                }
             finally {
    try { rs.close(); } catch (SQLException e) {  }
    try { pst.close(); } catch (SQLException e) { }
    try { conn.close(); System.out.println("Connection closed");} catch (SQLException e) {}
}
        }
    }
    private void print_receiptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_print_receiptActionPerformed
       if(jtp.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "<html><h4><font color='red'>Cannot print empty receipt!</font></h4></html>");
            }
        
            else {
            try {
                   jtp.print();
                  close();
                } catch (PrinterException ex) {
               Logger.getLogger(withdrawal_from_land.class.getName()).log(Level.SEVERE, null, ex);
           }
             
              
        }
    }//GEN-LAST:event_print_receiptActionPerformed

    private void penalty_charge_rateFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_penalty_charge_rateFocusLost
      //calculating interest
                int amnt = Integer.parseInt(pc.getText().trim());
                double rt =  Double.parseDouble(penalty_charge_rate.getText().trim());
                double pcf = amnt*(rt/100);
                penalty_charge_fee.setText(String.valueOf(pcf));
                penalty_charge_fee.setEnabled(false);
                
                //calculating withdrawal
                
                 int wamnt= Integer.parseInt(withdrawal_amount.getText().trim());
                 int amntr = (int) (wamnt+ (-pcf));
                 
                 amount_received.setText(String.valueOf(amntr));
                 amount_received.setEnabled(false);    }//GEN-LAST:event_penalty_charge_rateFocusLost

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
            java.util.logging.Logger.getLogger(withdrawal_from_land.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(withdrawal_from_land.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(withdrawal_from_land.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(withdrawal_from_land.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new withdrawal_from_land().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Search;
    private javax.swing.JTextField amount_received;
    private javax.swing.JTextField cname;
    private javax.swing.JLabel current_date;
    private javax.swing.JTextField id;
    private javax.swing.JButton idsearch;
    private javax.swing.JTextField initial_amount;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
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
    private javax.swing.JTextPane jtp;
    private javax.swing.JTextField pc;
    private javax.swing.JTextField penalty_charge_fee;
    private javax.swing.JTextField penalty_charge_rate;
    private javax.swing.JComboBox<String> pl;
    private javax.swing.JTextField plot_no;
    private javax.swing.JButton print_receipt;
    private javax.swing.JComboBox<String> psize;
    private javax.swing.JPasswordField pwd;
    private javax.swing.JPanel rctpanel;
    private javax.swing.JButton save_withdrawal_amount;
    private javax.swing.JTextField sbplotno;
    private javax.swing.JTextField withdrawal_amount;
    // End of variables declaration//GEN-END:variables
}
