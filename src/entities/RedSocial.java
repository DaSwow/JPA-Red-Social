/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author carls
 */
@Entity
@Table(name = "Red Social")
public class RedSocial extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nombre;

    private String sitioWeb;

    @Temporal(TemporalType.DATE)
    private Date fechaInicioOperaciones;

    @ManyToMany(mappedBy = "redesSociales")
    private Collection<Usuario> usuarios = new ArrayList();

    @Transient
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Collection<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Collection<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public void addUsuario(Usuario usuario) {
        if (!usuarios.contains(usuario)) {
            usuarios.add(usuario);
            usuario.addRedSocial(this);
        }
    }

    public String getSitioWeb() {
        return sitioWeb;
    }

    public void setSitioWeb(String sitioWeb) {
        this.sitioWeb = sitioWeb;
    }

    public Date getFechaInicioOperaciones() {
        return fechaInicioOperaciones;
    }

    public void setFechaInicioOperaciones(String fechaInicioOperaciones) {
        try {
            this.fechaInicioOperaciones = sdf.parse(fechaInicioOperaciones);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return  this.getClass().getSimpleName() + "[ nombre=" + nombre + " ]";
    }

}
