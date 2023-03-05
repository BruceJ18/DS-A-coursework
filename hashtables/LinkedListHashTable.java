package datastructures.hashtables;

import java.util.LinkedList;

public class LinkedListHashTable {
    private class Entry {
        private int key;
        private String value;
        public Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    private LinkedList<Entry>[] mainChain = new LinkedList[5];

    public void put(int key, String value) {
        var entry = getEntry(key);
        if (entry != null) {
            entry.value = value;
            return;
        }

        createSideChain(key).add(new Entry(key, value));
    }

    public String get(int key) {
        var entry = getEntry(key);
        return (entry == null) ?  null : entry.value;
    }

    public void remove(int key) {
        var entry = getEntry(key);
        if (entry == null)
            throw new IllegalStateException();
        getSideChain(key).remove(entry);

    }

    private LinkedList<Entry> getSideChain(int key) {
        return  mainChain[hashFunction(key)];
    }

    private Entry getEntry(int key){
        var sideChain = getSideChain(key);
        if (sideChain != null) {
            for (var entry : sideChain) {
                if (entry.key == key)
                    return entry;
            }
        }
        return null;
    }

    private int hashFunction(int key) {
        return key % mainChain.length;
    }

    private LinkedList<Entry> createSideChain(int key) {
        var index = hashFunction(key);
        var sideChain = mainChain[index];
        if (sideChain == null)
            mainChain[index] = new LinkedList<>();

        return sideChain;
    }
}
