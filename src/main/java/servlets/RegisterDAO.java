package  servlets;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

public class RegisterDAO extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String ret = null;
        users sol = null;
        String name = request.getParameter("name");
        String password = request.getParameter("password");

        try {
            sol= EetacDataBaseDAO.getInstance().getUser(name);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (Explosiones explosiones) {
            try {
                ret = "Usuario creado: " + name;
                EetacDataBaseDAO.getInstance().addUser(name,password);
                response.setContentType("application/html");
                response.setCharacterEncoding("UTF-8");
                response.getWriter().write(ret);

            } catch (SQLException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        if (sol != null) {
            ret = "Usuario existente";
            response.setContentType("application/html");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(ret);
        }

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String ret=null;
        users sol = null;
        String name = request.getParameter("name");
        String password = request.getParameter("password");

        try {
            sol = EetacDataBaseDAO.getInstance().getUser(name);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (Explosiones explosiones) {
            ret = "Error al autenticarse";
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        if (sol.getPassword().equals(password)) {
            ret = "Acceso autorizado: " + name;
        }
        else
        {
            ret = "Error al autenticarse";
        }
        response.setContentType("application/html");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(ret);

    }
}


