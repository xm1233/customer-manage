package utiliy;

import java.util.Scanner;

public class utility {
    public static char readmenue() {
    Scanner sc = new Scanner(System.in);
    char c;
    for (; ; ) {
        String s = sc.nextLine();
        c = s.charAt(0);
        if ((c != '1') && (c != '2') && (c != '3') && (c != '4')&&(c!='5')) {
            System.out.println("输入错误，请重新输入");
        } else break;
    }
    return c;
}
    public static char out(){
        Scanner sc = new Scanner(System.in);
        char c;
        for (; ; ) {
            String s = sc.nextLine();
            c = s.charAt(0);
            if ((c == 'Y') || (c == 'N') ) {
                break;
            } else System.out.println("输入错误，请重新输入");
        }
        return c;
    }

    public static int readint(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        return n;
    }

    public static int readint(int defaultValue){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int n=Integer.parseInt(s);
        return s.equals("")?defaultValue:n;
    }

    public static char readchar(){
        Scanner sc= new Scanner(System.in);
        String s = sc.nextLine();
        char c = s.charAt(0);
        return c;
    }

    public static char readchar(char defaultValue){
        Scanner sc= new Scanner(System.in);
        String s = sc.nextLine();
        return (s.length()==0)?defaultValue:s.charAt(0);
    }

    public static String readstring() {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        return s;
    }

    public static String readstring(String defaultValue) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        return s.equals("")?defaultValue:s;
    }
}

