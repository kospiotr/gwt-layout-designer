package pl.pkosmowski.gxtshowcase.client.widget;

import com.google.gwt.user.client.ui.Widget;
import pl.pkosmowski.gxtshowcase.client.editor.ClassEditor;

/**
 *
 * @author Piotr Kosmowski
 */
public abstract class ObjectAccessor {

    protected ClassEditor<?> editor;

    public abstract Widget createNewInstance();

    public ClassEditor<?> getEditor() {
        return editor;
    }

}
