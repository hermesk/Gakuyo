
import java.awt.Toolkit;
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
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;



public class Transfers extends javax.swing.JFrame {

    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    private static Transfers obj=null;
    
              //current date
   DateFormat dF = new SimpleDateFormat("yyyy-MM-dd");
       Date date = new Date();
       String td=dF.format(date);
       
         // autgen transfer no
                int rno = (int) Math.floor((Math.random() * 1000000) + 1)+(int) Math.floor((Math.random() * 10000)+1);
                String transfer_no = "LDTR" + rno;
    
    private Transfers() {
        
        initComponents();
        conn = DbConnect.connecrDb();
        ProperyDetails();
        current_date();
        logo();
      
    }
      public static Transfers getObj() {
        if (obj== null){
            obj = new Transfers();
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
  
     private void display() {
        if(conn==null){
            JOptionPane.showMessageDialog(this, "Could not connect to the server");
        }else{
        try {
            String searchclient = "select sum(amount),location,cost,size from land where id=? and location='"+location.getSelectedItem()+"'  GROUP BY land.location,land.cost,land.size";

            pst = conn.prepareStatement(searchclient);
            pst.setString(1, id.getText());
            rs = pst.executeQuery();

            if (rs.next()) {
                String amntpd = rs.getString(1);
                location.setSelectedItem(rs.getString("location"));
                cost.setText(rs.getString("cost"));
                amnt.setText(amntpd);
                size.setSelectedItem(rs.getString("size"));
               
            } else {
                JOptionPane.showMessageDialog(null, "No Land Payments Found For Client ID" + " " + id.getText());
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
   
        }

    }
      private void display1(){
        if(conn==null){
            JOptionPane.showMessageDialog(this, "Could not connect to the server");
        }else{
          try {
            String searchclient = "select sum(amount), location,cost,house_size from house where id=? and location='"+location.getSelectedItem()+"' GROUP BY house.location,house.cost,house.house_size";

            pst = conn.prepareStatement(searchclient);
            pst.setString(1, id.getText());
            rs = pst.executeQuery();

            if (rs.next()) {
                String amntpd = rs.getString(1);
                location.setSelectedItem(rs.getString("location"));
              
                cost.setText(rs.getString("cost"));
                amnt.setText(amntpd);
                size.setSelectedItem(rs.getString("house_size"));
               
            } else {
                JOptionPane.showMessageDialog(null, "No house Payments Found For Client ID" + " " + id.getText());
                
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        }

    }
     private void ProperyDetails() {
        if(conn==null){
            JOptionPane.showMessageDialog(this, "Could not connect to the server");
        }else{
        try {
            String sql = "select *from property_location";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                String lctn = rs.getString("location");
                location.addItem(lctn);
                String sz = rs.getString("size");
                size.addItem(sz);
                String lctn1 = rs.getString("location");
                location1.addItem(lctn1);
                String sz1 = rs.getString("size");
                size1.addItem(sz1);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
  
    }}
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
     
     public void trdoc(){
         
      if(!jtp.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "<html><h4><font color='red'>print current receipt</font></h4></html>");
            }
     if(conn==null){
            JOptionPane.showMessageDialog(this, "Could not connect to the server");
        }
     else{
        try{
                   String searchuser = "select [user].branch,[user].fname,[user].lname,[client_detail].name from [user],[client_detail] where [user].password=?"
                           + " and [client_detail].id=?";
                   pst=conn.prepareStatement(searchuser);
                   pst.setString(1, md5(pwd.getText().trim()));
                   pst.setString(2, id.getText());
                   rs = pst.executeQuery();
                    if(rs.next()){
                        
                    String nme=rs.getString("name");
                    String branch=rs.getString("branch");
                    String fname =rs.getString("fname"); 
                    String lname =rs.getString("lname"); 
                    String name = fname+" "+lname;
                  
                    String ReceiptNo = String.valueOf(transfer_no);
                    int pamnt = Integer.parseInt(penalty.getText().trim());
                    
                    int n = Integer.parseInt(amnt1.getText())+pamnt;
                    String Englishword = EnglishNumber(n);
                    String amntw = " " + Englishword+ " "+"Kenya Shillings Only";
                    String Size_of_land= size.getSelectedItem().toString();
                    String Amountw=String.valueOf(amntw);
                    String tt= "transfer from"+" "+location.getSelectedItem().toString() +" "+"to"+" " +location1.getSelectedItem().toString();
                    String sg = "..............";
                    String servedby=" ";
                    String ttl="\t\t\tTRANSFERS ";
                  
                    StyledDocument doc = (StyledDocument) jtp.getDocument();
                    Style style = doc.addStyle("Tahoma", null);
                    StyleConstants.setFontSize(style, 11);
                    jtp.setPage(getClass().getResource("logo.html"));
                    jtp.getStyledDocument().insertString(1, ttl+"\nBranch"+" "+branch+" . "+ " "+"Date Of Transfer"+" "+td+  " . "+ " "+"Transaction Date"+"  "+td+". "+""
                    + " "+"\nClient Name\t\t\t\t"+nme+"\nTransaction\t\t"+tt+"\nTransferNo\t\t\t\t"+ReceiptNo+"\nType Of House\t\t\t"
                   +Size_of_land+"\nPenalty \t\t\t\t"+pamnt+"\nAmount \t\t\t\t"+n+"\nAmount in Words:"+Amountw+ "\nClient Signature:"+sg+" "+"Served by"+servedby+""+name+"\n\t\t Where Trust Meets Your Vision",style);
                JOptionPane.showMessageDialog(null, "Saved");
                    }
                   
        }
         catch (IOException | BadLocationException | SQLException ex) {
         }
      
      
     } 
     }
      private void logo(){
    setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("images/LOG.png")));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtp = new javax.swing.JTextPane();
        prnt = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnsave = new javax.swing.JButton();
        location = new javax.swing.JComboBox<>();
        size = new javax.swing.JComboBox<>();
        cost = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        amnt1 = new javax.swing.JTextField();
        amnt = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        id = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        location1 = new javax.swing.JComboBox<>();
        size1 = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        btndetails = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        cost1 = new javax.swing.JTextField();
        tfrom = new javax.swing.JComboBox<>();
        today = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        pwd = new javax.swing.JPasswordField();
        tto = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        penalty = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("TRANSFERS");
        setResizable(false);

        jScrollPane1.setViewportView(jtp);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
                .addContainerGap())
        );

        prnt.setText("Print");
        prnt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prntActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Transfers", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        btnsave.setText("Save");
        btnsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsaveActionPerformed(evt);
            }
        });

        jLabel5.setText("location");

        jLabel3.setText("Cost");

        jLabel1.setText("Transfer  From");

        jLabel14.setText("password");

        jLabel11.setText("Amount");

        jLabel8.setText("location");

        jLabel4.setText("Amount");

        jLabel10.setText("Size");

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/gakuyo.png"))); // NOI18N

        btndetails.setText("Get Details");
        btndetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndetailsActionPerformed(evt);
            }
        });

        jLabel6.setText("Size");

        tfrom.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "LAND", "HOUSE", " " }));

        today.setText("Date");

        jLabel7.setText("Transfer  To");

        tto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "LAND", "HOUSE", " " }));

        jLabel12.setText("Penalty");

        jLabel2.setText("Id");

        jLabel9.setText("Cost");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(today)
                        .addGap(76, 76, 76))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(125, 125, 125)
                                        .addComponent(jLabel14)
                                        .addGap(18, 18, 18)
                                        .addComponent(pwd, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel7)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(81, 81, 81)
                                        .addComponent(tto, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(size, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(33, 33, 33))
                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                    .addComponent(jLabel12)
                                                    .addGap(45, 45, 45)))
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                    .addComponent(cost1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jLabel11))
                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                    .addComponent(location1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jLabel10))
                                                .addComponent(penalty, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addGap(134, 134, 134)
                                            .addComponent(btnsave)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(size1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(amnt1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(tfrom, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(10, 10, 10)
                                                .addComponent(jLabel2))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(location, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel6)))
                                        .addGap(18, 18, 18)
                                        .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btndetails))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(cost, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(amnt, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btndetails)
                            .addComponent(tfrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(location, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(size, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(amnt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(tto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(location1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(size1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(cost1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(amnt1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(penalty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(pwd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnsave))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(today)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(226, 226, 226)
                        .addComponent(prnt))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(67, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(prnt)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(1064, 473));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btndetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndetailsActionPerformed

      if (id.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Enter ID number");
        }
      else if(tfrom.getSelectedItem()=="LAND") {
            display();
        }   
      else if(tfrom.getSelectedItem()=="HOUSE") {
            display1();
        }
      else if(tfrom.getSelectedItem()=="GZD") {
            display();
        }
    }//GEN-LAST:event_btndetailsActionPerformed

    private void btnsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsaveActionPerformed
     
        if(id.getText().isEmpty()||cost1.getText().isEmpty()||amnt1.getText().isEmpty()||penalty.getText().isEmpty() )
       {  
           JOptionPane.showMessageDialog(null, "<html><h4><font color='red'>Kindly Fill all the fields!</font></h4></html>");
        int a = Integer.parseInt(amnt.getText());
        int b = Integer.parseInt(amnt1.getText()); 
        if (b>a){
        JOptionPane.showMessageDialog(null,"Amount being transfered cannot exceed total amount");
        }
        
       }
        else if(!jtp.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "<html><h4><font color='red'>print current receipt first!</font></h4></html>");
            }
        
            
          else if(pwd.getText().isEmpty()){
               JOptionPane.showMessageDialog(null,"Kindly Input Your Password ");
                  } 
        if(conn==null){
            JOptionPane.showMessageDialog(this, "Could not connect to the server");
        }
            else{
                
            try{
            String searchuser = "select *from [user] where password=?";
            pst=conn.prepareStatement(searchuser);
            pst.setString(1, md5(pwd.getText().trim()));
            rs = pst.executeQuery();
            if(rs.next()){
                   String fname =rs.getString("fname"); 
                   String lname =rs.getString("lname"); 
                   String uname = fname+" "+lname;
                   
                   if(tfrom.getSelectedItem()=="LAND"){
                   if(tto.getSelectedItem()=="LAND"){
                       
                   //calculating initial bal
                            int amount = Integer.parseInt(amnt1.getText().trim());
                            int cst = Integer.parseInt(cost1.getText().trim());
                            int initialbal = cst - amount;
                            
                   String tr = "transfer from"+" "+location.getSelectedItem().toString();
                   //record new land transfer in table land
                    String trland = "insert into land(id,size,location,cost,amount,tdate,ref_no,receiptno,pmode,balance)"
                            + "values(?,?,?,?,?,?,?,?,?,?)";
                    
                    pst = conn.prepareStatement(trland);
                    pst.setString(1, id.getText().trim());
                    pst.setString(2, size1.getSelectedItem().toString());
                    pst.setString(3, location1.getSelectedItem().toString());
                    pst.setString(4, cost1.getText().trim());
                    pst.setString(5, amnt1.getText().trim());
                    pst.setString(6, td);
                    pst.setString(7, String.valueOf(transfer_no));
                    pst.setString(8, String.valueOf(transfer_no));
                    pst.setString(9, tr);
                    pst.setString(10, String.valueOf(initialbal));
                    pst.execute();
                    
                    //1.deduct the transfer from land
                    
                    /**calculating Withdrawal**/
                    
                    int amntd = Integer.parseInt(amnt1.getText().trim());
                    int pamnt = Integer.parseInt(penalty.getText().trim());
                    int namnt =-(amntd +pamnt);
                    
                    //calculate remaining balance
                    int iamnt = Integer.parseInt(amnt.getText().trim());
                    int rmbal =iamnt+namnt;
                    String trt = "transfer to"+" "+location1.getSelectedItem().toString();
                    
                    String tland = "insert into land(id,size,location,cost,amount,tdate,ref_no,receiptno,pmode,balance)"
                            + "values(?,?,?,?,?,?,?,?,?,?)";
                    pst = conn.prepareStatement(tland);
                    pst.setString(1, id.getText().trim());
                    pst.setString(2, size1.getSelectedItem().toString());
                    pst.setString(3, location.getSelectedItem().toString());
                    pst.setString(4, cost.getText().trim());
                    pst.setString(5, String.valueOf(namnt));
                    pst.setString(6, td);
                    pst.setString(7, String.valueOf(rno));
                    pst.setString(8, String.valueOf(transfer_no));
                    pst.setString(9, trt);
                    pst.setString(10, String.valueOf(rmbal));
                    pst.execute();
                    
                    //insert into transfer table//
                    
                     String landtr = "insert into transfers (id,ttype,size,location,cost,amount,tdate,trfrom,penalty,receiptno,servedby)"
                           + "values(?,?,?,?,?,?,?,?,?,?,?)";
             
                            pst = conn.prepareStatement(landtr);
                            pst.setString(1, id.getText().trim());
                            pst.setString(2, tto.getSelectedItem().toString().toLowerCase());
                            pst.setString(3, size1.getSelectedItem().toString());
                            pst.setString(4, location1.getSelectedItem().toString());
                            pst.setString(5, cost1.getText().trim());
                            pst.setString(6, amnt1.getText().trim());
                            pst.setString(7, td);
                            pst.setString(8, location.getSelectedItem().toString());
                            pst.setString(9, penalty.getText().trim());
                            pst.setString(10, transfer_no);
                            pst.setString(11, uname);
                            pst.execute();
                   
                    trdoc();
                   }
                   else if(tto.getSelectedItem()=="HOUSE"){
                   
                       //record new land transfer to house
                       String tr = "Land transfer from"+" "+location.getSelectedItem().toString();
                   
                        //calculating initial bal
                            int amount = Integer.parseInt(amnt1.getText().trim());
                            int cst = Integer.parseInt(cost1.getText().trim());
                            int initialbal = cst - amount;
                            
                       String trland = "insert into house(id,house_size,location,cost,amount,transaction_date,refno,receiptno,payment_mode,balance,posting_date)"
                            + "values(?,?,?,?,?,?,?,?,?,?,?)";
                    
                    pst = conn.prepareStatement(trland);
                    pst.setString(1, id.getText().trim());
                    pst.setString(2, size1.getSelectedItem().toString());
                    pst.setString(3, location1.getSelectedItem().toString());
                    pst.setString(4, cost1.getText().trim());
                    pst.setString(5, amnt1.getText().trim());
                    pst.setString(6, td);
                    pst.setString(7, String.valueOf(transfer_no));
                    pst.setString(8, String.valueOf(transfer_no));
                    pst.setString(9, tr);
                    pst.setString(10, String.valueOf(initialbal));
                    pst.setString(11, td);
                    pst.execute();
                    
                    //deduct transfered amount in lands table
                    
                    //calculating transfer
                    int amntt = Integer.parseInt(amnt1.getText().trim());
                    int pamnt = Integer.parseInt(penalty.getText().trim());
                    int tamnt =  -(amntt+pamnt);
                    //calculate remaining bal
                    int iamnt = Integer.parseInt(amnt.getText().trim());
                    int rmbal =iamnt+tamnt;
                    String ttr = "transfer from"+" "+location.getSelectedItem().toString();
                   
                    String tland = "insert into land(id,size,location,cost,amount,tdate,ref_no,receiptno,pmode,balance)"
                            + "values(?,?,?,?,?,?,?,?,?,?)";
                    
                    pst = conn.prepareStatement(tland);
                    pst.setString(1, id.getText().trim());
                    pst.setString(2, size1.getSelectedItem().toString());
                    pst.setString(3, location1.getSelectedItem().toString());
                    pst.setString(4, cost1.getText().trim());
                    pst.setString(5, String.valueOf(tamnt));
                    pst.setString(6, td);
                    pst.setString(7, String.valueOf(rno));
                    pst.setString(8, String.valueOf(transfer_no));
                    pst.setString(9, ttr);
                    pst.setString(10, String.valueOf(rmbal));
                    pst.execute();
                    
                    //record in transfer table
                    String landtr = "insert into transfers (id,ttype,size,location,cost,amount,tdate,trfrom,penalty,servedby,receiptno)"
                           + "values(?,?,?,?,?,?,?,?,?,?,?)";
             
                            pst = conn.prepareStatement(landtr);
                            pst.setString(1, id.getText().trim());
                            pst.setString(2, tto.getSelectedItem().toString().toLowerCase());
                            pst.setString(3, size1.getSelectedItem().toString());
                            pst.setString(4, location1.getSelectedItem().toString());
                            pst.setString(5, cost1.getText().trim());
                            pst.setString(6, amnt1.getText().trim());
                            pst.setString(7, td);
                            pst.setString(8, location.getSelectedItem().toString());
                            pst.setString(9, penalty.getText().trim());
                            pst.setString(10, uname);
                            pst.setString(11, transfer_no);
                            pst.execute();
                            
                            trdoc();
                   
                   }
                   }
              else if(tfrom.getSelectedItem()=="HOUSE"){
                 if(tto.getSelectedItem()=="HOUSE"){
                     
                 String tr = "transfer from"+" "+location.getSelectedItem().toString();
               
                 //calculating initial bal
                int cst = Integer.parseInt(cost1.getText().trim());
                int tamnt = Integer.parseInt(amnt1.getText().trim());
                int bal = cst -tamnt;
                
                 
                 //record new house
                   String trland = "insert into house(id,house_size,location,cost,amount,transaction_date,refno,receiptno,payment_mode,balance,posting_date)"
                            + "values(?,?,?,?,?,?,?,?,?,?,?)";
                    
                    pst = conn.prepareStatement(trland);
                    pst.setString(1, id.getText().trim());
                    pst.setString(2, size1.getSelectedItem().toString());
                    pst.setString(3, location1.getSelectedItem().toString());
                    pst.setString(4, cost1.getText().trim());
                    pst.setString(5, String.valueOf(tamnt));
                    pst.setString(6, td);
                    pst.setString(7, String.valueOf(transfer_no));
                    pst.setString(8, String.valueOf(transfer_no));
                    pst.setString(9, tr);
                    pst.setString(10, String.valueOf(bal));
                    pst.setString(11, td);
                    pst.execute();
                    
                    
                    //deduct transfered amount
                      //calculating Withdrawal
                    int amntt = Integer.parseInt(amnt1.getText().trim());
                    int pamnt = Integer.parseInt(penalty.getText().trim()); 
                    int amntd =  -(amntt+pamnt);
                    
                    String ttr = "transfer to"+" "+location1.getSelectedItem().toString();
                
                    int amount = Integer.parseInt(amnt.getText().trim());
                    int rmbal = amount+amntd;
                
                     String trh = "insert into house(id,house_size,location,cost,amount,transaction_date,refno,receiptno,payment_mode,balance)"
                            + "values(?,?,?,?,?,?,?,?,?,?)";
                    
                    pst = conn.prepareStatement(trh);
                    pst.setString(1, id.getText().trim());
                    pst.setString(2, size.getSelectedItem().toString());
                    pst.setString(3, location.getSelectedItem().toString());
                    pst.setString(4, cost.getText().trim());
                    pst.setString(5, String.valueOf(amntd));
                    pst.setString(6, td);
                    pst.setString(7, String.valueOf(rno));
                    pst.setString(8, String.valueOf(transfer_no));
                    pst.setString(9, ttr);
                    pst.setString(10, String.valueOf(rmbal));
                    pst.execute();
                 
                 //record the transfer in tranfer table
                 String landtr = "insert into transfers (id,ttype,size,location,cost,amount,tdate,trfrom,penalty,servedby,receiptno)"
                           + "values(?,?,?,?,?,?,?,?,?,?,?)";
             
                            pst = conn.prepareStatement(landtr);
                            pst.setString(1, id.getText().trim());
                            pst.setString(2, tto.getSelectedItem().toString().toLowerCase());
                            pst.setString(3, size1.getSelectedItem().toString());
                            pst.setString(4, location1.getSelectedItem().toString());
                            pst.setString(5, cost1.getText().trim());
                            pst.setString(6, amnt1.getText().trim());
                            pst.setString(7, td);
                            pst.setString(8, location.getSelectedItem().toString());
                            pst.setString(9, penalty.getText().trim());
                            pst.setString(10, uname);
                            pst.setString(11, String.valueOf(transfer_no));
                            pst.execute();
                            
                            trdoc();
                 }
                 //house to land transfer
                 else if(tto.getSelectedItem()=="LAND"){
                     
                     //record new land from transfer
                 String tr = "house transfer from"+" "+location.getSelectedItem().toString();
                 int tamnt = Integer.parseInt(amnt1.getText().trim());
                 int cst = Integer.parseInt(cost1.getText().trim());
                 int rmbal =cst-tamnt;
                 
                  String tland = "insert into land(id,size,location,cost,amount,tdate,ref_no,receiptno,pmode,balance)"
                            + "values(?,?,?,?,?,?,?,?,?,?)";
                    
                    pst = conn.prepareStatement(tland);
                    pst.setString(1, id.getText().trim());
                    pst.setString(2, size1.getSelectedItem().toString());
                    pst.setString(3, location1.getSelectedItem().toString());
                    pst.setString(4, cost1.getText().trim());
                    pst.setString(5, String.valueOf(tamnt));
                    pst.setString(6, td);
                    pst.setString(7, String.valueOf(transfer_no));
                    pst.setString(8, String.valueOf(transfer_no));
                    pst.setString(9, tr);
                    pst.setString(10, String.valueOf(rmbal));
                    pst.execute();
                    
                    //deduct transfered amount in house
                      //calculating Withdrawal
                    int amntt = Integer.parseInt(amnt1.getText().trim());
                    int pamnt = Integer.parseInt(penalty.getText().trim());
                    int amntd =  -(amntt+pamnt);
                    
                    //calculating remaining bal
                    int inamnt = Integer.parseInt(amnt.getText().trim());
                    int rmbl = inamnt+amntd;
                    
                    String ttr = "transfer from"+" "+location.getSelectedItem().toString();
                
                    String trland = "insert into house(id,house_size,location,cost,amount,transaction_date,refno,receiptno,payment_mode,balance)"
                            + "values(?,?,?,?,?,?,?,?,?,?)";
                    
                    pst = conn.prepareStatement(trland);
                    pst.setString(1, id.getText().trim());
                    pst.setString(2, size1.getSelectedItem().toString());
                    pst.setString(3, location1.getSelectedItem().toString());
                    pst.setString(4, cost1.getText().trim());
                    pst.setString(5, String.valueOf(amntd));
                    pst.setString(6, td);
                    pst.setString(7, String.valueOf(rno));
                    pst.setString(8, String.valueOf(transfer_no));
                    pst.setString(9, ttr);
                    pst.setString(10, String.valueOf(rmbl));
                    pst.execute();
                 
                    //record in transfer tbl
                    String landtr = "insert into transfers (id,ttype,size,location,cost,amount,tdate,trfrom,penalty,servedby,receiptno)"
                           + "values(?,?,?,?,?,?,?,?,?,?,?)";
             
                            pst = conn.prepareStatement(landtr);
                            pst.setString(1, id.getText().trim());
                            pst.setString(2, tto.getSelectedItem().toString().toLowerCase());
                            pst.setString(3, size1.getSelectedItem().toString());
                            pst.setString(4, location1.getSelectedItem().toString());
                            pst.setString(5, cost1.getText().trim());
                            pst.setString(6, amnt1.getText().trim());
                            pst.setString(7, td);
                            pst.setString(8, location.getSelectedItem().toString());
                            pst.setString(9, penalty.getText().trim());
                            pst.setString(10, uname);
                            pst.setString(11, String.valueOf(transfer_no));
                            pst.execute();
                             
                            trdoc();
                 }
                 
                    
            }
        }
            else{
              JOptionPane.showMessageDialog(null, "Incorrect Password");
            }
            }
            catch (SQLException ex) {
                    Logger.getLogger(Transfers.class.getName()).log(Level.SEVERE, null, ex);
                }
     
            }     
    }//GEN-LAST:event_btnsaveActionPerformed
public void close(){
        WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
         }
    private void prntActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prntActionPerformed

            
        if(jtp.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "<html><h4><font color='red'>Cannot print empty receipt!</font></h4></html>");
            }
        
        else{
        try{
            jtp.print();
            close();
             Transfers.getObj().setVisible(true);
       
        }
        catch(java.awt.print.PrinterException e)
        {
            PrintStream format = System.err.format("Cannot print %s%n");
        }
            }

    }//GEN-LAST:event_prntActionPerformed
     
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
    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(() -> {
            new Transfers().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField amnt;
    private javax.swing.JTextField amnt1;
    private javax.swing.JButton btndetails;
    private javax.swing.JButton btnsave;
    private javax.swing.JTextField cost;
    private javax.swing.JTextField cost1;
    private javax.swing.JTextField id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
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
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jtp;
    private javax.swing.JComboBox<String> location;
    private javax.swing.JComboBox<String> location1;
    private javax.swing.JTextField penalty;
    private javax.swing.JButton prnt;
    private javax.swing.JPasswordField pwd;
    private javax.swing.JComboBox<String> size;
    private javax.swing.JComboBox<String> size1;
    private javax.swing.JComboBox<String> tfrom;
    private javax.swing.JLabel today;
    private javax.swing.JComboBox<String> tto;
    // End of variables declaration//GEN-END:variables
}

