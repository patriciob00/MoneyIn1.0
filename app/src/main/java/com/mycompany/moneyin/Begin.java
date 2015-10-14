package com.mycompany.moneyin;

import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileSettingDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;


public class Begin extends ActionBarActivity {

    public Toolbar toolbar;
    private Drawer navigation;
    private AccountHeader header;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_begin);

        toolbar =(Toolbar)findViewById(R.id.app_bar);
        toolbar.setTitle("Principal");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        //ACCOUNT HEADER
        header = new AccountHeaderBuilder()
                .withActivity(this)
                .withCompactStyle(false)
                .withSavedInstance(savedInstanceState)
                .withThreeSmallProfileImages(false)
                .withHeaderBackground(R.drawable.ultimatematerial)
                .addProfiles(
                        new ProfileDrawerItem().withName("Patricio Bruno").withEmail("pbrunorb@hotmail.com").withIcon(getResources().getDrawable(R.drawable.bitbucket))
                )
                .withOnAccountHeaderListener(new AccountHeader.OnAccountHeaderListener() {

                    @Override
                    public boolean onProfileChanged(View view, IProfile profile, boolean current) {
                        Toast.makeText(Begin.this, "onProfileChanged: " + profile.getName(), Toast.LENGTH_SHORT).show();
                        return false;
                    }
                })
                .build();

        //NAVIGATION DRAWER
        navigation = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(toolbar)
                .withActionBarDrawerToggleAnimated(true)
                .withDrawerGravity(Gravity.LEFT)
                .withActionBarDrawerToggle(true)
                .withAccountHeader(header)
                .withSavedInstance(savedInstanceState)
                .withSelectedItem(0)
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        return false;
                    }
                })
                .withOnDrawerItemLongClickListener(new Drawer.OnDrawerItemLongClickListener() {
                    @Override
                    public boolean onItemLongClick(View view, int position, IDrawerItem drawerItem) {
                        return false;
                    }
                })
                .build();
        navigation.addItem(new PrimaryDrawerItem().withName("Contas").withIcon(getResources().getDrawable(R.drawable.violetballdrawer)));
        navigation.addItem(new PrimaryDrawerItem().withName("Receitas").withIcon(getResources().getDrawable(R.drawable.greenballdrawer)));
        navigation.addItem(new PrimaryDrawerItem().withName("Despesas").withIcon(getResources().getDrawable(R.drawable.redballdrawer)));
        navigation.addItem(new PrimaryDrawerItem().withName("Gráficos").withIcon(getResources().getDrawable(R.drawable.saldototal)));
        navigation.addItem(new DividerDrawerItem());
        navigation.addItem( new ProfileSettingDrawerItem().withName("Perfil").withIcon(getResources().getDrawable(R.drawable.perfil_selected)));
        navigation.addItem(new SecondaryDrawerItem().withName("Configurações").withIcon(getResources().getDrawable(R.drawable.settings_selected)));

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
