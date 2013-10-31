package pl.pkosmowski.gxtshowcase.client;

import com.google.gwt.user.client.ui.Widget;

/**
 *
 * @author Piotr Kosmowski
 */
public class PropertiesEditorPanel extends AbstractEditorTab {

    public PropertiesEditorPanel(EditorWidgetsMapper editorWidgetsMapper) {
        super(editorWidgetsMapper, "Properties");
    }

    @Override
    protected void setEditorWidgetFor(Widget widget) {
        setEditorWidgetAndDisplayIt(getEditorWidgetsMapper().getPropertiesEditorForType(widget.getClass()));
    }
}
