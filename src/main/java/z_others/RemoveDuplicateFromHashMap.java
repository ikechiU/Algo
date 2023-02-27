package z_others;

import java.util.HashMap;
import java.util.Map;

public class RemoveDuplicateFromHashMap {
    public static void main(String[] args) {
        HashMap<Integer, String> car = new HashMap<>();
        car.put(1, "Toyota");
        car.put(2, "Mercedes");
        car.put(3, "Toyota");
        car.put(4, "Hyundai");

        HashMap<Integer, String> carType = new HashMap<>();
        for (Map.Entry<Integer, String> map: car.entrySet()) {
            var key = map.getKey();
            var value = map.getValue();

            if (!carType.containsValue(value)) {
                carType.put(key, value);
            }
        }

        System.out.println(car);
        System.out.println(carType);

//        Thread thread = new Thread(() ->{});
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });
        thread.start();
    }
}
