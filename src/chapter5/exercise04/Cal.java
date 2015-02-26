package chapter5.exercise04;

import java.time.Month;
import java.time.Year;
import java.time.YearMonth;

public class Cal {
    public static void main(String[] args) {
        Options options = parseOptions(args);
        PritableMonth month = new PritableMonth(YearMonth.of(options.year.getValue(), options.month));
        month.printMonth();
    }

    public static Options parseOptions(String[] args) {
        validationArguments(args);
        Month month = Month.of(Integer.parseInt(args[0]));
        Year year   = Year.of(Integer.parseInt(args[1]));
        return new Options(year, month);
    }

    public static void validationArguments(String[] args) {
        if ( args.length != 2 ) {
            usage();
            System.exit(1);
        }
        int month = 0, year = 0;
        try {
            month = Integer.parseInt(args[0]);
            year = Integer.parseInt(args[1]);
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
            System.exit(1);
        }

        if ( month <= 0 || month > 12 ) {
            System.err.println("month must be 1 - 12");
            usage();
            System.exit(1);
        }
        if ( year <= 0 ) {
            System.err.println("year must be greater than or equal to 0");
            usage();
            System.exit(1);
        }
    }

    public static void usage() {
        System.out.println("Usage: ");
        System.out.println("  $ java Cal month year");
        System.out.println();
        System.out.println("Samples: ");
        System.out.println("  $ java Cal 3 2014");
        System.out.println("  $ java Cal 11 2014");
    }

    private static class Options {
        private Year year;
        private Month month;

        private Options(Year year, Month month) {
            this.year = year;
            this.month = month;
        }
    }
}
