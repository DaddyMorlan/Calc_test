import java.util.Scanner;

class MistakeException extends Exception{
    public MistakeException (String message){
        super(message);
    }
}

class Main {
    public static String calc(String input) throws MistakeException {
           try {
                String[] tokens = input.split(" ", 3);//делим одну строку на число-знак-число, ввод через пробел как в примере
                int a = Integer.parseInt(tokens[0]); // 0-й символ - первое число
                String znak = tokens[1]; // 1-й символ - знак
                int b = Integer.parseInt(tokens[2]); // 2-й символ - второе число
                int result; // результат
                if ((a <= 10 && a >= 1 && b <= 10 && b >= 1)) {
                    switch (znak) {
                        case "+":
                            result = a + b;
                            break;
                        case "-":
                            result = a - b;
                            break;
                        case "/":
                            result = a / b;
                            break;
                        case "*":
                            result = a * b;
                            break;
                        default:
                            throw new MistakeException("формат математической операции не удовлетворяет заданию - целые числа, два операнда и один оператор (+, -, /, *)");
                    }
                } else {
                    throw new MistakeException("Только числа от 1 до 10");
                }
                return Integer.toString(result); // переводим число result в строку и выводим result
            } catch (Exception e){
                throw new MistakeException("формат математической операции не удовлетворяет заданию - целые числа, два операнда и один оператор (+, -, /, *)");
            }
    }
}

class Run {
     public static void main(String[] args) throws MistakeException{
        Scanner scanner = new Scanner(System.in); //обозначение объекта сканнер
        System.out.println("Введите Ваш пример:"); // приветственная строка
        String input = scanner.nextLine(); // запрос ввода
        System.out.println("Ответ: " + Main.calc(input));
    }
}