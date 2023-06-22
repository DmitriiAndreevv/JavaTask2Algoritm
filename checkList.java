import java.util.Iterator;
public class checkList {

    public static void main(String[] args) {
        SingleLinkList<Contact> contactList = new SingleLinkList<>();

        contactList.addToEnd(new Contact(1, "Иванов Михаил Павлович", "+79022742244", "mihalPall@mailcom"));
        contactList.addToEnd(new Contact(2, "Ибрагимов Анур Ибрагамович", "+79224443244", "simanan@mailcom"));
        contactList.addToEnd(new Contact(3, "Симонова Анна Олеговна", "+79535396642", "slonkov@mailcom"));
        contactList.addToEnd(new Contact(4, "Савина Ирина Михайловна", "+79995477421", "savinall@mailcom"));
        contactList.addToEnd(new Contact(5, "Салтыков Павел Семенович", "+79522782264", "saltikov@mailcom"));

        for (Object contact : contactList) {
            System.out.println(contact);
        }
        contactList.reverse();

        System.out.println("______________________________________________________________________________________________________");

        for (Object contact : contactList) {
            System.out.println(contact);
        }
    }

    static class Contact {
        int id;
        String name;
        String phone;
        String email;

        public Contact(int id, String name, String phone, String email) {
            this.id = id;
            this.name = name;
            this.phone = phone;
            this.email = email;
        }

        @Override
        public String toString() {
            return "Contact{" +  "id: " + id +  ", Full name :" + name + '\'' +  ", phone number :" + phone + '\'' + ", email='" + email + '\'' + '}';
        }
        }

        /**
         * Класс списка
         *
         * @param <T>
         */

        public static class SingleLinkList<T> implements Iterable {
            ListItem<T> head;
            ListItem<T> tail;

            @Override
            public Iterator iterator() {
                return new Iterator<T>() {
                    ListItem<T> current = head;

                    @Override
                    public boolean hasNext() {
                        return current != null;
                    }

                    @Override
                    public T next() {
                        T data = current.data;
                        current = current.next;
                        return data;
                    }
                };
            }
/**
 * Класс отдельного элемента
 *
 * @param <T>
 */
        private static class ListItem<T> {
            T data;
            ListItem<T> next;
        }

// Проверка на то, пустая ли голова
        public boolean isEmpty() {
            return head == null;
        }

        // Заполнение списка
        public void addToEnd(T item) {
// Выделение памяти для списка

            ListItem<T> newItem = new ListItem<>();
            newItem.data = item;

// Если голова и хвост пустая, то присваеваем newItem
            if (isEmpty()) {
                head = newItem;
                tail = newItem;

// Если не пустая, то передаём элементу адрес и ставим его в хвост
            } else {
                tail.next = newItem;
                tail = newItem;
            }
        }

// Метод разворота списка
        public void reverse() {
            if (!isEmpty() && head.next != null) { // Если не пусто и голова не равна нулю
                tail = head;
                ListItem<T> current = head.next;
                head.next = null;
                while (current != null) {
                    ListItem<T> next = current.next;
                    current.next = head;
                    head = current;
                    current = next;
                }
            }
        }
    }
}