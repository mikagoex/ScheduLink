package schedulink.schedulink;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;


public class MainPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }

/*
Methods that are called to switch activities
 */
    public void displayGroupsActivity(View v){
        startActivity(new Intent(MainPageActivity.this, GroupsActivity.class));
    }

    public void displaySchedulinksActivity(View v){
        startActivity(new Intent(MainPageActivity.this, SchedulinksActivity.class));
    }

    public void displayContactsActivity(View v){
        startActivity(new Intent(MainPageActivity.this, ContactsActivity.class));
    }

    public void displayOptionsActivity(View v){
        startActivity(new Intent(MainPageActivity.this, OptionsActivity.class));
    }







}
