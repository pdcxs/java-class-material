package simpleparser;

import java.util.ArrayList;

public class Lexer {
  private final ArrayList<String> lexes;
  private String curLex;
  private final String code;
  private int location;

  public Lexer(String code) {
    this.code = code;
    location = 0;
    curLex = "";
    lexes = new ArrayList<>();
  }

  private void step() {
    char c = code.charAt(location);
    if (c == '(' || c == ')') {
      if (!curLex.isEmpty()) {
        lexes.add(curLex);
        curLex = "";
      }
      lexes.add(c + "");
    } else if (Character.isWhitespace(c)) {
      if (!curLex.isEmpty()) {
        lexes.add(curLex);
        curLex = "";
      }
    } else {
      curLex += c;
    }
    location++;
  }

  public ArrayList<String> parse() {
    while (location < code.length()) {
      step();
    }
    return lexes;
  }
}
