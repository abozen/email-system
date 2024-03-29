
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author abozen
 */
public class fLogin extends javax.swing.JFrame {

    /**
     * Creates new form fLogin
     */
    static int userNo = 0;

    static boolean savedShow = false;
    static boolean isChecked1 = false;
    static boolean isChecked2 = false;

    public fLogin() {
        initComponents();

        login_list.setVisible(false);
    }

    //checks if the mail is registered before
    public boolean isUnique(String mail) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "369874125");
            Statement st = con.createStatement();

            int logUser = 0;

            String query = "SELECT * FROM asd.users WHERE email='" + mail + "' ";

            ResultSet rs = st.executeQuery(query);

            if (rs.next()) {
                return false;
            } else {
                return true;
            }

        } catch (HeadlessException | SQLException E) {
            JOptionPane.showMessageDialog(null, E);
        }
        return false;
    }

    public void clearAll() {
        register_txt1.setText("");
        register_txt2.setText("");
        register_txt3.setText("");
        register_psw.setText("");
        register_rb1.setSelected(false);
        register_rb2.setSelected(false);
        register_cb.setSelectedIndex(0);
        login_txt1.setText("");
        login_psw.setText("");
        lb1.setText("");
        lb2.setText("");
        lb3.setText("");
        lb4.setText("");
        lb5.setText("");
        lb6.setText("");

    }

    public void clearLabels() {
        lb1.setText("");
        lb2.setText("");
        lb3.setText("");
        lb4.setText("");
        lb5.setText("");
        lb6.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        login_txt1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        login_psw = new javax.swing.JPasswordField();
        jCheckBox1 = new javax.swing.JCheckBox();
        login_b1 = new javax.swing.JButton();
        login_b2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        login_list = new javax.swing.JList<>();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        register_txt1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        register_txt2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        register_txt3 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        register_rb1 = new javax.swing.JRadioButton();
        register_rb2 = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        register_cb = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        register_b1 = new javax.swing.JButton();
        register_psw = new javax.swing.JPasswordField();
        jCheckBox2 = new javax.swing.JCheckBox();
        lb1 = new javax.swing.JLabel();
        lb2 = new javax.swing.JLabel();
        lb3 = new javax.swing.JLabel();
        lb4 = new javax.swing.JLabel();
        lb5 = new javax.swing.JLabel();
        lb6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(500, 500));
        jPanel1.setPreferredSize(new java.awt.Dimension(500, 500));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(login_txt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, 160, 30));

        jLabel1.setText("E-Mail");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 60, 30));

        jLabel2.setText("Password");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 60, 30));
        jPanel1.add(login_psw, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 160, 30));

        jCheckBox1.setText("Show");
        jCheckBox1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jCheckBox1StateChanged(evt);
            }
        });
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        jPanel1.add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 100, -1, -1));

        login_b1.setText("Login");
        login_b1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                login_b1ActionPerformed(evt);
            }
        });
        jPanel1.add(login_b1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, 160, 30));

        login_b2.setText("Show Saved E-mails");
        login_b2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                login_b2ActionPerformed(evt);
            }
        });
        jPanel1.add(login_b2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 200, 160, 30));

        login_list.setBackground(new java.awt.Color(204, 255, 255));
        login_list.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "asd" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(login_list);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 250, 160, 120));

        jTabbedPane1.addTab("Log in", jPanel1);

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setText("Name");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 60, 30));
        jPanel3.add(register_txt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 160, 30));

        jLabel4.setText("Age");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 60, 30));
        jPanel3.add(register_txt2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 160, 30));

        jLabel5.setText("E-Mail");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 60, 30));
        jPanel3.add(register_txt3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 240, 160, 30));

        jLabel6.setText("Surname");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 60, 30));

        register_rb1.setText("Male");
        jPanel3.add(register_rb1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, -1, -1));

        register_rb2.setText("Female");
        jPanel3.add(register_rb2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, -1, -1));

        jLabel7.setText("Gender");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 60, 30));

        register_cb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60" }));
        register_cb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                register_cbActionPerformed(evt);
            }
        });
        jPanel3.add(register_cb, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, 80, 30));

        jLabel8.setText("Password");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 60, 30));

        register_b1.setText("Register");
        register_b1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                register_b1ActionPerformed(evt);
            }
        });
        jPanel3.add(register_b1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 340, 160, 30));
        jPanel3.add(register_psw, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 290, 160, 30));

        jCheckBox2.setText("Show");
        jCheckBox2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jCheckBox2StateChanged(evt);
            }
        });
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });
        jPanel3.add(jCheckBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, -1, -1));

        lb1.setFont(new java.awt.Font("Helvetica Neue", 1, 12)); // NOI18N
        lb1.setForeground(new java.awt.Color(255, 51, 51));
        jPanel3.add(lb1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 40, 190, 30));

        lb2.setFont(new java.awt.Font("Helvetica Neue", 1, 12)); // NOI18N
        lb2.setForeground(new java.awt.Color(255, 51, 51));
        jPanel3.add(lb2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 90, 160, 30));

        lb3.setFont(new java.awt.Font("Helvetica Neue", 1, 12)); // NOI18N
        lb3.setForeground(new java.awt.Color(255, 51, 51));
        jPanel3.add(lb3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 140, 180, 30));

        lb4.setFont(new java.awt.Font("Helvetica Neue", 1, 12)); // NOI18N
        lb4.setForeground(new java.awt.Color(255, 51, 51));
        jPanel3.add(lb4, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 190, 180, 30));

        lb5.setFont(new java.awt.Font("Helvetica Neue", 1, 12)); // NOI18N
        lb5.setForeground(new java.awt.Color(255, 51, 51));
        jPanel3.add(lb5, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 240, 200, 30));

        lb6.setFont(new java.awt.Font("Helvetica Neue", 1, 12)); // NOI18N
        lb6.setForeground(new java.awt.Color(255, 51, 51));
        jPanel3.add(lb6, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 290, 200, 30));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 500));

        jTabbedPane1.addTab("Register", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCheckBox1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jCheckBox1StateChanged
        // TODO add your handling code here:

    }//GEN-LAST:event_jCheckBox1StateChanged

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
        isChecked1 = !isChecked1;
        if (isChecked1)
            login_psw.setEchoChar((char) 0);
        else
            login_psw.setEchoChar('*');
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void login_b1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_login_b1ActionPerformed

        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "369874125");
            Statement st = con.createStatement();
            //Statement st2 = con.createStatement();

            int logUser = 0;

            String query = "SELECT * FROM asd.users WHERE email='" + login_txt1.getText() + "' AND pass = '" + login_psw.getText() + "' ";
            String query2 = "SELECT userNo FROM asd.users WHERE email='" + login_txt1.getText() + "' ";

            ResultSet rs2 = st.executeQuery(query2);

            while (rs2.next()) {
                logUser = rs2.getInt(1);
            }
            ResultSet rs = st.executeQuery(query);
            if (rs.next()) {
                fMenu fmenu = new fMenu(logUser);
                fmenu.setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Mail or Password is wrong");
            }

        } catch (HeadlessException | SQLException E) {
            JOptionPane.showMessageDialog(null, E);
        }


    }//GEN-LAST:event_login_b1ActionPerformed

    private void login_b2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_login_b2ActionPerformed
        // TODO add your handling code here:
        savedShow = !savedShow;

        login_list.setVisible(savedShow);
        if (savedShow)
            login_b2.setText("Hide Saved E-mails");
        else
            login_b2.setText("Show Saved E-mails");
    }//GEN-LAST:event_login_b2ActionPerformed

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        // TODO add your handling code here:
        isChecked2 = !isChecked2;
        if (isChecked2)
            register_psw.setEchoChar((char) 0);
        else
            register_psw.setEchoChar('*');
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void jCheckBox2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jCheckBox2StateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox2StateChanged

    private void register_cbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_register_cbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_register_cbActionPerformed

    private void register_b1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_register_b1ActionPerformed
        // TODO add your handling code here:

        //counter for checking if every regex is confirmed
        int isFive = 0;

        if (!isUnique(register_txt3.getText())) {
            JOptionPane.showMessageDialog(null, "This mail is registered before");
            isFive--;

        }

        //regex for name
        if (register_txt1.getText().isEmpty()) {
            lb1.setText("Name can't be empty");
        } else {
            Matcher matcher;
            matcher = Pattern.compile("^[a-zA-Z]{2,30}$").matcher(register_txt1.getText());
            if (!matcher.find()) {
                lb1.setText("Incorrect name type");
            } else {
                lb1.setText("");
                isFive++;
            }
        }

        //regex for surname
        if (register_txt2.getText().isEmpty()) {
            lb2.setText("Surname can't be empty");
        } else {
            Matcher matcher;
            matcher = Pattern.compile("^[a-zA-Z]{2,30}$").matcher(register_txt2.getText());
            if (!matcher.find()) {
                lb2.setText("Incorrect surname type");
            } else {
                lb2.setText("");
                isFive++;
            }
        }

        //checking if gender not choosen
        if (!register_rb1.isSelected() && !register_rb2.isSelected()) {
            lb3.setText("Gender must be choosen");
        } else {
            isFive++;
        }

        //regex for email
        if (register_txt3.getText().isEmpty()) {
            lb5.setText("E-mail can't be empty");
        } else {
            Matcher matcher;
            matcher = Pattern.compile("^[a-z0-9.!#$%&'*+/=?^_`{|}~-]{2,20}+@[a-z0-9-]{2,7}+(?:\\.[a-z0-9-]{1,4}+)*$").matcher(register_txt3.getText());
            if (!matcher.find()) {
                lb5.setText("Incorrect E-mail type");
            } else {
                lb5.setText("");
                isFive++;
            }
        }

        if (register_psw.getText().isEmpty()) {
            lb6.setText("Password can't be empty");
        } else {
            Matcher matcher;
            matcher = Pattern.compile("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]{6,20}$").matcher(register_psw.getText());
            if (!matcher.find()) {
                lb6.setText("Incorrect password type");
            } else {
                lb6.setText("");
                isFive++;
            }
        }

        String gender = register_rb1.isSelected() ? "Male" : "Female";

        if (isFive == 5)
        try {

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "369874125");
            Statement st = con.createStatement();

            String query2 = "SELECT MAX(userNo) FROM asd.users";
            ResultSet rs = st.executeQuery(query2);
            while (rs.next()) {
                userNo = rs.getInt(1) + 1;
            }

            String query = "INSERT INTO asd.users (userNo, email, pass, name, surname, gender, age)"
                    + " VALUES('" + userNo + "' ,"
                    + " '" + register_txt3.getText() + "' ,"
                    + " '" + register_psw.getText() + "' ,"
                    + " '" + register_txt1.getText() + "' ,"
                    + " '" + register_txt2.getText() + "' ,"
                    + " '" + gender + "' ,"
                    + " '" + register_cb.getSelectedItem() + "' "
                    + " )";

            st.execute(query);

            JOptionPane.showMessageDialog(null, "Successfully registered.");
            clearAll();
            jTabbedPane1.setSelectedIndex(0);

        } catch (HeadlessException | SQLException E) {
            JOptionPane.showMessageDialog(null, E);
        }


    }//GEN-LAST:event_register_b1ActionPerformed

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
            java.util.logging.Logger.getLogger(fLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new fLogin().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lb1;
    private javax.swing.JLabel lb2;
    private javax.swing.JLabel lb3;
    private javax.swing.JLabel lb4;
    private javax.swing.JLabel lb5;
    private javax.swing.JLabel lb6;
    private javax.swing.JButton login_b1;
    private javax.swing.JButton login_b2;
    private javax.swing.JList<String> login_list;
    private javax.swing.JPasswordField login_psw;
    private javax.swing.JTextField login_txt1;
    private javax.swing.JButton register_b1;
    private javax.swing.JComboBox<String> register_cb;
    private javax.swing.JPasswordField register_psw;
    private javax.swing.JRadioButton register_rb1;
    private javax.swing.JRadioButton register_rb2;
    private javax.swing.JTextField register_txt1;
    private javax.swing.JTextField register_txt2;
    private javax.swing.JTextField register_txt3;
    // End of variables declaration//GEN-END:variables
}
