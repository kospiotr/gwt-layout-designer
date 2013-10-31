
package pl.pkosmowski.gxtshowcase.client.components;

import pl.pkosmowski.gxtshowcase.client.widget.WidgetContainer;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;

/**
 *
 * @author Piotr Kosmowski
 */
public class VerticalLayoutContainerComponent extends WidgetContainer {

    public VerticalLayoutContainerComponent() {
        editor = new VerticalLayoutContainerEditor();
        adder = new VerticalLayoutContainerAdder();
    }

    @Override
    public Widget createNewInstance() {
        return new VerticalLayoutContainer();
    }
    
}
