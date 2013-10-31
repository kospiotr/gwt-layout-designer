package pl.pkosmowski.gxtshowcase.client;

/**
 *
 * @author Piotr Kosmowski
 */
public class ObjectUtils {

    public static String getClassShortName(Class<?> clazz) {
        String fullName = getClassFullName(clazz);
        String shortName = fullName.substring(fullName.lastIndexOf('.') + 1);
        return shortName;
    }

    public static String getClassFullName(Class<?> clazz) {
        return clazz.getName();
    }
}
