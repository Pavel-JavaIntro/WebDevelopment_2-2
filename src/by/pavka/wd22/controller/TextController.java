package by.pavka.wd22.controller;

public class TextController {
  private static final TextController instance = new TextController();

  private TextController() {}

  public static TextController getInstance() {
    return instance;
  }
}
