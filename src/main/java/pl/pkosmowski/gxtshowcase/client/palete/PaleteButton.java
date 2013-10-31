package pl.pkosmowski.gxtshowcase.client.palete;

import com.sencha.gxt.widget.core.client.button.TextButton;
import pl.pkosmowski.gxtshowcase.client.widget.ObjectAccessor;

/**
 *
 * @author Piotr Kosmowski
 */
public class PaleteButton extends TextButton{

    private ObjectAccessor widgetElement;

    public PaleteButton(String name, ObjectAccessor widgetElement) {
        setText(name);
        this.widgetElement = widgetElement;
    }

    public ObjectAccessor getWidgetElement() {
        return widgetElement;
    }

}
