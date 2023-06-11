package Model;

import java.util.Random;

public class Tim {
    private String namaTeam, profilTim;
    private int kapasitas;
    
    public Tim(){}
    public Tim(String nama, String profil, int kapasitas){
        namaTeam = nama;
        profilTim = profil;
        this.kapasitas = kapasitas;
    }
    public String getNamaTim(){
        return namaTeam;
    }

    public String getProfilTim() {
        return profilTim;
    }

    public int getKapasitas() {
        return kapasitas;
    }
    
}
