
package pl.pkosmowski.gxtshowcase.client.components;

import pl.pkosmowski.gxtshowcase.client.widget.WidgetComponent;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.button.TextButton;

/**
 *
 * @author Piotr Kosmowski
 */
public class TextButtonComponent extends WidgetComponent {
    
    public TextButtonComponent() {
        editor = new TextButtonEditor();
    }

    @Override
    public Widget createNewInstance() {
        return new TextButton();
    }
    
}
