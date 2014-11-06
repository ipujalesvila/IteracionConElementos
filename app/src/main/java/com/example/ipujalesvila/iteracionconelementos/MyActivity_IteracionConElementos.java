package com.example.ipujalesvila.iteracionconelementos;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;


public class MyActivity_IteracionConElementos extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_activity__iteracion_con_elementos);

        Button miboton = (Button) findViewById(R.id.b_saludo);
        final RadioButton miRadioSr = (RadioButton) findViewById(R.id.rbSr);
        final RadioButton miRadioSra = (RadioButton) findViewById(R.id.rbSra);



        miboton.setOnClickListener(new View.OnClickListener() {

            EditText editText = (EditText) findViewById(R.id.entrada);

            @Override
            public void onClick(View v) {
                if ("".equals(editText.getText().toString().trim())) {
                    CharSequence msg = getResources().getString(R.string.toastNombre);
                    //mostrar dialogo
                    //showAlert();
                    //mostrar toast()
                    showToast(getResources().getString(R.string.toastNombre));
                    return;
                }

                TextView text = (TextView) findViewById(R.id.saludo);



                if (miRadioSr.isChecked()) {
                    text.setText("Hola Sr. : " + editText.getText());
                } else if (miRadioSra.isChecked()) {
                    text.setText("Hola Sra. : " + editText.getText());

                }
                Intent intento = new Intent(MyActivity_IteracionConElementos.this,Resultado.class);
                intento.putExtra("saludo",text.getText().toString());
                startActivity(intento);


            }
        });
    }

    protected void showToast(String msg) {
        Context contexto = getApplicationContext();
        int duracion = Toast.LENGTH_SHORT;
        Toast tostada = Toast.makeText(contexto, msg, duracion);
        tostada.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my_activity__iteracion_con_elementos, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
