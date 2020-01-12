
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
/**
 * Klasa NewLinia rezprezenruje okno do dodania nowej Lini
 * @author Mikolaj Baczynski
 */

public class NewLinia extends javax.swing.JFrame {
    /**Metoda wywoływana w InsertNewLot, Przekazanie obiektu, by można było zaktualizować dodane Linie w jListLinie
     * @param temp obiket w którym zostanie zaktualizowana jListLinie
    */
    public  void getNewLot(InsertNewLot temp){tempLot=temp;}
    InsertNewLot tempLot;

    /**Konstruktor definiuje okno wraz z elementami*/
    public NewLinia() {
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
        TextLinia = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        TextNr = new javax.swing.JTextField();
        button_submit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(69, 66, 216));
        jPanel1.setPreferredSize(new java.awt.Dimension(0, 66));

        jLabel10.setFont(new java.awt.Font("Ubuntu", 0, 20)); // NOI18N
        jLabel10.setText("Nowa linia");
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

        TextLinia.setBackground(new java.awt.Color(141, 140, 154));

        jLabel8.setFont(new java.awt.Font("Ubuntu", 0, 15)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(126, 175, 229));
        jLabel8.setText("Nazwa lini:");

        jLabel9.setFont(new java.awt.Font("Ubuntu", 0, 15)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(126, 175, 229));
        jLabel9.setText("Podaj ilość miejsc w samolocie:");

        TextNr.setBackground(new java.awt.Color(141, 140, 154));


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
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(29, 29, 29)
                        .addComponent(TextNr, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(button_submit, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel8)
                            .addGap(18, 18, 18)
                            .addComponent(TextLinia, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(92, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(TextLinia, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(TextNr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(button_submit)
                .addGap(35, 35, 35))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
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
    /**Metoda po wciśnięciu button_submit dodaje nowy lot do bazy */
    private void button_submitActionPerformed(java.awt.event.ActionEvent evt) {
        String nazwaLini = TextLinia.getText();
        int ilosc_miejsc = 0;
        
        try{
         ilosc_miejsc= Integer.parseInt( TextNr.getText() );
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Ilosc miejsc ma być liczbą naturalna!");
        }
        int flag=0;
        if(nazwaLini.equals("") || ilosc_miejsc<=0){
            JOptionPane.showMessageDialog(null, "Wybierz wszystkie pola");
        }
        else{
        String query = "select * from dodajLinieSamolot(?,?);";
        
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps=ConnectionDB.getConnect().prepareStatement(query);
            ps.setString(1, nazwaLini);
            ps.setInt(2,ilosc_miejsc);
            rs = ps.executeQuery();
            while(rs.next()){
                flag=rs.getInt(1);
            }
            if(flag==0){
                JOptionPane.showMessageDialog(null, "Nazwa Lini już istnieje");

            }
            else{
                JOptionPane.showMessageDialog(null, "Dodano nową linie!");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(NewLinia.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        tempLot.setLinie();
        this.dispose();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TextLinia;
    private javax.swing.JTextField TextNr;
    private javax.swing.JButton button_submit;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
