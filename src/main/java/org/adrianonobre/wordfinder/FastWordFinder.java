package org.adrianonobre.wordfinder;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by adriano on 2016-11-18.
 */
public class FastWordFinder {

    private final Trie _trie;

    public FastWordFinder(Iterable<String> words) {
        _trie = new Trie(words);
    }

    public Set<String> findWords(char[] chars) {
        Set<String> wordsFound = new HashSet<>();
        for (int i = 0 ; i < chars.length; i++) {
            char c = chars[i];
            Trie.Pointer p = _trie.getPointer(c, null);
            if (p != null) {
                char[] remaining = removeElementAt(chars, i);
                char[] consumed = new char[]{ c };

                parseTrie(p, consumed, remaining, wordsFound);
            }
        }

        return wordsFound;
    }

    private void parseTrie(Trie.Pointer p, char[] consumed, char[] remaining, Set<String> wordsFound) {
        if (p.isWord()) {
            wordsFound.add(String.copyValueOf(consumed));
        }

        for (int i = 0; i < remaining.length; i++) {
            char c = remaining[i];
            Trie.Pointer newP = _trie.getPointer(c, p);
            if (newP != null) {
                char[] newRemaining = removeElementAt(remaining, i);
                char[] newConsumed = append(consumed, c);

                parseTrie(newP, newConsumed, newRemaining, wordsFound);
            }
        }
    }

    private static char[] append(char[] source, char c) {
        char[] result = new char[source.length + 1];
        for (int i = 0 ; i < source.length; i++) {
            result[i] = source[i];
        }
        result[result.length - 1] = c;

        return result;
    }

    private static char[] removeElementAt(char[] source, int i) {
        char[] result = new char[source.length - 1];
        int n = 0;
        for (int j = 0; j < source.length; j++) {
            if (j != i) {
                result[n++] = source[j];
            }
        }
        return result;
    }
}
