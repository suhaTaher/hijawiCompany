/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hijawi;

import java.awt.HeadlessException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.Connection;


/**
 *
 * @author ASUS
 */
public class searchforsales extends javax.swing.JFrame {

    /**
     * Creates new form searchforsales
     */
    public searchforsales() {
        initComponents();
   
    
       String TypeOfTool1="";
       String size1="";
       String JobOfTool1="";
       String supplier1="";
       String status1="";
       int status;
       int size=0;
       int flag=0;
       int isle=0;
       int shelf=0;
       int ordernumber1=0;
       int colornumber1=0;
        
        String search=this.searchKey.getText();
        char TypeOfTool=search.charAt(0);
        Connection connection;
        PreparedStatement ps,ps1,ps2;    
       
        switch (TypeOfTool) {
            case 'D':
                try {
                    connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/compony","root","");
                    ps = connection.prepareStatement("select * from dicut where name= ?");
                    ps.setString(1,search );
                    ResultSet rs = ps.executeQuery();
                    if(rs.next())
                    {
                        TypeOfTool1=rs.getString(2);
                        JobOfTool1=rs.getString(3);
                        size=rs.getInt(4);
                        status=rs.getInt(5);
                        supplier1=rs.getString(8);
                        isle=rs.getInt(9);
                        shelf=rs.getInt(10);
                        ordernumber1=rs.getInt(11);
                        if(status==1)status1="متوفر";
                        if(status==0) status1="غير متوفر";
                        switch (size) {
                            case 1:
                                size1="30*20";
                                break;
                            case 2:
                                size1="50*60";
                                break;
                            case 3:
                                size1="70*60";
                                break;
                            default:
                                break;
                        }
                        
                    }
                    
                    else  JOptionPane.showMessageDialog(this,"Not Found" );
                }
                catch (HeadlessException | SQLException ex ) {
                    JOptionPane.showMessageDialog(this,"Wrong \n"+ex );
                }       break; 
            case 'P':
                try{
                    connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/compony","root","");
                    ps1 = connection.prepareStatement("select * from iplate where name= ?");
                    ps1.setString(1,search );
                    ResultSet rs1 = ps1.executeQuery();
                    if(rs1.next())
                    {
                        TypeOfTool1=rs1.getString(2);
                        JobOfTool1=rs1.getString(3);
                        size=rs1.getInt(4);
                        status=rs1.getInt(5);
                        flag=rs1.getInt(6);
                        isle=rs1.getInt(8);
                        shelf=rs1.getInt(9);
                        ordernumber1=rs1.getInt(10);
                        colornumber1=rs1.getInt(11);
                  
                          if(status==1)status1="متوفر";
                        if(status==0) status1="غير متوفر";
                        switch (size) {
                            case 1:
                                size1="30*20";
                                break;
                            case 2:
                                size1="50*60";
                                break;
                            case 3:
                                size1="70*60";
                                break;
                            default:
                                break;
                        }
                        
                    }
                    else  JOptionPane.showMessageDialog(this,"Not Found" );
                }
                catch (HeadlessException | SQLException ex ) {
                    JOptionPane.showMessageDialog(this,"Wrong \n"+ex );
                }       break;
            case 'C':
                try{
                    connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/compony","root","");
                    ps1 = connection.prepareStatement("select * from iclasheh where name= ?");
                    ps1.setString(1,search );
                    ResultSet rs1 = ps1.executeQuery();
                    if(rs1.next())
                    {
                        TypeOfTool1=rs1.getString(2);
                        JobOfTool1=rs1.getString(3);
                        size=rs1.getInt(4);
                        status=rs1.getInt(5);
                        isle=rs1.getInt(8);
                        shelf=rs1.getInt(9);
                        ordernumber1=rs1.getInt(10);
                        if(status==1)status1="متوفر";
                        if(status==0) status1="غير متوفر";
                        switch (size) {
                            case 1:
                                size1="30*20";
                                break;
                            case 2:
                                size1="50*60";
                                break;
                            case 3:
                                size1="70*60";
                                break;
                            default:
                                break;
                        }
                        
                    }
                    else  JOptionPane.showMessageDialog(this,"Not Found" );
                }
                catch (HeadlessException | SQLException ex ) {
                    JOptionPane.showMessageDialog(this,"Wrong \n"+ex );
                }       break;
            default:
                JOptionPane.showMessageDialog(this,"Not Found" );
                break;
        }
        
this.Tool_name.setText(TypeOfTool1);
this.Supplier.setText(supplier1);
this.Tool_size.setText(size1);
this.sector.setText(JobOfTool1);
this.aisle.setText(Integer.toString(isle));
this.shelf.setText(Integer.toString(shelf));
this.Status.setText(status1);
this.colorNo.setText(Integer.toString(colornumber1));  }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        aisle = new javax.swing.JTextField();
        shelf = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        sector = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        Tool_name = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        Tool_size = new javax.swing.JTextField();
        jPanel11 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        Supplier = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        colorNo = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Colors = new javax.swing.JList<>();
        lable = new javax.swing.JLabel();
        Status = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        searchKey = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("اسم المستخدم");

        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setFont(new java.awt.Font("Traditional Arabic", 3, 18)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("موقع التخزين");
        jPanel8.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 10, 74, 26));

        aisle.setEditable(false);
        aisle.setBackground(new java.awt.Color(255, 255, 255));
        aisle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aisleActionPerformed(evt);
            }
        });
        jPanel8.add(aisle, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 50, 150, 40));

        shelf.setEditable(false);
        shelf.setBackground(new java.awt.Color(255, 255, 255));
        shelf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shelfActionPerformed(evt);
            }
        });
        jPanel8.add(shelf, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, 150, 40));

        jLabel13.setFont(new java.awt.Font("Traditional Arabic", 3, 18)); // NOI18N
        jLabel13.setText("الرف");
        jPanel8.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 50, 50, 40));

        jLabel21.setFont(new java.awt.Font("Traditional Arabic", 3, 18)); // NOI18N
        jLabel21.setText("الممر");
        jPanel8.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 50, 50, 40));

        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setFont(new java.awt.Font("Traditional Arabic", 3, 18)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("القطاع");
        jPanel9.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 74, 26));

        sector.setEditable(false);
        sector.setBackground(new java.awt.Color(255, 255, 255));
        sector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sectorActionPerformed(evt);
            }
        });
        jPanel9.add(sector, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 40));

        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Traditional Arabic", 3, 18)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("نوع الاداة");
        jPanel7.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 74, 26));

        Tool_name.setEditable(false);
        Tool_name.setBackground(new java.awt.Color(255, 255, 255));
        Tool_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tool_nameActionPerformed(evt);
            }
        });
        jPanel7.add(Tool_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 40));

        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setFont(new java.awt.Font("Traditional Arabic", 3, 18)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("الحجم");
        jPanel10.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 74, 26));

        Tool_size.setEditable(false);
        Tool_size.setBackground(new java.awt.Color(255, 255, 255));
        Tool_size.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tool_sizeActionPerformed(evt);
            }
        });
        jPanel10.add(Tool_size, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 40));

        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setFont(new java.awt.Font("Traditional Arabic", 3, 18)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("المورد");
        jPanel11.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 74, 26));

        Supplier.setEditable(false);
        Supplier.setBackground(new java.awt.Color(255, 255, 255));
        Supplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SupplierActionPerformed(evt);
            }
        });
        jPanel11.add(Supplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 40));

        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel6.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        colorNo.setEditable(false);
        colorNo.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.add(colorNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, 150, 40));

        jLabel19.setFont(new java.awt.Font("Traditional Arabic", 3, 18)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("عدد الالوان");
        jPanel6.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 10, 74, 26));

        Colors.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(Colors);

        jPanel6.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 150, 120));

        lable.setForeground(new java.awt.Color(255, 0, 0));
        lable.setText("statusOF the tool");

        Status.setEditable(false);
        Status.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StatusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(0, 103, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 662, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                        .addComponent(lable, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Status, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lable, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Status, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Traditional Arabic", 3, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("بحث عن اداة");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 0, 102, 38));

        searchKey.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchKeyActionPerformed(evt);
            }
        });
        jPanel4.add(searchKey, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 0, 290, 40));

        jButton1.setFont(new java.awt.Font("Traditional Arabic", 3, 18)); // NOI18N
        jButton1.setText("بحث");
        jPanel4.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 0, 80, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 541, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchKeyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchKeyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchKeyActionPerformed

    private void aisleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aisleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_aisleActionPerformed

    private void shelfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shelfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_shelfActionPerformed

    private void sectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sectorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sectorActionPerformed

    private void Tool_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Tool_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Tool_nameActionPerformed

    private void Tool_sizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Tool_sizeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Tool_sizeActionPerformed

    private void SupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SupplierActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SupplierActionPerformed

    private void StatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_StatusActionPerformed

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
            java.util.logging.Logger.getLogger(searchforsales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(searchforsales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(searchforsales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(searchforsales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new searchforsales().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> Colors;
    private javax.swing.JTextField Status;
    private javax.swing.JTextField Supplier;
    private javax.swing.JTextField Tool_name;
    private javax.swing.JTextField Tool_size;
    private javax.swing.JTextField aisle;
    private javax.swing.JTextField colorNo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lable;
    private javax.swing.JTextField searchKey;
    private javax.swing.JTextField sector;
    private javax.swing.JTextField shelf;
    // End of variables declaration//GEN-END:variables
}
