package ro.pub.cs.systems.eim.practicaltest01var07;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class PracticalTest01Var07SecondaryActivity extends AppCompatActivity {

    TextView textView1, textView2 , textView3, textView4;
    Button sumButton, productButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var07_secondary);


        sumButton = (Button) findViewById(R.id.sumButton);
        productButton = (Button) findViewById(R.id.prodButton);

        textView1 = (TextView) findViewById(R.id.textView);
        textView2 = (TextView) findViewById(R.id.textView2);
        textView3 = (TextView) findViewById(R.id.textView3);
        textView4 = (TextView) findViewById(R.id.textView4);

        Intent intent = getIntent();
        textView1.setText( Objects.requireNonNull(intent.getExtras()).getString("1"));
        textView2.setText( Objects.requireNonNull(intent.getExtras()).getString("2"));

        textView3.setText( Objects.requireNonNull(intent.getExtras()).getString("3"));
        textView4.setText( Objects.requireNonNull(intent.getExtras()).getString("4"));


        sumButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int val1 = Integer.parseInt(textView1.getText().toString());
                int val2 = Integer.parseInt(textView2.getText().toString());

                int val3 = Integer.parseInt(textView3.getText().toString());
                int val4 = Integer.parseInt(textView4.getText().toString());

                int suma = val1 + val2 + val3  + val4;


                Toast.makeText(getApplicationContext(), "suma: " + suma , Toast.LENGTH_LONG).show();

            }
        });

        productButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int val1 = Integer.parseInt(textView1.getText().toString());
                int val2 = Integer.parseInt(textView2.getText().toString());

                int val3 = Integer.parseInt(textView3.getText().toString());
                int val4 = Integer.parseInt(textView4.getText().toString());

                int prod = val1 * val2 * val3 * val4;




                Toast.makeText(getApplicationContext(), "prod: " + prod , Toast.LENGTH_LONG).show();

            }
        });
    }
}