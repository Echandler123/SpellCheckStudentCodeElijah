public class Trie {
    public class Node {
        boolean isWord;
        Node[] next;
        public Node() {
            this.isWord = false;
            this.next = new Node[256];
        }
        public boolean isWord() {
            return isWord;
        }
        public void setWord() {
            isWord = true;
        }
        public Node[] getNext() {
            return next;
        }
    }
    public Trie() {
        root = new Node();
    }
    private Node root;
    public void insert (String s){
        Node N = root;
        for(int i = 0; i < s.length(); i++){
            if(N.getNext()[s.charAt(i)] == null) {
                N.getNext()[s.charAt(i)]= new Node();
            }
            N = N.getNext()[s.charAt(i)];
        }
        N.setWord();
    }
    public boolean lookup(String s) {
        Node N = root;
        for (int i = 0; i < s.length(); i++) {
            if(N.getNext()[s.charAt(i)] == null) {
                return false;
            }
            N = N.getNext()[s.charAt(i)];
        }
        return N.isWord();
    }
    public void printTrie(){
        System.out.println();
    }
}
