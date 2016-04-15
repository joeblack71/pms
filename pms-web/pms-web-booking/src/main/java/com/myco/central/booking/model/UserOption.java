/*
 * UserOption.java
 *
 * Created on December 11, 2002, 7:42 PM
 */

package com.mycom.booking.beans;

/**
 *
 * @author  instructor
 * @version 
 */
public class UserOption {

    private int    codigo;
    private String descripcion;
    private String link;
    private String imagen;
    private String title;

    /** Creates new UserOption */
    public UserOption() {
    }

    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getLink() {
        return link;
    }
    public void setLink(String link) {
        this.link = link;
    }

    public String getImagen() {
        return imagen;
    }
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String imagen) {
        this.title = title;
    }

}
