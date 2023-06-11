package Model;

import java.util.Random;
import java.util.Date;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

public class Turnamen {
    private String namaTurnamen, tempat, deskripsi, jenisTurnamen, tanggal, peserta;
    private int idTurnamen;
    public Turnamen(){}

    public Turnamen(String namaTurnamen) {
        this.namaTurnamen = namaTurnamen;
    }
    public Turnamen(String namaTurnamen, String peserta) {
        this.namaTurnamen = namaTurnamen;
        this.peserta = peserta;
    }
    
    public Turnamen(int idTurnamen, String nama, String tempat, String waktu, String deskripsi, String jenisTurnamen){
        this.idTurnamen = idTurnamen;
        namaTurnamen = nama;
        this.tempat = tempat;
        this.jenisTurnamen = jenisTurnamen;
        this.deskripsi = deskripsi;
        this.tanggal = waktu;
    }
    public Turnamen(String nama, String tempat, String waktu, String deskripsi, String jenisTurnamen){
        namaTurnamen = nama;
        this.tempat = tempat;
        this.jenisTurnamen = jenisTurnamen;
        this.deskripsi = deskripsi;
        this.tanggal = waktu;
    }
    public int getIdTurnamen(){
        return idTurnamen;
    }
    public String getNamaTurnamen(){
        return namaTurnamen;
    }
    public String getPeserta() {
        return peserta;
    }    
    public String getTempat() {
        return tempat;
    }
    public String getDeskripsi() {
        return deskripsi;
    }
    public String getJenisTurnamen() {
        return jenisTurnamen;
    }
    public String getTanggal() {
        return tanggal;
    }
}

