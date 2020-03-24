/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author carls
 */
@Entity
@Table(name = "RedSocialUsuario")
public class RedSocialUsuario implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "USUARIO_ID")
    private Usuario usuario;

    @Id
    @ManyToOne
    @JoinColumn(name = "REDSOCIAL_ID")
    private RedSocial red;

    @Temporal(TemporalType.DATE)
    private Date fechaRegistrado;

   
    private String pseudonimo;

    @Transient
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public RedSocialUsuario() {

    }

    public void setAtributos(RedSocial red, Usuario usuario, String fechaRegistrado, String pseudonimo) {
        this.usuario = usuario;
        this.red = red;
        this.pseudonimo = pseudonimo;
        try {
            this.fechaRegistrado = sdf.parse(fechaRegistrado);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public RedSocial getRedSocial() {
        return red;
    }

    public void setRedSocial(RedSocial red) {
        this.red = red;
    }

    public Date getFechaRegistrado() {
        return fechaRegistrado;
    }

    public String getPseudonimo() {
        return pseudonimo;
    }

}
