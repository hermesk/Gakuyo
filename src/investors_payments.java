
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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

public class investors_payments extends javax.swing.JFrame {

    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    private static investors_payments obj=null;
    
    private investors_payments() {
       
        initComponents();
        conn = DbConnect.connecrDb();
        
        logo();
        Current_Date();
        invbank();
    }
      public static investors_payments getObj() {
        if (obj== null){
            obj = new investors_payments();
        }
      else{
         obj.setExtendedState(JFrame.NORMAL);
         obj.setAlwaysOnTop(true);
         obj.requestFocus();
       }
       return obj;
 }
    public final void Current_Date(){
        
    //current date
       DateFormat dF = new SimpleDateFormat("yyyy-MM-dd");
       Date date = new Date();
       String td=dF.format(date);
       today.setText(td);
    
    }
   
    private void logo(){
    setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("images/LOG.png")));
    }
     
   
    
     private void invbank(){
       if(conn==null){
            JOptionPane.showMessageDialog(this, "Could not connect to the server");
        }
       else{
         try{
         String sql = "select   DISTINCT bank_name from investors_club";
         pst = conn.prepareStatement(sql);
         rs =pst.executeQuery();
         while(rs.next()){
          String pbk = rs.getString("bank_name");         
          banks.addItem(pbk);
          
                  }
       }
     catch(SQLException e)
     {
                 JOptionPane.showMessageDialog(null, e);
    }
        
       }  }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        id = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        dd = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        banks = new javax.swing.JComboBox<>();
        dd2 = new javax.swing.JTextField();
        dd1 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        dd3 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        today = new javax.swing.JLabel();
        genrp = new javax.swing.JButton();
        genprt = new javax.swing.JButton();
        genpd = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        sdate = new com.toedter.calendar.JDateChooser();
        jLabel11 = new javax.swing.JLabel();
        tdate = new com.toedter.calendar.JDateChooser();
        invrp = new javax.swing.JButton();

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
        setTitle("Investors payments");
        setResizable(false);

        jLabel1.setText("INVESTORS CLUB MONTHLY PAYMENTS");

        jLabel2.setText("Search by ID");

        jLabel3.setText("Seach by bank &  Pay day ");

        id.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                idKeyTyped(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/gakuyo.png"))); // NOI18N

        jLabel5.setText("Search by pay day from");

        dd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ddKeyTyped(evt);
            }
        });

        jLabel8.setText("To");

        dd1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                dd1KeyTyped(evt);
            }
        });

        jLabel9.setText("To");

        jLabel7.setText("  From");

        today.setText("today");

        genrp.setText("Generate");
        genrp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genrpActionPerformed(evt);
            }
        });

        genprt.setText("Generate");
        genprt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genprtActionPerformed(evt);
            }
        });

        genpd.setText("Generate");
        genpd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genpdActionPerformed(evt);
            }
        });

        jLabel6.setText("Investors Report");

        jLabel10.setText("From");

        sdate.setDateFormatString("yyyy-MM-dd");

        jLabel11.setText("To");

        tdate.setDateFormatString("yyyy-MM-dd");

        invrp.setText("Generate");
        invrp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invrpActionPerformed(evt);
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
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(24, 24, 24)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(banks, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(dd1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel9)
                                        .addGap(18, 18, 18)
                                        .addComponent(dd3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(28, 28, 28)
                                                .addComponent(genrp))))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(today)
                                .addGap(143, 143, 143)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(genprt))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(dd, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(dd2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(genpd))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(invrp)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(today)))
                .addGap(4, 4, 4)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(genrp))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(banks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(dd1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dd3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(genprt))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(dd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(dd2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(genpd))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel10))
                        .addComponent(sdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11)
                        .addComponent(tdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(invrp))
                .addContainerGap(58, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void idKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_idKeyTyped
        char c=evt.getKeyChar();
        if(!(Character.isAlphabetic(c) ||  (c==KeyEvent.VK_BACK_SPACE)||  c==KeyEvent.VK_DELETE ||Character.isDigit(c))){
        evt.consume();
        getToolkit().beep();}
    }//GEN-LAST:event_idKeyTyped

    private void ddKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ddKeyTyped
           char c = evt.getKeyChar();
        if (!(Character.isDigit(c)
                || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE )) {
            evt.consume();
           getToolkit().beep(); 
       }
    }//GEN-LAST:event_ddKeyTyped

    private void dd1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dd1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_dd1KeyTyped

    private void genrpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genrpActionPerformed
      if(id.getText().isEmpty()){
              JOptionPane.showMessageDialog(null, "<html><h4><font color='red'>Enter Investor ID </font></h4></html>");       
                }
      else{
               
        try {
            String check ="SELECT COUNT(*) AS total FROM investors_club where investors_club.id='"+id.getText()+"'"; 
                            pst=conn.prepareStatement(check);
                            rs = pst.executeQuery();
                          while(rs.next()){
            if(rs.getInt("total")>0){
               InputStream ljp = getClass().getResourceAsStream("investor statement.jrxml");
                JasperDesign jd = JRXmlLoader.load(ljp);
                

      String sql = "select investors.name as 'Name',investors.id,investors_club.tdate as 'Date',investors_club.amount,investors_club.ptype,investors_club.rate,"
                         + "investors_club.interest,investors_club.govtw,investors_club.payment,investors_club.bank_account as 'bankaccount',investors_club.bank_name as 'bank',investors.bank_branch as 'Branch' "
                        + "from investors,investors_club where investors.id='"+id.getText()+"' and investors_club.id='"+id.getText()+"'ORDER BY tdate";
         
                JRDesignQuery nq = new JRDesignQuery();
                nq.setText(sql);
                jd.setQuery(nq);
                
                JasperReport jr = JasperCompileManager.compileReport(jd);
                JasperPrint jp = JasperFillManager.fillReport(jr,null, conn);
                JasperViewer.viewReport(jp,false);
                              }
            else{
            JOptionPane.showMessageDialog(null,"Investor not found" );
            }        
                          }
                
        } catch (JRException | SQLException ex) {
            Logger.getLogger(investors_payments.class.getName()).log(Level.SEVERE, null, ex);
        }
                
      }
        id.setText("");
    }//GEN-LAST:event_genrpActionPerformed

    private void genprtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genprtActionPerformed
      if(dd1.getText().isEmpty()){
              JOptionPane.showMessageDialog(null, "<html><h4><font color='red'>Enter start pay day </font></h4></html>");       
                }
        else if(dd3.getText().isEmpty()){
              JOptionPane.showMessageDialog(null, "<html><h4><font color='red'>Enter final pay day </font></h4></html>");       
                }
        else{
        try {
            String check ="SELECT COUNT(*) AS total FROM investors_club where bank_name = '"+banks.getSelectedItem()+"' and "
            + "DATEPART (dd, tdate)>='"+dd1.getText()+"' and DATEPART (dd, tdate)<='"+dd3.getText()+"' "; 
                            pst=conn.prepareStatement(check);
                            rs = pst.executeQuery();
                          while(rs.next()){
            if(rs.getInt("total")>0){
             InputStream ljp = getClass().getResourceAsStream("investors.jrxml");
                JasperDesign jd = JRXmlLoader.load(ljp);

            String sql = "select investors.name,investors.id,investors_club.tdate as 'Date',investors_club.amount,investors_club.ptype,"
            + "investors_club.rate,investors_club.interest,investors_club.govtw, investors_club.payment,investors_club.bank_account"
            + " as 'bankaccount',investors_club.bank_name as 'Bank',investors.bank_branch as 'Branch'from investors,investors_club"
            + " where investors.id=investors_club.id and bank_name = '"+banks.getSelectedItem()+"' and "
            + "DATEPART (dd, tdate)>='"+dd1.getText()+"' and DATEPART (dd, tdate)<='"+dd3.getText()+"' ";
            JRDesignQuery nq = new JRDesignQuery();
            nq.setText(sql);
            jd.setQuery(nq);

            JasperReport jr = JasperCompileManager.compileReport(jd);
            JasperPrint jp = JasperFillManager.fillReport(jr,null, conn);
            JasperViewer.viewReport(jp,false);
            
            }
                      else{
            JOptionPane.showMessageDialog(null,"Investor not found" );
            }    
                          }
           
        } catch (JRException | SQLException ex) {
            Logger.getLogger(investors_payments.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
            dd1.setText("");
            dd3.setText("");
    }//GEN-LAST:event_genprtActionPerformed

    private void genpdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genpdActionPerformed
      if(dd.getText().isEmpty()){
              JOptionPane.showMessageDialog(null, "<html><h4><font color='red'>Enter start pay day </font></h4></html>");       
                }
        else if(dd2.getText().isEmpty()){
              JOptionPane.showMessageDialog(null, "<html><h4><font color='red'>Enter final pay day </font></h4></html>");       
                }
        else{
        try {
            String check ="SELECT COUNT(*) AS total FROM investors_club"
                    + " where (DATEPART (dd, tdate)>='"+dd.getText()+"' and DATEPART (dd, tdate)<='"+dd2.getText()+"') "; 
                            pst=conn.prepareStatement(check);
                            rs = pst.executeQuery();
                          while(rs.next()){
            if(rs.getInt("total")>0){
             InputStream ljp = getClass().getResourceAsStream("investors.jrxml");
                JasperDesign jd = JRXmlLoader.load(ljp);

            String sql = "select investors.name as 'Name',investors.id,investors_club.tdate as 'Date',investors_club.amount,investors_club.ptype,investors_club.rate,"
                     + "investors_club.interest,investors_club.govtw, investors_club.payment,investors_club.bank_account as 'bankaccount',investors_club.bank_name as 'bank',"
                    + "investors.bank_branch as 'Branch'from investors,investors_club where"
                   + "(DATEPART (dd, tdate)>='"+dd.getText()+"' and DATEPART (dd, tdate)<='"+dd2.getText()+"')and investors.id=investors_club.id ORDER BY tdate";
         
            JRDesignQuery nq = new JRDesignQuery();
            nq.setText(sql);
            jd.setQuery(nq);

            JasperReport jr = JasperCompileManager.compileReport(jd);
            JasperPrint jp = JasperFillManager.fillReport(jr,null, conn);
            JasperViewer.viewReport(jp,false);
            
            }
                    else{
            JOptionPane.showMessageDialog(null,"Investor not found" );
            }           
                          
                          }
              
        } catch (JRException | SQLException ex) {
            Logger.getLogger(investors_payments.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
             dd.setText("");
            dd2.setText("");
    }//GEN-LAST:event_genpdActionPerformed

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
        
         else if(conn==null){
            JOptionPane.showMessageDialog(null, "Could not connect to the server");
        }
         else{
        try {
             
                   String start=((JTextField)sdate.getDateEditor().getUiComponent()).getText().trim();
                   String end=((JTextField)tdate.getDateEditor().getUiComponent()).getText().trim();
                   String check ="SELECT COUNT(*) AS total FROM investors_club where  (pdate>='"+start+"' and pdate<=('"+end+"'))"; 
                            pst=conn.prepareStatement(check);
                            rs = pst.executeQuery();
                            
                    while(rs.next()){
                           if(rs.getInt("total")>0){ 
                               
                   InputStream ljp = getClass().getResourceAsStream("invstor.jrxml");
                   JasperDesign jd = JRXmlLoader.load(ljp);
                

                  String sql ="select investors.name as Name, investors.id,investors_club.tdate as Date,investors_club.amount ,"
                          +"investors_club.ptype,investors_club.rate,investors_club.interest,investors_club.govtw," 
                          +"investors_club.payment,investors_club.bank_account as bankaccount," 
                          +"investors_club.bank_name as bank,investors.bank_branch as  Branch from investors,investors_club "
                          + "where [investors_club].pdate>='"+start+"' and [investors_club].pdate<='"+end+"'"
                          + " and investors.id=investors_club.id ORDER BY investors_club.pdate";
             
                JRDesignQuery nq = new JRDesignQuery();
                nq.setText(sql);
                jd.setQuery(nq);
                 
                JasperReport jr = JasperCompileManager.compileReport(jd);
                JasperPrint jp = JasperFillManager.fillReport(jr,null, conn);
                JasperViewer.viewReport(jp,false);
              
                           }
               else{
                  JOptionPane.showMessageDialog(null, "No Investor found between "+ " "+start+" and " +" "+end+"");

                              }
                    }  
        }
        catch (JRException | SQLException ex) {
            Logger.getLogger(Reports.class.getName()).log(Level.SEVERE, null, ex);
        }
         }
            ((JTextField)sdate.getDateEditor().getUiComponent()).setText("");
               ((JTextField)tdate.getDateEditor().getUiComponent()).setText("");       
        
        
    }//GEN-LAST:event_invrpActionPerformed

    public static void main(String args[]) {
    
        java.awt.EventQueue.invokeLater(() -> {
            new investors_payments().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> banks;
    private javax.swing.JTextField dd;
    private javax.swing.JTextField dd1;
    private javax.swing.JTextField dd2;
    private javax.swing.JTextField dd3;
    private javax.swing.JButton genpd;
    private javax.swing.JButton genprt;
    private javax.swing.JButton genrp;
    private javax.swing.JTextField id;
    private javax.swing.JButton invrp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private com.toedter.calendar.JDateChooser sdate;
    private com.toedter.calendar.JDateChooser tdate;
    private javax.swing.JLabel today;
    // End of variables declaration//GEN-END:variables
}
