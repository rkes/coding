public class PalindromePartition {

      public static void main(String[] args) {
          ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
          String s = "nitin";// [0,1,2,3,4]
          printAllPalindrome(s, 0, s.length(), new ArrayList<String>(), res);
          for (ArrayList<String> lsts : res) {
            for (String val : lsts)
              System.out.printf("%s\t", val);
            System.out.println();
          }
          System.out.println(res);
        }

        public static void printAllPalindrome(String str, int start, int n, ArrayList<String> strs,ArrayList<ArrayList<String>> res) {
          if (start == n) {
            res.add(new ArrayList<>(strs));
            return;
          }
          for (int i = start; i < n; i++) {
            String s = str.substring(start, i + 1);
            if (isPalindrome(s)) {
              strs.add(s);
              printAllPalindrome(str, start + 1, n, strs, res);
              strs.remove(strs.size() - 1);
            }
          }
        }
}
