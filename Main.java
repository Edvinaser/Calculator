import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String input = null;
        System.out.println(calc(input));
    }

    public static String calc(String input) {
        int n1real = 0, n2real = 0, rezultrim = 0;
        int num1 = 0;
        int num2 = 0;
        boolean n1rom = false, n2rom = false;
        char[] task1 = new char[10];
        String[] rim = new String[13];
        rim[0] = "I";
        rim[1] = "II";
        rim[2] = "III";
        rim[3] = "IV";
        rim[4] = "V";
        rim[5] = "VI";
        rim[6] = "VII";
        rim[7] = "VIII";
        rim[8] = "IX";
        rim[9] = "X";
        rim[10] = "XL";
        rim[11] = "L";
        rim[12] = "C";
        Scanner in = new Scanner(System.in);
        String task = in.nextLine();
        String[] splitting = new String[3];
        String Str = new String(task);
        int i = 0;

        try {
            for (String retval : Str.split(" ")) {
                splitting[i] = retval;
                i++;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            e.getStackTrace();
            System.exit(0);
        }

        if (null == splitting[0] || splitting[0].isEmpty()) {
            System.exit(0);
        }
        if (null == splitting[2] || splitting[2].isEmpty()) {
            System.exit(0);
        }
        if (splitting[1].length() > 1) {
            System.exit(0);
        }


        try {
            num1 = Integer.parseInt(splitting[0]);
        } catch (NumberFormatException e) {
            n1rom = true;
        }
        try {
            num2 = Integer.parseInt(splitting[2]);
        } catch (NumberFormatException e) {
            n2rom = true;
        }
        if (n2rom != n1rom) {
        } else if (n1rom == true) {
            if (splitting[0].equals(rim[3])) n1real = 4;
            else if (splitting[0].equals(rim[8])) n1real = 9;
            else {
                char[] romechar1 = splitting[0].toCharArray();
                for (i = 0; i < romechar1.length; i++) {
                    switch (romechar1[i]) {
                        case 'I':
                            n1real = n1real + 1;
                            break;
                        case 'V':
                            n1real = n1real + 5;
                            break;
                        case 'X':
                            n1real = n1real + 10;
                            break;

                    }
                }
            }
            if (splitting[2].equals(rim[3])) n2real = 4;
            else if (splitting[2].equals(rim[8])) n2real = 9;
            else {
                char[] romechar2 = splitting[2].toCharArray();
                for (i = 0; i < romechar2.length; i++) {
                    switch (romechar2[i]) {
                        case 'I':
                            n2real = n2real + 1;
                            break;
                        case 'V':
                            n2real = n2real + 5;
                            break;
                        case 'X':
                            n2real = n2real + 10;
                            break;

                    }
                }
            }
            if (n1real < 0) ;
            else if (n1real > 10.1) ;
            else if (n2real < 0) ;
            else if (n2real > 10.1) ;
            else {
                task1 = task.toCharArray();
                for (int b = 0, n = task1.length; b < n; b++) {
                    switch (task1[b]) {
                        case '+':
                            rezultrim = n1real + n2real;
                            break;
                        case '-':
                            rezultrim = n1real - n2real;
                            break;
                        case '*':
                            rezultrim = n1real * n2real;
                            break;
                        case '/':
                            rezultrim = n1real / n2real;
                            break;
                    }
                }
            }
            if (rezultrim > 0) {
                if (rezultrim <= 10)
                    System.out.println(rim[rezultrim - 1]);
                else {
                    char[] convert = ("" + rezultrim).toCharArray();
                    String[] romanNumeral = new String[10];
                    if (convert.length == 100) System.out.println(rim[12]);
                    else {
                        switch (convert[0]) {
                            case '1':
                                romanNumeral[0] = rim[9];
                                break;
                            case '2':
                                romanNumeral[0] = rim[9];
                                romanNumeral[1] = rim[9];
                                break;
                            case '3':
                                romanNumeral[0] = rim[9];
                                romanNumeral[1] = rim[9];
                                romanNumeral[3] = rim[9];
                                break;
                            case '4':
                                romanNumeral[0] = rim[10];
                                break;
                            case '5':
                                romanNumeral[0] = rim[11];
                                break;
                            case '6':
                                romanNumeral[0] = rim[11];
                                romanNumeral[1] = rim[9];
                                break;
                            case '7':
                                romanNumeral[0] = rim[11];
                                romanNumeral[1] = rim[9];
                                romanNumeral[2] = rim[9];
                                break;
                            case '8':
                                romanNumeral[0] = rim[11];
                                romanNumeral[1] = rim[9];
                                romanNumeral[2] = rim[9];
                                romanNumeral[3] = rim[9];
                                break;
                            case '9':
                                romanNumeral[0] = rim[11];
                                romanNumeral[1] = rim[10];
                                break;

                        }
                        for (i = 0; i < romanNumeral.length; i++) {
                            if (romanNumeral[i] != null)
                                System.out.print(romanNumeral[i]);
                        }
                        i = Character.getNumericValue(convert[1]);
                        i = i - 1;
                        if (i > 0)
                            System.out.print(rim[i]);
                    }

                }
            } else
                System.exit(0);
        } else if (num1 < 0) ;
        else if (num1 > 10.1) ;
        else if (num2 < 0) ;
        else if (num2 > 10.1) ;
        else {
            task1 = task.toCharArray();
            for (int b = 0, n = task1.length; b < n; b++) {
                switch (task1[b]) {
                    case '+':
                        input = String.valueOf(num1 + num2);
                        break;
                    case '-':
                        input = String.valueOf(num1 - num2);
                        break;
                    case '*':
                        input = String.valueOf(num1 * num2);
                        break;
                    case '/':
                        input = String.valueOf(num1 / num2);
                        break;
                }
            }
        }
        return (input);
    }
}
