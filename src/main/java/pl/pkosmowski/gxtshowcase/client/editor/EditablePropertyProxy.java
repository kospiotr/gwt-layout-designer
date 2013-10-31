package pl.pkosmowski.gxtshowcase.client.editor;

import pl.pkosmowski.gxtshowcase.client.factories.EditorFieldFactory;
import com.sencha.gxt.widget.core.client.form.Field;

/**
 *
 * @author Piotr Kosmowski
 */
public class EditablePropertyProxy<I, T> extends PropertyAccessor<I, T> {

    private static EditorFieldFactory fieldFactory = new EditorFieldFactory();
    private Field<T> editor;

    public EditablePropertyProxy(String text, Class<T> type,
            Getter<I, T> getterProxy,
            Setter<I, T> setterProxy) {
        super(text, getterProxy, setterProxy);
        this.editor = fieldFactory.createField(type);
    }

    public void revertEditorValue(I source) {
        editor.setValue(getGetter().get(source));
    }

    public void applyToSource(I source) {
        getSetter().set(source, editor.getValue());
    }

    public Field<?> getEditor() {
        return editor;
    }

}
