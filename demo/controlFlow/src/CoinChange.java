import java.util.HashMap;

// https://pe-cn.github.io/31/
// https://projecteuler.net/problem=31
public class CoinChange {
  public static void main(String[] args) {
    int[] coins = { 1, 2, 5, 10, 20, 50, 100, 200 };
    int target = 200;
    System.out.println(solve(target, coins));
  }

  static HashMap<Key, Integer> results = new HashMap<>();

  static int solve(int target, int[] coins, int curCoin) {
    Key k = new Key(target, curCoin);
    if (results.containsKey(k))
      return results.get(k);
    if (target < 0 || curCoin >= coins.length)
      return 0;
    if (target == 0)
      return 1;
    int coin = coins[curCoin];
    int result = solve(target - coin, coins, curCoin)
        + solve(target, coins, curCoin + 1);

    results.put(k, result);

    return result;
  }

  static int solve(int target, int[] coins) {
    return solve(target, coins, 0);
  }
}

class Key {
  int target;
  int curCoin;

  Key(int t, int c) {
    target = t;
    curCoin = c;
  }
}
