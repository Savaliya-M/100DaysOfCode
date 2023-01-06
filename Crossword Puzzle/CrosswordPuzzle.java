import java.util.*;

public class CrosswordPuzzle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String crossword_temp[] = new String[10];
        for (int i = 0; i < 10; i++) {
            crossword_temp[i] = sc.nextLine();
        }

        char crossword[][] = new char[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                crossword[i][j] = crossword_temp[i].charAt(j);
            }
        }

        String words[] = sc.nextLine().split(";");

        boolean wordfill[][] = new boolean[words.length][];
        for (int i = 0; i < words.length; i++) {
            wordfill[i] = new boolean[words[i].length()];
        }

        solveCrossword(crossword, words, 0, wordfill);
        sc.close();
    }

    private static void solveCrossword(char[][] crossword, String[] words, int index, boolean wordFill[][]) {
        if (index == words.length) {
            printCrossword(crossword);
            return;
        }
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (crossword[i][j] == '-' || crossword[i][j] == words[index].charAt(0)) {
                    boolean inserted = insertVerticalIfPossible(i, j, crossword, words, index, wordFill);
                    if (inserted)
                        solveCrossword(crossword, words, index + 1, wordFill);
                    if (inserted)
                        removeVertically(i, j, crossword, words, index, wordFill);

                    inserted = insertHorizontalIfPossible(i, j, crossword, words, index, wordFill);
                    if (inserted)
                        solveCrossword(crossword, words, index + 1, wordFill);
                    if (inserted)
                        removeHorizontally(i, j, crossword, words, index, wordFill);

                }
            }
        }

    }

    private static void removeHorizontally(int i, int j, char[][] crossword, String[] words, int index,
            boolean[][] wordFill) {
        for (int x = 0; x < words[index].length(); x++) {
            if (wordFill[index][x]) {
                crossword[i][j] = '-';
            }
            wordFill[index][x] = false;
            j++;
        }
    }

    private static boolean insertHorizontalIfPossible(int i, int j, char[][] crossword, String[] words, int index,
            boolean[][] wordFill) {
        String word = words[index];
        int wordIndex = 0, jj = j;
        while (j < 10) {
            if (crossword[i][j] == '+')
                return false;
            else if (crossword[i][j] == '-')
                wordIndex++;
            else if (crossword[i][j] == word.charAt(wordIndex))
                wordIndex++;
            else
                return false;

            if (wordIndex == word.length()) {
                for (int x = 0; x < word.length(); x++) {
                    if (crossword[i][jj] == word.charAt(x)) {
                        wordIndex++;
                    } else {
                        crossword[i][jj] = word.charAt(x);
                        wordFill[index][x] = true;
                    }
                    jj++;
                }
                return true;
            }
            j++;
        }
        return false;

    }

    private static void removeVertically(int i, int j, char[][] crossword, String[] words, int index,
            boolean[][] wordFill) {
        for (int x = 0; x < words[index].length(); x++) {
            if (wordFill[index][x]) {
                crossword[i][j] = '-';
            }
            wordFill[index][x] = false;
            i++;
        }
    }

    private static boolean insertVerticalIfPossible(int i, int j, char[][] crossword, String[] words, int index,
            boolean[][] wordFill) {
        String word = words[index];
        int wordIndex = 0, ii = i;
        while (i < 10) {
            if (crossword[i][j] == '+')
                return false;
            else if (crossword[i][j] == '-')
                wordIndex++;
            else if (crossword[i][j] == word.charAt(wordIndex))
                wordIndex++;
            else
                return false;

            if (wordIndex == word.length()) {
                for (int x = 0; x < word.length(); x++) {
                    if (crossword[ii][j] == word.charAt(x)) {
                        wordIndex++;
                    } else {
                        crossword[ii][j] = word.charAt(x);
                        wordFill[index][x] = true;
                    }
                    ii++;
                }
                return true;
            }
            i++;
        }
        return false;
    }

    private static void printCrossword(char[][] crossword) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(crossword[i][j]);
            }
            System.out.println();
        }
    }
}
