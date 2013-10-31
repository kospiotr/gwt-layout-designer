package pl.pkosmowski.gxtshowcase.client;

import com.google.common.base.Function;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.Sets;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.widget.core.client.PlainTabPanel;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.BoxLayoutContainer;
import com.sencha.gxt.widget.core.client.container.HBoxLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import java.util.Set;

/**
 *
 * @author Piotr Kosmowski
 */
public class EditorsPanel extends VerticalLayoutContainer {

    private TextButton applyButton;
    private TextButton deleteButton;
    private TextButton revertButton;
    private Set<AbstractEditorTab> editorTabs;

    private EditorWidgetsMapper editorWidgetsMapper;
    private MainPanel mainPanel;

    public EditorsPanel(MainPanel mainPanel, ComponentFactory componentFactory) {
        this.mainPanel = mainPanel;
        initComponents(componentFactory);
        add(createTabPanel(), new VerticalLayoutContainer.VerticalLayoutData(1, 1));
        add(createButtonBar(), new VerticalLayoutContainer.VerticalLayoutData(1, -1, new Margins(5, 0, 0, 0)));
    }

    private void initComponents(ComponentFactory componentFactory) {
        this.applyButton = new TextButton("Apply", new SelectEvent.SelectHandler() {

            public void onSelect(SelectEvent event) {
                onSubmit();
            }
        });
        this.deleteButton = new TextButton("Delete", new SelectEvent.SelectHandler() {

            public void onSelect(SelectEvent event) {
                onDelete();
            }

        });
        this.revertButton = new TextButton("Revert", new SelectEvent.SelectHandler() {

            public void onSelect(SelectEvent event) {
                onRevert();
            }
        });
        this.editorWidgetsMapper = new EditorWidgetsMapper(componentFactory);
        editorTabs = Sets.newLinkedHashSet();
        editorTabs.add(new PropertiesEditorPanel(editorWidgetsMapper));
        editorTabs.add(new LayoutEditorPanel(editorWidgetsMapper));
    }

    private Widget createTabPanel() {
        PlainTabPanel tabPanel = new PlainTabPanel();
        for (AbstractEditorTab abstractEditorTab : editorTabs) {
            tabPanel.add(abstractEditorTab, abstractEditorTab.getTabItemConfig());
        }
        return tabPanel;
    }

    private Widget createButtonBar() {
        HBoxLayoutContainer out = new HBoxLayoutContainer();
        BoxLayoutContainer.BoxLayoutData applyBoxLayoutData = new BoxLayoutContainer.BoxLayoutData();
        applyBoxLayoutData.setFlex(1);
        out.add(applyButton, applyBoxLayoutData);
        out.add(deleteButton, new BoxLayoutContainer.BoxLayoutData(new Margins(0, 0, 0, 5)));
        out.add(revertButton, new BoxLayoutContainer.BoxLayoutData(new Margins(0, 0, 0, 5)));
        return out;
    }

    public void setupEditorsForComponent(Widget object) {
        setEditorsWidgetFor(object);
        bindEditorsTo(object);
        onRevert();
        processButtonsDisability();
    }

    private void setEditorsWidgetFor(Widget object) {
        for (AbstractEditorTab abstractEditorTab : editorTabs) {
            abstractEditorTab.setEditorWidgetFor(object);
        }
    }

    private void bindEditorsTo(Widget object) {
        for (AbstractEditorTab abstractEditorTab : editorTabs) {
            abstractEditorTab.bindEditorTo(object);
        }
    }

    public void onSubmit() {
        for (AbstractEditorTab abstractEditorTab : editorTabs) {
            abstractEditorTab.applyToSource();
        }
    }

    public void onRevert() {
        for (AbstractEditorTab abstractEditorTab : editorTabs) {
            abstractEditorTab.revertEditorValue();
        }
    }

    private void onDelete() {
        mainPanel.removeCurrentlySelectedComponent();
    }

    private void processButtonsDisability() {
        boolean hasPropertiesToEdit = false;
        for (AbstractEditorTab abstractEditorTab : editorTabs) {
            hasPropertiesToEdit = hasPropertiesToEdit || abstractEditorTab.hasPropertiesToEdit();
        }
        setButtonsEnable(hasPropertiesToEdit);
    }

    private void setButtonsEnable(boolean enable) {
        applyButton.setEnabled(enable);
        deleteButton.setEnabled(enable);
        revertButton.setEnabled(enable);
    }

}
