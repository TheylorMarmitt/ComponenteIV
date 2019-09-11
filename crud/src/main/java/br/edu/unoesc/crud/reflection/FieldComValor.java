package br.edu.unoesc.crud.reflection;

import java.lang.reflect.Field;

// objetivo retornar o valor dos fields
public class FieldComValor {

    private Field field;
    private Object object;

    public FieldComValor(Field field, Object objeto){
        this.field = field;
        this.object = objeto;
    }

    public String getValor(){
        try{
            field.setAccessible(true);
            return String.valueOf(field.get(object));
        }catch (IllegalAccessException e){
            e.printStackTrace();
        }

        return "";
    }

}
