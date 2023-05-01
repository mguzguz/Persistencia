<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>BASE DE DATOS</title>
        <link href="estilos.css" rel="stylesheet" type="text/css"/>
        <style>
            table {
                margin: 0 auto; 
                text-align: center; 
            }
        </style>
    </head>
    <body>
        <div class="formulario">
            <h1>Base de Datos</h1>
            <section class="contenedor">
               
                <table>
                        <tr>
                          <th>Usuario</th>
                          <th>Contraseña</th>
                        </tr>
                        <% 
                          Connection con = null;
                          Statement stmt = null;
                          ResultSet rs = null;
                          try {
                            Class.forName("com.mysql.jdbc.Driver");
                            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydoggy", "root", "");
                            stmt = con.createStatement();
                            rs = stmt.executeQuery("SELECT * FROM usuarios");
                            while (rs.next()) {
                        %>
                              <tr>
                                <td><%=rs.getString("USUARIO")%></td>
                                <td><%=rs.getString("CONTRASENA")%></td>
                              </tr>
                        <% 
                            }
                            rs.close();
                            stmt.close();
                            con.close();
                          } catch (Exception e) {
                            out.println("Error: " + e.getMessage());
                          }
                        %>
                </table>
            <p><a class="link" href="menu.jsp">Volver a Menú de opciones</a></p>

            </section> 
            
        </div>
    </body>
</html>
