import java.util.*;
import java.util.concurrent.*;

class Item {
    String name;
    int weight;

    public Item(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }
}

class Mover implements Callable<List<Item>> {
    private final List<Item> items;
    private final int maxWeight;

    public Mover(List<Item> items, int maxWeight) {
        this.items = items;
        this.maxWeight = maxWeight;
    }

    @Override
    public List<Item> call() {
        List<Item> carriedItems = new ArrayList<>();
        int currentWeight = 0;
        
        for (Item item : items) {
            if (currentWeight + item.weight <= maxWeight) {
                carriedItems.add(item);
                currentWeight += item.weight;
            } else {
                break;
            }
        }
        
        return carriedItems;
    }
}

public class Warehouse {
    private static final int MAX_WEIGHT = 150;
    private static final int LOADERS = 3;

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Item1", 50));
        items.add(new Item("Item2", 30));
        items.add(new Item("Item3", 80));
        items.add(new Item("Item4", 60));
        items.add(new Item("Item5", 40));
        items.add(new Item("Item6", 90));
        items.add(new Item("Item7", 20));
        items.add(new Item("Item8", 70));
        items.add(new Item("Item9", 10));

        ExecutorService executor = Executors.newFixedThreadPool(LOADERS);
        CompletionService<List<Item>> completionService = new ExecutorCompletionService<>(executor);
        List<List<Item>> dividedItems = divideItems(items, LOADERS);

        for (List<Item> itemList : dividedItems) {
            completionService.submit(new Mover(itemList, MAX_WEIGHT));
        }

        for (int i = 0; i < LOADERS; i++) {
            Future<List<Item>> future = completionService.take();
            List<Item> carriedItems = future.get();
            System.out.println("Gryzchik " + (i + 1) + " Neset: " + carriedItems.size() + " total: " +
                    carriedItems.stream().mapToInt(item -> item.weight).sum() + " kg.");
        }

        executor.shutdown();
    }

    private static List<List<Item>> divideItems(List<Item> items, int numHandlers) {
        List<List<Item>> dividedItems = new ArrayList<>();
        int itemsPerHandler = items.size() / numHandlers;

        for (int i = 0; i < numHandlers; i++) {
            int start = i * itemsPerHandler;
            int end = (i == numHandlers - 1) ? items.size() : (i + 1) * itemsPerHandler;
            dividedItems.add(items.subList(start, end));
        }
        return dividedItems;
    }
}
