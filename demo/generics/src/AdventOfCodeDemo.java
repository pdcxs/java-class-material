import java.util.*;
// import java.util.stream.Stream;

public class AdventOfCodeDemo {
  // This is a solution for problem
  // https://adventofcode.com/2024/day/11
  public static void main(String[] args) {
    // Test input
    List<Long> init = List.of(125L, 17L);
    for (int i = 0; i < 6; i++) {
      System.out.println(init);
      init = blink(init);
    }

    List<Long> input = Arrays.asList(3028L, 78L, 973951L, 5146801L, 5L, 0L, 23533L, 857L);

    // Question 1, method 1
    var cur = input;
    for (int i = 0; i < 25; i++) {
      cur = blink(cur);
    }
    System.out.println(cur.size());

    // Question 1, method 2
    var record = getInit(input);
    var curRecord = record;
    for (int i = 0; i < 25; i++) {
      curRecord = blink(curRecord);
    }
    long s = 0;
    for (var entry : curRecord.entrySet()) {
      s += entry.getValue();
    }
    System.out.println(s);

    // Question 2
    curRecord = record;
    for (int i = 0; i < 75; i++) {
      curRecord = blink(curRecord);
    }
    s = 0;
    for (var entry : curRecord.entrySet()) {
      s += entry.getValue();
    }
    System.out.println(s);
  }

  static List<Long> transform(Long stone) {
    if (stone.equals(0L)) {
      return List.of(1L);
    }
    String s = stone.toString();
    if (s.length() % 2 == 0) {
      String s1 = s.substring(0, s.length() / 2);
      String s2 = s.substring(s.length() / 2, s.length());
      return List.of(Long.parseLong(s1), Long.parseLong(s2));
    }
    return List.of(stone * 2024);
  }

  static List<Long> blink(List<Long> stones) {
    ArrayList<Long> acc = new ArrayList<>();
    for (Long s : stones) {
      for (Long ns : transform(s)) {
        acc.add(ns);
      }
    }
    return acc;
    // return stones.stream()
    // .map(AdventOfCodeDemo::transform)
    // .reduce((acc, e) -> Stream.concat(
    // acc.stream(), e.stream())
    // .toList())
    // .get();
  }

  static Map<Long, Long> getInit(List<Long> stones) {
    Map<Long, Long> result = new HashMap<>();
    for (Long s : stones) {
      if (result.containsKey(s)) {
        result.put(s, result.get(s) + 1);
      } else {
        result.put(s, 1L);
      }
    }
    return result;
  }

  static Map<Long, Long> blink(Map<Long, Long> record) {
    Map<Long, Long> result = new HashMap<>();
    for (var entrySet : record.entrySet()) {
      Long s = entrySet.getKey();
      Long count = entrySet.getValue();

      List<Long> newStones = transform(s);
      for (Long ns : newStones) {
        if (result.containsKey(ns)) {
          result.put(ns, result.get(ns) + count);
        } else {
          result.put(ns, count);
        }
      }
    }
    return result;
  }
}
