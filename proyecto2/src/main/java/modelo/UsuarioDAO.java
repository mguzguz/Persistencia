package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuarioDAO implements Validar {

    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    int r=0;

    @Override
    public int validar(Usuario usu) {
        String sql = "SELECT * FROM usuarios WHERE USUARIO=? AND CONTRASENA=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, usu.getUsuario());
            ps.setString(2, usu.getContraseña());
            rs = ps.executeQuery();
            if (rs.next()) {
                return 1; 
            } else {
                return 0; 
            }

        } catch (Exception e) {
            return 0; // Error
        }
    }

    @Override
    public int eliminar(String usuario, String contraseña) {
    String sql = "DELETE FROM usuarios WHERE USUARIO=? AND CONTRASENA=?";
    int resultado = 0;
    try {
        con = cn.getConnection();
        ps = con.prepareStatement(sql);
        ps.setString(1, usuario);
        ps.setString(2, contraseña);
        resultado = ps.executeUpdate();
    } catch (Exception e) {
         e.getMessage();
    } 
    return resultado;
}
    
}
