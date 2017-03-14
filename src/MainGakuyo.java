

import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class MainGakuyo extends javax.swing.JFrame {
 
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    public MainGakuyo() {
        initComponents();
        setResizable(false);
         logo();
    }
 
   
   public void close(){
        WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
         }
    private void logo(){
    setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("images/LOG.png")));
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem6 = new javax.swing.JMenuItem();
        jLabel2 = new javax.swing.JLabel();
        mainmenu = new javax.swing.JMenuBar();
        menu_clientdetails = new javax.swing.JMenu();
        regclient = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        revinvestor = new javax.swing.JMenuItem();
        pr = new javax.swing.JMenu();
        reports = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        payments = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jMenuItem4 = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        jMenuItem5 = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        withdrawals_reports = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        jSeparator7 = new javax.swing.JPopupMenu.Separator();
        transfer_report = new javax.swing.JMenuItem();
        jSeparator9 = new javax.swing.JPopupMenu.Separator();
        statement = new javax.swing.JMenuItem();
        Credit = new javax.swing.JMenu();
        land_menu = new javax.swing.JMenuItem();
        house_menu = new javax.swing.JMenuItem();
        gakuyo_menu = new javax.swing.JMenuItem();
        investors = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        reversal = new javax.swing.JMenuItem();
        withdrawals = new javax.swing.JMenu();
        transfers = new javax.swing.JMenuItem();
        inv_clubwithdrwls = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        l_withdrwals = new javax.swing.JMenuItem();
        house_withdrawals = new javax.swing.JMenuItem();
        payment_voucher_section = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        backoffice_setup = new javax.swing.JMenu();
        edit_clients = new javax.swing.JMenuItem();
        edit_investorsclub = new javax.swing.JMenuItem();
        edit_landdetails = new javax.swing.JMenuItem();
        edit_housedetails = new javax.swing.JMenuItem();
        edit_gzd = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        update_user_accounts = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        log_out = new javax.swing.JMenu();
        jSeparator8 = new javax.swing.JPopupMenu.Separator();
        lgout = new javax.swing.JMenuItem();

        jMenuItem6.setText("jMenuItem6");

        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we)
            { 
                String ObjButtons[] = {"Yes","No"};
                int PromptResult = JOptionPane.showOptionDialog(null,"Are you sure you want to exit the system?","Confirm",JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,null,ObjButtons,ObjButtons[1]);
                if(PromptResult==JOptionPane.YES_OPTION)
                {
                    System.exit(0);
                    try {
                        rs.close();
                        pst.close();
                        conn.close();

                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null,e);
                    }
                }
            }
        });
        setTitle("WELCOME TO GAKUYO REAL ESTATE MANAGEMENT SYSTEM");
        setBackground(new java.awt.Color(102, 255, 102));
        setForeground(new java.awt.Color(149, 242, 171));

        jLabel2.setBackground(new java.awt.Color(102, 255, 102));
        jLabel2.setForeground(new java.awt.Color(153, 255, 153));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/HOME5.jpg"))); // NOI18N

        mainmenu.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 255, 102)));
        mainmenu.setToolTipText("");
        mainmenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mainmenu.setFont(new java.awt.Font("Segoe UI Emoji", 1, 8)); // NOI18N
        mainmenu.setPreferredSize(new java.awt.Dimension(396, 35));

        menu_clientdetails.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        menu_clientdetails.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/CLIENTMANAGEMENTICON.png"))); // NOI18N
        menu_clientdetails.setText("CLIENT MANAGEMENT");
        menu_clientdetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menu_clientdetailsMouseClicked(evt);
            }
        });

        regclient.setText("CLIENT REGISTRATION");
        regclient.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                regclientMousePressed(evt);
            }
        });
        menu_clientdetails.add(regclient);
        menu_clientdetails.add(jSeparator2);

        revinvestor.setText("INVESTORS REGISTRATION");
        revinvestor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                revinvestorMousePressed(evt);
            }
        });
        menu_clientdetails.add(revinvestor);

        mainmenu.add(menu_clientdetails);

        pr.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pr.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/REPORTSSECTION_1.png"))); // NOI18N
        pr.setText("PERIODIC ACTIVITES ");
        pr.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                prMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                prMousePressed(evt);
            }
        });

        reports.setText("PROPERTY REPORTS");
        reports.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                reportsMousePressed(evt);
            }
        });
        pr.add(reports);
        pr.add(jSeparator1);

        payments.setText("INVESTORS PAYMENTS");
        payments.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                paymentsMousePressed(evt);
            }
        });
        payments.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paymentsActionPerformed(evt);
            }
        });
        pr.add(payments);
        pr.add(jSeparator3);

        jMenuItem4.setText("SALES REPORTS");
        jMenuItem4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItem4MousePressed(evt);
            }
        });
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        pr.add(jMenuItem4);
        pr.add(jSeparator4);

        jMenuItem5.setText("EXPENSE REPORTS");
        jMenuItem5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItem5MousePressed(evt);
            }
        });
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        pr.add(jMenuItem5);
        pr.add(jSeparator5);

        withdrawals_reports.setText("WITHDRAWAL/REFUND REPORTS");
        withdrawals_reports.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                withdrawals_reportsMousePressed(evt);
            }
        });
        pr.add(withdrawals_reports);
        pr.add(jSeparator6);
        pr.add(jSeparator7);

        transfer_report.setText("TRANSFER REPORTS");
        transfer_report.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                transfer_reportMousePressed(evt);
            }
        });
        transfer_report.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transfer_reportActionPerformed(evt);
            }
        });
        pr.add(transfer_report);
        pr.add(jSeparator9);

        statement.setText("STATEMENTS");
        statement.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                statementMousePressed(evt);
            }
        });
        pr.add(statement);

        mainmenu.add(pr);

        Credit.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Credit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/creditmanagement.png"))); // NOI18N
        Credit.setText("CREDIT MANAGEMENT");
        Credit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                CreditMousePressed(evt);
            }
        });

        land_menu.setText("LAND PAYMENTS SECTION");
        land_menu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                land_menuMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                land_menuMousePressed(evt);
            }
        });
        land_menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                land_menuActionPerformed(evt);
            }
        });
        Credit.add(land_menu);

        house_menu.setText("HOUSE PAYMENTS SECTION");
        house_menu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                house_menuMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                house_menuMousePressed(evt);
            }
        });
        house_menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                house_menuActionPerformed(evt);
            }
        });
        Credit.add(house_menu);

        gakuyo_menu.setText("GAKUYO ZERO DEPOSIT SECTION");
        gakuyo_menu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gakuyo_menuMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                gakuyo_menuMousePressed(evt);
            }
        });
        Credit.add(gakuyo_menu);

        investors.setText("INVESTORS CLUB PAYMENT SECTION");
        investors.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                investorsMousePressed(evt);
            }
        });
        investors.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                investorsActionPerformed(evt);
            }
        });
        Credit.add(investors);

        jMenuItem3.setText("REPRINT RECEIPT");
        jMenuItem3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItem3MousePressed(evt);
            }
        });
        Credit.add(jMenuItem3);

        reversal.setText("REVERSALS");
        reversal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                reversalMousePressed(evt);
            }
        });
        Credit.add(reversal);

        mainmenu.add(Credit);

        withdrawals.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        withdrawals.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/withdrawals.png"))); // NOI18N
        withdrawals.setText("WITHDRAWALS & TRANSFERS");
        withdrawals.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                withdrawalsMousePressed(evt);
            }
        });

        transfers.setText("TRANSFERS");
        transfers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                transfersMousePressed(evt);
            }
        });
        withdrawals.add(transfers);

        inv_clubwithdrwls.setText("INVESTORS CLUB WITHDRAWALS");
        inv_clubwithdrwls.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                inv_clubwithdrwlsMousePressed(evt);
            }
        });
        withdrawals.add(inv_clubwithdrwls);

        jMenuItem2.setText("GAKUYO ZERO DEPOSIT WITHDRAWALS");
        jMenuItem2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItem2MousePressed(evt);
            }
        });
        withdrawals.add(jMenuItem2);

        l_withdrwals.setText("LAND WITHDRAWALS");
        l_withdrwals.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                l_withdrwalsMousePressed(evt);
            }
        });
        withdrawals.add(l_withdrwals);

        house_withdrawals.setText("HOUSE WITHDRAWALS");
        house_withdrawals.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                house_withdrawalsMousePressed(evt);
            }
        });
        withdrawals.add(house_withdrawals);

        mainmenu.add(withdrawals);

        payment_voucher_section.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        payment_voucher_section.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pv.png"))); // NOI18N
        payment_voucher_section.setText("PAYMENT VOUCHER");
        payment_voucher_section.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                payment_voucher_sectionMouseClicked(evt);
            }
        });

        jMenuItem7.setText("PAYMENT VOUCHER");
        jMenuItem7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItem7MousePressed(evt);
            }
        });
        payment_voucher_section.add(jMenuItem7);

        mainmenu.add(payment_voucher_section);

        backoffice_setup.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        backoffice_setup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/EDITSECTION.png"))); // NOI18N
        backoffice_setup.setText("BACK OFFICE  SECTION");

        edit_clients.setText("EDIT CLIENT DETAILS");
        edit_clients.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                edit_clientsMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                edit_clientsMousePressed(evt);
            }
        });
        backoffice_setup.add(edit_clients);

        edit_investorsclub.setText("EDIT INVESTORS CLUB DETAILS");
        edit_investorsclub.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                edit_investorsclubMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                edit_investorsclubMousePressed(evt);
            }
        });
        edit_investorsclub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edit_investorsclubActionPerformed(evt);
            }
        });
        backoffice_setup.add(edit_investorsclub);

        edit_landdetails.setText("EDIT LAND PAYMENT  DETAILS");
        edit_landdetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                edit_landdetailsMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                edit_landdetailsMousePressed(evt);
            }
        });
        backoffice_setup.add(edit_landdetails);

        edit_housedetails.setText("EDIT HOUSE PAYMENT DETAILS");
        edit_housedetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                edit_housedetailsMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                edit_housedetailsMousePressed(evt);
            }
        });
        edit_housedetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edit_housedetailsActionPerformed(evt);
            }
        });
        backoffice_setup.add(edit_housedetails);

        edit_gzd.setText("EDIT GAKUYO ZERO DEPOSIT DETAILS");
        edit_gzd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                edit_gzdMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                edit_gzdMousePressed(evt);
            }
        });
        backoffice_setup.add(edit_gzd);

        jMenuItem1.setText("EDIT PAYMENT VOUCHER DETAILS");
        jMenuItem1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItem1MousePressed(evt);
            }
        });
        backoffice_setup.add(jMenuItem1);

        update_user_accounts.setText("EDIT USER ACCOUNTS");
        update_user_accounts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                update_user_accountsMousePressed(evt);
            }
        });
        backoffice_setup.add(update_user_accounts);

        mainmenu.add(backoffice_setup);

        jMenu1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMenu1.setText("ABOUT");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        mainmenu.add(jMenu1);

        log_out.setText("Users");
        log_out.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                log_outMousePressed(evt);
            }
        });

        username.setText("USER");
        log_out.add(username);
        log_out.add(jSeparator8);

        lgout.setText("LOG OUT");
        lgout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lgoutMousePressed(evt);
            }
        });
        log_out.add(lgout);

        mainmenu.add(log_out);

        setJMenuBar(mainmenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1319, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 626, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1335, 700));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void menu_clientdetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu_clientdetailsMouseClicked
       
       
        
    }//GEN-LAST:event_menu_clientdetailsMouseClicked

    private void prMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_prMouseClicked
       
       
    }//GEN-LAST:event_prMouseClicked

    private void edit_investorsclubActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edit_investorsclubActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edit_investorsclubActionPerformed

    private void edit_investorsclubMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_edit_investorsclubMouseClicked
         edit_investors_club.getObj().setVisible(true);
        
    }//GEN-LAST:event_edit_investorsclubMouseClicked

    private void edit_landdetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_edit_landdetailsMouseClicked
         editland.getObj().setVisible(true);
    }//GEN-LAST:event_edit_landdetailsMouseClicked

    private void edit_housedetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_edit_housedetailsMouseClicked
        
      edithouse.getObj().setVisible(true);
    }//GEN-LAST:event_edit_housedetailsMouseClicked

    private void edit_gzdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_edit_gzdMouseClicked
       
        
    }//GEN-LAST:event_edit_gzdMouseClicked

    private void log_outMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_log_outMousePressed
       
    }//GEN-LAST:event_log_outMousePressed

    private void edit_clientsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_edit_clientsMouseClicked
           edit_client_details.getObj().setVisible(true);
    }//GEN-LAST:event_edit_clientsMouseClicked

    private void edit_clientsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_edit_clientsMousePressed
      
         edit_client_details.getObj().setVisible(true);
        
    }//GEN-LAST:event_edit_clientsMousePressed

    private void edit_investorsclubMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_edit_investorsclubMousePressed
        // TODO add your handling code here:
        edit_investors_club.getObj().setVisible(true);
        
    }//GEN-LAST:event_edit_investorsclubMousePressed

    private void edit_landdetailsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_edit_landdetailsMousePressed
         editland.getObj().setVisible(true);
       
    }//GEN-LAST:event_edit_landdetailsMousePressed

    private void edit_housedetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edit_housedetailsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edit_housedetailsActionPerformed

    private void edit_housedetailsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_edit_housedetailsMousePressed
        // TODO add your handling code here:
        edithouse.getObj().setVisible(true);
       
    }//GEN-LAST:event_edit_housedetailsMousePressed

    private void edit_gzdMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_edit_gzdMousePressed
        Edit_Gakuyozerodeposit.getObj().setVisible(true);
    }//GEN-LAST:event_edit_gzdMousePressed

    private void gakuyo_menuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gakuyo_menuMousePressed
        GakuyoZeroDeposit.getObj().setVisible(true);
        
    }//GEN-LAST:event_gakuyo_menuMousePressed

    private void gakuyo_menuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gakuyo_menuMouseClicked
       GakuyoZeroDeposit.getObj().setVisible(true);
    }//GEN-LAST:event_gakuyo_menuMouseClicked

    private void house_menuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_house_menuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_house_menuActionPerformed

    private void house_menuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_house_menuMousePressed
        house.getObj().setVisible(true);
        
    }//GEN-LAST:event_house_menuMousePressed

    private void house_menuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_house_menuMouseClicked
         house.getObj().setVisible(true);

    }//GEN-LAST:event_house_menuMouseClicked

    private void land_menuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_land_menuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_land_menuActionPerformed

    private void land_menuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_land_menuMousePressed

        land.getObj().setVisible(true);
      
    
    }//GEN-LAST:event_land_menuMousePressed

    private void land_menuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_land_menuMouseClicked
    }//GEN-LAST:event_land_menuMouseClicked

    private void CreditMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CreditMousePressed
       
    }//GEN-LAST:event_CreditMousePressed

    private void investorsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_investorsMousePressed
        Investors_club.getObj().setVisible(true);
       
    }//GEN-LAST:event_investorsMousePressed

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        about_this_software.getObj().setVisible(true);
    }//GEN-LAST:event_jMenu1MouseClicked

    private void payment_voucher_sectionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_payment_voucher_sectionMouseClicked
        
    }//GEN-LAST:event_payment_voucher_sectionMouseClicked

    private void jMenuItem1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem1MousePressed
        edit_payment_voucher.getObj().setVisible(true);
        
    }//GEN-LAST:event_jMenuItem1MousePressed

    private void update_user_accountsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_update_user_accountsMousePressed
        
       register.getObj().setVisible(true);
    }//GEN-LAST:event_update_user_accountsMousePressed

    private void transfersMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_transfersMousePressed
         Transfers.getObj().setVisible(true);
        
    }//GEN-LAST:event_transfersMousePressed

    private void inv_clubwithdrwlsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inv_clubwithdrwlsMousePressed
        withdawal_investors.getObj().setVisible(true);
        
    }//GEN-LAST:event_inv_clubwithdrwlsMousePressed

    private void withdrawalsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_withdrawalsMousePressed
        
    }//GEN-LAST:event_withdrawalsMousePressed

    private void l_withdrwalsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l_withdrwalsMousePressed
        withdrawal_from_land.getObj().setVisible(true);
        
    }//GEN-LAST:event_l_withdrwalsMousePressed

    private void jMenuItem2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem2MousePressed
       withdrawal_from_gzd.getObj().setVisible(true);
      
    }//GEN-LAST:event_jMenuItem2MousePressed

    private void house_withdrawalsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_house_withdrawalsMousePressed
        withdrawal_from_house.getObj().setVisible(true);
        
    }//GEN-LAST:event_house_withdrawalsMousePressed

    private void reportsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reportsMousePressed
        Reports.getObj().setVisible(true);
      
    }//GEN-LAST:event_reportsMousePressed

    private void paymentsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paymentsMousePressed
         investors_payments.getObj().setVisible(true);
        
    }//GEN-LAST:event_paymentsMousePressed

    private void regclientMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_regclientMousePressed
        
        ClientDetails.getObj().setVisible(true);
          
      
    }//GEN-LAST:event_regclientMousePressed

    private void revinvestorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_revinvestorMousePressed
        investor_registration.getObj().setVisible(true);

        
    }//GEN-LAST:event_revinvestorMousePressed

    private void paymentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paymentsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_paymentsActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem4MousePressed
        sales.getObj().setVisible(true);
      
    }//GEN-LAST:event_jMenuItem4MousePressed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        expence_reports.getObj().setVisible(true);
       
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void prMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_prMousePressed
        
    }//GEN-LAST:event_prMousePressed

    private void withdrawals_reportsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_withdrawals_reportsMousePressed
        withdrawal_report.getObj().setVisible(true);
      
    }//GEN-LAST:event_withdrawals_reportsMousePressed

    private void jMenuItem7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem7MousePressed
        payment_voucher.getObj().setVisible(true);
       
    }//GEN-LAST:event_jMenuItem7MousePressed

    private void transfer_reportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transfer_reportActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_transfer_reportActionPerformed

    private void transfer_reportMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_transfer_reportMousePressed
        transfer_reports.getObj().setVisible(true);
      
    }//GEN-LAST:event_transfer_reportMousePressed

    private void lgoutMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lgoutMousePressed
       System.gc();
        java.awt.Window win[]=java.awt.Window.getWindows();
         for(int i=0;i<win.length;i++){
             win[i].dispose();
             win[i]=null;}
        login lg = new login();
              lg.setVisible(true);    }//GEN-LAST:event_lgoutMousePressed

    private void investorsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_investorsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_investorsActionPerformed

    private void jMenuItem5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem5MousePressed
       expence_reports.getObj().setVisible(true); 
     
    }//GEN-LAST:event_jMenuItem5MousePressed

    private void jMenuItem3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem3MousePressed
        
         reprint_receipt.getObj().setVisible(true);
        
    }//GEN-LAST:event_jMenuItem3MousePressed

    private void reversalMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reversalMousePressed
               receipt_reversal.getObj().setVisible(true);
    }//GEN-LAST:event_reversalMousePressed

    private void statementMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_statementMousePressed
        
        statements.getObj().setVisible(true);
    }//GEN-LAST:event_statementMousePressed

    
    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(() -> {
            new MainGakuyo().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JMenu Credit;
    public static javax.swing.JMenu backoffice_setup;
    private javax.swing.JMenuItem edit_clients;
    private javax.swing.JMenuItem edit_gzd;
    private javax.swing.JMenuItem edit_housedetails;
    private javax.swing.JMenuItem edit_investorsclub;
    private javax.swing.JMenuItem edit_landdetails;
    private javax.swing.JMenuItem gakuyo_menu;
    private javax.swing.JMenuItem house_menu;
    private javax.swing.JMenuItem house_withdrawals;
    private javax.swing.JMenuItem inv_clubwithdrwls;
    private javax.swing.JMenuItem investors;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JPopupMenu.Separator jSeparator7;
    private javax.swing.JPopupMenu.Separator jSeparator8;
    private javax.swing.JPopupMenu.Separator jSeparator9;
    private javax.swing.JMenuItem l_withdrwals;
    private javax.swing.JMenuItem land_menu;
    private javax.swing.JMenuItem lgout;
    private javax.swing.JMenu log_out;
    private javax.swing.JMenuBar mainmenu;
    public static javax.swing.JMenu menu_clientdetails;
    public static javax.swing.JMenu payment_voucher_section;
    private javax.swing.JMenuItem payments;
    private javax.swing.JMenu pr;
    private javax.swing.JMenuItem regclient;
    private javax.swing.JMenuItem reports;
    private javax.swing.JMenuItem reversal;
    private javax.swing.JMenuItem revinvestor;
    private javax.swing.JMenuItem statement;
    private javax.swing.JMenuItem transfer_report;
    private javax.swing.JMenuItem transfers;
    private javax.swing.JMenuItem update_user_accounts;
    public static final javax.swing.JMenuItem username = new javax.swing.JMenuItem();
    public static javax.swing.JMenu withdrawals;
    private javax.swing.JMenuItem withdrawals_reports;
    // End of variables declaration//GEN-END:variables
}
