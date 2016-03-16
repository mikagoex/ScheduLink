package schedulink.schedulink;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Michael on 16-02-18.
 */
public class Group implements Serializable {
    private String gid;
    private String name;
    private Uzer owner;
    private ArrayList<Uzer> memberList;
    //private Schedulink userSchedulink //the users set Schedulink for the group
    //private Schedulink groupSchedulink //the groups Schedulink object

    public Group(String name, Uzer owner){
        this.name = name;
        this.owner = owner;
        memberList = new ArrayList<>();
        memberList.add(this.owner);
        //set gid
    }

    public String getGid() {
        return gid;
    }

    public void setGid(String gid) {
        this.gid = gid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Uzer getOwner() {
        return owner;
    }

    public void setOwner(Uzer owner) {
        this.owner = owner;
    }

    public ArrayList<Uzer> getMemberList() {
        return memberList;
    }

    public void setMemberList(ArrayList<Uzer> memberList) {
        this.memberList = memberList;
    }

    public void addMember(Uzer member){
        memberList.add(member);
        System.out.print("member added");
    }

    public void removeMember(Uzer member){
        memberList.remove(member);
        System.out.print("member removed");
    }

    public void inviteMember(){
        //send email to Uzer if they do not exist in DB
        //else send notification to Uzer to join
        //have pendingMembersList?
        System.out.print("inviteMember() was called");
    }

    public int getMemberlistSize(){
        return memberList.size();
    }

    //removes all group members
    public void disbanGroup(){
        //provide a warning
        //if conformation, clear
        memberList.clear();
        //else do nothing
    }
}
