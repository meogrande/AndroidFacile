package meomobile.it.myapplication;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences mPrefs;
    private String mCurString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("MainActivity","onCreate");
        Button b = (Button) findViewById(R.id.button);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView tv = (TextView) findViewById(R.id.textView);
                tv.setText("Wow! Hai cliccato!");
                System.out.println("Hai cliccato!");
                Log.d("Click", "Hai cliccato");
            }
        });

        // Imposto il valore della textview con il valore memorizzato
        mPrefs = getSharedPreferences("fabio", MODE_PRIVATE);
        mCurString = mPrefs.getString("view_mode", "Hello world!");
        TextView tv = (TextView) findViewById(R.id.textView);
        tv.setText(mCurString);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("MainActivity", "start");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("MainActivity", "resume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("MainActivity", "pause");

        // Salvo il valore nelle preferenze
        SharedPreferences.Editor ed = mPrefs.edit();
        TextView tv = (TextView) findViewById(R.id.textView);
        ed.putString("view_mode", tv.getText().toString());
        //System.out.println(tv.getText().toString());
        ed.commit();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("MainActivity", "restart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("MainActivity", "Stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("MainActivity", "destroy");
    }
}
