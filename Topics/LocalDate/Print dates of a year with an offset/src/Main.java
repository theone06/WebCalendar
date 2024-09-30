import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String givenDate = scanner.nextLine();
        long offsetDays = scanner.nextLong();
        LocalDate date = LocalDate.parse(givenDate);
        LocalDate yearEnd = LocalDate.of(date.getYear(), 12, 31);

        while (date.isBefore(yearEnd) || date.isEqual(yearEnd)) {
            System.out.println(date);
            date = date.plusDays(offsetDays);
        }

    }
}