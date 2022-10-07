import java.util.*;

class StringMethos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the string :");
        String str = sc.nextLine();
        System.out.print("Enter another string : ");
        String str2 = sc.nextLine();

        // length method which gives us a length of string
        System.out.println("str.length() : " + str.length());

        // charAt method which gives us a character which is present in specific index
        // of string
        System.out.println("str.charAt(2) : " + str.charAt(2));

        // substring method gives us a specifice part of string which is entered by user
        System.out.println("str.substring(3,6) : " + str.substring(3, 6));

        // equal method check if two strings are equal or not
        System.out.println("str.equals(str2) : " + str.equals(str2));

        // equalIgnoreCase method compare two string by ignoring case
        System.out.println("str.equalsIgnoreCase(str2) : " + str.equalsIgnoreCase(str2));

        // tolowercase method convert the string into lower case
        System.out.println("str.toLowerCase() : " + str.toLowerCase());

        // touppercase method convert the string into upper case
        System.out.println("str.toUpperCase() : " + str.toUpperCase());

        // trim method removes white space from beginning and end.
        System.out.println("str.trim() : " + str.trim());
    }
}