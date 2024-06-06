import java.io.PrintStream;
import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Stream;

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
// Поиск по имени
        if (phoneBook.get(name)!=null){
            return phoneBook.get(name);
        }else{
            return new ArrayList<Integer>();
        }
    }
    public static  void getPhoneBook() {
// Вывод телефонной книги
        Map<Integer, ArrayList<String>> SortName = new TreeMap<>(Collections.reverseOrder());// создаем упорядоченную мапу по количеству телефонов

        for (HashMap.Entry<String, ArrayList<Integer>> entry : phoneBook.entrySet()) {
            if (SortName.get(entry.getValue().size()) != null) {
                SortName.get(entry.getValue().size()).add(entry.getKey());
            } else {
                // Если такого человека нет, то создаем нового и добавлем к нему номер
                SortName.put(entry.getValue().size(), new ArrayList<>());
                SortName.get(entry.getValue().size()).add(entry.getKey());
            }
                //В результате получили отсортированную Мапу в обратном порядке

            }// конец сортировки по количеству номеров
//Используя порядок TreeMap по значениям реализуем вывод всех номеров пользователя от большего к меньшему
        for (Map.Entry<Integer,ArrayList<String>> entry : SortName.entrySet()){
            for (int i=0;i<entry.getValue().size();i++){
                System.out.println(entry.getValue().get(i)+" Номера:");
                System.out.println(phoneBook.get(entry.getValue().get(i)));

            }

        }



        }




}


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
        System.out.println("Вывод всей книги по количеству телефонов по убыванию");
        PhoneBook.getPhoneBook();
        System.out.println("Конец вывода");


        // Удаление номера пользователя без удаления самого пользователя и вывод на экран
        System.out.println("Удаление номера у пользователя Гитлер и вывод на экран справочника");
        myPhoneBook.delnumber("Гитлер",666);
        PhoneBook.getPhoneBook();
    }
}