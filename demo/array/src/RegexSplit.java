public class RegexSplit {
    public static void main(String[] args) {
        String str = "他说：我很好。我说：我不信 Hello, good morning!";
        String regex = "[\\s\\p{Punct}：。]+";
        String[] words = str.split(regex);

        for (int i = 0; i < words.length; i++) {
            System.out.println(words[i]);
        }
    }
}
