package pl.pkosmowski.gxtshowcase.client.navigator;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;
import pl.pkosmowski.gxtshowcase.client.ObjectUtils;

/**
 *
 * @author Piotr Kosmowski
 */
public class ComponentNameCounter {

    Multiset<String> myMultiset = HashMultiset.create();

    public String getNameFor(Class<?> clazz) {
        String shortName = ObjectUtils.getClassShortName(clazz);

        myMultiset.add(shortName);
        return shortName+"_"+myMultiset.count(shortName);
    }


}
