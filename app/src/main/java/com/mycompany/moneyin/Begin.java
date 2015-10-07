package com.mycompany.moneyin;

import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;


public class Begin extends ActionBarActivity {

    public Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_begin);

        toolbar =(Toolbar)findViewById(R.id.app_bar);
        toolbar.setTitle("Principal");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

              NavigationDrawerFragment drawerFragment= (NavigationDrawerFragment)getFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), toolbar);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_begin, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Toast.makeText(this,"Hey , Você acabou de clicar em "+item.getTitle(),Toast.LENGTH_SHORT).show();
            return true;
        }
        if (id==R.id.Next_despesa){
            startActivity(new Intent(this, Second.class));
        }
        if (id==R.id.Sincronizar) {
            Toast.makeText(this,"Sincronizando",Toast.LENGTH_SHORT).show();
            return true;
        }
        if (id==R.id.Next_receita){
            startActivity(new Intent(this,Three.class));
        }
        if (id==R.id.total_despesa){
            startActivity(new Intent(this,Despesas.class));
        }


        return super.onOptionsItemSelected(item);
    }
}
