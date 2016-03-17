package schedulink.schedulink;


import java.util.ArrayList;
import schedulink.schedulink.weekview.Schedulink;

/**
 * Created by Michael on 16-02-18.
 */
public class Uzer {

    private String key;
    private String displayName;
    private String email;
    private Group viewedGroup;
    private ArrayList<Uzer> contactList;
    private ArrayList<Group> groupList;
    private ArrayList<Schedulink> schedulinkList;

    //empty constructor for firebase
    public Uzer(){

    }

    public Uzer(String displayName, String email) {
        this.displayName = displayName;
        this.email = email;
        contactList = new ArrayList<Uzer>();
        groupList = new ArrayList<Group>();
        schedulinkList = new ArrayList<Schedulink>();
        //set uid
    }

    public String getKey() { return key; }

    public void setKey(String key) { this.key = key; }

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

    public Group getViewedGroup() { return viewedGroup; }

    public void setViewedGroup(Group viewedGroup) { this.viewedGroup = viewedGroup; }

    public ArrayList<Uzer> getContactList() {
        return contactList;
    }

    public void setContactList(ArrayList<Uzer> contactList) {
        this.contactList = contactList;
    }

    public ArrayList<Group> getGroupList() {
        return groupList;
    }

    public void setGroupList(ArrayList<Group> groupList) {
        this.groupList = groupList;
    }

    public ArrayList<Schedulink> getSchedulinkList() {
        return schedulinkList;
    }

    public void setSchedulinkList(ArrayList<Schedulink> schedulinkList) {
        this.schedulinkList = schedulinkList;
    }

    public void createGroup(String name){
        Group newGroup = new Group(displayName, this);
        groupList.add(newGroup);
        viewedGroup=newGroup;
    }

    public void joinGroup(Group group){
        groupList.add(group);
    }

    public void leaveGroup(Group group){
        groupList.remove(group);
    }

    public void leaveAllGroups(){
        groupList.clear();
    }

    public void addContact(Uzer user){
        contactList.add(user);
    }

    public void removeContact(Uzer user){
        contactList.remove(user);
    }

}
