
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Klasa Register rezprezenruje okno do rejestracji
 * @author Mikolaj Baczynski
 */
public class Register extends javax.swing.JFrame {
    /**Konstruktor definiuje okno wraz z elementami*/
    public Register() {
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    /**Metoda wywoływana przez konstruktor 
     * 
     *definicja całego panelu
     */
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPasswordRPass = new javax.swing.JPasswordField();
        jTextRMail = new javax.swing.JTextField();
        TextRNick = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jPasswordRPass2 = new javax.swing.JPasswordField();
        button_register = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel4.setBackground(new java.awt.Color(69, 66, 216));
        jPanel4.setForeground(new java.awt.Color(91, 90, 117));

        jPanel2.setBackground(new java.awt.Color(76, 76, 76));
        jPanel2.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(126, 175, 229));
        jLabel2.setText("Nick:");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel2.add(jLabel2);
        jLabel2.setBounds(10, 20, 110, 30);

        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(126, 175, 229));
        jLabel3.setText("e-mail:");
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel2.add(jLabel3);
        jLabel3.setBounds(10, 170, 100, 30);

        jLabel4.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(126, 175, 229));
        jLabel4.setText("Hasło:");
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel2.add(jLabel4);
        jLabel4.setBounds(10, 70, 110, 30);

        jPasswordRPass.setBackground(new java.awt.Color(141, 140, 154));
        jPasswordRPass.setForeground(new java.awt.Color(1, 1, 1));
        jPasswordRPass.setText("jPasswor");
        jPanel2.add(jPasswordRPass);
        jPasswordRPass.setBounds(150, 70, 170, 30);

        jTextRMail.setBackground(new java.awt.Color(141, 140, 154));
        jPanel2.add(jTextRMail);
        jTextRMail.setBounds(150, 170, 170, 30);

        TextRNick.setBackground(new java.awt.Color(141, 140, 154));
        jPanel2.add(TextRNick);
        TextRNick.setBounds(150, 20, 170, 30);

        jLabel5.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(126, 175, 229));
        jLabel5.setText("Powtórz Hasło:");
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel2.add(jLabel5);
        jLabel5.setBounds(10, 120, 140, 30);

        jPasswordRPass2.setBackground(new java.awt.Color(141, 140, 154));
        jPasswordRPass2.setForeground(new java.awt.Color(1, 1, 1));
        jPasswordRPass2.setText("jPasswor");

        jPanel2.add(jPasswordRPass2);
        jPasswordRPass2.setBounds(150, 120, 170, 30);

        button_register.setBackground(new java.awt.Color(126, 175, 229));
        button_register.setText("Załóż!");

        button_register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_registerActionPerformed(evt);
            }
        });
        jPanel2.add(button_register);
        button_register.setBounds(150, 220, 170, 30);

        jPanel1.setBackground(new java.awt.Color(69, 66, 216));
        jPanel1.setPreferredSize(new java.awt.Dimension(0, 66));

        jLabel9.setFont(new java.awt.Font("Ubuntu", 0, 20)); // NOI18N
        jLabel9.setText("Rejestracja");
        jLabel9.setToolTipText("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(179, Short.MAX_VALUE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel9)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 437, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }
    /**Metoda po wciśnięciu przycisku  button_refister tworzy wstawia nowego użytkownika do tabeli użytkownik*/
    private void button_registerActionPerformed(java.awt.event.ActionEvent evt) {
        String form_nick = TextRNick.getText();
        String form_haslo = String.valueOf(jPasswordRPass.getPassword());
        String form_hasloP = String.valueOf(jPasswordRPass2.getPassword());
        String mail = jTextRMail.getText();
        
        if(form_nick.equals("")){JOptionPane.showMessageDialog(null, "Podaj nick");}
        else if(form_haslo.equals("")){JOptionPane.showMessageDialog(null, "Podaj haslo");}
        else if(!form_haslo.equals(form_hasloP)){JOptionPane.showMessageDialog(null, "Podane hasła są różne");}
        else if(mail.equals("")){JOptionPane.showMessageDialog(null, "Podaj mail");}

        else{
            PreparedStatement ps;
            String query="INSERT INTO uzytkownik(nick,haslo,mail,typ) values (?,?,?,?)";
            try{
                ps=ConnectionDB.getConnect().prepareStatement(query);
            
                ps.setString(1, form_nick);
                ps.setString(2, form_haslo);
                ps.setString(3, mail);
                ps.setString(4, "user");
            
                //sprawdzenie czy użytkownik jest już w bazie
                if(ps.executeUpdate()>0){
                    JOptionPane.showMessageDialog(null, "Użytkownik Dodany");
                }
                else{
                    JOptionPane.showMessageDialog(null, "Użytkownik juz istnieje");
                }
            }
            catch(SQLException e){
            }
        
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TextRNick;
    private javax.swing.JButton button_register;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPasswordField jPasswordRPass;
    private javax.swing.JPasswordField jPasswordRPass2;
    private javax.swing.JTextField jTextRMail;
    // End of variables declaration//GEN-END:variables
}
