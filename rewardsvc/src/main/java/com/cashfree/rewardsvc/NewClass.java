import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class NewClass {

    private List<String> items;
    private List<Object> cachedObjects;
    private SecureRandom secureRandom;

    public NewClass() {
        items = new ArrayList<>();
        cachedObjects = new ArrayList<>();
        secureRandom = new SecureRandom();
    }

    public void populateItems() {
        if (secureRandom.nextBoolean()) {
            for (int i = 0; i < 10; i++) {
                items.add("Item " + i);
            }
        }
    }

    public void clearItems() {
        items.clear();
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
        }
        return 0;
    }

    private Object getRandomObject() {
        if (secureRandom.nextBoolean()) {
            return "Not an Integer";
        }
        return secureRandom.nextInt(100);
    }

    public void simulateOperations() {
        cacheData();
        populateItems();
        clearItems();

        if (secureRandom.nextInt(10) > 5 && items != null) {
            System.out.println(items.size());
        }

        int sum = calculateSum();
        System.out.println("Calculated sum: " + sum);
    }

    public static void main(String[] args) {
        NewClass nc = new NewClass();

        for (int i = 0; i < 100; i++) {
            try {
                nc.simulateOperations();
            } catch (NullPointerException e) {
                System.out.println("Caught a NullPointerException: " + e.getMessage());
            } catch (ClassCastException e) {
                System.out.println("Caught a ClassCastException: " + e.getMessage());
            }
        }
    }
}