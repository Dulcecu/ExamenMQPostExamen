package servlets;

import java.util.*;

/**
 * Created by Turpitude on 18/11/2016.
 */

public class EetacDataBase implements EetacInterface {

    final static org.apache.log4j.Logger logger= org.apache.log4j.Logger.getLogger(EetacDataBase.class);
    private static EetacDataBase instance;
    private HashMap<String,users> eetacusers;

    public  EetacDataBase(){
        logger.info("Se crea el Hashmap eetaccustomers");
        eetacusers= new HashMap<String, users>();

    }
    public  static EetacDataBase getInstance(){
        if (instance==null) instance=new EetacDataBase();
        logger.info("Se devuleve la instancia");
        return instance;
    }

    public ArrayList<users> AlphabeticUser() {


        logger.info("Se convierte el HashMap a una Lista");
        ArrayList<users> us= new ArrayList<users>();
        for (HashMap.Entry<String, users> entry : eetacusers.entrySet())
        {

            us.add(entry.getValue());

        }
        logger.info("Se ordena la lista alfabeticamente");
        if (us.size() > 0) {
            Collections.sort(us, new Comparator<users>() {
                public int compare(final users object1, final users object2) {
                    return object1.getName().compareTo(object2.getName());
                }
            });
        }
        return us;
    }

    public void addUser(String name, String password) {
        logger.info("Se crea un usuario: "+name+" / "+password+" y se inserta en el HashMap");
        users us = new users(name,password);
        eetacusers.put(name,us);
    }

    public void updateUser(String name, String password) {
        logger.info("Se crea un usuario: "+name+" / "+password+" y se actualiza en el HashMap");
        users us = new users(name,password);
        eetacusers.put(name,us);
    }

    public users getUser(String name) {
        logger.info("Se recupera el usuario por el nombre de : "+name);
        return  eetacusers.get(name);

    }

    public List<Etakemon> getetakemons(String name) {

        try {
            logger.info("Se recupera la lista de etakemons de un usuario por el nombre de : " + name);
            return eetacusers.get(name).getUserscol();
        }
        catch (Exception e)
        {
            logger.fatal("Excepcion : "+ e);
            return null;
        }
    }

    public void addEtakemon(String name,Etakemon etakemon) {
        try {
            logger.info("Inserta un etakemon al usuario con el nombre de : " + name);
            users us = eetacusers.get(name);
            us.addUsercol(etakemon);
        }
        catch (Exception e){
            logger.fatal("Excepcion : "+ e);
        }
    }
}
