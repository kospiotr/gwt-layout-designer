package pl.pkosmowski.gxtshowcase.client.palete;

import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.toolbar.ToolBar;
import java.util.logging.Level;
import pl.pkosmowski.gxtshowcase.client.ComponentFactory;
import pl.pkosmowski.gxtshowcase.client.MainPanel;
import pl.pkosmowski.gxtshowcase.client.navigator.NavigationComponent;
import pl.pkosmowski.gxtshowcase.client.widget.WidgetContainer;

/**
 *
 * @author Piotr Kosmowski
 */
public class PaletePanel extends VerticalLayoutContainer {

    MainPanel mainPanel;
    private ToolBar toolBar;
    Palete palete;

    public PaletePanel(MainPanel mainPanel, ComponentFactory componentFactory) {
        this.mainPanel = mainPanel;
        palete = new Palete(componentFactory);
        toolBar = new ToolBar();
        add(toolBar, new VerticalLayoutData(1, -1));
        initPalete();
    }

    private void initPalete() {
        for (final PaleteButton button : palete.getPaleteElements()) {
            toolBar.add(button);
            button.addSelectHandler(new SelectEvent.SelectHandler() {

                public void onSelect(SelectEvent event) {
                    mainPanel.addNewComponentFromPalete(button.getWidgetElement());
                }
            });
        }
    }

    public void onSelectedComponentInNavigator(NavigationComponent navigationComponent) {
        boolean canAddChildren = navigationComponent.getPaleteElement() instanceof WidgetContainer;
        palete.setDisabilityToAllButtons(!canAddChildren);
    }

}
