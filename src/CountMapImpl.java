
import java.util.HashMap;
import java.util.Map;

public class CountMapImpl<T> implements CountMap<T>{

    private Map<T, Integer> map = new HashMap<>();

    @Override
    public void add(T t) {
        Integer n = map.getOrDefault(t, 0);
        map.put(t, ++n);
    }

    @Override
    public int getCount(T t) {
        return map.getOrDefault(t, 0);
    }

    @Override
    public int remove(T t) {
        int count = map.getOrDefault(t, 0);
        map.remove(t);
        return count;
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public void addAll(CountMap<? extends T> source) {
        for (Map.Entry entry : source.toMap().entrySet()) {
            Integer val = (map.getOrDefault(entry.getKey(), 0));
            map.put((T) entry.getKey(), (Integer) entry.getValue() + val);
        }
    }

    @Override
    public Map<T, Integer> toMap() {
        return map;
    }

    @Override
    public void toMap(Map<T, Integer> destination) {
        destination.putAll(map);
    }

    @Override
    public String toString() {
        return "CountMapImpl{" +
                "map=" + map +
                '}';
    }
}
