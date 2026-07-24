class Solution {
    class Pair {
        String word;
        int len;

        Pair(String word_, int len_) {
            this.word = word_;
            this.len = len_;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q = new LinkedList<>();
        HashSet<String> set = new HashSet<>();

        for (String word : wordList) {
            set.add(word);
        }
        set.remove(beginWord); // to avoid revisiting
        if (!set.contains(endWord))
            return 0; // Optimization

        q.offer(new Pair(beginWord, 1));
        while (!q.isEmpty()) {
            String wordy = q.peek().word;
            int length = q.peek().len;
            q.remove();

            if (wordy.equals(endWord))
                return length;
                
            for (int i = 0; i < wordy.length(); i++) {
                char[] arr = wordy.toCharArray();
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    arr[i] = ch;
                    String newWord = new String(arr);
                    if (set.contains(newWord)) {
                        set.remove(newWord);
                        q.offer(new Pair(newWord, length + 1));
                    }
                }

            }
        }
        return 0;

    }
}