package com.livtech.demo.interviews.amazon;

import java.util.*;

public class FindKTopToys {
    /*const tests = [
  {
    topToys: 2,
    toys: ["elmo", "elsa", "legos", "drone", "tablet", "warcraft"],
    quotes: [
      "Emo is the hottest of the season! Elmo will be on every kid's wishlist!",
      "The new Elmo dolls are super high quality",
      "Expect the Elsa dolls to be very popular this year",
      "Elsa and Elmo are the toys I'll be buying for my kids",
      "For parents of older kids, look into buying them a drone",
      "Warcraft is slowly rising in popularity ahead of the holiday season"
    ],
    expected: ["elmo", "elsa"]
  },
  {
    topToys: 2,
    toys: ["anacell", "betacellular", "cetracular", "deltacellular", "eurocell"],
    quotes: [
      "Best services provided by anacell",
      "betacellular has great services",
      "anacell provides much better services than all other",
    ],
    expected: ["anacell", "betacellular"]
  },
  {
    topToys: 2,
    toys: ["anacell", "betacellular", "cetracular", "deltacellular", "eurocell"],
    quotes: [
      "I love anacell Best services Best services provided by anacell",
      "betacellular has great services",
      "deltacellular provides much better services than betacellular",
      "cetracular is worse than eurocell",
      "betacellular is better than deltacellular",
    ],
    expected: ["betacellular", "deltacellular"]
  },
  {
    topToys: 15,
    toys: ["a and b", "b and c"],
    quotes: ["asdf a and b b and a b and c b and c"],
    expected: ["b and c", "a and b"]
  }
];
    * */
    public static void main(String[] args) {
        int topToys = 2;
        String[] toys = {"anacell", "betacellular", "cetracular", "deltacellular", "eurocell"};
        String[] quotes =
                {"I love anacell Best services Best services provided by anacell",
                        "betacellular has great services",
                        "deltacellular provides much better services than betacellular",
                        "cetracular is worse than eurocell",
                        "betacellular is better than deltacellular"};
        System.out.println(getTopToys(topToys, toys, quotes));
    }

    static ArrayList<String> getTopToys(int topToys, String[] toys, String[] quotes) {
        ArrayList<String> topItems = new ArrayList<>();

        HashMap<String, Integer> toyMap = new HashMap<>();
        for (String toy : toys) {
            toyMap.put(toy, 0);
        }
        for (String qoute : quotes) {
            HashSet<String> toySet = new HashSet<>();
            String[] words = qoute.split(" ");
            for (String word : words) {
                if (toyMap.containsKey(word) && !toySet.contains(word)) {
                    toySet.add(word);
                    int count = toyMap.get(word) + 1;
                    toyMap.put(word, count);
                }
            }
        }
        PriorityQueue<Map.Entry<String, Integer>> maxHeap = new PriorityQueue<>((o1, o2) -> {
            if (o1.getValue().equals(o2.getValue())) {
                return o1.getKey().compareTo(o2.getKey());
            }
            return o2.getValue().compareTo(o1.getValue());
        });

        maxHeap.addAll(toyMap.entrySet());
        for (int i = 0; i < topToys; i++) {
            topItems.add(maxHeap.remove().getKey());
        }
        return topItems;
    }
}
