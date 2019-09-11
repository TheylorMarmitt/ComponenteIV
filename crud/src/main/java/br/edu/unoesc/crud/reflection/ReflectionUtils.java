package br.edu.unoesc.crud.reflection;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;

// objetivo retornar os fields
public class ReflectionUtils {

    public static Collection<Field> getCamposTela(Class<?> clazz){
        Collection<Field> retorno = new ArrayList<>();

        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields){
            if(field.isAnnotationPresent(CampoTela.class)){
                retorno.add(field);
            }
        }

        return retorno;
    }

}
