package pl.pkosmowski.gxtshowcase.client.editor;

/**
 *
 * @author Piotr Kosmowski
 */
public abstract class PropertyAccessor<I,T> {

    private Getter<I,T> getter;
    private Setter<I,T> setter;
    private String name;

    public PropertyAccessor(String name, Getter<I,T> getter, Setter<I,T> setter) {
        this.name = name;
        this.getter = getter;
        this.setter = setter;
    }

    public String getName() {
        return name;
    }

    public void setValue(I obj, T value){
        setter.set(obj, value);
    }
    public T getValue(I obj){
        return getter.get(obj);
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public Getter<I,T> getGetter() {
        return getter;
    }

    public void setGetter(Getter<I,T> getter) {
        this.getter = getter;
    }

    public Setter<I,T> getSetter() {
        return setter;
    }

    public void setSetter(Setter<I,T> setter) {
        this.setter = setter;
    }

}
