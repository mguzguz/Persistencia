/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import modelo.Usuario;
import modelo.UsuarioDAO;

@WebServlet(name = "Registrar", urlPatterns = {"/Registrar"})
public class Registrar extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion=request.getParameter("accion"); 
        if(accion.equalsIgnoreCase("registrar")){
            String usuario = request.getParameter("usuario");
            String contraseña = request.getParameter("contraseña");

            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn;
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydoggy", "root", "");
                String sql = "INSERT INTO usuarios(USUARIO, CONTRASENA) VALUES (?,?)";
                try ( 
                    PreparedStatement ps = conn.prepareStatement(sql)) {
                    ps.setString(1, usuario);
                    ps.setString(2, contraseña);
                    ps.executeUpdate();
                    response.sendRedirect("bien.jsp");

                }
                conn.close();

            } catch (Exception e) {
                e.printStackTrace();
                PrintWriter out = response.getWriter();
                out.println("<html><body>");
                out.println("<h1>No se pudo hacer el registro</h1>");
                out.println("<form action='login.jsp' method='get'>");
                out.println("<input type='submit' value='LOGIN'/>");
                out.println("</form>");
                out.println("</body></html>");
                out.println("<html><body>");
            }

        }else if(accion.equalsIgnoreCase("login")){
            UsuarioDAO dao = new UsuarioDAO();
            String usuario = request.getParameter("usuarioL");
            String contraseña = request.getParameter("contraseñaL");
            Usuario usu = new Usuario(usuario, contraseña);
            int r;
            r = dao.validar(usu);
            if (r == 1) {
                response.sendRedirect("menu.jsp");
            } else {
                response.sendRedirect("mal.jsp");
            }
        }else if(accion.equalsIgnoreCase("eliminarUsuario")){
            UsuarioDAO dao= new UsuarioDAO(); 
            String usuario=request.getParameter("usser"); 
            String contraseña=request.getParameter("password"); 
            int r= dao.eliminar(usuario, contraseña); 
            if (r == 1) {
                response.sendRedirect("Correcto.jsp");

            } else {
                response.sendRedirect("fallo.jsp");
            }
            
        }else{
            PrintWriter out = response.getWriter();
                out.println("<html><body>");
                out.println("<h1>IMPOSIBLE.</h1>");
                out.println("</body></html>");
                out.println("<html><body>");
        }
        
    }
}