import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NewClass {

    private List<String> items;
    private List<Object> cachedObjects;

    public ProblemNewClassaticClass() {
        items = new ArrayList<>();
        cachedObjects = new ArrayList<>();
    }

    public void populateItems() {
        if (new Random().nextBoolean()) {
            for (int i = 0; i < 10; i++) {
                items.add("Item " + i);
            }
        }
    }

    public void clearItems() {
        items = null;
    }

    public void cacheData() {
        for (int i = 0; i < 100; i++) {
            Object obj = new Object();
            cachedObjects.add(obj);
        }
    }

    public int calculateSum() {
        Object value = getRandomObject();
        if (value instanceof Integer) {
            return (Integer) value;
        } else {
            return 0;
        }
    }

    private Object getRandomObject() {
        if (new Random().nextBoolean()) {
            return "Not an Integer";
        } else {
            return new Random().nextInt(100);
        }
    }

    public void simulateOperations() {
        cacheData();
        populateItems();
        clearItems();

        if (new Random().nextInt(10) > 5) {
            System.out.println(items.size());
        }

        int sum = calculateSum();
        System.out.println("Calculated sum: " + sum);
    }

    public static void main(String[] args) {
        NewClass pc = new NewClass();

        for (int i = 0; i < 100; i++) {
                pc.simulateOperations();
        }
    }
}
