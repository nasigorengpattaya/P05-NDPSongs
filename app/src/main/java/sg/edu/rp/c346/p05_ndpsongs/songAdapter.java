package sg.edu.rp.c346.p05_ndpsongs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ivanlipotan on 5/18/17.
 */

public class songAdapter extends ArrayAdapter<Song> {
    Context context;
    ArrayList<Song> songs;
    int resource;
    ImageView imageView1,imageView2,imageView3,imageView4,imageView5;
    public songAdapter(Context context,int resource,ArrayList<Song>songs){
        super(context, resource, songs);
        this.context = context;
        this.songs = songs;
        this.resource = resource;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(resource, parent, false);

        TextView tvtitle = (TextView) rowView.findViewById(R.id.textViewTitle);
        TextView tvsinger = (TextView) rowView.findViewById(R.id.textViewSinger);
        TextView tvyear = (TextView) rowView.findViewById(R.id.textViewYear;

        ImageView iv1 = (ImageView) rowView.findViewById(R.id.imageView1);
        ImageView iv2 = (ImageView) rowView.findViewById(R.id.imageView2);
        ImageView iv3 = (ImageView) rowView.findViewById(R.id.imageView3);
        ImageView iv4 = (ImageView) rowView.findViewById(R.id.imageView4);
        ImageView iv5 = (ImageView) rowView.findViewById(R.id.imageView5);

        Song song = songs.get(position);
        tvtitle.setText(song.getTitle());
        tvsinger.setText(song.getSinger());
        tvyear.setText(song.getYear());

        //Check if the property for starts == 5, if so, "light" up the stars
        if (song.getStar()== 5) {
            iv5.setImageResource(android.R.drawable.btn_star_big_on);
            iv4.setImageResource(android.R.drawable.btn_star_big_on);
            iv3.setImageResource(android.R.drawable.btn_star_big_on);
            iv2.setImageResource(android.R.drawable.btn_star_big_on);
            iv1.setImageResource(android.R.drawable.btn_star_big_on);
        } else if (song.getStar() == 4) {
            iv4.setImageResource(android.R.drawable.btn_star_big_on);
            iv3.setImageResource(android.R.drawable.btn_star_big_on);
            iv2.setImageResource(android.R.drawable.btn_star_big_on);
            iv1.setImageResource(android.R.drawable.btn_star_big_on);
        } else if (song.getStar() == 3) {
            iv3.setImageResource(android.R.drawable.btn_star_big_on);
            iv2.setImageResource(android.R.drawable.btn_star_big_on);
            iv1.setImageResource(android.R.drawable.btn_star_big_on);
        } else if (song.getStar() == 2) {
            iv2.setImageResource(android.R.drawable.btn_star_big_on);
            iv1.setImageResource(android.R.drawable.btn_star_big_on);
        } else {
            iv1.setImageResource(android.R.drawable.btn_star_big_on);
        }

        return rowView;
    }
}
