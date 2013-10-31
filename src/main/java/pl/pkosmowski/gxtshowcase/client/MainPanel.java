package pl.pkosmowski.gxtshowcase.client;

import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.Style;
import pl.pkosmowski.gxtshowcase.client.navigator.ComponentNameCounter;
import pl.pkosmowski.gxtshowcase.client.navigator.NavigationComponent;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.button.ToolButton;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer.BorderLayoutData;
import com.sencha.gxt.widget.core.client.container.MarginData;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.Viewport;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.info.Info;
import java.util.logging.Logger;
import pl.pkosmowski.gxtshowcase.client.navigator.ContainerAdder;
import pl.pkosmowski.gxtshowcase.client.palete.PaletePanel;
import pl.pkosmowski.gxtshowcase.client.widget.WidgetContainer;
import pl.pkosmowski.gxtshowcase.client.widget.ObjectAccessor;

public class MainPanel extends Viewport {

    private static final Logger logger = Logger.getLogger(MainPanel.class.getName());
    private ComponentFactory componentFactory;
    private ComponentNameCounter componentNamer;

    private BorderLayoutContainer mainLayoutPanel;
    private ContentPanel previewPanel;
    private PaletePanel paletePanel;

    private NavigatorPanel navigatorPanel;
    private EditorsPanel propertiesPanel;
    private ContentPanel mainContentPanel;

    public MainPanel() {
        this.componentFactory = new ComponentFactory();
        this.componentNamer = new ComponentNameCounter();

        this.mainContentPanel = new ContentPanel();
        this.mainLayoutPanel = new BorderLayoutContainer();
        this.paletePanel = new PaletePanel(this, componentFactory);
        this.previewPanel = new PreviewPanel(this);

        this.navigatorPanel = new NavigatorPanel(this);
        this.propertiesPanel = new EditorsPanel(this, componentFactory);

        initBorderLayout();
        add(mainContentPanel);
    }

    private void initBorderLayout() {
        BorderLayoutData westBorderLayoutData = new BorderLayoutContainer.BorderLayoutData() {
            {
                setSize(250);
                setMargins(new Margins(5, 0, 5, 5));
                setCollapseMini(true);
                setCollapsible(true);
            }
        };

        mainLayoutPanel.setWestWidget(navigatorPanel, westBorderLayoutData);
        BorderLayoutData eastBorderLayoutData = new BorderLayoutContainer.BorderLayoutData() {
            {
                setSize(250);
                setMargins(new Margins(5, 5, 5, 0));
            }
        };
        mainLayoutPanel.setEastWidget(propertiesPanel, eastBorderLayoutData);
        mainLayoutPanel.setCenterWidget(previewPanel, new MarginData(5));
        
        verticalLayoutContainer = new VerticalLayoutContainer();
        verticalLayoutContainer.add(paletePanel, new VerticalLayoutContainer.VerticalLayoutData(1, -1));
        verticalLayoutContainer.add(mainLayoutPanel, new VerticalLayoutContainer.VerticalLayoutData(1, 1));
        mainContentPanel.add(verticalLayoutContainer);
    }
    private VerticalLayoutContainer verticalLayoutContainer;

    public void removeComponent(NavigationComponent navigationComponent) {
        navigationComponent.getWidget().removeFromParent();
        navigatorPanel.removeComponent(navigationComponent);
    }

    public void removeCurrentlySelectedComponent() {
        removeComponent(navigatorPanel.getSelectedNavigationElement());
    }

    void selectedComponentInNavigator(NavigationComponent navigationComponent) {
        propertiesPanel.setupEditorsForComponent(navigationComponent.getWidget());
        paletePanel.onSelectedComponentInNavigator(navigationComponent);
    }

    public Widget getPreviewPanel() {
        return previewPanel;
    }

    public void addNewComponentFromPalete(ObjectAccessor paleteElement) {
        NavigationComponent parentComponent = navigatorPanel.getSelectedNavigationElement();
        Widget createNewInstance = paleteElement.createNewInstance();
        NavigationComponent navigationComponent = new NavigationComponent(componentNamer.getNameFor(createNewInstance.getClass()), createNewInstance, paleteElement);
        try {
            addNewWidgetPsyhicallyToParent(parentComponent, createNewInstance);
            navigatorPanel.addNewWidgetToCurrentlySelected(parentComponent, navigationComponent);
        } catch (Exception e) {
            Info.display("Error", e.getMessage());
        }
    }

    private void addNewWidgetPsyhicallyToParent(NavigationComponent parent, Widget child) {
        WidgetContainer parentContainer = (WidgetContainer) parent.getPaleteElement();
        ContainerAdder containerAdder = parentContainer.getAdder();
        containerAdder.add(parent.getWidget(), child, null);
    }

    private void maximize() {
        mainLayoutPanel.hide(Style.LayoutRegion.WEST);
        mainLayoutPanel.hide(Style.LayoutRegion.EAST);
        paletePanel.hide();
        verticalLayoutContainer.forceLayout();
    }

    private void minimize() {
        mainLayoutPanel.show(Style.LayoutRegion.WEST);
        mainLayoutPanel.show(Style.LayoutRegion.EAST);
        paletePanel.show();
        verticalLayoutContainer.forceLayout();
    }

    private class PreviewPanel extends ContentPanel {

        private ToolButton minToolButton;
        private ToolButton maximizeToolButton;

        private PreviewPanel(final MainPanel mainPanel) {
            setHeadingText("Preview");
            maximizeToolButton = new ToolButton(ToolButton.MAXIMIZE, new SelectEvent.SelectHandler() {
                public void onSelect(SelectEvent event) {
                    minToolButton.show();
                    maximizeToolButton.hide();
                    mainPanel.maximize();
                }
            });
            minToolButton = new ToolButton(ToolButton.RESTORE, new SelectEvent.SelectHandler() {
                public void onSelect(SelectEvent event1) {
                    minToolButton.hide();
                    maximizeToolButton.show();
                    mainPanel.minimize();
                }
            });
            addTool(maximizeToolButton);
            addTool(minToolButton);
            minToolButton.hide();
        }
    }
}
