package Model;

public class HasilPertandingan extends Berita implements DetailBerita{
    String statistik;
    public HasilPertandingan(){};

    public HasilPertandingan(int idNews, String judul, String penulis, String isiBerita, String statistik) {
        super(idNews, judul, penulis, isiBerita);
        this.statistik = statistik;
    }

    public String getStatistik() {
        return statistik;
    }
    
    @Override
    public String analisis() {
        String newLine = System.getProperty("line.separator");
        return "Turnamen: " + newLine
                + "Home: " + newLine
                + "Away: " + newLine
                + "Skor: " + newLine
                + "MVP: ";
    }
    
}
