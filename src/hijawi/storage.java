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
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author ASUS
 */
public class storage extends javax.swing.JFrame {

    /**
     * Creates new form storage
     */
     private CardLayout cardLayout;
     private CardLayout cardLayout2;
    public storage(String usernamr) {
        initComponents();
         cardLayout = (CardLayout) cards.getLayout();
         cardLayout2 = (CardLayout) ToolCards.getLayout();
         
         
        /* LOGIN login=new LOGIN(); 
          this.setVisible(false);
         login.setVisible(true);*/
         
        /* String tooltype=(String) this.Tool1.getSelectedItem();
        String supplier=(String) this.jComboBox2.getSelectedItem();
        String size=(String) this.Size1.getSelectedItem();
        String sector=(String) this.Tool1.getSelectedItem();
        int colorno=0;
        String[] color= new String[3];
        if(this.jCheckBox5.isSelected()){color[colorno]="ازرق";colorno++;}
        if(this.jCheckBox6.isSelected()){color[colorno]="اصفر";colorno++;}
        if(this.jCheckBox7.isSelected()){color[colorno]="احمر";colorno++;}
        if(this.jCheckBox8.isSelected()){color[colorno]="اسود";colorno++;}

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
        }*/
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

        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
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
        jLabel12 = new javax.swing.JLabel();
        cards = new javax.swing.JPanel();
        newToolPAnel = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        addUpdate = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        Opertations = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        ToolCards = new javax.swing.JPanel();
        OperationsOnTools = new javax.swing.JPanel();
        panel1 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        searchKey1 = new javax.swing.JTextField();
        search = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        OperationsOnTools1 = new javax.swing.JPanel();
        done1 = new javax.swing.JButton();
        jPanel22 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        area = new javax.swing.JTextField();
        isle = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jPanel23 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        sector = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        CarierNo1 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel25 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        Size1 = new javax.swing.JTextField();
        jPanel26 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        Supplier1 = new javax.swing.JTextField();
        jPanel27 = new javax.swing.JPanel();
        jPanel28 = new javax.swing.JPanel();
        colorNo1 = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        Colors1 = new javax.swing.JList<>();
        jPanel32 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        Tool2 = new javax.swing.JTextField();
        Status1 = new javax.swing.JLabel();
        jPanel29 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        AddAndUpdate = new javax.swing.JPanel();
        jPanel30 = new javax.swing.JPanel();
        searchKey2 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jPanel24 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        Tool1 = new javax.swing.JComboBox<>();
        jPanel31 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        Size2 = new javax.swing.JComboBox<>();
        jPanel33 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        shelf2 = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jPanel34 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel39 = new javax.swing.JLabel();
        CarierNo2 = new javax.swing.JTextField();
        aisle3 = new javax.swing.JTextField();
        jPanel35 = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        suplier = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        ColorNo = new javax.swing.JTextField();
        jCheckBox5 = new javax.swing.JCheckBox();
        jCheckBox6 = new javax.swing.JCheckBox();
        jCheckBox7 = new javax.swing.JCheckBox();
        jCheckBox8 = new javax.swing.JCheckBox();
        OK = new javax.swing.JButton();
        jComboBox3 = new javax.swing.JComboBox<>();
        OrderListpanel = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollBar2 = new javax.swing.JScrollBar();
        ExpieredToolsPAnel = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollBar3 = new javax.swing.JScrollBar();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        sidePanel.setBackground(new java.awt.Color(255, 255, 255));
        sidePanel.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Traditional Arabic", 3, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("الحجاوي");
        sidePanel.add(jLabel1);
        jLabel1.setBounds(0, 54, 210, 37);

        jLabel2.setBackground(new java.awt.Color(17, 45, 57));
        jLabel2.setFont(new java.awt.Font("Traditional Arabic", 3, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("اسم المستخدم");
        sidePanel.add(jLabel2);
        jLabel2.setBounds(0, 110, 210, 32);

        ToolsStorage.setBackground(new java.awt.Color(255, 255, 255));
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
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("الأدوات");
        ToolsStorage.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 80, -1));

        sidePanel.add(ToolsStorage);
        ToolsStorage.setBounds(0, 250, 210, 46);

        orderList.setBackground(new java.awt.Color(255, 255, 255));
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

        jLabel5.setBackground(new java.awt.Color(51, 51, 51));
        jLabel5.setFont(new java.awt.Font("Traditional Arabic", 3, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("لائحة الطلبات");
        orderList.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 80, -1));

        sidePanel.add(orderList);
        orderList.setBounds(0, 190, 210, 46);

        signOut.setBackground(new java.awt.Color(17, 45, 57));
        signOut.setFont(new java.awt.Font("Traditional Arabic", 3, 18)); // NOI18N
        signOut.setForeground(new java.awt.Color(204, 0, 0));
        signOut.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        signOut.setText("تسجيل الخروج");
        signOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                signOutMousePressed(evt);
            }
        });
        sidePanel.add(signOut);
        signOut.setBounds(0, 410, 210, 35);

        expieredList.setBackground(new java.awt.Color(255, 255, 255));
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
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("لائحة الأدوات المنتهية ");
        expieredList.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 170, -1));

        sidePanel.add(expieredList);
        expieredList.setBounds(0, 310, 210, 46);

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/im5.jpg"))); // NOI18N
        sidePanel.add(jLabel12);
        jLabel12.setBounds(0, 400, 200, 150);

        cards.setLayout(new java.awt.CardLayout());

        addUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                addUpdateMousePressed(evt);
            }
        });

        jLabel11.setText("اضاف و تعديل ");

        javax.swing.GroupLayout addUpdateLayout = new javax.swing.GroupLayout(addUpdate);
        addUpdate.setLayout(addUpdateLayout);
        addUpdateLayout.setHorizontalGroup(
            addUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addUpdateLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
        );
        addUpdateLayout.setVerticalGroup(
            addUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addUpdateLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                .addContainerGap())
        );

        Opertations.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                OpertationsMousePressed(evt);
            }
        });

        jLabel32.setText("عمليات اخرى على الادوات");

        javax.swing.GroupLayout OpertationsLayout = new javax.swing.GroupLayout(Opertations);
        Opertations.setLayout(OpertationsLayout);
        OpertationsLayout.setHorizontalGroup(
            OpertationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OpertationsLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        OpertationsLayout.setVerticalGroup(
            OpertationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, OpertationsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Opertations, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(addUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(Opertations, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(63, 63, 63))
        );

        ToolCards.setLayout(new java.awt.CardLayout());

        OperationsOnTools.setBackground(new java.awt.Color(255, 255, 255));

        panel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel20.setBackground(new java.awt.Color(255, 255, 255));
        jPanel20.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        searchKey1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchKey1ActionPerformed(evt);
            }
        });
        jPanel20.add(searchKey1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, 290, 40));

        search.setBackground(new java.awt.Color(51, 51, 51));
        search.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchMouseClicked(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Traditional Arabic", 3, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 0, 0));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("بحث");

        javax.swing.GroupLayout searchLayout = new javax.swing.GroupLayout(search);
        search.setLayout(searchLayout);
        searchLayout.setHorizontalGroup(
            searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, searchLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                .addContainerGap())
        );
        searchLayout.setVerticalGroup(
            searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanel20.add(search, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 40));

        OperationsOnTools1.setBackground(new java.awt.Color(255, 255, 255));

        done1.setFont(new java.awt.Font("Traditional Arabic", 3, 18)); // NOI18N
        done1.setText("موافق");
        done1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                done1ActionPerformed(evt);
            }
        });

        jPanel22.setBackground(new java.awt.Color(255, 255, 255));
        jPanel22.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel22.setFont(new java.awt.Font("Traditional Arabic", 3, 18)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("موقع التخزين");
        jPanel22.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 0, 74, 26));

        area.setEditable(false);
        area.setBackground(new java.awt.Color(255, 255, 255));
        area.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                areaActionPerformed(evt);
            }
        });
        jPanel22.add(area, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 50, 150, 40));

        isle.setEditable(false);
        isle.setBackground(new java.awt.Color(255, 255, 255));
        isle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                isleActionPerformed(evt);
            }
        });
        jPanel22.add(isle, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, 150, 40));

        jLabel23.setFont(new java.awt.Font("Traditional Arabic", 3, 18)); // NOI18N
        jLabel23.setText("الممر");
        jPanel22.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 50, 50, 40));

        jLabel24.setFont(new java.awt.Font("Traditional Arabic", 3, 18)); // NOI18N
        jLabel24.setText("رقم المنطقة");
        jPanel22.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 50, 60, 40));

        jPanel23.setBackground(new java.awt.Color(255, 255, 255));
        jPanel23.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel25.setFont(new java.awt.Font("Traditional Arabic", 3, 18)); // NOI18N
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("القطاع");
        jPanel23.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 70, 26));
        jPanel23.add(sector, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 40));

        jPanel22.add(jPanel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 100, -1, 40));

        jLabel26.setFont(new java.awt.Font("Traditional Arabic", 3, 18)); // NOI18N
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("رقم الحاملة ");
        jPanel22.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 100, 70, 30));

        CarierNo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CarierNo1ActionPerformed(evt);
            }
        });
        jPanel22.add(CarierNo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 100, 150, 40));

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Traditional Arabic", 3, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(204, 0, 0));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("موافق");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanel22.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 150, 40));

        jPanel25.setBackground(new java.awt.Color(255, 255, 255));
        jPanel25.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel28.setFont(new java.awt.Font("Traditional Arabic", 3, 18)); // NOI18N
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("الحجم");
        jPanel25.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 74, 26));

        Size1.setEditable(false);
        Size1.setBackground(new java.awt.Color(255, 255, 255));
        Size1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Size1ActionPerformed(evt);
            }
        });
        jPanel25.add(Size1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 40));

        jPanel26.setBackground(new java.awt.Color(255, 255, 255));
        jPanel26.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel29.setFont(new java.awt.Font("Traditional Arabic", 3, 18)); // NOI18N
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("المورد");
        jPanel26.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, 74, 26));

        Supplier1.setEditable(false);
        Supplier1.setBackground(new java.awt.Color(255, 255, 255));
        Supplier1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Supplier1ActionPerformed(evt);
            }
        });
        jPanel26.add(Supplier1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 150, 40));

        jPanel27.setBackground(new java.awt.Color(255, 255, 255));

        jPanel28.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        colorNo1.setEditable(false);
        colorNo1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel30.setFont(new java.awt.Font("Traditional Arabic", 3, 18)); // NOI18N
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("عدد الالوان");

        Colors1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane5.setViewportView(Colors1);

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(407, 407, 407))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel27Layout.createSequentialGroup()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(colorNo1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)))
                .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(colorNo1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(42, 42, 42))
            .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel32.setBackground(new java.awt.Color(255, 255, 255));
        jPanel32.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel34.setFont(new java.awt.Font("Traditional Arabic", 3, 18)); // NOI18N
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel34.setText("نوع الاداة");
        jPanel32.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 74, 26));

        Tool2.setEditable(false);
        Tool2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel32.add(Tool2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 40));

        javax.swing.GroupLayout OperationsOnTools1Layout = new javax.swing.GroupLayout(OperationsOnTools1);
        OperationsOnTools1.setLayout(OperationsOnTools1Layout);
        OperationsOnTools1Layout.setHorizontalGroup(
            OperationsOnTools1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OperationsOnTools1Layout.createSequentialGroup()
                .addGroup(OperationsOnTools1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(OperationsOnTools1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(OperationsOnTools1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6))
                    .addGroup(OperationsOnTools1Layout.createSequentialGroup()
                        .addGap(0, 16, Short.MAX_VALUE)
                        .addGroup(OperationsOnTools1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(OperationsOnTools1Layout.createSequentialGroup()
                                .addComponent(done1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        OperationsOnTools1Layout.setVerticalGroup(
            OperationsOnTools1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OperationsOnTools1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(OperationsOnTools1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(OperationsOnTools1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(OperationsOnTools1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(OperationsOnTools1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(done1)))
                .addContainerGap(83, Short.MAX_VALUE))
        );

        Status1.setForeground(new java.awt.Color(255, 0, 0));
        Status1.setText("statusOF the tool");

        jPanel29.setBackground(new java.awt.Color(255, 255, 255));
        jPanel29.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel31.setFont(new java.awt.Font("Traditional Arabic", 3, 18)); // NOI18N
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("العملية");
        jPanel29.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 74, 26));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "استعارة", "ارجاع", "حذف" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        jPanel29.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 150, 40));

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(OperationsOnTools1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(Status1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(Status1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(OperationsOnTools1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(109, 109, 109))
        );

        javax.swing.GroupLayout OperationsOnToolsLayout = new javax.swing.GroupLayout(OperationsOnTools);
        OperationsOnTools.setLayout(OperationsOnToolsLayout);
        OperationsOnToolsLayout.setHorizontalGroup(
            OperationsOnToolsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OperationsOnToolsLayout.createSequentialGroup()
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, 683, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );
        OperationsOnToolsLayout.setVerticalGroup(
            OperationsOnToolsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, OperationsOnToolsLayout.createSequentialGroup()
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, 536, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        ToolCards.add(OperationsOnTools, "card3");

        jPanel30.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        searchKey2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchKey2ActionPerformed(evt);
            }
        });
        jPanel30.add(searchKey2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, 320, 40));

        jButton3.setFont(new java.awt.Font("Traditional Arabic", 3, 18)); // NOI18N
        jButton3.setText("بحث");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel30.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, 40));

        jLabel13.setFont(new java.awt.Font("Traditional Arabic", 3, 18)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("بحث عن اداة");
        jPanel30.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 0, 90, 38));

        jPanel24.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel27.setFont(new java.awt.Font("Traditional Arabic", 3, 18)); // NOI18N
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("نوع الاداة");
        jPanel24.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 74, 26));

        Tool1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dicut", "IClasheh", "IPlate" }));
        Tool1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tool1ActionPerformed(evt);
            }
        });
        jPanel24.add(Tool1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 40));

        jPanel31.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel33.setFont(new java.awt.Font("Traditional Arabic", 3, 18)); // NOI18N
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setText("الحجم");
        jPanel31.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 74, 26));

        Size2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "70*100", "50*30", "غير ذلك" }));
        jPanel31.add(Size2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 40));

        jPanel33.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel35.setFont(new java.awt.Font("Traditional Arabic", 3, 18)); // NOI18N
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setText("موقع التخزين");
        jPanel33.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 10, 74, 26));

        shelf2.setEditable(false);
        shelf2.setBackground(new java.awt.Color(255, 255, 255));
        shelf2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shelf2ActionPerformed(evt);
            }
        });
        jPanel33.add(shelf2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, 150, 40));

        jLabel36.setFont(new java.awt.Font("Traditional Arabic", 3, 18)); // NOI18N
        jLabel36.setText("الرف");
        jPanel33.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 40, 50, 40));

        jLabel37.setFont(new java.awt.Font("Traditional Arabic", 3, 18)); // NOI18N
        jLabel37.setText("الممر");
        jPanel33.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 40, 50, 40));

        jPanel34.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel38.setFont(new java.awt.Font("Traditional Arabic", 3, 18)); // NOI18N
        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel38.setText("القطاع");
        jPanel34.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 74, 26));

        jComboBox1.setFont(new java.awt.Font("Traditional Arabic", 3, 18)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "مطاعم", "الادوية", "بنوك", "تعليم", "اخرى" }));
        jPanel34.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 150, 40));

        jPanel33.add(jPanel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(414, 90, 250, 40));

        jLabel39.setFont(new java.awt.Font("Traditional Arabic", 3, 18)); // NOI18N
        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel39.setText("رقم الحاملة ");
        jPanel33.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 100, 70, 30));

        CarierNo2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CarierNo2ActionPerformed(evt);
            }
        });
        jPanel33.add(CarierNo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 150, 40));

        aisle3.setEditable(false);
        aisle3.setBackground(new java.awt.Color(255, 255, 255));
        aisle3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aisle3ActionPerformed(evt);
            }
        });
        jPanel33.add(aisle3, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 40, 150, 40));

        jPanel35.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel40.setFont(new java.awt.Font("Traditional Arabic", 3, 18)); // NOI18N
        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel40.setText("المورد");
        jPanel35.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 74, 26));

        suplier.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nablus", "Ramallah" }));
        suplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suplierActionPerformed(evt);
            }
        });
        jPanel35.add(suplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 40));

        jLabel8.setText("عدد الألوان");

        ColorNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ColorNoActionPerformed(evt);
            }
        });

        jCheckBox5.setText("أسود");
        jCheckBox5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jCheckBox6.setText("أزرق");
        jCheckBox6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jCheckBox6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox6ActionPerformed(evt);
            }
        });

        jCheckBox7.setText("أصفر");
        jCheckBox7.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jCheckBox8.setText("أحمر");
        jCheckBox8.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        OK.setFont(new java.awt.Font("Traditional Arabic", 3, 24)); // NOI18N
        OK.setText("موافق");
        OK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OKActionPerformed(evt);
            }
        });

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "اضافة", "تعديل" }));

        javax.swing.GroupLayout AddAndUpdateLayout = new javax.swing.GroupLayout(AddAndUpdate);
        AddAndUpdate.setLayout(AddAndUpdateLayout);
        AddAndUpdateLayout.setHorizontalGroup(
            AddAndUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddAndUpdateLayout.createSequentialGroup()
                .addGroup(AddAndUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(AddAndUpdateLayout.createSequentialGroup()
                        .addContainerGap(105, Short.MAX_VALUE)
                        .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, 662, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(AddAndUpdateLayout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(AddAndUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(AddAndUpdateLayout.createSequentialGroup()
                                .addGroup(AddAndUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jPanel35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(AddAndUpdateLayout.createSequentialGroup()
                                        .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AddAndUpdateLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(OK, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(AddAndUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox5)
                    .addComponent(jCheckBox6)
                    .addComponent(jCheckBox7)
                    .addComponent(jCheckBox8))
                .addGap(66, 66, 66)
                .addComponent(ColorNo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        AddAndUpdateLayout.setVerticalGroup(
            AddAndUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddAndUpdateLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AddAndUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboBox3)
                    .addComponent(jPanel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(39, 39, 39)
                .addGroup(AddAndUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(AddAndUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AddAndUpdateLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(AddAndUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(AddAndUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(ColorNo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(AddAndUpdateLayout.createSequentialGroup()
                                .addComponent(jCheckBox5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox7)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox8)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AddAndUpdateLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                        .addComponent(OK)
                        .addGap(78, 78, 78))))
        );

        ToolCards.add(AddAndUpdate, "card2");

        javax.swing.GroupLayout newToolPAnelLayout = new javax.swing.GroupLayout(newToolPAnel);
        newToolPAnel.setLayout(newToolPAnelLayout);
        newToolPAnelLayout.setHorizontalGroup(
            newToolPAnelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(newToolPAnelLayout.createSequentialGroup()
                .addComponent(ToolCards, javax.swing.GroupLayout.PREFERRED_SIZE, 689, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        newToolPAnelLayout.setVerticalGroup(
            newToolPAnelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(newToolPAnelLayout.createSequentialGroup()
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ToolCards, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        cards.add(newToolPAnel, "card5");

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
                .addContainerGap(46, Short.MAX_VALUE)
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
                .addContainerGap(490, Short.MAX_VALUE)
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
                .addComponent(cards, javax.swing.GroupLayout.DEFAULT_SIZE, 689, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sidePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cards, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(sidePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(918, 593));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ToolsStorageMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ToolsStorageMousePressed
        // TODO add your handling code here:

        setColor(ToolsStorage);
        resetColor(orderList);
        resetColor(expieredList);

        endtool.setOpaque(true);
        endReq.setOpaque(false);
        endWorker1.setOpaque(false);

        cardLayout.show(cards, "card5");
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

    private void searchKey1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchKey1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchKey1ActionPerformed

    private void areaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_areaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_areaActionPerformed

    private void isleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_isleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_isleActionPerformed

    private void CarierNo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CarierNo1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CarierNo1ActionPerformed

    private void Tool1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Tool1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Tool1ActionPerformed

    private void Supplier1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Supplier1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Supplier1ActionPerformed

    private void jCheckBox6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox6ActionPerformed

    private void done1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_done1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_done1ActionPerformed

    private void addUpdateMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addUpdateMousePressed
        // TODO add your handling code here:
         setColor(addUpdate);
         resetColor(Opertations);
        
        cardLayout2.show(ToolCards, "card2");
    }//GEN-LAST:event_addUpdateMousePressed

    private void OpertationsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OpertationsMousePressed
        // TODO add your handling code here:
        resetColor(addUpdate);
        setColor(Opertations);
        cardLayout2.show(ToolCards, "card3");
    }//GEN-LAST:event_OpertationsMousePressed

    private void searchKey2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchKey2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchKey2ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void ColorNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ColorNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ColorNoActionPerformed

    private void shelf2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shelf2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_shelf2ActionPerformed

    private void CarierNo2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CarierNo2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CarierNo2ActionPerformed

    private void Size1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Size1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Size1ActionPerformed

    private void suplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suplierActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_suplierActionPerformed

    private void aisle3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aisle3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_aisle3ActionPerformed

    private void OKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OKActionPerformed
        // TODO add your handling code here:
ArrayList<String> color=new ArrayList<String>();  
        int no=0;
        String otype=(String) this.jComboBox3.getSelectedItem();
       if(otype=="اضافة"){
        if(this.jCheckBox5.isSelected()){color.add("أسود");no++;}
        if(this.jCheckBox6.isSelected()){color.add("أزرق");no++;}
        if(this.jCheckBox7.isSelected()){color.add("أصفر");no++;}
        if(this.jCheckBox8.isSelected()){color.add("أحمر");no++;}
        String tooltype=(String) this.Tool1.getSelectedItem();
        String supplier=(String) this.suplier.getSelectedItem();
        String size=(String) this.Size2.getSelectedItem();
        String sector=(String) this.jComboBox1.getSelectedItem();
        StringBuilder toolname = new StringBuilder();
        Connection connection;
        long millis=System.currentTimeMillis();  
        java.sql.Date date = new java.sql.Date(millis);  
        PreparedStatement ps,ps1,ps2;
        int size1=1;
        int isle=0;
        char s;
        char jobOfTool='R';
        int cNo=0;
        int area=0;
             if(size=="70×100")size1=1;
             else if(size=="50×30")size1=2; 
             else size1=3; 
             
             if("Ramallah".equals(supplier))s='R';
             else s='N';
              
             if(null!=sector)switch (sector) {
            case "مطاعم":
                jobOfTool='R';
                break;
            case "الادوية":
                jobOfTool='M';
                break;
            case "اخرى":
                jobOfTool='O';
                break;
            case "تعليم":
                jobOfTool='E';
                break;
            case "بنوك":
                jobOfTool='B';
                break;
            default:
                break;
        }
                if("Dicut"==tooltype){
           try { 
               if(size1==1)isle=1;
               else if(size1==2)isle=2;
               else if(size1==3 && jobOfTool=='R' ||jobOfTool=='M' )isle=3;
               else isle=4;
               
               area=1;
             connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/compony","root","");
              ps1 = connection.prepareStatement("SELECT MAX(carierNo) AS number FROM dicut WHERE   isle=?");
               ps1.setInt(1,isle);
               ResultSet s1 = ps1.executeQuery();
                if(s1.next()){
                     cNo=s1.getInt(1)+1;
                }
             ps = connection.prepareStatement("INSERT INTO dicut(name,type,sector,size,area,status,DateOfAttachment,supplier,isle,carierNo) VALUES (?,?,?,?,?,?,?,?,?,?)");
             toolname.append('D');//type
             toolname.append(size1);//size
             toolname.append(jobOfTool);
             toolname.append(cNo);
             toolname.append(s);//supplier

             ps.setString(1,toolname.toString());
             ps.setString(2,tooltype);
             ps.setString(3,sector);
             ps.setInt(4,size1);
              ps.setInt(5,area);
             ps.setInt(6,1);//status
             ps.setDate(7,date);
             ps.setString(8,supplier);
             ps.setInt(9,isle);
             ps.setInt(10,cNo);

             boolean rs = ps.execute();
             if(!rs)JOptionPane.showMessageDialog(this, "تم الاضافة بنجاح\n Tool name="+toolname.toString());
             else  JOptionPane.showMessageDialog(this, "Erorr");       
             } catch (HeadlessException | SQLException ex ) {
             JOptionPane.showMessageDialog(this,"Wrong \n"+ex );
             }    
             }    
        
                
                else if("IClasheh"==tooltype && !this.ColorNo.getText().isEmpty() ){
               try { 
               int colorno=Integer.parseInt(this.ColorNo.getText());
               if(size1==1)isle=1;
               else if(size1==2)isle=2;
               else if(size1==3 && jobOfTool=='R' ||jobOfTool=='M' )isle=3;
               else isle=4;
               
               area=3;
               connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/compony","root","");
               ps1 = connection.prepareStatement("SELECT MAX(carierNo) AS number FROM iclasheh  WHERE   isle=?");
               ps1.setInt(1,isle);
               ResultSet s1 = ps1.executeQuery();
               if(s1.next()){
                     cNo=s1.getInt(1)+1;
                }
             ps = connection.prepareStatement("INSERT INTO iclasheh(name,type,sector,size,area,status,DateOfAttachment,isle,carierNo,colornumber) VALUES (?,?,?,?,?,?,?,?,?,?)");
             toolname.append('C');//type
             toolname.append(size1);//size
             toolname.append(jobOfTool);
             toolname.append(cNo);//????????????????????????????car
             toolname.append(colorno);

             ps.setString(1,toolname.toString());
             ps.setString(2,tooltype);
             ps.setString(3,sector);
             ps.setInt(4,size1);
             ps.setInt(5,area);
             ps.setInt(6,1);//status
             ps.setDate(7,date);
             ps.setInt(8,isle);
             ps.setInt(9,cNo);//?????????????????????????????????cariire
             ps.setInt(10,colorno);
             boolean rs = ps.execute();
             if(!rs)JOptionPane.showMessageDialog(this, "تم الاضافة بنجاح\n Tool name="+toolname.toString());
             else  JOptionPane.showMessageDialog(this, "Erorr");       
             } catch (HeadlessException | SQLException ex ) {
             JOptionPane.showMessageDialog(this,"Wrong \n"+ex );
             }    
             }  
                
               else if("IPlate"==tooltype && no!=0){
               try { 
   
        
               if(size1==1 && jobOfTool=='R')isle=1;
               else if(size1==1 && jobOfTool=='M')isle=1;
               
               else if(size1==1 && jobOfTool=='B')isle=2;
               else if(size1==1 )isle=2;
               
               else if(size1==2 && jobOfTool=='R')isle=3;
               else if(size1==2 && jobOfTool=='M')isle=3;
               else if(size1==2 && jobOfTool=='B')isle=4;
               else if(size1==2 && jobOfTool=='E')isle=4;
               else if(size1==2)isle=4;
               
               area=2;
               connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/compony","root","");
               ps1 = connection.prepareStatement("SELECT MAX(carierNo) AS number FROM iplate  WHERE   isle=?");
               ps1.setInt(1,isle);
               ResultSet s1 = ps1.executeQuery();
               if(s1.next()){
                     cNo=s1.getInt(1)+1;
                }
                 toolname.append('P');//type
             toolname.append(size1);//size
             toolname.append(jobOfTool);
             toolname.append(cNo);//????????????????????????????car
             toolname.append(no);//color

             
             ps = connection.prepareStatement("INSERT INTO iplate(name,type,sector,size,area,status,DateOfAttachment,isle,carierNo,colornumber) VALUES (?,?,?,?,?,?,?,?,?,?)");
           

             ps.setString(1,toolname.toString());
             ps.setString(2,tooltype);
             ps.setString(3,sector);
             ps.setInt(4,size1);
             ps.setInt(5,area);
             ps.setInt(6,1);//status
             ps.setDate(7,date);
             ps.setInt(8,isle);
             ps.setInt(9,cNo);//?????????????????????????????????cariire
             ps.setInt(10,no);
             boolean rs = ps.execute();
             if(!rs)JOptionPane.showMessageDialog(this, "تم الاضافة بنجاح\n Tool name="+toolname.toString());
             else  JOptionPane.showMessageDialog(this, "Erorr"); 
         
              for (String color1 : color) {
                   connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/compony","root","");
                   ps1 = connection.prepareStatement("INSERT INTO color(platename,color) VALUES (?,?)");
                   ps1.setString(1,toolname.toString());
                   ps1.setString(2, color1);
                   ps1.execute();
               }
             } catch (HeadlessException | SQLException ex ) {
             JOptionPane.showMessageDialog(this,"Wrong \n"+ex );
             }    
             }
             else  JOptionPane.showMessageDialog(this, "Erorr");    
       }
    }//GEN-LAST:event_OKActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        this.jCheckBox5.setSelected(false);
this.jCheckBox6.setSelected(false);
this.jCheckBox7.setSelected(false);
this.jCheckBox8.setSelected(false);
        String TypeOfTool1="";
       String size1="";
       String JobOfTool1="";
       String supplier1="";
       String status1="";
       int status;
       int size=0;
       int flag=0;
       int isle=0;
       int carierNo =0;
       int ordernumber1=0;
       int colornumber1=0;
       int area=0;
        String search=this.searchKey2.getText();
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
                        area=rs.getInt(5);
                        status=rs.getInt(6);
                        supplier1=rs.getString(9);
                        isle=rs.getInt(10);
                        carierNo =rs.getInt(11);
                        if(status==1)status1="متوفر";
                        if(status==0) status1="غير متوفر";
                        switch (size) {
                            case 1:
                                size1="70×100";
                                break;
                            case 2:
                                size1="50×30";
                                break;
                            case 3:
                                size1="غير ذلك";
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
                        area=rs1.getInt(5);
                        status=rs1.getInt(6);
                        isle=rs1.getInt(9);
                        carierNo =rs1.getInt(10);
                        colornumber1=rs1.getInt(11);
                  
                          if(status==1)status1="متوفر";
                        if(status==0) status1="غير متوفر";
                        switch (size) {
                            case 1:
                                size1="70×100";
                                break;
                            case 2:
                                size1="50×30";
                                break;
                            default:
                                break;
                        }
                        
                    }
                    
                    else  JOptionPane.showMessageDialog(this,"Not Found" );
                  
                   ps2 = connection.prepareStatement("SELECT color FROM color WHERE platename=?");
                   ps2.setString(1, search);
                  ResultSet rs= ps2.executeQuery();
                   ArrayList<String> colorr=new ArrayList<String>(); 
                  while(rs.next()){
                      colorr.add(rs.getString(1));
                  }
                for (String color1 : colorr) {
                 if(color1.equals("أسود"))this.jCheckBox5.setSelected(true);
                 if(color1.equals("أزرق"))this.jCheckBox6.setSelected(true);
                 if(color1.equals("أصفر"))this.jCheckBox7.setSelected(true);
                 if(color1.equals("أحمر"))this.jCheckBox8.setSelected(true);
                  }
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
                        status=rs1.getInt(6);
                        area=rs1.getInt(5);
                        isle=rs1.getInt(9);
                        carierNo=rs1.getInt(10);
                        colornumber1=rs1.getInt(11);
                        if(status==1)status1="متوفر";
                        if(status==0) status1="غير متوفر";
                        switch (size) {
                           case 1:
                                size1="70×100";
                                break;
                            case 2:
                                size1="50×30";
                                break;
                            case 3:
                                size1="غير ذلك";
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
        
this.Tool1.setSelectedItem(TypeOfTool1);
this.suplier.setSelectedItem(supplier1);
this.Size2.setSelectedItem(size1);
this.jComboBox1.setSelectedItem(JobOfTool1);
this.aisle3.setText(Integer.toString(area));
this.shelf2.setText(Integer.toString(isle));
this.CarierNo2.setText(Integer.toString(carierNo));
this.ColorNo.setText(Integer.toString(colornumber1));
    }//GEN-LAST:event_jButton3ActionPerformed

    private void searchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchMouseClicked
        // TODO add your handling code here:
                Vector data = new Vector();
        this.Tool2.setText("");
this.Supplier1.setText("");
this.Size1.setText("");
this.sector.setText("");
this.area.setText("");
this.isle.setText("");
this.CarierNo1.setText("");
this.colorNo1.setText("");
 this.Colors1.setListData(data);
        String TypeOfTool1="";
       String size1="";
       String JobOfTool1="";
       String supplier1="";
       String status1="";
       int status;
       int size=0;
       int flag=0;
       int isle=0;
       int carierNo =0;
       int ordernumber1=0;
       int colornumber1=0;
       int area=0;
        String search=this.searchKey1.getText();
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
                        area=rs.getInt(5);
                        status=rs.getInt(6);
                        supplier1=rs.getString(9);
                        isle=rs.getInt(10);
                        carierNo =rs.getInt(11);
                        if(status==1)status1="متوفر";
                        if(status==0) status1="غير متوفر";
                        switch (size) {
                            case 1:
                                size1="70×100";
                                break;
                            case 2:
                                size1="50×30";
                                break;
                            case 3:
                                size1="غير ذلك";
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
                        area=rs1.getInt(5);
                        status=rs1.getInt(6);
                        isle=rs1.getInt(9);
                        carierNo =rs1.getInt(10);
                        colornumber1=rs1.getInt(11);
                  
                    
                         ps2 = connection.prepareStatement("select * from color where platename= ?");
                         ps2.setString(1,search );
                         ResultSet rs2 = ps2.executeQuery();
                         while(rs2.next()){
                             
                            data.addElement(rs2.getString(2));
                         }
                             this.Colors1.setListData(data);
                        
                          if(status==1)status1="متوفر";
                        if(status==0) status1="غير متوفر";
                        switch (size) {
                            case 1:
                                size1="70×100";
                                break;
                            case 2:
                                size1="50×30";
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
                        status=rs1.getInt(6);
                        area=rs1.getInt(5);
                        isle=rs1.getInt(9);
                        carierNo=rs1.getInt(10);
                        colornumber1=rs1.getInt(11);
                        if(status==1)status1="متوفر";
                        if(status==0) status1="غير متوفر";
                        switch (size) {
                           case 1:
                                size1="70×100";
                                break;
                            case 2:
                                size1="50×30";
                                break;
                            case 3:
                                size1="غير ذلك";
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
        
this.Tool2.setText(TypeOfTool1);
this.Supplier1.setText(supplier1);
this.Size1.setText(size1);
this.sector.setText(JobOfTool1);
this.Status1.setText(status1);
this.area.setText(Integer.toString(area));
this.isle.setText(Integer.toString(isle));
this.CarierNo1.setText(Integer.toString(carierNo));
this.colorNo1.setText(Integer.toString(colornumber1));
    }//GEN-LAST:event_searchMouseClicked

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        // TODO add your handling code here:
        String otype=(String) this.jComboBox2.getSelectedItem(); 
boolean empty=this.searchKey1.getText().isEmpty();

  if(otype=="استعارة" && !empty){
      String search=this.searchKey1.getText();
      char type=search.charAt(0);
      int status=0;
      if(type=='D'){
          Connection connection;
          try {
              connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/compony","root","");
              PreparedStatement ps = connection.prepareStatement("SELECT status FROM dicut WHERE  name=?");
              ps.setString(1,search);
                ResultSet s1 = ps.executeQuery();
                if(s1.next()) status =s1.getInt(1);
                if(status==1){
               PreparedStatement ps1 = connection.prepareStatement("UPDATE dicut SET status=? WHERE name=?");
               ps1.setInt(1,0);
                 ps1.setString(2,search);
                    boolean rs = ps1.execute();
             if(!rs)JOptionPane.showMessageDialog(this, "تم ىنجاح");
             else  JOptionPane.showMessageDialog(this, "Erorr"); 
               
                }
                else JOptionPane.showMessageDialog(this, "الاداة غير متوفرة تمت استعارتها");
                
          } catch (SQLException ex) {
              Logger.getLogger(storage.class.getName()).log(Level.SEVERE, null, ex);
          }
         
      }
      else  if(type=='P'){
          Connection connection;
          try {
              connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/compony","root","");
              PreparedStatement ps = connection.prepareStatement("SELECT status FROM iplate WHERE  name=?");
              ps.setString(1,search);
                ResultSet s2 = ps.executeQuery();
                if(s2.next()) status =s2.getInt(1);
                if(status==1){
               PreparedStatement ps2 = connection.prepareStatement("UPDATE iplate SET status=? WHERE name=?");
               ps2.setInt(1,0);
                 ps2.setString(2,search);
                    boolean rs2 = ps2.execute();
             if(!rs2)JOptionPane.showMessageDialog(this, "تم ىنجاح");
             else  JOptionPane.showMessageDialog(this, "Erorr"); 
               
                }
                else JOptionPane.showMessageDialog(this, "الاداة غير متوفرة تمت استعارتها");
                
          } catch (SQLException ex) {
              Logger.getLogger(storage.class.getName()).log(Level.SEVERE, null, ex);
          }
         
      } 
            else  if(type=='C'){
          Connection connection;
          try {
              connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/compony","root","");
              PreparedStatement ps = connection.prepareStatement("SELECT status FROM iclasheh WHERE  name=?");
              ps.setString(1,search);
                ResultSet s3 = ps.executeQuery();
                if(s3.next()) status =s3.getInt(1);
                if(status==1){
               PreparedStatement ps3 = connection.prepareStatement("UPDATE iclasheh SET status=? WHERE name=?");
               ps3.setInt(1,0);
               ps3.setString(2,search);
                boolean rs3 = ps3.execute();
             if(!rs3)JOptionPane.showMessageDialog(this, "تم ىنجاح");
             else  JOptionPane.showMessageDialog(this, "Erorr"); 
               
                }
                else JOptionPane.showMessageDialog(this, "الاداة غير متوفرة تمت استعارتها");
                
          } catch (SQLException ex) {
              Logger.getLogger(storage.class.getName()).log(Level.SEVERE, null, ex);
          }
         
      } 
  }
    if(otype=="ارجاع" && !empty){
      String search=this.searchKey1.getText();
      char type=search.charAt(0);
      int status=0;
      if(type=='D'){
          Connection connection;
          try {
              connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/compony","root","");
              PreparedStatement ps = connection.prepareStatement("SELECT status FROM dicut WHERE  name=?");
              ps.setString(1,search);
                ResultSet s1 = ps.executeQuery();
                if(s1.next()) status =s1.getInt(1);
                if(status==0){
               PreparedStatement ps1 = connection.prepareStatement("UPDATE dicut SET status=? WHERE name=?");
               ps1.setInt(1,1);
                 ps1.setString(2,search);
                    boolean rs = ps1.execute();
             if(!rs)JOptionPane.showMessageDialog(this, "تم ىنجاح");
             else  JOptionPane.showMessageDialog(this, "Erorr"); 
               
                }
                else JOptionPane.showMessageDialog(this, "الاداة  متوفرة ");
                
          } catch (SQLException ex) {
              Logger.getLogger(storage.class.getName()).log(Level.SEVERE, null, ex);
          }
         
      }
      else  if(type=='P'){
          Connection connection;
          try {
              connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/compony","root","");
              PreparedStatement ps = connection.prepareStatement("SELECT status FROM iplate WHERE  name=?");
              ps.setString(1,search);
                ResultSet s2 = ps.executeQuery();
                if(s2.next()) status =s2.getInt(1);
                if(status==0){
               PreparedStatement ps2 = connection.prepareStatement("UPDATE iplate SET status=? WHERE name=?");
               ps2.setInt(1,1);
                 ps2.setString(2,search);
                    boolean rs2 = ps2.execute();
             if(!rs2)JOptionPane.showMessageDialog(this, "تم ىنجاح");
             else  JOptionPane.showMessageDialog(this, "Erorr"); 
               
                }
                else JOptionPane.showMessageDialog(this, "الاداة متوفرة");
                
          } catch (SQLException ex) {
              Logger.getLogger(storage.class.getName()).log(Level.SEVERE, null, ex);
          }
         
      } 
            else  if(type=='C'){
          Connection connection;
          try {
              connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/compony","root","");
              PreparedStatement ps = connection.prepareStatement("SELECT status FROM iclasheh WHERE  name=?");
              ps.setString(1,search);
                ResultSet s3 = ps.executeQuery();
                if(s3.next()) status =s3.getInt(1);
                if(status==0){
               PreparedStatement ps3 = connection.prepareStatement("UPDATE iclasheh SET status=? WHERE name=?");
               ps3.setInt(1,1);
               ps3.setString(2,search);
                boolean rs3 = ps3.execute();
             if(!rs3)JOptionPane.showMessageDialog(this, "تم ىنجاح");
             else  JOptionPane.showMessageDialog(this, "Erorr"); 
               
                }
                else JOptionPane.showMessageDialog(this, "الاداة متوفرة");
                
          } catch (SQLException ex) {
              Logger.getLogger(storage.class.getName()).log(Level.SEVERE, null, ex);
          }
         
      } 
  }
        if(otype=="حذف" && !empty){
      String search=this.searchKey1.getText();
      char type=search.charAt(0);
      int status=0;
      if(type=='D'){
          Connection connection;
          try {
              connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/compony","root","");
              PreparedStatement ps = connection.prepareStatement("SELECT status FROM dicut WHERE  name=?");
              ps.setString(1,search);
                ResultSet s1 = ps.executeQuery();
                if(s1.next()) {
                     PreparedStatement ps1 = connection.prepareStatement("DELETE FROM dicut WHERE  name=?");  
                 ps1.setString(1,search);
                    boolean rs1 = ps1.execute();
             if(!rs1)JOptionPane.showMessageDialog(this, "تم ىنجاح");
             else  JOptionPane.showMessageDialog(this, "Erorr"); 
                }  
                   JOptionPane.showMessageDialog(this, "لم يتم العثور على الاداة");
          } catch (SQLException ex) {
              Logger.getLogger(storage.class.getName()).log(Level.SEVERE, null, ex);
          }
         
      }
      else  if(type=='P'){
          Connection connection;
          try {
              connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/compony","root","");
              PreparedStatement ps = connection.prepareStatement("SELECT status FROM iplate WHERE  name=?");
              ps.setString(1,search);
                ResultSet s1 = ps.executeQuery();
                if(s1.next()) {
                     PreparedStatement ps1 = connection.prepareStatement("DELETE FROM iplate  WHERE  name=?");  
                 ps1.setString(1,search);
                    boolean rs1 = ps1.execute();
             if(!rs1)JOptionPane.showMessageDialog(this, "تم ىنجاح");
             else  JOptionPane.showMessageDialog(this, "Erorr"); 
                }   
                   JOptionPane.showMessageDialog(this, "لم يتم العثور على الاداة");
          } catch (SQLException ex) {
              Logger.getLogger(storage.class.getName()).log(Level.SEVERE, null, ex);
          }
         
      } 
            else  if(type=='C'){
          Connection connection;
          try {
              connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/compony","root","");
              PreparedStatement ps = connection.prepareStatement("SELECT status FROM iclasheh WHERE  name=?");
              ps.setString(1,search);
               ResultSet s1 = ps.executeQuery();
              if(s1.next()) {
                     PreparedStatement ps1 = connection.prepareStatement("DELETE FROM iclasheh  WHERE  name=?");  
                 ps1.setString(1,search);
                    boolean rs1 = ps1.execute();
             if(!rs1)JOptionPane.showMessageDialog(this, "تم ىنجاح");
             else  JOptionPane.showMessageDialog(this, "Erorr"); 
                }  
              JOptionPane.showMessageDialog(this, "لم يتم العثور على الاداة");
          } catch (SQLException ex) {
              Logger.getLogger(storage.class.getName()).log(Level.SEVERE, null, ex);
          }
         
      } 
  }
    }//GEN-LAST:event_jPanel1MouseClicked

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
    private javax.swing.JPanel AddAndUpdate;
    private javax.swing.JTextField CarierNo1;
    private javax.swing.JTextField CarierNo2;
    private javax.swing.JTextField ColorNo;
    private javax.swing.JList<String> Colors1;
    private javax.swing.JPanel ExpieredToolsPAnel;
    private javax.swing.JButton OK;
    private javax.swing.JPanel OperationsOnTools;
    private javax.swing.JPanel OperationsOnTools1;
    private javax.swing.JPanel Opertations;
    private javax.swing.JPanel OrderListpanel;
    private javax.swing.JTextField Size1;
    private javax.swing.JComboBox<String> Size2;
    private javax.swing.JLabel Status1;
    private javax.swing.JTextField Supplier1;
    private javax.swing.JComboBox<String> Tool1;
    private javax.swing.JTextField Tool2;
    private javax.swing.JPanel ToolCards;
    private javax.swing.JPanel ToolsStorage;
    private javax.swing.JPanel addUpdate;
    private javax.swing.JTextField aisle3;
    private javax.swing.JTextField area;
    private javax.swing.JPanel cards;
    private javax.swing.JTextField colorNo1;
    private javax.swing.JButton done1;
    private javax.swing.JPanel endReq;
    private javax.swing.JPanel endWorker1;
    private javax.swing.JPanel endtool;
    private javax.swing.JPanel expieredList;
    private javax.swing.JTextField isle;
    private javax.swing.JButton jButton3;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JCheckBox jCheckBox7;
    private javax.swing.JCheckBox jCheckBox8;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JScrollBar jScrollBar2;
    private javax.swing.JScrollBar jScrollBar3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JPanel newToolPAnel;
    private javax.swing.JPanel orderList;
    private javax.swing.JPanel panel1;
    private javax.swing.JPanel search;
    private javax.swing.JTextField searchKey1;
    private javax.swing.JTextField searchKey2;
    private javax.swing.JTextField sector;
    private javax.swing.JTextField shelf2;
    private javax.swing.JPanel sidePanel;
    private javax.swing.JLabel signOut;
    private javax.swing.JComboBox<String> suplier;
    // End of variables declaration//GEN-END:variables
}
