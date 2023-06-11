package View;

import MainProgram.DBconn;
import Model.Berita;
import Model.Event;
import Model.HasilPertandingan;
import Model.ProfilPemain;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DaftarBeritaView extends javax.swing.JFrame {

    Connection con = DBconn.getConnection();
    Statement stt = DBconn.getStatement();
    ResultSet rs;
    ArrayList<Berita> listBerita = new ArrayList<>();
    String sql;
    public DaftarBeritaView() {
        initComponents();
        tampilBerita();
        this.setTitle("Menu Berita");
        this.setLocationRelativeTo(null);
    }
    public ArrayList<Berita> getListBerita(){
        return listBerita;
    }
    public void klikBtnKembali(ActionListener listener){
        btnKembali.addActionListener(listener);
    }
    
    public void tampilBerita(){
        try{
            String sql = "select * from berita";
            rs = stt.executeQuery(sql);
            while(rs.next()){
                if(rs.getString("kategori").equals("Profil Pemain")){
                    Berita tambahProfil = new ProfilPemain(rs.getInt("id"), rs.getString("judul"), rs.getString("penulis"), rs.getString("isi"), rs.getString("lampiran"));
                    listBerita.add(tambahProfil);
                }
                else if(rs.getString("kategori").equals("Hasil Pertandingan")){
                    Berita tambahHasil = new HasilPertandingan(rs.getInt("id"), rs.getString("judul"), rs.getString("penulis"), rs.getString("isi"), rs.getString("lampiran"));
                    listBerita.add(tambahHasil);
                }
                else if(rs.getString("kategori").equals("Event")){
                    Berita tambahEvent = new Event(rs.getInt("id"), rs.getString("judul"), rs.getString("penulis"), rs.getString("isi"), rs.getString("lampiran"));
                    listBerita.add(tambahEvent);
                }
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        DefaultTableModel model = (DefaultTableModel) tabelBerita.getModel();
        for(Berita e:listBerita){
            Object o[] = {e.getJudul(), e.getPenulis()};
            model.addRow(o);
        }
    }
    public String getSelectedBerita(){
        int row = tabelBerita.getSelectedRow();
        return tabelBerita.getModel().getValueAt(row, 0).toString();
    }
    public void klikTabelBerita(MouseListener listener){
        tabelBerita.addMouseListener(listener);
    }
    
    public JTable getJTable(){
        return tabelBerita;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelBerita = new javax.swing.JTable();
        btnKembali = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("MENU BERITA");

        tabelBerita.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Judul", "Penulis"
            }
        ));
        jScrollPane1.setViewportView(tabelBerita);

        btnKembali.setText("Kembali");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnKembali)
                .addGap(162, 162, 162))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(54, 54, 54)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                .addComponent(btnKembali)
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKembali;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelBerita;
    // End of variables declaration//GEN-END:variables
}
