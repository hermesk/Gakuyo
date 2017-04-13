
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.MessageFormat;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import net.proteanit.sql.DbUtils;


public class sales extends javax.swing.JFrame {
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    DecimalFormat df = new DecimalFormat("###.##");
    private static sales obj=null;

    private sales() {
        initComponents();
        conn = DbConnect.connecrDb();
         logo();
         user();
         branch();
    }
          public static sales getObj() {
        if (obj== null){
            obj = new sales();
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
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        sales_table = new javax.swing.JTable()

        {
            public boolean isCellEditable(int rowindex, int colIndex)
            { return false;}
        }

        ;
        jPanel1 = new javax.swing.JPanel();
        search_branch = new javax.swing.JComboBox<>();
        search_sales_branch = new javax.swing.JButton();
        servedby = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        search_sales = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        bfrom = new com.toedter.calendar.JDateChooser();
        bto = new com.toedter.calendar.JDateChooser();
        sfrom = new com.toedter.calendar.JDateChooser();
        sto = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        property = new javax.swing.JComboBox<>();
        ttype = new javax.swing.JComboBox<>();
        sfrm = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        st = new com.toedter.calendar.JDateChooser();
        salevdebt = new javax.swing.JButton();
        brsales = new javax.swing.JButton();
        print = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SALES REPORTS");
        setResizable(false);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/gakuyo.png"))); // NOI18N

        sales_table.setBorder(new javax.swing.border.MatteBorder(null));
        sales_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "", "", "", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(sales_table);

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        search_sales_branch.setText("SEARCH");
        search_sales_branch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_sales_branchActionPerformed(evt);
            }
        });

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("FILTER BY SERVED BY AND DATE");

        search_sales.setText("SEARCH");
        search_sales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_salesActionPerformed(evt);
            }
        });

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("FILTER BY BRANCH AND DATE");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("TO");

        jLabel5.setText("FROM");

        jLabel6.setText("TO");

        jLabel7.setText("FROM");

        bfrom.setDateFormatString("yyyy-MM-dd");

        bto.setDateFormatString("yyyy-MM-dd");

        sfrom.setDateFormatString("yyyy-MM-dd");

        sto.setDateFormatString("yyyy-MM-dd");

        jLabel8.setText("SALES VS DEBT COLLECTION");

        property.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "LAND", "HOUSE", "GZD" }));

        ttype.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sales", "Debt Collection" }));

        sfrm.setDateFormatString("yyyy-MM-dd");

        jLabel9.setText("FROM");

        jLabel10.setText("TO");

        st.setDateFormatString("yyyy-MM-dd");

        salevdebt.setText("Search");
        salevdebt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salevdebtActionPerformed(evt);
            }
        });

        brsales.setText("Generate");
        brsales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brsalesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(servedby, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(search_branch, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sfrom, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bfrom, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sto, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bto, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(search_sales_branch)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(brsales))
                            .addComponent(search_sales)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(property, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(ttype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sfrm, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(st, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(salevdebt))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(281, 281, 281)
                        .addComponent(jLabel8)))
                .addContainerGap(148, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {bto, st, sto});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {salevdebt, search_sales, search_sales_branch});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {bfrom, sfrm, sfrom});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {search_branch, servedby});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(search_branch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(bto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(search_sales_branch)
                            .addComponent(brsales)))
                    .addComponent(bfrom, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(servedby, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(sfrom, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(sto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(search_sales)
                        .addGap(3, 3, 3)))
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(property, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ttype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sfrm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(st, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(salevdebt))
                        .addGap(3, 3, 3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        print.setText("Print");
        print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(372, 372, 372)
                .addComponent(print)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(print)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 30, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(901, 650));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void search_sales_branchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_sales_branchActionPerformed
        if(((JTextField)bfrom.getDateEditor().getUiComponent()).getText().trim().isEmpty()||((JTextField)bto.getDateEditor().getUiComponent()).getText().trim().isEmpty())
                {
                    JOptionPane.showMessageDialog(null, "<html><font color='red'>Kindly Fill start date and end date</font></html>");
                   }
             else{
                            if(conn==null){
            JOptionPane.showMessageDialog(this, "Could not connect to the server");
        }       else {
                          
                   try{   
                         String start=((JTextField)bfrom.getDateEditor().getUiComponent()).getText().trim();
                      String end=((JTextField)bto.getDateEditor().getUiComponent()).getText().trim();
                         String check ="SELECT COUNT(*) AS total FROM  receipt where branch = '"+search_branch.getSelectedItem()+"' and (pdate>='"+start+"' and pdate<=('"+end+"'))"; 
                            pst=conn.prepareStatement(check);
                            rs = pst.executeQuery();
                          while(rs.next()){
                              DefaultTableModel model = (DefaultTableModel) sales_table.getModel();
                                model.setRowCount(0);
                              if(rs.getInt("total")>0){
                    String srecpt = "select pdate as 'Posting Date', servedby as 'Served By',amount as 'Amount', ptype as 'Payment Type' from receipt "
                            + "where branch = '"+search_branch.getSelectedItem()+"'and (pdate >='"+start+"' and pdate<=('"+end+"'))";  

                        pst = conn.prepareStatement(srecpt);
                        rs=pst.executeQuery();
                      
                       sales_table.setModel( DbUtils.resultSetToTableModel(rs));
                          fixWidth(sales_table, 0, 100);
                          fixWidth(sales_table, 1, 140);
                          fixWidth(sales_table, 2, 100);
                          fixWidth(sales_table, 3, 100);
                      getSum();
                         }else{
                           JOptionPane.showMessageDialog(null, "No Records Found On"+" "+search_branch.getSelectedItem()+ " Branch ");}}}                
           catch(SQLException e){
        JOptionPane.showMessageDialog(null, e);} 
             }
                      }
    }//GEN-LAST:event_search_sales_branchActionPerformed
    private void fixWidth(final JTable table, final int columnIndex, final int width) {
        TableColumn column = table.getColumnModel().getColumn(columnIndex);
        column.setMinWidth(width);
        column.setMaxWidth(width);
        column.setPreferredWidth(width);
    }
    private void search_salesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_salesActionPerformed
        if(((JTextField)sfrom.getDateEditor().getUiComponent()).getText().trim().isEmpty()||((JTextField)sto.getDateEditor().getUiComponent()).getText().trim().isEmpty())
                           {
                    JOptionPane.showMessageDialog(null, "<html><font color='red'>Kindly Fill start date and end date</font></html>");
                   }
          else{
                   if(conn==null){
            JOptionPane.showMessageDialog(this, "Could not connect to the server");
        }
                    else {
                   try{   
                         String start=((JTextField)sfrom.getDateEditor().getUiComponent()).getText().trim();
                      String end=((JTextField)sto.getDateEditor().getUiComponent()).getText().trim();  
                         String check ="SELECT COUNT(*) AS total FROM receipt where servedby= '"+servedby.getSelectedItem()+"'and (pdate>='"+start+"' and pdate<=('"+end+"'))"; 
                            pst=conn.prepareStatement(check);
                            rs = pst.executeQuery();
                          while(rs.next()){
                              DefaultTableModel model = (DefaultTableModel) sales_table.getModel();
                                model.setRowCount(0);
                              if(rs.getInt("total")>0){
                    String srecpt = "select pdate as 'Posting Date',ptype as 'Payment Type',amount as 'Amount' ,branch from receipt "
                            + "where servedby = '"+servedby.getSelectedItem()+"'and (pdate >='"+start+"' and pdate<=('"+end+"'))";  
                        pst = conn.prepareStatement(srecpt);
                        rs=pst.executeQuery();
                       sales_table.setModel( DbUtils.resultSetToTableModel(rs));
                          fixWidth(sales_table, 0, 100);
                          fixWidth(sales_table, 1, 140);
                          fixWidth(sales_table, 2, 100);
                          fixWidth(sales_table, 3, 100);
                      getSum();
                         }else{
                           JOptionPane.showMessageDialog(null, "No User  "+" "+servedby.getSelectedItem()+" ");

                              }}}                
           catch(SQLException e){
        JOptionPane.showMessageDialog(null, e);
    }   
    }  }                    
    }//GEN-LAST:event_search_salesActionPerformed

    private void salevdebtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salevdebtActionPerformed
        if(((JTextField)sfrm.getDateEditor().getUiComponent()).getText().trim().isEmpty()||((JTextField)st.getDateEditor().getUiComponent()).getText().trim().isEmpty())
                           {
                    JOptionPane.showMessageDialog(null, "<html><font color='red'>Kindly Fill start date and end date</font></html>");
                   }
         else{
                  if(conn==null){
            JOptionPane.showMessageDialog(this, "Could not connect to the server");
        }
          else{
        if (property.getSelectedItem() == "LAND"){
         if (ttype.getSelectedItem() == "Sales"){
            try{
                  String start=((JTextField)sfrm.getDateEditor().getUiComponent()).getText().trim();
                  String end=((JTextField)st.getDateEditor().getUiComponent()).getText().trim();
                  
               String check ="SELECT COUNT(*) AS total FROM land "
                       + "where (pdate>='"+start+"' and pdate<='"+end+"') and (ptype ='Deposit' or ptype ='Booking'or ptype='Full Amount') "; 
                            pst=conn.prepareStatement(check);
                            rs = pst.executeQuery();
                            
                                   while(rs.next()){
                            DefaultTableModel model = (DefaultTableModel) sales_table.getModel();
                                model.setRowCount(0);
                              if(rs.getInt("total")>0){
                                     
                    String sland = "select client_detail.name,land.id,land.amount,land.cost,"
                            + "land.size,land.pdate  as 'Posting Date' ,"
                            + "land.location,land.pmode as 'Payment Mode',land.ptype as 'Payment Type'from land,client_detail "
                            + " where (pdate>='"+start+"' and pdate<='"+end+"') and (land.ptype='Deposit' or land.ptype='Booking' or land.ptype ='Full Amount')"
                            + "and land.id =client_detail.id  ";
                            

                        pst = conn.prepareStatement(sland);
                        rs=pst.executeQuery();
                        
                        sales_table.setModel( DbUtils.resultSetToTableModel(rs));
                          fixWidth(sales_table, 0, 140);
                          fixWidth(sales_table, 1, 70);
                          fixWidth(sales_table, 2, 90);
                          fixWidth(sales_table, 3, 60);
                          fixWidth(sales_table, 4, 60);
                          fixWidth(sales_table, 5, 90);
                          fixWidth(sales_table, 6, 100);
                          getSum();
                         }
                        else{
                           JOptionPane.showMessageDialog(null, "no payments found");

                              }}
              }
                      catch(SQLException e){
        JOptionPane.showMessageDialog(null, e);
    }   
         }  
         if (ttype.getSelectedItem() == "Debt Collection"){
            try{
                  String start=((JTextField)sfrm.getDateEditor().getUiComponent()).getText().trim();
                  String end=((JTextField)st.getDateEditor().getUiComponent()).getText().trim();
                  
               String check ="SELECT COUNT(*) AS total FROM land where ptype ='Installments' and (pdate>='"+start+"' and pdate<='"+end+"')"; 
                            pst=conn.prepareStatement(check);
                            rs = pst.executeQuery();
                            
                                   while(rs.next()){
                            
                              if(rs.getInt("total")>0){
                                     
                    String sland = "select client_detail.name,land.id,land.amount,land.cost,"
                            + "land.size,land.pdate  as 'Posting Date' ,"
                            + "land.location,land.pmode as 'Payment Mode',land.ptype as 'Payment Type'from land,client_detail "
                            + " where land.ptype='Installments' and (pdate>='"+start+"' and pdate<='"+end+"')and land.id =client_detail.id  ";

                        pst = conn.prepareStatement(sland);
                        rs=pst.executeQuery();
                        
                        sales_table.setModel( DbUtils.resultSetToTableModel(rs));
                          fixWidth(sales_table, 0, 140);
                          fixWidth(sales_table, 1, 70);
                          fixWidth(sales_table, 2, 60);
                          fixWidth(sales_table, 3, 60);
                          fixWidth(sales_table, 4, 60);
                          fixWidth(sales_table, 5, 90);
                          fixWidth(sales_table, 6, 100);
                          getSum();
                         }
                        else{
                           JOptionPane.showMessageDialog(null, "no payments found");

                              }}
              }
                      catch(SQLException e){
        JOptionPane.showMessageDialog(null, e);
    }   
         } 
    }
        else if (property.getSelectedItem() == "HOUSE"){
          if (ttype.getSelectedItem() == "Sales"){
            try{
                  String start=((JTextField)sfrm.getDateEditor().getUiComponent()).getText().trim();
                  String end=((JTextField)st.getDateEditor().getUiComponent()).getText().trim();
                  
               String check ="SELECT COUNT(*) AS total FROM house where (posting_date>='"+start+"' and posting_date<='"+end+"')and (payment_type = 'Deposit' or payment_type='Booking' or payment_type='Full Amount')"; 
                            pst=conn.prepareStatement(check);
                            rs = pst.executeQuery();
                            
                         while(rs.next()){
                              if(rs.getInt("total")>0){
                    String sland = "select client_detail.name,house.id,house.amount,house.cost,"
                            + "house.house_size,house.posting_date as 'Posting Date' ,"
                            + "house.location,house.payment_mode as 'Payment Mode' from house,client_detail "
                            + " where  house.id=client_detail.id  and (house.payment_type = 'Deposit' or house.payment_type='Booking' or house.payment_type='Full Amount') and (posting_date>='"+start+"' and posting_date<='"+end+"')";

                        pst = conn.prepareStatement(sland);
                        rs=pst.executeQuery();
                        
                        sales_table.setModel( DbUtils.resultSetToTableModel(rs));
                          fixWidth(sales_table, 0, 180);
                          fixWidth(sales_table, 1, 70);
                          fixWidth(sales_table, 2, 90);
                          fixWidth(sales_table, 3, 60);
                          fixWidth(sales_table, 4, 80);
                          fixWidth(sales_table, 5, 90);
                          fixWidth(sales_table, 6, 80);
                          fixWidth(sales_table, 7, 100);
                          getSum();
                         }
                        else{
                           JOptionPane.showMessageDialog(null, "no payments found");

                              }}
              }
                      catch(SQLException e){
        JOptionPane.showMessageDialog(null, e);
    }   
          }
          else if (ttype.getSelectedItem() == "Debt Collection"){
            try{
                  String start=((JTextField)sfrm.getDateEditor().getUiComponent()).getText().trim();
                  String end=((JTextField)st.getDateEditor().getUiComponent()).getText().trim();
                  
               String check ="SELECT COUNT(*) AS total FROM house where payment_type = 'Installment' and (posting_date>='"+start+"' and posting_date<='"+end+"')"; 
                            pst=conn.prepareStatement(check);
                            rs = pst.executeQuery();
                            
                         while(rs.next()){
                       
                              if(rs.getInt("total")>0){
                                  
                    String sland = "select client_detail.name,house.id,house.amount,house.cost,"
                            + "house.house_size,house.posting_date as 'Posting Date' ,"
                            + "house.location,house.payment_mode as 'Payment Mode' from house,client_detail "
                            + " where house.id=client_detail.id  and house.payment_type = 'Installment'"
                            + " and (posting_date>='"+start+"' and posting_date<='"+end+"') and client_detail=house.id";

                        pst = conn.prepareStatement(sland);
                        rs=pst.executeQuery();
                        
                        sales_table.setModel( DbUtils.resultSetToTableModel(rs));
                          fixWidth(sales_table, 0, 180);
                          fixWidth(sales_table, 1, 70);
                          fixWidth(sales_table, 2, 90);
                          fixWidth(sales_table, 3, 60);
                          fixWidth(sales_table, 4, 80);
                          fixWidth(sales_table, 5, 90);
                          fixWidth(sales_table, 6, 80);
                          fixWidth(sales_table, 7, 100);
                          getSum();
                         }
                        else{
                           JOptionPane.showMessageDialog(null, "no payments found");

                              }}
              }
                      catch(SQLException e){
        JOptionPane.showMessageDialog(null, e);
    }   
          }
      }
        else if (property.getSelectedItem() == "GZD"){
            if (ttype.getSelectedItem() == "Sales"){
            try{
                  String start=((JTextField)sfrm.getDateEditor().getUiComponent()).getText().trim();
                  String end=((JTextField)st.getDateEditor().getUiComponent()).getText().trim();
                  
               String check ="SELECT COUNT(*) AS total FROM gakuyo_zero_deposit where (posting_date>='"+start+"' and posting_date<='"+end+"') and (ptype = 'Deposit' or ptype='Booking' or ptype='Full Amount')"; 
                            pst=conn.prepareStatement(check);
                            rs = pst.executeQuery();
                            
                         while(rs.next()){
                       
                              if(rs.getInt("total")>0){
                                         
                    String sland = "select gakuyo_zero_deposit.id,client_detail.name,gakuyo_zero_deposit.amount,gakuyo_zero_deposit.ptype,"
                            + "gakuyo_zero_deposit.type_of_house,gakuyo_zero_deposit.posting_date as 'Posting Date' ,"
                            + "gakuyo_zero_deposit.payment_mode as 'Payment Mode' from gakuyo_zero_deposit,client_detail "
                            + " where gakuyo_zero_deposit.id=client_detail.id  and (gakuyo_zero_deposit.ptype='Deposit' or"
                            + " gakuyo_zero_deposit.ptype='Booking'or gakuyo_zero_deposit.ptype='Full Amount') and (posting_date>='"+start+"' and posting_date<='"+end+"')";

                        pst = conn.prepareStatement(sland);
                        rs=pst.executeQuery();
                        
                        sales_table.setModel( DbUtils.resultSetToTableModel(rs));
                          fixWidth(sales_table, 0, 100);
                          fixWidth(sales_table, 1, 200);
                          fixWidth(sales_table, 2, 100);
                          fixWidth(sales_table, 3, 110);
                          fixWidth(sales_table, 4, 100);
                          fixWidth(sales_table, 5, 100);
                          fixWidth(sales_table, 6, 100);
                          getSum();
                         }
                        else{
                           JOptionPane.showMessageDialog(null, "no payments found");

                              }}
              }
                      catch(SQLException e){
        JOptionPane.showMessageDialog(null, e);
    }  }
            else if (ttype.getSelectedItem() == "Debt Collection"){
            try{
                  String start=((JTextField)sfrm.getDateEditor().getUiComponent()).getText().trim();
                  String end=((JTextField)st.getDateEditor().getUiComponent()).getText().trim();
                  
               String check ="SELECT COUNT(*) AS total FROM gakuyo_zero_deposit where (posting_date>='"+start+"' and posting_date<='"+end+"') and (ptype = 'Installments')"; 
                            pst=conn.prepareStatement(check);
                            rs = pst.executeQuery();
                            
                         while(rs.next()){
                       
                              if(rs.getInt("total")>0){
                                  
                          
                                         
                    String sland = "select gakuyo_zero_deposit.id,client_detail.name,gakuyo_zero_deposit.amount,gakuyo_zero_deposit.ptype,"
                            + "gakuyo_zero_deposit.type_of_house,gakuyo_zero_deposit.posting_date as 'Posting Date' ,"
                            + "gakuyo_zero_deposit.payment_mode as 'Payment Mode' from gakuyo_zero_deposit,client_detail "
                            + " where gakuyo_zero_deposit.id=client_detail.id  and (gakuyo_zero_deposit.ptype='Installments') and (posting_date>='"+start+"' and posting_date<='"+end+"')";

                        pst = conn.prepareStatement(sland);
                        rs=pst.executeQuery();
                        
                        sales_table.setModel( DbUtils.resultSetToTableModel(rs));
                          fixWidth(sales_table, 0, 100);
                          fixWidth(sales_table, 1, 200);
                          fixWidth(sales_table, 2, 100);
                          fixWidth(sales_table, 3, 110);
                          fixWidth(sales_table, 4, 100);
                          fixWidth(sales_table, 5, 100);
                          fixWidth(sales_table, 6, 100);
                          getSum();
                         }
                        else{
                           JOptionPane.showMessageDialog(null, "no payments found");

                              }}
              }
                      catch(SQLException e){
        JOptionPane.showMessageDialog(null, e);
    }  
            }
            
   
      }}
         }
    }//GEN-LAST:event_salevdebtActionPerformed

    private void printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printActionPerformed
       if(sales_table != null && sales_table.getModel() != null){
           
      JCheckBox fitWidthBox = new JCheckBox("Fit width to printed page", true);
        MessageFormat header = new MessageFormat("");
        MessageFormat footer = new MessageFormat("Page{0,number,integer}");

        boolean fitWidth = fitWidthBox.isSelected();

        try{
            
            JTable.PrintMode mode = fitWidth ? JTable.PrintMode.FIT_WIDTH
            : JTable.PrintMode.NORMAL;
            sales_table.print(mode,header,footer);
        }
        catch(java.awt.print.PrinterException e)
        {
            PrintStream format = System.err.format("Cannot print %s%n");
        }
                
            }
       else{
           JOptionPane.showMessageDialog(null, "Cannot print empty statement");
        }
    }//GEN-LAST:event_printActionPerformed

    private void brsalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brsalesActionPerformed
        
        
    }//GEN-LAST:event_brsalesActionPerformed
     public void toExcel(JTable sales_table, File file){
               
                    try (FileWriter excel = new FileWriter(file)) {
                        for(int i = 0; i < sales_table.getColumnCount(); i++){
                            excel.write(sales_table.getColumnName(i) + "\t");
                                               }
                          excel.write("\n");
                       
                          for(int i=0; i< sales_table.getRowCount(); i++) {
                            for(int j=0; j < sales_table.getColumnCount(); j++) {
                            excel.write(sales_table.getValueAt(i,j).toString()+"\t");                           

                            }
                           excel.write("\n");
                        }
                    

                }catch(IOException e){ 
                 JOptionPane.showMessageDialog(null,e);
 }}
    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(() -> {
            new sales().setVisible(true);
        });
    }
    public double getSum(){
         
         DefaultTableModel model = (DefaultTableModel)sales_table.getModel();
         DecimalFormat dft = new DecimalFormat("##,##,##,##,##,##,##0.00");
       int amnt=0;
     
        for(int i=0;i<sales_table.getRowCount();i++)
           {
            String d= sales_table.getValueAt(i, 2).toString();
            double nt=Double.parseDouble(d);
            amnt+=nt;          
            }
         
         int dt= sales_table.getRowCount();
          String str = dft.format(amnt);
          String mytt ="<html><b>Total("+dt+")<b></html>";
          String mytamnt ="<html><b><u>"+str+" </u></b></html>"+""; 
          
             Object[] row = {mytt ,"",mytamnt,"",""};
                model.addRow(row);
        return amnt;
    }
     private void branch(){
   if(conn==null){
            JOptionPane.showMessageDialog(this, "Could not connect to the server");
        }
         else{
         try{
         String sql = "select DISTINCT branch from receipt where branch IS NOT NULL";
         pst = conn.prepareStatement(sql);
         rs =pst.executeQuery();
         while(rs.next()){
          String pbk = rs.getString("branch");         
          search_branch.addItem(pbk);
          
                  }
       }
          
     catch(SQLException e)
     {
                 JOptionPane.showMessageDialog(null, e);
    }
                 } }
      private void user(){
      if(conn==null){
            JOptionPane.showMessageDialog(this, "Could not connect to the server");
        }
      else{
          try{
         String sql = "select DISTINCT servedby from receipt where servedby IS NOT NULL ";
         pst = conn.prepareStatement(sql);
         rs =pst.executeQuery();
         while(rs.next()){
          String pbk = rs.getString("servedby");         
          servedby.addItem(pbk);
          
                  }
       }
          
     catch(SQLException e)
     {
                 JOptionPane.showMessageDialog(null, e);
    }
          
      }}
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser bfrom;
    private javax.swing.JButton brsales;
    private com.toedter.calendar.JDateChooser bto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton print;
    private javax.swing.JComboBox<String> property;
    private javax.swing.JTable sales_table;
    private javax.swing.JButton salevdebt;
    private javax.swing.JComboBox<String> search_branch;
    private javax.swing.JButton search_sales;
    private javax.swing.JButton search_sales_branch;
    private javax.swing.JComboBox<String> servedby;
    private com.toedter.calendar.JDateChooser sfrm;
    private com.toedter.calendar.JDateChooser sfrom;
    private com.toedter.calendar.JDateChooser st;
    private com.toedter.calendar.JDateChooser sto;
    private javax.swing.JComboBox<String> ttype;
    // End of variables declaration//GEN-END:variables
}
