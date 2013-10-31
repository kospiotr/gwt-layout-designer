package pl.pkosmowski.gxtshowcase.client.factories;

import com.sencha.gxt.widget.core.client.form.CheckBox;
import com.sencha.gxt.widget.core.client.form.Field;
import com.sencha.gxt.widget.core.client.form.TextField;

/**
 *
 * @author Piotr Kosmowski
 */
public class EditorFieldFactory {

    public <T> Field<T> createField(Class<T> clazz) {
        if (clazz.getName().equals(String.class.getName())) {
            return (Field<T>) new TextField() {
                {
                    setValue("");
                }
            };
        }
        if (clazz.getName().equals(Boolean.class.getName())) {
            return (Field<T>) new CheckBox() {
                {
                    setValue(true);
                }
            };
        }
        throw new RuntimeException("Could not create field for class: " + clazz);
    }

}
