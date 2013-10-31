package pl.pkosmowski.gxtshowcase.client.palete;

import com.google.common.base.Function;
import com.google.common.collect.FluentIterable;
import pl.pkosmowski.gxtshowcase.client.widget.ObjectAccessor;
import com.google.common.collect.Sets;
import com.sencha.gxt.widget.core.client.button.TextButton;
import java.util.Set;
import pl.pkosmowski.gxtshowcase.client.ComponentFactory;
import pl.pkosmowski.gxtshowcase.client.ObjectUtils;

/**
 *
 * @author Piotr Kosmowski
 */
public class Palete {

    private Set<PaleteButton> paleteElements = Sets.newLinkedHashSet();

    public Palete(ComponentFactory componentFactory) {
        paleteElements = FluentIterable.from(componentFactory.getAllElements()).transform(new Function<ObjectAccessor, PaleteButton>() {

            public PaleteButton apply(ObjectAccessor input) {
                String buttonName = ObjectUtils.getClassShortName(input.getEditor().getType());
                return new PaleteButton(buttonName, input);
            }
        }).toSet();

    }

    public Set<PaleteButton> getPaleteElements() {
        return paleteElements;
    }

    public void setDisabilityToAllButtons(boolean toDisable) {
        for (PaleteButton paleteElement : paleteElements) {
            paleteElement.setEnabled(!toDisable);
        }
    }

}
