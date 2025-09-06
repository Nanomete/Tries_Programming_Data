public class Test {
    public static void main(String[] args) {
        // new Object of Trie
        Trie t = new Trie();
        // insert words
        t.insert("hello");
        t.insert("hi");
        t.insert("hey");
        t.insert("he");
        t.insert("her");
        t.insert("hero");
        t.insert("heroplane");
        t.insert("Phone");
        t.insert("Pancake");
        t.insert("finsh");
        // print Trie
        t.PrintTrie();
        // print words
        t.PrintWord();
    }
}