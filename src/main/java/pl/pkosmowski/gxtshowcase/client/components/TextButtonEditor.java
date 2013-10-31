package pl.pkosmowski.gxtshowcase.client.components;

import com.sencha.gxt.widget.core.client.button.TextButton;
import pl.pkosmowski.gxtshowcase.client.editor.ClassEditor;
import pl.pkosmowski.gxtshowcase.client.editor.EditablePropertyProxy;
import pl.pkosmowski.gxtshowcase.client.editor.Getter;
import pl.pkosmowski.gxtshowcase.client.editor.Setter;

/**
 *
 * @author Piotr Kosmowski
 */
public class TextButtonEditor extends ClassEditor<TextButton> {

    public TextButtonEditor() {
        super(TextButton.class);
        addProperty(new EditablePropertyProxy<TextButton, String>(
                "text",
                String.class,
                new Getter<TextButton, String>() {

                    public String get(TextButton item) {
                        return item.getText();
                    }
                }, new Setter<TextButton, String>() {

                    public void set(TextButton item, String value) {
                        item.setText(value);
                    }
                }));
        addProperty(new EditablePropertyProxy<TextButton, Boolean>(
                "enabled",
                Boolean.class,
                new Getter<TextButton, Boolean>() {

                    public Boolean get(TextButton item) {
                        return item.isEnabled();
                    }
                }, new Setter<TextButton, Boolean>() {

                    public void set(TextButton item, Boolean value) {
                        item.setEnabled(value);
                    }
                }));
    }

}
