package pl.pkosmowski.gxtshowcase.client;

import com.sencha.gxt.core.client.dom.ScrollSupport;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.form.Field;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import java.util.Map;
import pl.pkosmowski.gxtshowcase.client.editor.ClassEditor;

/**
 *
 * @author Piotr Kosmowski
 */
public class EditorPanel<T> extends VerticalLayoutContainer {

    private ClassEditor<?> editor;

    public EditorPanel(ClassEditor<?> editor) {
        this.editor = editor;
        setScrollMode(ScrollSupport.ScrollMode.AUTO);
        for (Map.Entry<String, Field<?>> entry : editor.getFieldsEditors().entrySet()) {
            add(new FieldLabel(entry.getValue(), entry.getKey()), new VerticalLayoutData(1, -1));
        }
    }

    public ClassEditor<?> getEditor() {
        return editor;
    }

}
