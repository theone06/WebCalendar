import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String dateString = scanner.nextLine();
        LocalDate date = LocalDate.parse(dateString);
        date = date.plusWeeks(2);
        System.out.println(date);
    }
}