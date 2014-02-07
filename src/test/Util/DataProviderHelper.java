package Util;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: nkornilova
 * Date: 08.07.13
 * Time: 16:58
 * To change this template use File | Settings | File Templates.
 */
public class DataProviderHelper {
    public static Map<String, String> getDataProviderParams(Method testMethod) throws Exception
    {
        if (testMethod == null)
            throw new IllegalArgumentException("Test Method context cannot be null.");

        DataProviderParams args = testMethod.getAnnotation(DataProviderParams.class);

        if (args == null || args.value() == null || args.value().length == 0) throw new IllegalArgumentException();

        Map<String, String> params = new HashMap<String, String>();

        for (String value : args.value()) {
            for (String part : value.split(";")) {
                String[] parts = part.split("=");
                params.put(parts[0], parts[1]);
            }

        }

        return params;
    }
}
