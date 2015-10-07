package com.mycompany.moneyin;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Calendar;


public class Second extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Spinner categoria = (Spinner) findViewById(R.id.categoriaDespesa);


     /**   List<String> list = new ArrayList<String>();
        list.add("Alimentação");
        list.add("Educação");
        list.add("Transporte");
        list.add("Alimentação");
        list.add("Lazer");
        list.add("Moradia");
        list.add("Saùde");
        list.add("Roupa");
        list.add("Pagamentos"); **/

        //ArrayAdapter<String> DataAdapter = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item);

        ArrayAdapter DataAdapter = (ArrayAdapter.createFromResource(this, R.array.categorias,R.layout.support_simple_spinner_dropdown_item));
        DataAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        //Carregando o adapter no spinner
        categoria.setAdapter(DataAdapter);

        final EditText EditDataRec = (EditText)findViewById(R.id.editDataDes);
        EditDataRec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar mcurrentDate = Calendar . getInstance ();
                int mYear = mcurrentDate.get(Calendar.YEAR);
                int mMonth = mcurrentDate.get(Calendar.MONTH);
                int mDay = mcurrentDate.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog mDatePicker = new  DatePickerDialog (Second.this ,  new  DatePickerDialog.OnDateSetListener()  {
                    public  void onDateSet ( DatePicker datepicker ,  int selectedyear ,  int selectedmonth ,  int selectedday )  {
                        // TODO Auto-gerado método stub
                        /** Seu código para obter data e hora **/
                        String data = String.valueOf(selectedday)+"/"+String.valueOf(selectedmonth+1)+"/"+String.valueOf(selectedyear);
                        EditDataRec.setText(data);
                    }
                }, mYear , mMonth , mDay );
                mDatePicker . setTitle ( "Selecione a Data" );
                mDatePicker.show ();   }

        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_second, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.save) {
            Toast.makeText(this,"Despesa Adicionda",Toast.LENGTH_SHORT).show();
            finish();
            //startActivity(new Intent(this,Begin.class));

        }
        if (id==android.R.id.home){
            NavUtils.navigateUpFromSameTask(this);
        }

        return super.onOptionsItemSelected(item);
    }


}
