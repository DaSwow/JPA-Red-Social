package entities;

import entities.RedSocialUsuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-03-24T06:16:18")
@StaticMetamodel(RedSocial.class)
public class RedSocial_ { 

    public static volatile SingularAttribute<RedSocial, String> sitioWeb;
    public static volatile SingularAttribute<RedSocial, Date> fechaInicioOperaciones;
    public static volatile SingularAttribute<RedSocial, Long> id;
    public static volatile CollectionAttribute<RedSocial, RedSocialUsuario> usuarioRed;
    public static volatile SingularAttribute<RedSocial, String> nombre;

}