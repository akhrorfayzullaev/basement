package test;

import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class ClassTest {
    public static double number1=90.3,number2=23.3;
    public static void main(String[] args) {
        /*MainInterface <Integer> typeInt = ((value1, value2) -> value1+value2 );
        System.out.println(typeInt.mainMEthod(150, 550));

        MainInterface <String> typeString = ((value1, value2) -> value1.concat(value2));
        System.out.println(typeString.mainMEthod("Scanner scanner", " = new Scanner (System.in);"));*/

        Operation  operation = ()->number1+number2;
        System.out.println(operation.getResult());



        Predicate <String> predicate = string -> string.equals("lambda is monster");
        System.out.println(predicate.test("lambda is monster"));

        int [] arr = {-10,-15,10,14,84,60,30,0,-25,-60,-50};
        for (int number: arr) {
            if (number>0){
                System.out.print(number+" ");
            }
        }
        IntStream.of(arr).filter(simpleNumber->simpleNumber>0).forEach(System.out::println);

        Person mail = new Person(15,35);
        Person femail = new Person(45,65);

    }
    public double showResult(double value1,double value2){
        return value1+value2;
    }
}
