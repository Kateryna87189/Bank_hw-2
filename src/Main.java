import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
У вас в программе есть класс: Account (Банковский счет: String iban; BigDecimal balance; Person owner).
Пусть дана Map, где ключ это Person, значение список счетов данного Person.
Необходимо написать метод, который проверит есть ли в данной Map ошибки,
т.е.есть ли счета, записанные по неправильному ключу.
 */
public class Main {
    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("Джон", "Сноу", 36),
                new Person("Віктор", "Цой", 68),
                new Person("Пол", "Маккартні", 54),
                new Person("Джекі", "Чан", 75)
        );
       // System.out.println(people);
        List<Account> accounts = List.of(
                new Account("DE1234567890", new BigDecimal("100.00"), people.get(0)),
                new Account("DE0987654321", new BigDecimal("2000000.00"), people.get(1)),
                new Account("DE1111111111", new BigDecimal("1500877.00"), people.get(2)),
                new Account("DE2222222222", new BigDecimal("5000000.00"), people.get(3)),
                new Account("DE3333333333", new BigDecimal("7015000.00"), people.get(0))
        );
       // System.out.println(accounts);
        Map<Person, List<Account>> personsAccountsMap = new HashMap<>();
        addAccountsToPerson(personsAccountsMap, people, accounts);

        System.out.println("Список Клієнтв: ");
        for (Person person:people){
            System.out.println(person);
        }

        System.out.println("Список акаунтів: ");
        for (Account account:accounts){
            System.out.println(account);
        }

        boolean hassErrors = checkForErrors(personsAccountsMap);
        System.out.println("мар має помилку: " + hassErrors);
    }

    // Метод для додавання акаунтів до мапи
    public static void addAccountsToPerson(Map<Person, List<Account>> map, List<Person> people, List<Account> accounts) {
        for (Person person : people) {
            map.put(person, new ArrayList<>());
        }
        for (Account account : accounts) {
            Person owner = account.getOwner();
            if (map.containsKey(owner)) {
                map.get(owner).add(account);
            }
        }
    }

    public static boolean checkForErrors(Map<Person, List<Account>> map) {

        for (Map.Entry<Person, List<Account>> entry : map.entrySet()) {
            Person people = entry.getKey();
            for (Account account : entry.getValue()) {
                if (!account.getOwner().equals(people)) {

                    return  true;
                }
            }
        }
        return false;
    }
}