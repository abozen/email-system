

import java.awt.Color;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author abozen
 */
public class fMailBox extends javax.swing.JFrame {

    /**
     * Creates new form fMailBox
     */
    
    int userNo = 0;
    boolean toRead = true;
    
    public fMailBox() {
        initComponents();
        tb_b2.setBackground(Color.red);
        
    }
    
    public fMailBox(int userNo){
        initComponents();
        tb_b2.setBackground(Color.red);
        this.userNo = userNo;
        createTable(userNo);
    }
    
    
    // A method to get email name by using userNo
    public String getEmail(int userNo){
        String ret = "";
        
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=CONVERT_TO_NULL","root","369874125");
            Statement st = con.createStatement();
            
            String query = "SELECT email FROM asd.users WHERE userNo='"+ userNo +"' ";
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                ret = rs.getString(1);
            }
   
        }catch(HeadlessException | SQLException E){
            JOptionPane.showMessageDialog(null,E );
        }
        return ret;
    }
    
    // A method to get the number of mails that user recieved
    public int getNumberOfMails(int userNo){
        int numberOfMails = 0;
        try{
            
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=CONVERT_TO_NULL","root","369874125");
            Statement st = con.createStatement();
            
            String query = "SELECT COUNT(*) AS '"+ userNo +"'  FROM asd.mails WHERE recieverNo='"+ userNo +"' ";
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                numberOfMails = rs.getInt(1);
            }
            
            
        }catch(HeadlessException | SQLException E){
            JOptionPane.showMessageDialog(null,E );
        }
        return numberOfMails;
    }
    
    // A method to get the topics of mails that user recieved  as an array
    public String[] getTopics(int userNo){
        String[] ret = new String[getNumberOfMails(userNo)];
        try{
            int counter = 0;
            
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=CONVERT_TO_NULL","root","369874125");
            Statement st = con.createStatement();
            
            String query = "SELECT topic FROM asd.mails WHERE recieverNo='"+ userNo +"' ";
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                ret[counter] = rs.getString(1);
                counter++;
            }
            
            
        }catch(HeadlessException | SQLException E){
            JOptionPane.showMessageDialog(null,E );
        }
        
        
        return ret;
    }
    
    // A method to get the senders userNo as an array
    public String[] getSenders(int userNo){
        String[] ret = new String[getNumberOfMails(userNo)];
        try{
            int counter = 0;
            
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=CONVERT_TO_NULL","root","369874125");
            Statement st = con.createStatement();
            
            String query = "SELECT senderNo FROM asd.mails WHERE recieverNo='"+ userNo +"' ";
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                ret[counter] = getEmail(rs.getInt(1));
                counter++;
            }
            
            
        }catch(HeadlessException | SQLException E){
            JOptionPane.showMessageDialog(null,E );
        }
        
        
        return ret;
    }
    
    public String getMail(int userNo, int row){
        String ret = "";
        try{
            int counter = 0;
            
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=CONVERT_TO_NULL","root","369874125");
            Statement st = con.createStatement();
            
            String query = "SELECT mail FROM asd.mails WHERE recieverNo='"+ userNo +"' ";
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                if(counter == row)
                    ret = rs.getString(1);
                counter++;
            }
            
            
        }catch(HeadlessException | SQLException E){
            JOptionPane.showMessageDialog(null,E );
        }
        return ret;
    }
    
    public int getMailNo(int userNo, int row){
        int ret = 0;
        try{
            int counter = 0;
            
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=CONVERT_TO_NULL","root","369874125");
            Statement st = con.createStatement();
            
            String query = "SELECT mailNo FROM asd.mails WHERE recieverNo='"+ userNo +"' ";
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                if(counter == row)
                    ret = rs.getInt(1);
                counter++;
            }
            
            
        }catch(HeadlessException | SQLException E){
            JOptionPane.showMessageDialog(null,E );
        }
        return ret;
    }
    
    public void deleteMail(int mailNo){
        int ret = 0;
        
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=CONVERT_TO_NULL","root","369874125");
            Statement st = con.createStatement();
            
            String query = "DELETE FROM asd.mails WHERE mailNo='"+ mailNo +"' ";
            st.executeUpdate(query);

            
            
        }catch(HeadlessException | SQLException E){
            JOptionPane.showMessageDialog(null,E );
        }
    }
    
    // Creates the table of mails just before the frame opens
    public void createTable(int userNo){
        
        int numberOfMails = getNumberOfMails(userNo);
            
            String[] col = {"Sender", "Topic"};
            String[][] data = new String[numberOfMails][2];
            
            for (int i = 0; i < numberOfMails; i++) {
                data[i][0] = getSenders(userNo)[i];
            }
            for (int i = 0; i < numberOfMails; i++) {
                data[i][1] = getTopics(userNo)[i];
            }
            DefaultTableModel tableModel = new DefaultTableModel(data, col){

                @Override
                public boolean isCellEditable(int row, int column) {
                   //all cells false
                   return false;
                }
            };
        mb_table.setModel(tableModel);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        mb_table = new javax.swing.JTable();
        mb_b1 = new javax.swing.JButton();
        tb_b2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setBackground(new java.awt.Color(204, 255, 255));

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(500, 500));
        jPanel1.setPreferredSize(new java.awt.Dimension(500, 500));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mb_table.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        mb_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null}
            },
            new String [] {
                "Sender", "Topic"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        mb_table.setGridColor(new java.awt.Color(51, 51, 51));
        mb_table.setShowGrid(true);
        mb_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mb_tableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(mb_table);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 400, 360));

        mb_b1.setText("Back");
        mb_b1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mb_b1ActionPerformed(evt);
            }
        });
        jPanel1.add(mb_b1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 80, 30));

        tb_b2.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        tb_b2.setText("Delete");
        tb_b2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tb_b2ActionPerformed(evt);
            }
        });
        jPanel1.add(tb_b2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, 110, -1));

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mb_b1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mb_b1ActionPerformed
        // TODO add your handling code here:
        fMenu fmenu = new fMenu(userNo);
        fmenu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_mb_b1ActionPerformed

    private void mb_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mb_tableMouseClicked
        // TODO add your handling code here:
        int row = mb_table.rowAtPoint(evt.getPoint());
        
        String mail = getMail(userNo, row);        
        String topic = getTopics(userNo)[row];
        String sender = getSenders(userNo)[row];
        
        if(toRead){
            fRead fread = new fRead(userNo, mail, topic, sender);
            fread.setVisible(true);
            this.dispose();
        }else{
            int result = JOptionPane.showConfirmDialog(this,"Sure? You want to delete this mail?", "Delete Mail",
               JOptionPane.YES_NO_OPTION,
               JOptionPane.QUESTION_MESSAGE);
            if(result == JOptionPane.YES_OPTION){
               deleteMail(getMailNo(userNo, row));
               createTable(userNo);
            }else if (result == JOptionPane.NO_OPTION){
               
            }else {
               
            }
            
        }

        
    }//GEN-LAST:event_mb_tableMouseClicked

    private void tb_b2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tb_b2ActionPerformed
        // TODO add your handling code here:
        if(toRead){
            tb_b2.setText("Read");
            tb_b2.setBackground(Color.white);
            toRead = !toRead;
        }else{
            tb_b2.setText("Delete");
            tb_b2.setBackground(Color.red);
            toRead = !toRead;
        }
    }//GEN-LAST:event_tb_b2ActionPerformed

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
            java.util.logging.Logger.getLogger(fMailBox.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fMailBox.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fMailBox.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fMailBox.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new fMailBox().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton mb_b1;
    private javax.swing.JTable mb_table;
    private javax.swing.JButton tb_b2;
    // End of variables declaration//GEN-END:variables
}
