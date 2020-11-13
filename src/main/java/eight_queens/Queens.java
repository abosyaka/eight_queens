package eight_queens;

import java.util.LinkedList;

public class Queens {

  private final int queens_number = 8;
  private final LinkedList<Integer> state = new LinkedList<>();

  private boolean isSafe(LinkedList<Integer> state) {

    if (state.size() == 1) {
      return true;
    }

    var size = state.size() - 1;
    var y = state.get(size);

    for (var i = 0; i < size; i++) {

      if (state.getLast().equals(state.get(i))) {
        return false;
      }

      var deltaX = Math.abs(size - i);
      var deltaY = Math.abs(y - state.get(i));

      if (deltaX == deltaY) {
        return false;
      }

    }

    return true;
  }

  private LinkedList<Integer> compute(LinkedList<Integer> state) {

    if (queens_number == state.size()) {
      return state;
    }

    for (var i = 0; i < queens_number; i++) {

      state.add(i);

      if (isSafe(state)) {
        var tmp = compute(state);
        if (tmp != null) {
          return tmp;
        }
      }

      state.removeLast();
    }

    return null;
  }

  public String toString() {

    var s = new StringBuilder();

    for (var i = 0; i < queens_number; i++) {

      s.append("\n");

      for (var j = 0; j < queens_number; j++) {

        if (state.get(i) == j) {
          s.append("  Q");
        } else {
          s.append("  |");
        }

      }

    }

    return s.toString();
  }

  public void solve() {
    compute(state);
  }

}