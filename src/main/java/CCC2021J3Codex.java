import java.util.*;

/**
 A transaction is possibly invalid if:

 the amount exceeds $1000, or;
 if it occurs within (and including) 60 minutes of another transaction with the same name in a different city.
 You are given an array of strings transaction where transactions[i] consists of comma-separated values representing the name, time (in minutes), amount, and city of the transaction.

 Return a list of transactions that are possibly invalid. You may return the answer in any order.
 */
class Solution {
    public List<String> invalidTransactions(String[] transactions) {
        List<String> res = new ArrayList<>();
        Map<String, List<Transaction>> map = new HashMap<>();
        for (String s : transactions) {
            String[] ss = s.split(",");
            String name = ss[0];
            int time = Integer.parseInt(ss[1]);
            int amount = Integer.parseInt(ss[2]);
            String city = ss[3];
            Transaction t = new Transaction(name, time, amount, city);
            if (amount > 1000) {
                res.add(s);
            }
            List<Transaction> list = map.getOrDefault(name, new ArrayList<>());
            list.add(t);
            map.put(name, list);
        }
        for (String name : map.keySet()) {
            List<Transaction> list = map.get(name);
            for (int i = 0; i < list.size(); i++) {
                Transaction t1 = list.get(i);
                for (int j = i + 1; j < list.size(); j++) {
                    Transaction t2 = list.get(j);
                    if (Math.abs(t1.time - t2.time) <= 60 && !t1.city.equals(t2.city)) {
                        res.add(t1.toString());
                        res.add(t2.toString());
                    }
                }
            }
        }
        return res;
    }

    class Transaction {
        String name;
        int time;
        int amount;
        String city;

        public Transaction(String name, int time, int amount, String city) {
            this.name = name;
            this.time = time;
            this.amount = amount;
            this.city = city;
        }

        @Override
        public String toString() {
            return name + "," + time + "," + amount + "," + city;
        }
    }

}