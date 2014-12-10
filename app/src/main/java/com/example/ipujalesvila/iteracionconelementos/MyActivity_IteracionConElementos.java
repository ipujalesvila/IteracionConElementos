package com.example.ipujalesvila.iteracionconelementos;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.CompoundButton;


public class MyActivity_IteracionConElementos extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_activity__iteracion_con_elementos);

        Button miboton = (Button) findViewById(R.id.b_saludo);
        final RadioButton miRadioSr = (RadioButton) findViewById(R.id.rbSr);
        final RadioButton miRadioSra = (RadioButton) findViewById(R.id.rbSra);

        final Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.HelloBye, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);


        miboton.setOnClickListener(new View.OnClickListener() {

            String saludo = "";

            EditText editText = (EditText) findViewById(R.id.entrada);

            @Override
            public void onClick(View v) {
                TextView text = (TextView) findViewById(R.id.saludo);
                text.setText("");
                saludo = "";

                if ("".equals(editText.getText().toString().trim())) {
                    CharSequence msg = getResources().getString(R.string.toastNombre);
                    //mostrar dialogo
                    //showAlert();
                    //mostrar toast()
                    showToast(getResources().getString(R.string.toastNombre));
                    return;
                }

                saludo = saludo + spinner.getSelectedItem()+" ";


                if (miRadioSr.isChecked()) {
                    saludo = saludo + "Sr. : " + editText.getText();
                } else if (miRadioSra.isChecked()) {
                    saludo = saludo + "Sra. : " + editText.getText();

                }


                CheckBox timeCheckBox = (CheckBox) findViewById(R.id.checkBox);
                if (timeCheckBox.isChecked()) {
                    DatePicker datePick = (DatePicker) findViewById(R.id.datePicker);
                    String dateToShow = datePick.getDayOfMonth() + "/" + (datePick.getMonth() + 1) + "/" + datePick.getYear();
                    TimePicker timePick = (TimePicker) findViewById(R.id.timePicker);
                    dateToShow += " " + timePick.getCurrentHour() + ":" + timePick.getCurrentMinute();

                    saludo = saludo + " " + dateToShow;

                }
                text.setText(saludo);

                Intent intento = new Intent(MyActivity_IteracionConElementos.this, Resultado.class);
                intento.putExtra("saludo", saludo);
                startActivity(intento);


            }
        });
        CheckBox checkBox = (CheckBox)findViewById(R.id.checkBox);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                int visivility = isChecked?View.VISIBLE:View.GONE;
                View view = findViewById(R.id.timePicker);
                view.setVisibility(visivility);
                view = findViewById(R.id.datePicker);
                view.setVisibility(visivility);
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
