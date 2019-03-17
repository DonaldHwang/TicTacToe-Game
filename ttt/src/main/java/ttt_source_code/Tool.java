/**
   A class for Tool (of Player)
 */
package ttt_source_code;
public enum Tool {
  X, O, EMPTY;   // name()
  
  public String toString () { return SHOW_AS[ ordinal() ]; }

  private static String[] SHOW_AS = { "X", "O", " " };
}
