package pl.pkosmowski.gxtshowcase.client.widget;

import pl.pkosmowski.gxtshowcase.client.navigator.ContainerAdder;

/**
 *
 * @author Piotr Kosmowski
 */
public abstract class WidgetContainer extends ObjectAccessor {

    protected ContainerAdder adder;

    public ContainerAdder getAdder() {
        return adder;
    }

    public void setAdder(ContainerAdder adder) {
        this.adder = adder;
    }
    
}
