
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
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
         String sql = "select *from property_location where location IS NOT NULL";
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
      
   @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        location = new javax.swing.JComboBox<>();
        property = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        sdate = new com.toedter.calendar.JDateChooser();
        tdate = new com.toedter.calendar.JDateChooser();
        genloc = new javax.swing.JButton();
        invrp = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

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
        setTitle("PROPERTY PAYMENT REPORTS");
        setBackground(new java.awt.Color(153, 153, 153));

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        jLabel6.setText("Search by Location");

        property.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Land", "House" }));
        property.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                propertyActionPerformed(evt);
            }
        });

        jLabel3.setText("From");

        jLabel4.setText("To ");

        jLabel5.setText("Select Property");

        sdate.setDateFormatString("yyyy-MM-dd");

        tdate.setDateFormatString("yyyy-MM-dd");

        genloc.setText("Generate");
        genloc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genlocActionPerformed(evt);
            }
        });

        invrp.setText("Generate");
        invrp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invrpActionPerformed(evt);
            }
        });

        jLabel1.setText("Search by Date  ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel1)
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(location, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(property, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(genloc)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(sdate, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(99, 99, 99)
                                .addComponent(invrp)))
                        .addGap(11, 11, 11)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(tdate, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(property, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(location, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(9, 9, 9)
                        .addComponent(genloc)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(sdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(jLabel1))
                            .addComponent(jLabel4)))
                    .addComponent(tdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(invrp)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/gakuyo.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(163, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(90, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(882, 350));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void propertyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_propertyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_propertyActionPerformed

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
              InputStream ljp = getClass().getResourceAsStream("landrp.jrxml");
                    JasperDesign jd = JRXmlLoader.load(ljp);

                          String sland = "select land.pdate,client_detail.name,land.id, land.location,land.amount,land.cost,"
                            + "land.size,land.ref_no as 'Refno',"
                            + "land.pmode as 'PMode',land.debitacc,land.ptype as 'PType',land.plot_no as 'PlotNo',land.balance,land.servedby from land,client_detail "
                            + "where  land.id=client_detail.id and land.location='"+location.getSelectedItem()+"'"; 

                JRDesignQuery nq = new JRDesignQuery();
                nq.setText(sland);
                jd.setQuery(nq);
             
                JasperReport jr = JasperCompileManager.compileReport(jd);
                JasperPrint jp = JasperFillManager.fillReport(jr,null, conn);
                JasperViewer.viewReport(jp,false);
                              
                              }
                            else{
                           JOptionPane.showMessageDialog(null, "No Land Record Found in "+" "+location.getSelectedItem()+" ");

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
                InputStream ljp = getClass().getResourceAsStream("houserp.jrxml");               
                JasperDesign jd = JRXmlLoader.load(ljp);
                
                String sland = "select house.posting_date as 'Pdate',client_detail.name,client_detail.phone,house.id,house.account_debit as 'Acc',house.amount,"
                              + "house.cost,house.refno as 'Refno',house.location,house.payment_mode as 'Mode',house.payment_type as Type,house.plotno,"
                              + "house.house_size as 'Size',house.balance,house.servedby from house,client_detail "
                              + "where house.id=client_detail.id and house.location='"+location.getSelectedItem()+"'";

                JRDesignQuery nq = new JRDesignQuery();
                nq.setText(sland);
                jd.setQuery(nq);
             
                JasperReport jr = JasperCompileManager.compileReport(jd);
                JasperPrint jp = JasperFillManager.fillReport(jr,null, conn);
                JasperViewer.viewReport(jp,false);
                              
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
                   
                   String check ="SELECT COUNT(*) AS total FROM land where (pdate>='"+start+"' and pdate<=('"+end+"'))"; 
                            pst=conn.prepareStatement(check);
                            rs = pst.executeQuery();
                          while(rs.next()){
                              if(rs.getInt("total")>0){
                                  
                    
              //String report = "src\\landrp.jrxml";
              InputStream ljp = getClass().getResourceAsStream("landrpd.jrxml");
             JasperDesign jd = JRXmlLoader.load(ljp);

       String sland = "select land.pdate,client_detail.name,land.id, land.location,land.amount,land.cost,"
                            + "land.size,land.ref_no as 'Refno',"
                            + "land.pmode as 'PMode',land.debitacc,land.ptype as 'PType',land.plot_no as 'PlotNo',land.balance,land.servedby from land,client_detail "
                             + "where (pdate>='"+start+"' and pdate<=('"+end+"'))  and client_detail.id=land.id"; 

                JRDesignQuery nq = new JRDesignQuery();
                nq.setText(sland);
                jd.setQuery(nq);
             
                JasperReport jr = JasperCompileManager.compileReport(jd);
                JasperPrint jp = JasperFillManager.fillReport(jr,null, conn);
                JasperViewer.viewReport(jp,false);
                              
                              }
                          else{
                           JOptionPane.showMessageDialog(null, "No Land Record Found ");

                              }
                          }
                  
        } catch (JRException ex) {
            Logger.getLogger(investors_payments.class.getName()).log(Level.SEVERE, null, ex);
        }   catch (SQLException ex) {
                Logger.getLogger(Reports.class.getName()).log(Level.SEVERE, null, ex);
            }}
          else if (property.getSelectedItem() == "House"){ 
          try {
                   String start=((JTextField)sdate.getDateEditor().getUiComponent()).getText().trim();
                   String end=((JTextField)tdate.getDateEditor().getUiComponent()).getText().trim();
                   
                    String check ="SELECT COUNT(*) AS total FROM house where (posting_date>='"+start+"' and posting_date<=('"+end+"'))"; 
                            pst=conn.prepareStatement(check);
                            rs = pst.executeQuery();
                          while(rs.next()){
                              if(rs.getInt("total")>0){
                              
                              // String report = "src\\houserp.jrxml";
               InputStream ljp = getClass().getResourceAsStream("houserp.jrxml");
                JasperDesign jd = JRXmlLoader.load(ljp);

                String sland = "select house.posting_date as 'Pdate',client_detail.name,client_detail.phone,house.id,house.account_debit as 'Acc',house.amount,"
                              + "house.cost,house.refno as 'Refno',house.location,house.payment_mode as 'Mode',house.payment_type as Type,house.plotno,"
                              + "house.house_size as 'Size',house.balance,house.servedby from house,client_detail  where"
                              + "(posting_date>='"+start+"' and posting_date<=('"+end+"')) and client_detail.id=house.id";

                JRDesignQuery nq = new JRDesignQuery();
                nq.setText(sland);
                jd.setQuery(nq);
             
                JasperReport jr = JasperCompileManager.compileReport(jd);
                JasperPrint jp = JasperFillManager.fillReport(jr,null, conn);
                JasperViewer.viewReport(jp,false);
                              }
                        else{
                           JOptionPane.showMessageDialog(null, "No House Record Found ");

                              }
                          }
                   
               
        } catch (JRException ex) {
            Logger.getLogger(investors_payments.class.getName()).log(Level.SEVERE, null, ex);
        }   catch (SQLException ex) {
                Logger.getLogger(Reports.class.getName()).log(Level.SEVERE, null, ex);
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
    private javax.swing.JButton genloc;
    private javax.swing.JButton invrp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> location;
    private javax.swing.JComboBox<String> property;
    private com.toedter.calendar.JDateChooser sdate;
    private com.toedter.calendar.JDateChooser tdate;
    // End of variables declaration//GEN-END:variables
}
