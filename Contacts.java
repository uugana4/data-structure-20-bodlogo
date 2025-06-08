import java.util.*;

public class Contacts {
    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
        int count = 0;
    }

    static class Trie {
        TrieNode root = new TrieNode();

        void add(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (!node.children.containsKey(c)) {
                    node.children.put(c, new TrieNode());
                }
                node = node.children.get(c);
                node.count++;
            }
        }

        int find(String prefix) {
            TrieNode node = root;
            for (char c : prefix.toCharArray()) {
                if (!node.children.containsKey(c)) {
                    return 0;
                }
                node = node.children.get(c);
            }
            return node.count;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Trie trie = new Trie();
        for (int i = 0; i < n; i++) {
            String op = sc.next();
            String contact = sc.next();
            if (op.equals("add")) {
                trie.add(contact);
            } else if (op.equals("find")) {
                System.out.println(trie.find(contact));
            }
        }
        sc.close();
    }
}