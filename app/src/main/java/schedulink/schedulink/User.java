package schedulink.schedulink;

/**
 * Created by Tylerr on 2016-02-09.
 */
public class User {
    private String f_name;
    private String l_name;
    private int userID;
    private String nickname;
    private String email;
    private boolean email_verified;
    //private Schedule[] schedules;     <-- Gonna need this

    public User(String input_first,String input_last, String input_email)
    {
        f_name = input_first;
        l_name = input_last;
        email = input_email;
        userID = createNewID();
        email_verified = false;
    }
    public void emailVerify(boolean result)
    {
        email_verified = result;
    }
    private int createNewID()
    {
        return 0;
    }
    public boolean changeNickname(String newNickname)
    {
        if(true) //Name is taken
        {
            return false;
        }
        else if(newNickname.equals("an inappropriate word"))
        {
            return false;
        }
        else
        {
            nickname = newNickname;
            return true;
        }
    }
}
