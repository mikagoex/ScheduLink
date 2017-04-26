package schedulink.schedulink;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ContactsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);
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

        Button contactsButton = (Button)findViewById(R.id.button4);

        contactsButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(ContactsActivity.this, "Request Made!", Toast.LENGTH_LONG).show();
                        EditText email = (EditText)findViewById(R.id.editText6);
                        if(email.getText()!=null){
                            Global global=((Global)getApplicationContext());
                            FirebaseDatabase database = FirebaseDatabase.getInstance();
                            DatabaseReference myRef = database.getReference();
                            DatabaseReference myCheatRef = myRef.child("Requests").push();
                            myCheatRef.child("requestor").setValue(global.getEmail());
                            myCheatRef.child("target").setValue(email.getText().toString());
                            startActivity(new Intent(ContactsActivity.this, ContactsActivity.class));
                        }
                    }
                }
        );


    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(ContactsActivity.this, MainPageActivity.class));
    }

}
