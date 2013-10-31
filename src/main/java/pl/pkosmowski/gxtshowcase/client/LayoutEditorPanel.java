package pl.pkosmowski.gxtshowcase.client;

import com.google.gwt.user.client.ui.Widget;

/**
 *
 * @author Piotr Kosmowski
 */
public class LayoutEditorPanel extends AbstractEditorTab {

    public LayoutEditorPanel(EditorWidgetsMapper editorWidgetsMapper) {
        super(editorWidgetsMapper, "Layout");
    }

    @Override
    protected void setEditorWidgetFor(Widget widget) {
        setEditorWidgetAndDisplayIt(getEditorWidgetsMapper().getLayoutsEditorForType(widget.getClass()));
    }
}
