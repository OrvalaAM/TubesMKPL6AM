package Model;

import java.util.Random;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Berita {
    private int idNews;
    private String judul, penulis, isiBerita, kategori;
    public Berita(){}
    public Berita(int idNews, String judul, String penulis, String isiBerita){
        this.judul = judul;
        this.penulis = penulis;
        this.idNews = idNews;
        this.isiBerita = isiBerita;
    }

    public Berita(int idNews, String judul, String penulis, String isiBerita, String kategori) {
        this.idNews = idNews;
        this.judul = judul;
        this.penulis = penulis;
        this.isiBerita = isiBerita;
        this.kategori = kategori;
    }
    

    public Berita(String judul, String penulis, String isiBerita, String kategori) {
        this.judul = judul;
        this.penulis = penulis;
        this.isiBerita = isiBerita;
        this.kategori = kategori;
    }

    public String getKategori() {
        return kategori;
    }
    public int getIdNews(){
        return idNews;
    }
    public String getJudul(){
        return judul;
    }
    public String getPenulis(){
        return penulis;
    }
    public String getIsiBerita(){
        return isiBerita;
    }
    
}
