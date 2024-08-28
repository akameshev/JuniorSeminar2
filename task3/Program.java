package task3;

import java.util.UUID;

public class Program {
    public static void main(String[] args) throws IllegalAccessException {
        Employee user = new Employee("Stanislav", "stas@mail.ru");
        UUID pk = UUID.randomUUID();
        user.setId(pk);

        QueryBuilder queryBuilder = new QueryBuilder();
        String insertQuery = queryBuilder.buildInsertQuery(user);
        String selectQuery = queryBuilder.buildSelectQuery(Employee.class,pk);
        System.out.printf("Insert query: %s\n",insertQuery);
        System.out.println(selectQuery);
    }
}
