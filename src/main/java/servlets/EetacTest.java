package servlets;

import junit.framework.TestCase;

/**
 * Created by Turpitude on 15/11/2016.
 */
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.omg.CosNaming.NamingContextPackage.NotFound;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

public class EetacTest extends TestCase {

    users ud;
    String name;
    String password;
    Etakemon etakemon;
    @Before
    public void setUp() throws Exception {
        etakemon=new Etakemon("Grig","El grig");
        name="Bort";
        password="Bortpls";
    ud=new users("Bort","Bortpls");
    }

    @After
    public void tearDown() throws Exception {

        ud=null;

    }
    @Test
    public void testaddUser() throws Exception {

        EetacDataBase.getInstance().addUser(name,password);

    }
    @Test
    public void testudpdateUser() throws Exception {

        EetacDataBase.getInstance().addUser(name,password);
        name="Lobo";
        password="Loslobos";
        EetacDataBase.getInstance().updateUser(name,password);

    }
    @Test
    public void testgetUser() throws Exception {

        EetacDataBase.getInstance().getUser(name);
    }
    @Test
    public void testgetEtakemon() throws Exception {

        EetacDataBase.getInstance().addUser(name,password);
        EetacDataBase.getInstance().addEtakemon(name,etakemon);
        EetacDataBase.getInstance().getetakemons(name);

    }
    @Test
    public void testaddEtakemon() throws Exception {

        EetacDataBase.getInstance().addUser(name,password);
        EetacDataBase.getInstance().addEtakemon(name,etakemon);

    }
    @Test
    public void testAlphabeticUser() throws Exception {

        EetacDataBase.getInstance().AlphabeticUser();

    }

}