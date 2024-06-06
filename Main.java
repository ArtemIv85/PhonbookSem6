import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;

class PhoneBook {
    private static HashMap<String, ArrayList<Integer>> phoneBook = new HashMap<>();

    public void add(String name, Integer phoneNum) {

// Добавление нового номера
        if (phoneBook.get(name)!= null){ // если такой человек уже есть то добавляем к нему еще номер
            phoneBook.get(name).add(phoneNum);
        }
        else{
            // Если такого человека нет, то создаем нового и добавлем к нему номер
            phoneBook.put(name, new ArrayList<>());
            phoneBook.get(name).add(phoneNum);
        }

    }

    public void delnumber(String name,Integer phoneNum){
    //удаление номера у человека
        if (phoneBook.get(name)!=null){
            phoneBook.get(name).remove(phoneNum);
        }else{
            System.out.printf("Даннаго человека или номера нет в базе");
        }
    }


    public ArrayList<Integer> find(String name) {
// Введите свое решение ниже
        if (phoneBook.get(name)!=null){
            return phoneBook.get(name);
        }else{
            return new ArrayList<Integer>();
        }
    }
    public static HashMap<String, ArrayList<Integer>> getPhoneBook() {
// Вывод телефонной книги
        return phoneBook;
    }
}
// Не удаляйте этот класс - он нужен для 

public class Main {
    public static void main(String[] args) {


        PhoneBook myPhoneBook = new PhoneBook();
        myPhoneBook.add("Иванов", 111);
        myPhoneBook.add("Иванов", 222);
        myPhoneBook.add("Петров", 333);
        myPhoneBook.add("Макаренко", 444);
        myPhoneBook.add("Сталин", 555);
        myPhoneBook.add("Гитлер", 666);
        myPhoneBook.add("Петров", 777);
        myPhoneBook.add("Петров", 888);
        myPhoneBook.add("Сталин", 999);

//Вывод всех номеров конкретного человека
        String str1="Петров";
        System.out.println("Все номера пользователя "+str1+": ");
        System.out.println(myPhoneBook.find(str1));

// Вывод всей книги
        System.out.println(PhoneBook.getPhoneBook());


        // Удаление номера пользователя без удаления самого пользователя и вывод на экран
        myPhoneBook.delnumber("Гитлер",666);
        System.out.println(PhoneBook.getPhoneBook());
    }
}