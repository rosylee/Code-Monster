package com.example.dwu.a20180927.Search;
public class Customer {
    private String term = "";
    private int id = 0;
    private int profilePic = -1;

    public Customer(String term,int id, int pic) {
        this.term = term;
        this.id = id;
        this.profilePic = pic;

    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String firstName) {
        this.term = term;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(int profilePic) {
        this.profilePic = profilePic;
    }

    @Override
    public String toString() {
        return this.term+ " " ;
    }
}
