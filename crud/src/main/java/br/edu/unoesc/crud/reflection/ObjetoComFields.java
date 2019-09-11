package br.edu.unoesc.crud.reflection;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class ObjetoComFields implements Iterable<FieldComValor>{

    private Collection<FieldComValor> valores;

    public ObjetoComFields(Object objeto, Collection<Field> camposTela){
        valores = new ArrayList<>();

        camposTela.forEach(field -> {
            valores.add(new FieldComValor(field, objeto));
        });
    }

    @Override
    public Iterator<FieldComValor> iterator(){
        return valores.iterator();
    }

}
