package schedulink.schedulink;


import java.util.ArrayList;
import schedulink.schedulink.weekview.Schedulink;

/**
 * Created by Michael on 16-02-18.
 */
public class Uzer {

    private String uid;
    private String name;
    private String email;
    private Group viewedGroup;
    private ArrayList<Uzer> contactList;
    private ArrayList<Group> groupList;
    private ArrayList<Schedulink> schedulinkList;


    public Uzer(String name, String email) {
        this.name = name;
        this.email = email;
        contactList = new ArrayList<Uzer>();
        groupList = new ArrayList<Group>();
        schedulinkList = new ArrayList<Schedulink>();
        //set uid
    }

    public String getUid() { return uid; }

    public void setUid(String uid) { this.uid = uid; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        Group newGroup = new Group(name, this);
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
