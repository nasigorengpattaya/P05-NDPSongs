package sg.edu.rp.c346.p05_ndpsongs;

import android.content.Intent;
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
        song = (Song) i.getSerializableExtra("song");
        song.


        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(ThirdActivity.this);
                song.(etContent.getText().toString());
                dbh.updateNote(data);
                dbh.close();
            }
        });
    }
}
