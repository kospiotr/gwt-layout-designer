package pl.pkosmowski.gxtshowcase.client.navigator;

import com.google.gwt.user.client.ui.Widget;

/**
 *
 * @author Piotr Kosmowski
 */
public interface ContainerAdder<T extends Widget> {

    public void add(T parent, Widget child, Object layoutData);

}
