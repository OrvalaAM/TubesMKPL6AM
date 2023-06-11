package View;

import Controller.JoinTurnamenController;
import Model.Turnamen;
import Model.User;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;

public class JoinTurnamenView extends javax.swing.JFrame {

    ArrayList<Turnamen> listTurnamen;
    ArrayList<Turnamen> listPartisipasi;
    JoinTurnamenController controller = new JoinTurnamenController();
    User user;
    public JoinTurnamenView(User user) {
        initComponents();
        this.user = user;
        this.setTitle("Menu Turnamen");
        if(user.getNamaTeam().equals("")){
            String[] menu = new String[]{"Solo"};
            cbxJenis.setModel(new DefaultComboBoxModel(menu));
            listTurnamen = controller.setListTurnamenByJenis("Solo");
            tampilTabelTurnamenByJenis(listTurnamen);
        }
        else{
            String[] menu = new String[]{"Semua", "Solo", "Team", "Solo/Team"};
            cbxJenis.setModel(new DefaultComboBoxModel(menu));
            listTurnamen = controller.setListTurnamen();
            tampilTabelTurnamen();
        }
        this.setLocationRelativeTo(null);
        tampilListPartisipasi();
    }
    public void tampilListPartisipasi(){
        listPartisipasi = controller.setListPartisipasi(user);
        DefaultListModel model = new DefaultListModel();
        for(Turnamen e:listPartisipasi){
            model.addElement(e.getNamaTurnamen());
        }
        jListPartisipasi.setModel(model);
    }
    public void tampilTabelTurnamen(){
        listTurnamen = controller.setListTurnamen();
        DefaultTableModel model = (DefaultTableModel) tabelTurnamen.getModel();
        for(Turnamen e:listTurnamen){
            Object o[] = {e.getNamaTurnamen(), e.getTempat(), e.getTanggal(), e.getDeskripsi(), e.getJenisTurnamen()};
            model.addRow(o);
        }
    }
    
    public void removeRow(){
        DefaultTableModel model = (DefaultTableModel) tabelTurnamen.getModel();
        model.removeRow(0);
    }
    public void tampilTabelTurnamenByJenis(ArrayList<Turnamen> listTurnamenTerpilih){
        listTurnamen = listTurnamenTerpilih;
        DefaultTableModel model = (DefaultTableModel) tabelTurnamen.getModel();
        for(Turnamen e:listTurnamen){
            Object o[] = {e.getNamaTurnamen(), e.getTempat(), e.getTanggal(), e.getDeskripsi(), e.getJenisTurnamen()};
            model.addRow(o);
        }
    }
    public String getJenis(){
        int index = cbxJenis.getSelectedIndex();
        return cbxJenis.getItemAt(index);
    }
    public String getNamaTurnamen(){
        int row = tabelTurnamen.getSelectedRow();
        return tabelTurnamen.getModel().getValueAt(row, 0).toString();
    }
    public ArrayList<Turnamen> getListTurnamen(){
        return listTurnamen;
    }
    public void klikBtnIkut(ActionListener listener){
        btnIkut.addActionListener(listener);
    }
    public void klikBtnKembali(ActionListener listener){
        btnKembali.addActionListener(listener);
    }
    public void klikCbxJenis(ActionListener listener){
        cbxJenis.addActionListener(listener);
    }
    public void setCbxJenis(int index){
        cbxJenis.setSelectedIndex(index);
    }
    public void reset(){
        listTurnamen.removeAll(listTurnamen);
        DefaultTableModel model = (DefaultTableModel) tabelTurnamen.getModel();
        while(model.getRowCount() > 0){
            model.removeRow(0);
        }
        listPartisipasi.removeAll(listPartisipasi);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListPartisipasi = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelTurnamen = new javax.swing.JTable();
        cbxJenis = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        btnIkut = new javax.swing.JButton();
        btnKembali = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("MENU TURNAMEN");

        jScrollPane1.setViewportView(jListPartisipasi);

        jLabel2.setText("Turnamen yang akan diikuti");

        jLabel3.setText("Turnamen yang tersedia");

        tabelTurnamen.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nama Turnamen", "Tempat", "Tanggal", "Deskripsi", "Jenis Turnamen"
            }
        ));
        jScrollPane2.setViewportView(tabelTurnamen);

        cbxJenis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

        jLabel4.setText("Jenis");

        btnIkut.setText("Ikut");

        btnKembali.setText("Kembali");

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addComponent(btnKembali)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnIkut, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(97, 97, 97))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(90, 90, 90)
                                            .addComponent(jButton1))
                                        .addComponent(jLabel4))
                                    .addGap(46, 46, 46)
                                    .addComponent(cbxJenis, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(188, 188, 188)
                        .addComponent(jLabel1)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(15, 15, 15)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(38, 38, 38)))
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxJenis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnKembali)
                    .addComponent(btnIkut))
                .addContainerGap(61, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        removeRow();
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIkut;
    private javax.swing.JButton btnKembali;
    private javax.swing.JComboBox<String> cbxJenis;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JList<String> jListPartisipasi;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabelTurnamen;
    // End of variables declaration//GEN-END:variables

}
