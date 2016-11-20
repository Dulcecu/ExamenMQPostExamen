package servlets;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.*;

/**
 * Created by Turpitude on 18/11/2016.
 */
public class EetacDataBaseDAO extends Dao implements EetacInterface {
    private static EetacDataBaseDAO instance;
    public  EetacDataBaseDAO(){

    }
    public  static EetacDataBaseDAO getInstance(){
        if (instance==null) instance=new EetacDataBaseDAO();
        return instance;
    }

    public ArrayList<users> AlphabeticUser() {
        ArrayList<users> us= new ArrayList<users>();
        if (us.size() > 0) {
            Collections.sort(us, new Comparator<users>() {
                public int compare(final users object1, final users object2) {
                    return object1.getName().compareTo(object2.getName());
                }
            });
        }
        return us;
    }

    public void addUser(String name, String password) throws SQLException, NoSuchMethodException, ClassNotFoundException, IllegalAccessException, InvocationTargetException {

        users us = new users(name,password);
        us.insert();

    }

    public void updateUser(String name, String password) throws SQLException, NoSuchMethodException, ClassNotFoundException, IllegalAccessException, InvocationTargetException {

        users us = new users(name,password);
        us.update();

    }

    public users getUser(String name) throws NoSuchMethodException, Explosiones, IllegalAccessException, SQLException, InvocationTargetException, ClassNotFoundException {
        users us= new users(name);
        return us.select();

    }

    public List<Etakemon> getetakemons(String name) throws NoSuchMethodException, Explosiones, IllegalAccessException, SQLException, InvocationTargetException, ClassNotFoundException {

        users us = new users(name);
        return us.selectEtakemons();


    }

    public void addEtakemon(String name, Etakemon etakemon) throws NoSuchMethodException, Explosiones, IllegalAccessException, SQLException, InvocationTargetException, ClassNotFoundException {

        users us= new users(name);
        List<Etakemon> etakemons= us.selectEtakemons();
        etakemons.add(etakemon);
        us.setUserscol(etakemons);
        us.updateEtakemon();

    }
}
