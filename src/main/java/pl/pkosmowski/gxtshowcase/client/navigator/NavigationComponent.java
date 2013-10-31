package pl.pkosmowski.gxtshowcase.client.navigator;

import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import pl.pkosmowski.gxtshowcase.client.widget.ObjectAccessor;

/**
 *
 * @author Piotr Kosmowski
 */
public class NavigationComponent {

    private String name;
    private Widget widget;
    private ObjectAccessor paleteElement;

    public NavigationComponent() {
    }

    public NavigationComponent(String name) {
        this.name = name;
    }

    public NavigationComponent(String name, Widget widget, ObjectAccessor paleteElement) {
        this.name = name;
        this.widget = widget;
        this.paleteElement = paleteElement;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static ModelKeyProvider<NavigationComponent> createModelKeyProvider() {
        return new ModelKeyProvider<NavigationComponent>() {

            public String getKey(NavigationComponent item) {
                return item.getName();
            }
        };
    }

    public static ValueProvider<NavigationComponent, String> createValueProvider() {
        return new ValueProvider<NavigationComponent, String>() {

            public String getValue(NavigationComponent object) {
                return object.getName();
            }

            public void setValue(NavigationComponent object, String value) {
                object.setName(value);
            }

            public String getPath() {
                return "name";
            }
        };
    }

    public Widget getWidget() {
        return widget;
    }

    public void setWidget(Widget widget) {
        this.widget = widget;
    }

    public ObjectAccessor getPaleteElement() {
        return paleteElement;
    }

    public void setPaleteElement(ObjectAccessor paleteElement) {
        this.paleteElement = paleteElement;
    }

}
