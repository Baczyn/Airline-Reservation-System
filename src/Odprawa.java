
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Duration;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Klasa Odprawa rezprezenruje okno do dodania nowego lotniska
 * @author Mikolaj Baczynski
 */
public class Odprawa extends javax.swing.JFrame {
    //identyfikator rezerwacji która ma byc odprawiona
    String id_rezerw;
    int id_odp=0;
    /**Metoda aktywuje przycisk do losowego wyboru miejsca, gdy do lotu zostało 2 dni */
    void AktywujLosbutton(){
        String query="select data_lotu from lot JOIN rezerwacja r USING(id_lot) where r.id_rezerwacja="+id_rezerw+";";
        PreparedStatement ps;
        ResultSet rs;
        LocalDate datateraz = LocalDate.now();
        LocalDate datalot=LocalDate.now();

        
        try {
            ps=ConnectionDB.getConnect().prepareStatement(query);
            rs = ps.executeQuery();
             while(rs.next()){
                datalot = rs.getDate(1).toLocalDate();
    
            }
             
        } catch (SQLException ex) {
            Logger.getLogger(Odprawa.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        long i =  Duration.between(datateraz.atStartOfDay(),datalot.atStartOfDay() ).toDays();
        if( i < 2 ){
            
             button_los.setEnabled(true);
        }
            
        
    }
    /**Konstruktor definiuje okno wraz z elementami
     * 
     * @param id_rezewacja identyfikator rezerwacji która ma byc odprawiona
    */
    public Odprawa(String id_rezerwacja) {
        id_rezerw=id_rezerwacja;
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jListMiejsca.setVisible(false);
        button_wybierz.setVisible(false);
        button_los.setEnabled(false);
        AktywujLosbutton();
        
    }
    /**Metoda wywoływana przez konstruktor 
     * 
     *definicja całego panelu
     */
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        button_wybierz = new javax.swing.JButton();
        button_zaplac1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListMiejsca = new javax.swing.JList<>();
        button_los = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(69, 66, 216));

        jLabel8.setFont(new java.awt.Font("Ubuntu", 0, 20)); // NOI18N
        jLabel8.setText("Odprawa");
        jLabel8.setToolTipText("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(266, 266, 266)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(275, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(76, 76, 76));
        jPanel2.setForeground(new java.awt.Color(254, 254, 254));

        jLabel4.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(126, 175, 229));
        jLabel4.setText("( dostęone 2 dni przed odlotem)");

        jLabel5.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(126, 175, 229));
        jLabel5.setText("Zapłać 20zł za wybór miejsca, lub przydzielimy ci je losowo");

        button_wybierz.setBackground(new java.awt.Color(126, 175, 229));
        button_wybierz.setText("Wybierz miejsce");
        button_wybierz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_wybierzActionPerformed(evt);
            }
        });

        button_zaplac1.setBackground(new java.awt.Color(126, 175, 229));
        button_zaplac1.setText("Zapłać");
        button_zaplac1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_zaplac1ActionPerformed(evt);
            }
        });

        jListMiejsca.setBackground(new java.awt.Color(141, 140, 154));
        jListMiejsca.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jScrollPane2.setViewportView(jListMiejsca);

        button_los.setBackground(new java.awt.Color(126, 175, 229));
        button_los.setText("Wybierz miejsce losowo");
        button_los.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_losActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(110, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(button_wybierz, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button_zaplac1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(button_los, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button_zaplac1)
                    .addComponent(button_los))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(button_wybierz)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 633, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 280, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }
    /**Metoda po wciśnięciu button zaplac1 aktywuje możliwość wyboru miejsc */
    private void button_zaplac1ActionPerformed(java.awt.event.ActionEvent evt) {
        jListMiejsca.setVisible(true);
        button_wybierz.setVisible(true);
        
        DefaultListModel<String> model1 = new DefaultListModel<>();
        jListMiejsca.setModel(model1);
        
        
        String query = "select * from dostepneMiejsca("+id_rezerw+");";
        PreparedStatement ps;
        ResultSet rs;
        
        String queryIDodp = "SELECT COUNT(*) FROM odprawa ;";
        PreparedStatement psID;
        ResultSet rsID;
        
        
        
        try {
            ps=ConnectionDB.getConnect().prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                model1.addElement(rs.getString(1));
            }
            
            psID=ConnectionDB.getConnect().prepareStatement(queryIDodp);
            rsID = psID.executeQuery();
             while(rsID.next()){
                id_odp = rsID.getInt(1)+1;
            }
            
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Odprawa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**Metoda po wciśnięciu button_wybierz wstawia odprawia pasażera, razem  z wybrabym przez niego miejscem */
    private void button_wybierzActionPerformed(java.awt.event.ActionEvent evt) {        String id_miejsce = jListMiejsca.getSelectedValue();
        if(id_miejsce==null){
             JOptionPane.showMessageDialog(null, "Wybierz miejsce");
        }
        else{
            try{
                //wstawienie danych do odprawa 
                Calendar calendar = Calendar.getInstance();
                java.sql.Date date = new java.sql.Date(calendar.getTime().getTime());
        
                String queryInsert = "INSERT INTO odprawa(id_odprawa,cena_miejsce,data_odprawa,id_rezerwacja,lokalizacja) VALUES (?,20,?,?,?)";
                PreparedStatement ps2;
                
                ps2=ConnectionDB.getConnect().prepareStatement(queryInsert);
                ps2.setInt(1,id_odp);
                ps2.setDate(2, date);
                ps2.setInt(3, Integer.parseInt(id_rezerw));
                ps2.setString(4,id_miejsce);
                
                if(ps2.executeUpdate()>0){
                    JOptionPane.showMessageDialog(null, "Miejsce Zarezerwowane");
                    this.dispose();   
                }
                else{
                    JOptionPane.showMessageDialog(null, "Blad rezerwacji");
                }
            
            } catch (SQLException ex) {
                Logger.getLogger(Odprawa.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }
    }

    /**Metoda po wciśnięciu button_los wstawia odprawia pasażera,z losowo wybranym miejscem */
    private void button_losActionPerformed(java.awt.event.ActionEvent evt) {
        String query_rand = "select * from dostepnemiejsca("+id_rezerw+") order by random() limit 1;";
        PreparedStatement ps_rand;
        ResultSet rs_rand;
        String id_miejsce="";
        
        try {
            ps_rand=ConnectionDB.getConnect().prepareStatement(query_rand);
            rs_rand = ps_rand.executeQuery();
            while(rs_rand.next()){
                id_miejsce=rs_rand.getString(1);
            }   
        } catch (SQLException ex) {
            Logger.getLogger(Odprawa.class.getName()).log(Level.SEVERE, null, ex);
        }
          
        String queryIDodp = "SELECT COUNT(*) FROM odprawa ;";
        PreparedStatement psID;
        ResultSet rsID;

        try {
            psID=ConnectionDB.getConnect().prepareStatement(queryIDodp);
            rsID = psID.executeQuery();
             while(rsID.next()){
                id_odp = rsID.getInt(1)+1;
            }
            
            //wstawienie danych do tabeli odprawa
            Calendar calendar = Calendar.getInstance();
            java.sql.Date date = new java.sql.Date(calendar.getTime().getTime());

            String queryInsert = "INSERT INTO odprawa(id_odprawa,cena_miejsce,data_odprawa,id_rezerwacja,lokalizacja) VALUES (?,0,?,?,?)";
            PreparedStatement ps2;
            
            ps2=ConnectionDB.getConnect().prepareStatement(queryInsert);
            ps2.setInt(1,id_odp);
            ps2.setDate(2, date);
            ps2.setInt(3, Integer.parseInt(id_rezerw));
            ps2.setString(4,id_miejsce);

            if(ps2.executeUpdate()>0){
                JOptionPane.showMessageDialog(null, "Miejsce Zarezerwowane: "+id_miejsce);
                this.dispose();
            }
            else{
                JOptionPane.showMessageDialog(null, "Blad rezerwacji");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Odprawa.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_los;
    private javax.swing.JButton button_wybierz;
    private javax.swing.JButton button_zaplac1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JList<String> jListMiejsca;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
