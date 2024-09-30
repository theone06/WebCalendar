import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] date = input.split(" ");
        int year = Integer.parseInt(date[0]);
        int month = Integer.parseInt(date[1]);
        int nDays = Integer.parseInt(date[2]);
        LocalDate output = LocalDate.of(year, month, 1);
        System.out.println(output.plusDays(output.lengthOfMonth() - nDays));

    }
}