package pl.pkosmowski.gxtshowcase.client;

import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.widget.core.client.Composite;
import com.sencha.gxt.widget.core.client.TabItemConfig;
import com.sencha.gxt.widget.core.client.container.CardLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.sencha.gxt.widget.core.client.form.TextField;

/**
 *
 * @author Piotr Kosmowski
 */
public abstract class AbstractEditorTab extends Composite {

    private EditorWidgetsMapper editorWidgetsMapper;
    private TabItemConfig tabItemConfig;

    private VerticalLayoutContainer layout;
    private CardLayoutContainer propertiesPanelLayout;
    private TextField variableNameTextField;

    private EditorPanel<?> currentPropertyEditorWidget;

    public AbstractEditorTab(EditorWidgetsMapper editorWidgetsMapper, String tabName) {
        this.editorWidgetsMapper = editorWidgetsMapper;
        this.tabItemConfig = new TabItemConfig(tabName);

        this.propertiesPanelLayout = new CardLayoutContainer();
        this.variableNameTextField = new TextField();

        layout = new VerticalLayoutContainer();
        layout.add(new FieldLabel(variableNameTextField, "Variable name"), new VerticalLayoutContainer.VerticalLayoutData(1, -1, new Margins(5, 5, 0, 5)));
        layout.add(propertiesPanelLayout, new VerticalLayoutContainer.VerticalLayoutData(1, 1, new Margins(5)));
        initWidget(layout);
    }

    public TabItemConfig getTabItemConfig() {
        return tabItemConfig;
    }

    public EditorWidgetsMapper getEditorWidgetsMapper() {
        return editorWidgetsMapper;
    }

    protected abstract void setEditorWidgetFor(Widget widget);

    protected void setEditorWidgetAndDisplayIt(EditorPanel<?> propertiesEditorForType) {
        currentPropertyEditorWidget = propertiesEditorForType;
        propertiesPanelLayout.setActiveWidget(currentPropertyEditorWidget);
    }
    
    void applyToSource() {
        currentPropertyEditorWidget.getEditor().applyToSource();
    }

    void revertEditorValue() {
        currentPropertyEditorWidget.getEditor().revertEditorValue();
    }

    boolean hasPropertiesToEdit() {
        boolean isEmpty = currentPropertyEditorWidget instanceof EmptyEditorWidget;
        return !isEmpty;
    }

    void bindEditorTo(Widget object) {
        currentPropertyEditorWidget.getEditor().bindObject(object);
    }

}
