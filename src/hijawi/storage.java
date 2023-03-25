/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hijawi;

import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.HeadlessException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.Connection;
/**
 *
 * @author ASUS
 */
public class storage extends javax.swing.JFrame {

    /**
     * Creates new form storage
     */
     private CardLayout cardLayout;
    public storage(String usernamr) {
        initComponents();
         cardLayout = (CardLayout) cards.getLayout();
         
        /* LOGIN login=new LOGIN(); 
          this.setVisible(false);
         login.setVisible(true);*/
         
         String tooltype=(String) this.Tool.getSelectedItem();
        String supplier=(String) this.jComboBox1.getSelectedItem();
        String size=(String) this.Size.getSelectedItem();
        String sector=(String) this.Tool.getSelectedItem();
        int colorno=0;
        String[] color= new String[3];
        if(this.jCheckBox1.isSelected()){color[colorno]="ازرق";colorno++;}
        if(this.jCheckBox2.isSelected()){color[colorno]="اصفر";colorno++;}
        if(this.jCheckBox3.isSelected()){color[colorno]="احمر";colorno++;}
        if(this.jCheckBox4.isSelected()){color[colorno]="اسود";colorno++;}

        int size1=1;
        char jobOfTool='r';
        char s='r';
        StringBuilder toolname = new StringBuilder();

        Connection connection;
    long millis=System.currentTimeMillis();  
    java.sql.Date date = new java.sql.Date(millis);  
          
        PreparedStatement ps,ps1,ps2;

         switch (size) {
            case "30*20":
                size1=1;
                break;
            case "50*60":
                size1=2;
                break;
            case "70*60":
                size1=3;
                break;
            default:
                size1=4;
                break;
        }
         if("Ramallah".equals(supplier))s='r';
        else s='n';
         if(null!=sector)switch (sector) {
            case "مطاعم":
                jobOfTool='r';
                break;
            case "مدارس":
                jobOfTool='s';
                break;
            case "مكاتب":
                jobOfTool='o';
                break;
            case "شركات خاصة":
                jobOfTool='c';
                break;
            case "بنوك":
                jobOfTool='b';
                break;
            default:
                break;
        }
        if("Dicut"==tooltype){
           try { 

             connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/compony","root","");
             ps = connection.prepareStatement("INSERT INTO dicut(name,type,sector,size,status,DateOfAttachment,supplier,isle,shelf,ordernumber) VALUES (?,?,?,?,?,?,?,?,?,?)");
             toolname.append('D');//type
             toolname.append(size1);//size
             toolname.append(jobOfTool);
             toolname.append('1');//isle
             toolname.append(s);//supplier
             toolname.append('1');//order number

             ps.setString(1,toolname.toString());
             ps.setString(2,tooltype);
             ps.setString(3,sector);
             ps.setInt(4,size1);
             ps.setInt(5,1);//status
             ps.setDate(6,date);
             ps.setString(7,supplier);
             ps.setInt(8,1);
             ps.setInt(9,1);
             ps.setInt(10,1);

             boolean rs = ps.execute();
             if(!rs)JOptionPane.showMessageDialog(this, "تم الاضافة بنجاح\n Tool name="+toolname.toString());
             else  JOptionPane.showMessageDialog(this, "Erorr");  
             
             
              
        } catch (HeadlessException | SQLException ex ) {
            JOptionPane.showMessageDialog(this,"Wrong \n"+ex );
        }    
        }
         if("IClasheh"==tooltype){
           try { 

             connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/compony","root","");
             ps = connection.prepareStatement("INSERT INTO iclasheh(name,type,sector,size,status,DateOfAttachment,isle,shelf,ordernumber) VALUES (?,?,?,?,?,?,?,?,?)");
             toolname.append('C');//type
             toolname.append(size1);//size
             toolname.append(jobOfTool);
             toolname.append('3');//isle
             toolname.append('1');//order number

             ps.setString(1,toolname.toString());
             ps.setString(2,tooltype);
             ps.setString(3,sector);
             ps.setInt(4,size1);
             ps.setInt(5,1);//status
             ps.setDate(6,date);
             ps.setInt(7,1);
             ps.setInt(8,1);
             ps.setInt(9,1);

             boolean rs = ps.execute();
             if(!rs)JOptionPane.showMessageDialog(this, "تم الاضافة بنجاح\n Tool name="+toolname.toString());
             else  JOptionPane.showMessageDialog(this, "Erorr");  
             
             
              
        } catch (HeadlessException | SQLException ex ) {
            JOptionPane.showMessageDialog(this,"Wrong \n"+ex );
        }    
        }
          if("IPlate"==tooltype){
           try { 

             connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/compony","root","");
             ps = connection.prepareStatement("INSERT INTO iplate(name,type,sector,size,status,DateOfAttachment,isle,shelf,ordernumber,colornumber) VALUES (?,?,?,?,?,?,?,?,?,?)");
             toolname.append('P');//type
             toolname.append(size1);//size
             toolname.append(jobOfTool);
             toolname.append('4');//isle
             toolname.append(colorno);//color
             toolname.append('1');//order number
 
             ps.setString(1,toolname.toString());
             ps.setString(2,tooltype);
             ps.setString(3,sector);
             ps.setInt(4,size1);
             ps.setInt(5,1);//status
             ps.setDate(6,date);
             ps.setInt(7,1);
             ps.setInt(8,1);
             ps.setInt(9,1);
             ps.setInt(10,colorno);

             boolean rs = ps.execute();
          
             if(!rs)
                 JOptionPane.showMessageDialog(this, "تم الاضافة بنجاح\n Tool name="+toolname.toString());
             else  JOptionPane.showMessageDialog(this, "Erorr");  
             
                  
               for (String color1 : color) {
                         
                   ps1 = connection.prepareStatement("INSERT INTO color(platename,color) VALUES (?,?)");
                   ps1.setString(1,toolname.toString());
                   ps1.setString(2, color1);
                   boolean rs1 = ps1.execute();
               }
              
        } catch (HeadlessException | SQLException ex ) {
            JOptionPane.showMessageDialog(this,"Wrong \n"+ex );
        }    
        }
    }
        void setColor(JPanel panel) {
        panel.setBackground(new Color(10, 35, 47));
    }
    
    void resetColor(JPanel panel) {
        panel.setBackground(new Color(17,45,57));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sidePanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ToolsStorage = new javax.swing.JPanel();
        endtool = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        orderList = new javax.swing.JPanel();
        endWorker1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        signOut = new javax.swing.JLabel();
        expieredList = new javax.swing.JPanel();
        endReq = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        cards = new javax.swing.JPanel();
        OrderListpanel = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollBar2 = new javax.swing.JScrollBar();
        ToolsPanel = new javax.swing.JPanel();
        panel = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        searchKey = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        aisle = new javax.swing.JTextField();
        shelf = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        Tool = new javax.swing.JComboBox<>();
        jPanel10 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        Size = new javax.swing.JComboBox<>();
        jPanel11 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        Supplier = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        colorNo = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Colors = new javax.swing.JList<>();
        jPanel9 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        sector = new javax.swing.JTextField();
        done = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        Status = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        ExpieredToolsPAnel = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollBar3 = new javax.swing.JScrollBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        sidePanel.setBackground(new java.awt.Color(17, 45, 57));

        jLabel1.setFont(new java.awt.Font("Traditional Arabic", 3, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("الحجاوي");

        jLabel2.setBackground(new java.awt.Color(17, 45, 57));
        jLabel2.setFont(new java.awt.Font("Traditional Arabic", 3, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("اسم المستخدم");

        ToolsStorage.setBackground(new java.awt.Color(17, 45, 57));
        ToolsStorage.setForeground(new java.awt.Color(255, 255, 255));
        ToolsStorage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ToolsStorageMousePressed(evt);
            }
        });
        ToolsStorage.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        endtool.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout endtoolLayout = new javax.swing.GroupLayout(endtool);
        endtool.setLayout(endtoolLayout);
        endtoolLayout.setHorizontalGroup(
            endtoolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        endtoolLayout.setVerticalGroup(
            endtoolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        ToolsStorage.add(endtool, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 20, 50));

        jLabel3.setFont(new java.awt.Font("Traditional Arabic", 3, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("الأدوات");
        ToolsStorage.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 80, -1));

        orderList.setBackground(new java.awt.Color(17, 45, 57));
        orderList.setForeground(new java.awt.Color(255, 255, 255));
        orderList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                orderListMousePressed(evt);
            }
        });
        orderList.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        endWorker1.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout endWorker1Layout = new javax.swing.GroupLayout(endWorker1);
        endWorker1.setLayout(endWorker1Layout);
        endWorker1Layout.setHorizontalGroup(
            endWorker1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        endWorker1Layout.setVerticalGroup(
            endWorker1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        orderList.add(endWorker1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 20, 50));

        jLabel5.setFont(new java.awt.Font("Traditional Arabic", 3, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("لائحة الطلبات");
        orderList.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 80, -1));

        signOut.setBackground(new java.awt.Color(17, 45, 57));
        signOut.setFont(new java.awt.Font("Traditional Arabic", 3, 13)); // NOI18N
        signOut.setForeground(new java.awt.Color(255, 51, 51));
        signOut.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        signOut.setText("تسجيل الخروج");
        signOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                signOutMousePressed(evt);
            }
        });

        expieredList.setBackground(new java.awt.Color(17, 45, 57));
        expieredList.setForeground(new java.awt.Color(255, 255, 255));
        expieredList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                expieredListMousePressed(evt);
            }
        });
        expieredList.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        endReq.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout endReqLayout = new javax.swing.GroupLayout(endReq);
        endReq.setLayout(endReqLayout);
        endReqLayout.setHorizontalGroup(
            endReqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        endReqLayout.setVerticalGroup(
            endReqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        expieredList.add(endReq, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 20, 50));

        jLabel4.setFont(new java.awt.Font("Traditional Arabic", 3, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("لائحة الأدوات المنتهية ");
        expieredList.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 170, -1));

        javax.swing.GroupLayout sidePanelLayout = new javax.swing.GroupLayout(sidePanel);
        sidePanel.setLayout(sidePanelLayout);
        sidePanelLayout.setHorizontalGroup(
            sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(signOut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sidePanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ToolsStorage, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(orderList, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(expieredList, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        sidePanelLayout.setVerticalGroup(
            sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidePanelLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(orderList, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ToolsStorage, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(expieredList, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(signOut, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        cards.setLayout(new java.awt.CardLayout());

        OrderListpanel.setPreferredSize(new java.awt.Dimension(700, 597));

        jLabel7.setFont(new java.awt.Font("Traditional Arabic", 3, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("لائحة الطلبات ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 567, Short.MAX_VALUE)
                .addComponent(jScrollBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollBar2, javax.swing.GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout OrderListpanelLayout = new javax.swing.GroupLayout(OrderListpanel);
        OrderListpanel.setLayout(OrderListpanelLayout);
        OrderListpanelLayout.setHorizontalGroup(
            OrderListpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OrderListpanelLayout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addGroup(OrderListpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, OrderListpanelLayout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, OrderListpanelLayout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55))))
        );
        OrderListpanelLayout.setVerticalGroup(
            OrderListpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OrderListpanelLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        cards.add(OrderListpanel, "card4");

        ToolsPanel.setPreferredSize(new java.awt.Dimension(68, 597));

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        searchKey.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchKeyActionPerformed(evt);
            }
        });
        jPanel4.add(searchKey, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, 290, 40));

        jButton1.setFont(new java.awt.Font("Traditional Arabic", 3, 18)); // NOI18N
        jButton1.setText("بحث");
        jPanel4.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, 40));

        jLabel8.setFont(new java.awt.Font("Traditional Arabic", 3, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("بحث عن اداة");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 0, 102, 38));

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
        jPanel8.add(shelf, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, 150, 40));

        jLabel13.setFont(new java.awt.Font("Traditional Arabic", 3, 18)); // NOI18N
        jLabel13.setText("الرف");
        jPanel8.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 50, 50, 40));

        jLabel21.setFont(new java.awt.Font("Traditional Arabic", 3, 18)); // NOI18N
        jLabel21.setText("الممر");
        jPanel8.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 50, 50, 40));

        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Traditional Arabic", 3, 18)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("نوع الاداة");
        jPanel7.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 74, 26));

        Tool.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        Tool.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ToolActionPerformed(evt);
            }
        });
        jPanel7.add(Tool, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 40));

        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setFont(new java.awt.Font("Traditional Arabic", 3, 18)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("الحجم");
        jPanel10.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 74, 26));

        Size.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel10.add(Size, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 40));

        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setFont(new java.awt.Font("Traditional Arabic", 3, 18)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("المورد");
        jPanel11.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, 74, 26));

        Supplier.setEditable(false);
        Supplier.setBackground(new java.awt.Color(255, 255, 255));
        Supplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SupplierActionPerformed(evt);
            }
        });
        jPanel11.add(Supplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 150, 40));

        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        colorNo.setEditable(false);
        colorNo.setBackground(new java.awt.Color(255, 255, 255));

        jLabel19.setFont(new java.awt.Font("Traditional Arabic", 3, 18)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("عدد الالوان");

        Colors.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(Colors);

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

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(colorNo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(colorNo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        done.setFont(new java.awt.Font("Traditional Arabic", 3, 18)); // NOI18N
        done.setText("موافق");
        done.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doneActionPerformed(evt);
            }
        });

        jCheckBox1.setText("أزرق");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jCheckBox2.setText("أصفر");

        jCheckBox3.setText("أحمر");

        jCheckBox4.setText("أسود");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 662, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(done, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox4)
                    .addComponent(jCheckBox3)
                    .addComponent(jCheckBox2)
                    .addComponent(jCheckBox1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(done)
                    .addComponent(jCheckBox1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBox3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox4)
                .addGap(0, 13, Short.MAX_VALUE))
        );

        Status.setForeground(new java.awt.Color(255, 0, 0));
        Status.setText("statusOF the tool");

        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel20.setFont(new java.awt.Font("Traditional Arabic", 3, 18)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("العملية");
        jPanel13.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 74, 26));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "استعارة", "ارجاع", "حذف", "اضافة", "تعديل" }));
        jPanel13.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 150, 40));

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(Status, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Status, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout ToolsPanelLayout = new javax.swing.GroupLayout(ToolsPanel);
        ToolsPanel.setLayout(ToolsPanelLayout);
        ToolsPanelLayout.setHorizontalGroup(
            ToolsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 686, Short.MAX_VALUE)
            .addGroup(ToolsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(ToolsPanelLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        ToolsPanelLayout.setVerticalGroup(
            ToolsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 638, Short.MAX_VALUE)
            .addGroup(ToolsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(ToolsPanelLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        cards.add(ToolsPanel, "card3");

        ExpieredToolsPAnel.setPreferredSize(new java.awt.Dimension(686, 597));

        jLabel6.setFont(new java.awt.Font("Traditional Arabic", 3, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("لائحة الأدوات المنتهية ");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 558, Short.MAX_VALUE)
                .addComponent(jScrollBar3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollBar3, javax.swing.GroupLayout.DEFAULT_SIZE, 439, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout ExpieredToolsPAnelLayout = new javax.swing.GroupLayout(ExpieredToolsPAnel);
        ExpieredToolsPAnel.setLayout(ExpieredToolsPAnelLayout);
        ExpieredToolsPAnelLayout.setHorizontalGroup(
            ExpieredToolsPAnelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ExpieredToolsPAnelLayout.createSequentialGroup()
                .addContainerGap(484, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
            .addGroup(ExpieredToolsPAnelLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ExpieredToolsPAnelLayout.setVerticalGroup(
            ExpieredToolsPAnelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ExpieredToolsPAnelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        cards.add(ExpieredToolsPAnel, "card2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(cards, javax.swing.GroupLayout.DEFAULT_SIZE, 683, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sidePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cards, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(sidePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ToolsStorageMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ToolsStorageMousePressed
        // TODO add your handling code here:

        setColor(ToolsStorage);
        resetColor(orderList);
        resetColor(expieredList);

        endtool.setOpaque(true);
        endReq.setOpaque(false);
        endWorker1.setOpaque(false);

        cardLayout.show(cards, "card3");
    }//GEN-LAST:event_ToolsStorageMousePressed

    private void expieredListMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_expieredListMousePressed
        // TODO add your handling code here:
        resetColor(ToolsStorage);
        setColor(expieredList);
        resetColor(orderList);

        endtool.setOpaque(false);
        endReq.setOpaque(true);
        endWorker1.setOpaque(false);

        cardLayout.show(cards, "card2");
    }//GEN-LAST:event_expieredListMousePressed

    private void orderListMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_orderListMousePressed
        // TODO add your handling code here:
        resetColor(ToolsStorage);
        resetColor(expieredList);
        setColor(orderList);

        endtool.setOpaque(false);
        endReq.setOpaque(false);
        endWorker1.setOpaque(true);

        cardLayout.show(cards, "card4");
    }//GEN-LAST:event_orderListMousePressed

    private void signOutMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signOutMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_signOutMousePressed

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

    private void SupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SupplierActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SupplierActionPerformed

    private void doneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doneActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_doneActionPerformed

    private void ToolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ToolActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ToolActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox1ActionPerformed

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
            java.util.logging.Logger.getLogger(storage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(storage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(storage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(storage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new storage("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> Colors;
    private javax.swing.JPanel ExpieredToolsPAnel;
    private javax.swing.JPanel OrderListpanel;
    private javax.swing.JComboBox<String> Size;
    private javax.swing.JLabel Status;
    private javax.swing.JTextField Supplier;
    private javax.swing.JComboBox<String> Tool;
    private javax.swing.JPanel ToolsPanel;
    private javax.swing.JPanel ToolsStorage;
    private javax.swing.JTextField aisle;
    private javax.swing.JPanel cards;
    private javax.swing.JTextField colorNo;
    private javax.swing.JButton done;
    private javax.swing.JPanel endReq;
    private javax.swing.JPanel endWorker1;
    private javax.swing.JPanel endtool;
    private javax.swing.JPanel expieredList;
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollBar jScrollBar2;
    private javax.swing.JScrollBar jScrollBar3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel orderList;
    private javax.swing.JPanel panel;
    private javax.swing.JTextField searchKey;
    private javax.swing.JTextField sector;
    private javax.swing.JTextField shelf;
    private javax.swing.JPanel sidePanel;
    private javax.swing.JLabel signOut;
    // End of variables declaration//GEN-END:variables
}
