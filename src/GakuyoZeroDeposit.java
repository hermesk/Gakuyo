
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
import javax.swing.JTextField;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;


public class GakuyoZeroDeposit extends javax.swing.JFrame  {
    
     public static Connection conn = null;
    public static PreparedStatement pst = null;
    public static ResultSet rs = null;
    
    private static GakuyoZeroDeposit obj=null;
       //current date
       DateFormat dF = new SimpleDateFormat("yyyy-MM-dd");
       Date date = new Date();
        String td=dF.format(date);        
            
                
    GakuyoZeroDeposit() {
        initComponents();
         conn = DbConnect.connecrDb();
          ComboPmode();
           current_date();
           ProperyDetails();
           logo();
    
    }
      public static GakuyoZeroDeposit getObj() {
        if (obj== null){
            obj = new GakuyoZeroDeposit();
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
    
    private void logo(){
    setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("images/LOG.png")));
    }
         private void ProperyDetails(){
       
    if(conn==null){
            JOptionPane.showMessageDialog(this, "Could not connect to the server");
        }  
    else{
          try{
         String sql = "select ptype from property_location WHERE ptype IS NOT NULL";
         pst = conn.prepareStatement(sql);
         rs =pst.executeQuery();
         while(rs.next()){
          
          String ptp = rs.getString("ptype");
                deposit.addItem(ptp);
                  }
       }
          
     catch(SQLException e)
     {
                 JOptionPane.showMessageDialog(null, e);
    }
 
    }
          }
    
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
          String paymode = rs.getString("mode");         
          payment_mode.addItem(paymode);
          String dbt = rs.getString("debit");         
          account_debit.addItem(dbt);
                  }
       }
     catch(SQLException e)
     {
                 JOptionPane.showMessageDialog(null, e);
    }
     
       }
          }
    private void display() {
        if(conn==null){
            JOptionPane.showMessageDialog(this, "Could not connect to the server");
        }
       else{
        try {
            String searchclient = "select [gakuyo_zero_deposit].type_of_house,[client_detail].name from [gakuyo_zero_deposit],[client_detail] where [gakuyo_zero_deposit].id=? and [client_detail].id=?";

            pst = conn.prepareStatement(searchclient);
            pst.setString(1, id.getText());
            pst.setString(2, id.getText());
            rs = pst.executeQuery();

            if (rs.next()) {
                type_of_house.setSelectedItem(rs.getString("type_of_house"));
                cname.setText(rs.getString("name"));
                type_of_house.setEnabled(false);
                cname.setEnabled(false);
               
            } else {
                JOptionPane.showMessageDialog(null, "No Gakuyo Zero Deposit Found For Client ID" + " " + id.getText());
                
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

        jLabel12 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        current_date = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        RefNo = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cname = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        GakuyoZeroDeposit = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        account_debit = new javax.swing.JComboBox<>();
        get_client_details = new javax.swing.JButton();
        id = new javax.swing.JTextField();
        type_of_house = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        deposit = new javax.swing.JComboBox<>();
        pwd = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        payment_mode = new javax.swing.JComboBox<>();
        transaction_date = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        Amntfig = new javax.swing.JFormattedTextField();
        rctpanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtp = new javax.swing.JTextPane();
        print_receipt = new javax.swing.JButton();

        jLabel12.setText("jLabel12");

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
        setTitle("GAKUYO ZERO DEPOSIT");
        setBackground(new java.awt.Color(255, 102, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFont(new java.awt.Font("Adobe Arabic", 0, 14)); // NOI18N
        setIconImages(null);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "GAKUYO ZERO DEPOSIT", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/gakuyo.png"))); // NOI18N

        current_date.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        current_date.setText("date");

        RefNo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                RefNoFocusGained(evt);
            }
        });
        RefNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefNoActionPerformed(evt);
            }
        });
        RefNo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                RefNoKeyTyped(evt);
            }
        });

        jLabel13.setText("REFERENCE NO:");

        jLabel8.setText("TRANSACTION DATE");

        jLabel1.setText("ID/PASSPORT NO:");

        cname.setEditable(false);
        cname.setText("CLIENT NAME");

        jLabel10.setText("Password");

        GakuyoZeroDeposit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Save-icon.png"))); // NOI18N
        GakuyoZeroDeposit.setText("Save");
        GakuyoZeroDeposit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GakuyoZeroDepositActionPerformed(evt);
            }
        });

        jLabel6.setText("AMOUNT");

        jLabel7.setText("A/C DEBIT");

        account_debit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                account_debitActionPerformed(evt);
            }
        });

        get_client_details.setText("Get Client Details");
        get_client_details.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                get_client_detailsActionPerformed(evt);
            }
        });

        id.setText(null);
        id.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                idFocusGained(evt);
            }
        });
        id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idActionPerformed(evt);
            }
        });
        id.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                idKeyTyped(evt);
            }
        });

        type_of_house.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2 Bedroom", "3 Bedroom", "Land" }));
        type_of_house.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                type_of_houseActionPerformed(evt);
            }
        });

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("PAYMENT MODE");

        deposit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                depositActionPerformed(evt);
            }
        });

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("CHOOSE");

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

        transaction_date.setDateFormatString("yyyy-MM-dd");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("CHOOSE");

        Amntfig.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(270, 270, 270)
                        .addComponent(get_client_details))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(207, 207, 207)
                                .addComponent(jLabel5))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(266, 266, 266)
                                .addComponent(jLabel4)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Amntfig)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(deposit, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(payment_mode, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 9, Short.MAX_VALUE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel1))
                            .addComponent(jLabel7)
                            .addComponent(jLabel13)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)
                                .addComponent(pwd, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(account_debit, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabel6))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(GakuyoZeroDeposit)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(RefNo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(type_of_house, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(transaction_date, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cname, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {RefNo, account_debit, id, pwd});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(get_client_details))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(transaction_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(deposit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(type_of_house, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(payment_mode))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(account_debit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(jLabel6)
                        .addComponent(Amntfig, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RefNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(cname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(pwd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(GakuyoZeroDeposit)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(current_date, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(current_date)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jtp.setEditable(false);
        jtp.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jtp.setMaximumSize(new java.awt.Dimension(100, 2147483647));
        jScrollPane1.setViewportView(jtp);

        javax.swing.GroupLayout rctpanelLayout = new javax.swing.GroupLayout(rctpanel);
        rctpanel.setLayout(rctpanelLayout);
        rctpanelLayout.setHorizontalGroup(
            rctpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rctpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 511, Short.MAX_VALUE)
                .addContainerGap())
        );
        rctpanelLayout.setVerticalGroup(
            rctpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rctpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
                .addContainerGap())
        );

        print_receipt.setText("Print");
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
                        .addGap(239, 239, 239)
                        .addComponent(print_receipt, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(rctpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(1152, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(rctpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(print_receipt)
                .addContainerGap(48, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(1168, 494));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void type_of_houseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_type_of_houseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_type_of_houseActionPerformed

    private void RefNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RefNoActionPerformed

    private void RefNoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_RefNoFocusGained
        // TODO add your handling code here:
       
    }//GEN-LAST:event_RefNoFocusGained

    private void idFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_idFocusGained
        // TODO add your handling code here:
        
    }//GEN-LAST:event_idFocusGained

    private void GakuyoZeroDepositActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GakuyoZeroDepositActionPerformed
     if(!jtp.getText().isEmpty())
           {
        JOptionPane.showMessageDialog(null,"Print current receipt");
        }
       
        if(id.getText().isEmpty()||((JTextField)transaction_date.getDateEditor().getUiComponent()).getText().isEmpty()||Amntfig.getText().isEmpty()||RefNo.getText().isEmpty() )

        {    JOptionPane.showMessageDialog(null, "<html><h4><font color='red'>Kindly Fill all the fields Correctly!</font></h4></html>");
        }
         else if(pwd.getText().isEmpty()){
               JOptionPane.showMessageDialog(null,"Kindly Input Your Password ");
                  } 
        else{
        if(conn==null){
            JOptionPane.showMessageDialog(null, "Could not connect to the server");
        }
        
             else if (!pwd.getText().isEmpty()){
         
          try{
            
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
                     
                    String nme=rs.getString("name");//client
                    String branch=rs.getString("branch");
                    String fname =rs.getString("fname"); 
                    String lname =rs.getString("lname"); 
                    String uname = fname+" "+lname;
           
              
           //check for reference number
            String searchrefno = "SELECT COUNT(*) AS total FROM [gakuyo_zero_deposit] where ref_no =?";
            pst=conn.prepareStatement(searchrefno);
            pst.setString(1,  RefNo.getText().trim());
            rs = pst.executeQuery();
            
            
            while(rs.next())
            {
             if(rs.getInt("total")<1){
                 
        //check receipt no
         String checkrn ="SELECT TOP 1 rno FROM receipt ORDER BY rno DESC";
         pst = conn.prepareStatement(checkrn);
         rs =pst.executeQuery();
       
         while(rs.next()){
          int b = Integer.parseInt(rs.getString(1));
          int n =(b+1);
         
           String receiptno = "GZD"+n;       
                       
                String gakuyo_zero_deposit = "insert into [gakuyo_zero_deposit](posting_date,id,transaction_date,type_of_house,ptype,"
                        + "payment_mode,account_debit,amount,ref_no,receipt_no,servedby)"
                + "values(?,?,?,?,?,?,?,?,?,?,?)";
             
                    pst = conn.prepareStatement(gakuyo_zero_deposit);
                    pst.setString(1, td);
                    pst.setString(2, id.getText().trim());
                    pst.setString(3, ((JTextField)transaction_date.getDateEditor().getUiComponent()).getText().trim());
                    pst.setString(4, type_of_house.getSelectedItem().toString());
                    pst.setString(5, deposit.getSelectedItem().toString());
                    pst.setString(6, payment_mode.getSelectedItem().toString());
                    pst.setString(7, account_debit.getSelectedItem().toString());
                    pst.setString(8, Amntfig.getText().replaceAll(",",""));
                    pst.setString(9, RefNo.getText().trim());
                    pst.setString(10, String.valueOf(receiptno));
                    pst.setString(11, uname);
                    pst.execute();
                     
                     //display receipt
                
                    
                    int nm = Integer.parseInt( Amntfig.getText().replaceAll(",",""));
                    String Englishword = EnglishNumber(nm);
                    String amntw = " " + Englishword+ " "+"Kenya Shillings Only";
                   
                    String transactionDate=((JTextField)transaction_date.getDateEditor().getUiComponent()).getText();
                    String Type_Of_House= type_of_house.getSelectedItem().toString();
                    String Deposit_Type= deposit.getSelectedItem().toString();
                    String Payment_mode=payment_mode.getSelectedItem().toString();
                    String Amount=Amntfig.getText();
                    String Amountw=String.valueOf(amntw);
                    String sg = "..............";
                    String Deposited="..............";
                    String servedby=" ";
                    String ttl="\t\tGAKUYO ZERO DEPOSIT ";
                     
                    StyledDocument doc = (StyledDocument) jtp.getDocument();
                    Style style = doc.addStyle("Tahoma", null);
                    StyleConstants.setFontSize(style, 11);
                    jtp.setPage(getClass().getResource("logo.html"));
                    jtp.getStyledDocument().insertString(1, ttl+"\nBranch"+" "+branch+" . "+ " "+"Date Of Posting"+" "+td+  ""
                            + " . "+ " "+"Transaction Date"+"  "+transactionDate+" ."+" "+"\nClient Name\t\t\t\t"+nme+
                            "\nReceiptNo\t\t\t\t"+receiptno+"\nType Of House\t\t\t"
                            +Type_Of_House+"\nType Of Deposit\t\t\t"+Deposit_Type+"\nMode Of Payment\t\t\t"+Payment_mode+
                            "\nAmount\t\t\t\t"+Amount+"\nAmount in Words:"+Amountw+"\nDepositedBy:"+Deposited+""
                  + "Client Signature:"+sg+"Served by"+servedby+""+uname+"\n\t\t Where Trust Meets Your Vision",style);
               
                    
              //save receipt//
               String gzdreceipt = "insert into receipt(cname,pdate,tdate,ptype,pmode,amount,receiptno,servedby,branch,client_id,rno)"
                        + "values(?,?,?,?,?,?,?,?,?,?,?)";
                     
                    pst = conn.prepareStatement(gzdreceipt);
                    
                    pst.setString(1,nme);
                    pst.setString(2, td);
                    pst.setString(3, ((JTextField)transaction_date.getDateEditor().getUiComponent()).getText().trim());
                    pst.setString(4, deposit.getSelectedItem().toString());
                    pst.setString(5, payment_mode.getSelectedItem().toString());
                    pst.setString(6, Amntfig.getText().replaceAll(",",""));
                    pst.setString(7, String.valueOf(receiptno));
                    pst.setString(8,uname);
                    pst.setString(9,branch);
                    pst.setString(10,id.getText().trim());
                    pst.setString(11,String.valueOf(n)); //increment receipt numbers
                    pst.execute();
                 
               JOptionPane.showMessageDialog(null, "Saved" );

         }
            
            } 
             else {
                 JOptionPane.showMessageDialog(null, "<html><h2><font color='red'>The reference number already exist!</font></h2></html>");
             }
                 }
              } 
      else{
             JOptionPane.showMessageDialog(null, "Incorrect  password");}    
        
    
             }
             else {
             JOptionPane.showMessageDialog(null, "<html><h4><font color='red'>Client with ID " +id.getText().trim()+ " does not exist! Please register the client</font></h4></html>");
             }
        }
        //
   }              catch (SQLException ex) {
                      Logger.getLogger(GakuyoZeroDeposit.class.getName()).log(Level.SEVERE, null, ex);
                  } catch (IOException ex) {
                      Logger.getLogger(GakuyoZeroDeposit.class.getName()).log(Level.SEVERE, null, ex);
                  } catch (BadLocationException ex) {
                      Logger.getLogger(GakuyoZeroDeposit.class.getName()).log(Level.SEVERE, null, ex);
                  }
    
              
              } }  
        
    }//GEN-LAST:event_GakuyoZeroDepositActionPerformed
 
    
    private void idKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_idKeyTyped
    char c=evt.getKeyChar();
        if(!(Character.isAlphabetic(c) ||  (c==KeyEvent.VK_BACK_SPACE)||  c==KeyEvent.VK_DELETE ||Character.isDigit(c))){
        evt.consume();
        getToolkit().beep();}
    }//GEN-LAST:event_idKeyTyped

    private void RefNoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RefNoKeyTyped
     char c=evt.getKeyChar();
        if(!(Character.isAlphabetic(c) ||  (c==KeyEvent.VK_BACK_SPACE)||  c==KeyEvent.VK_DELETE ||Character.isDigit(c))){
        evt.consume();
        getToolkit().beep();}
    }//GEN-LAST:event_RefNoKeyTyped

    private void account_debitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_account_debitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_account_debitActionPerformed

    private void depositActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_depositActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_depositActionPerformed

    private void payment_modeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payment_modeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_payment_modeActionPerformed

    private void idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idActionPerformed

    private void print_receiptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_print_receiptActionPerformed
         
            if(jtp.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "<html><h4><font color='red'>Cannot print empty receipt!</font></h4></html>");
            }
            else {
         try {
                    jtp.print();
                   
            close();
             GakuyoZeroDeposit gzd = new GakuyoZeroDeposit();gzd.setVisible(true);
                } catch (PrinterException ex) {
                    Logger.getLogger(GakuyoZeroDeposit.class.getName()).log(Level.SEVERE, null, ex);
                }
}           
           
    }//GEN-LAST:event_print_receiptActionPerformed

    private void get_client_detailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_get_client_detailsActionPerformed
        if (id.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Enter ID number");
        } 
        if(id.getText().length()!=8){
            JOptionPane.showMessageDialog(null, "ID must be 8 digits");
            }else {
            display();
        }
    }//GEN-LAST:event_get_client_detailsActionPerformed

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
           RefNo.setText(String.valueOf(n));
           RefNo.setEnabled(false);

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
   
    
    private void cmd_saveActionPerformed(java.awt.event.ActionEvent evt) {                                         
        
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
            java.util.logging.Logger.getLogger(GakuyoZeroDeposit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GakuyoZeroDeposit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GakuyoZeroDeposit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GakuyoZeroDeposit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new GakuyoZeroDeposit().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField Amntfig;
    private javax.swing.JButton GakuyoZeroDeposit;
    private javax.swing.JTextField RefNo;
    private javax.swing.JComboBox<String> account_debit;
    public static javax.swing.JTextField cname;
    private javax.swing.JLabel current_date;
    private javax.swing.JComboBox<String> deposit;
    private javax.swing.JButton get_client_details;
    public static javax.swing.JTextField id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jtp;
    private javax.swing.JComboBox<String> payment_mode;
    private javax.swing.JButton print_receipt;
    private javax.swing.JPasswordField pwd;
    private javax.swing.JPanel rctpanel;
    private com.toedter.calendar.JDateChooser transaction_date;
    private javax.swing.JComboBox<String> type_of_house;
    // End of variables declaration//GEN-END:variables
}
