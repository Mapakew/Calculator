import java.io.IOException;
import java.util.Scanner;

public class Kalk {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String stroka = scn.nextLine();
        System.out.println(calc(stroka));

    }
    public static String calc(String stroka) {

        int a;
        int b;
        boolean c;
        String znak = oprZnak(stroka);
        String rezultat;
        String[] chisla = stroka.split("[+\\-*/]");

        if (chisla.length != 2)
            try {
                throw new IOException();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        if (!Rimskie.proverka(chisla[0]) && !Rimskie.proverka(chisla[1])) {
            a = Integer.parseInt(chisla[0]);
            b = Integer.parseInt(chisla[1]);
            c = false;
        } else if (Rimskie.proverka(chisla[0]) && Rimskie.proverka(chisla[1])) {
            a = Rimskie.rimToArab(chisla[0]);
            b = Rimskie.rimToArab(chisla[1]);
            c = true;

        } else try {
            throw new IOException();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if (a > 10 || b > 10)
            try {
            throw new IOException();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        int x = raschet(a, b, znak);
        if (c) {
            if (x <= 0) {
                try {
                    throw new IOException();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else rezultat = Rimskie.arabToRim(x);
        } else rezultat = String.valueOf(x);
    return rezultat;
    }

    static String oprZnak(String h){
        if(h.contains("+")) return "+";
        else if (h.contains("-")) return "-";
        else if (h.contains("*")) return "*";
        else return "/";
    }

       static int raschet(int a, int b, String znak){
        if(znak.equals("+")) return a+b;
        else if (znak.equals("-")) return a-b;
        else if (znak.equals("*")) return a*b;
        else return a/b;
    }
}


