package pl.pkosmowski.gxtshowcase.client;

import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.container.MarginData;
import pl.pkosmowski.gxtshowcase.client.navigator.ContainerAdder;
import pl.pkosmowski.gxtshowcase.client.widget.WidgetContainer;

/**
 *
 * @author Piotr Kosmowski
 */
class RootElementComponent extends WidgetContainer {

    public RootElementComponent() {
        this.adder = new ContainerAdder<ContentPanel>() {

            public void add(ContentPanel parent, Widget child, Object layoutData) {
                parent.add(child, new MarginData(5));
            }
        };
    }

    @Override
    public Widget createNewInstance() {
        throw new UnsupportedOperationException("Not supported yet.");
    }


}
