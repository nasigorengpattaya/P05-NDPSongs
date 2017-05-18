package sg.edu.rp.c346.p05_ndpsongs;

import java.io.Serializable;

/**
 * Created by 15017420 on 18/5/2017.
 */

public class Song  implements Serializable {

    private int id;
    private String title;
    private String year;
    private String singer;
    private int star;

    public Song(int id, String title, String year, String singer, int star) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.singer = singer;
        this.star = star;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

}
