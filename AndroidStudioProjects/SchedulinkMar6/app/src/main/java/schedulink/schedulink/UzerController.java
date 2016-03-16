package schedulink.schedulink;

import android.app.Application;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Bildozer on 2016-03-16.
 */
public class UzerController extends Application
{
    private Uzer currentUser;
    private ArrayList<Group> groups;
    //private ArrayList<Schedulink> schedulinks;
    private Firebase ref;
    private String errorMessage;

    public UzerController(String key, String email)
    {
        super();
        currentUser = new Uzer();
        currentUser.setKey(key);
        currentUser.setEmail(email);
        getUzerInfo(key);
    }

    public void getUzerInfo(String key)
    {
        Firebase userRef = ref.child("Users").child(currentUser.getKey());
        userRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Uzer u = (Uzer) dataSnapshot.getValue(Uzer.class);
                currentUser.setDisplayName(u.getDisplayName());
                currentUser.setName(u.getName());
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }

    public void updateUzerDisplayName(String newDisplay)
    {
        Firebase userRef = ref.child("Users").child(currentUser.getKey());
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("Display", newDisplay);
        userRef.updateChildren(map);
    }

    public String updateUzerPassword(String oldPassword, String newPassword)
    {
        errorMessage = "";
        ref.changePassword(currentUser.getEmail(), oldPassword, newPassword, new Firebase.ResultHandler() {
            @Override
            public void onSuccess() {
                UzerController.this.errorMessage = "Success";
            }

            @Override
            public void onError(FirebaseError firebaseError) {
                UzerController.this.errorMessage = "Firebase Error: " + firebaseError.getDetails();
            }
        });
        return errorMessage;
    }

    public void updateGroups()
    {

    }

    public void persistGroups()
    {

    }

    public void updateSchedulinks()
    {

    }

    public void persistSchedulinks()
    {

    }

}
