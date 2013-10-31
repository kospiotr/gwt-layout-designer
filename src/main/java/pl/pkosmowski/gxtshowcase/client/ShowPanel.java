
package pl.pkosmowski.gxtshowcase.client;

import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.Composite;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.container.FlowLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;


public class ShowPanel extends Composite{

    private ContentPanel contentPanel;
    private VerticalLayoutContainer verticalLayoutContainer;
    private FlowLayoutContainer currentSection;
            
    public ShowPanel() {
        this.contentPanel = new ContentPanel();
        this.verticalLayoutContainer = new VerticalLayoutContainer();
        contentPanel.add(verticalLayoutContainer);
        initWidget(contentPanel);
    }

    public void setHeadingText(String text) {
        contentPanel.setHeadingText(text);
    }
    
    public void addToSection(Widget widget){
        if(currentSection == null){
            createNewSection();
        }
        currentSection.add(widget);
    }

    public void createNewSection() {
        currentSection = new FlowLayoutContainer();
        verticalLayoutContainer.add(currentSection, new VerticalLayoutContainer.VerticalLayoutData(1, -1));
    }

    
}
