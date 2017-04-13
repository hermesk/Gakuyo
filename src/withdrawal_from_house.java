 

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

public class withdrawal_from_house extends javax.swing.JFrame {

  Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
        private static withdrawal_from_house obj=null;

    
     // autgen receipt no
                int rno =(int) Math.floor((Math.random() * 1000000) + 1)+(int) Math.floor((Math.random() * 100000)+1);
                String receipt_no = "WD" + rno+ "HSE";
                
                DateFormat dF = new SimpleDateFormat("yyyy-MM-dd");
                Date date = new Date();
                String td=dF.format(date);
                
                
    private withdrawal_from_house() {
        initComponents();
    conn = DbConnect.connecrDb();

        setResizable(false);
        ProperyDetails();
        current_date();
        logo();
    }
         public static withdrawal_from_house getObj() {
        if (obj== null){
            obj = new withdrawal_from_house();
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
    private void ProperyDetails() {
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
          public void dreceipt() throws SQLException{
              if(conn==null){
            JOptionPane.showMessageDialog(this, "Could not connect to the server");
        }
     else{        
                try {
                
                 String searchuser = "select[user].branch,[user].fname,[user].lname   "
                            + "from [user] where password=? ";
                    
                   pst=conn.prepareStatement(searchuser);
                   pst.setString(1, md5(pwd.getText().trim()));
                   rs = pst.executeQuery();
                    rs.next();
                    
                    String fname =rs.getString("fname"); 
                    String lname =rs.getString("lname"); 
                    String name = fname+" "+lname;
                    String branch=rs.getString("branch");
                    
                    String ReceiptNo = String.valueOf(receipt_no);
                    String nme= cname.getText();
                     
                    int n = Integer.parseInt(amount_withdrawn.getText().replaceAll(",",""));
                    String Englishword = EnglishNumber(n);
                    String amntw = " " + Englishword+ " "+"Kenya Shillings Only";
                    
                    String postingDate= String.valueOf(td);
                    String penalty=penalty_fee.getText();
                    String Amountrec=amnt_received.getText();
                    String Amountw=String.valueOf(amntw);
                    String sg = "..............";
                    String servedby=" ";
                    String ttl="\t\t\tGAKUYO HOUSE REFUND ";
                  
                    
                    jtp.setPage(getClass().getResource("logo.html"));
                    jtp.getStyledDocument().insertString(1, ttl+"\nBranch Name\t\t\t"+branch+"\nClient Name\t\t\t\t"+nme+"\nRefNo\t\t\t\t"+ReceiptNo+"\nDate Of withdrawal\t\t\t"+postingDate+
                      "\nWithdrawal Amount Recieved\t\t"+Amountrec+"\nPenalty Fee\t\t\t\t"+penalty+"\nAmount withdrawn:\t\t\t"+n+"\nAmount in Words:"+Amountw+""
                       + "Client Signature:\t "+sg+"Served by  "+servedby+""+name+"\n\n\t\t\t Where Trust Meets Your Vision",null);
             
                } catch (IOException | BadLocationException ex) {
                    Logger.getLogger(withdrawal_from_house.class.getName()).log(Level.SEVERE, null, ex);
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
     private void display() {
         if(conn==null){
            JOptionPane.showMessageDialog(this, "Could not connect to the server");
        }
         else{
         try {
            String searchclient = "select sum(house.amount),client_detail.name,house.cost,house.house_size,house.plotno from house,client_detail where house.id=? and"
                    + " location='"+pl.getSelectedItem()+"' and house.id=client_detail.id GROUP BY client_detail.name,house.cost,house.house_size,house.plotno,house.location";

            pst = conn.prepareStatement(searchclient);
            pst.setString(1, id.getText());
            rs = pst.executeQuery();

            if (rs.next()) {
                String amntpd = rs.getString(1);
                cname.setText(rs.getString("name"));
                initial_amount.setText(amntpd);
                initial_amount.setEnabled(false);
                pc.setText(rs.getString("cost"));
                pc.setEnabled(false);
                psize.setSelectedItem(rs.getString("house_size"));
                psize.setEnabled(false);
                house_no.setText(rs.getString("plotno"));
                house_no.setEnabled(true);
              
            } else {
                JOptionPane.showMessageDialog(null, "No HOUSE PURCHASE Found For Client ID" + " " + id.getText());

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
        id = new javax.swing.JTextField();
        getdetails = new javax.swing.JButton();
        current_date = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        pl = new javax.swing.JComboBox<>();
        pc = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        house_no = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        initial_amount = new javax.swing.JTextField();
        psize = new javax.swing.JComboBox<>();
        penalty_rate = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        penalty_fee = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        save = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        pwd = new javax.swing.JPasswordField();
        cname = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        amount_withdrawn = new javax.swing.JFormattedTextField();
        amnt_received = new javax.swing.JFormattedTextField();
        rctpanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtp = new javax.swing.JTextPane();
        print_receipt = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("House Refund");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "HOUSE REFUND", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        id.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                idKeyTyped(evt);
            }
        });

        getdetails.setText("GET DETAILS");
        getdetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getdetailsActionPerformed(evt);
            }
        });

        current_date.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        current_date.setText("DATE");

        jLabel3.setText(" LOCATION");

        pc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pcKeyTyped(evt);
            }
        });

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("HOUSE NO");

        house_no.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                house_noKeyTyped(evt);
            }
        });

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("PROPERTY SIZE");

        initial_amount.setEditable(false);
        initial_amount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                initial_amountKeyTyped(evt);
            }
        });

        penalty_rate.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        penalty_rate.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                penalty_rateFocusLost(evt);
            }
        });
        penalty_rate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                penalty_rateKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                penalty_rateKeyTyped(evt);
            }
        });

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("PENALTY RATE %");

        penalty_fee.setEditable(false);
        penalty_fee.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel12.setText("AMOUNT RECIEVED");

        save.setText("SAVE");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("INPUT PASSWORD");

        cname.setEditable(false);
        cname.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cname.setText("CLIENT NAME");

        jLabel8.setText("ID");

        jLabel1.setText("WITHDRAWAL AMOUNT");

        jLabel13.setText("TOTAL AMOUNT");

        jLabel14.setText("COST OF PROPERTY");

        jLabel15.setText("PENALTY FEE");

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/gakuyo.png"))); // NOI18N

        amount_withdrawn.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(158, 158, 158)
                        .addComponent(current_date, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 28, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(penalty_rate, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(psize, javax.swing.GroupLayout.Alignment.LEADING, 0, 137, Short.MAX_VALUE)
                                    .addComponent(amnt_received))
                                .addGap(10, 10, 10)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel15)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel1))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(pc, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(jLabel13)))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(initial_amount, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                            .addComponent(penalty_fee, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                            .addComponent(house_no, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                            .addComponent(amount_withdrawn)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pl, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(getdetails, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cname, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(save)
                            .addComponent(pwd, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 222, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(current_date)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(getdetails)
                    .addComponent(jLabel8)
                    .addComponent(jLabel3)
                    .addComponent(pl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(cname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(pc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(psize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(penalty_rate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel15))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel12)
                                .addComponent(amnt_received, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel5)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(initial_amount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(amount_withdrawn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(penalty_fee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(house_no, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(pwd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(save)
                .addGap(45, 45, 45))
        );

        jScrollPane1.setViewportView(jtp);

        javax.swing.GroupLayout rctpanelLayout = new javax.swing.GroupLayout(rctpanel);
        rctpanel.setLayout(rctpanelLayout);
        rctpanelLayout.setHorizontalGroup(
            rctpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rctpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 527, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        rctpanelLayout.setVerticalGroup(
            rctpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rctpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE)
                .addContainerGap())
        );

        print_receipt.setText("PRINT");
        print_receipt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                print_receiptActionPerformed(evt);
            }
        });

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
                        .addComponent(rctpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(267, 267, 267)
                        .addComponent(print_receipt)))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rctpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(print_receipt)))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void getdetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getdetailsActionPerformed
          if (id.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Enter ID number");
        }
            else if(conn==null){
            JOptionPane.showMessageDialog(this, "Could not connect to the server");
        }
            
     else {
                 display();
            }
    
    }//GEN-LAST:event_getdetailsActionPerformed

    private void penalty_rateKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_penalty_rateKeyReleased
      
               
    }//GEN-LAST:event_penalty_rateKeyReleased

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed

        if (id.getText().isEmpty() || amount_withdrawn.getText().isEmpty()||pc.getText().isEmpty()||initial_amount.getText().isEmpty()||penalty_rate.getText().isEmpty()
               ||penalty_fee.getText().isEmpty()||amnt_received.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "<html><h2><font color='red'>Kindly Fill all the required fields Correctly!</font></h2></html>");}
        
          
           else if(pwd.getText().isEmpty()){
               JOptionPane.showMessageDialog(null,"Kindly Input Your Password ");
                  } 
             else if(conn==null){
            JOptionPane.showMessageDialog(this, "Could not connect to the server");
        }
              else if(!jtp.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "<html><h4><font color='red'>print current receipt first!</font></h4></html>");
            }
        
         else {
               int a = Integer.parseInt(initial_amount.getText().replaceAll(",",""));
          int b = Integer.parseInt(amount_withdrawn.getText().replaceAll(",",""));
          if (b>a){
          JOptionPane.showMessageDialog(null,"Amount being withdrawn cannot exceed total amount deposited");
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
           String searchuser = "select username from [user] where password=? ";
            pst=conn.prepareStatement(searchuser);
            pst.setString(1, md5(pwd.getText().trim()));
            rs = pst.executeQuery();
            if(rs.next()){
              
                try {
                  
                   String srchuser = "select [user].fname,[user].lname from [user] where [user].password=? ";
                   pst=conn.prepareStatement(srchuser);
                   pst.setString(1, md5(pwd.getText().trim()));
                   rs = pst.executeQuery();
                   rs.next();
                   
                   String fname =rs.getString("fname"); 
                   String lname =rs.getString("lname"); 
                   String uname = fname+" "+lname;
                    
                   String ptp ="house";
                     int wamnt= Integer.parseInt(amount_withdrawn.getText().trim().replaceAll(",",""));
                
        
                String propertywithdrawals = "insert into property_withdrawals(id,amount_withdrawn,pdate,receipt_no,property_location,plot_no,"
                        + "property_size,property_cost,amount_payed,penalty_rate,penalty_fee,amount_received,ptype,servedby)"
                        + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                
                 pst = conn.prepareStatement(propertywithdrawals);

                pst.setString(1, id.getText().trim());
                
                
                pst.setString(2, amount_withdrawn.getText().trim().replaceAll(",",""));
                pst.setString(3, td);
                pst.setString(4, receipt_no);
                
                pst.setString(5, pl.getSelectedItem().toString());
                pst.setString(6, house_no.getText().trim());
                 pst.setString(7, psize.getSelectedItem().toString());
                pst.setString(8, pc.getText().trim());
                pst.setString(9, initial_amount.getText().trim());
                pst.setString(10, penalty_rate.getText().trim());
                pst.setString(11, penalty_fee.getText().trim());
                pst.setString(12, String.valueOf(wamnt));
                pst.setString(13, ptp);
                pst.setString(14, uname);
                pst.execute();
                
                  //subracting from the database
                int wamnt1= -(wamnt);
                
                 //current bal
                            int amnt = Integer.parseInt(amount_withdrawn.getText().trim().replaceAll(",",""));
                            int tcost = Integer.parseInt(pc.getText().trim());
                            int pdamnt = Integer.parseInt(initial_amount.getText().trim().replaceAll(",",""));
                            
                            int currentbal = tcost -(amnt+pdamnt);

                           
                 String w = "withdrawals from"+" "+pl.getSelectedItem().toString();
                 
                 String house = "insert into house(id,house_size,location,cost,amount,posting_date,refno,receiptno,payment_mode,plotno,balance)"
                            + "values(?,?,?,?,?,?,?,?,?,?,?)";
                 
                 pst = conn.prepareStatement(house);
                    pst.setString(1, id.getText().trim());
                    pst.setString(2, psize.getSelectedItem().toString());
                    pst.setString(3, pl.getSelectedItem().toString());
                    pst.setString(4, pc.getText().trim());
                    pst.setString(5, String.valueOf(wamnt1));
                    pst.setString(6, td);
                    pst.setString(7, String.valueOf(receipt_no));
                    pst.setString(8, String.valueOf(receipt_no));
                    pst.setString(9, w);
                    pst.setString(10, house_no.getText().trim());
                    pst.setString(11, String.valueOf(currentbal).replaceAll(",",""));
                    pst.execute();
                     dreceipt();
                     saverct();
                    JOptionPane.showMessageDialog(null, "Withdrawal Recorded");
                   } catch (SQLException ex) {
                Logger.getLogger(withdrawal_from_house.class.getName()).log(Level.SEVERE, null, ex);
            }
        
                  }
            }catch (SQLException ex) {
                    Logger.getLogger(withdrawal_from_house.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            }
        }       catch (SQLException ex) {
                    Logger.getLogger(withdrawal_from_house.class.getName()).log(Level.SEVERE, null, ex);
                }
                                       
        }
        }
    }//GEN-LAST:event_saveActionPerformed

    public void saverct(){
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
                
                     String hsw = "insert into property_withdrawal_receipt(cname,pdate,penalty_charge_fee,withdrawal_amount_recieved,withdrawal_amount,receiptno,served_by,branch)"
                        + "values(?,?,?,?,?,?,?,?)";
                     
                    pst = conn.prepareStatement(hsw);
                    pst.setString(1,nme);
                    pst.setString(2, td);
                    pst.setString(3, initial_amount.getText().trim().replaceAll(",",""));
                    pst.setString(4, amnt_received.getText().trim().replaceAll(",",""));
                    pst.setString(5, amount_withdrawn.getText().trim().replaceAll(",",""));
                    pst.setString(6, String.valueOf(receipt_no));
                    pst.setString(7,name);
                    pst.setString(8,branch);
                    pst.execute();
              
                } catch (SQLException ex) {
                    Logger.getLogger(withdrawal_from_house.class.getName()).log(Level.SEVERE, null, ex);
                }
                                        
             
    }
    }
    private void idKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_idKeyTyped
       char c=evt.getKeyChar();
        if(!(Character.isAlphabetic(c) ||  (c==KeyEvent.VK_BACK_SPACE)||  c==KeyEvent.VK_DELETE ||Character.isDigit(c))){
        evt.consume();
        getToolkit().beep();}
    }//GEN-LAST:event_idKeyTyped

    private void penalty_rateKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_penalty_rateKeyTyped
         char c = evt.getKeyChar();
        if (!(Character.isDigit(c)
                || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE || evt.getKeyChar() == '.')) {
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_penalty_rateKeyTyped

    private void house_noKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_house_noKeyTyped
      char c=evt.getKeyChar();
        if(!(Character.isAlphabetic(c) ||  (c==KeyEvent.VK_BACK_SPACE)||  c==KeyEvent.VK_DELETE ||Character.isDigit(c))){
        evt.consume();
        getToolkit().beep();}
    }//GEN-LAST:event_house_noKeyTyped

    private void initial_amountKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_initial_amountKeyTyped
         char c=evt.getKeyChar();
        if(!((c==KeyEvent.VK_BACK_SPACE)||  c==KeyEvent.VK_DELETE ||Character.isDigit(c))){
        evt.consume();
        getToolkit().beep();}
    }//GEN-LAST:event_initial_amountKeyTyped

    private void pcKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pcKeyTyped
        char c=evt.getKeyChar();
        if(!((c==KeyEvent.VK_BACK_SPACE)||  c==KeyEvent.VK_DELETE ||Character.isDigit(c))){
        evt.consume();
        getToolkit().beep();}
    }//GEN-LAST:event_pcKeyTyped

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

    private void penalty_rateFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_penalty_rateFocusLost
               
                //calculating interest
                int amnt = Integer.parseInt(pc.getText().trim());
                double rt =  Double.parseDouble(penalty_rate.getText().trim());
                double pcf = amnt*(rt/100);
                penalty_fee.setText(String.valueOf(pcf));
                penalty_fee.setEnabled(false);
                
                //calculating withdrawal
                 
                 int  wamnt= Integer.parseInt(amount_withdrawn.getText().trim().replaceAll(",",""));
                 
                 int amntr = (int)(wamnt+ (-pcf));
                 
                 
                 amnt_received.setText(String.valueOf(amntr).replaceAll(",",""));
                 amnt_received.setEnabled(false);
    }//GEN-LAST:event_penalty_rateFocusLost

    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(() -> {
            new withdrawal_from_house().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField amnt_received;
    private javax.swing.JFormattedTextField amount_withdrawn;
    private javax.swing.JTextField cname;
    private javax.swing.JLabel current_date;
    private javax.swing.JButton getdetails;
    private javax.swing.JTextField house_no;
    private javax.swing.JTextField id;
    private javax.swing.JTextField initial_amount;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jtp;
    private javax.swing.JTextField pc;
    private javax.swing.JTextField penalty_fee;
    private javax.swing.JTextField penalty_rate;
    private javax.swing.JComboBox<String> pl;
    private javax.swing.JButton print_receipt;
    private javax.swing.JComboBox<String> psize;
    private javax.swing.JPasswordField pwd;
    private javax.swing.JPanel rctpanel;
    private javax.swing.JButton save;
    // End of variables declaration//GEN-END:variables
}
