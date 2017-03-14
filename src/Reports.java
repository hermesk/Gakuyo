
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import net.proteanit.sql.DbUtils;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

public class Reports extends javax.swing.JFrame {

    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
  private static Reports obj=null;
  
    private Reports() {
        initComponents();
        conn = DbConnect.connecrDb();
        ProperyDetails();
        setResizable(false);
        logo();
    }
     public static Reports getObj() {
       if (obj== null){
         obj = new Reports();
        }
        else{
         obj.setExtendedState(JFrame.NORMAL);
         obj.setAlwaysOnTop(true);
         obj.requestFocus();
       }return obj;
}
    
    private void logo(){
    setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("images/LOG.png")));
    }


      private void ProperyDetails(){
          conn = DbConnect.connecrDb();
        if(conn==null){
            JOptionPane.showMessageDialog(this, "Could not connect to the server");
        }
        else{
          try{
         String sql = "select *from property_location";
         pst = conn.prepareStatement(sql);
         rs =pst.executeQuery();
         while(rs.next()){
          String lctn = rs.getString("location");         
          location.addItem(lctn);
         
                  }
       }
     catch(SQLException e)
     {
         
         JOptionPane.showMessageDialog(null, e);
    }
                                   
        }}
      
        public double getSum(){
         
         DefaultTableModel model = (DefaultTableModel)stmnt_table.getModel();
         DecimalFormat df = new DecimalFormat("##,##,##,##,##,##,##0.00");
         int amnt=0;
     
        for(int i=0;i<stmnt_table.getRowCount();i++)
           {
            String d= stmnt_table.getValueAt(i, 4).toString();
            double nt=Double.parseDouble(d);
            amnt+=nt;
           
            
            }
         
             int dt= stmnt_table.getRowCount();
            String str = df.format(amnt);
            String mytt ="<html><b>Total("+dt+")<b></html>";
            String mytamnt ="<html><b><u>"+str+" </u></b></html>"+"";
             Object[] row = {"","",mytt,"",mytamnt};
                model.addRow(row);
        return amnt;
    }
        public double getSum1(){
         
         DefaultTableModel model = (DefaultTableModel)stmnt_table.getModel();
         DecimalFormat df = new DecimalFormat("##,##,##,##,##,##,##0.00");
         double amnt=0,ntrt=0 ,pmnt=0;
     
        for(int i=0;i<stmnt_table.getRowCount();i++)
           {
            String d= stmnt_table.getValueAt(i, 4).toString();
            double nt=Double.parseDouble(d);
            amnt+=nt;
            
            }
        for(int i=0;i<stmnt_table.getRowCount();i++)
           {
            String d1= stmnt_table.getValueAt(i, 11).toString();
            double nt1=Double.parseDouble(d1);
            ntrt+=nt1;
            
            }
        for(int i=0;i<stmnt_table.getRowCount();i++)
           {
            String d2= stmnt_table.getValueAt(i, 12).toString();
            double nt2=Double.parseDouble(d2);
            pmnt+=nt2;
            
            }
         
             int dt= stmnt_table.getRowCount();
            String str = df.format(amnt);
            String trt = df.format(ntrt);
            String pt = df.format(pmnt);
            String mytt ="<html><b>Total("+dt+")<b></html>";
            String mytamnt ="<html><b><u>"+str+" </u></b></html>"+"";
            String mytint ="<html><b><u>"+trt+" </u></b></html>"+"";
            String mytpmnt ="<html><b><u>"+pt+" </u></b></html>"+"";

             Object[] row = {"","",mytt,"",mytamnt,"","","","","","",mytint,mytpmnt};
                model.addRow(row);
        return amnt;
    }
      
        private void fixWidth(final JTable table, final int columnIndex, final int width) {
        TableColumn column = table.getColumnModel().getColumn(columnIndex);
        column.setMinWidth(width);
        column.setMaxWidth(width);
        column.setPreferredWidth(width);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        date_search = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        location = new javax.swing.JComboBox<>();
        property = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        location_search = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        sdate = new com.toedter.calendar.JDateChooser();
        tdate = new com.toedter.calendar.JDateChooser();
        genloc = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        stmnt_table = new javax.swing.JTable()
        {
            public boolean isCellEditable(int rowindex, int colIndex)
            { return false;}
        }
        ;
        print = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        invrp = new javax.swing.JButton();

        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we)
            { 

                dispose();
                try {
                    DefaultTableModel model = (DefaultTableModel) stmnt_table.getModel();
                    model.setRowCount(0);
                    rs.close();
                    pst.close();
                    conn.close();

                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null,e);
                }

            }
        });
        setTitle("PROPERTY PAYMENT REPORTS");
        setBackground(new java.awt.Color(153, 153, 153));

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        date_search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search.png"))); // NOI18N
        date_search.setText("Search");
        date_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                date_searchActionPerformed(evt);
            }
        });

        jLabel6.setText("Search by Location");

        property.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Land", "House" }));
        property.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                propertyActionPerformed(evt);
            }
        });

        jLabel3.setText("From");

        jLabel4.setText("To ");

        location_search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search.png"))); // NOI18N
        location_search.setText("Search");
        location_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                location_searchActionPerformed(evt);
            }
        });

        jLabel2.setText("Search by Date  ");

        jLabel5.setText("Select Property");

        sdate.setDateFormatString("yyyy-MM-dd");

        tdate.setDateFormatString("yyyy-MM-dd");

        genloc.setText("Generate");
        genloc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genlocActionPerformed(evt);
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
                        .addGap(100, 100, 100)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(sdate, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tdate, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(date_search)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(genloc)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(location, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(property, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(location_search)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(property, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(location, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(location_search)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(genloc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(date_search)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(sdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addComponent(jLabel4)
                        .addComponent(tdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        stmnt_table.setBackground(new java.awt.Color(204, 204, 204));
        stmnt_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "", "", "", ""
            }
        ));
        jScrollPane1.setViewportView(stmnt_table);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
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
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(469, 469, 469)
                .addComponent(print)
                .addContainerGap(625, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(print)
                .addContainerGap())
        );

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/gakuyo.png"))); // NOI18N

        invrp.setText("Generate");
        invrp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invrpActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(418, 418, 418)
                        .addComponent(invrp)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(invrp)
                .addGap(27, 27, 27)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );

        setSize(new java.awt.Dimension(1165, 513));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void location_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_location_searchActionPerformed
        if(conn==null){
            JOptionPane.showMessageDialog(this, "Could not connect to the server");
        }  
      else{
        if (property.getSelectedItem() == "Land"){ 
                          
                     try{   
                         String check ="SELECT COUNT(*) AS total FROM land where location = '"+location.getSelectedItem()+"'"; 
                            pst=conn.prepareStatement(check);
                            rs = pst.executeQuery();
                            
                          while(rs.next()){
                              DefaultTableModel model = (DefaultTableModel) stmnt_table.getModel();
                                model.setRowCount(0);
                              if(rs.getInt("total")>0){
                         
                                
                    String sland = "select land.pdate  as 'Posting Date' ,client_detail.name,land.id, land.location,land.amount,land.cost,"
                            + "land.size,land.ref_no as 'Ref no',"
                            + "land.pmode as 'PMode',land.ptype as 'PType',land.plot_no as 'Plot No',land.balance,land.servedby from land,client_detail "
                            + "where  land.id=client_detail.id and land.location='"+location.getSelectedItem()+"'"; 

                        pst = conn.prepareStatement(sland);
                        rs=pst.executeQuery();
                       stmnt_table.setModel( DbUtils.resultSetToTableModel(rs));
                       getSum();
                       
                        fixWidth(stmnt_table, 1, 170);
                        fixWidth(stmnt_table, 3, 80);
                        fixWidth(stmnt_table, 4, 70);
                        fixWidth(stmnt_table, 5, 70);
                        fixWidth(stmnt_table, 11, 70);
                         }
                      else{
                           JOptionPane.showMessageDialog(null, "No Client in "+" "+location.getSelectedItem()+" ");

                              }}}                
           catch(SQLException e){
        JOptionPane.showMessageDialog(null, e);
    }   
             
        }   
        
          else if (property.getSelectedItem() == "House"){ 
                          
                     try{   
                         String check ="SELECT COUNT(*) AS total FROM house where location = '"+location.getSelectedItem()+"'"; 
                            pst=conn.prepareStatement(check);
                            rs = pst.executeQuery();
                          while(rs.next()){
                              
                              if(rs.getInt("total")>0){
                                  
                      String sland = "select house.posting_date as 'Pdate',client_detail.name,house.id,house.account_debit,house.amount,"
                              + "house.cost,house.refno as 'Ref no',house.location,house.payment_mode,house.payment_type,house.plotno,"
                              + "house.house_size,house.servedby from house,client_detail where house.id=client_detail.id and house.location='"+location.getSelectedItem()+"'";
                              
                        pst = conn.prepareStatement(sland);
                        rs=pst.executeQuery();
                      stmnt_table.setModel( DbUtils.resultSetToTableModel(rs));
                         getSum(); 
                        fixWidth(stmnt_table, 1, 170);
                        fixWidth(stmnt_table, 3, 80);
                        fixWidth(stmnt_table, 4, 70);
                        fixWidth(stmnt_table, 5, 70);
                        fixWidth(stmnt_table, 11, 70);
                         }
                      else{
                           JOptionPane.showMessageDialog(null, "No Client in "+ " "+location.getSelectedItem()+" ");

                              }}}                
           catch(SQLException e){
        JOptionPane.showMessageDialog(null, e);
    }   
   
        } 
      }        
    }//GEN-LAST:event_location_searchActionPerformed

    private void date_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_date_searchActionPerformed
        if (((JTextField)sdate.getDateEditor().getUiComponent()).getText().trim().isEmpty()&&((JTextField)tdate.getDateEditor().getUiComponent()).getText().trim().isEmpty())
            {
             JOptionPane.showMessageDialog(null, "<html><font color='red'>Fill start date and end date</font></html>");
            }
       else if(((JTextField)sdate.getDateEditor().getUiComponent()).getText().trim().isEmpty())
             {
             JOptionPane.showMessageDialog(null, "<html><font color='red'>Fill start date</font></html>");
             }
       else if (((JTextField)tdate.getDateEditor().getUiComponent()).getText().trim().isEmpty())
                 { 
                    JOptionPane.showMessageDialog(null, "<html><font color='red'>Fill end date</font></html>");
                 }
          else {
           if(conn==null){
            JOptionPane.showMessageDialog(null, "Could not connect to the server");
        }
           else{
        if (property.getSelectedItem() == "Land"){ 
                          
         try{    
             
                  String start=((JTextField)sdate.getDateEditor().getUiComponent()).getText().trim();
                  String end=((JTextField)tdate.getDateEditor().getUiComponent()).getText().trim();
                              
             String check ="SELECT COUNT(*) AS total FROM land where (pdate>='"+start+"' and pdate<=('"+end+"'))"; 
                            pst=conn.prepareStatement(check);
                            rs = pst.executeQuery();
                            
                    while(rs.next()){    
                      DefaultTableModel model = (DefaultTableModel) stmnt_table.getModel();
                                model.setRowCount(0);
                           if(rs.getInt("total")>0){                             
                         
          
          String sland ="select client_detail.name,client_detail.phone,land.ref_no as 'Ref no',land.id,land.amount,land.cost,land.size,land.pdate as 'Posting date',"
                  + "land.tdate as 'transaction date',land.location,land.pmode as 'mode',land.ptype as 'type',land.plot_no as 'Plot No',land.balance,land.servedby from "
                  + "client_detail,land where (pdate>='"+start+"' and pdate<=('"+end+"'))  and client_detail.id=land.id";
          pst = conn.prepareStatement(sland);
                        rs=pst.executeQuery();
                       stmnt_table.setModel( DbUtils.resultSetToTableModel(rs));
                      
                         getSum();
                        fixWidth(stmnt_table, 0, 150);
                        ((JTextField)sdate.getDateEditor().getUiComponent()).setText("");
                        ((JTextField)tdate.getDateEditor().getUiComponent()).setText("");
                      }
                    else{
                  JOptionPane.showMessageDialog(null, "No Client found between "+ " "+start+" and " +" "+end+"");

                              }
                          }}              
           catch(SQLException e){
        JOptionPane.showMessageDialog(null, e);
    }   
                                     
         }  
            
        else if (property.getSelectedItem() == "House"){ 
                          
         try{    
             
                  String start=((JTextField)sdate.getDateEditor().getUiComponent()).getText().trim();
                  String end=((JTextField)tdate.getDateEditor().getUiComponent()).getText().trim();
                              
             String check ="SELECT COUNT(*) AS total FROM house where  (posting_date>='"+start+"' and posting_date<=('"+end+"'))"; 
                            pst=conn.prepareStatement(check);
                            rs = pst.executeQuery();
                            
                    while(rs.next()){ 
                        int tt =rs.getInt("total");
                       JOptionPane.showMessageDialog(null,tt);
                           if(rs.getInt("total")>0){                             
                         
            String sland = "select client_detail.name,client_detail.phone, house.refno as 'Ref no',house.account_debit,house.amount,"
                              + "house.cost,house.id,house.location,house.payment_mode,house.payment_type,house.posting_date,house.plotno,house.transaction_date,"
                              + "house.house_size, house.balance,house.servedby from house,client_detail where(posting_date>='"+start+"' and posting_date<=('"+end+"')) and client_detail.id=house.id";
                             
                        pst = conn.prepareStatement(sland);
                        rs=pst.executeQuery();
                       stmnt_table.setModel( DbUtils.resultSetToTableModel(rs));                        
                     getSum(); 
                      fixWidth(stmnt_table, 0, 150);
                           }
              else{
                  JOptionPane.showMessageDialog(null, "No Client found between "+ " "+start+" and " +" "+end+"");

                              }
                          }}              
           catch(SQLException e){
        JOptionPane.showMessageDialog(null, e);
    }   
  
         } 
         else if (property.getSelectedItem() == "Investors"){ 
                          
         try{    
             
                  String start=((JTextField)sdate.getDateEditor().getUiComponent()).getText().trim();
                  String end=((JTextField)tdate.getDateEditor().getUiComponent()).getText().trim();
                              
             String check ="SELECT COUNT(*) AS total FROM investors_club where  (pdate>='"+start+"' and pdate<=('"+end+"'))"; 
                            pst=conn.prepareStatement(check);
                            rs = pst.executeQuery();
                            
                    while(rs.next()){
                        int tt =rs.getInt("total");
                       JOptionPane.showMessageDialog(null,tt);
                           if(rs.getInt("total")>0){                             
                         
            String inv =  "select investors.name as 'Name',investors_club.tdate as 'date of deposit',investors_club.rate,investors_club.bank_account as 'bank account',investors_club.amount as 'amount invested',"
                         + "investors_club.bank_name as 'bank',investors_club.servedby from investors,investors_club where [investors_club].pdate>='"+start+"' and [investors_club].pdate<='"+end+"' and investors.id=investors_club.id ORDER BY investors_club.pdate";
             
                        pst = conn.prepareStatement(inv);
                        rs=pst.executeQuery();
                       stmnt_table.setModel( DbUtils.resultSetToTableModel(rs));
                       getSum(); 
                      fixWidth(stmnt_table, 0, 150);
                         
                      }
                    else{
                  JOptionPane.showMessageDialog(null, "No Client found between "+ " "+start+" and " +" "+end+"");

                              }
                          }}              
           catch(SQLException e){
        JOptionPane.showMessageDialog(null, e);
    }   
   
         } 
         }
       }
    }//GEN-LAST:event_date_searchActionPerformed

    private void propertyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_propertyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_propertyActionPerformed

    private void printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printActionPerformed
        if(stmnt_table != null && stmnt_table.getModel() != null){

            JCheckBox fitWidthBox = new JCheckBox("Fit width to printed page", true);
            MessageFormat header = new MessageFormat("Gakuyo Property Report");
            MessageFormat footer = new MessageFormat("Page{0,number,integer}");

            boolean fitWidth = fitWidthBox.isSelected();

            try{
                JTable.PrintMode mode = fitWidth ? JTable.PrintMode.FIT_WIDTH
                : JTable.PrintMode.NORMAL;
                stmnt_table.print(mode,header,footer);
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

    private void genlocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genlocActionPerformed
        if(conn==null){
            JOptionPane.showMessageDialog(null, "Could not connect to the server");
        }
         else{
             if (property.getSelectedItem() == "Land"){ 
        try { 
              String check ="SELECT COUNT(*) AS total FROM land where location = '"+location.getSelectedItem()+"'"; 
                            pst=conn.prepareStatement(check);
                            rs = pst.executeQuery();
                            
                          while(rs.next()){
                              
                              if(rs.getInt("total")>0){
                                 //String report = "src\\landrp.jrxml";
                         JasperDesign jd = JRXmlLoader.load("src\\landrp.jrxml");

                          String sland = "select land.pdate,client_detail.name,land.id, land.location,land.amount,land.cost,"
                            + "land.size,land.ref_no as 'Refno',"
                            + "land.pmode as 'PMode',land.debitacc,land.ptype as 'PType',land.plot_no as 'PlotNo',land.balance,land.servedby from land,client_detail "
                            + "where  land.id=client_detail.id and land.location='"+location.getSelectedItem()+"'"; 

                JRDesignQuery nq = new JRDesignQuery();
                nq.setText(sland);
                jd.setQuery(nq);
             
                JasperReport jr = JasperCompileManager.compileReport(jd);
                JasperPrint jp = JasperFillManager.fillReport(jr,null, conn);
                JasperViewer.viewReport(jp);
                              
                              }
                            else{
                           JOptionPane.showMessageDialog(null, "No Client in "+" "+location.getSelectedItem()+" ");

                              }
                          
                          }
             
             
        } catch (JRException ex) {
            Logger.getLogger(investors_payments.class.getName()).log(Level.SEVERE, null, ex);
        }        catch (SQLException ex) {
                     Logger.getLogger(Reports.class.getName()).log(Level.SEVERE, null, ex);
                 }}
          else if (property.getSelectedItem() == "House"){ 
         
              try {
              String check ="SELECT COUNT(*) AS total FROM house where location = '"+location.getSelectedItem()+"'"; 
                            pst=conn.prepareStatement(check);
                            rs = pst.executeQuery();
                          while(rs.next()){
                              if(rs.getInt("total")>0){
                               // String report = "src\\houserp.jrxml";
                JasperDesign jd = JRXmlLoader.load("src\\houserp.jrxml");

                String sland = "select house.posting_date as 'Pdate',client_detail.name,client_detail.phone,house.id,house.account_debit as 'Acc',house.amount,"
                              + "house.cost,house.refno as 'Refno',house.location,house.payment_mode as 'Mode',house.payment_type as Type,house.plotno,"
                              + "house.house_size as 'Size',house.balance,house.servedby from house,client_detail "
                              + "where house.id=client_detail.id and house.location='"+location.getSelectedItem()+"'";

                JRDesignQuery nq = new JRDesignQuery();
                nq.setText(sland);
                jd.setQuery(nq);
             
                JasperReport jr = JasperCompileManager.compileReport(jd);
                JasperPrint jp = JasperFillManager.fillReport(jr,null, conn);
                JasperViewer.viewReport(jp);
                              
                              }}
              
        } catch (JRException ex) {
            Logger.getLogger(investors_payments.class.getName()).log(Level.SEVERE, null, ex);
        }        catch (SQLException ex) {
                     Logger.getLogger(Reports.class.getName()).log(Level.SEVERE, null, ex);
                 }
              
              
          }   
         }
    }//GEN-LAST:event_genlocActionPerformed

    private void invrpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invrpActionPerformed

        if (((JTextField)sdate.getDateEditor().getUiComponent()).getText().trim().isEmpty()&&((JTextField)tdate.getDateEditor().getUiComponent()).getText().trim().isEmpty())
            {
             JOptionPane.showMessageDialog(null, "<html><font color='red'>Fill start date and end date</font></html>");
            }
       else if(((JTextField)sdate.getDateEditor().getUiComponent()).getText().trim().isEmpty())
             {
             JOptionPane.showMessageDialog(null, "<html><font color='red'>Fill start date</font></html>");
             }
       else if (((JTextField)tdate.getDateEditor().getUiComponent()).getText().trim().isEmpty())
                 { 
                    JOptionPane.showMessageDialog(null, "<html><font color='red'>Fill end date</font></html>");
                 }
           else  if (property.getSelectedItem() == "Land"){ 
        try {
                   String start=((JTextField)sdate.getDateEditor().getUiComponent()).getText().trim();
                   String end=((JTextField)tdate.getDateEditor().getUiComponent()).getText().trim();
              //String report = "src\\landrp.jrxml";
             JasperDesign jd = JRXmlLoader.load("src\\landrpd.jrxml");

       String sland = "select land.pdate,client_detail.name,land.id, land.location,land.amount,land.cost,"
                            + "land.size,land.ref_no as 'Refno',"
                            + "land.pmode as 'PMode',land.debitacc,land.ptype as 'PType',land.plot_no as 'PlotNo',land.balance,land.servedby from land,client_detail "
                             + "where (pdate>='"+start+"' and pdate<=('"+end+"'))  and client_detail.id=land.id"; 

                JRDesignQuery nq = new JRDesignQuery();
                nq.setText(sland);
                jd.setQuery(nq);
             
                JasperReport jr = JasperCompileManager.compileReport(jd);
                JasperPrint jp = JasperFillManager.fillReport(jr,null, conn);
                JasperViewer.viewReport(jp);
        } catch (JRException ex) {
            Logger.getLogger(investors_payments.class.getName()).log(Level.SEVERE, null, ex);
        }}
          else if (property.getSelectedItem() == "House"){ 
          try {
                   String start=((JTextField)sdate.getDateEditor().getUiComponent()).getText().trim();
                   String end=((JTextField)tdate.getDateEditor().getUiComponent()).getText().trim();
               // String report = "src\\houserp.jrxml";
                JasperDesign jd = JRXmlLoader.load("src\\houserp.jrxml");

                String sland = "select house.posting_date as 'Pdate',client_detail.name,client_detail.phone,house.id,house.account_debit as 'Acc',house.amount,"
                              + "house.cost,house.refno as 'Refno',house.location,house.payment_mode as 'Mode',house.payment_type as Type,house.plotno,"
                              + "house.house_size as 'Size',house.balance,house.servedby from house,client_detail "
                              + "(posting_date>='"+start+"' and posting_date<=('"+end+"')) and client_detail.id=house.id";

                JRDesignQuery nq = new JRDesignQuery();
                nq.setText(sland);
                jd.setQuery(nq);
             
                JasperReport jr = JasperCompileManager.compileReport(jd);
                JasperPrint jp = JasperFillManager.fillReport(jr,null, conn);
                JasperViewer.viewReport(jp);
        } catch (JRException ex) {
            Logger.getLogger(investors_payments.class.getName()).log(Level.SEVERE, null, ex);
        }
              
              
          }   
         
        
    }//GEN-LAST:event_invrpActionPerformed
  
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(() -> {
            new Reports().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton date_search;
    private javax.swing.JButton genloc;
    private javax.swing.JButton invrp;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> location;
    private javax.swing.JButton location_search;
    private javax.swing.JButton print;
    private javax.swing.JComboBox<String> property;
    private com.toedter.calendar.JDateChooser sdate;
    private javax.swing.JTable stmnt_table;
    private com.toedter.calendar.JDateChooser tdate;
    // End of variables declaration//GEN-END:variables
}
