package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

/**
 * Created by Turpitude on 16/11/2016.
 */
public class Register extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String ret = null;
        users sol = null;
        String name = request.getParameter("name");
        String password = request.getParameter("password");

        sol=EetacDataBase.getInstance().getUser(name);

        if (sol == null) {
                ret = "Usuario creado: " + name;
               EetacDataBase.getInstance().addUser(name,password);


        } else {
            ret = "Usuario existente";
        }

        response.setContentType("application/html");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(ret);

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String ret;
        users sol = null;
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        sol = EetacDataBase.getInstance().getUser(name);
        try {
            if (sol.getPassword().equals(password)) {
                ret = "Acceso autorizado: " + name;
            } else {
                ret = "Error al autenticarse";
            }
        }
        catch (Exception e){
            ret = "Error al autenticarse";
        }

        response.setContentType("application/html");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(ret);

    }
}



