package task3;

import java.lang.reflect.Field;
import java.util.UUID;

public class QueryBuilder {
    public String buildInsertQuery(Object object) throws IllegalAccessException {
        Class<?> clazz = object.getClass();
        StringBuilder query = new StringBuilder("INSERT INTO ");

        if (clazz.isAnnotationPresent(Table.class)) {
            Table tableAnnotation = clazz.getAnnotation(Table.class);
            query
                    .append(tableAnnotation.name())
                    .append(" (");

            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(Column.class)) {
                    Column columnAnnotation = field.getAnnotation(Column.class);
                    query.append(columnAnnotation.name()).append(", ");
                }
            }
            if (query.charAt(query.length() - 2) == ',') {
                query.delete(query.length() - 2, query.length());
            }
            query.append(") VALUES (");
            for (Field field : fields) {
                if (field.isAnnotationPresent(Column.class)) {
                    field.setAccessible(true);
                    query
                            .append("'")
                            .append(field.get(object))
                            .append("', ");
                }
            }
            if (query.charAt(query.length() - 2) == ',') {
                query.delete(query.length() - 2, query.length());
            }
            query.append(")");
            return query.toString();
        } else {
            return null;
        }
    }
    public String buildSelectQuery(Class<?>clazz, UUID primaryKey){
        StringBuilder query = new StringBuilder("SELECT * FROM ");
        if (clazz.isAnnotationPresent(Table.class)){
            Table tableAnnotation = clazz.getAnnotation(Table.class);
            query.append(tableAnnotation.name()).append(" WHERE ");
        }
        Field [] fields = clazz.getDeclaredFields();
        for (Field field:fields){
            if (field.isAnnotationPresent(Column.class)){
                Column columnAnnotation = field.getAnnotation(Column.class);
                if (columnAnnotation.primaryKey()){
                    query.append(columnAnnotation.name()).append(" = ").append(primaryKey);
                    break;
                }
            }
        }
        return query.toString();
    }
}
