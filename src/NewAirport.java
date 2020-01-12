
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
/**
 * Klasa NewAirport rezprezenruje okno do dodania nowego lotniska
 * @author Mikolaj Baczynski
 */

public class NewAirport extends javax.swing.JFrame {
    /**Metoda wywoływana w InsertNewLot, Przekazanie obiektu, by można było zaktualizować dodane lotniska w jListLotni 
     * @param temp obiket w którym zostanie zaktualizowana jListLotni
    */
    public  void getNewPort(InsertNewLot temp){
        tempLot=temp;}

    InsertNewLot tempLot;
    /**Konstruktor definiuje okno wraz z elementami*/
    public NewAirport() {
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

        jPanel1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        TextNazwa = new javax.swing.JTextField();
        TextUlica = new javax.swing.JTextField();
        TextKraj = new javax.swing.JTextField();
        TextMiasto = new javax.swing.JTextField();
        button_submit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(69, 66, 216));

        jLabel10.setFont(new java.awt.Font("Ubuntu", 0, 20)); // NOI18N
        jLabel10.setText("Nowe lotnisko");
        jLabel10.setToolTipText("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel10)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 66, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel10)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanel2.setBackground(new java.awt.Color(76, 76, 76));

        jLabel6.setFont(new java.awt.Font("Ubuntu", 0, 15)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(126, 175, 229));
        jLabel6.setText("Ulica");

        jLabel7.setFont(new java.awt.Font("Ubuntu", 0, 15)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(126, 175, 229));
        jLabel7.setText("Miasto");

        jLabel8.setFont(new java.awt.Font("Ubuntu", 0, 15)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(126, 175, 229));
        jLabel8.setText("Nazwa");

        jLabel9.setFont(new java.awt.Font("Ubuntu", 0, 15)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(126, 175, 229));
        jLabel9.setText("Kraj");

        TextNazwa.setBackground(new java.awt.Color(141, 140, 154));
        TextUlica.setBackground(new java.awt.Color(141, 140, 154));
        TextKraj.setBackground(new java.awt.Color(141, 140, 154));
        TextMiasto.setBackground(new java.awt.Color(141, 140, 154));
        button_submit.setBackground(new java.awt.Color(126, 175, 229));
        button_submit.setText("Potwierdź");
        button_submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_submitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(TextMiasto, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(TextKraj, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(26, 26, 26)
                        .addComponent(TextNazwa, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(button_submit, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TextUlica, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(129, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(TextNazwa, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(TextKraj, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(TextMiasto, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(TextUlica, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(button_submit)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }

    /**Metoda po wciśnięciu button_submit dodaje nowe lotnisko do bazy */
    private void button_submitActionPerformed(java.awt.event.ActionEvent evt) {
        String nazwa = TextNazwa.getText();
        String kraj = TextKraj.getText();
        String miasto = TextMiasto.getText();
        String ulica = TextUlica.getText();
        int ilosc=0;
        
        if(nazwa.equals("") || nazwa.equals("") || nazwa.equals("") || nazwa.equals("")){
            JOptionPane.showMessageDialog(null, "Wybierz wszystkie pola");
        }
        else{
        String query1 = "select Count(*) from lotnisko;";

        PreparedStatement ps1;
        ResultSet rs1;
        
        String query2 = "INSERT INTO lotnisko(id_lotnisko,nazwa,kraj,miasto,ulica) VALUES(?,?,?,?,?);";
        PreparedStatement ps2;
        try {
            ps1=ConnectionDB.getConnect().prepareStatement(query1);
            rs1 = ps1.executeQuery();
            while(rs1.next()){
                ilosc = rs1.getInt(1) +1;
            }
            
            ps2=ConnectionDB.getConnect().prepareStatement(query2);
            ps2.setInt(1,ilosc);
            ps2.setString(2, nazwa);
            ps2.setString(3, kraj);
            ps2.setString(4, miasto);
            ps2.setString(5, ulica);
            
            if(ps2.executeUpdate()>0){
                JOptionPane.showMessageDialog(null, "Dodano Lotnisko");

            }
            else{
                 JOptionPane.showMessageDialog(null, "To lotnisko już jestnieje");
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(NewLinia.class.getName()).log(Level.SEVERE, null, ex);
        }

        tempLot.setTrasa();
        this.dispose();
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TextKraj;
    private javax.swing.JTextField TextMiasto;
    private javax.swing.JTextField TextNazwa;
    private javax.swing.JTextField TextUlica;
    private javax.swing.JButton button_submit;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
