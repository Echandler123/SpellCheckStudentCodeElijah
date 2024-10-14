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
        if (root == null) {
            this.root = new NodeTST(s.charAt(0));
        }
        NodeTST N = root;
        for (int i = 0; i < s.length(); ) {  // no need to decrement 'i'
            if (N.getValue() == s.charAt(i)) {
                if (i + 1 < s.length()) {
                    if (N.getEqual() == null) {
                        NodeTST Next = new NodeTST(s.charAt(i + 1));
                        N.setEqual(Next);
                    }
                    N = N.getEqual();
                    i++;  // move to the next character
                } else {
                    N.setEndofWord();
                    return;
                }
            } else if (s.charAt(i) < N.getValue()) {
                if (N.getLess() == null) {
                    NodeTST Next = new NodeTST(s.charAt(i));
                    N.setLess(Next);
                }
                N = N.getLess();
            } else {
                if (N.getMore() == null) {
                    NodeTST Next = new NodeTST(s.charAt(i));
                    N.setMore(Next);
                }
                N = N.getMore();
            }
        }
        N.setEndofWord();
    }

    public boolean lookup(String s) {
        NodeTST N = root;
        for (int i = 0; i < s.length(); i++) {
            while (N != null) {
                if (s.charAt(i) < N.getValue()) {
                    N = N.getLess();
                } else if (s.charAt(i) > N.getValue()) {
                    N = N.getMore();
                } else {  // match found
                    if (i == s.length() - 1) {  // last character
                        return N.isEndofWord();
                    }
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
