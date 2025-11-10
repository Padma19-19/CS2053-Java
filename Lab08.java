//Lab Session:8 (Generics, autoboxing, wrapper classes, collections)
import java.util.ArrayList;

class Box<T> {
    private ArrayList<T> items = new ArrayList<>();

    public void addItem(T item) {
        items.add(item);
    }

    public void displayItems() {
        System.out.println("Box contains:");
        for (T item : items) {
            System.out.println("- " + item);
        }
    }
}

public class Lab 8 {
    public static void main(String[] args) {

        Box<Integer> intBox = new Box<>();
        intBox.addItem(10);
        intBox.addItem(25);
        intBox.addItem(50);
        System.out.println(" Integer Box:");
        intBox.displayItems();

        Box<Double> doubleBox = new Box<>();
        doubleBox.addItem(15.5);
        doubleBox.addItem(42.9);
        System.out.println("\n Double Box:");
        doubleBox.displayItems();

        Box<String> stringBox = new Box<>();
        stringBox.addItem("Apples");
        stringBox.addItem("Bananas");
        stringBox.addItem("Oranges");
        System.out.println("\n String Box:");
        stringBox.displayItems();
    }
}
