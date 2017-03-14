
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class register extends javax.swing.JDialog {

    Connection conn = null;
    ResultSet rs = null;
    
   private static register obj=null;
   
    PreparedStatement pst = null;

    
   private register() {
      
        initComponents();
        conn = DbConnect.connecrDb();
        update_table();
      ProperyDetails();
     logo();
    }
       public static register getObj() {
        if (obj== null){
            obj = new register();
        }
      else{
         obj.setAlwaysOnTop(true);
         obj.requestFocus();
       }
       return obj;
 }
       private void update_table(){
    if(conn==null){
            JOptionPane.showMessageDialog(this, "Could not connect to the server");
        }
           try{
          String sql = "select  username,password from [user]";
          pst = conn.prepareStatement(sql);
          rs=pst.executeQuery();

      }
      catch(SQLException e)
      {
             JOptionPane.showMessageDialog(null,e);
            }
  
       
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
         
                  }
       }
     catch(SQLException e)
     {
                 JOptionPane.showMessageDialog(null, e);
    }
  
             }      }
 
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        pwd = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        cpwd = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        uname = new javax.swing.JTextField();
        cmd_register = new javax.swing.JButton();
        cmd_del = new javax.swing.JButton();
        cmd_clear = new javax.swing.JButton();
        cmd_update = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        fname = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        lname = new javax.swing.JTextField();
        branch = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        level = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        searchuser = new javax.swing.JButton();

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
        setTitle("Add New User");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setIconImages(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Register User", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        pwd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pwdActionPerformed(evt);
            }
        });

        jLabel1.setText("Username");

        cpwd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cpwdKeyPressed(evt);
            }
        });

        jLabel2.setText("Password");

        jLabel3.setText("Confirm password");

        uname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unameActionPerformed(evt);
            }
        });

        cmd_register.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/register.png"))); // NOI18N
        cmd_register.setText("Register");
        cmd_register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd_registerActionPerformed(evt);
            }
        });

        cmd_del.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Button-Close-icon.png"))); // NOI18N
        cmd_del.setText("Delete");
        cmd_del.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd_delActionPerformed(evt);
            }
        });

        cmd_clear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Clear-icon.png"))); // NOI18N
        cmd_clear.setText("Clear");
        cmd_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd_clearActionPerformed(evt);
            }
        });

        cmd_update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/update.png"))); // NOI18N
        cmd_update.setText("Update");
        cmd_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd_updateActionPerformed(evt);
            }
        });

        jLabel5.setText("Firstname");

        jLabel6.setText("Lastname");

        branch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                branchActionPerformed(evt);
            }
        });

        jLabel7.setText("Branch");

        jLabel8.setText("Access Level");

        level.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "admin", "manager", "user" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cmd_register)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmd_clear)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmd_update)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmd_del)))
                        .addContainerGap(14, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(branch, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lname)
                            .addComponent(cpwd)
                            .addComponent(fname)
                            .addComponent(uname)
                            .addComponent(pwd)
                            .addComponent(level, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(171, 171, 171))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(uname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(pwd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cpwd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(fname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(branch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(level, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmd_register)
                    .addComponent(cmd_clear)
                    .addComponent(cmd_update)
                    .addComponent(cmd_del))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/gakuyo.png"))); // NOI18N

        jLabel9.setText("Search user");

        searchuser.setText("SEARCH");
        searchuser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchuserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(204, 204, 204)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(searchuser))
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(142, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchuser))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cmd_registerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_registerActionPerformed
        if(uname.getText().trim().isEmpty()||pwd.getText().trim().isEmpty()||cpwd.getText().trim().isEmpty()
                ||fname.getText().trim().isEmpty()||lname.getText().trim().isEmpty()){
           JOptionPane.showMessageDialog(null, "<html>Fill all fields!</html>");
           }
        else if(!pwd.getText().trim().equals(cpwd.getText().trim())){
       JOptionPane.showMessageDialog(null, "<html>Password Mismatch!</html>");
        }
          else if(conn==null){
            JOptionPane.showMessageDialog(this, "Could not connect to the server");
        }
        else if(uname.getText().length()>2){
        
         try
                     {
                        String check ="SELECT COUNT(*) AS total FROM [user] where username = '"+uname.getText()+"'"; 
                        pst=conn.prepareStatement(check);
                        rs = pst.executeQuery();
                        while(rs.next()){
                        if(rs.getInt("total")>0)
                        {
                          JOptionPane.showMessageDialog(null, "username already exist!");
                        }
              else{
                  
                   String checkp ="SELECT COUNT(*) AS total FROM [user] where password = '"+pwd.getText()+"'"; 
                        pst=conn.prepareStatement(checkp);
                        rs = pst.executeQuery();
                        while(rs.next()){
                        if(rs.getInt("total")>0)
                        {
                          JOptionPane.showMessageDialog(null, "Choose a stronger password");
                        }
                        else{ 
                 String sql = "insert into [user](username,password,fname,lname,branch,level) values (?,?,?,?,?,?)";
              
                 
                pst=conn.prepareStatement(sql);
                pst.setString(1, uname.getText().trim()); 
                pst.setString(2,md5((pwd.getText()).trim()));
                pst.setString(3, fname.getText().trim());
                pst.setString(4, lname.getText().trim());
                pst.setString(5, branch.getSelectedItem().toString());
                pst.setString(6, level.getSelectedItem().toString());
                pst.execute();
               
                 JOptionPane.showMessageDialog(null, "Saved");
        
                        }
                        }
                        }}
                     }catch (SQLException e) {
                               JOptionPane.showMessageDialog(null, e);
                               
                           }
  
                     uname.setText("");
                     pwd.setText("");
                     cpwd.setText("");
                     fname.setText("");
                     lname.setText("");
                     
        }
                     else{
        JOptionPane.showMessageDialog(null, "Choose a better username");
        }
        
            
    }//GEN-LAST:event_cmd_registerActionPerformed

    private void cmd_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_clearActionPerformed
        // TODO add your handling code here:
         uname.setText("");
         pwd.setText("");
         cpwd.setText("");
         fname.setText("");
         lname.setText("");
        
         
        
    }//GEN-LAST:event_cmd_clearActionPerformed

    private void cmd_delActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_delActionPerformed
        if(uname.getText().isEmpty()||pwd.getText().isEmpty()||cpwd.getText().isEmpty()){
           JOptionPane.showMessageDialog(null, "<html>Fill all fields!</html>");
        }
        else if(!pwd.getText().trim().equals(cpwd.getText().trim())){
            
       JOptionPane.showMessageDialog(null, "<html>Password mismatch!</html>");
        }
          else if(conn==null){
            JOptionPane.showMessageDialog(this, "Could not connect to the server");
        }
        else{
             int d = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete", "Delete", JOptionPane.YES_NO_OPTION);

            if(d==0){

            try {
                
                String name =  level.getSelectedItem().toString(); 
                 if(!name.equals("admin")&&!name.equals("root"))
                 {  String sql = "delete from [user] where username=?";
                     pst=conn.prepareStatement(sql);
                     pst.setString(1, uname.getText().trim());
                     pst.execute();
                     JOptionPane.showMessageDialog(null, "Deleted");
 
                    }
                 else{     
               JOptionPane.showMessageDialog(null, "<html>Cannot Delete Admin Account</html>");

                     }

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);

            }
       
            }}
    }//GEN-LAST:event_cmd_delActionPerformed

    private void cmd_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_updateActionPerformed
        if(uname.getText().trim().isEmpty()||pwd.getText().trim().isEmpty()||cpwd.getText().trim().isEmpty()
                ||fname.getText().trim().isEmpty()||lname.getText().trim().isEmpty()){
           JOptionPane.showMessageDialog(null, "<html>Fill all fields!</html>");
           }
        else if(!pwd.getText().trim().equals(cpwd.getText().trim())){
       JOptionPane.showMessageDialog(null, "<html>Password mismatch!</html>");

        }
      else if(conn==null){
            JOptionPane.showMessageDialog(this, "Could not connect to the server");
        }    
       else{
        try{
            String checkp ="SELECT * FROM [user] where username='"+uname.getText()+"'"; 
                       
                        pst=conn.prepareStatement(checkp);
                        rs = pst.executeQuery();
             while(rs.next()){
                        
                 String  value1 = uname.getText().trim();
                String  value2 = md5(pwd.getText().trim());
                String  value3 = fname.getText().trim();
                String  value4 = lname.getText().trim();
                String  value5 = branch.getSelectedItem().toString();
                String  value6 = level.getSelectedItem().toString();

                String sql = "update [user] set username='"+value1+"',password='"+value2+"',fname= '"+value3+"',lname='"+value4+"',branch ='"+value5+"',level='"+value6+"'WHERE username='"+value1+"'";

                pst = conn.prepareStatement(sql);
                pst.execute();
                JOptionPane.showMessageDialog(null, "Updated");
                        
                        
                        }
              }
               catch(NumberFormatException | SQLException e){
        JOptionPane.showMessageDialog(null, e);
        }
  
            }
           
    }//GEN-LAST:event_cmd_updateActionPerformed

    private void cpwdKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cpwdKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
             
        if(uname.getText().trim().isEmpty()||pwd.getText().trim().isEmpty()||cpwd.getText().trim().isEmpty()){
                JOptionPane.showMessageDialog(null, "<html>Fill all fields!</html>");
           }
        else if(!pwd.getText().trim().equals(cpwd.getText().trim())){
                 JOptionPane.showMessageDialog(null, "<html>Password Mismatch!</html>");
        }
          else if(conn==null){
            JOptionPane.showMessageDialog(this, "Could not connect to the server");
        }
        else if(uname.getText().length()>0){
        
         try
                     {
                        String check ="SELECT COUNT(*) AS total FROM user  where username = '"+uname.getText()+"'"; 
                        pst=conn.prepareStatement(check);
                        rs = pst.executeQuery();
                        
          while(rs.next()){
             if(rs.getInt("total")>0)
                        {
                          JOptionPane.showMessageDialog(null, "username already exist!");
                        }
          else{
                try{
                 String sql = "insert into [user](username,password,fname,lname,branch) values (?,?,?,?,?)";
                pst=conn.prepareStatement(sql);
                pst.setString(1, uname.getText().trim()); 
                pst.setString(2,md5(pwd.getText()).trim());
                pst.setString(3, fname.getText().trim());
                pst.setString(4, lname.getText().trim());
                pst.setString(5,branch.getSelectedItem().toString().trim()); 
                
                pst.execute();
               
                 JOptionPane.showMessageDialog(null, "Saved");
                }
              
        catch(SQLException | HeadlessException e){

        }
              
       
             }}
                     }catch (SQLException e) {
                               JOptionPane.showMessageDialog(null, e);
                               
                           }
   
       
        }
                     
 }
    }//GEN-LAST:event_cpwdKeyPressed

    private void unameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_unameActionPerformed

    private void pwdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pwdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pwdActionPerformed

    private void branchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_branchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_branchActionPerformed

    private void searchuserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchuserActionPerformed
       if(username.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "enter username");
        }
        else if(conn==null){
            JOptionPane.showMessageDialog(this, "Could not connect to the server");
        }
        else{
           try{
               String checkU ="SELECT COUNT(*) AS total FROM [user] where username COLLATE Latin1_General_CS_AS= '"+username.getText()+"'"; 
                        pst=conn.prepareStatement(checkU);
                        rs = pst.executeQuery();
                         while(rs.next()){
             if(rs.getInt("total")>0)
                        {
                      String ck= "select * from [user] where username COLLATE Latin1_General_CS_AS='"+username.getText()+"'";
                        pst=conn.prepareStatement(ck);
                        rs = pst.executeQuery();
              while(rs.next()){  
                uname.setText(rs.getString("username").trim());
                pwd.setText(rs.getString("password").trim());
                cpwd.setText(rs.getString("password").trim());
                branch.setSelectedItem(rs.getString("branch"));
                fname.setText(rs.getString("fname").trim());
                lname.setText(rs.getString("lname").trim());
                level.setSelectedItem(rs.getString("level").trim());
                        }}
             else{
             JOptionPane.showMessageDialog(this, "user does not exist");
             
             }
                         }
           
           }
           catch(SQLException | HeadlessException e){
           JOptionPane.showMessageDialog(null, e);
           }
        
        }
        
        
        
    }//GEN-LAST:event_searchuserActionPerformed
             public void close(){
        WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
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
            java.util.logging.Logger.getLogger(register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new register().setVisible(true);
        });
    }
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
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> branch;
    private javax.swing.JButton cmd_clear;
    private javax.swing.JButton cmd_del;
    private javax.swing.JButton cmd_register;
    private javax.swing.JButton cmd_update;
    private javax.swing.JPasswordField cpwd;
    private javax.swing.JTextField fname;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> level;
    private javax.swing.JTextField lname;
    private javax.swing.JPasswordField pwd;
    private javax.swing.JButton searchuser;
    private javax.swing.JTextField uname;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables

    
}
