/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author carls
 */
@Entity
@Table(name = "Usuario")
public class Usuario extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nombre;

    private String correoElectronico;

    private String sexo;

    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;

    private Integer edad;

    @ManyToMany
    @JoinTable(name = "Red Social Usuario")
    private Collection<RedSocial> redesSociales=new ArrayList();

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Collection<RedSocial> getRedesSociales() {
        return redesSociales;
    }

    public void setRedesSociales(Collection<RedSocial> redesSociales) {
        this.redesSociales = redesSociales;
    }

    public void addRedSocial(RedSocial red) {
        if (!redesSociales.contains(red)) {
            redesSociales.add(red);
            red.addUsuario(this);
        }
    }


    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        try {
            this.fechaNacimiento = sdf.parse(fechaNacimiento);

            Period diff = Period.between(convertToLocalDateViaInstant(this.fechaNacimiento), LocalDate.now());
            this.setEdad(diff.getYears());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public Integer getEdad() {
        return edad;
    }

    private void setEdad(Integer edad) {
        this.edad = edad;
    }

    public LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }

}
