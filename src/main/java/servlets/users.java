package servlets;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Turpitude on 10/10/2016.
 */
public class users extends Dao {

    public String name;
    public String password;
    public List<Etakemon> userscol;

    public users(String name, String password) {

        this.userscol = new ArrayList<Etakemon>();
        this.name = name;
        this.password = password;
    }

    public users(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Etakemon> getUserscol(){
        return  this.userscol;
    }

    public  void addUsercol(Etakemon etakemon){
        this.userscol.add(etakemon);
    }

    public  void setUserscol( List<Etakemon> etak){
        this.userscol=etak;
    }
}
