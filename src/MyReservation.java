
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 * Klasa MyReservation rezprezenruje okno z rezerwacjami użytkownika
 * @author Mikolaj Baczynski
 */

public class MyReservation extends javax.swing.JFrame {
/**Metoda wypełnia tabele TableRezerw informacjiami zawartymi w tablicy arr
 * @param arr tablica z rekordami otrzymanymi z zapytania zwracającego informacje rezerwacji
 * metoda wywoływana jest w Klasie MainWindow w funkcji button_myRezerwActionPerformed
 */
public void setTable(ArrayList<String> arr){
    DefaultTableModel model = (DefaultTableModel) TableRezerw.getModel();
    DefaultListModel<String> model1 = new DefaultListModel<>();
    jListOdpraw.setModel(model1);
    int j=0;
    for(int i=0;i<arr.size();i+=10){
        model.insertRow(j, new Object[] { arr.get(i),arr.get(i+1),arr.get(i+2),arr.get(i+3),arr.get(i+4),arr.get(i+5),arr.get(i+6),arr.get(i+7),arr.get(i+8),arr.get(i+9) });
        j++;
        model1.addElement(arr.get(i));
    }
}
    /**Konstruktor definiuje okno wraz z elementami*/
    public MyReservation() {
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
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableRezerw = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        jListOdpraw = new javax.swing.JList<>();
        jLabel4 = new javax.swing.JLabel();
        button_Odpraw = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(69, 66, 216));
        jPanel1.setEnabled(false);

        jPanel2.setBackground(new java.awt.Color(76, 76, 76));

        TableRezerw.setBackground(new java.awt.Color(76, 76, 76));
        TableRezerw.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Rezerw", "Nick", "Imie", "Nazwisko", "Skad", "Dokąd ", "Data", "Godzina", "Cena", "Linia"
            }
        ));
        TableRezerw.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        TableRezerw.setEnabled(false);

        jScrollPane1.setViewportView(TableRezerw);
        if (TableRezerw.getColumnModel().getColumnCount() > 0) {
            TableRezerw.getColumnModel().getColumn(0).setResizable(false);
            TableRezerw.getColumnModel().getColumn(1).setResizable(false);
            TableRezerw.getColumnModel().getColumn(2).setResizable(false);
            TableRezerw.getColumnModel().getColumn(3).setResizable(false);
            TableRezerw.getColumnModel().getColumn(4).setResizable(false);
            TableRezerw.getColumnModel().getColumn(5).setResizable(false);
            TableRezerw.getColumnModel().getColumn(6).setResizable(false);
            TableRezerw.getColumnModel().getColumn(7).setResizable(false);
            TableRezerw.getColumnModel().getColumn(8).setResizable(false);
            TableRezerw.getColumnModel().getColumn(9).setResizable(false);
        }

        jListOdpraw.setBackground(new java.awt.Color(141, 140, 154));
        jListOdpraw.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jListOdpraw.setSelectedIndex(1);

        jScrollPane4.setViewportView(jListOdpraw);

        jLabel4.setFont(new java.awt.Font("Ubuntu", 0, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(126, 175, 229));
        jLabel4.setText("Wybierz rezerwacje do odprawy");

        button_Odpraw.setBackground(new java.awt.Color(126, 175, 229));
        button_Odpraw.setText("Odpraw Sie");

        button_Odpraw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_OdprawActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 960, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(button_Odpraw, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(button_Odpraw, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(69, 66, 216));
        jPanel3.setPreferredSize(new java.awt.Dimension(0, 66));

        jLabel9.setFont(new java.awt.Font("Ubuntu", 0, 20)); // NOI18N
        jLabel9.setText("Twoje Rezerwacje");
        jLabel9.setToolTipText("");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(297, 297, 297))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 984, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }
    /**Metoda wywoływana po wiśnięciu button_odpraw, tworzy okno Odprawy */
    private void button_OdprawActionPerformed(java.awt.event.ActionEvent evt) {
        //pobranie wybranej rezerwacji do odprawy
        String id_reze = jListOdpraw.getSelectedValue();
        if(id_reze==null){
            JOptionPane.showMessageDialog(null, "Wybierz rezerwacje do odprawy");
        }
        else{
            String query = "select id_odprawa,lokalizacja from  odprawa where odprawa.id_rezerwacja = "+id_reze+";";
            PreparedStatement ps;
            ResultSet rs;
            PreparedStatement ps2;
            ResultSet rs2;
            int odprawiony=0;// pasazer nie jest odprawiony
            String lokal="";
            try {
                ps=ConnectionDB.getConnect().prepareStatement(query);
                rs = ps.executeQuery();
                while(rs.next()){
                    odprawiony = rs.getInt(1);
                    lokal=rs.getString(2);
                }
                
                String query2="select data_lotu from lot JOIN rezerwacja r USING(id_lot) where r.id_rezerwacja="+id_reze+";";
                LocalDate datateraz = LocalDate.now();
                LocalDate datalot=LocalDate.now();
                ps2=ConnectionDB.getConnect().prepareStatement(query2);
                rs2 = ps2.executeQuery();
                while(rs2.next()){
                    datalot = rs2.getDate(1).toLocalDate();
                }
                //jesli lot już się odbył wyskakuje błąd
                long i =  Duration.between(datateraz.atStartOfDay(),datalot.atStartOfDay() ).toDays();
                if( i < 0 ){
                    JOptionPane.showMessageDialog(null, "Lot już się odbył");
                }
                else{
                    //jak użytkownik juz się odprawił dostaje info z zarazerwowanym miejscem w samolocie
                    if(odprawiony>0){
                        JOptionPane.showMessageDialog(null, "Ta rezerwacaja zostala juz odprawiona. Twoje miejsce to "+lokal);
                    }
                    //jeśli nie odprawiony tworzy się okno do odprawy
                    else{
                        Odprawa odp = new Odprawa(id_reze);
                        odp.setVisible(true);
                        odp.pack();
                        odp.setLocationRelativeTo(null);
                        this.dispose();

                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(MyReservation.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TableRezerw;
    private javax.swing.JButton button_Odpraw;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jListOdpraw;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    // End of variables declaration//GEN-END:variables
}
