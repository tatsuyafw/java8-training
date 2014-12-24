package chapter5.exercise04;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class PritableMonth {
    private static final int LINE_LENGTH = 20;

    private YearMonth yearMonth;

    public PritableMonth(YearMonth yearMonth) {
        this.yearMonth = yearMonth;
    }

    public void printMonth() {
        System.out.println(headLine());
        for (String line : weekLines()) {
            System.out.println(line);
        }
    }

    private List<String> weekLines() {
        List<String> lines = new ArrayList<>();
        LocalDate date = this.yearMonth.atDay(1);
        StringBuilder lineBuilder = new StringBuilder();
        // [WIP]
        while ( date != this.yearMonth.atEndOfMonth() ) {
            date = date.plusDays(1);
        }

        return lines;
    }

    private String headLine() {
        String month = this.yearMonth.getMonth().getDisplayName(TextStyle.SHORT, Locale.JAPANESE);
        String year = String.valueOf(this.yearMonth.getYear());
        String head = month + " " + year;

        int paddingLeftLength = (int) Math.round((LINE_LENGTH - head.length()) / 2.0);
        int paddingRightLength = (LINE_LENGTH - head.length()) / 2;
        String paddingLeft = stringBuild(' ', paddingLeftLength);
        String paddingRight = stringBuild(' ', paddingRightLength);
        return paddingLeft + head + paddingRight;
    }

    private String stringBuild(char c, int length) {
        StringBuilder builder= new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            builder.append(c);
        }
        return builder.toString();
    }
}
