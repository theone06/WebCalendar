import java.time.LocalDate;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String year = scanner.nextLine();
        int [] dayOfYear = new int[3];

        dayOfYear[0] = scanner.nextInt();
        dayOfYear[1] = scanner.nextInt();
        dayOfYear[2] = scanner.nextInt();

        for (int i = 0; i < dayOfYear.length; i++) {
            LocalDate date = LocalDate.ofYearDay(Integer.parseInt(year), dayOfYear[i]);
            System.out.println(date);
        }

    }
}