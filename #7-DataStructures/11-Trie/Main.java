import java.util.Map;
import java.util.HashMap;

public class Main {
  public static void main(String[] args) {
    Trie node = new Trie();
    node.insert("word");
    node.insert("wording");
    node.insert("world");
    node.insert("blackmail");
    node.insert("blackboard");
    node.insert("blackbuck");
    node.insert("blackwillow");
    node.insert("blackwidow");
    node.insert("blackbucky");
    node.insert("ThiagoSilva");
    node.insert("ThiagoAlacantra");
    node.insert("ThiagoMotta");
    node.print();

  }
}

class Trie {
  private class TrieNode {
    private Map<Character, TrieNode> children;
    private boolean endOfWord;

    private TrieNode() {
      children = new HashMap<>();
      endOfWord = false;
    }

    public void setChildren(Map<Character, TrieNode> children) {
      this.children = children;
    }

    public void setEndOfWord(boolean endOfWord) {
      this.endOfWord = endOfWord;
    }

    public Map<Character, TrieNode> getChildren() {
      return children;
    }

    public boolean getEndOfWord() {
      return endOfWord;
    }
  }

  private final TrieNode root;

  public Trie() {
    root = new TrieNode();
  }

  // abcd
  public void insert(String word) {
    TrieNode current = root;
    for (int i = 0; i < word.length(); i++) {
      // System.out.println(word.charAt(i));
      if (current.getChildren().containsKey(word.charAt(i))) {
        current = current.getChildren().get(word.charAt(i));
        continue;
      } else {
        current.getChildren().put(word.charAt(i), new TrieNode());
        current = current.getChildren().get(word.charAt(i));
      }
    }
    if (!current.getEndOfWord()) {
      current.setEndOfWord(true);
    }
  }

  public String getSmallestPrefix(String word) {
    TrieNode current = root;
    for (int i = 0; i < word.length(); i++) {
      if (current.getChildren().containsKey(word.charAt(i))) {
        current = current.getChildren().get(word.charAt(i));
        if (current.getEndOfWord())
          return word.substring(0, i + 1);
      } else {
        break;
      }
    }
    return word;
  }

  public void print() {
    TrieNode current = root;
    for (Map.Entry<Character, TrieNode> entry : current.children.entrySet()) {
      helper(entry.getKey(), entry.getValue(), 1);
    }
  }

  public void helper(char curr, TrieNode node, int offset) {
    System.out.println(String.format("%" + offset + "c", curr));
    for (Map.Entry<Character, TrieNode> entry : node.children.entrySet()) {
      helper(entry.getKey(), entry.getValue(), offset + 2);
    }
  }

}
