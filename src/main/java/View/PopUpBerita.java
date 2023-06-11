package View;

import Model.Berita;
import Model.Event;
import Model.HasilPertandingan;
import Model.ProfilPemain;

public class PopUpBerita extends javax.swing.JDialog {

    public PopUpBerita(java.awt.Frame parent, boolean modal, Berita berita) {
        super(parent, modal);
        initComponents();
        this.setTitle("Berita");
        this.setLocationRelativeTo(null);
        lblJudul.setText(berita.getJudul());
        lblPenulis.setText("Ditulis oleh " + berita.getPenulis());
        lblIsi.setText(berita.getIsiBerita());
        if(berita instanceof ProfilPemain){
            ProfilPemain profil = (ProfilPemain) berita;
            lblLampiran.setText(profil.getDetailPemain());
        }
        if(berita instanceof HasilPertandingan){
            HasilPertandingan hasil = (HasilPertandingan) berita;
            lblLampiran.setText(hasil.getStatistik());
        }
        if(berita instanceof Event){
            Event event = (Event) berita;
            lblLampiran.setText(event.getKesan());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblJudul = new javax.swing.JLabel();
        lblPenulis = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lblIsi = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        lblLampiran = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblJudul.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblJudul.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lblIsi.setEditable(false);
        lblIsi.setColumns(20);
        lblIsi.setLineWrap(true);
        lblIsi.setRows(5);
        lblIsi.setOpaque(false);
        jScrollPane2.setViewportView(lblIsi);

        lblLampiran.setEditable(false);
        lblLampiran.setColumns(20);
        lblLampiran.setLineWrap(true);
        lblLampiran.setRows(5);
        lblLampiran.setOpaque(false);
        jScrollPane3.setViewportView(lblLampiran);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(lblPenulis, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblJudul, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE)
                            .addComponent(jScrollPane3))))
                .addContainerGap(75, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblJudul, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(lblPenulis, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea lblIsi;
    private javax.swing.JLabel lblJudul;
    private javax.swing.JTextArea lblLampiran;
    private javax.swing.JLabel lblPenulis;
    // End of variables declaration//GEN-END:variables
}
