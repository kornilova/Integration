package Util;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created with IntelliJ IDEA.
 * User: nkornilova
 * Date: 08.07.13
 * Time: 16:58
 * To change this template use File | Settings | File Templates.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface DataProviderParams {
    String[] value();
}
