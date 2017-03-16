
import java.awt.Toolkit;
import java.io.InputStream;
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
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager; 
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.*;

public class statements extends javax.swing.JFrame {
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    DateFormat dF = new SimpleDateFormat("yyyy-MM-dd");
    Date date = new Date();
    String td = dF.format(date);
    private static statements obj=null;
    
    public statements() {
        
        initComponents();
        conn = DbConnect.connecrDb();//open db connection
        current_date();//DISPLAY SYSTEM DATE
        logo(); //SYSTEM LOGO
        
    }
      public static statements getObj() {
       if (obj== null){
         obj = new statements();
        }
        else{
         obj.setExtendedState(JFrame.NORMAL);
         obj.setAlwaysOnTop(true);
         obj.requestFocus();
       }return obj;
}
    private void logo() {
    setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("images/LOG.png")));

    }
    public final void current_date() {
        today.setText(td);
    }
   
  
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        today = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        property = new javax.swing.JComboBox<>();
        id = new javax.swing.JTextField();
        genreport = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("STATEMENTS");
        setResizable(false);

        today.setText("Date");

        jLabel2.setText("Client Id ");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/gakuyo.png"))); // NOI18N

        property.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Land", "House" }));

        id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idActionPerformed(evt);
            }
        });

        genreport.setText("Generate");
        genreport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genreportActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(property, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(genreport))
                                .addGap(36, 36, 36))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(42, 42, 42)
                                .addComponent(today)))))
                .addGap(63, 63, 63))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(today)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(property, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(genreport)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 165, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(113, 113, 113))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(655, 255));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idActionPerformed

    private void genreportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genreportActionPerformed
 if(conn==null){
            JOptionPane.showMessageDialog(this, "Could not connect to the server");
        }
        else if(id.getText().isEmpty()){
     JOptionPane.showMessageDialog(null,"Enter ID number");
    } 
        else{
            if (property.getSelectedItem() == "Land"){       
        try{
            String check ="SELECT COUNT(*) AS total FROM land where land.id='"+id.getText()+"'"; 
                            pst=conn.prepareStatement(check);
                            rs = pst.executeQuery();
                            
                          while(rs.next()){
                              
                              if(rs.getInt("total")>0){
                                 InputStream ljp = getClass().getResourceAsStream("clientlandstatement.jrxml");
                   JasperDesign jd = JRXmlLoader.load(ljp);
                   String sland = "select land.tdate as 'TDate', client_detail.name,land.id,"
                    + "land.size,land.location,land.pmode as 'Mode',"
                    + "land.ptype as 'Type',land.plot_no as 'PlotNo',land.amount from land,client_detail "
                   + " where land.id='"+id.getText()+"' and client_detail.id='"+id.getText()+"'";

                JRDesignQuery nq = new JRDesignQuery();
                nq.setText(sland);
                jd.setQuery(nq);
                JasperReport jr = JasperCompileManager.compileReport(jd);
                JasperPrint jp = JasperFillManager.fillReport(jr,null, conn);
                JasperViewer.viewReport(jp,false);
                id.setText("");
                              }
                              
                              else{
                           JOptionPane.showMessageDialog(null, "No Land Record Found for "+" "+id.getText()+" ");

                              }
                          }
         
        }
        catch ( JRException | SQLException ex) {
            Logger.getLogger(statements.class.getName()).log(Level.SEVERE, null, ex);
        }
            }
        else if (property.getSelectedItem() == "House"){
                try {
                     String check ="SELECT COUNT(*) AS total FROM house where house.id='"+id.getText()+"'"; 
                            pst=conn.prepareStatement(check);
                            rs = pst.executeQuery();
                            
                          while(rs.next()){
                              
                              if(rs.getInt("total")>0){
                                      
                         InputStream ljp = getClass().getResourceAsStream("clienthousestatement.jrxml");
                        JasperDesign jd = JRXmlLoader.load(ljp);
                     String sland = "select house.transaction_date as 'TDate', client_detail.name,house.location,house.id as 'ID',house.house_size as 'Size',"
                          + "house.payment_mode as 'Mode',house.payment_type as 'Type',house.plotno,house.amount from house,client_detail "
                           + "where house.id='"+id.getText()+"' and client_detail.id='"+id.getText()+"'";

          
                        JRDesignQuery nq = new JRDesignQuery();
                        nq.setText(sland);
                        jd.setQuery(nq);
                        JasperReport jr = JasperCompileManager.compileReport(jd);
                        JasperPrint jp = JasperFillManager.fillReport(jr,null, conn);
                        JasperViewer.viewReport(jp,false);
                              
                              }
                            else{
                           JOptionPane.showMessageDialog(null, "No House Record Found for "+" "+id.getText()+" ");

                              }
                          }
                          
                   
                    
                } catch (JRException | SQLException ex) {
                    Logger.getLogger(statements.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
        }
    }//GEN-LAST:event_genreportActionPerformed

    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(() -> {
            new statements().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton genreport;
    private javax.swing.JTextField id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> property;
    private javax.swing.JLabel today;
    // End of variables declaration//GEN-END:variables
}
