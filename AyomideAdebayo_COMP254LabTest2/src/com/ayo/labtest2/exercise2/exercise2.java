package com.ayo.labtest2.exercise2;

public class exercise2 {
    // putOnlyIfAbsentMethod
    public V putOnlyIfAbsent(K key, V value){
        int j = findIndex(Key);
        if(j == -1){
            table.add(new MapEntry<>(Key, value));
            return null; // Returns null if the key is not present
        }else{
            return table.get(j).getValue(); // Returns the value
        }
    }



    // Testing the putOnlyIfAbsent method
    public static void main(String[] args) {
        UnsortedTableMap<String, Integer> map = new UnsortedTableMap<>();
        System.out.println("Put only if absent (new key): " + map.putOnlyIfAbsent("apple", 50));
        System.out.println("Put only if absent (existing key): " + map.putOnlyIfAbsent("apple", 60));
        System.out.println("Current value of 'apple': " + map.get("apple"));
        System.out.println("Put only if absent (new key): " + map.putOnlyIfAbsent("banana", 30));
        System.out.println("Current value of 'banana': " + map.get("banana"));
    }
}
