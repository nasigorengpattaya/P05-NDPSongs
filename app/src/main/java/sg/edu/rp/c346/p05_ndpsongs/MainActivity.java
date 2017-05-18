package sg.edu.rp.c346.p05_ndpsongs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etTitle, etSinger,etYear;
    RadioGroup rg;
    Button btnInsert,btnShowList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etTitle= (EditText)findViewById(R.id.editTextTitle);
        etYear = (EditText)findViewById(R.id.editTextYear);
        etSinger = (EditText)findViewById(R.id.editTextSinger);
        rg = (RadioGroup)findViewById(R.id.rg);
        btnInsert =(Button)findViewById(R.id.buttonInsert);
        btnShowList =(Button)findViewById(R.id.buttonShow);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String title = etTitle.getText().toString().trim();
                String year = etYear.getText().toString().trim();
                String singer = etSinger.getText().toString().trim();
                int star = rg.getCheckedRadioButtonId();

                if (title.length() == 0 && year.length()== 0 && singer.length() == 0)return;

                long row_affected = 0;

                DBHelper dbh = new DBHelper(MainActivity.this);
                if (star == R.id.radioButton1) {
                    row_affected = dbh.insertSong(title,year,singer,1);
                } else if (star == R.id.radioButton2) {
                    row_affected = dbh.insertSong(title,year,singer,2);
                } else if (star == R.id.radioButton3) {
                    row_affected = dbh.insertSong(title,year,singer,3);
                } else if (star == R.id.radioButton4) {
                    row_affected = dbh.insertSong(title,year,singer,4);
                } else if (star == R.id.radioButton5) {
                    row_affected = dbh.insertSong(title,year,singer,5);
                }
                dbh.close();

                if (row_affected != -1){
                    Toast.makeText(MainActivity.this, "Insert successful",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnShowList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,SecondActivity.class);
                startActivity(i);


            }
        });




    }
}
