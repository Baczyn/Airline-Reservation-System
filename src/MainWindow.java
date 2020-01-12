import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
/**
 * Klasa MainWindow rezprezenruje Główne okno aplikacji
 * @author Mikolaj Baczynski
 */
public class MainWindow extends javax.swing.JFrame {
    /**Metoda ustawia w JListLinia dostępne linie lotnicze */
    public void setLinie(){
        PreparedStatement ps;
        ResultSet rs;
        DefaultListModel<String> model = new DefaultListModel<>();
        String query = "Select nazwa FROM linia;";
        jListLinia.setModel(model);
        model.addElement("Wszystkie");
        
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
    /**Metoda ustawia w jListLoty wszytskie dostępne loty */
    public void show_loty(){
        PreparedStatement ps;
        ResultSet rs;
        String query="select id_lot from lot ;";
        DefaultListModel<String> model1 = new DefaultListModel<>();
        jListLoty.setModel(model1);
        try {
            ps=ConnectionDB.getConnect().prepareStatement(query);
            rs =ps.executeQuery();
            while(rs.next()){
                model1.addElement(rs.getString(1));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    /**Metoda zmienia przycisk "zaloguj" na "zalogowano" */
    public void updatebutton_log(){
        buttonMain_log.setText("Zalogowano");

    }
    /**Metoda wyświetla przycisk button_myRezerw po zalogowaniu */
    public void setVisableMyRezerw(){
         button_myRezerw.setVisible(true);
     }
     /**Metoda wyświetla przycisk buttonlogout po zalogowaniu */
    public void setVisableLogout(){
         buttonlogout.setVisible(true);
     }
     /**Metoda wyświetla oanel administratora po zalogowaniu jako admin*/
    public void setAdminpanel(){
      jButton_zarzadzaj.setVisible(true);
      jPanel5.setVisible(true);
      show_loty();
    }

    /**Konstruktor definiuje okno wraz z elementami*/
    public MainWindow() {
        initComponents();
        setLinie();
        setLocationRelativeTo(null);
        setResizable(false);
        button_myRezerw.setVisible(false);
        buttonlogout.setVisible(false);
        jPanel5.setVisible(false);
        jButton_zarzadzaj.setVisible(false);
        flag_login=false;
        current_nick=""; 
        
    }
    

    /**Metoda wywoływana przez konstruktor 
     * 
     *definicja całego panelu
     */
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        buttonlogout = new javax.swing.JLabel();
        buttonMain_reg = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListDo = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListLinia = new javax.swing.JList<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        jListSkad = new javax.swing.JList<>();
        button_szukaj = new javax.swing.JButton();
        buttonMain_log = new javax.swing.JLabel();
        jButton_zarzadzaj = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jButton_allpax = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jListLoty = new javax.swing.JList<>();
        button_myRezerw = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel4.add(new JLabel(new ImageIcon("logosamolotu.jpg")));
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(76, 76, 76));
        jPanel2.setForeground(new java.awt.Color(254, 254, 254));
        jPanel2.setMaximumSize(new java.awt.Dimension(700, 700));
        jPanel2.setMinimumSize(new java.awt.Dimension(700, 700));
        jPanel2.setVerifyInputWhenFocusTarget(false);
        jPanel2.setLayout(null);

        buttonlogout.setBackground(new java.awt.Color(126, 175, 229));
        buttonlogout.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        buttonlogout.setForeground(new java.awt.Color(126, 175, 229));
        buttonlogout.setText("Wyloguj");
        buttonlogout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonlogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonlogoutMouseClicked(evt);
            }
        });
        jPanel2.add(buttonlogout);
        buttonlogout.setBounds(370, 0, 80, 30);

        buttonMain_reg.setBackground(new java.awt.Color(126, 175, 229));
        buttonMain_reg.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        buttonMain_reg.setForeground(new java.awt.Color(126, 175, 229));
        buttonMain_reg.setText("Rejestracja");
        buttonMain_reg.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonMain_reg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonMain_regMouseClicked(evt);
            }
        });
        jPanel2.add(buttonMain_reg);
        buttonMain_reg.setBounds(590, 0, 98, 30);

        jLabel1.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(126, 175, 229));
        jLabel1.setText("Skąd:");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(30, 60, 43, 26);

        jLabel4.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(126, 175, 229));
        jLabel4.setText("Dokąd:");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(230, 60, 57, 26);

        jLabel5.setFont(new java.awt.Font("Ubuntu", 1, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(126, 175, 229));
        jLabel5.setText("Wyszukaj Lotu:");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(30, 20, 145, 24);

        jLabel6.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(126, 175, 229));
        jLabel6.setText("Linia:");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(30, 150, 42, 21);

        jListDo.setBackground(new java.awt.Color(141, 140, 154));
        jListDo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jScrollPane1.setViewportView(jListDo);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(230, 100, 170, 30);

        jListLinia.setBackground(new java.awt.Color(141, 140, 154));
        jListLinia.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Wszystkie" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jListLinia.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jScrollPane2.setViewportView(jListLinia);

        jPanel2.add(jScrollPane2);
        jScrollPane2.setBounds(30, 180, 110, 30);

        jListSkad.setBackground(new java.awt.Color(141, 140, 154));
        jListSkad.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jListSkad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListSkadMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jListSkad);

        jPanel2.add(jScrollPane4);
        jScrollPane4.setBounds(30, 100, 170, 30);

        button_szukaj.setBackground(new java.awt.Color(126, 175, 229));
        button_szukaj.setText("Szukaj");

        button_szukaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_szukajActionPerformed(evt);
            }
        });
        jPanel2.add(button_szukaj);
        button_szukaj.setBounds(460, 100, 180, 30);

        buttonMain_log.setBackground(new java.awt.Color(126, 175, 229));
        buttonMain_log.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        buttonMain_log.setForeground(new java.awt.Color(126, 175, 229));
        buttonMain_log.setText("Zaloguj sie");
        buttonMain_log.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonMain_log.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonMain_logMouseClicked(evt);
            }
        });
        jPanel2.add(buttonMain_log);
        buttonMain_log.setBounds(470, 0, 150, 30);

        jButton_zarzadzaj.setBackground(new java.awt.Color(126, 175, 229));
        jButton_zarzadzaj.setText("Dodaj Lot");
        jButton_zarzadzaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_zarzadzajActionPerformed(evt);
            }
        });
        jPanel2.add(jButton_zarzadzaj);
        jButton_zarzadzaj.setBounds(460, 260, 180, 30);

        jPanel3.setBackground(new java.awt.Color(77, 77, 77));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 350, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel3);
        jPanel3.setBounds(20, 310, 350, 100);

        jPanel5.setBackground(new java.awt.Color(77, 77, 77));

        jButton_allpax.setBackground(new java.awt.Color(126, 175, 229));
        jButton_allpax.setText("Pokaż pasażerów lotu:");
        jButton_allpax.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_allpaxActionPerformed(evt);
            }
        });

        jListLoty.setBackground(new java.awt.Color(141, 140, 154));
        jListLoty.setSelectedIndex(1);
        jScrollPane3.setViewportView(jListLoty);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jButton_allpax, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(113, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_allpax))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel5);
        jPanel5.setBounds(30, 240, 350, 70);

        button_myRezerw.setBackground(new java.awt.Color(126, 175, 229));
        button_myRezerw.setText("Moje Rezerwacje");

        button_myRezerw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_myRezerwActionPerformed(evt);
            }
        });
        jPanel2.add(button_myRezerw);
        button_myRezerw.setBounds(460, 180, 180, 30);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logosamolotu.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }
    /**Metoda po wciśnięciu przycisku buttonlogout wylogowuje uzytjownika tworzą nowe okno MainWindow */
    private void buttonlogoutMouseClicked(java.awt.event.MouseEvent evt) {
        this.dispose();
        MainWindow main = new MainWindow();
        main.setVisible(true);
        main.pack();
        jPanel5.setVisible(false);
        jButton_zarzadzaj.setVisible(false);           
    }
    /**Metoda po wciśnięciu przycisku buttonMain_reg otwiera nowe okno do rejestracji */
    private void buttonMain_regMouseClicked(java.awt.event.MouseEvent evt) {
        Register reg = new Register();
        reg.setVisible(true);
        reg.pack();
    }
    /**Metoda po wciśnięciu przycisku button_myRezerw otwiera nowe okno MyResecation i wyświetla wszytskie rezerwacje*/
    private void button_myRezerwActionPerformed(java.awt.event.ActionEvent evt) {
        MyReservation res = new MyReservation();
        res.setVisible(true);
        res.pack();

        PreparedStatement ps;
        ResultSet rs;
        String query = "SELECT * FROM mojerezerw WHERE nick=?;";
        //zmienna arr przechowuje wszytskie zwrócone przez zapytanie query rekordy
        ArrayList<String> arr = new ArrayList<String>();
        
        try {
            ps=ConnectionDB.getConnect().prepareStatement(query);
            ps.setString(1, current_nick);
            rs = ps.executeQuery();
            
            while(rs.next()){
                 arr.add(rs.getString(1));
                 arr.add(rs.getString(2));
                 arr.add(rs.getString(3));
                 arr.add(rs.getString(4));
                 arr.add(rs.getString(5));
                 arr.add(rs.getString(6));
                 arr.add(rs.getString(7));
                 arr.add(rs.getString(8));
                 arr.add(rs.getString(9));
                 arr.add(rs.getString(10));
             }
             
         }catch (SQLException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
         }
         res.setTable(arr);   
    }

    boolean flagskad=true;
    /**Metoda po kliknięciu w pole jListSkąd uaktualnia dostpene lotniska wylotu i docelowe*/
    private void jListSkadMouseClicked(java.awt.event.MouseEvent evt) {
        
        if(flagskad==true){
        PreparedStatement ps;
        ResultSet rs;
        String query = "Select Distinct miasto_z, miasto_do FROM szukaj;";
        //tablica trzymajaca wszystkie lotniska skąd coś wylatuje
        ArrayList<String> arrSkad = new ArrayList<String>();
        //tablica trzymajaca wszystkie lotniska dokąd coś leci
        ArrayList<String> arrDo = new ArrayList<String>();
        try {
            ps=ConnectionDB.getConnect().prepareStatement(query);           
            rs = ps.executeQuery();
            while(rs.next()){
               arrSkad.add(rs.getString(1));
               arrDo.add(rs.getString(2));
            }
            DefaultListModel<String> model1 = new DefaultListModel<>();
            jListSkad.setModel(model1);
            DefaultListModel<String> model2 = new DefaultListModel<>();
            jListDo.setModel(model2);
            for(int i=0;i<arrSkad.size();i++)
                model1.addElement(arrSkad.get(i));
            for(int i=0;i<arrDo.size();i++)
                model2.addElement(arrDo.get(i));
        
        }catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        flagskad=false;
        }
    }

    /**Metoda po wciśnięciu button_szukaj wyszukuje loty o zadanych parametrach */
    private void button_szukajActionPerformed(java.awt.event.ActionEvent evt) {
        //pobranie parametrów wybranych przez użytkownika
        String skad = jListSkad.getSelectedValue();
        String cel = jListDo.getSelectedValue();
        String linia = jListLinia.getSelectedValue();
  
        if(linia==null || skad==null||cel==null){
           JOptionPane.showMessageDialog(null, "Wybierz wszystkie pola");
        }
        else{
            Search search = new Search();
            search.setVisible(true);
            search.pack();
            search.setLocationRelativeTo(null);
            String query;
            boolean flag=false;
            if(linia.equals("Wszystkie"))
                query="select Distinct * from szukaj WHERE miasto_z=? AND miasto_do=?;";
            else{
                query="select Distinct * from szukaj WHERE miasto_z=? AND miasto_do=? AND linia=?;";
                flag=true;
            }
        //tablica trzymająca informacje o dostepnych lotach
        ArrayList<String> loty = new ArrayList<String>();
        ArrayList<Integer> cena = new ArrayList<Integer>();
        ArrayList<LocalDate> daty = new ArrayList<LocalDate>();
        LocalDate datateraz = LocalDate.now();

        PreparedStatement ps;
        ResultSet rs=null;
        try {
            ps=ConnectionDB.getConnect().prepareStatement(query); 
            ps.setString(1,skad);
            ps.setString(2, cel);
            if(flag) ps.setString(3, linia);
            
            rs = ps.executeQuery();
            //Sklejanie Stringa(posiadającego info o lotach)
            while(rs.next()){
                loty.add(rs.getInt(8)+" | " +rs.getString(1)+ " | "+rs.getString(2)+ " | "+rs.getString(3)+ " | "
                +rs.getString(4)+ " | "+rs.getString(5)+ " | "+rs.getString(6)+ " | "+rs.getString(7)+ " | ");
                  
                daty.add(rs.getDate(5).toLocalDate());
                cena.add(rs.getInt(9));
            }
            //ustawienie zniżki - jeżeli do lotu zostało więcej niż 7 dni, naliczany jest rabat 20% 
            for(int i=0;i<loty.size();i++){
                if( (Duration.between(datateraz.atStartOfDay(),daty.get(i).atStartOfDay() )).toDays() >=7  ){
                    Double k= cena.get(i)*0.8;
                    //doklejamy cene do stringa wyświetlanego użytkownikowi
                    loty.set(i,loty.get(i)+k);
                }
                else{
                    int k=cena.get(i);
                    loty.set(i,loty.get(i)+k);
                }
            }
                                   
        } catch (SQLException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
                       
        search.initjListLoty(loty);
        
    }
                
    }
    /**Metoda po wciśnięciu buttonMain_log  otwiera okno do logowania*/
    private void buttonMain_logMouseClicked(java.awt.event.MouseEvent evt) {
        Login log = new Login();
        log.setVisible(true);
        log.pack();
        this.dispose();
    }
    /**Metoda po wciśnięciu jButton_zarzadak  otwiera okno do zarządzania lotami*/
    private void jButton_zarzadzajActionPerformed(java.awt.event.ActionEvent evt) {
        InsertNewLot lot = new InsertNewLot();
        lot.setVisible(true);
        lot.pack();
        lot.setLocationRelativeTo(null); 
        lot.getNewWin(this);
    }
    /**Metoda po wciśnięciu jButton_allpx wyświetla wszystkich pasażerów danego lotu*/  
    private void jButton_allpaxActionPerformed(java.awt.event.ActionEvent evt) {
        String lot = jListLoty.getSelectedValue();
        if(lot!=null){
            Manage manage = new Manage();
            manage.setVisible(true);
            manage.pack();

            PreparedStatement ps;
            ResultSet rs;
            String query = "SELECT * FROM mojerezerwv2 WHERE id_lot=?;";
            ArrayList<String> arr = new ArrayList<String>();

            try {
                ps=ConnectionDB.getConnect().prepareStatement(query);
                ps.setInt(1, Integer.parseInt(lot));
                rs = ps.executeQuery();

                while(rs.next()){
                    arr.add(rs.getString(1));
                    arr.add(rs.getString(2));
                    arr.add(rs.getString(3));
                    arr.add(rs.getString(4));
                    arr.add(rs.getString(5));
                    arr.add(rs.getString(6));
                    arr.add(rs.getString(7));
                    arr.add(rs.getString(8));
                    arr.add(rs.getString(9));
                    arr.add(rs.getString(10));
                    arr.add(rs.getString(11));
                    arr.add(rs.getString(12));
                    arr.add(rs.getString(13));
                    arr.add(rs.getString(14));

                }

            } catch (SQLException ex) {
                Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
            //przekazanie danych z tablicy do okna Manage, by można nimi było wypełnić tabele
            manage.setTable(arr);
        }
        else{
            JOptionPane.showMessageDialog(null, "Wybierz lot");
        }

       
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
          
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                new MainWindow().setVisible(true);
            }
        });
        
    }

    //początek deklaracji zmiennych
    /**zmienna trzymająca informacje, czy w aplikacji jest ktoś zalogowany  */
    static boolean flag_login=false;
    /**zmienna trzymająca nick, osobyzalogowanej  */
    static String current_nick=""; 
    private javax.swing.JLabel buttonMain_log;
    private javax.swing.JLabel buttonMain_reg;
    private javax.swing.JButton button_myRezerw;
    private javax.swing.JButton button_szukaj;
    private javax.swing.JLabel buttonlogout;
    private javax.swing.JButton jButton_allpax;
    private javax.swing.JButton jButton_zarzadzaj;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JList<String> jListDo;
    private javax.swing.JList<String> jListLinia;
    private javax.swing.JList<String> jListLoty;
    private javax.swing.JList<String> jListSkad;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    // koniec deklaracji zmiennych
}
