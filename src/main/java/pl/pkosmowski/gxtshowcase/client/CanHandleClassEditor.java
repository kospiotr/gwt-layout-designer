package pl.pkosmowski.gxtshowcase.client;

import pl.pkosmowski.gxtshowcase.client.editor.ClassEditor;

/**
 *
 * @author Piotr Kosmowski
 */
interface CanHandleClassEditor {

    ClassEditor<?> getPropertyEditor();

    void setPropertyEditorWidget(EditorPanel<?> propetyEditorWidget);
}
