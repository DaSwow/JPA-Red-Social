package entities;

import entities.RedSocial;
import entities.Usuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-03-24T06:16:18")
@StaticMetamodel(RedSocialUsuario.class)
public class RedSocialUsuario_ { 

    public static volatile SingularAttribute<RedSocialUsuario, RedSocial> red;
    public static volatile SingularAttribute<RedSocialUsuario, Date> fechaRegistrado;
    public static volatile SingularAttribute<RedSocialUsuario, String> pseudonimo;
    public static volatile SingularAttribute<RedSocialUsuario, Usuario> usuario;

}