
package dispatchers;

import java.sql.*;

import beans.Opcion;
import beans.Usuario;
import listas.ListaOpciones;
import listas.ListaUsuarios;

public class DisUser {

    private Usuario usuario;
    private Connection connection;

    public DisUser() {
    }
   
    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public Connection getConnection() {
        return connection;
    }
    public void setConnection(Connection connection) {
        this.connection = connection;
    }
    
    public boolean validar(){
        boolean flag=false;
        try{
            String sql = "select nombre, apellido from "+
            "usuario where login='"+usuario.getLogin()+
            "' and clave='"+usuario.getClave()+"'";
            ResultSet rs = connection.createStatement().executeQuery(sql);
            if(rs.next()){
                usuario.setNombre(rs.getString("nombre"));
                usuario.setApellido(rs.getString("apellido"));
                flag = true;
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }
    
    public boolean insertar(){
        boolean flag = false;
        try{
            String sql = "insert into usuario(login, clave, " +
                "nombre, apellido, edad) values(?,?,?,?,?)";
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, usuario.getLogin());
            pre.setString(2, usuario.getClave());
            pre.setString(3, usuario.getNombre());
            pre.setString(4, usuario.getApellido());
            pre.setInt(5,usuario.getEdad());
            pre.executeUpdate();
            flag = true;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    public boolean modificar(){
        boolean flag = false;
        try{
            String sql = "update usuario set clave=?, nombre=?,"+
            " apellido=?, edad=? where login=?";
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(5, usuario.getLogin());
            pre.setString(1, usuario.getClave());
            pre.setString(2, usuario.getNombre());
            pre.setString(3, usuario.getApellido());
            pre.setInt(4,usuario.getEdad());
            pre.executeUpdate();
            flag = true;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    public boolean eliminar(){
        boolean flag = false;
        try{
            String sql = "delete from usuario where login=?";
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, usuario.getLogin());
            pre.executeUpdate();
            flag = true;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    public void cargarTodos(ListaUsuarios lista){
        try{
            String sql = "select login,clave,nombre,apellido,edad from usuario";
            ResultSet rs = connection.createStatement().executeQuery(sql);
            while(rs.next()){
                Usuario u = new Usuario();
                u.setLogin(rs.getString("login"));
                u.setClave(rs.getString("clave"));
                u.setNombre(rs.getString("nombre"));
                u.setApellido(rs.getString("apellido"));
                u.setEdad(rs.getInt("edad"));
                lista.addElement(u);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public void cargarOpciones(ListaOpciones lista){
		try{
            String sql = "SELECT o.codOpcion, o.descripcion, o.link, o.imagen, o.title" +
                         " FROM  opcion o, opcionxusuario ou" +
                         " WHERE ou.login='" + usuario.getLogin() +
                         " ' AND ou.codOpcion = o.codOpcion";
            ResultSet rs = connection.createStatement().executeQuery(sql);
            while(rs.next()){
                Opcion o = new Opcion();
                o.setCodigo(rs.getInt("codOpcion"));
                o.setDescripcion(rs.getString("descripcion"));
                o.setLink(rs.getString("link"));
                o.setImagen(rs.getString("imagen"));
                o.setTitle(rs.getString("title"));
                lista.addElement(o);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

}