import java.util.*;

public class countVowels {
    static int count_Vowels(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i'
                    || str.charAt(i) == 'o' || str.charAt(i) == 'u') {
                count++;
                System.out.print(str.charAt(i) + " ");
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the string: ");
        String str = sc.nextLine();
        str = str.toLowerCase();
        System.out.print("\nNumber of  Vowels in the string: " + count_Vowels(str) + "\n");
    }
}
