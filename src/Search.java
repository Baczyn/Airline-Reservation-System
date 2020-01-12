
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
/**
 * Klasa Search rezprezenruje okno dostęonych lotów o zadanych parametrach
 * @author Mikolaj Baczynski
 */
public class Search extends javax.swing.JFrame {
    //zmienna trzyma id wybranego lotu
    static int id_lot;

    /**Konstruktor definiuje okno wraz z elementami*/
    public Search() {
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        //jesli użytkownik niezalogowany, brak dostępu do rezerwacji
        if(MainWindow.flag_login==false) button_rezerw.setEnabled(false);
    }
    /**Metoda wypełnia jListLoty otrzymanymi z zapytania rekordami(dostepne loty)
     * @param loty rekordy otrzymane z zaptania
     * Metoda wywoływana jest w MainWindow po otrzymaniu dostępnych lotów
    */
    public void initjListLoty(ArrayList<String> loty){
        
        DefaultListModel<String> model = new DefaultListModel<>();
        jListLoty.setModel(model);

        for(int i=0;i<loty.size();i++)
            model.addElement(loty.get(i));
                

    }
    /**Metoda wywoływana przez konstruktor 
     * 
     *definicja całego panelu
     */
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListLoty = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        button_rezerw = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(69, 66, 216));
        jPanel1.setPreferredSize(new java.awt.Dimension(570, 66));

        jLabel8.setFont(new java.awt.Font("Ubuntu", 0, 20)); // NOI18N
        jLabel8.setText("Dostępne Loty");
        jLabel8.setToolTipText("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(189, 189, 189)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(239, Short.MAX_VALUE))
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

        jListLoty.setBackground(new java.awt.Color(141, 140, 154));
        jScrollPane2.setViewportView(jListLoty);

        jLabel1.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(126, 175, 229));
        jLabel1.setText("skąd");

        jLabel2.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(126, 175, 229));
        jLabel2.setText("miasto");

        jLabel3.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(126, 175, 229));
        jLabel3.setText("do");

        jLabel4.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(126, 175, 229));
        jLabel4.setText("miasto");

        jLabel5.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(126, 175, 229));
        jLabel5.setText("Linia");

        jLabel6.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(126, 175, 229));
        jLabel6.setText("data odlotu");

        jLabel7.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(126, 175, 229));
        jLabel7.setText("godzina");

        button_rezerw.setBackground(new java.awt.Color(126, 175, 229));
        button_rezerw.setText("Rezerwuj!");
        button_rezerw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_rezerwActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(126, 175, 229));
        jLabel9.setText("id");

        jLabel10.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(126, 175, 229));
        jLabel10.setText("cena");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(button_rezerw, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(42, 42, 42)
                .addComponent(jLabel3)
                .addGap(41, 41, 41)
                .addComponent(jLabel4)
                .addGap(37, 37, 37)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10)
                .addGap(25, 25, 25))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(button_rezerw)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }
    //Metoda po wciśnięciu button_rezerw przekierowuje użytkownika do wprowadzenia danych osobowych
    private void button_rezerwActionPerformed(java.awt.event.ActionEvent evt) {

         String wybrany_lot=jListLoty.getSelectedValue();
        if(wybrany_lot==null){
            JOptionPane.showMessageDialog(null, "Wybierz lot do rezerwacji");
        }
        //wyłuskanie id lotu ze Stringa
        else{
            int i=0;
            String Getid="";
            while(wybrany_lot.charAt(i) != ' '){
                Getid+=wybrany_lot.charAt(i);
                i++;
            }
            id_lot = Integer.parseInt(Getid);    
  
            PreparedStatement ps;
            ResultSet rs;
            String query="SELECT * FROM ilosc_wolnych("+id_lot+");";
            int ilosc_wolnych=0;
                try {
                    ps=ConnectionDB.getConnect().prepareStatement(query);
                    rs = ps.executeQuery();
                    while(rs.next()){
                        ilosc_wolnych=rs.getInt(1);
                    }
                }catch (SQLException ex) {
                    Logger.getLogger(Search.class.getName()).log(Level.SEVERE, null, ex);
                }

                if(ilosc_wolnych<1){
                    JOptionPane.showMessageDialog(null, "Brak wolnych miejsc");
                }
                else{
                    JOptionPane.showMessageDialog(null, "Pozostalo wolynch miejsc:"+ilosc_wolnych);
                    DanePax dane = new DanePax();
                    dane.setVisible(true);
                    dane.pack();
                    dane.setLocationRelativeTo(null);
                    this.dispose();
                }
            }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_rezerw;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jListLoty;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
