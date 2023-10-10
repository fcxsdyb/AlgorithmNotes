package LaiOffer.Class8_HashTable_String_I;

import java.util.*;

/**
 * HashTable Question 1:
 * For a composition with different kinds of words, try to find the top k frequent words from the composition.
 * Assumptions: HashTable + Priority Queue
 * <p>
 * Time Complexity = O(n log k)
 * Space Complexity = O(n)
 */
public class HashTable_WordCount {

    public static List<String> topKFrequent(String[] words, int k) {
        // Step 1: Update the word count in the HashTable
        Map<String, Integer> wordCountMap = new HashMap<>();
        for (String word : words) {
            wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
        }

        // Step 2: Initialize a min-heap Priority Queue
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
                (a, b) -> a.getValue().equals(b.getValue()) ? b.getKey().compareTo(a.getKey()) : a.getValue() - b.getValue()
        );

        // Step 3: Add entries from the HashTable to the Priority Queue
        for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
            pq.offer(entry);
            if (pq.size() > k) {
                pq.poll();  // Remove the minimum element if size exceeds k
            }
        }

        // Step 4: Extract elements from the Priority Queue
        List<String> result = new LinkedList<>();
        while (!pq.isEmpty()) {
            result.add(0, pq.poll().getKey());  // Add elements to the front of the result list
        }

        // Step 5: Return the result list
        return result;
    }

    public static void main(String[] args) {
        String[] words = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        int k = 4;
        List<String> result = topKFrequent(words, k);
        System.out.println(result);
    }

}
