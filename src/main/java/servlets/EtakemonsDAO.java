package servlets;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Turpitude on 18/11/2016.
 */
public class EtakemonsDAO extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String ret = null;
        List<Etakemon> sol = new ArrayList<Etakemon>();
        String myuser=request.getParameter("cookie");
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        try {
            sol=EetacDataBaseDAO.getInstance().getetakemons(myuser);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (Explosiones explosiones) {
            explosiones.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Etakemon etakemon= new Etakemon(name,description);
        try {

            if (sol.get(0)==null) {
                ret = "Etakemon creado: " + name;
                EetacDataBaseDAO.getInstance().addEtakemon(name, etakemon);
            }

            else {
                ret = "Etakemon existente";
            }

        }
        catch (Exception e){
            ret = "Etakemon creado: " + name;
            try {
                EetacDataBaseDAO.getInstance().addEtakemon(myuser, etakemon);
            } catch (NoSuchMethodException e1) {
                e1.printStackTrace();
            } catch (Explosiones explosiones) {
                explosiones.printStackTrace();
            } catch (IllegalAccessException e1) {
                e1.printStackTrace();
            } catch (SQLException e1) {
                e1.printStackTrace();
            } catch (InvocationTargetException e1) {
                e1.printStackTrace();
            } catch (ClassNotFoundException e1) {
                e1.printStackTrace();
            }
        }

        response.setContentType("application/html");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(ret);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        List<String> ret = new ArrayList<String>();
        List<Etakemon> sol = null;
        String myuser=request.getParameter("cookie");
        try {
            sol=EetacDataBaseDAO.getInstance().getetakemons(myuser);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (Explosiones explosiones) {
            explosiones.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {

            for (int i = 0; i < sol.size(); i++) {
                ret.add(sol.get(i).getName());
            }
        }
        catch (Exception e){

        }
        String json = new Gson().toJson(ret);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);

    }
}

