package pl.pkosmowski.gxtshowcase.client.editor;

/**
 *
 * @author Piotr Kosmowski
 */
public interface Setter<I, V> {

    void set(I item, V value);
}
