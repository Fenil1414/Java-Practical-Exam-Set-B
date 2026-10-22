import java.util.Scanner;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String original = sc.nextLine();
        String keyword = sc.nextLine();

        String trimmed = original.trim();
        String[] words = trimmed.split("\\s+");

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            if (i > 0) {
                sb.append(" ");
            }
            sb.append(words[i].toLowerCase(Locale.ROOT));
        }

        sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));

        String shortest = words[0].toLowerCase(Locale.ROOT);
        int keywordCount = 0;

        for (String word : words) {
            String lower = word.toLowerCase(Locale.ROOT);

            if (lower.length() < shortest.length()) {
                shortest = lower;
            }

            if (lower.equals(keyword.toLowerCase(Locale.ROOT))) {
                keywordCount++;
            }
        }

        int vowelCount = 0;

        for (int i = 0; i < original.length(); i++) {
            char ch = Character.toLowerCase(original.charAt(i));

            if (ch == 'a' || ch == 'e' || ch == 'i' ||
                ch == 'o' || ch == 'u') {
                vowelCount++;
            }
        }

        System.out.println("Sentence: " + sb);
        System.out.println("Words: " + words.length);
        System.out.println("Shortest word: " + shortest);
        System.out.println("Keyword count: " + keywordCount);
        System.out.println("Vowels: " + vowelCount);

        sc.close();
    }
}
