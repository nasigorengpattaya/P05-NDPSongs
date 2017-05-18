package sg.edu.rp.c346.p05_ndpsongs;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {
    Button btnUpdate,btnDelete;
    EditText etTitle,etSinger,etYear;
    RadioGroup rg;
    Song song;
    private DBHelper dbhelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        btnUpdate =(Button)findViewById(R.id.btnUpdate);
        btnDelete = (Button)findViewById(R.id.btnDelete);
        etTitle = (EditText)findViewById(R.id.etTitle);
        etSinger= (EditText)findViewById(R.id.etSinger);
        etYear= (EditText)findViewById(R.id.etYear);
        rg =(RadioGroup)findViewById(R.id.rg);
        Intent i = getIntent();

        DBHelper dbh = new DBHelper(ThirdActivity.this);
        int id = i.getIntExtra("id", 0);
        Cursor res = dbh.getSong(id);
        res.moveToFirst();

        etTitle.setText(res.getString(res.getColumnIndex("title")));
        etSinger.setText(res.getString(res.getColumnIndex("singer")));
        etYear.setText(res.getString(res.getColumnIndex("year")));
        rg.check(id);

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(ThirdActivity.this);
                song.setTitle(etTitle.getText().toString());
                song.setSinger(etSinger.getText().toString());
                song.setYear(etYear.getText().toString());
                song.setStar(rg.getCheckedRadioButtonId());
                dbh.updateSong(song);
                dbh.close();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(ThirdActivity.this);
              int id = song.getId();
                dbh.deleteSong(id);
                dbh.close();
            }
        });
    }
}
