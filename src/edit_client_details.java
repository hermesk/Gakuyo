
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class edit_client_details extends javax.swing.JFrame {

    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
     private static edit_client_details obj=null;
     
    private edit_client_details() {
        initComponents();
        
       conn = DbConnect.connecrDb();
       
       ProperyDetails();
       setResizable(false);
       
   logo();
    }
       public static edit_client_details getObj() {
        if (obj== null){
            obj = new edit_client_details();
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
   private void ProperyDetails(){
    if(conn==null){
            JOptionPane.showMessageDialog(this, "Could not connect to the server");
        }  
       else{
               try{
         String sql = "select *from property_location";
         pst = conn.prepareStatement(sql);
         rs =pst.executeQuery();
         while(rs.next()){
          String br = rs.getString("branch");         
          branch.addItem(br);
         
               }   }
       
     catch(SQLException e)
     {
                 JOptionPane.showMessageDialog(null, e);
    }
    }  }
 public void close(){
        WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
         }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        branch = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        title = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        client_id = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        client_phone = new javax.swing.JTextField();
        clear_table = new javax.swing.JButton();
        update_clients = new javax.swing.JButton();
        delete_clients = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        text_search = new javax.swing.JTextField();
        id_search = new javax.swing.JButton();
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
        setTitle("EDIT CLIENT DETAILS SECTION");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CLIENT DETAILS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N
        jPanel1.setToolTipText("CLIENT DETAILS");

        jLabel1.setText("BRANCH");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("NAME :");

        name.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        name.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nameKeyTyped(evt);
            }
        });

        title.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mr.", "Mrs", "Ms", "Sir" }));

        jLabel3.setText("ID/PASSPORT NUMBER");

        client_id.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        client_id.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                client_idKeyTyped(evt);
            }
        });

        jLabel4.setText("PHONE NO:");

        client_phone.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        client_phone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                client_phoneActionPerformed(evt);
            }
        });
        client_phone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                client_phoneKeyTyped(evt);
            }
        });

        clear_table.setText("CLEAR");
        clear_table.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clear_tableActionPerformed(evt);
            }
        });

        update_clients.setText("UPDATE");
        update_clients.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_clientsActionPerformed(evt);
            }
        });

        delete_clients.setText("DELETE");
        delete_clients.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_clientsActionPerformed(evt);
            }
        });

        jLabel8.setText("SEARCH BY ID");

        text_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_searchActionPerformed(evt);
            }
        });
        text_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                text_searchKeyTyped(evt);
            }
        });

        id_search.setText("SEARCH");
        id_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                id_searchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(branch, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(214, 214, 214))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 4, Short.MAX_VALUE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(update_clients)
                                        .addGap(18, 18, 18)
                                        .addComponent(delete_clients)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(client_id, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(client_phone)))))
                        .addContainerGap(16, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(clear_table))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel8)
                        .addGap(14, 14, 14)
                        .addComponent(text_search, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(id_search)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(text_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(id_search))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(branch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(client_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(client_phone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clear_table)
                    .addComponent(update_clients)
                    .addComponent(delete_clients))
                .addContainerGap(143, Short.MAX_VALUE))
        );

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/gakuyo.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void client_phoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_client_phoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_client_phoneActionPerformed

    private void text_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text_searchActionPerformed

    private void id_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_id_searchActionPerformed
        if(text_search.getText().isEmpty()){
              JOptionPane.showMessageDialog(null, "<html><h4><font color='red'>Enter ID or Passport no!</font></h4></html>");       
                }
         else{
       if(conn==null){
            JOptionPane.showMessageDialog(this, "Could not connect to the server");
        }  
              else{
                     try{
                         String check ="SELECT COUNT(*) AS total,branch,title,name,id,phone FROM client_detail where id = '"+text_search.getText()+"' GROUP BY branch,title,name,id,phone"; 
                            pst=conn.prepareStatement(check);
                            rs = pst.executeQuery();
                            
                             while(rs.next()){
                              
                              if(rs.getInt("total")>0){
                                         
                 branch.setSelectedItem(rs.getString("branch"));
                 title.setSelectedItem(rs.getString("title"));
                 name.setText(rs.getString("name"));
                 client_id.setText(rs.getString("id"));
                 client_phone.setText(rs.getString("phone"));
                              }
                      
                      else  {
                           JOptionPane.showMessageDialog(null, "Client with ID No"+" "+text_search.getText()+" "+"does not exist");

                              }}} catch (SQLException ex) {
                Logger.getLogger(edit_client_details.class.getName()).log(Level.SEVERE, null, ex);
            }
                     } 
        }           
        
    }//GEN-LAST:event_id_searchActionPerformed

    private void clear_tableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clear_tableActionPerformed
         client_id.setText("");
        
        client_phone.setText("");

        name.setText("");
        
    }//GEN-LAST:event_clear_tableActionPerformed

    private void delete_clientsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_clientsActionPerformed
        if(client_id.getText().isEmpty()||client_phone.getText().isEmpty()||name.getText().isEmpty())
            {
            JOptionPane.showMessageDialog(null, "<html>Fill all the fields!</html>");

        }
     
        else{
             conn = DbConnect.connecrDb();
             if(conn==null){
            JOptionPane.showMessageDialog(this, "Could not connect to the server");
        }  
                else{
            int d = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete", "Delete", JOptionPane.YES_NO_OPTION);

            if(d==0){    
               
               String sql = "delete from client_detail where id =?";
               try {
                    
                    pst=conn.prepareStatement(sql);
                    pst.setString(1, text_search.getText());
                    pst.execute();
                    JOptionPane.showMessageDialog(null, "deleted");

                } catch (SQLException ex) {
                    Logger.getLogger(edit_client_details.class.getName()).log(Level.SEVERE, null, ex);
                }
            }}
        }
    }//GEN-LAST:event_delete_clientsActionPerformed

    private void update_clientsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_clientsActionPerformed
       
        if(client_id.getText().isEmpty()||client_phone.getText().isEmpty()||name.getText().isEmpty() )
             {
           JOptionPane.showMessageDialog(null, "<html>Fill all the fields!</html>");
        }

        else if(client_id.getText().length()>8)
        {
           JOptionPane.showMessageDialog(null, "<html>Invalid Id Number!</html>");
        }
   
        else{
              conn = DbConnect.connecrDb();
               if(conn==null){
            JOptionPane.showMessageDialog(this, "Could not connect to the server");
        }  
                else{
            try{
                
                
                
                String  value1 = branch.getSelectedItem().toString().toUpperCase().trim();
                String  value2 = title.getSelectedItem().toString().toUpperCase().trim();
                
                String  value3 = name.getText().toUpperCase().trim();
               
                String  value = client_id.getText().toUpperCase().trim();
                
                 String sql = "update client_detail set branch= '"+value1+"',title='"+value2+"',name='"+value3+"' where id ='"+value+"'";
                 
                 pst = conn.prepareStatement(sql);
                pst.execute();
                JOptionPane.showMessageDialog(null, "Successfully Updated");
            } catch (SQLException ex) {
                Logger.getLogger(edit_client_details.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
        }
    }//GEN-LAST:event_update_clientsActionPerformed

    private void nameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameKeyTyped
     
    }//GEN-LAST:event_nameKeyTyped

    private void client_idKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_client_idKeyTyped
       char c=evt.getKeyChar();
        if(!(Character.isAlphabetic(c) ||  (c==KeyEvent.VK_BACK_SPACE)||  c==KeyEvent.VK_DELETE ||Character.isDigit(c))){
        evt.consume();
        getToolkit().beep();}
    }//GEN-LAST:event_client_idKeyTyped

    private void client_phoneKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_client_phoneKeyTyped
        char c=evt.getKeyChar();
        if(!((c==KeyEvent.VK_BACK_SPACE)||  c==KeyEvent.VK_DELETE ||Character.isDigit(c))){
        evt.consume();
        getToolkit().beep();}
        
    }//GEN-LAST:event_client_phoneKeyTyped

    private void text_searchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_text_searchKeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c)
                || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE || evt.getKeyChar() == ',')) {
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_text_searchKeyTyped

  
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(() -> {
            new edit_client_details().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> branch;
    private javax.swing.JButton clear_table;
    private javax.swing.JTextField client_id;
    private javax.swing.JTextField client_phone;
    private javax.swing.JButton delete_clients;
    private javax.swing.JButton id_search;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField name;
    private javax.swing.JTextField text_search;
    private javax.swing.JComboBox<String> title;
    private javax.swing.JButton update_clients;
    // End of variables declaration//GEN-END:variables
}
