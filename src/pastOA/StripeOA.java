package pastOA;

import java.util.*;

public class StripeOA {
    static List<Integer> balance(List<String> lines) {
        List<Integer> res = new ArrayList<>();
        HashMap<String, Integer> balance = new HashMap<>();
        for (String line : lines) {
            if (line.startsWith("API")) {
                HashMap<String, String> map = new HashMap<>();
                String[] parts = line.substring(5).split("&");
                for (String part : parts) {
                    String[] small = part.split("=");
                    map.put(small[0], small[1]);
                }
                int amount = Integer.valueOf(map.get("amount"));
                int realAmount = amount - ((int) Math.round(amount / 100 * 2.9) + 30);
                if (map.containsKey("destination[account]") && map.containsKey("destination[amount]")) {
                    int amountD = Integer.valueOf(map.get("destination[amount]"));
                    int amountM = realAmount - amountD;
                    String idM = map.get("merchant");
                    String idD = map.get("destination[account]");
                    if (!balance.containsKey(idM)) {
                        balance.put(idM, 0);
                    }
                    if (!balance.containsKey(idD)) {
                        balance.put(idD, 0);
                    }
                    balance.put(idM, balance.get(idM) + amountM);
                    balance.put(idD, balance.get(idD) + amountD);
                } else {
                    String id = map.get("merchant");
                    if (!balance.containsKey(id)) {
                        balance.put(id, 0);
                    }
                    balance.put(id, balance.get(id) + realAmount);
                }
            } else {
                String merchant = line.substring(5).split("=")[1];
                if(balance.containsKey(merchant)) {
                    res.add(balance.get(merchant));
                } else {
                    res.add(0);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        StripeOA here = new StripeOA();
        String[] lines = {"API: merchant=123456789&amount=1000&destination[account]=111111&destination[amount]=877",
            "API: destination[account]=112211&amount=800&merchant=123456789&destination[amount]=622",
            "BAL: merchant=123456789",
            "BAL: merchant=112211"
        };
        List<String> input = new ArrayList<>(Arrays.asList(lines));
        System.out.println(here.balance(input));
    }
}
