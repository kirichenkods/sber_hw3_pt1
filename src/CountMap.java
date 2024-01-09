
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public interface CountMap<T> {
    // добавляет элемент в этот контейнер.
    void add(T t);

    //Возвращает количество добавлений данного элемента
    int getCount(T t);

    //Удаляет элемент и контейнера и возвращает количество его добавлений(до удаления)
    int remove(T t);

    //количество разных элементов
    int size();

    //Добавить все элементы из source в текущий контейнер,
    // при совпадении ключей,     суммировать значения
    void addAll(CountMap<? extends T> source);

    //Вернуть java.util.Map. ключ - добавленный элемент,
    // значение - количество его добавлений
    Map<T, Integer> toMap();

    //Тот же самый контракт как и toMap(), только всю информацию записать в destination
    void toMap(Map<T, Integer> destination);

    public static void main(String[] args) {
        CountMap<Integer> map = new CountMapImpl<>();

        map.add(10);
        map.add(10);
        map.add(5);
        map.add(6);
        map.add(5);
        map.add(10);

//        int count = map.getCount(5); // 2
        int count = map.getCount(6); // 1
//        int count = map.getCount(10); // 3
        System.out.println(map);
        System.out.println(count);
        System.out.println(map.getCount(11));
        System.out.println(map.remove(5));
        System.out.println(map);
        System.out.println(map.getCount(6));
        System.out.println(map.size());


    }
}
