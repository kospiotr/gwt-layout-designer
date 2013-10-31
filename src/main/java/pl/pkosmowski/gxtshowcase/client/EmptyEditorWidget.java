
package pl.pkosmowski.gxtshowcase.client;

import com.google.gwt.user.client.ui.Label;
import pl.pkosmowski.gxtshowcase.client.editor.ClassEditor;

/**
 *
 * @author Piotr Kosmowski
 */
public class EmptyEditorWidget extends EditorPanel<Object> {

    public EmptyEditorWidget() {
        super(new ClassEditor<Object>(Object.class));
    }
    
}
