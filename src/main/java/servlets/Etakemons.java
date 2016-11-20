package servlets;

import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Turpitude on 18/11/2016.
 */
public class Etakemons extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String ret = null;
        List<Etakemon> sol = null;
        String myuser=request.getParameter("cookie");
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        sol=EetacDataBase.getInstance().getetakemons(myuser);
        Etakemon etakemon= new Etakemon(name,description);
try {
    if (!sol.get(0).getName().equals(name)) {
        ret = "Etakemon creado: " + name;
        EetacDataBase.getInstance().addEtakemon(myuser, etakemon);
    }

        else {
            ret = "Etakemon existente";
        }
}
        catch (Exception e){
            ret = "Etakemon creado: " + name;
            EetacDataBase.getInstance().addEtakemon(myuser, etakemon);
    }
        response.setContentType("application/html");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(ret);

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        List<String> ret = new ArrayList<String>();
        List<Etakemon> sol = null;
        String myuser=request.getParameter("cookie");
        sol=EetacDataBase.getInstance().getetakemons(myuser);

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

