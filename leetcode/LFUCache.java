package leetcode;


import java.util.HashMap;
import java.util.LinkedHashSet;

public class LFUCache {

    private class InfoNode {
        public int value;
        public int frequency;
        public int key;

        public InfoNode(int v, int f, int k) {
            value = v;
            frequency = f;
            key = k;
        }
    }

    private final HashMap<Integer, InfoNode> map;
    private final HashMap<Integer, LinkedHashSet<InfoNode>> frequencyMap;
    private int minFreq = Integer.MAX_VALUE;
    private final int capacity;

    public LFUCache(int capacity) {
        map = new HashMap<>();
        frequencyMap = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        InfoNode node = map.get(key);
        if (node == null) {
            return -1;
        } else {
            updateFreq(key, node);
        }
        return node.value;
    }

    public void put(int key, int value) {
        InfoNode node = map.get(key);
        if (node != null) {
            node.value = value;
            updateFreq(key, node);
        } else {
            if (capacity == 0) {
                return;
            }
            if (map.size() == capacity) {
                LinkedHashSet<InfoNode> minFreqMap = frequencyMap.get(minFreq);
                InfoNode oldest = minFreqMap.iterator().next();
                minFreqMap.remove(oldest);
                map.remove(oldest.key);
            }
            InfoNode newNode = new InfoNode(value, 1, key);
            map.put(key, newNode);
            LinkedHashSet<InfoNode> currMap = frequencyMap.computeIfAbsent(1, k -> new LinkedHashSet<InfoNode>());
            currMap.add(newNode);
            minFreq = 1;
        }
    }

    private void updateFreq(int key, InfoNode node) {
        node.frequency++;
        LinkedHashSet<InfoNode> prevMap = frequencyMap.get(node.frequency - 1);
        if (minFreq == node.frequency - 1 && prevMap.size() == 1) {
            minFreq++;
        }
        prevMap.remove(node);
        LinkedHashSet<InfoNode> currMap = frequencyMap.computeIfAbsent(node.frequency, k -> new LinkedHashSet<>());
        currMap.add(node);
    }
}
