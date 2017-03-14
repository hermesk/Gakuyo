
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
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class land extends javax.swing.JFrame  {

    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
      private static land obj=null;

 AtomicInteger seq = new AtomicInteger();
int nextVal = seq.incrementAndGet();

            
             //current date
       DateFormat dF = new SimpleDateFormat("yyyy-MM-dd");
       Date date = new Date();
      String td=dF.format(date);
     
       
   land() {
        initComponents();
        conn = DbConnect.connecrDb();
        ComboPmode();
        ProperyDetails();
        Current_Date();
         logo();
        
         
    }
       public static land getObj() {
        if (obj== null){
            obj = new land();
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

    private void display() {
   
    if(conn==null){
            JOptionPane.showMessageDialog(this, "Could not connect to the server");
        }
        else{
        

        try {
            String searchld = "select * from land where land.id=? ";

            pst = conn.prepareStatement(searchld );
            pst.setString(1, id.getText());
            rs = pst.executeQuery();

            if (rs.next()) {
                  String d =rs.getString("discount");
                location.setSelectedItem(rs.getString("location"));
                cost.setText(rs.getString("cost"));
                plotno.setSelectedItem(rs.getString("plot_no"));
                size.setSelectedItem(rs.getString("size"));
                location.setEnabled(true);
                discount.setEnabled(false);
                cost.setEnabled(false);
                
                size.setEnabled(false);
                if("0".equals(d)){
                disc.setSelectedItem("NO");
                discount.setText(d);
                disc.setEnabled(false);
                }
                else{
                disc.setSelectedItem("YES");
                discount.setText("YES");
                disc.setEnabled(false);
                }
                
               
                
                
            } else {
                JOptionPane.showMessageDialog(null, "No Land Payments Found For Client ID" + " " + id.getText());
                
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
            String searchld = "select client_detail.name,land.location,land.cost,land.plot_no,land.size from client_detail,land "
                    + "where land.id=client_detail.id and land.plot_no=? and land.location='"+location1.getSelectedItem()+"' ";

            pst = conn.prepareStatement(searchld );
            pst.setString(1, sbyplotno.getText());
            rs = pst.executeQuery();

            if (rs.next()) {
                plotno.removeAllItems();
                plotno.addItem(sbyplotno.getText().toString());
                location.setSelectedItem(rs.getString("location"));
                cost.setText(rs.getString("cost"));
               
                size.setSelectedItem(rs.getString("size"));
                location.setEnabled(true);
                cost.setEnabled(false);
                plotno.setEnabled(true);
                size.setEnabled(false);
                cname.setText(rs.getString("name"));
                cname.setEnabled(false);
            } else {
                JOptionPane.showMessageDialog(null, "No Land Payments Found For plot no" + " " + sbyplotno.getText());
                
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
 
       }
    }

    private void ComboPmode() {
     
     if(conn==null){
            JOptionPane.showMessageDialog(this, "Could not connect to the server");
        }
        else{
        try {
            String sql = "select *from payment_mode";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                String paymode = rs.getString("mode");
                pmode.addItem(paymode);
                String dbt = rs.getString("debit");
                account.addItem(dbt);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
  
    }}

    private void ProperyDetails() {
    if(conn==null){
            JOptionPane.showMessageDialog(this, "Could not connect to the server");
        }
    else{
        try {
            String sql = "select *from property_location ";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
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
        } catch (SQLException e) {
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
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        id = new javax.swing.JTextField();
        location = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        pmode = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        pdetails = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        size = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        ptype = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        refno = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        account = new javax.swing.JComboBox<>();
        save = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        current_date = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        pwd = new javax.swing.JPasswordField();
        tdate = new com.toedter.calendar.JDateChooser();
        cname = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        sbyplotno = new javax.swing.JTextField();
        Search = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        amount = new javax.swing.JFormattedTextField();
        cost = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        disc = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        discount = new javax.swing.JFormattedTextField();
        plotno = new javax.swing.JComboBox<>();
        location1 = new javax.swing.JComboBox<>();
        jtp2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtp = new javax.swing.JTextPane();
        print_receipt = new javax.swing.JButton();

        jTextField1.setText("jTextField1");

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
        setTitle("LAND PAYMENT SECTION");

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/gakuyo.png"))); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("LAND PAYMENT SECTION"));

        jLabel2.setText("Search by ID");

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

        jLabel14.setText("LOCATION");

        jLabel11.setText("PAYMENT MODE");

        pmode.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                pmodeFocusLost(evt);
            }
        });

        jLabel13.setText("PLOT NO");

        pdetails.setText("Get Details");
        pdetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pdetailsActionPerformed(evt);
            }
        });

        jLabel9.setText("COST");

        jLabel15.setText("SIZE");

        jLabel5.setText("PAYMENT TYPE");

        jLabel12.setText("REF NO");

        refno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refnoActionPerformed(evt);
            }
        });
        refno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                refnoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                refnoKeyTyped(evt);
            }
        });

        jLabel7.setText("ACC/DEBIT");

        save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Save-icon.png"))); // NOI18N
        save.setText("SAVE");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        jLabel10.setText("TRANSACTION DATE");

        current_date.setText("Date");

        jLabel3.setText("AMOUNT");

        jLabel4.setText("PASSWORD");

        pwd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pwdActionPerformed(evt);
            }
        });

        tdate.setDateFormatString("yyyy-MM-dd");

        cname.setText("client name");
        cname.setEditable(false);

        jLabel6.setText("Search by Plot no");

        Search.setText("Search");
        Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchActionPerformed(evt);
            }
        });

        jButton1.setText("CLEAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        amount.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        amount.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                amountFocusLost(evt);
            }
        });
        amount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                amountKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                amountKeyTyped(evt);
            }
        });

        cost.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        cost.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                costKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                costKeyTyped(evt);
            }
        });

        jLabel8.setText("DISCOUNTED");

        disc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "YES", "NO" }));
        disc.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                discFocusLost(evt);
            }
        });
        disc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                discActionPerformed(evt);
            }
        });

        jLabel16.setText("Discount  Amount");

        discount.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));

        plotno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NO" }));

        location1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                location1FocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(current_date)
                .addGap(309, 309, 309))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(236, 236, 236)
                        .addComponent(pdetails, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(tdate, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cname, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(location, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel6))
                                .addGap(23, 23, 23)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(sbyplotno, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(id, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(pmode, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(amount, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(refno, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(disc, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel7)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel16)
                            .addComponent(jLabel5)
                            .addComponent(location1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Search)
                            .addComponent(size, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cost, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ptype, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(account, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(plotno, javax.swing.GroupLayout.Alignment.LEADING, 0, 119, Short.MAX_VALUE)
                                .addComponent(discount, javax.swing.GroupLayout.Alignment.LEADING))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(save, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pwd, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(123, 123, 123)))
                .addContainerGap(117, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(current_date)
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(pdetails)
                        .addComponent(jLabel10))
                    .addComponent(tdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(sbyplotno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Search)
                    .addComponent(location1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(location, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(size, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(pmode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(cost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(amount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(ptype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(account, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)
                            .addComponent(refno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(disc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(discount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(plotno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(pwd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(save)
                    .addComponent(jButton1))
                .addGap(35, 35, 35))
        );

        jtp.setEditable(false);
        jtp.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jScrollPane1.setViewportView(jtp);

        javax.swing.GroupLayout jtp2Layout = new javax.swing.GroupLayout(jtp2);
        jtp2.setLayout(jtp2Layout);
        jtp2Layout.setHorizontalGroup(
            jtp2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jtp2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
                .addContainerGap())
        );
        jtp2Layout.setVerticalGroup(
            jtp2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jtp2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(286, 286, 286)
                                .addComponent(print_receipt))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jtp2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(58, 58, 58))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jtp2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(print_receipt))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleName("land");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
   
        if(id.getText().isEmpty()||((JTextField)tdate.getDateEditor().getUiComponent()).getText().isEmpty()||amount.getText().isEmpty()||refno.getText().isEmpty()||pwd.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "<html><h4><font color='red'>Kindly Fill all the fields Correctly!</font></h4></html>");
        int a = Integer.parseInt(cost.getText().replaceAll(",",""));
        int b = Integer.parseInt(amount.getText().replaceAll(",",""));  
        if (b>a){
        JOptionPane.showMessageDialog(null,"Amount being paid cannot exceed total cost");
        }
        }
       else if(!jtp.getText().isEmpty())
       {
        JOptionPane.showMessageDialog(null,"Print current receipt");
        }
       
       else if(pwd.getText().isEmpty()){
               JOptionPane.showMessageDialog(null,"Kindly Input Your Password ");
                  }
         else{
               if (!pwd.getText().isEmpty()){
                    conn = DbConnect.connecrDb();
                  if(conn==null){
            JOptionPane.showMessageDialog(this, "Could not connect to the server");
        }
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
            String searchrefno = "SELECT COUNT(*) AS total FROM [land] where ref_no =?";
            pst=conn.prepareStatement(searchrefno);
            pst.setString(1,  refno.getText().trim());
            rs = pst.executeQuery();
           
            while(rs.next()){
             if(rs.getInt("total")<1){/////
                
                //calculating total plot cost
                int pcost = Integer.parseInt(cost.getText().trim().replaceAll(",",""));
                String check = "SELECT COUNT(*) AS total FROM land where id = '" + id.getText() + "'";
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
         //new receipt number
           String receiptno = "GRELD"+n; 

                    String searchclient = "select COUNT(*) AS total,sum(amount) from land where id=?";
                         pst=conn.prepareStatement(searchclient);
                         pst.setString(1, id.getText());
                         rs=pst.executeQuery();
                         
                  while(rs.next()){     
                          if(rs.getInt("total")<1){
                          String amntpd = rs.getString(1);
                         
                          String land = "insert into land(ref_no,id,amount,cost,size,pdate,tdate,location,pmode,debitacc,ptype,plot_no,discount,balance,receiptno,servedby)"
                                    + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

                            pst = conn.prepareStatement(land);
                            pst.setString(1, refno.getText().trim());
                            pst.setString(2, id.getText().trim());
                            pst.setString(3, amount.getText().trim().replaceAll(",",""));
                            pst.setString(4, String.valueOf(pcost));
                            pst.setString(5, size.getSelectedItem().toString());
                            pst.setString(6, td);
                            pst.setString(7, ((JTextField) tdate.getDateEditor().getUiComponent()).getText().trim());
                            pst.setString(8, location.getSelectedItem().toString());
                            pst.setString(9, pmode.getSelectedItem().toString());
                            pst.setString(10, account.getSelectedItem().toString());
                            pst.setString(11, ptype.getSelectedItem().toString());
                            pst.setString(12, plotno.getSelectedItem().toString());
                            pst.setString(13, discount.getText().replaceAll(",",""));
                            //initial bal
                            int amnt = Integer.parseInt(amount.getText().trim().replaceAll(",",""));
                            int pdamnt = Integer.parseInt(amntpd);
                            int currentbal = pcost - ( pdamnt+amnt);

                            pst.setString(14, String.valueOf(currentbal));
                            pst.setString(15, String.valueOf(receiptno));   
                            pst.setString(16, uname);
                            pst.execute();
                          
                            //display receipt in jtp
                  
                       
                    int nm = Integer.parseInt(amount.getText().replaceAll(",",""));
                    String Englishword = EnglishNumber(nm);
                    String amntw = " " + Englishword+ " "+"Kenya Shillings Only";
                    
                    String transactionDate=((JTextField)tdate.getDateEditor().getUiComponent()).getText();
                    String Size_of_land= size.getSelectedItem().toString();
                    String Deposit_Type= ptype.getSelectedItem().toString();
                    String Payment_mode=pmode.getSelectedItem().toString();
                    String Amount=amount.getText();
                    String Amountw=String.valueOf(amntw);
                    String sg = ".............";
                    String Deposited="..................";
                    String servedby=" ";
                    String ttl="\t\t\tLAND PAYMENTS ";
                  
                    StyledDocument doc = (StyledDocument) jtp.getDocument();
                    Style style = doc.addStyle("Tahoma", null);
                    StyleConstants.setFontSize(style, 12);
                    jtp.setPage(getClass().getResource("logo.html"));
                    jtp.getStyledDocument().insertString(1, ttl+"\nBranch"+" "+branch+" . "+ " "+"Date Of Posting"+" "+td+  " . "+ " "+"Transaction Date"+"  "+transactionDate+". "+" "+"\nClient Name\t\t\t\t"+name+
                            "\nReceiptNo\t\t\t\t"+receiptno+"\nSize Of Land\t\t\t\t"
                            +Size_of_land+"\nType Of Payment\t\t\t"+Deposit_Type+"\nMode Of Payment\t\t\t"+Payment_mode+"\nAmount\t\t\t\t"+Amount+ "\nAmount in Words:"+Amountw+"\nDepositedBy:"+Deposited+""
                                    + "Client Signature:"+sg+"Served by"+servedby+""+uname+"\n\t\t Where Trust Meets Your Vision",style);
                
                     //save in receipt table
                    
                     String landrct = "insert into receipt(cname,pdate,tdate,pmode,amount,receiptno,servedby,ptype,branch,client_id,rno)"
                        + "values(?,?,?,?,?,?,?,?,?,?,?)";
                     
                    pst = conn.prepareStatement(landrct);
                    
                    pst.setString(1,name);
                    pst.setString(2, td);
                    pst.setString(3, ((JTextField)tdate.getDateEditor().getUiComponent()).getText().trim());
                    pst.setString(4, pmode.getSelectedItem().toString());
                    pst.setString(5, amount.getText().trim().replaceAll(",",""));
                    pst.setString(6, String.valueOf(receiptno));
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
                       //save in land
                         
                            String land = "insert into land(ref_no,id,amount,cost,size,pdate,tdate,location,pmode,"
                                    + "debitacc,ptype,plot_no,discount,balance,receiptno,servedby)"
                                    + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

                            pst = conn.prepareStatement(land);
                            pst.setString(1, refno.getText().trim());
                            pst.setString(2, id.getText().trim());
                            pst.setString(3, amount.getText().trim().replaceAll(",",""));
                            pst.setString(4, String.valueOf(pcost));
                            pst.setString(5, size.getSelectedItem().toString());
                            pst.setString(6, td);
                            pst.setString(7, ((JTextField) tdate.getDateEditor().getUiComponent()).getText().trim());
                            pst.setString(8, location.getSelectedItem().toString());
                            pst.setString(9, pmode.getSelectedItem().toString());
                            pst.setString(10, account.getSelectedItem().toString());
                            pst.setString(11, ptype.getSelectedItem().toString());
                            pst.setString(12, plotno.getSelectedItem().toString());
                            pst.setString(13, discount.getText().replaceAll(",",""));

                            //initial bal
                            int amnt = Integer.parseInt(amount.getText().trim().replaceAll(",",""));
                            int initialbal = pcost - amnt;

                            pst.setString(14, String.valueOf(initialbal));
                            pst.setString(15, String.valueOf(receiptno)); 
                            pst.setString(16, uname);
                            pst.execute();
                               
                        //display receipt in jtp
                  
                       
                    int nm = Integer.parseInt(amount.getText().replaceAll(",",""));
                    String Englishword = EnglishNumber(nm);
                    String amntw = " " + Englishword+ " "+"Kenya Shillings Only";
                    
                    String transactionDate=((JTextField)tdate.getDateEditor().getUiComponent()).getText();
                    String Size_of_land= size.getSelectedItem().toString();
                    String Deposit_Type= ptype.getSelectedItem().toString();
                    String Payment_mode=pmode.getSelectedItem().toString();
                    String Amount=amount.getText();
                    String Amountw=String.valueOf(amntw);
                    String sg = ".............";
                    String Deposited="..................";
                    String servedby=" ";
                    String ttl="\t\t\tLAND PAYMENTS ";
                  
                    StyledDocument doc = (StyledDocument) jtp.getDocument();
                    Style style = doc.addStyle("Tahoma", null);
                    StyleConstants.setFontSize(style, 11);
                    jtp.setPage(getClass().getResource("logo.html"));
                    jtp.getStyledDocument().insertString(1, ttl+"\nBranch"+" "+branch+" . "+ " "+"Date Of Posting"+" "+td+  " . "+ " "+"Transaction Date"+"  "+transactionDate+". "+" "+"\nClient Name\t\t\t\t"+name+
                            "\nReceiptNo\t\t\t\t"+receiptno+"\nSize Of Land\t\t\t\t"
                            +Size_of_land+"\nType Of Payment\t\t\t"+Deposit_Type+"\nMode Of Payment\t\t\t"+Payment_mode+"\nAmount\t\t\t\t"+Amount+ "\nAmount in Words:"+Amountw+"\nDepositedBy:"+Deposited+""
                                    + "Client Signature:"+sg+"Served by"+servedby+""+uname+"\n\t\t Where Trust Meets Your Vision",style);
                
                     //save in receipt table
                   
                     String landrct = "insert into receipt(cname,pdate,tdate,pmode,amount,receiptno,servedby,ptype,branch,client_id,rno)"
                        + "values(?,?,?,?,?,?,?,?,?,?,?)";
                     
                    pst = conn.prepareStatement(landrct);
                    
                    pst.setString(1,name);
                    pst.setString(2, td);
                    pst.setString(3, ((JTextField)tdate.getDateEditor().getUiComponent()).getText().trim());
                    pst.setString(4, pmode.getSelectedItem().toString());
                    pst.setString(5, amount.getText().trim().replaceAll(",",""));
                    pst.setString(6, String.valueOf(receiptno));
                    pst.setString(7,uname);
                    pst.setString(8, ptype.getSelectedItem().toString());
                    pst.setString(9, branch);
                    pst.setString(10,id.getText().trim());
                    pst.setString(11,String.valueOf(n)); //increment receipt numbers
                    pst.execute();
                  
                    updateplotno();//update plot numbers
             
                 
         JOptionPane.showMessageDialog(null, "Saved");
              
                    }}
                }
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
            }}
                catch (SQLException ex) {
                      Logger.getLogger(land.class.getName()).log(Level.SEVERE, null, ex);
        }          catch (IOException ex) {
                       Logger.getLogger(land.class.getName()).log(Level.SEVERE, null, ex);
                   } catch (BadLocationException ex) {
                       Logger.getLogger(land.class.getName()).log(Level.SEVERE, null, ex);
                   }
 
               }  }
    }//GEN-LAST:event_saveActionPerformed

    private void pdetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pdetailsActionPerformed
        if (id.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Enter ID number");
        } 
       else if(id.getText().length()!=8){
            JOptionPane.showMessageDialog(null, "ID must be 8 digits");
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
            
    }//GEN-LAST:event_pdetailsActionPerformed
 public void close(){
        WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
         }
   
    private void print_receiptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_print_receiptActionPerformed
        if(jtp.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "<html><h4><font color='red'>Cannot print empty receipt!</font></h4></html>");
            }
        
        else{
        try{
            jtp.print();
            close();
            land l = new land();
            l.setVisible(true);
        }
        catch(java.awt.print.PrinterException e)
        {
            PrintStream format = System.err.format("Cannot print %s%n");
        }
            }
    }//GEN-LAST:event_print_receiptActionPerformed

    private void refnoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_refnoKeyTyped
    char c=evt.getKeyChar();
        if(!(Character.isAlphabetic(c) ||  (c==KeyEvent.VK_BACK_SPACE)||  c==KeyEvent.VK_DELETE ||Character.isDigit(c))){
        evt.consume();
        getToolkit().beep();}
    }//GEN-LAST:event_refnoKeyTyped

    private void idKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_idKeyTyped
    char c=evt.getKeyChar();
        if(!(Character.isAlphabetic(c) ||  (c==KeyEvent.VK_BACK_SPACE)||  c==KeyEvent.VK_DELETE ||Character.isDigit(c))){
        evt.consume();
        getToolkit().beep();}
    }//GEN-LAST:event_idKeyTyped

    private void SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchActionPerformed
         if (sbyplotno.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Enter plot number");
        } 
        else { 
          displayptno(); 
        } 
             
        
    }//GEN-LAST:event_SearchActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         id.setText("");
         pwd.setText("");
         amount.setText("");
         amount.setText("");
         refno.setText("");
        // plotno.setSelectedItem("");
         sbyplotno.setText("");
         cname.setText("");
         location.setEnabled(true);
         size.setEnabled(true);
                 // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void pwdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pwdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pwdActionPerformed

    private void amountKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_amountKeyTyped
       char c = evt.getKeyChar();
        if (!(Character.isDigit(c)
                || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE || evt.getKeyChar() == '.')) {
            evt.consume();
            getToolkit().beep();
        }    }//GEN-LAST:event_amountKeyTyped

    private void costKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_costKeyTyped
       char c = evt.getKeyChar();
        if (!(Character.isDigit(c)
                || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE || evt.getKeyChar() == '.')) {
            evt.consume();
            getToolkit().beep();
        }    }//GEN-LAST:event_costKeyTyped

    private void refnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_refnoActionPerformed

    private void discFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_discFocusLost

        if(disc.getSelectedItem()=="NO"){
          discount.setText("0");
          discount.setEnabled(false);
        }
        else{
        discount.setEnabled(true);
        }
    }//GEN-LAST:event_discFocusLost

    private void discActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_discActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_discActionPerformed

    private void locationFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_locationFocusLost
        plotno.removeAllItems();
        plotno.addItem("NO");
        plotnos();
        
        
    }//GEN-LAST:event_locationFocusLost

    private void refnoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_refnoKeyReleased
      }//GEN-LAST:event_refnoKeyReleased

    private void costKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_costKeyReleased
    }//GEN-LAST:event_costKeyReleased

    private void amountKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_amountKeyReleased
                    
                 }//GEN-LAST:event_amountKeyReleased

    private void amountFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_amountFocusLost
       
    }//GEN-LAST:event_amountFocusLost

    private void location1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_location1FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_location1FocusLost

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
       
    }//GEN-LAST:event_locationMouseClicked
                                     
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
            java.util.logging.Logger.getLogger(land.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(land.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(land.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(land.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new land().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Search;
    private javax.swing.JComboBox<String> account;
    private javax.swing.JFormattedTextField amount;
    public static javax.swing.JTextField cname;
    private javax.swing.JFormattedTextField cost;
    private javax.swing.JLabel current_date;
    private javax.swing.JComboBox<String> disc;
    private javax.swing.JFormattedTextField discount;
    public static javax.swing.JTextField id;
    private javax.swing.JButton jButton1;
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
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextPane jtp;
    private javax.swing.JPanel jtp2;
    private javax.swing.JComboBox<String> location;
    private javax.swing.JComboBox<String> location1;
    private javax.swing.JButton pdetails;
    private javax.swing.JComboBox<String> plotno;
    private javax.swing.JComboBox<String> pmode;
    private javax.swing.JButton print_receipt;
    private javax.swing.JComboBox<String> ptype;
    private javax.swing.JPasswordField pwd;
    private javax.swing.JTextField refno;
    private javax.swing.JButton save;
    private javax.swing.JTextField sbyplotno;
    private javax.swing.JComboBox<String> size;
    private com.toedter.calendar.JDateChooser tdate;
    // End of variables declaration//GEN-END:variables
}
