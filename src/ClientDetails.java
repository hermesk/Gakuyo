
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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

public class ClientDetails extends javax.swing.JFrame {

    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    //current date
    DateFormat dF = new SimpleDateFormat("yyyy-MM-dd");
       Date date = new Date();
       String td=dF.format(date);
   private static ClientDetails obj=null;

    
    private ClientDetails() {
        initComponents();
        conn = DbConnect.connecrDb();
        ProperyDetails();
        Current_Date();
        setResizable(false);
        logo();
    }
   public static ClientDetails getObj() {
       if (obj== null){
         obj = new ClientDetails();
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
    public final void Current_Date(){
     current_date.setText(td);
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
          }}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        id = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        cmd_save = new javax.swing.JButton();
        phoneNo = new javax.swing.JTextField();
        title = new javax.swing.JComboBox<>();
        Combo_property = new javax.swing.JComboBox<>();
        txt_search = new javax.swing.JTextField();
        cmd_search = new javax.swing.JButton();
        name = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        branch = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        current_date = new javax.swing.JLabel();
        idp = new javax.swing.JComboBox<>();
        jMenuBar1 = new javax.swing.JMenuBar();

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
        setTitle("Client Details");

        id.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        id.setText(null);
        id.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                idFocusGained(evt);
            }
        });
        id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idActionPerformed(evt);
            }
        });
        id.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                idKeyTyped(evt);
            }
        });

        jLabel9.setText("Search by ID");

        cmd_save.setText("NEXT");
        cmd_save.setActionCommand("");
        cmd_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd_saveActionPerformed(evt);
            }
        });

        phoneNo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        phoneNo.setText(null);
        phoneNo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                phoneNoFocusGained(evt);
            }
        });
        phoneNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phoneNoActionPerformed(evt);
            }
        });
        phoneNo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                phoneNoKeyTyped(evt);
            }
        });

        title.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mr.", "Mrs", "Ms", "Sir" }));

        Combo_property.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Land", "House", "GZD" }));
        Combo_property.setToolTipText("");
        Combo_property.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Combo_propertyActionPerformed(evt);
            }
        });

        txt_search.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_searchFocusGained(evt);
            }
        });

        cmd_search.setText("Search");
        cmd_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd_searchActionPerformed(evt);
            }
        });

        name.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        name.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                nameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                nameFocusLost(evt);
            }
        });
        name.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                nameMouseReleased(evt);
            }
        });
        name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameActionPerformed(evt);
            }
        });
        name.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nameKeyTyped(evt);
            }
        });

        jLabel10.setText("Transaction Type:");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("NAME");

        jLabel5.setText(" Phone No.");

        jLabel1.setText("Branch");

        branch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                branchActionPerformed(evt);
            }
        });

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/gakuyo.png"))); // NOI18N

        jLabel2.setText("Member Details");

        current_date.setText("Date");

        idp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID", "PASSPORT" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(idp, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(id, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(phoneNo, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(82, 82, 82))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Combo_property, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(252, 252, 252))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(branch, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(current_date)
                    .addComponent(cmd_search))
                .addGap(17, 17, 17))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(262, 262, 262)
                        .addComponent(cmd_save)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(current_date)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addGap(28, 28, 28))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmd_search)
                        .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(branch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(phoneNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(idp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(Combo_property, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmd_save)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        jDesktopPane1.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(74, Short.MAX_VALUE)
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(691, 479));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void nameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nameFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_nameFocusGained

    private void nameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nameFocusLost
        // TODO add your handling code here:
      
    }//GEN-LAST:event_nameFocusLost

    private void nameMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nameMouseReleased
        // TODO add your handling code here:
          String sname = name.getText();
        if(sname.isEmpty()){
           name.setText("");
        }
    }//GEN-LAST:event_nameMouseReleased

    private void cmd_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_saveActionPerformed
        if(name.getText().isEmpty()||id.getText().isEmpty()||phoneNo.getText().isEmpty())
        {
                   JOptionPane.showMessageDialog(null, "<html><h4><font color='red'>Fill all the fields!</font></h4></html>");
        }
       else if(id.getText().length()!=8 &&idp.getSelectedItem()=="ID"){
            JOptionPane.showMessageDialog(null, "ID must be 8 digits");
                   }
        else if(conn==null){
            JOptionPane.showMessageDialog(null, "Could not connect to the server");
        }
         else if(!id.getText().isEmpty()){
             try{
                 String check ="SELECT COUNT(*) AS total,name FROM client_detail  where id = '"+id.getText()+"' GROUP BY name"; 
                        pst=conn.prepareStatement(check);
                        rs = pst.executeQuery();
                        while(rs.next()){
                  if(rs.getInt("total")>0)
                        {
                            String nm =rs.getString("name");
                          JOptionPane.showMessageDialog(null, nm+ " "+"already exist");
                          
                          String property = Combo_property.getSelectedItem().toString();
            switch (property) {
                case "Land":
                  
                    new land().setVisible(true);
                    land.id.setText(id.getText().toUpperCase().trim());
                    land.cname.setText(name.getText().toUpperCase().trim());
                    land.id.setEnabled(false);
                    land.cname.setEnabled(false);
                     close();
                    break;
                case "House":
                    new house().setVisible(true);
                    house.id.setText(id.getText().toUpperCase().trim());
                    house.cname.setText(name.getText().toUpperCase().trim());
                    house.id.setEnabled(false);
                    house.cname.setEnabled(false);
                      close();
                      break;
                case "GZD":
                  new GakuyoZeroDeposit().setVisible(true);
                   GakuyoZeroDeposit.id.setText(id.getText().toUpperCase().trim());
                   GakuyoZeroDeposit.cname.setText(name.getText().toUpperCase().trim());
                   GakuyoZeroDeposit.id.setEnabled(false);
                   GakuyoZeroDeposit.cname.setEnabled(false);
                    close();
                    break;
                    default:
                    break;
            }
                        }
           else {
             
                  String addclient = "insert into client_detail(title,name,id,phone,branch)"
                    + "values(?,?,?,?,?)";
                  
                            pst = conn.prepareStatement(addclient);
                            pst.setString(1, title.getSelectedItem().toString());                               
                            pst.setString(2, name.getText().toUpperCase().trim());
                            pst.setString(3, id.getText().toUpperCase().trim());
                            pst.setString(4, phoneNo.getText().toUpperCase().trim());
                            pst.setString(5, branch.getSelectedItem().toString());  
                            pst.execute();
                            JOptionPane.showMessageDialog(null, "Saved");
             
                      
        String property = Combo_property.getSelectedItem().toString();
            switch (property) {
                case "Land":
                  
                    new land().setVisible(true);
                    land.id.setText(id.getText().toUpperCase().trim());
                    land.cname.setText(name.getText().toUpperCase().trim());
                    land.id.setEnabled(false);
                    land.cname.setEnabled(false);
                     close();
                    break;
                case "House":
                    new house().setVisible(true);
                    house.id.setText(id.getText().toUpperCase().trim());
                    house.cname.setText(name.getText().toUpperCase().trim());
                    house.id.setEnabled(false);
                    house.cname.setEnabled(false);
                      close();
                      break;
                case "GZD":
                  new GakuyoZeroDeposit().setVisible(true);
                   GakuyoZeroDeposit.id.setText(id.getText().toUpperCase().trim());
                   GakuyoZeroDeposit.cname.setText(name.getText().toUpperCase().trim());
                   GakuyoZeroDeposit.id.setEnabled(false);
                   GakuyoZeroDeposit.cname.setEnabled(false);
                    close();
                    break;
                    default:
                    break;
            }
}
                        }
                     
             }   catch (SQLException ex) {
                     Logger.getLogger(ClientDetails.class.getName()).log(Level.SEVERE, null, ex);
                 }
             
             }
      
    }//GEN-LAST:event_cmd_saveActionPerformed

    private void nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameActionPerformed

    private void phoneNoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_phoneNoFocusGained
        // TODO add your handling code here:
        phoneNo.setText("");
    }//GEN-LAST:event_phoneNoFocusGained

    private void phoneNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phoneNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phoneNoActionPerformed

    private void idFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_idFocusGained
        
    }//GEN-LAST:event_idFocusGained

    private void Combo_propertyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Combo_propertyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Combo_propertyActionPerformed

    private void nameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameKeyTyped
    char c = evt.getKeyChar();
        if ((Character.isDigit(c)
                || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE || evt.getKeyChar() == '+')) {
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_nameKeyTyped

    private void phoneNoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_phoneNoKeyTyped
          char c = evt.getKeyChar();
        if (!(Character.isDigit(c)
                || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE || evt.getKeyChar() == '+')) {
            evt.consume();
           
        }
    }//GEN-LAST:event_phoneNoKeyTyped

    private void idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idActionPerformed

    private void idKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_idKeyTyped
   char c=evt.getKeyChar();
        if(!(Character.isAlphabetic(c) ||  (c==KeyEvent.VK_BACK_SPACE)||  c==KeyEvent.VK_DELETE ||Character.isDigit(c))){
        evt.consume();
        getToolkit().beep();}
    }//GEN-LAST:event_idKeyTyped

    private void txt_searchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_searchFocusGained
        txt_search.setText("");
    }//GEN-LAST:event_txt_searchFocusGained

    private void cmd_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_searchActionPerformed
   if(txt_search.getText().isEmpty()){
     JOptionPane.showMessageDialog(null,"Enter ID number");
    } 
   else  if(txt_search.getText().length()!=8){
            JOptionPane.showMessageDialog(null, "ID must be 8 digits");
            }
    else{ 
         if(conn==null){
            JOptionPane.showMessageDialog(this, "Could not connect to the server");
        }
            else{
        try{
           String searchclient = "select *from client_detail where id=?";
           
            pst=conn.prepareStatement(searchclient);
            pst.setString(1, txt_search.getText());
            rs=pst.executeQuery();
            
            if(rs.next()){
                
                branch.setSelectedItem(rs.getString("branch"));
                title.setSelectedItem(rs.getString("title"));
                name.setText(rs.getString("name"));
                id.setText( rs.getString("id"));
                phoneNo.setText(rs.getString("phone"));
            }
            else{
                       JOptionPane.showMessageDialog(null, "Client with ID No"+" "+txt_search.getText()+" "+"does not exist");
            }
        }
        catch(SQLException e){
        JOptionPane.showMessageDialog(null, e);}
         }
     }
    }//GEN-LAST:event_cmd_searchActionPerformed

    private void branchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_branchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_branchActionPerformed
    
     public void close(){
        WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
         }
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
            java.util.logging.Logger.getLogger(ClientDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new ClientDetails().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Combo_property;
    private javax.swing.JComboBox<String> branch;
    private javax.swing.JButton cmd_save;
    private javax.swing.JButton cmd_search;
    private javax.swing.JLabel current_date;
    public static javax.swing.JTextField id;
    private javax.swing.JComboBox<String> idp;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField name;
    private javax.swing.JTextField phoneNo;
    private javax.swing.JComboBox<String> title;
    private javax.swing.JTextField txt_search;
    // End of variables declaration//GEN-END:variables
}
