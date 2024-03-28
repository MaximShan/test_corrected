import java.util.Objects;
import java.util.Scanner;
import java.util.Arrays;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {


        Roman roman = new Roman();
        Scanner console = new Scanner(System.in);
        System.out.println("Введите операцию с 2-я цифрами не более 10: ");
        String operation = console.nextLine();
        String operation2 = operation.replaceAll("\\s+", "");
        String[] arr = operation2.split("");
        String[] operations = {"+", "-", "/", "*"};
        String operator = "";
        int count = 0;
        for (String s : arr) {
            if (Objects.equals(s, "-") || Objects.equals(s, "+") || Objects.equals(s, "*") || Objects.equals(s, "/")) {
                count++;
            }
        }

        if(count > 1){
            try{
                throw new IOException();
            }catch (IOException e){
                throw new IOException();
            }
        }

        if (operation.contains("-") || operation.contains("+") || operation.contains("*") || operation.contains("/"))
        {
            for (String s : arr) {

                for (String string : operations) {
                    if (Objects.equals(s, string)) {
                        operator = string;
                        break;
                    }
                }

            }
        }else {
            try{
                throw new IOException();
            }catch (IOException e){
                throw new IOException();
            }
        }




        int index = -1;
        for (int i=0;i<arr.length;i++) {
            if (arr[i].equals(operator)) {
                index = i;
                break;
            }

        }
        String[] newArr1 = Arrays.copyOfRange(arr, 0 , index);
        String[] newArr2 = Arrays.copyOfRange(arr,index + 1, arr.length);



        String number1 = String.join("", newArr1);
        String number2 = String.join("", newArr2);

        int count2 = 0;
        for (String s : newArr1) {
            if (Objects.equals(s, "I")) {
                count2++;
            }
        }

        if(count2 > 3){
            try{
                throw new IOException();
            }catch (IOException e){
                throw new IOException();
            }
        }

        int count3 = 0;
        for (String s : newArr2) {
            if (Objects.equals(s, "I")) {
                count3++;
            }
        }

        if(count3 > 3){
            try{
                throw new IOException();
            }catch (IOException e){
                throw new IOException();
            }
        }


        var regex = "A-Za-zА-Яа-я&&[^IVX]+";
        if (number1.matches(regex)){
            try{
                throw new IOException();
            }catch (IOException e){
                throw new IOException();
            }
        }
        if (number2.matches(regex)){
            try{
                throw new IOException();
            }catch (IOException e){
                throw new IOException();
            }
        }





        if (number1.contains("I") || number1.contains("V") || number1.contains("X")) {
            if (number2.contains("I") || number2.contains("V") || number2.contains("X")){


                int numb1 = roman.romanToInt(number1);
                int numb2 = roman.romanToInt(number2);
                int resultat = 0;
                if (numb1 > 10 || numb2 > 10){
                    try{
                        throw new IOException();
                    }catch (IOException e){
                        throw new IOException();
                    }
                }
                resultat = switch (operator) {
                    case "+" -> {
                        System.out.println("Ваш ответ: ");
                        yield numb1 + numb2;
                    }
                    case "-" -> {
                        System.out.println("Ваш ответ: ");
                        yield numb1 - numb2;
                    }
                    case "*" -> {
                        System.out.println("Ваш ответ: ");
                        yield numb1 * numb2;
                    }
                    case "/" -> {
                        System.out.println("Ваш ответ: ");
                        yield numb1 / numb2;
                    }
                    default -> resultat;
                };
                int x = resultat;
                int units = x%10;
                int tens = (x%100)/10;
                int hundreds = (x%1000)/100;

                if(x <= 0){
                    try{
                        throw new IOException();
                    }catch (IOException e){
                        System.out.println("Невозможно вывести результат который меньше или эквивалентен нулю");
                        System.exit(1);
                    }
                }

                System.out.println(Hundreds(hundreds) + Tens(tens) + Units(units));



            }else{
                try{
                    throw new IOException();
                }catch (IOException e){
                    throw new IOException();
                }

            }} else if (number2.contains("I") || number2.contains("V") || number2.contains("X") || number2.contains("M")) {
            try{
                throw new IOException();
            }catch (IOException e){
                throw new IOException();
            }
        }else{
            if (Integer.parseInt(number1) > 10 || Integer.parseInt(number2) > 10){
                try{
                    throw new IOException();
                }catch (IOException e){
                    throw new IOException();
                }
            }
            switch (operator){
                case "+":
                    System.out.println("Ваш ответ: ");
                    System.out.print(Integer.parseInt(number1) + Integer.parseInt(number2));
                    break;

                case "-":
                    System.out.println("Ваш ответ: ");
                    System.out.print(Integer.parseInt(number1) - Integer.parseInt(number2));
                    break;
                case "*":
                    System.out.println("Ваш ответ: ");
                    System.out.print(Integer.parseInt(number1) * Integer.parseInt(number2));
                    break;
                case "/":
                    System.out.println("Ваш ответ: ");
                    System.out.print(Integer.parseInt(number1) / Integer.parseInt(number2));
                    break;
            }
        }
    }



    public static class Roman {

        public int getArabian(char roman){
            if('I' == roman) return 1;
            else if('V' == roman) return 5;
            else if('X' == roman) return 10;
            else if('L' == roman) return 50;
            else if('C' == roman) return 100;
            else if('D' == roman) return 500;
            else if('M' == roman) return 1000;
            return 0;

        }

        public int romanToInt(String s) {



            int end = s.length()-1;
            char[] arr = s.toCharArray();
            int arabian;
            int result = getArabian(arr[end]);
            for (int i = end-1; i >=0; i--) {
                arabian = getArabian(arr[i]);

                if (arabian < getArabian(arr[i + 1])) {
                    result -= arabian;
                } else {
                    result += arabian;
                }


            }
            return result;

        }
    }
    public static String Units(int units) {
        String s_units = switch (units) {
            case 1 -> "I";
            case 2 -> "II";
            case 3 -> "III";
            case 4 -> "IV";
            case 5 -> "V";
            case 6 -> "VI";
            case 7 -> "VII";
            case 8 -> "VIII";
            case 9 -> "IX";
            default -> "";
        };
        return s_units;
    }
    public static String Tens(int tens) {
        String s_tens = switch (tens) {
            case 1 -> "X";
            case 2 -> "XX";
            case 3 -> "XXX";
            case 4 -> "XL";
            case 5 -> "L";
            case 6 -> "LX";
            case 7 -> "LXX";
            case 8 -> "LXXX";
            case 9 -> "XC";
            default -> "";
        };
        return s_tens;
    }
    public static String Hundreds(int hundreds) {
        String s_hundreds="";
        if (hundreds == 1) {
            s_hundreds = "C";
        }
        return s_hundreds;
    }
}
