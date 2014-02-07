package com.estylesoft.integration.Model;

import com.estylesoft.integration.Database.mybatis.MyBatisSqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Nataliya.Gordeeva
 * Date: 28.01.14
 * Time: 18:55
 * To change this template use File | Settings | File Templates.
 */
public class ModelBase {

    @DataField(xlsFieldName = "TEST_ID")
    private String dataTestId;

    public String getDataTestId() {
        return dataTestId;
    }

    public void setDataTestId(String dataTestId) {
        this.dataTestId = dataTestId;
    }


    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    protected @interface DataField {
        String xlsFieldName() default "";
    }

    private static List<Field> getAllFields(List<Field> fields, Class<?> type) {
        Collections.addAll(fields, type.getDeclaredFields());

        if (type.getSuperclass() != null) {
            fields = getAllFields(fields, type.getSuperclass());
        }

        return fields;
    }

    public ModelBase setFields(Map<String, String> fieldData) {
        List<Field> fields = getAllFields(new ArrayList<Field>(), this.getClass());
        String fieldName = null, fieldValue;
        boolean isExist;
        boolean wasAccessible;
        for (Field field : fields) {
            isExist = false;
            if (field.isAnnotationPresent(DataField.class)) {
                if (fieldData.containsKey(field.getAnnotation(DataField.class).xlsFieldName())) {
                    isExist = true;
                    fieldName = field.getAnnotation(DataField.class).xlsFieldName();
                }
            } else if (fieldData.containsKey(field.getName())) {
                isExist = true;
                fieldName = field.getName();
            }
            if (isExist) {
                try {
                    fieldValue = fieldData.get(fieldName);
                    if (fieldValue != null) {
                        wasAccessible = field.isAccessible();
                        field.setAccessible(true);

                        if (field.getType().equals(String.class)) {
                            field.set(this, fieldData.get(fieldName));

                        } else if (field.getType().equals(Integer.class) || field.getType().equals(int.class)) {
                            Integer result = Integer.parseInt(fieldValue);
                            field.set(this, result);

                        } else if (field.getType().equals(Double.class) || field.getType().equals(double.class)) {
                            Double result = Double.parseDouble(fieldValue);
                            field.set(this, result);

                        } else if (field.getType().equals(Long.class) || field.getType().equals(long.class)) {
                            Long result = Long.parseLong(fieldValue);
                            field.set(this, result);

                        } else if (field.getType().equals(Boolean.class) || field.getType().equals(boolean.class)) {
                            if (fieldValue.equals("1") || fieldValue.equals("true")) {
                                field.set(this, true);
                            } else if (fieldValue.equals("0") || fieldValue.toLowerCase().equals("false")) {
                                field.set(this, false);
                            }
                        }
                        field.setAccessible(wasAccessible);
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                    continue;
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    continue;
                }

            }
        }
        return this;
    }
}
