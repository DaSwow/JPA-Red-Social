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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
public class RedSocial  implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "REDSOCIAL_ID")
    private Long id;
    
    
    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String sitioWeb;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaInicioOperaciones;

    @Transient
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

  
    @OneToMany(mappedBy = "red")
    private Collection<RedSocialUsuario> usuarioRed = new ArrayList();

      
    public Collection<RedSocialUsuario> getUsuarioRed() {
        return usuarioRed;
    }

    public void setUsuarios(Collection<RedSocialUsuario> usuarios) {
        this.usuarioRed = usuarios;
    }

    public void addUsuario(RedSocialUsuario usuarioGrupo) {

            usuarioRed.add(usuarioGrupo);
         
    }

    public String getSitioWeb() {
        return sitioWeb;
    }

    public void setSitioWeb(String sitioWeb) {
        this.sitioWeb = sitioWeb;
    }

    @Id
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    
    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "[ nombre=" + nombre + " ]";
    }

}
