package Model;

public class Event extends Berita{
    String kesan;

    public Event() {}

    public Event(int idNews, String judul, String penulis, String isiBerita, String kesan) {
        super(idNews, judul, penulis, isiBerita);
        this.kesan = kesan;
    }

    public String getKesan() {
        return kesan;
    }
    
    
}
