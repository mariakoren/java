import java.time.LocalTime;
public class Meeting {

    private String description;
    private LocalTime start;
    private LocalTime end;
    private double id;
    private double priority;
    public final LocalTime  EARLIEST_START = LocalTime.of(8, 0);

    Meeting(String description, LocalTime start, LocalTime end, double id, double priority ){
        this.description = description;
        this.start = start;
        this.end = end;
        this.id = id;
        this.priority = priority;
    }

    public String getDescription() {
        return description;
    }

    public LocalTime getStart() {
        return start;
    }

    public void setStart(LocalTime start) {
        if (!start.isBefore(EARLIEST_START)) {
            this.start = start;
        }
    }

    public LocalTime getEnd() {
        return end;
    }

    public void setEnd(LocalTime end) {
        if (end.isBefore(LocalTime.of(23, 59))) {
            this.end = end;
        }

    }

    public double getId(){
        return id;
    }

    public void setId(double id) {
        this.id = id;
    }

    public double getPriority() {
        return priority;
    }

    public void setPriority(double priority) {
        if (isValidate(priority)){
            this.priority = priority;
        }
    }

    public boolean isValidate(double priority){
        return priority == 1 || priority == 2 || priority == 3;
    }

    @Override
    public String toString() {
        return "This meeding have an id: " + getId() +
                " start at " + getStart() +
                " end at " + getEnd() +
                " have priority " + getPriority();
    }

    
}
