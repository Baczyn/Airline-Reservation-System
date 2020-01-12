import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Klasa Login rezprezenruje okno do logowania, oraz obsługuje formluarz loginu
 * @author Mikolaj Baczynski
 */

public class Login extends javax.swing.JFrame {
/**Konstruktor definiuje okno wraz z elementami*/
    public Login() {
        initComponents();
        /**ustawienie okna na srodku ekranu */
        this.setLocationRelativeTo(null);
        /**zamknięcie powoduje, zamknięcie tylko tego okna nie calego programu */
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        /**brak mozliwosci zmiany rozmiaru okna */
        setResizable(false);
    }
    /**Metoda wywoływana przez konstruktor 
     * 
     *definicja całego panelu
     */
    private void initComponents() {

        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPasswordRPass = new javax.swing.JPasswordField();
        jButton_LOGIN = new javax.swing.JButton();
        TextRNick = new javax.swing.JTextField();
        button_create = new javax.swing.JButton();

        jFormattedTextField1.setText("jFormattedTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(69, 66, 216));
        jPanel3.setForeground(new java.awt.Color(91, 90, 117));
        jPanel3.setToolTipText("");
        jPanel3.setPreferredSize(new java.awt.Dimension(376, 66));

        jLabel1.setFont(new java.awt.Font("Ubuntu", 0, 20)); // NOI18N
        jLabel1.setText("Panel Logowania");
        jLabel1.setToolTipText("");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(126, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(76, 76, 76));
        jPanel2.setForeground(new java.awt.Color(69, 66, 216));
        jPanel2.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(126, 175, 229));
        jLabel2.setText("Nick:");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(50, 40, 60, 40);

        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(126, 175, 229));
        jLabel3.setText("Hasło:");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(50, 100, 70, 30);

        jPasswordRPass.setBackground(new java.awt.Color(141, 140, 154));
        jPasswordRPass.setForeground(new java.awt.Color(1, 1, 1));
        jPasswordRPass.setText("jPasswor");

        jPanel2.add(jPasswordRPass);
        jPasswordRPass.setBounds(120, 100, 170, 30);

        jButton_LOGIN.setBackground(new java.awt.Color(126, 175, 229));
        jButton_LOGIN.setText("Zaloguj");
        jButton_LOGIN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_LOGINActionPerformed(evt);
            }
        });
        jPanel2.add(jButton_LOGIN);
        jButton_LOGIN.setBounds(120, 140, 170, 30);

        TextRNick.setBackground(new java.awt.Color(141, 140, 154));
        jPanel2.add(TextRNick);
        TextRNick.setBounds(120, 50, 170, 30);

        button_create.setBackground(new java.awt.Color(126, 175, 229));
        button_create.setText("Załóż nowe konto");
        button_create.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button_createMouseClicked(evt);
            }
        });

        jPanel2.add(button_create);
        button_create.setBounds(120, 180, 170, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }
/**Metoda po wciśnięciu przycisku  button_creare tworzy nowy obiekt do rejestracji*/
    private void button_createMouseClicked(java.awt.event.MouseEvent evt) {
        Register reg = new Register();
        reg.setVisible(true);
        reg.pack();
        this.dispose();
        
    }
/**Metoda po wciśnięciu przycisku jButton_LOGIN sprawdza, czy użytkownik jest w bazie
 * tworzy nowe Główne okno, lub wyświetla komunikat o błędzie logowania
 */
    private void jButton_LOGINActionPerformed(java.awt.event.ActionEvent evt) {
        PreparedStatement ps;
        ResultSet rs;
        String form_nick = TextRNick.getText();
        String form_haslo = String.valueOf(jPasswordRPass.getPassword());
        String typ="";
        String query="SELECT * FROM uzytkownik where nick=? AND haslo=?";
        
        try {
            ps=ConnectionDB.getConnect().prepareStatement(query);
            
            ps.setString(1,form_nick);
            ps.setString(2, form_haslo);
            
            rs = ps.executeQuery();
            
            if(rs.next()){
                typ = rs.getString(4);
                JOptionPane.showMessageDialog(null, "Zalogowano");
                this.dispose();
                MainWindow main = new MainWindow();
                
                
                main.pack();
                main.updatebutton_log();
                main.setVisableMyRezerw();
                main.setVisableLogout();
                main.setVisible(true);
                MainWindow.current_nick=form_nick;
                MainWindow.flag_login=true;
                if(typ.equals("admin")){
                    main.setAdminpanel();}
            }
            else{
                JOptionPane.showMessageDialog(null, "Błedne dane");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
   /**początek deklaracji zmiennych */
    private javax.swing.JTextField TextRNick;
    private javax.swing.JButton button_create;
    private javax.swing.JButton jButton_LOGIN;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPasswordField jPasswordRPass;
   /**koniec deklaracji zmiennych */

    
}
