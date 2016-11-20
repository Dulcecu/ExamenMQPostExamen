package servlets;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Turpitude on 18/11/2016.
 */
public interface EetacInterface {

    ArrayList<users> AlphabeticUser();
    void addUser( String name,String password) throws SQLException, NoSuchMethodException, ClassNotFoundException, IllegalAccessException, InvocationTargetException;
    void updateUser(String name,String password) throws SQLException, NoSuchMethodException, ClassNotFoundException, IllegalAccessException, InvocationTargetException;
    users getUser(String name) throws NoSuchMethodException, Explosiones, IllegalAccessException, SQLException, InvocationTargetException, ClassNotFoundException;
    List<Etakemon> getetakemons(String name) throws NoSuchMethodException, Explosiones, IllegalAccessException, SQLException, InvocationTargetException, ClassNotFoundException;
    void addEtakemon(String name,Etakemon etakemon) throws NoSuchMethodException, Explosiones, IllegalAccessException, SQLException, InvocationTargetException, ClassNotFoundException;


}
