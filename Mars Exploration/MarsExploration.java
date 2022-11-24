import java.io.*;

public class MarsExploration {

    public static int marsExploration(String s) {
        int len = s.length();
        int count = 0;
        for (int i = 0; i <= len-3; i=i+3) {
            if(!s.substring(i,i+3).equals("SOS")){
                 count += countdifchar(s.substring(i,i+3));
            }
        }
        return count;
    }
    static int countdifchar(String ss){
        int count = 0;
        if(ss.charAt(0)!='S'){
            count++;
        }
         if(ss.charAt(1)!='O'){
            count++;
        }
         if(ss.charAt(2)!='S'){
            count++;
        }
        
        return count;
    }
}

class MarsExploration_exe {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        int result = MarsExploration.marsExploration(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
