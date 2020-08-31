package by.pavka.wd22;

import by.pavka.wd22.entity.TextComposite;
import by.pavka.wd22.entity.TextLeaf;
import by.pavka.wd22.entity.TextNode;
import by.pavka.wd22.parser.TextParser;
import by.pavka.wd22.parser.TextParserImpl;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

  public static void main(String[] args) {
    TextNode root = new TextComposite();
    TextNode child1 = new TextComposite();
    TextNode child2 = new TextComposite();
    root.add(child1);
    root.add(child2);
    TextNode leaf1 = new TextLeaf("Evening .");
    TextNode leaf2 = new TextLeaf("That");
    TextNode leaf3 = new TextLeaf("was");
    TextNode leaf4 = new TextLeaf("fine");
    TextNode leaf5 = new TextLeaf(".");
    child1.add(leaf1);
    child2.add(leaf2);
    child2.add(leaf3);
    child2.add(leaf4);
    child2.add(leaf5);
    String text = root.toString();
    System.out.println(text);
    TextParser textParser = new TextParserImpl(".*?\\.", null);
    TextParser childParser = new TextParserImpl(null, ".*? ");
    textParser.setChild(childParser);
    TextNode result = textParser.parse(text);
    System.out.println("Parsed");
    System.out.println(result.toString());
    System.out.println((((TextComposite)result).textNodes.size()));
    TextNode result2 = textParser.parse("It was rainy. I walked along a street. I smiled.");
    System.out.println(result2);
  }
}
