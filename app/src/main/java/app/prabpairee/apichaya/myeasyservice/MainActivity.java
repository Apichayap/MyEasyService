package app.prabpairee.apichaya.myeasyservice;

import android.content.res.Configuration;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import app.prabpairee.apichaya.myeasyservice.fragment.MainFragment;
import app.prabpairee.apichaya.myeasyservice.fragment.SecoundFragment;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Add Fragment Activity
        addFragment(savedInstanceState);

        //Setup Drawer Menu
        setupDrawerMenu();

        //Text Controller
        textController();

        //Create ToolBar
        createToolBar();



    }   // Main Method

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);



    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        actionBarDrawerToggle.onConfigurationChanged(newConfig);


    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();


    }

    private void createToolBar() {
        toolbar = (Toolbar) findViewById(R.id.toolBarMain);
        setSupportActionBar(toolbar);

        actionBarDrawerToggle = new ActionBarDrawerToggle(
                MainActivity.this,
                drawerLayout,
                R.string.open,
                R.string.closer

        );
        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    private void textController() {
        TextView mainTextView = (TextView) findViewById(R.id.txtMainFragment);
        TextView SecTextView = (TextView) findViewById(R.id.txtSecondFragment);
        TextView exitTextView = (TextView) findViewById(R.id.txtExit);

        //For MainFragment
        mainTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.contentFragmentMain, new MainFragment())
                        .commit();


                //Close Drawer
                drawerLayout.closeDrawers();

            }
        });

        //For SecondFragment
        SecTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.contentFragmentMain, new SecoundFragment())
                        .commit();


                drawerLayout.closeDrawers();
            }
        });

        //For Exit
        exitTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();

                drawerLayout.closeDrawers();
            }
        });



    }

    private void setupDrawerMenu() {
        drawerLayout = (DrawerLayout) findViewById(R.id.MyDrawerLayout);
    }

    private void addFragment(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.contentFragmentMain,new MainFragment()).commit();
        }
    }

}   // Main Class
