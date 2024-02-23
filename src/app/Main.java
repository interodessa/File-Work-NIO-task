package app;
import java.io.IOException;
import java.util.Scanner;

public class Main {
public static void main(String[] args) throws IOException {
        choice();
    }
    private static void choice() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                Input number of your choice
                1)Write to file
                2)Read from file
                """);
        int choice = scanner.nextInt();
        if(choice == 1){
            FileWriteService toFile = new FileWriteService();
            System.out.println(toFile.toFile(text(),fileName()));
        }
        else if (choice == 2){
            FileReadService fromFile = new FileReadService();
            System.out.println(fromFile.fromFile(fileName()));
        }else {
            System.out.println("Input 1 or 2");
        }
    }
    private static String text(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type text\n");
        return scanner.nextLine();
    }
    private static String fileName(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("File name\n");
        return scanner.nextLine();
    }
}
