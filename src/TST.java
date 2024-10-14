public class TST {
        public class NodeTST {
            private boolean isEndofWord;
            private NodeTST less;
            private NodeTST equal;
            private NodeTST more;
            private char value;
            public NodeTST(char value) {
                this.value = value;
                this.less = null;
                this.equal = null;
                this.more = null;
                this.isEndofWord = false;
            }

            public char getValue() {
                return value;
            }

            public NodeTST getLess() {
                return less;
            }
            public NodeTST getEqual() {
                return equal;
            }

            public NodeTST getMore() {
                return more;
            }

            public void setValue(char value) {
                this.value = value;
            }
            public void setEqual(NodeTST equal) {
                this.equal = equal;
            }

            public void setLess(NodeTST less) {
                this.less = less;
            }

            public void setMore(NodeTST more) {
                this.more = more;
            }

            public void setEndofWord() {
                isEndofWord = true;
            }

            public boolean isEndofWord() {
                return isEndofWord;
            }
        }
    private NodeTST root;
    public TST(){
            root = null;
    }
    public void insert (String s) {
        // Set root as first char in the word
        if (root == null) {
            this.root = new NodeTST(s.charAt(0));
        }
        NodeTST N = root;
        // Loop through each letter in the word
        for (int i = 0; i < s.length(); ) {
            // Checks if the current letter is the same as the next
            if (N.getValue() == s.charAt(i)) {
                // Checks if the next letter would not be the last one in the word
                if (i + 1 < s.length()) {
                    // If the middle node is empty set the current letter as it
                    if (N.getEqual() == null) {
                        NodeTST Next = new NodeTST(s.charAt(i + 1));
                        N.setEqual(Next);
                    }
                    N = N.getEqual();
                    // Moves to next character
                    i++;
                }
                // If it is the last character set it as the end of the word and return
                else {
                    N.setEndofWord();
                    return;
                }
            }
            // Checks if the value of the next letter is less than the current
            else if (s.charAt(i) < N.getValue()) {
                // If the node on the lesser end is empty then add the next letter to it
                if (N.getLess() == null) {
                    NodeTST Next = new NodeTST(s.charAt(i));
                    N.setLess(Next);
                }
                // Sets the next letter as the current
                N = N.getLess();
            }
            // At this point the value of the next letter has to be more than the current
            else {
                // If the node on the greater end is empty then add the next letter to it
                if (N.getMore() == null) {
                    NodeTST Next = new NodeTST(s.charAt(i));
                    N.setMore(Next);
                }
                // Sets the next letter as the current
                N = N.getMore();
            }
        }
        N.setEndofWord();
    }
    public boolean lookup(String s) {
        NodeTST N = root;
        // Go through each letter in the word
        for (int i = 0; i < s.length(); i++) {
            // Loop through until the current letter isn't null
            while (N != null) {
                // Go to lesser side if the next letter is less than the current one
                if (s.charAt(i) < N.getValue()) {
                    // Set the next letter as the lesser node of the current
                    N = N.getLess();
                }
                // Go to greater side if the next letter is greater than the current one
                else if (s.charAt(i) > N.getValue()) {
                    // Set the next letter as the greater node of the current
                    N = N.getMore();
                }
                // Go to them middle if the next letter is equal to the current one
                else {
                    // If this is the end of the word return if it is the end of a word or not
                    if (i == s.length() - 1) {
                        return N.isEndofWord();
                    }
                    // Set the next letter as the equal node of the current if it is not the end
                    // of the word
                    N = N.getEqual();
                    break;
                }
            }
            if (N == null) {
                return false;
            }
        }
        return false;
    }


}
