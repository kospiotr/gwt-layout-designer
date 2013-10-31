package pl.pkosmowski.gxtshowcase.client;

import com.google.common.collect.Maps;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import pl.pkosmowski.gxtshowcase.client.widget.ObjectAccessor;

/**
 *
 * @author Piotr Kosmowski
 */
public class EditorWidgetsMapper {

    private static final Logger logger = Logger.getLogger(EditorWidgetsMapper.class.getName());
    private Map<String, EditorPanel<?>> editorPanelsMaping = Maps.newHashMap();

    public EditorWidgetsMapper(ComponentFactory componentFactory) {
        for (ObjectAccessor widgetElement : componentFactory.getAllElements()) {
            String name = ObjectUtils.getClassFullName(widgetElement.getEditor().getType());
            editorPanelsMaping.put(name, new EditorPanel(widgetElement.getEditor()));
        }
    }

    public EditorPanel<?> getPropertiesEditorForType(Class<?> type) {
        EditorPanel<?> foundPropertyEditor = editorPanelsMaping.get(ObjectUtils.getClassFullName(type));
        return foundPropertyEditor != null ? foundPropertyEditor : new EmptyEditorWidget();
    }

    EditorPanel<?> getLayoutsEditorForType(Class<? extends Object> type) {
        return new EmptyEditorWidget();
    }

}
