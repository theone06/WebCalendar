import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] date = input.split("-");
        String year = date[0];
        String month = date[1];
        String day = date[2];
        LocalDate givenDate = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));

        System.out.println(givenDate.minusYears(30));
        System.out.println(givenDate.plusYears(30));
    }
}