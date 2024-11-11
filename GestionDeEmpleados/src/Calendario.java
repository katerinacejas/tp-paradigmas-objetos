import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.YearMonth;

public class Calendario {

    public int diasHabilesMesActual(int mesActual) {
        int anio = LocalDate.now().getYear();
        YearMonth anioMes = YearMonth.of(anio, mesActual);

        return (int) anioMes.atDay(1)
                .datesUntil(anioMes.atEndOfMonth())
                .filter(date -> (date.getDayOfWeek() != DayOfWeek.SATURDAY) && (date.getDayOfWeek() != DayOfWeek.SUNDAY))
                .count();
    }
}
