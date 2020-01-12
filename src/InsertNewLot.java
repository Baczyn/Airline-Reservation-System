
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Klasa InsertNewLot rezprezenruje okno do dodania nowego lotu
 * @author Mikolaj Baczynski
 */

public class InsertNewLot extends javax.swing.JFrame {
    /**Metoda wywoływana w MainWindow, Przekazanie obiektu, by można było zaktualizować dodane lotniska w jListLotni 
     * @param temp obiket w którym zostanie zaktualizowana jListLotni
    */
    public  void getNewWin(MainWindow temp){
        tempwin=temp;}

    MainWindow tempwin;

    /**Metoda ustawia w JListLinia wszytskie dostępne linie */
    public void setLinie(){
        PreparedStatement ps;
        ResultSet rs;
        String query = "Select nazwa FROM linia;";
        DefaultListModel<String> model = new DefaultListModel<>();
        
        jListLinia.setModel(model);
        
        try {
            ps=ConnectionDB.getConnect().prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
               model.addElement(rs.getString(1));  
            }

        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**Metoda ustawia w JListSamolot wszytskie dostępne samoloty w danej lini */
    public void setSamoloty(){
        PreparedStatement ps;
        ResultSet rs;
        String query = "select id_samolot FROM samolot JOIN linia USING(id_linia)  where nazwa=?;";
        
        DefaultListModel<String> model = new DefaultListModel<>();
        String nazwaLini = jListLinia.getSelectedValue();
        
        jListSamolot.setModel(model);
        try {
            ps=ConnectionDB.getConnect().prepareStatement(query);
            ps.setString(1, nazwaLini);
            rs = ps.executeQuery();
            while(rs.next()){
               model.addElement(rs.getString(1));  
            }

        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**Metoda ustawia w JlistSkad/jListDokad wszytskie dostępne lotniska */
    void setTrasa(){
        PreparedStatement ps;
        ResultSet rs;
        String query = "Select nazwa FROM lotnisko;";

        DefaultListModel<String> model = new DefaultListModel<>(); 
        jListSkad.setModel(model);
        jListDokad.setModel(model);
        
        try {
            ps=ConnectionDB.getConnect().prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
               model.addElement(rs.getString(1));  
            }

        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
/**Konstruktor definiuje oknow wraz z elemnetami */
    public InsertNewLot() {
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLinie();
        setTrasa();
       
    }

    /**Metoda wywoływana przez konstruktor 
     * 
     *definicja całego panelu
     */
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabelAddLinia = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jListLinia = new javax.swing.JList<>();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jListSamolot = new javax.swing.JList<>();
        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jListSkad = new javax.swing.JList<>();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jListDokad = new javax.swing.JList<>();
        jLabelAddLotni = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        TextGodz = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        TextCzas = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        TextCena = new javax.swing.JTextField();
        dateChooser = new datechooser.beans.DateChooserCombo();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        button_submit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(69, 66, 216));

        jLabel8.setFont(new java.awt.Font("Ubuntu", 0, 20)); // NOI18N
        jLabel8.setText("Dodawanie nowego Lotu");
        jLabel8.setToolTipText("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                .addGap(28, 28, 28))
        );

        jPanel2.setBackground(new java.awt.Color(76, 76, 76));

        jLabel6.setFont(new java.awt.Font("Ubuntu", 0, 15)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(126, 175, 229));
        jLabel6.setText("Wybierz Linie:");

        jLabelAddLinia.setFont(new java.awt.Font("Ubuntu", 0, 15)); // NOI18N
        jLabelAddLinia.setForeground(new java.awt.Color(126, 175, 229));
        jLabelAddLinia.setText("Dodaj nową linie");
        jLabelAddLinia.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelAddLinia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelAddLiniaMouseClicked(evt);
            }
        });

        jListLinia.setBackground(new java.awt.Color(141, 140, 154));
        jListLinia.setSelectedIndex(1);

        jListLinia.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jListLiniaValueChanged(evt);
            }
        });
        jScrollPane6.setViewportView(jListLinia);

        jPanel3.setBackground(new java.awt.Color(76, 76, 76));

        jLabel7.setFont(new java.awt.Font("Ubuntu", 0, 15)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(126, 175, 229));
        jLabel7.setText("Wybierz samolot");

        jListSamolot.setBackground(new java.awt.Color(141, 140, 154));
        jListSamolot.setPreferredSize(new java.awt.Dimension(32, 32));
        jListSamolot.setSelectedIndex(1);

        jScrollPane3.setViewportView(jListSamolot);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 207, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(76, 76, 76));

        jLabel9.setFont(new java.awt.Font("Ubuntu", 0, 15)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(126, 175, 229));
        jLabel9.setText("Skąd");

        jListSkad.setBackground(new java.awt.Color(141, 140, 154));
        jListSkad.setSelectedIndex(1);
        jScrollPane7.setViewportView(jListSkad);

        jLabel11.setFont(new java.awt.Font("Ubuntu", 0, 15)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(126, 175, 229));
        jLabel11.setText("Dokąd");

        jListDokad.setBackground(new java.awt.Color(141, 140, 154));
        jListDokad.setSelectedIndex(1);
        jScrollPane5.setViewportView(jListDokad);

        jLabelAddLotni.setFont(new java.awt.Font("Ubuntu", 0, 15)); // NOI18N
        jLabelAddLotni.setForeground(new java.awt.Color(126, 175, 229));
        jLabelAddLotni.setText("Dodaj nowe lotnisko");
        jLabelAddLotni.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelAddLotni.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelAddLotniMouseClicked(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Ubuntu", 0, 15)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(126, 175, 229));
        jLabel12.setText("Data odlotu");

        jLabel13.setFont(new java.awt.Font("Ubuntu", 0, 15)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(126, 175, 229));
        jLabel13.setText("PLN (bez groszy)");

        TextGodz.setBackground(new java.awt.Color(141, 140, 154));
        TextGodz.setText("00:00:00");


        jLabel14.setFont(new java.awt.Font("Ubuntu", 0, 15)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(126, 175, 229));
        jLabel14.setText("Czas trwania");

        TextCzas.setBackground(new java.awt.Color(141, 140, 154));
        TextCzas.setText("0.000");


        jLabel15.setFont(new java.awt.Font("Ubuntu", 0, 15)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(126, 175, 229));
        jLabel15.setText("Cena");

        TextCena.setBackground(new java.awt.Color(141, 140, 154));
        TextCena.setText("100");


        jLabel16.setFont(new java.awt.Font("Ubuntu", 0, 15)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(126, 175, 229));
        jLabel16.setText("Godzina odlotu");

        jLabel18.setFont(new java.awt.Font("Ubuntu", 0, 15)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(126, 175, 229));
        jLabel18.setText("format 0.00");

        jLabel19.setFont(new java.awt.Font("Ubuntu", 0, 15)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(126, 175, 229));
        jLabel19.setText("format 00:00:00");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(47, 47, 47)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jLabelAddLotni)
                .addGap(160, 160, 160))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TextCena, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TextCzas, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TextGodz, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(dateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabelAddLotni, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextGodz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextCzas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextCena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(54, Short.MAX_VALUE))
        );

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
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(37, 37, 37)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61)
                        .addComponent(jLabelAddLinia))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(168, 168, 168)
                .addComponent(button_submit, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelAddLinia, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(button_submit)
                .addContainerGap())
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
    /**Metoda po wciśnieciu jLabelAddLinia otwiera okno NewLinia */
    private void jLabelAddLiniaMouseClicked(java.awt.event.MouseEvent evt) {
        NewLinia linia = new NewLinia();
        linia.setVisible(true);
        linia.pack();
        linia.getNewLot(this);
    }
    /** Metoda aktualizująca dostępne samoloty, gdy wybrano inną linie */ 
    private void jListLiniaValueChanged(javax.swing.event.ListSelectionEvent evt) {
       setSamoloty();
    }
    /**Metoda po wciśnięciu button_submit dodaje nowy lot do bazy */ 
    private void button_submitActionPerformed(java.awt.event.ActionEvent evt) {        String NazwaLini = jListLinia.getSelectedValue();
        
        String Skad = jListSkad.getSelectedValue();
        String Dokad = jListDokad.getSelectedValue();
        Calendar cal = dateChooser.getSelectedDate();
        java.sql.Date sqlData = new java.sql.Date(cal.getTimeInMillis());
        java.sql.Time godz = null;
        float czas = 0;
        int cena = 0;
        int idSamolotu = 0;
        try{
            godz = java.sql.Time.valueOf(TextGodz.getText());
            czas = Float.parseFloat(TextCzas.getText());
            cena = Integer.parseInt(TextCena.getText());
            idSamolotu = Integer.parseInt(jListSamolot.getSelectedValue());
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Sprawdź format wprowadzonych danych");
        }

        if(NazwaLini==null||  Skad==null || Dokad==null|| godz==null){
            JOptionPane.showMessageDialog(null, "Wybierz wszystkie pola ");
        }
        else if(idSamolotu<=0 ||cena<=0|| czas<=0 ){
            JOptionPane.showMessageDialog(null, "Liczby muszą być > 0");
        }
        else{
        
        PreparedStatement ps;
        ResultSet rs;
        String query = "SELECT * FROM dodajLot(?,?,?,?,?,?,?,?);";

        try {
            ps=ConnectionDB.getConnect().prepareStatement(query);
            ps.setString(1, NazwaLini);
            ps.setInt(2, idSamolotu);
            ps.setString(3, Skad);
            ps.setString(4, Dokad);
            ps.setDate(5, sqlData);
            ps.setTime(6, godz);
            ps.setFloat(7, czas);
            ps.setInt(8,cena);

            rs =ps.executeQuery();

        } catch (SQLException ex) {
            Logger.getLogger(InsertNewLot.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(null, "Wprowadzono lot poprawnie");
        tempwin.setLinie();
        tempwin.show_loty();


        this.dispose();
        
        }

    }
    /**Metoda po wciśnieciu jLabelAddLotni otwiera nowe oko NewAiport */
    private void jLabelAddLotniMouseClicked(java.awt.event.MouseEvent evt) {
        NewAirport port = new NewAirport();
        port.setVisible(true);
        port.pack();
        port.getNewPort(this);

    }
   

    // początek deklaracji zmiennych
    private javax.swing.JTextField TextCena;
    private javax.swing.JTextField TextCzas;
    private javax.swing.JTextField TextGodz;
    private javax.swing.JButton button_submit;
    private datechooser.beans.DateChooserCombo dateChooser;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelAddLinia;
    private javax.swing.JLabel jLabelAddLotni;
    private javax.swing.JList<String> jListDokad;
    private javax.swing.JList<String> jListLinia;
    private javax.swing.JList<String> jListSamolot;
    private javax.swing.JList<String> jListSkad;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    //koniec deklaracji zmiennych
}
