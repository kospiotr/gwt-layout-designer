
package pl.pkosmowski.gxtshowcase.client.editor;

import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.container.Container;

/**
 *
 * @author Piotr Kosmowski
 */
public class HierarchyKeeper {
    
    public static void addChild(Widget parent, Widget child) {
        if(parent instanceof Container){
            ((Container)parent).add(child); 
        }
    }
    
}
