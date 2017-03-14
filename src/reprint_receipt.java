
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import net.proteanit.sql.DbUtils;


public class reprint_receipt extends javax.swing.JFrame {
  
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    StyledDocument doc;
     private static reprint_receipt obj=null;
     
    private reprint_receipt() {
        initComponents();
        conn = DbConnect.connecrDb();
         logo();
        
    }
       public static reprint_receipt getObj() {
        if (obj== null){
            obj = new reprint_receipt();
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        jCalendar1 = new com.toedter.calendar.JCalendar();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        id = new javax.swing.JTextField();
        search = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        pdate = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        reprint = new javax.swing.JTable()
        {
            public boolean isCellEditable(int rowindex, int colIndex)
            { return false;}
        }
        ;
        rctpanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtp = new javax.swing.JTextPane();
        print = new javax.swing.JButton();

        jScrollPane3.setViewportView(jEditorPane1);

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
        setTitle("Reprint Receipt");
        setResizable(false);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/gakuyo.png"))); // NOI18N

        jLabel2.setText("ID NUMBER:");

        id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idActionPerformed(evt);
            }
        });

        search.setText("Search");
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });

        jLabel3.setText("POSTING DATE");

        pdate.setDateFormatString("yyyy-MM-dd");

        reprint.setModel(new javax.swing.table.DefaultTableModel(
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
        reprint.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                reprintMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(reprint);

        jtp.setEditable(false);
        jtp.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jtp.setToolTipText("");
        jScrollPane2.setViewportView(jtp);

        javax.swing.GroupLayout rctpanelLayout = new javax.swing.GroupLayout(rctpanel);
        rctpanel.setLayout(rctpanelLayout);
        rctpanelLayout.setHorizontalGroup(
            rctpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rctpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 532, Short.MAX_VALUE)
                .addContainerGap())
        );
        rctpanelLayout.setVerticalGroup(
            rctpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rctpanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        print.setText("PRINT");
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
                                .addGap(71, 71, 71)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 565, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(jLabel3)
                                            .addGap(18, 18, 18)
                                            .addComponent(pdate, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(28, 28, 28)
                                            .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(rctpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(320, 320, 320)
                                .addComponent(print)))
                        .addGap(0, 113, Short.MAX_VALUE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addComponent(pdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(search))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rctpanel, javax.swing.GroupLayout.PREFERRED_SIZE, 360, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(print)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(775, 693));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
       
       if(!jtp.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "<html><h4><font color='red'>print current receipt!</font></h4></html>");
        }
       else if(id.getText().isEmpty()||((JTextField)pdate.getDateEditor().getUiComponent()).getText().isEmpty()){
           JOptionPane.showMessageDialog(null,  "<html><h4><font color='red'>fill all fields!</font></h4></html>");
       }
           else if(conn==null){
            JOptionPane.showMessageDialog(this, "Could not connect to the server");
        }
            else{try{
                         String check ="SELECT COUNT(*) AS total FROM receipt where "
                                 + "client_id = '"+id.getText()+"' and pdate='"+((JTextField)pdate.getDateEditor().getUiComponent()).getText().trim()+"'"; 
                            pst=conn.prepareStatement(check);
                            rs = pst.executeQuery();
                            
                          while(rs.next()){
                              
                              if(rs.getInt("total")>0){
                                         
                              String sland = "select receiptno as 'Receipt No.',client_id as 'ID Number',cname as 'Client Name',pdate as 'Posting Date',amount from receipt where "
                                      + "client_id = '"+id.getText()+"' and pdate='"+((JTextField)pdate.getDateEditor().getUiComponent()).getText().trim()+"' ";

                        pst = conn.prepareStatement(sland);
                        rs=pst.executeQuery();
                        
                        reprint.setModel( DbUtils.resultSetToTableModel(rs));
                              }
                        else{
                           JOptionPane.showMessageDialog(null, "No record found");

                              }}}
                
           catch(SQLException e){
        JOptionPane.showMessageDialog(null, e);
    }
         
         }
    }//GEN-LAST:event_searchActionPerformed
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
          
            }
            catch(java.awt.print.PrinterException e)
            {
                PrintStream format = System.err.format("Cannot print %s%n");
            }

        }
    }//GEN-LAST:event_printActionPerformed

    private void reprintMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reprintMouseClicked
        conn = DbConnect.connecrDb();
        if(jtp.getText().isEmpty()){
             
             try{
            int row = reprint.getSelectedRow();
            int col = reprint.getSelectedColumn();
            
            
            String tableclicked = (reprint.getModel().getValueAt(row, col).toString());
            String sql = "select* from receipt where receiptno ='"+tableclicked+"'";
             pst=conn.prepareStatement(sql);
             rs = pst.executeQuery();
             
             while(rs.next()){
             String amnt = rs.getString("amount");
             int n = Integer.parseInt(amnt);
                    String Englishword = EnglishNumber(n);
                    String amntw = " " + Englishword+ " "+"Kenya Shillings Only";
             String nme = rs.getString("cname");
             String rctno = rs.getString("receiptno");
             String tday = rs.getString("tdate");
             String pday = rs.getString("pdate");
             String pmd = rs.getString("pmode");
             String ptyp = rs.getString("ptype");
             String br = rs.getString("branch");
             String sg = ".............";
             String Deposited="....................";
             String cshier = rs.getString("servedby");
             String ttl="\t\t\tGAKUYO REAL ESTATE";
              StyledDocument dc = (StyledDocument) jtp.getDocument();
              Style style = dc.addStyle("Tahoma", null);
              StyleConstants.setFontSize(style, 11);
              jtp.setPage(getClass().getResource("logo.html"));
              jtp.getStyledDocument().insertString(1,ttl+ "\nBranch"+" "+br+"  "+ " "+"Date Of Posting"+" "+pday+  "  "+ " "+"Transaction Date"+"  "+tday+" "+" "+"\nClient Name\t\t\t\t"+nme+"\nReceiptNo\t\t\t\t"+rctno+""
                            +"\nPayment Type\t\t\t"+ptyp+"\nMode Of Payment\t\t\t"+pmd+"\nAmount\t\t\t\t"+amnt+"\nAmount in Words:"+amntw+"\nDeposited By:"+Deposited+""
                                    + "Client Signature:"+sg+"Served by "+cshier+"\n\t\t Where Trust Meets Your Vision",style); 
             }
        } catch (SQLException ex) {
            Logger.getLogger(reprint_receipt.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(reprint_receipt.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BadLocationException ex) {
            Logger.getLogger(reprint_receipt.class.getName()).log(Level.SEVERE, null, ex);
        }
             
            }  
         else{
       
         JOptionPane.showMessageDialog(null, "<html><h4><font color='red'>print current receipt first!</font></h4></html>");
         }
    }//GEN-LAST:event_reprintMouseClicked

    private void idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idActionPerformed

  
    public static void main(String args[]) {
   
        java.awt.EventQueue.invokeLater(() -> {
            new reprint_receipt().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField id;
    private com.toedter.calendar.JCalendar jCalendar1;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextPane jtp;
    private com.toedter.calendar.JDateChooser pdate;
    private javax.swing.JButton print;
    private javax.swing.JPanel rctpanel;
    private javax.swing.JTable reprint;
    private javax.swing.JButton search;
    // End of variables declaration//GEN-END:variables
}
