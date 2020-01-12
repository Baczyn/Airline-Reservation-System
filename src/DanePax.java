
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Duration;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Klasa DanePax rezprezenruje okno do wprowadzania danych osobowych pasażera
 * @author Mikolaj Baczynski
 */

public class DanePax extends javax.swing.JFrame {
    /**Konstruktor definiuje okno wraz z elementami*/
    public DanePax() {
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

        jPasswordField1 = new javax.swing.JPasswordField();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        TextImie = new javax.swing.JTextField();
        TextMiasto = new javax.swing.JTextField();
        TextKraj = new javax.swing.JTextField();
        TextNazwisko = new javax.swing.JTextField();
        TextUlica = new javax.swing.JTextField();
        TextDom = new javax.swing.JTextField();
        button_submit = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListPlec = new javax.swing.JList<>();

        jPasswordField1.setText("jPasswordField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(69, 66, 216));
        jPanel1.setPreferredSize(new java.awt.Dimension(376, 66));

        jLabel9.setFont(new java.awt.Font("Ubuntu", 0, 20)); // NOI18N
        jLabel9.setText("Dane osobowe");
        jLabel9.setToolTipText("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(117, 117, 117))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(20, 20, 20))
        );

        jPanel2.setBackground(new java.awt.Color(76, 76, 76));

        jLabel1.setFont(new java.awt.Font("Ubuntu", 0, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(126, 175, 229));
        jLabel1.setText("Imię");

        jLabel2.setFont(new java.awt.Font("Ubuntu", 0, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(126, 175, 229));
        jLabel2.setText("Nazwisko");

        jLabel3.setFont(new java.awt.Font("Ubuntu", 0, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(126, 175, 229));
        jLabel3.setText("Miasto");

        jLabel4.setFont(new java.awt.Font("Ubuntu", 0, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(126, 175, 229));
        jLabel4.setText("Kraj");

        jLabel5.setFont(new java.awt.Font("Ubuntu", 0, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(126, 175, 229));
        jLabel5.setText("nr. domu");

        jLabel7.setFont(new java.awt.Font("Ubuntu", 0, 15)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(126, 175, 229));
        jLabel7.setText("Ulica");

        jLabel8.setFont(new java.awt.Font("Ubuntu", 0, 15)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(126, 175, 229));
        jLabel8.setText("Płeć");

        TextImie.setBackground(new java.awt.Color(141, 140, 154));
        TextMiasto.setBackground(new java.awt.Color(141, 140, 154));
        TextKraj.setBackground(new java.awt.Color(141, 140, 154));
        TextNazwisko.setBackground(new java.awt.Color(141, 140, 154));
        TextUlica.setBackground(new java.awt.Color(141, 140, 154));
        TextDom.setBackground(new java.awt.Color(141, 140, 154));

        button_submit.setBackground(new java.awt.Color(126, 175, 229));
        button_submit.setText("Potwierdz i Zapłać");

        button_submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_submitActionPerformed(evt);
            }
        });

        jListPlec.setBackground(new java.awt.Color(141, 140, 154));
        jListPlec.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Kobieta", "Mężczyzna" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jListPlec.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jScrollPane2.setViewportView(jListPlec);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel7)
                    .addComponent(jLabel5)
                    .addComponent(jLabel8))
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(button_submit, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                    .addComponent(TextImie)
                    .addComponent(TextKraj)
                    .addComponent(TextNazwisko)
                    .addComponent(TextUlica)
                    .addComponent(TextDom)
                    .addComponent(TextMiasto)
                    .addComponent(jScrollPane2))
                .addContainerGap(112, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(TextImie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TextNazwisko, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TextDom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(TextKraj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TextMiasto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TextUlica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(button_submit)
                .addGap(51, 51, 51))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }
    /**Metoda po wciśnięciu button_subbimt wstawia dane pasażera do bazy */
    private void button_submitActionPerformed(java.awt.event.ActionEvent evt) {
        String imie = TextImie.getText();
        String nazwisko = TextNazwisko.getText();
        String kraj = TextKraj.getText();
        String miasto = TextMiasto.getText();
        String ulica = TextUlica.getText();
        int dom=0;
        try{
         dom= Integer.parseInt( TextDom.getText() );
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Numer domu ma być liczbą naturalna!");
        }
        String sex = jListPlec.getSelectedValue();
     
        if(imie.equals("") || nazwisko.equals("") || kraj.equals("") || miasto.equals("") || ulica.equals("") ||  dom <=0 ||sex.equals("")){
            JOptionPane.showMessageDialog(null, "Wybierz wszystkie pola");
        }
        else{
        //ustawienie id_pasazera
         PreparedStatement ps1;
         ResultSet rs1=null;
         String query1="select COUNT(*) FROM pasazer;";
         int id_pax=0;
         
         PreparedStatement ps2;
         String query2="Insert INTO pasazer(id_pasazer,nick) values (?,?);";

         //wstawienie danych do tabli rezerwacja
         PreparedStatement ps3;
         ResultSet rs3=null;
         String query3="select COUNT(*) FROM rezerwacja;";
         int id_rezer=0;


         PreparedStatement ps4;
         String query4="Insert INTO rezerwacja(id_rezerwacja,id_lot,id_pasazer,data_rezerw,znizka) values (?,?,?,?,0);";

        try {
            ps1=ConnectionDB.getConnect().prepareStatement(query1);//pobranie ilosci pasazerow
            ps3 = ConnectionDB.getConnect().prepareStatement(query3);//pobranie ilosci rezerwacji
            rs1 = ps1.executeQuery();
            rs3 = ps3.executeQuery();
            while(rs1.next() && rs3.next()){
                id_pax = rs1.getInt(1) +1; //id_pasazer dla nowego pasazera
                id_rezer = rs3.getInt(1) +1;//id_rezerwacjia dla nowej rezerwacji          
            }
            
            ps2 = ConnectionDB.getConnect().prepareStatement(query2);//wstawienie pasazera i jego nicku(lub braku) do encji pasazer
            ps2.setInt(1,id_pax);
            if(MainWindow.current_nick.equals("")){
                ps2.setString(2,null);}
            else{
                ps2.setString(2,MainWindow.current_nick);
            }
            ps2.executeUpdate();
            
            
            ps4 = ConnectionDB.getConnect().prepareStatement(query4);//wstawienie danych do encji tabeli rezerwacja
            ps4.setInt(1,id_rezer);
            ps4.setInt(2,Search.id_lot);
            ps4.setInt(3,id_pax);
            
            Calendar calendar = Calendar.getInstance();
            java.sql.Date date = new java.sql.Date(calendar.getTime().getTime());
            
            ps4.setDate(4, date);
            
            ps4.executeUpdate();
            
            LocalDate datateraz = LocalDate.now();
            LocalDate datalotu= LocalDate.now();
            //pobranie ceny i daty lotu
            PreparedStatement psGetcena = ConnectionDB.getConnect().prepareStatement("select cena,data_lotu from lot where id_lot=?;");
            psGetcena.setInt(1,Search.id_lot);
            ResultSet rscena = psGetcena.executeQuery();
            while(rscena.next()){
                datalotu= rscena.getDate(2).toLocalDate();
            }
            
            //aktualizacja rezerwacji by okreslic znizke
            PreparedStatement ps;
            ps = ConnectionDB.getConnect().prepareStatement("UPDATE rezerwacja SET znizka = ? where id_rezerwacja=?");
            ps.setInt(2,id_rezer);
            if( (Duration.between(datateraz.atStartOfDay(),datalotu.atStartOfDay() )).toDays() >=7  ){
                ps.setInt(1,20);
                ps.executeUpdate();       
            }
            else{
                ps.setInt(1,0);
                ps.executeUpdate(); 
            }
           

           
        }
          catch (SQLException ex) {
            Logger.getLogger(DanePax.class.getName()).log(Level.SEVERE, null, ex);
        }
            //wstawienie danych do tablict pasazer_dane
            System.out.println("1");
            PreparedStatement ps;
            String query="INSERT INTO pasazer_dane(id_pasazer,imie,nazwisko ,kraj,miasto,ulica,nr_domu ,plec ) values (?,?,?,?,?,?,?,?)";
            try{
                ps=ConnectionDB.getConnect().prepareStatement(query);
                System.out.println("2");
                ps.setInt(1,id_pax);
                ps.setString(2, imie);
                ps.setString(3, nazwisko);
                ps.setString(4, kraj);
                ps.setString(5, miasto);
                ps.setString(6, ulica);
                ps.setInt(7, dom); 
                ps.setString(8, sex);
                System.out.println("3");
                if(ps.executeUpdate()>0){
                    JOptionPane.showMessageDialog(null, "Dane poprawnie dodane");
                    this.dispose();
                    System.out.println("4a");
                    
                }
                else{
                    JOptionPane.showMessageDialog(null, "Wprowadz poprawne dane");
                    System.out.println("4b");
                }
            }
            catch(SQLException e){
                Logger.getLogger(DanePax.class.getName()).log(Level.SEVERE, null, e);

            }
        
        }

    }
    // początek deklaracji zmiennych
    private javax.swing.JTextField TextDom;
    private javax.swing.JTextField TextImie;
    private javax.swing.JTextField TextKraj;
    private javax.swing.JTextField TextMiasto;
    private javax.swing.JTextField TextNazwisko;
    private javax.swing.JTextField TextUlica;
    private javax.swing.JButton button_submit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jListPlec;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JScrollPane jScrollPane2;
    //koniec  deklaracji zmiennych
}
