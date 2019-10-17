package trie;

import java.util.*;

public class TrieNode {
    private HashMap<Character, TrieNode> children;
    private String text;
    private Pair metaData;

    public TrieNode() {
        children = new HashMap<Character, TrieNode>();
        text = "";
        metaData = new Pair(false, new TreeSet<>());
    }

    public TrieNode(String text) {
        this();
        this.text = text;
    }

    public HashMap<Character, TrieNode> getChildren() {
        return children;
    }

    public String getText() {
        return text;
    }

    public boolean isWord() {
        return metaData.isTrue;
    }

    public Set<Integer> getSetOfIntegers(){
        return metaData.listOfPosition;
    }

    public void setIsWord(boolean word) {
        metaData.isTrue = word;
    }

    public void setInMetaDataSet(int start){
        metaData.listOfPosition.add(start);
    }

    @Override
    public String toString() {
        return text;
    }

    class Pair{
        private Boolean isTrue;
        private Set<Integer> listOfPosition;

        public Pair(Boolean isTrue, Set<Integer> setOfPosition) {
            this.isTrue = isTrue;
            this.listOfPosition = setOfPosition;
        }

        public Set<Integer> getListOfPosition() {
            return listOfPosition;
        }

        public void setListOfPosition(Set<Integer> listOfPosition) {
            this.listOfPosition = listOfPosition;
        }

        public Boolean getTrue() {
            return isTrue;
        }

        public void setTrue(Boolean aTrue) {
            isTrue = aTrue;
        }
    }
}
