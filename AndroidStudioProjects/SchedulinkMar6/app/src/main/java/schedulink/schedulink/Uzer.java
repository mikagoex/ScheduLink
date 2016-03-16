package schedulink.schedulink;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Michael on 16-02-18.
 */
public class Uzer implements Serializable{

    private String key;
    private String name;
    private String displayName;
    private String email;

    public Uzer()
    {

    }

    public Uzer(String displayName)
    {
        this.displayName = displayName;
    }

    public Uzer(String name, String email, String displayName) {
        this.name = name;
        this.email = email;
        this.displayName = displayName;
        //set uid
    }

    public Uzer(String uid, String name, String email, String display)
    {
        this.email = email;
        this.key = uid;
        this.name = name;
        this.displayName = display;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
