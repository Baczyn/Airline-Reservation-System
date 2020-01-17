
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * Klasa Manage rezprezenruje okno do wyświetlenia wszystkich pasażerów
 * @author Mikolaj Baczynski
 */
public class Manage extends javax.swing.JFrame {
    /**Metoda wypełnia tabele TableRezerw informacjiami zawartymi w tablicy arr, oraz JListLoty zaweirajaca numery rezewacji
     * @param arr tablica z rekordami otrzymanymi z zapytania zwracającego dane pasażerów danego lotu
     * metoda wywoływana jest w funkcji jButton_allpaxActionPerformed
     */
    public void setTable(ArrayList<String> arr){

        DefaultListModel<String> model1 = new DefaultListModel<>();
        jListLoty.setModel(model1);
        DefaultTableModel model = (DefaultTableModel) TableRezerw.getModel();
        int j=0;
        for(int i=0;i<arr.size();i+=14){
            model.insertRow(j, new Object[] { arr.get(i),arr.get(i+1),arr.get(i+2),arr.get(i+3),arr.get(i+4),arr.get(i+5),arr.get(i+6),arr.get(i+7),arr.get(i+8),arr.get(i+9),arr.get(i+10),arr.get(i+11),arr.get(i+12),arr.get(i+13) });
            model1.addElement(arr.get(i));
            j++;
        }
    }

    /**Konstruktor definiuje okno wraz z elementami*/
    public Manage() {
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
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableRezerw = new javax.swing.JTable();
        button_usun = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jListLoty = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(69, 66, 216));
        jPanel1.setPreferredSize(new java.awt.Dimension(376, 66));

        jLabel9.setFont(new java.awt.Font("Ubuntu", 0, 20)); // NOI18N
        jLabel9.setText("Pasażerowie");
        jLabel9.setToolTipText("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(361, 361, 361)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel9)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(76, 76, 75));

        TableRezerw.setBackground(new java.awt.Color(76, 76, 76));
        TableRezerw.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Rezerw", "Nick", "Imie", "Nazwisko", "Kraj", "Miasto", "ID Lotu", "Skad", "Dokąd", "Data", "Godzina", "Cena", "Linia", "Miejsce"
            }
        ));
        TableRezerw.setEnabled(false);
        jScrollPane1.setViewportView(TableRezerw);
        if (TableRezerw.getColumnModel().getColumnCount() > 0) {
            TableRezerw.getColumnModel().getColumn(0).setResizable(true);
            TableRezerw.getColumnModel().getColumn(2).setResizable(true);
            TableRezerw.getColumnModel().getColumn(4).setResizable(true);
            TableRezerw.getColumnModel().getColumn(5).setResizable(true);
            TableRezerw.getColumnModel().getColumn(6).setResizable(true);
            TableRezerw.getColumnModel().getColumn(7).setResizable(true);
            TableRezerw.getColumnModel().getColumn(8).setResizable(true);
            TableRezerw.getColumnModel().getColumn(9).setResizable(true);
            TableRezerw.getColumnModel().getColumn(10).setResizable(true);
            TableRezerw.getColumnModel().getColumn(11).setResizable(true);
            TableRezerw.getColumnModel().getColumn(12).setResizable(true);
            TableRezerw.getColumnModel().getColumn(13).setResizable(true);
        }

        button_usun.setBackground(new java.awt.Color(126, 175, 229));
        button_usun.setText("Usuń lot");
        button_usun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_usunActionPerformed(evt);
            }
        });

        jListLoty.setBackground(new java.awt.Color(141, 140, 154));
        jListLoty.setSelectedIndex(1);
        jScrollPane3.setViewportView(jListLoty);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 856, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(button_usun, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 149, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(button_usun, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 888, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }
    private void button_usunActionPerformed(java.awt.event.ActionEvent evt) {                                            
        String lot = jListLoty.getSelectedValue();
       if(lot!=null){
           PreparedStatement ps;
           ResultSet rs;
           String query = "select * from usun_rezerwacje(?);";
           
     
           try {
               ps=ConnectionDB.getConnect().prepareStatement(query);
               ps.setInt(1, Integer.parseInt(lot));
               
               rs = ps.executeQuery();
               while(rs.next()){
                   if(rs.getInt(1)>0){
                       JOptionPane.showMessageDialog(null, "rezerwacja została usunięta"); 
                       this.dispose();
                   }
                   else{
                       JOptionPane.showMessageDialog(null, "Błąd podczas usuwania"); 
                   }
               
               }
           } catch (SQLException ex) {
               Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
           }
           
       }
       else{
       JOptionPane.showMessageDialog(null, "Wybierz rezerwacje do usunięcia");
       }
   }             




    //początek deklaracji zmiennych
    private javax.swing.JTable TableRezerw;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton button_usun;
    private javax.swing.JList<String> jListLoty;
    private javax.swing.JScrollPane jScrollPane3;
    //koniec deklaracji zmiennych
}
