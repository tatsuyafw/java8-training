package chapter5.exercise04;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Arrays;
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

    // TODO: Refactoring...
    private List<String> weekLines() {
        List<String> lines = new ArrayList<>();
        LocalDate date = this.yearMonth.atDay(1);
        LocalDate startOfNextMonth = yearMonth.plusMonths(1).atDay(1);
        StringBuilder lineBuilder = new StringBuilder();

        while ( ! date.equals(startOfNextMonth) ) {
            DayOfWeek currentDayOfWeek = date.getDayOfWeek();
            // 月始まりの場合は行の始まりの部分に曜日の数の空白埋める
            if ( date.getDayOfMonth() == 1 ) {
                int count = currentDayOfWeek.getValue() - DayOfWeek.MONDAY.getValue();
                String[] spaces = new String[count];
                Arrays.fill(spaces, "  "); // 一日は空白２つぶん
                lineBuilder.append(String.join(" ", spaces));
            }

            // 週始まりである月曜日以外は空白を挿入
            if ( ! date.getDayOfWeek().equals( DayOfWeek.MONDAY )) {
                lineBuilder.append(" ");
            }
            // 10 未満の一桁の日付の場合空白を挿入
            if ( date.getDayOfMonth() < 10 ) {
                lineBuilder.append(" ");
            }

            lineBuilder.append(date.getDayOfMonth());

            // 日曜の場合は改行
            if (date.getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
                lines.add(lineBuilder.toString());
                lineBuilder = new StringBuilder();
            }

            date = date.plusDays(1);
        }
        // 最後の行が残っている場合は追加
        if (lineBuilder.length() != 0) {
            lines.add(lineBuilder.toString());
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
