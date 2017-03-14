
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

public class transfer_reports extends javax.swing.JFrame {
    
Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    private static transfer_reports obj=null;
    
    private transfer_reports() {
        initComponents();
        conn = DbConnect.connecrDb();
       logo();
       
        
    }
        public static transfer_reports getObj() {
        if (obj== null){
            obj = new transfer_reports();
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
public double getSum(){
         
         DefaultTableModel model = (DefaultTableModel)transfer_table.getModel();
         DecimalFormat df = new DecimalFormat("##,##,##,##,##,##,##0.00");
       int amnt=0;
     
        for(int i=0;i<transfer_table.getRowCount();i++)
           {
            String d= transfer_table.getValueAt(i, 4).toString();
            double nt=Double.parseDouble(d);
            amnt+=nt;
           
            
            }
         
             int dt= transfer_table.getRowCount();
            String str = df.format(amnt);
            String mytt ="<html><b>Total("+dt+")<b></html>";
            String mytamnt ="<html><b><u>"+str+" </u></b></html>"+"";
             Object[] row = {"","",mytt,"",mytamnt};
                model.addRow(row);
        return amnt;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        transfer_table = new javax.swing.JTable()

        {
            public boolean isCellEditable(int rowindex, int colIndex)
            { return false;}
        }

        ;
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        sdate = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tdate = new com.toedter.calendar.JDateChooser();
        date_search = new javax.swing.JButton();
        property = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we)
            { 

                dispose();
                try {
                    DefaultTableModel model = (DefaultTableModel) transfer_table.getModel();
                    model.setRowCount(0);
                    rs.close();
                    pst.close();
                    conn.close();

                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null,e);
                }

            }
        });
        setTitle("PROPERTY TRANSFER REPORTS");
        setName("Transfers_Reports"); // NOI18N
        setResizable(false);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/gakuyo.png"))); // NOI18N

        transfer_table.setBorder(new javax.swing.border.MatteBorder(null));
        transfer_table.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(transfer_table);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel2.setText("TRANSFER REPORTS");

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel3.setText("SEARCH BY DATE");

        sdate.setDateFormatString("yyyy-MM-dd");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("FROM:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("TO:");

        tdate.setDateFormatString("yyyy-MM-dd");

        date_search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search.png"))); // NOI18N
        date_search.setText("SEARCH");
        date_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                date_searchActionPerformed(evt);
            }
        });

        property.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "LAND", "HOUSE" }));

        jLabel7.setText("TRANSACTION");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(312, 312, 312)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(215, 215, 215)
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(sdate, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel5))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(236, 236, 236)
                                        .addComponent(jLabel7)
                                        .addGap(60, 60, 60)
                                        .addComponent(property, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 47, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tdate, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(169, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(date_search)
                .addGap(319, 319, 319))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(property, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tdate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sdate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(date_search)
                .addGap(4, 4, 4))
        );

        jButton1.setText("PRINT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addGap(31, 31, 31))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 76, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(117, 117, 117))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(447, 447, 447))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(24, 24, 24))
        );

        getAccessibleContext().setAccessibleName("Transfers_Reports");
        getAccessibleContext().setAccessibleDescription("Transfers_Reports");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
       else{
       conn = DbConnect.connecrDb();
       if(conn==null){
            JOptionPane.showMessageDialog(this, "Could not connect to the server");
        }
       
       else if (property.getSelectedItem() == "LAND"){ 
                          
         try{    
             
                  String start=((JTextField)sdate.getDateEditor().getUiComponent()).getText().trim();
                  String end=((JTextField)tdate.getDateEditor().getUiComponent()).getText().trim(); 
                  String type = "land";
                             
             String check ="SELECT COUNT(*) AS total FROM transfers where  ttype='"+type+"' and (tdate>='"+start+"' and tdate<=('"+end+"'))"; 
                            pst=conn.prepareStatement(check);
                            rs = pst.executeQuery();
                            
                    while(rs.next()){    
                      DefaultTableModel model = (DefaultTableModel) transfer_table.getModel();
                                model.setRowCount(0);
                   if(rs.getInt("total")>0){                             
                       
                       
             String sland = "select client_detail.name,transfers.location,transfers.id as 'id no',transfers.size,transfers.amount,transfers.cost,transfers.tdate as 'tdate',"
                          + "transfers.receiptno,transfers.servedby from transfers,client_detail where transfers.id=client_detail.id and  ttype='"+type+"' and (tdate>='"+start+"' and tdate<=('"+end+"'))";
                             
                        pst = conn.prepareStatement(sland);
                        rs=pst.executeQuery();
                       transfer_table.setModel( DbUtils.resultSetToTableModel(rs));
                      getSum();
                         ((JTextField)sdate.getDateEditor().getUiComponent()).setText("");
                        ((JTextField)tdate.getDateEditor().getUiComponent()).setText("");
                      }
                    else{
                  JOptionPane.showMessageDialog(null, "No Transfers between "+ " "+start+" and " +" "+end+"");

                              }
                          }}              
           catch(SQLException e){
        JOptionPane.showMessageDialog(null, e);
    }   
     
         }  
            
        else if (property.getSelectedItem() == "HOUSE"){ 
                          
         try{    
             
                  String start=((JTextField)sdate.getDateEditor().getUiComponent()).getText().trim();
                  String end=((JTextField)tdate.getDateEditor().getUiComponent()).getText().trim();
                       String type = "house";           
             String check ="SELECT COUNT(*) AS total FROM transfers where ttype='"+type+"' and (tdate>='"+start+"' and tdate<=('"+end+"'))"; 
                            pst=conn.prepareStatement(check);
                            rs = pst.executeQuery();
                            
                    while(rs.next()){       
                           if(rs.getInt("total")>0){                             
                         
            String sland ="select client_detail.name,transfers.location,transfers.id as 'id no',transfers.size,transfers.amount,transfers.cost,transfers.tdate as 'tdate',"
                          + "transfers.receiptno,transfers.servedby from transfers,client_detail where transfers.id=client_detail.id and  ttype='"+type+"' and (tdate>='"+start+"' and tdate<=('"+end+"'))";
                             
                        pst = conn.prepareStatement(sland);
                        rs=pst.executeQuery();
                       transfer_table.setModel( DbUtils.resultSetToTableModel(rs));                        
                       getSum();
                           }
              else{
                  JOptionPane.showMessageDialog(null, "No Client found between "+ " "+start+" and " +" "+end+"");

                              }
                          }}              
           catch(SQLException e){
        JOptionPane.showMessageDialog(null, e);
    }   
        finally {
    try { rs.close(); } catch (SQLException e) { JOptionPane.showMessageDialog(null, e); }
    try { pst.close(); } catch (SQLException e) {JOptionPane.showMessageDialog(null, e); }
    try { conn.close(); System.out.println("Connection closed");} catch (SQLException e) {}
}
      
         } 
       }

    }//GEN-LAST:event_date_searchActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
 MessageFormat header=new MessageFormat("Transfers Report ");
        MessageFormat footer=new MessageFormat("page(0,number,integer)");
        try{
        transfer_table.print(JTable.PrintMode.NORMAL,header,footer);
        } catch (PrinterException ex) {
            Logger.getLogger(Edit_Gakuyozerodeposit.class.getName()).log(Level.SEVERE, null, ex);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(() -> {
            new transfer_reports().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton date_search;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> property;
    private com.toedter.calendar.JDateChooser sdate;
    private com.toedter.calendar.JDateChooser tdate;
    private javax.swing.JTable transfer_table;
    // End of variables declaration//GEN-END:variables
}
