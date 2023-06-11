package View;

import Controller.MenuTimController;
import MainProgram.DBconn;
import Model.Berita;
import Model.Event;
import Model.HasilPertandingan;
import Model.ProfilPemain;
import Model.Tim;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class MenuTimView extends javax.swing.JFrame {

    Connection con = DBconn.getConnection();
    Statement stt = DBconn.getStatement();
    ResultSet rs;
    ArrayList<Tim> listTim = new ArrayList<>();
    String sql;
    public MenuTimView() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Menu Tim");
        tampilTim();
    }
    public ArrayList<Tim> getListTim(){
        return listTim;
    }
    public void klikBtnBuat(ActionListener listener){
        btnBuat.addActionListener(listener);
    }
    public void klikBtnGabung(ActionListener listener){
        btnGabung.addActionListener(listener);
    }
    public void klikTabelTim(MouseListener listener){
        tabelTim.addMouseListener(listener);
    }
    public void klikBtnKembali(ActionListener listener){
        btnKembali.addActionListener(listener);
    }
    public void tampilTim(){
        try{
            sql = "select * from tim";
            rs = stt.executeQuery(sql);
            while(rs.next()){
                Tim tim = new Tim(rs.getString("nama_tim"), rs.getString("profil"), rs.getInt("kapasitas_anggota"));
                listTim.add(tim);
            }
        }
        
        catch(Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        DefaultTableModel model = (DefaultTableModel) tabelTim.getModel();
        for(Tim e:listTim){
            int jumlah = new MenuTimController().getJumlahAnggota(e.getNamaTim());
            if(jumlah < e.getKapasitas()){
                Object o[] = {e.getNamaTim(), e.getProfilTim()};
                model.addRow(o);
            }
        }
    }
    public void reset(){
        listTim.removeAll(listTim);
        DefaultTableModel model = (DefaultTableModel) tabelTim.getModel();
        while(model.getRowCount() > 0){
            model.removeRow(0);
        }
    }
    public  String getSelectedTim(){
        int row = tabelTim.getSelectedRow();
        return tabelTim.getModel().getValueAt(row, 0).toString();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnBuat = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelTim = new javax.swing.JTable();
        btnGabung = new javax.swing.JButton();
        btnKembali = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("MENU TIM");

        btnBuat.setText("Buat Tim");

        tabelTim.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nama Tim", "Profil Tim"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabelTim);

        btnGabung.setText("Gabung Tim");

        btnKembali.setText("Kembali");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(188, 188, 188)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBuat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(btnKembali)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnGabung))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(btnBuat)
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGabung)
                    .addComponent(btnKembali))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuat;
    private javax.swing.JButton btnGabung;
    private javax.swing.JButton btnKembali;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelTim;
    // End of variables declaration//GEN-END:variables
}
