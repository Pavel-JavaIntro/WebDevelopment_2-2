package by.pavka.wd22;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

  public static void main(String[] args) {
    // write your code here
    Deque<String> deque = new ArrayDeque<>();
    deque.addLast("a");
    deque.addLast("b");
    System.out.println(deque.getFirst());
  }
}
