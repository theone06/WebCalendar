import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] date = input.split(" ");
        String year = date[0];
        String month = date[1];

        LocalDate start = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), 1);
        LocalDate end = start.withDayOfMonth(start.lengthOfMonth());

        while (start.isBefore(end) || start.isEqual(end)) {
            if (start.getDayOfWeek().getValue() == java.time.DayOfWeek.MONDAY.getValue()) {
                System.out.println(start);
            }
            start = start.plusDays(1);
        }



    }
}
