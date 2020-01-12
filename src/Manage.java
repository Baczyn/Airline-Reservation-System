
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

/**
 * Klasa Manage rezprezenruje okno do wyświetlenia wszystkich pasażerów
 * @author Mikolaj Baczynski
 */
public class Manage extends javax.swing.JFrame {
    /**Metoda wypełnia tabele TableRezerw informacjiami zawartymi w tablicy arr
     * @param arr tablica z rekordami otrzymanymi z zapytania zwracającego dane pasażerów danego lotu
     * metoda wywoływana jest w funkcji jButton_allpaxActionPerformed
     */
    public void setTable(ArrayList<String> arr){
        DefaultTableModel model = (DefaultTableModel) TableRezerw.getModel();
        int j=0;
        for(int i=0;i<arr.size();i+=14){
            model.insertRow(j, new Object[] { arr.get(i),arr.get(i+1),arr.get(i+2),arr.get(i+3),arr.get(i+4),arr.get(i+5),arr.get(i+6),arr.get(i+7),arr.get(i+8),arr.get(i+9),arr.get(i+10),arr.get(i+11),arr.get(i+12),arr.get(i+13) });
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
                "ID Rezerw", "Nick", "Imie", "Nazwisko", "Kraj", "Miasto", "ID Lotu", "Skad", "Dokąd ", "Data        ", "Godzina   ", "Cena", "Linia", "Miejsce"
            }
        ));
        TableRezerw.setEnabled(false);
        jScrollPane1.setViewportView(TableRezerw);
        if (TableRezerw.getColumnModel().getColumnCount() > 0) {
            TableRezerw.getColumnModel().getColumn(0).setResizable(false);
            TableRezerw.getColumnModel().getColumn(2).setResizable(false);
            TableRezerw.getColumnModel().getColumn(4).setResizable(false);
            TableRezerw.getColumnModel().getColumn(5).setResizable(false);
            TableRezerw.getColumnModel().getColumn(6).setResizable(false);
            TableRezerw.getColumnModel().getColumn(7).setResizable(false);
            TableRezerw.getColumnModel().getColumn(8).setResizable(false);
            TableRezerw.getColumnModel().getColumn(9).setResizable(false);
            TableRezerw.getColumnModel().getColumn(10).setResizable(false);
            TableRezerw.getColumnModel().getColumn(11).setResizable(false);
            TableRezerw.getColumnModel().getColumn(12).setResizable(false);
            TableRezerw.getColumnModel().getColumn(13).setResizable(false);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 856, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(127, Short.MAX_VALUE))
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




    //początek deklaracji zmiennych
    private javax.swing.JTable TableRezerw;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    //koniec deklaracji zmiennych
}
