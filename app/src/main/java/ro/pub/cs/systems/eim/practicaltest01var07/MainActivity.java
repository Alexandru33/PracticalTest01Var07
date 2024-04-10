package ro.pub.cs.systems.eim.practicaltest01var07;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    Button setButton ;
    EditText editText1, editText2, editText3, editText4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var07_main);

        setButton = (Button ) findViewById(R.id.setButton);

        editText1 = (EditText) findViewById(R.id.editTextText);
        editText2 = (EditText) findViewById(R.id.editTextText2);

        editText3 = (EditText) findViewById(R.id.editTextText3);
        editText4 = (EditText) findViewById(R.id.editTextText4);

        if ( savedInstanceState != null)
        {
            editText1.setText( savedInstanceState.getString("key1"));
            editText2.setText( savedInstanceState.getString("key2"));
            editText3.setText( savedInstanceState.getString("key3"));
            editText4.setText( savedInstanceState.getString("key4"));

        }

        setButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String text1 = editText1.getText().toString();
                String text2 = editText2.getText().toString();
                String text3 = editText3.getText().toString();
                String text4 = editText4.getText().toString();
                int val1,val2,val3,val4;
                int isOk = 1;

                try
                {
                     val1 =Integer.parseInt(text1);
                     val2 =Integer.parseInt(text2);
                     val3 =Integer.parseInt(text3);
                     val4 =Integer.parseInt(text4);

                } catch( NumberFormatException e)
                {
                    System.err.println(Arrays.toString(e.getStackTrace()));
                    isOk = 0;
                }

                if ( isOk == 1)
                {
                    Intent intent = new Intent(getApplicationContext() , PracticalTest01Var07SecondaryActivity.class);

                    intent.putExtra("1" , text1);
                    intent.putExtra("2" , text2);

                    intent.putExtra("3" ,text3);
                    intent.putExtra("4" , text4);

                    startActivity(intent);

                }




            }
        });


    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("key1" , editText1.getText().toString());
        outState.putString("key2" , editText2.getText().toString());
        outState.putString("key3" , editText3.getText().toString());
        outState.putString("key4" , editText4.getText().toString());

    }
}