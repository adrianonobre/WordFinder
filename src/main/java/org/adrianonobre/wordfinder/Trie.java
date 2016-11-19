package org.adrianonobre.wordfinder;

import java.util.stream.StreamSupport;

/**
 * Created by adriano on 2016-11-18.
 */
public class Trie {

    private Pointer head = new Pointer();

    public Trie(Iterable<String> words) {
        StreamSupport.stream(words.spliterator(), false)
                     .map(w -> w.toLowerCase())
                     .filter(w -> w.matches("^[a-z]+$"))
                     .forEach(this::addWord);
    }

    private void addWord(String word) {
        Pointer curr = head;
        for (char letter : word.toCharArray()) {
            Pointer[] node = curr.charPointers;
            curr = node[letter - 'a'];
            if (curr == null) {
                curr = new Pointer();
                node[letter - 'a'] = curr;
            }
        }

        curr.isWord = true;
    }

    public Pointer getPointer(char c, Pointer p) {
        if (p == null) {
            p = head;
        }

        return p.charPointers[c - 'a'];
    }

    public class Pointer {
        private Pointer[] charPointers = new Pointer[26];

        private boolean isWord;

        public boolean isWord() {
            return isWord;
        }
    }
}
