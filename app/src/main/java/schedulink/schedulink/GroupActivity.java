package schedulink.schedulink;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class GroupActivity extends AppCompatActivity {

    private TextView groupName;
    Global global;
    Uzer newUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);
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

        global=((Global)getApplicationContext());
        newUser = global.getMainUzer();


        //Intent i = getIntent();
        //Group newGroup = (Group)i.getSerializableExtra("testGroup");

        Group newGroup = global.getMainUzer().getGroupList().get(0);

        groupName = (TextView) findViewById(R.id.gname); //set our variable to the xml ID
        groupName.setText(newGroup.getName());





    }

}
