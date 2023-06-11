package Model;

public class ProfilPemain extends Berita implements DetailBerita{
    String detailPemain;
    public ProfilPemain(){}
    public ProfilPemain(int idNews, String judul, String penulis, String isiBerita, String detailPemain) {
        super(idNews, judul, penulis, isiBerita);
        this.detailPemain = detailPemain;
    }

    public String getDetailPemain() {
        return detailPemain;
    }

    @Override
    public String analisis() {
        String newLine = System.getProperty("line.separator");
        return "Nama: " + newLine
                + "Asal: " + newLine
                + "Skill: " + newLine
                + "Kelemahan: " + newLine
                + "Motto hidup: ";
    }
    
    
}
