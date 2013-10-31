package pl.pkosmowski.gxtshowcase.client;

import com.google.gwt.core.client.Scheduler;
import com.google.gwt.user.client.Event;
import com.sencha.gxt.core.client.Style;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.TreeStore;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.container.MarginData;
import com.sencha.gxt.widget.core.client.tree.Tree;
import java.util.Arrays;
import java.util.List;
import pl.pkosmowski.gxtshowcase.client.navigator.NavigationComponent;

/**
 *
 * @author Piotr Kosmowski
 */
public class NavigatorPanel extends ContentPanel {

    MainPanel mainPanel;
    TreeStore<NavigationComponent> navigationStore;
    Tree<NavigationComponent, String> navigationTree;

    public NavigatorPanel(final MainPanel mainPanel) {
        this.mainPanel = mainPanel;
        initPanel();
        initTree();
    }

    private void initPanel() {
        setHeadingText("Navigator");
    }

    private void initTree() {
        this.navigationStore = new TreeStore<NavigationComponent>(NavigationComponent.createModelKeyProvider());
        this.navigationTree = new NavigationTree(navigationStore, NavigationComponent.createValueProvider());
        add(navigationTree, new MarginData(5));
        createRootNavigationElement();
        navigationTree.expandAll();
    }

    private void createRootNavigationElement() {
        NavigationComponent root = new NavigationComponent("ROOT", mainPanel.getPreviewPanel(), new RootElementComponent());
        navigationStore.add(root);
    }

    private void onNavigationCellClicked() {
        NavigationComponent selectedNavigationElement = getSelectedNavigationElement();
        mainPanel.selectedComponentInNavigator(selectedNavigationElement);

    }

    public NavigationComponent getSelectedNavigationElement() {
        return navigationTree.getSelectionModel().getSelectedItem();
    }

    private void select(List<NavigationComponent> navigationComponent) {
        navigationTree.getSelectionModel().setSelection(navigationComponent);
        onNavigationCellClicked();
    }

    void addNewWidgetToCurrentlySelected(NavigationComponent parentComponent, NavigationComponent navigationComponent) {
        navigationStore.add(parentComponent, navigationComponent);
        navigationTree.setExpanded(parentComponent, true);
        select(Arrays.asList(navigationComponent));

    }

    void removeComponent(NavigationComponent navigationComponent) {
        navigationStore.remove(navigationComponent);
    }

    private class NavigationTree extends Tree<NavigationComponent, String> {

        public NavigationTree(TreeStore<NavigationComponent> store, ValueProvider<? super NavigationComponent, String> valueProvider) {
            super(store, valueProvider);
            getSelectionModel().setSelectionMode(Style.SelectionMode.SINGLE);
        }

        @Override
        protected void onAfterFirstAttach() {
            super.onAfterFirstAttach();
            Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand() {
                @Override
                public void execute() {
                    select(navigationStore.getRootItems());
                }
            });
        }

        @Override
        protected void onClick(Event event) {
            super.onClick(event);
            onNavigationCellClicked();
        }
    }
};
