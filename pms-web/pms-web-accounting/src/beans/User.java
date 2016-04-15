
package beans;
import listas.ListaOpciones;

public class User {

    private String login;
    private String clave;
    private String nombre;
    private String apellido;
    private String direccion;
    private int edad;
    private static int cantidad;
    private ListaOpciones listaOpciones;
    
    /** Creates new User */
    public User() {
        cantidad++;
    }

    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    
    public String getClave() {
        return clave;
    }
    public void setClave(String clave) {
        this.clave = clave;
    }
    
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    public ListaOpciones getListaOpciones() {
        return listaOpciones;
    }
    public void setListaOpciones(ListaOpciones listaOpciones) {
        this.listaOpciones = listaOpciones;
    }

    public void imprimir(){
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellido: " + apellido);
        //System.out.println("Direccion: " + direccion);
        System.out.println("Edad: " + edad);
        System.out.println("Cantidad: " + cantidad);
    }
    
}