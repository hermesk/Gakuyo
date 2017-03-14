
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


public class house extends javax.swing.JFrame {
    
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
  private static house obj=null;

    Connection conn1 = null;
    PreparedStatement pst1 = null;
    ResultSet rs1 = null;
    
           //current date
       DateFormat dF = new SimpleDateFormat("yyyy-MM-dd");
       Date date = new Date();
       String td=dF.format(date);
       
            //autogen receipt
            int rno =(int) Math.floor((Math.random() * 1000000) + 1)+(int) Math.floor((Math.random() * 100000)+1);
            String reciept_no = "GREH"+rno;
    
   
            
            
   house() {
       initComponents();
         conn = DbConnect.connecrDb();
         ComboPmode();
         ProperyDetails();
        
         Current_Date();
         setResizable(false);
         logo();
    }
   
     public static house getObj() {
        if (obj== null){
            obj = new house();
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
   public final void Current_Date(){
        
        current_date.setText(td);
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
          pmode.addItem(paymode);
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
 
      private void ProperyDetails(){
       
    if(conn==null){
            JOptionPane.showMessageDialog(this, "Could not connect to the server");
        }  
    else{
          try{
         String sql = "select *from property_location ";
         pst = conn.prepareStatement(sql);
         rs =pst.executeQuery();
         while(rs.next()){
          String lctn = rs.getString("location");         
          location.addItem(lctn);
          location1.addItem(lctn);
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
          }
        public void plotnos(){
      
     if(conn==null){
            JOptionPane.showMessageDialog(this, "Could not connect to the server");
        }
         else{
         
             try { 
                  String ptl = (String) location.getSelectedItem();

                  String pt = "select DISTINCT ["+ptl+"] from plotnos where ["+ptl+"] IS NOT NULL ";
                  pst = conn.prepareStatement(pt);
                  rs = pst.executeQuery();
                  while (rs.next()){ 
                     String plotn = rs.getString(ptl);
                      plotno.addItem(plotn);
                  }
             }
               catch (SQLException ex) {
                 Logger.getLogger(land.class.getName()).log(Level.SEVERE, null, ex);
             }  
  
             }
    }
        public void updateplotno(){
       
      if(conn==null){
            JOptionPane.showMessageDialog(this, "Could not connect to the server");
        }
      else{
          
          if( plotno.getSelectedItem()!="NO"){
              
          
            try { 
                  String ptl = (String) location.getSelectedItem();//column name
                  String ptn =(String) plotno.getSelectedItem();//data
                  String v ="null";
                  
                  String pt = "update plotnos  set "+ptl+"="+v+"  where "+ptl+"="+ptn+"";
                  pst = conn.prepareStatement(pt);
                  pst.execute();
                  
                 
                 
             }
               catch (SQLException ex) {
                 Logger.getLogger(land.class.getName()).log(Level.SEVERE, null, ex);
             }
  
          }
      
      }
      
      }
      
    private void display() {
   
     if(conn==null){
            JOptionPane.showMessageDialog(this, "Could not connect to the server");
        }  
        else{
        try {
            String searchclient = "select * from house where house.id=? ";

            pst = conn.prepareStatement(searchclient);
            pst.setString(1, id.getText());
            rs = pst.executeQuery();

            if (rs.next()) {
                  String d =rs.getString("discount");
                location.setSelectedItem(rs.getString("location"));
                cost.setText(rs.getString("cost"));
                 plotno.removeAllItems();
                plotno.addItem(rs.getString("plotno"));
                size.setSelectedItem(rs.getString("house_size"));
                location.setEnabled(true);
                cost.setEnabled(false);
                plotno.setEnabled(true);
                size.setEnabled(false);
                
               if("0".equals(d)){
                disc.setSelectedItem("NO");
                discount.setText(d);
                disc.setEnabled(false);
                discount.setEnabled(false);
                }
                else{
                disc.setSelectedItem("YES");
                discount.setText(d);
                disc.setEnabled(false);
                discount.setEnabled(false);
                }
               
            } else {
                JOptionPane.showMessageDialog(null, "No house Payments Found For Client ID" + " " + id.getText());
                
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
 
                }
    }
    private void displayptno() {
    
       if(conn==null){
            JOptionPane.showMessageDialog(this, "Could not connect to the server");
        }
       else{
        try {
            String searchld = "select client_detail.name,house.location,house.cost,house.plotno,house.house_size from client_detail,house "
                    + "where house.id=client_detail.id and house.plotno=? and house.location='"+location1.getSelectedItem()+"' ";

            pst = conn.prepareStatement(searchld );
            pst.setString(1, hsno.getText());
            rs = pst.executeQuery();

            if (rs.next()) {
                plotno.removeAllItems();
                plotno.addItem(hsno.getText().toString());
                location.setSelectedItem(rs.getString("location"));
                cost.setText(rs.getString("cost"));
               
                size.setSelectedItem(rs.getString("house_size"));
                location.setEnabled(true);
                cost.setEnabled(false);
                plotno.setEnabled(true);
                size.setEnabled(false);
                cname.setText(rs.getString("name"));
                cname.setEnabled(false);
            } else {
                JOptionPane.showMessageDialog(null, "No Land house Found For plot no" + " " + hsno.getText());
                
            }

        } catch (SQLException e) {
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

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        refno = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        pmode = new javax.swing.JComboBox<>();
        save = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        TRANSACTIONDATE = new javax.swing.JLabel();
        ptype = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        account_debit = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        size = new javax.swing.JComboBox<>();
        id = new javax.swing.JTextField();
        location = new javax.swing.JComboBox<>();
        getdetails = new javax.swing.JButton();
        transaction_date = new com.toedter.calendar.JDateChooser();
        current_date = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        pwd = new javax.swing.JPasswordField();
        cname = new javax.swing.JTextField();
        cost = new javax.swing.JFormattedTextField();
        jLabel13 = new javax.swing.JLabel();
        disc = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        discount = new javax.swing.JFormattedTextField();
        plotno = new javax.swing.JComboBox<>();
        amount = new javax.swing.JFormattedTextField();
        jLabel15 = new javax.swing.JLabel();
        hsno = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        location1 = new javax.swing.JComboBox<>();
        sbyhnp = new javax.swing.JButton();
        print = new javax.swing.JButton();
        rctpanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtp = new javax.swing.JTextPane();

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
        setTitle("HOUSE PAYMENT SECTION");
        setFont(new java.awt.Font("Tahoma", 0, 5)); // NOI18N

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/gakuyo.png"))); // NOI18N

        refno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                refnoKeyTyped(evt);
            }
        });

        jLabel9.setText("REF NO");

        jLabel5.setText("HOUSE NO");

        jLabel8.setText("AMOUNT");

        jLabel3.setText("LOCATION");

        jLabel2.setText("ID/Passport");

        pmode.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                pmodeFocusLost(evt);
            }
        });

        save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Save-icon.png"))); // NOI18N
        save.setText("SAVE");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        jLabel10.setText("COST");

        TRANSACTIONDATE.setText("TRANSACTION DATE");

        jLabel6.setText("PAYMENT TYPE");

        jLabel7.setText("SIZE");

        jLabel4.setText("PAYMENT MODE");

        jLabel11.setText("ACC/DEBIT");

        id.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                idKeyTyped(evt);
            }
        });

        location.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                locationFocusLost(evt);
            }
        });
        location.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                locationMouseClicked(evt);
            }
        });

        getdetails.setText("Get Details");
        getdetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getdetailsActionPerformed(evt);
            }
        });

        transaction_date.setDateFormatString("yyyy-MM-dd");

        current_date.setText("Date");

        jLabel12.setText("INPUT PASSWORD");

        cname.setText("client name");
        cname.setEditable(false);

        cost.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        cost.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                costKeyTyped(evt);
            }
        });

        jLabel13.setText("DISCOUNTED");

        disc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "YES", "NO" }));
        disc.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                discFocusLost(evt);
            }
        });

        jLabel14.setText("DISC AMOUNT");

        discount.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));

        plotno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NO" }));

        amount.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        amount.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                amountFocusLost(evt);
            }
        });
        amount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                amountKeyTyped(evt);
            }
        });

        jLabel15.setText("Search by Hs No");

        jLabel16.setText("and");

        location1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                location1FocusLost(evt);
            }
        });
        location1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                location1MouseClicked(evt);
            }
        });

        sbyhnp.setText("Search");
        sbyhnp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sbyhnpActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(25, 25, 25)
                                .addComponent(location, 0, 116, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(size, 0, 116, Short.MAX_VALUE)
                                    .addComponent(cost)))
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(getdetails)
                                .addGap(57, 57, 57)
                                .addComponent(current_date))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel16)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(location1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(sbyhnp))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(TRANSACTIONDATE)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel14))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(amount)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(transaction_date, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                                                        .addComponent(plotno, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(discount))
                                                    .addComponent(ptype, 0, 135, Short.MAX_VALUE))
                                                .addGap(0, 10, Short.MAX_VALUE))))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(hsno, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(disc, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(pmode, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(95, 95, 95)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cname, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(37, 37, 37)
                                        .addComponent(pwd, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(21, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(28, 28, 28)
                        .addComponent(account_debit, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(186, 186, 186)
                        .addComponent(save)))
                .addGap(18, 18, 18)
                .addComponent(refno, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {account_debit, id, location, refno, size});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {ptype, transaction_date});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(getdetails)
                    .addComponent(current_date)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(hsno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(location1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sbyhnp))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(location, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(size, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(ptype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(TRANSACTIONDATE)
                        .addComponent(transaction_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(cost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(amount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(disc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14)
                            .addComponent(discount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(pmode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(plotno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(refno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(account_debit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addGap(6, 6, 6)))
                .addComponent(cname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(pwd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(save)
                .addGap(65, 65, 65))
        );

        print.setText("PRINT");
        print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printActionPerformed(evt);
            }
        });

        jtp.setEditable(false);
        jtp.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jtp.setMargin(new java.awt.Insets(1, 1, 1, 1));
        jScrollPane1.setViewportView(jtp);

        javax.swing.GroupLayout rctpanelLayout = new javax.swing.GroupLayout(rctpanel);
        rctpanel.setLayout(rctpanelLayout);
        rctpanelLayout.setHorizontalGroup(
            rctpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 525, Short.MAX_VALUE)
        );
        rctpanelLayout.setVerticalGroup(
            rctpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rctpanelLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE)
                .addGap(3, 3, 3))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(221, 221, 221)
                        .addComponent(print))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(rctpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(73, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rctpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(print))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        setSize(new java.awt.Dimension(1114, 526));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

  
    
    
    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        if(!jtp.getText().isEmpty())
           {
        JOptionPane.showMessageDialog(null,"Print current receipt");
        }
       
       else if(id.getText().isEmpty()||amount.getText().isEmpty()||((JTextField)transaction_date.getDateEditor().getUiComponent()).getText().isEmpty()||cost.getText().isEmpty()||refno.getText().isEmpty() )
            
            
       {    JOptionPane.showMessageDialog(null, "<html><h4><font color='red'>Kindly Fill all the fields Correctly!</font></h4></html>");
        int a=Integer.parseInt(cost.getText().replaceAll(",",""));
        int b=Integer.parseInt(amount.getText().replaceAll(",",""));
        if (b>a){
            JOptionPane.showMessageDialog(null,"Amount being paid cannot exceed total cost");
        }
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
             //check whether client exist
            String searchcl = "SELECT COUNT(*) AS total FROM [client_detail] where id =?";
            pst=conn.prepareStatement(searchcl);
            pst.setString(1,  id.getText().trim());
            rs = pst.executeQuery();
            while(rs.next()){
                
             if(rs.getInt("total")>0){
        
             // check for user
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
           
         
              
           //check for reference number
            String searchrefno = "SELECT COUNT(*) AS total FROM [house] where refno =?";
            pst=conn.prepareStatement(searchrefno);
            pst.setString(1,  refno.getText().trim());
            rs = pst.executeQuery();
            
            
            while(rs.next()){
             if(rs.getInt("total")<1){
       
                String check = "SELECT COUNT(*) AS total FROM house where id = '" + id.getText() + "'";
                pst = conn.prepareStatement(check);
                rs = pst.executeQuery();

                while (rs.next()) {
                            //check receipt no
         String checkrn ="SELECT TOP 1 rno FROM receipt ORDER BY rno DESC";
         pst = conn.prepareStatement(checkrn);
         rs =pst.executeQuery();
       
         while(rs.next()){
          int b = Integer.parseInt(rs.getString(1));
          int n =(b+1);
         
           String receiptno = "GREHS"+n; 
                    
                        //CHECK FOR previous payments
                        
                        String searchclient = "select COUNT(*) AS total,sum(amount) from house where id=? ";
                         pst=conn.prepareStatement(searchclient);
                         pst.setString(1, id.getText());
                         rs=pst.executeQuery();
                         
                    while(rs.next()){     
                 if(rs.getInt("total")<1){
                           
                          String amntpd = rs.getString(1);
                          
                           //save in house
                          String house = "insert into house(account_debit,cost,amount,id,location,payment_mode,payment_type,posting_date,plotno,refno,transaction_date,house_size,discount,balance,receiptno,servedby)"
                         + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

                            pst = conn.prepareStatement(house);
                            pst.setString(1, account_debit.getSelectedItem().toString());
                            pst.setString(2, cost.getText().trim().replaceAll(",",""));
                            pst.setString(3, amount.getText().trim().replaceAll(",",""));
                            pst.setString(4, id.getText().trim());
                            pst.setString(5, location.getSelectedItem().toString());
                            pst.setString(6, pmode.getSelectedItem().toString());
                            pst.setString(7, ptype.getSelectedItem().toString());
                            pst.setString(8, td);
                            pst.setString(9, plotno.getSelectedItem().toString());
                            pst.setString(10, refno.getText().trim());
                            pst.setString(11, ((JTextField)transaction_date.getDateEditor().getUiComponent()).getText().trim());
                            pst.setString(12,size.getSelectedItem().toString());  
                            pst.setString(13,disc.getSelectedItem().toString()); 

                       
                            //current bal
                            int amnt = Integer.parseInt(amount.getText().trim().replaceAll(",",""));
                            int tcost = Integer.parseInt(cost.getText().trim().replaceAll(",",""));
                            int pdamnt = Integer.parseInt(amntpd);
                            int currentbal = tcost - ( pdamnt+amnt);

                            pst.setString(14, String.valueOf(currentbal));
                            pst.setString(15, String.valueOf(reciept_no));
                            pst.setString(16, uname);
                            pst.execute();
                    
                            //display receipt
                    
                    int nm = Integer.parseInt(amount.getText().replaceAll(",",""));
                    String Englishword = EnglishNumber(nm);
                    String amntw = " " + Englishword+ " "+"Kenya Shillings Only";
                    
                    String transactionDate=((JTextField)transaction_date.getDateEditor().getUiComponent()).getText();
                    String Type_Of_House= size.getSelectedItem().toString();
                    String Deposit_Type= ptype.getSelectedItem().toString();
                    String Payment_mode=pmode.getSelectedItem().toString();
                    String Amount=amount.getText();
                    String Amountw=String.valueOf(amntw);
                    String sg = ".............";
                    String Deposited="................";
                    String servedby=" ";
                    String ttl="\t\t\tHOUSE PAYMENTS";
                    
                    StyledDocument doc = (StyledDocument) jtp.getDocument();
                    Style style = doc.addStyle("Tahoma", null);
                    StyleConstants.setFontSize(style, 11);
                  
                    jtp.setPage(getClass().getResource("logo.html"));
                    jtp.getStyledDocument().insertString(1, ttl+"\nBranch"+" "+branch+" . "+ " "+"Date Of Posting"+" "+td+  " . "+ " "+"Transaction Date"+"  "+transactionDate+" ."+" "+"\nClient Name\t\t\t\t"+name+"\nReceiptNo\t\t\t\t"+receiptno+"\nType Of House\t\t\t"
                            +Type_Of_House+"\nType Of Deposit\t\t\t"+Deposit_Type+"\nMode Of Payment\t\t\t"+Payment_mode+"\nAmount\t\t\t\t"+Amount+"\nAmount in Words:"+Amountw+"\nDepositedBy:"+Deposited+""
                                    + "Client Signature:"+sg+"Served by"+servedby+""+uname+"\n\t\t Where Trust Meets Your Vision",style);
              
               //save in receipt table
                
                    String hsrct = "insert into receipt(cname,pdate,tdate,pmode,amount,receiptno,servedby,ptype,branch,client_id,rno)"
                        + "values(?,?,?,?,?,?,?,?,?,?,?)";
                     
                    pst = conn.prepareStatement(hsrct);
                    
                    pst.setString(1,cname.getText().trim());
                    pst.setString(2, td);
                    pst.setString(3, ((JTextField)transaction_date.getDateEditor().getUiComponent()).getText().trim());
                    pst.setString(4, pmode.getSelectedItem().toString());
                    pst.setString(5, amount.getText().trim().replaceAll(",",""));
                    pst.setString(6, String.valueOf(reciept_no));
                    pst.setString(7,uname);
                    pst.setString(8, ptype.getSelectedItem().toString());
                    pst.setString(9, branch);
                    pst.setString(10,id.getText().trim());
                    pst.setString(11,String.valueOf(n)); //increment receipt numbers
                    pst.execute();
                   
                         
           updateplotno();
         JOptionPane.showMessageDialog(null, "Saved");
                            
                     }
             else {
                        
                            
                             String house = "insert into house(account_debit,cost,amount,id,location,payment_mode,payment_type,"
                                     + "posting_date,plotno,refno,transaction_date,house_size,discount,balance,receiptno,servedby)"
                                   + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

                    pst = conn.prepareStatement(house);
                    pst.setString(1, account_debit.getSelectedItem().toString());
                    pst.setString(2, cost.getText().trim().replaceAll(",",""));
                    pst.setString(3, amount.getText().trim().replaceAll(",",""));
                    pst.setString(4, id.getText().trim());
                    pst.setString(5, location.getSelectedItem().toString());
                    pst.setString(6, pmode.getSelectedItem().toString());
                    pst.setString(7, ptype.getSelectedItem().toString());
                    pst.setString(8, td);
                    pst.setString(9, plotno.getSelectedItem().toString());
                    pst.setString(10, refno.getText().trim());
                    pst.setString(11, ((JTextField)transaction_date.getDateEditor().getUiComponent()).getText().trim());
                    pst.setString(12,size.getSelectedItem().toString());    
                    pst.setString(13,disc.getSelectedItem().toString()); 
                    
                 //initial bal
                    int amnt = Integer.parseInt(amount.getText().trim().replaceAll(",",""));
                    int tcost = Integer.parseInt(cost.getText().trim().replaceAll(",",""));
                    int initialbal = tcost - amnt;

                    pst.setString(14, String.valueOf(initialbal));
                    pst.setString(15, String.valueOf(reciept_no));
                     pst.setString(16, uname);
                    pst.execute();

                            //display receipt
                    
                    int nm = Integer.parseInt(amount.getText().replaceAll(",",""));
                    String Englishword = EnglishNumber(nm);
                    String amntw = " " + Englishword+ " "+"Kenya Shillings Only";
                    
                    String transactionDate=((JTextField)transaction_date.getDateEditor().getUiComponent()).getText();
                    String Type_Of_House= size.getSelectedItem().toString();
                    String Deposit_Type= ptype.getSelectedItem().toString();
                    String Payment_mode=pmode.getSelectedItem().toString();
                    String Amount=amount.getText();
                    String Amountw=String.valueOf(amntw);
                    String sg = ".............";
                    String Deposited="................";
                    String servedby=" ";
                    String ttl="\t\t\tHOUSE PAYMENTS";
                    
                    StyledDocument doc = (StyledDocument) jtp.getDocument();
                    Style style = doc.addStyle("Tahoma", null);
                    StyleConstants.setFontSize(style, 11);
                  
                    jtp.setPage(getClass().getResource("logo.html"));
                    jtp.getStyledDocument().insertString(1, ttl+"\nBranch"+" "+branch+" . "+ " "+"Date Of Posting"+" "+td+  " . "+ " "+"Transaction Date"+"  "+transactionDate+" ."+" "+"\nClient Name\t\t\t\t"+name+"\nReceiptNo\t\t\t\t"+receiptno+"\nType Of House\t\t\t"
                            +Type_Of_House+"\nType Of Deposit\t\t\t"+Deposit_Type+"\nMode Of Payment\t\t\t"+Payment_mode+"\nAmount\t\t\t\t"+Amount+"\nAmount in Words:"+Amountw+"\nDepositedBy:"+Deposited+""
                                    + "Client Signature:"+sg+"Served by"+servedby+""+uname+"\n\t\t Where Trust Meets Your Vision",style);
              
               //save in receipt table
                
                    String hsrct = "insert into receipt(cname,pdate,tdate,pmode,amount,receiptno,servedby,ptype,branch,client_id,rno)"
                        + "values(?,?,?,?,?,?,?,?,?,?,?)";
                     
                    pst = conn.prepareStatement(hsrct);
                    
                    pst.setString(1,cname.getText().trim());
                    pst.setString(2, td);
                    pst.setString(3, ((JTextField)transaction_date.getDateEditor().getUiComponent()).getText().trim());
                    pst.setString(4, pmode.getSelectedItem().toString());
                    pst.setString(5, amount.getText().trim().replaceAll(",",""));
                    pst.setString(6, String.valueOf(reciept_no));
                    pst.setString(7,name);
                    pst.setString(8, ptype.getSelectedItem().toString());
                    pst.setString(9, branch);
                    pst.setString(10,id.getText().trim());
                    pst.setString(11,String.valueOf(n)); //increment receipt numbers
                    pst.execute();
                          
           updateplotno();
         JOptionPane.showMessageDialog(null, "Saved");
                   }
                }
                }
                }
           
              
            } 
             else {
                 JOptionPane.showMessageDialog(null, "<html><h4><font color='red'>The reference number already exist!</font></h4></html>");
             }
                 }
              
              } 
        else{
             JOptionPane.showMessageDialog(null, "Incorrect  password");
            }    
        
   
             
             }
             else {
             JOptionPane.showMessageDialog(null, "<html><h4><font color='red'>Client with ID " +id.getText().trim()+ " does not exist! Please register the client</font></h4></html>");
             }
        }
       
   }              catch (SQLException ex) {
                      Logger.getLogger(house.class.getName()).log(Level.SEVERE, null, ex);
                  } catch (IOException ex) {
                   Logger.getLogger(house.class.getName()).log(Level.SEVERE, null, ex);
               } catch (BadLocationException ex) {
                   Logger.getLogger(house.class.getName()).log(Level.SEVERE, null, ex);
               }
  
              }
            }
          }
       
    }//GEN-LAST:event_saveActionPerformed

    private void getdetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getdetailsActionPerformed
   if (id.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Enter ID number");
        } 
   
          else if(conn==null){
            JOptionPane.showMessageDialog(this, "Could not connect to the server");
        }  
          
         else {
     try {
                
                String searchld = "select client_detail.name from client_detail where client_detail.id=?";
                
                pst = conn.prepareStatement(searchld );
                pst.setString(1, id.getText());
                rs = pst.executeQuery();
                
                if (rs.next()) {
                cname.setText(rs.getString("name"));
                cname.setEnabled(false);
                display();
                }
                else{
                JOptionPane.showMessageDialog(null, "Client ID" + " " + id.getText() +"does not exist");
                }
            } catch (SQLException ex) {
                Logger.getLogger(land.class.getName()).log(Level.SEVERE, null, ex);
            } 

         }
    }//GEN-LAST:event_getdetailsActionPerformed
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
            close();
            house h = new house();
             h .setVisible(true);
        }
        catch(java.awt.print.PrinterException e)
        {
            PrintStream format = System.err.format("Cannot print %s%n");
        }
         }
    }//GEN-LAST:event_printActionPerformed

    private void idKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_idKeyTyped
      
        char c=evt.getKeyChar();
        if(!(Character.isAlphabetic(c) ||  (c==KeyEvent.VK_BACK_SPACE)||  c==KeyEvent.VK_DELETE ||Character.isDigit(c))){
        evt.consume();
        getToolkit().beep();}
    }//GEN-LAST:event_idKeyTyped

    private void refnoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_refnoKeyTyped
       
        char c=evt.getKeyChar();
        if(!(Character.isAlphabetic(c) ||  (c==KeyEvent.VK_BACK_SPACE)||  c==KeyEvent.VK_DELETE ||Character.isDigit(c))){
        evt.consume();
        getToolkit().beep();}
    }//GEN-LAST:event_refnoKeyTyped

    private void costKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_costKeyTyped
  char c = evt.getKeyChar();
        if (!(Character.isDigit(c)
                || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE || evt.getKeyChar() == '.')) {
            evt.consume();
            getToolkit().beep();
        }    }//GEN-LAST:event_costKeyTyped

    private void discFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_discFocusLost
        
        if(disc.getSelectedItem()=="NO"){
              discount.setText("0");
              discount.setEnabled(false);
        }
        else{
             discount.setEnabled(true);
        }    }//GEN-LAST:event_discFocusLost

    private void pmodeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pmodeFocusLost
         if("Cash".equals(pmode.getSelectedItem().toString())||"Transfer".equals(pmode.getSelectedItem().toString())||
            "Standing order".equals(pmode.getSelectedItem().toString())||"Defaced Agent Slip".equals(pmode.getSelectedItem().toString())){
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
      
           refno.setText(String.valueOf(n));
           refno.setEnabled(false);

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
    }//GEN-LAST:event_pmodeFocusLost

    private void locationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_locationMouseClicked
        // TODO add your handling code here:
    
    }//GEN-LAST:event_locationMouseClicked

    private void amountKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_amountKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c)
            || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE || evt.getKeyChar() == '.')) {
        evt.consume();
        getToolkit().beep();}

    }//GEN-LAST:event_amountKeyTyped

    private void amountFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_amountFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_amountFocusLost

    private void locationFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_locationFocusLost
        plotno.removeAllItems();
        plotno.addItem("NO");
        plotnos();
    }//GEN-LAST:event_locationFocusLost

    private void location1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_location1FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_location1FocusLost

    private void location1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_location1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_location1MouseClicked

    private void sbyhnpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sbyhnpActionPerformed
        // TODO add your handling code here:
        if (hsno.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Enter House number");
        } 
        else { 
          displayptno(); 
        }
        
    }//GEN-LAST:event_sbyhnpActionPerformed

    
    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(() -> {
            new house().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel TRANSACTIONDATE;
    private javax.swing.JComboBox<String> account_debit;
    private javax.swing.JFormattedTextField amount;
    public static javax.swing.JTextField cname;
    private javax.swing.JFormattedTextField cost;
    private javax.swing.JLabel current_date;
    private javax.swing.JComboBox<String> disc;
    private javax.swing.JFormattedTextField discount;
    private javax.swing.JButton getdetails;
    private javax.swing.JTextField hsno;
    public static javax.swing.JTextField id;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jtp;
    private javax.swing.JComboBox<String> location;
    private javax.swing.JComboBox<String> location1;
    private javax.swing.JComboBox<String> plotno;
    private javax.swing.JComboBox<String> pmode;
    private javax.swing.JButton print;
    private javax.swing.JComboBox<String> ptype;
    private javax.swing.JPasswordField pwd;
    private javax.swing.JPanel rctpanel;
    private javax.swing.JTextField refno;
    private javax.swing.JButton save;
    private javax.swing.JButton sbyhnp;
    private javax.swing.JComboBox<String> size;
    private com.toedter.calendar.JDateChooser transaction_date;
    // End of variables declaration//GEN-END:variables
}
