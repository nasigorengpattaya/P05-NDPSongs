package sg.edu.rp.c346.p05_ndpsongs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {
    ListView lv;
    Button btn5Star;
    ArrayList<Song> al;
    ArrayAdapter<Song>aa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        lv = (ListView)findViewById(R.id.lv);
        btn5Star = (Button)findViewById(R.id.btn5Star);


        al = new ArrayList<Song>();

        DBHelper dbh = new DBHelper(this);
        ArrayList<Song>songs = dbh.getAllSongs();
        aa = new songAdapter(this, R.layout.row, songs);
        lv.setAdapter(aa);



        btn5Star.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(SecondActivity.this);
                al.clear();
                al.addAll(dbh.get5StarSongs());
                dbh.close();

                for (int i = 0; i < al.size(); i++) {
                    String tmp = al.get(i).toString();
                }
                lv.setAdapter();
                aa.notifyDataSetChanged();
            }
        });

    }


}
