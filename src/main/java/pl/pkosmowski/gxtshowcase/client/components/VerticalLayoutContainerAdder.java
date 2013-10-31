
package pl.pkosmowski.gxtshowcase.client.components;

import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import pl.pkosmowski.gxtshowcase.client.navigator.ContainerAdder;

/**
 *
 * @author Piotr Kosmowski
 */
public class VerticalLayoutContainerAdder implements ContainerAdder<VerticalLayoutContainer> {

    public void add(VerticalLayoutContainer parent, Widget child, Object layoutData) {
        parent.add(child, new VerticalLayoutContainer.VerticalLayoutData());
    }

    
}
