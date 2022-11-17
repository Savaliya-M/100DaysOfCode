import java.io.*;
import java.util.stream.*;


public class SeparatetheNumbers {

    public static void separateNumbers(String s) {
        String ss = "";
        int valid = 0;
        for (int i = 1; i <= s.length()/2; i++) {
            ss = s.substring(0,i);
            long d = Long.parseLong(ss);
            String vs = ss;
            while (vs.length()<s.length()) {
                vs += Long.toString(++d);
            }
            if(s.equals(vs)){
                valid = 1;
                break;
            }
        }
        if(valid == 1){
            System.out.println("YES "+ss);
        }else{
            System.out.println("NO");
        }
    }

}

class SeparatetheNumbers_exe {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();

                SeparatetheNumbers.separateNumbers(s);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}
