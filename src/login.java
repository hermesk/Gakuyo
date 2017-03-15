

import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class login extends javax.swing.JFrame {

    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public login() {
        
        initComponents();
        conn = DbConnect.connecrDb();
        setResizable(false);
         logo();
    }
    
    private void logo(){
    setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("images/LOG.png")));
    }
    public void close() {
        WindowEvent winClosingEvent = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        cmd_login = new javax.swing.JButton();
        txt_password = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txt_user = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Login");

        jLabel4.setBackground(new java.awt.Color(0, 102, 51));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("LOGIN TO GAKUYO RMS");

        cmd_login.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/login.jpg"))); // NOI18N
        cmd_login.setText("Login");
        cmd_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd_loginActionPerformed(evt);
            }
        });

        txt_password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_passwordKeyPressed(evt);
            }
        });

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("PASSWORD");

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("USERNAME");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/login.png"))); // NOI18N

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/gakuyo.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmd_login, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                            .addComponent(txt_user)
                            .addComponent(txt_password)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jLabel6)))
                .addContainerGap(65, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txt_user, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23)
                                .addComponent(txt_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(29, 29, 29)
                                .addComponent(jLabel2)))
                        .addGap(32, 32, 32)
                        .addComponent(cmd_login))
                    .addComponent(jLabel5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_passwordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_passwordKeyPressed
        if (evt.getKeyCode()==KeyEvent.VK_ENTER) {
             if (txt_user.getText().trim().isEmpty() || txt_password.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "<html>Fill all fields!</html>");
        }
            else if(conn==null){
            JOptionPane.showMessageDialog(null, "Could not connect to the server");
        }
            else{
            try {
                String sql = "select * from [user] where username COLLATE Latin1_General_CS_AS=? and password=?";
                pst = conn.prepareStatement(sql);
                pst.setString(1, txt_user.getText().trim());
                pst.setString(2, md5(txt_password.getText().trim()));

                rs = pst.executeQuery();

                if (rs.next()) {
                     
               String level = rs.getString("level");
              
                    switch (level) {
                        case "user":
                            {
                                MainGakuyo hm = new MainGakuyo();
                                hm.setVisible(true);
                                MainGakuyo.backoffice_setup.setEnabled(false);
                                MainGakuyo.username.setText(txt_user.getText()); 

                                close();
                                break;
                            }
                        case "admin":
                            {
                                MainGakuyo hm = new MainGakuyo();
                                MainGakuyo.username.setText(txt_user.getText()); 
                                hm.setVisible(true);
                                close();
                                break;
                            }
                        case "manager":
                            {
                                MainGakuyo hm = new MainGakuyo();
                                hm.setVisible(true);
                                MainGakuyo.username.setText(txt_user.getText()); 
                                MainGakuyo.menu_clientdetails.setEnabled(false);
                                MainGakuyo.Credit.setEnabled(false);
                                MainGakuyo.withdrawals.setEnabled(false);
                                MainGakuyo.payment_voucher_section.setEnabled(false);
                                MainGakuyo.backoffice_setup.setEnabled(false);
                               close();
                                break;
                            }
                        default:
                            break;
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect username or password");
                }
            } catch (HeadlessException | SQLException ex) {

            }
   
        }}
    }//GEN-LAST:event_txt_passwordKeyPressed

    private void cmd_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_loginActionPerformed
        if (txt_user.getText().trim().isEmpty() || txt_password.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "<html>Fill all fields!</html>");
        }
        else if(conn==null){
            JOptionPane.showMessageDialog(null, "Could not connect to the server");
        }
        else {

            try {
                String sql = "select * from [user] where username COLLATE Latin1_General_CS_AS=? and password=?";
                pst = conn.prepareStatement(sql);
                pst.setString(1, txt_user.getText());
                pst.setString(2, md5(txt_password.getText().trim()));

                rs = pst.executeQuery();

                if (rs.next()) {
                   
                   String level = rs.getString("level");
                  
                    switch (level) {
                        case "user":
                            {
                                MainGakuyo hm = new MainGakuyo();
                                hm.setVisible(true);
                                MainGakuyo.username.setText(txt_user.getText()); 
                                MainGakuyo.backoffice_setup.setEnabled(false);
                                close();
                                break;
                            }
                        case "admin":
                            {   
                                MainGakuyo hm = new MainGakuyo();
                                MainGakuyo.username.setText(txt_user.getText()); 
                                hm.setVisible(true);
                                close();
                                break;
                            }
                        case "manager":
                            {
                                MainGakuyo hm = new MainGakuyo();
                                hm.setVisible(true);
                                MainGakuyo.username.setText(txt_user.getText()); 
                                MainGakuyo.menu_clientdetails.setEnabled(false);
                                MainGakuyo.Credit.setEnabled(false);
                                MainGakuyo.withdrawals.setEnabled(false);
                                MainGakuyo.payment_voucher_section.setEnabled(false);
                                MainGakuyo.backoffice_setup.setEnabled(false);
                               close();
                                break;
                            }
                        default:
                            break;
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect username or password");
                }
            } catch (HeadlessException | SQLException ex) {

            }
 
        }
    }//GEN-LAST:event_cmd_loginActionPerformed

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
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> {
            new login().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmd_login;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField txt_password;
    public static javax.swing.JTextField txt_user;
    // End of variables declaration//GEN-END:variables
}
