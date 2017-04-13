
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

public class withdrawal_report extends javax.swing.JFrame {

    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
  private static withdrawal_report obj=null;

    //current date
    DateFormat dF = new SimpleDateFormat("yyyy-MM-dd");
    Date date = new Date();
    String td = dF.format(date);

   private withdrawal_report() {

        initComponents();
        conn = DbConnect.connecrDb();
        logo();
        current_date();

    }
         public static withdrawal_report getObj() {
        if (obj== null){
            obj = new withdrawal_report();
        }
      else{
         obj.setExtendedState(JFrame.NORMAL);
         obj.setAlwaysOnTop(true);
         obj.requestFocus();
       }
       return obj;
 }

    private void logo() {
    setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("images/LOG.png")));

    }

    public final void current_date() {
        current_date.setText(td);
    }
     public double getSum(){
         
         DefaultTableModel model = (DefaultTableModel)withdrawal_tbl.getModel();
         DecimalFormat df = new DecimalFormat("##,##,##,##,##,##,##0.00");
       
          
       double pnmt=0,intrt=0,bb=0;
       int  amnti=0;
        
        for(int i=0;i<withdrawal_tbl.getRowCount();i++)
           {
            String d= withdrawal_tbl.getValueAt(i, 5).toString();
            double amnt=Double.parseDouble(d);
            amnti+=amnt;
             
             }
        for(int i=0;i<withdrawal_tbl.getRowCount();i++)
           {
            String d= withdrawal_tbl.getValueAt(i, 6).toString();
            double nt=Double.parseDouble(d);
            intrt+=nt;          
            }
         for(int i=0;i<withdrawal_tbl.getRowCount();i++)
           {
            String d= withdrawal_tbl.getValueAt(i, 7).toString();
            double pmnt=Double.parseDouble(d);
            pnmt+=pmnt;          
            }
         for(int i=0;i<withdrawal_tbl.getRowCount();i++)
           {
            String c= withdrawal_tbl.getValueAt(i, 9).toString();
            double b=Double.parseDouble(c);
            bb+=b;          
            }
          int dt= withdrawal_tbl.getRowCount();
              String str = df.format(amnti);
               String tpmnt = df.format(pnmt);
               String tnt = df.format(intrt);
               String mmbb = df.format(bb);
               String mytt ="<html><b>Total("+dt+")<b></html>";
               String mytamnt ="<html><b><u>"+str+" </u></b></html>"+"";
               String interest ="<html><b><u>"+tnt+" </u></b></html>"+"";
               String payment ="<html><b><u>"+tpmnt+" </u></b></html>"+"";
               String mbb ="<html><b><u>"+mmbb+" </u></b></html>"+"";

               Object[] row = {"",mytt,"","","",mytamnt,interest,payment,"",mbb};
               model.addRow(row);
        return amnti;
    }
     
      public double getSum1(){
         
         DefaultTableModel model = (DefaultTableModel)withdrawal_tbl.getModel();
         DecimalFormat df = new DecimalFormat("##,##,##,##,##,##,##0.00");
       
          
       double pnmt=0,intrt=0;
       int  amnti=0;
        
        for(int i=0;i<withdrawal_tbl.getRowCount();i++)
           {
            String d= withdrawal_tbl.getValueAt(i, 1).toString();
            double amnt=Double.parseDouble(d);
            amnti+=amnt;
             
             }
        for(int i=0;i<withdrawal_tbl.getRowCount();i++)
           {
            String d= withdrawal_tbl.getValueAt(i, 2).toString();
            double nt=Double.parseDouble(d);
            intrt+=nt;          
            }
         for(int i=0;i<withdrawal_tbl.getRowCount();i++)
           {
            String d= withdrawal_tbl.getValueAt(i, 3).toString();
            double pmnt=Double.parseDouble(d);
            pnmt+=pmnt;          
            }
          int dt= withdrawal_tbl.getRowCount();
              String str = df.format(amnti);
               String tpmnt = df.format(pnmt);
               String tnt = df.format(intrt);
               String mytt ="<html><b>Total("+dt+")<b></html>";
               String mytamnt ="<html><b><u>"+str+" </u></b></html>"+"";
               String interest ="<html><b><u>"+tnt+" </u></b></html>"+"";
               String payment ="<html><b><u>"+tpmnt+" </u></b></html>"+"";
               Object[] row = {mytt,mytamnt,interest, payment};
               model.addRow(row);
        return amnti;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        current_date = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ptype = new javax.swing.JComboBox<>();
        sdate = new com.toedter.calendar.JDateChooser();
        tdate = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        search = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        withdrawal_tbl = new javax.swing.JTable();
        print = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Withdrawal Reports");
        setResizable(false);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/gakuyo.png"))); // NOI18N

        current_date.setText("today");

        jLabel2.setText("Property type");

        ptype.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "land", "house", "investors", "GZD", " " }));

        sdate.setDateFormatString(" yyyy-MM-dd");

        tdate.setDateFormatString("yyyy-MM-dd");

        jLabel3.setText("From");

        jLabel4.setText("To");

        search.setText("Search");
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });

        withdrawal_tbl.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(withdrawal_tbl);

        print.setText("Print");
        print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(449, 449, 449)
                                .addComponent(print))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel1)
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(ptype, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(current_date)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(106, 106, 106)
                                .addComponent(jLabel3)
                                .addGap(36, 36, 36)
                                .addComponent(sdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(13, 13, 13)
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(tdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addComponent(search)))
                        .addGap(0, 482, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(current_date)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(ptype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(search))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(print)
                .addContainerGap(313, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
       
        if (((JTextField) sdate.getDateEditor().getUiComponent()).getText().trim().isEmpty() && ((JTextField) tdate.getDateEditor().getUiComponent()).getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "<html><font color='red'>Fill start date and end date</font></html>");
        } else if (((JTextField) sdate.getDateEditor().getUiComponent()).getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "<html><font color='red'>Fill start date</font></html>");
        } else if (((JTextField) tdate.getDateEditor().getUiComponent()).getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "<html><font color='red'>Fill end date</font></html>");
        }
        if(conn==null){
            JOptionPane.showMessageDialog(this, "Could not connect to the server");
        }
        
        else {
            if (ptype.getSelectedItem() == "land") {
                try {
                    String start = ((JTextField) sdate.getDateEditor().getUiComponent()).getText().trim();
                    String end = ((JTextField) tdate.getDateEditor().getUiComponent()).getText().trim();

                    String tp = "land";

                    String check = "SELECT COUNT(*) AS total FROM property_withdrawals where"
                            + "  (pdate>='" + start + "' and pdate<=('" + end + "') and ptype='" +tp + "')";
                    pst = conn.prepareStatement(check);
                    rs = pst.executeQuery();

                 rs.next();
                        
                        if (rs.getInt("total") > 0) {
                         DefaultTableModel model = (DefaultTableModel) withdrawal_tbl.getModel();
                                model.setRowCount(0);
                          
                        
                            String ldw = "select client_detail.name,property_withdrawals.pdate,property_withdrawals.property_location as 'location',property_withdrawals.plot_no,property_withdrawals.property_size as 'size',"
                                    + "property_withdrawals.property_cost as 'cost',property_withdrawals.amount_withdrawn,property_withdrawals.amount_payed,property_withdrawals.penalty_rate,"
                                    + "property_withdrawals.penalty_fee as 'penalty',property_withdrawals.servedby from property_withdrawals,client_detail where"
                                    + " property_withdrawals.id=client_detail.id and (pdate>='" + start + "' and pdate<=('" + end + "') and ptype='" + tp + "') ";

                            pst = conn.prepareStatement(ldw);
                            rs = pst.executeQuery();
                            withdrawal_tbl.setModel(DbUtils.resultSetToTableModel(rs));
                           getSum();
                        }
                        else{
                        JOptionPane.showMessageDialog(null, "No record Found");
                        }
                    

                } catch (SQLException ex) {
                    Logger.getLogger(withdrawal_report.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            
            else if (ptype.getSelectedItem() == "house") {
                
                try {
                    String start = ((JTextField) sdate.getDateEditor().getUiComponent()).getText().trim();
                    String end = ((JTextField) tdate.getDateEditor().getUiComponent()).getText().trim();

                    String tp = "house";

                    String check = "SELECT COUNT(*) AS total FROM property_withdrawals where"
                            + "  (pdate>='" + start + "' and pdate<=('" + end + "') and ptype='" + tp + "')";
                    pst = conn.prepareStatement(check);
                    rs = pst.executeQuery();

                  rs.next();
                        
                        if (rs.getInt("total") > 0) {
                            
                        
                    String ldw = "select client_detail.name,property_withdrawals.pdate,property_withdrawals.property_location as 'location',property_withdrawals.plot_no,property_withdrawals.property_size as 'size',"
                                    + "property_withdrawals.property_cost as 'cost',property_withdrawals.amount_withdrawn,property_withdrawals.amount_payed,property_withdrawals.penalty_rate,"
                                    + "property_withdrawals.penalty_fee as 'penalty',property_withdrawals.servedby from property_withdrawals,client_detail where"
                                    + " property_withdrawals.id=client_detail.id and (pdate>='" + start + "' and pdate<=('" + end + "') and ptype='" + tp + "') ";

                            pst = conn.prepareStatement(ldw);
                            rs = pst.executeQuery();
                            withdrawal_tbl.setModel(DbUtils.resultSetToTableModel(rs));
                            getSum();
                        }
                        else{
                        JOptionPane.showMessageDialog(null, "No record Found");
                        }
                    
                } catch (SQLException ex) {
                    Logger.getLogger(withdrawal_report.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (ptype.getSelectedItem() == "investors") {
              
                try{
                    String start = ((JTextField) sdate.getDateEditor().getUiComponent()).getText().trim();
                    String end = ((JTextField) tdate.getDateEditor().getUiComponent()).getText().trim();
                    
                    String tp = "investors";
                    String checkiv = "SELECT COUNT(*) AS total FROM investor_withdrawal where"
                            + "  (pdate>='" + start + "' and pdate<=('" + end + "') and ptype='" +tp + "')";
                    pst = conn.prepareStatement(checkiv);
                    rs = pst.executeQuery();
                   
                     rs.next();
                        
                        if (rs.getInt("total") > 0) {
                         
                        
                           String dspinv ="select investors.name,investor_withdrawal.initial_amount as 'investment',investor_withdrawal.withdrawal_amount as 'Withdrawn',investor_withdrawal.balance,"
                            + "investor_withdrawal.pdate as 'date',investor_withdrawal.refno,investor_withdrawal.withdrawal_type,investor_withdrawal.ptype,investor_withdrawal.servedby from investors,"
                            + "investor_withdrawal where (investor_withdrawal.pdate>='" + start + "' and investor_withdrawal.pdate<=('" + end + "') and investor_withdrawal.ptype='" +tp + "') "
                                   + "and investor_withdrawal.id=investors.id";
                    
                    pst = conn.prepareStatement(dspinv);
                    rs = pst.executeQuery();
                    withdrawal_tbl.setModel(DbUtils.resultSetToTableModel(rs));
                    getSum1();
                        }
                       else{
                        JOptionPane.showMessageDialog(null, "No record Found");
                        }
                       
                 } catch (SQLException ex) {
                    Logger.getLogger(withdrawal_report.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            }
            if (ptype.getSelectedItem() == "GZD"){
            
                try{
                    String start = ((JTextField) sdate.getDateEditor().getUiComponent()).getText().trim();
                    String end = ((JTextField) tdate.getDateEditor().getUiComponent()).getText().trim();
                    String tp = "gzd";
                    
                    
                    String checkgzd = "SELECT COUNT(*) AS total FROM gzd_withdrawals where"
                            + "  (pdate>='" + start + "' and pdate<=('" + end + "') and trtype='" +tp + "')";
                    pst = conn.prepareStatement(checkgzd);
                    rs = pst.executeQuery();
                        
                     rs.next();
                        if (rs.getInt("total") > 0) {
                        
                        
                        String gzdw = "select client_detail.name,gzd_withdrawals.inamount,gzd_withdrawals.wamount,gzd_withdrawals.balance,gzd_withdrawals.ptype,"
                                + "gzd_withdrawals.wtype,gzd_withdrawals.pdate,gzd_withdrawals.receipt_no,gzd_withdrawals.trtype,gzd_withdrawals.servedby from client_detail, gzd_withdrawals"
                                + " where (pdate>='" + start + "' and pdate<=('" + end + "') and trtype='" +tp + "')and gzd_withdrawals.id=client_detail.id";
                        pst = conn.prepareStatement(gzdw);
                        rs = pst.executeQuery();
                        withdrawal_tbl.setModel(DbUtils.resultSetToTableModel(rs));
                        getSum1();
                        }
                     else{
                        JOptionPane.showMessageDialog(null, "No record Found");
                        }
                     
                    
                    
                     } catch (SQLException ex) {
                    Logger.getLogger(withdrawal_report.class.getName()).log(Level.SEVERE, null, ex);
                }
         }
            
        }
    }//GEN-LAST:event_searchActionPerformed

    private void printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printActionPerformed
         if(withdrawal_tbl != null && withdrawal_tbl.getModel() != null){
           
        JCheckBox fitWidthBox = new JCheckBox("Fit width to printed page", true);
        MessageFormat header = new MessageFormat("Gakuyo Refund Report");
        MessageFormat footer = new MessageFormat("Page{0,number,integer}");

        boolean fitWidth = fitWidthBox.isSelected();

        try{
            JTable.PrintMode mode = fitWidth ? JTable.PrintMode.FIT_WIDTH
            : JTable.PrintMode.NORMAL;
            withdrawal_tbl.print(mode,header,footer);
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

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> {
            new withdrawal_report().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel current_date;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton print;
    private javax.swing.JComboBox<String> ptype;
    private com.toedter.calendar.JDateChooser sdate;
    private javax.swing.JButton search;
    private com.toedter.calendar.JDateChooser tdate;
    private javax.swing.JTable withdrawal_tbl;
    // End of variables declaration//GEN-END:variables
}
