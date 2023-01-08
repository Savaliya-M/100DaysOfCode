import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

public class PasswordCracker {

    static List<Integer> visited;

    public static String passwordCracker(List<String> passwords, String loginAttempt) {
        visited = new ArrayList<>();
        Map<Character, List<String>> posvaluesperchar = new HashMap<>();

        for (String password : passwords) {
            char initial = password.charAt(0);
            posvaluesperchar.putIfAbsent(initial, new ArrayList<>());
            posvaluesperchar.get(initial).add(password);
        }

        return helper(posvaluesperchar, loginAttempt, 0);
    }

    public static String helper(Map<Character, List<String>> passwords, String loginAttempt, int index) {
        visited.add(index);
        List<String> pospass = passwords.get(loginAttempt.charAt(0));

        if (pospass == null || pospass.isEmpty()) {
            return "WRONG PASSWORD";
        }

        for (int i = 0; i < pospass.size(); i++) {
            String currpass = pospass.get(i);
            if (loginAttempt.startsWith(currpass)) {
                String newloginAttempt = loginAttempt.substring(currpass.length());

                if (newloginAttempt.isEmpty()) {
                    return currpass;
                } else if (!visited.contains(index + currpass.length())) {
                    String newreturnable = helper(passwords, newloginAttempt, index + currpass.length());
                    if (!newreturnable.equals("WRONG PASSWORD")) {
                        return currpass + " " + newreturnable;
                    }
                }
            }
        }
        return "WRONG PASSWORD";

    }
}

class PasswordCracker_exe {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<String> passwords = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .collect(toList());

                String loginAttempt = bufferedReader.readLine();

                String result = PasswordCracker.passwordCracker(passwords, loginAttempt);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
