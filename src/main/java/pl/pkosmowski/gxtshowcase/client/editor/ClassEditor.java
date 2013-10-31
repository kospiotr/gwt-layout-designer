package pl.pkosmowski.gxtshowcase.client.editor;

import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.form.Field;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Piotr Kosmowski
 */
public class ClassEditor<T> {

    private Map<String, EditablePropertyProxy<T, ?>> editablePropertiesProxy;
    private Map<String, Field<?>> fieldsEditors;
    private T source;
    private Class<T> type;

    public ClassEditor(Class<T> type) {
        this.type = type;
        this.editablePropertiesProxy = new HashMap<String, EditablePropertyProxy<T, ?>>();
        this.fieldsEditors = new HashMap<String, Field<?>>();
    }

    public <V> void addProperty(EditablePropertyProxy<T, V> propertyProxy) {
        this.editablePropertiesProxy.put(propertyProxy.getName(), propertyProxy);
        this.fieldsEditors.put(propertyProxy.getName(), propertyProxy.getEditor());
    }

    public Map<String, Field<?>> getFieldsEditors() {
        return fieldsEditors;
    }

    public void bind(T source) {
        this.source = source;
    }

    public void applyToSource() {
        for (Map.Entry<String, EditablePropertyProxy<T, ?>> entry : editablePropertiesProxy.entrySet()) {
            entry.getValue().applyToSource(source);
        }
    }

    public void revertEditorValue() {
        for (Map.Entry<String, EditablePropertyProxy<T, ?>> entry : editablePropertiesProxy.entrySet()) {
            entry.getValue().revertEditorValue(source);
        }
    }

    public void bindObject(Object widget) {
        this.source = (T) widget;
    }

    public Class<T> getType() {
        return type;
    }

}
