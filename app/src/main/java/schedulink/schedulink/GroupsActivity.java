package schedulink.schedulink;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.app.Activity;
import android.app.AlertDialog;
import java.util.ArrayList;
import java.util.List;

import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;


public class GroupsActivity extends AppCompatActivity {

    //create instance variables
    private Button createNewGroupBtn;
    private ListView lv;
    Global global;
    Uzer newUser;



    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_groups);

        lv = (ListView) findViewById(R.id.listView2); // set the proper id to lv

        //add the global object and retrieve uzer
        global=((Global)getApplicationContext());
        newUser = global.getMainUzer();

        // components from content_groups.xml
        createNewGroupBtn = (Button) findViewById(R.id.newGroupButton);
        createNewGroupBtn.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View view) {
                showInputDialog();
            }
        });

        // array adapter, to display
        final List<Group> groupList = newUser.getGroupList();

        ArrayAdapter<Group> arrayAdapter = new ArrayAdapter<Group>(this, android.R.layout.simple_list_item_1, groupList);
        lv.setAdapter(arrayAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //set viewGroup and go to activity
                newUser.setViewedGroup(groupList.get(position));
                Intent intent = new Intent(GroupsActivity.this, GroupActivity.class);
                startActivity(intent);
            }
        });


    }


    protected void showInputDialog() {

        // get prompts.xml view
        LayoutInflater layoutInflater = LayoutInflater.from(GroupsActivity.this);
        View promptView = layoutInflater.inflate(R.layout.prompts, null);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(GroupsActivity.this);
        alertDialogBuilder.setView(promptView);

        final EditText editText = (EditText) promptView.findViewById(R.id.edittext);
        // setup a dialog window
        alertDialogBuilder.setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        //creating new group and starting activity
                        newUser.createGroup(editText.getText().toString());
                        Intent intent = new Intent(GroupsActivity.this, GroupActivity.class);
                        startActivity(intent);
                    }

                })
                .setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

        // create an alert dialog
        AlertDialog alert = alertDialogBuilder.create();
        alert.show();
    }



}
