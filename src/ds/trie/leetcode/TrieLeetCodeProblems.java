package ds.trie.leetcode;

public class TrieLeetCodeProblems {
    public static void main(String...args) {
        Trie trie = null;

        /*
        System.out.println("");
        System.out.println("Input is ");
        System.out.println("[\"Trie\", \"insert\", \"search\", \"search\", \"startsWith\", \"insert\", \"search\"]");
        System.out.println("[], [\"apple\"], [\"apple\"], [\"app\"], [\"app\"], [\"app\"], [\"app\"]");
        System.out.println("Expected output is ");
        System.out.println("[null, null, true, false, true, null, true]");

        trie = new Trie();
        trie.insert("apple");
        System.out.println("Actual output is ");
        System.out.print("[null");
        System.out.print(", null");

        System.out.print(", " + trie.search("apple"));
        System.out.print(", " + trie.search("app"));
        System.out.print(", " + trie.startsWith("app"));
        trie.insert("app");
        System.out.print(", null");
        System.out.print(", " + trie.search("app"));
        System.out.print("]");
        System.out.println("");

        System.out.println("");
        System.out.println("Input is ");
        System.out.println("[\"Trie\",\"insert\",\"startsWith\"]");
        System.out.println("[[],[\"hotdog\"],[\"dog\"]]");
        System.out.println("Expected output is ");
        System.out.println("[null, null, false]");
        */

        trie = new Trie();
        trie.insert("hotdog");
        System.out.println("Actual output is ");
        System.out.print("[null");
        System.out.print(", null");

        System.out.print(", " + trie.search("dog"));
        System.out.print("]");
        System.out.println("");
    }
}
