package com.ayo.lab6.exercise1;

// Modified AbstractHashMap implementation
public abstract class AbstractHashMap<K,V> {
    private float maxLoadFactor;

    public AbstractHashMap(int capacity, float maxLoadFactor) {
        this.capacity = capacity;
        this.maxLoadFactor = maxLoadFactor;
        // Initialization code...
    }

    // Overridden put method and other modifications to support maxLoadFactor
}

// Adjusted ChainHashMap implementation
public class ChainHashMap<K,V> extends AbstractHashMap<K,V> {
    public ChainHashMap(int capacity, float maxLoadFactor) {
        super(capacity, maxLoadFactor);
        // Specific initialization...
    }
    // Implementation details...
}

// Adjusted ProbeHashMap implementation
public class ProbeHashMap<K,V> extends AbstractHashMap<K,V> {
    public ProbeHashMap(int capacity, float maxLoadFactor) {
        super(capacity, maxLoadFactor);
        // Specific initialization...
    }
    // Implementation details...
}

// Experimentation code
public class MapEfficiencyTest {
    public static void main(String[] args) {
        // Array of load factors to test
        float[] loadFactors = {0.1f, 0.5f, 0.75f, 0.9f};
        int capacity = 1000; // Starting capacity
        int numKeys = 50000; // Number of keys to insert

        for (float loadFactor : loadFactors) {
            ChainHashMap<Integer, Integer> chainMap = new ChainHashMap<>(capacity, loadFactor);
            ProbeHashMap<Integer, Integer> probeMap = new ProbeHashMap<>(capacity, loadFactor);
            // Perform insertions and measure time...
        }
    }
}




