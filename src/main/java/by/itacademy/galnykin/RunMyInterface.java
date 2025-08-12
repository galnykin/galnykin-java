package by.itacademy.galnykin;

import java.util.function.Predicate;

public class RunMyInterface {
    public static void main(String[] args) throws Exception {
//        MyInterface myPredicate = x -> x > 0;
//        System.out.println(myPredicate.check(10));   //true
//
//        //Аналогично, но используется встроенный функциональный интерфейс java.util.function.Predicate
//        Predicate<Integer> predicate = x -> x > 0;
//        System.out.println(predicate.test(-10));    //false
//
//        predicate = x -> x == 0;
//        System.out.println(predicate.test(-0));

//        ICalc calc = (a, b) -> a + b;
//        System.out.println(calc.method(Integer.MAX_VALUE, 5));

//        calc = (a, b) -> a - b;
//        System.out.println(calc.method(6, 5));
//
//        calc = (a, b) -> a * b;
//        System.out.println(calc.method(6, 5));

        ICalculator calculator = new Calculator();
        System.out.println(calculator.sum(1, Integer.MAX_VALUE));

//        System.out.println(calculator.subtract(Integer.MIN_VALUE, 0));
    }
}
