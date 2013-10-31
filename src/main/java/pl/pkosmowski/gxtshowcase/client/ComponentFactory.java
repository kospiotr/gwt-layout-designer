package pl.pkosmowski.gxtshowcase.client;

import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import pl.pkosmowski.gxtshowcase.client.components.TextButtonComponent;
import pl.pkosmowski.gxtshowcase.client.components.VerticalLayoutContainerComponent;
import pl.pkosmowski.gxtshowcase.client.widget.WidgetContainer;
import pl.pkosmowski.gxtshowcase.client.widget.WidgetComponent;
import com.google.common.collect.Sets;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import pl.pkosmowski.gxtshowcase.client.widget.ObjectAccessor;

/**
 *
 * @author Piotr Kosmowski
 */
public class ComponentFactory {

    private static final Logger logger = Logger.getLogger(ComponentFactory.class.getName());
    private Set<WidgetContainer> containers;
    private Set<WidgetComponent> components;

    public ComponentFactory() {
        this.components = Sets.newLinkedHashSet();
        this.containers = Sets.newLinkedHashSet();
        initContainers();
        initComponents();
        logger.log(Level.INFO, "Initialized: " + getAllElements().size());
    }

    public Set<ObjectAccessor> getAllElements() {
        LinkedHashSet<ObjectAccessor> out = new LinkedHashSet<ObjectAccessor>();
        out.addAll(containers);
        out.addAll(components);
        return out;
    }

    private void initContainers() {
        containers.add(new VerticalLayoutContainerComponent());
    }

    private void initComponents() {
        components.add(new TextButtonComponent());
    }

}
