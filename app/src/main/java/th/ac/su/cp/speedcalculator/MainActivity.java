package th.ac.su.cp.speedcalculator;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button calbutton = findViewById(R.id.calbutton);
        Button clear = findViewById(R.id.clear);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView vt = findViewById(R.id.answer);
                vt.setText("");
            }
        });
        calbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText distance = findViewById(R.id.distance);
                EditText time = findViewById(R.id.time);

                String dis = distance.getText().toString();
                String t = time.getText().toString();

                if(dis.length()==0 || t.length()==0){
                    Toast a = Toast.makeText(MainActivity.this,"Distance and Time are required",Toast.LENGTH_LONG);

                    a.show();
                }
                else{
                    double d = Double.parseDouble(dis);
                    Double tim = Double.parseDouble(t);
                    if(tim > 0){
                        double answer = (d/tim);
                        double v = (answer*3600)/1000;

                        String finalanswer = String.format(Locale.getDefault(),"%2.f",answer);

                        TextView ans = findViewById(R.id.answer);
                        ans.setText(finalanswer);
                        AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                        dialog.setTitle("SPEED CALCULATOR");
                        dialog.setPositiveButton("OK",null);

                        if(answer > 80){
                            dialog.setMessage("Speed is over limit");
                            dialog.show();
                        }
                    }else{
                        Toast z = Toast.makeText(MainActivity.this,"time must than zero",Toast.LENGTH_LONG);
                        z.show();
                    }

                }
            }
        });

    }
}