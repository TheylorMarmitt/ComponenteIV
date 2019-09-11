package br.edu.unoesc.crud.reflection;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CamposDinamicos<T>  implements Iterable<ObjetoComFields>{

    private Collection<T> lista;
    private Class<T> clazz;

    public CamposDinamicos(Collection<T> lista, Class<T> clazz){
        this.lista = lista;
        this.clazz = clazz;

    }

    @Override
    public Iterator<ObjetoComFields> iterator() {

        Collection<ObjetoComFields> o = new ArrayList<>();

        Collection<Field> camposTela = ReflectionUtils.getCamposTela(clazz);

        lista.forEach(objeto -> {
            o.add(new ObjetoComFields(objeto, camposTela));
        });

        return o.iterator();
    }
}
