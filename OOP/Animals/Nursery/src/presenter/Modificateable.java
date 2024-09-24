package presenter;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
public @interface Modificateable {
    // Set if needs to modificate when project extends
}
