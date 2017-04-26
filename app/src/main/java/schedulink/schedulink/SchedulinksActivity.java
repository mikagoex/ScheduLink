package schedulink.schedulink;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class SchedulinksActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedulinks);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final String [] schedules= {"School Schedule", "Work Schedule", "MGMT3550 Group"};
        ListAdapter scheduleAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, schedules);
        ListView scheduleListView = (ListView)findViewById(R.id.listView4);
        scheduleListView.setAdapter(scheduleAdapter);

        scheduleListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String schedule = String.valueOf(parent.getItemAtPosition(position));
                        Toast.makeText(SchedulinksActivity.this, schedule, Toast.LENGTH_LONG).show();
                    }
                }
        );


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
Method that is called to switch activities
 */
    public void displaySchedulinkViewerActivity(View v){
        startActivity(new Intent(SchedulinksActivity.this, SchedulinkViewerActivity.class));
    }

}
