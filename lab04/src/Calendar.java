import java.util.*;
import java.time.LocalTime;


public class Calendar {
    private final ArrayList<Meeting> monday;
    private final ArrayList<Meeting> tuesday;
    private final ArrayList<Meeting> wednesday;
    private final ArrayList<Meeting> thursday;
    private final ArrayList<Meeting> friday;
    private final ArrayList<Meeting> saturday;
    private final ArrayList<Meeting> sunday;

    public Calendar(){
        this.monday = new ArrayList<>();
        this.tuesday = new ArrayList<>();
        this.wednesday = new ArrayList<>();
        this.thursday = new ArrayList<>();
        this.friday = new ArrayList<>();
        this.saturday = new ArrayList<>();
        this.sunday = new ArrayList<>();
    }

    public void displayAllMeetings(){
        List<List<Meeting>> meetingsByDay = Arrays.asList(monday, tuesday, wednesday, thursday, friday, saturday, sunday);

        for (List<Meeting> meetings : meetingsByDay) {
            for (Meeting meeting : meetings) {
                System.out.println(meeting);
            }
        }
    }

    public void displayForMonday(){
        for (Meeting meeting : monday) {
            System.out.println(meeting);
        }
    }
    public void displayForTuesday(){
        for (Meeting meeting : tuesday) {
            System.out.println(meeting);
        }
    }
    public void displayForWednsday(){
        for (Meeting meeting : wednesday) {
            System.out.println(meeting);
        }
    }
    public void displayForThursday(){
        for (Meeting meeting : thursday) {
            System.out.println(meeting);
        }
    }
    public void displayForFriday(){
        for (Meeting meeting : friday) {
            System.out.println(meeting);
        }
    }
    public void displayForSaturday(){
        for (Meeting meeting : saturday) {
            System.out.println(meeting);
        }
    }
    public void displayForSunday(){
        for (Meeting meeting : sunday) {
            System.out.println(meeting);
        }
    }


    public void displayForMondayWithPriority(double priority){
        for (Meeting meeting : monday) {
            if (meeting.getPriority() == priority) {
                System.out.println(meeting);
            }
        }
    }
    public void displayForTuesdayWithPriority(double priority){
        for (Meeting meeting : tuesday) {
            if (meeting.getPriority() == priority) {
                System.out.println(meeting);
            }
        }
    }
    public void displayForWednsdayWithPriority(double priority){
        for (Meeting meeting : wednesday) {
            if (meeting.getPriority() == priority) {
                System.out.println(meeting);
            }
        }
    }
    public void displayForThursdayWithPriority(double priority){
        for (Meeting meeting : thursday) {
            if (meeting.getPriority() == priority) {
                System.out.println(meeting);
            }
        }
    }
    public void displayForFridayWithPriority(double priority){
        for (Meeting meeting : friday) {
            if (meeting.getPriority() == priority) {
                System.out.println(meeting);
            }
        }
    }
    public void displayForSaturdayWithPriority(double priority){
        for (Meeting meeting : saturday) {
            if (meeting.getPriority() == priority) {
                System.out.println(meeting);
            }
        }
    }
    public void displayForSundayWithPriority(double priority){
        for (Meeting meeting : sunday) {
            if (meeting.getPriority() == priority) {
                System.out.println(meeting);
            }
        }
    }


    public void displayForMondayStartFrom(LocalTime startTime){
        for (Meeting meeting : monday) {
            if (meeting.getStart().isBefore(startTime)) {
                System.out.println(meeting);
            }
        }
    }
    public void displayForTuesdayStartFrom(LocalTime startTime){
        for (Meeting meeting : tuesday) {
            if (meeting.getStart().isBefore(startTime)) {
                System.out.println(meeting);
            }
        }
    }
    public void displayForWednsdayStartFrom(LocalTime startTime){
        for (Meeting meeting : wednesday) {
            if (meeting.getStart().isBefore(startTime)) {
                System.out.println(meeting);
            }
        }
    }
    public void displayForThursdayStartFrom(LocalTime startTime){
        for (Meeting meeting : thursday) {
            if (meeting.getStart().isBefore(startTime)) {
                System.out.println(meeting);
            }
        }
    }
    public void displayForFridayStartFrom(LocalTime startTime){
        for (Meeting meeting : friday) {
            if (meeting.getStart().isBefore(startTime)) {
                System.out.println(meeting);
            }
        }
    }
    public void displayForSaturdayStartFrom(LocalTime startTime){
        for (Meeting meeting : saturday) {
            if (meeting.getStart().isBefore(startTime)) {
                System.out.println(meeting);
            }
        }
    }
    public void displayForSundayStartFrom(LocalTime startTime){
        for (Meeting meeting : sunday) {
            if (meeting.getStart().isBefore(startTime)) {
                System.out.println(meeting);
            }
        }
    }

    public  void  displayStartFrom(String day, LocalTime startTime){
        if (Objects.equals(day, "monday")){
            displayForMondayStartFrom(startTime);
        } else if (Objects.equals(day, "tuesday")){
            displayForTuesdayStartFrom(startTime);
        } else if (Objects.equals(day, "wednesday")) {
            displayForWednsdayStartFrom(startTime);
        } else if (Objects.equals(day, "thursday")) {
            displayForThursdayStartFrom(startTime);
        } else if (Objects.equals(day, "friday")){
            displayForFridayStartFrom(startTime);
        } else if (Objects.equals(day, "satarday")) {
            displayForSaturdayStartFrom(startTime);
        } else if (Objects.equals(day, "sunday")) {
            displayForSundayStartFrom(startTime);
        }
    }


    public  void  displayPriority(String day, double priority){
        if (Objects.equals(day, "monday")){
            displayForMondayWithPriority(priority);
        } else if (Objects.equals(day, "tuesday")){
            displayForTuesdayWithPriority(priority);
        } else if (Objects.equals(day, "wednesday")) {
            displayForWednsdayWithPriority(priority);
        } else if (Objects.equals(day, "thursday")) {
            displayForThursdayWithPriority(priority);
        } else if (Objects.equals(day, "friday")){
            displayForFridayWithPriority(priority);
        } else if (Objects.equals(day, "satarday")) {
            displayForSaturdayWithPriority(priority);
        } else if (Objects.equals(day, "sunday")) {
            displayForSundayWithPriority(priority);
        }
    }


    public void addToMonday( Meeting meeting){
        if (monday.size() > 0){
            meeting.setId(monday.getLast().getId()+1);
        }
        monday.add(meeting);
    }

    public  void addToTuesday( Meeting meeting){
        if (tuesday.size() > 0){
            meeting.setId(tuesday.getLast().getId()+1);
        }
        tuesday.add(meeting);
    }
    public  void addToWensday(Meeting meeting){
        if (wednesday.size() > 0){
            meeting.setId(wednesday.getLast().getId()+1);
        }
        wednesday.add(meeting);
    }

    public void addToThursday(Meeting meeting){
        if (thursday.size() > 0){
            meeting.setId(thursday.getLast().getId()+1);
        }
        thursday.add(meeting);
    }
    public void addToFriday(Meeting meeting){
        if (friday.size() > 0){
            meeting.setId(friday.getLast().getId()+1);
        }
        friday.add(meeting);
    }
    public void addToSatarday(Meeting meeting){
        if (saturday.size() > 0){
            meeting.setId(saturday.getLast().getId()+1);
        }
        saturday.add(meeting);
    }

    public void addToSunday(Meeting meeting){
        if (sunday.size() > 0){
            meeting.setId(sunday.getLast().getId()+1);
        }
        sunday.add(meeting);
    }

    public void addMeeting(String day, Meeting meeting){
        if (Objects.equals(day, "monday")){
            addToMonday(meeting);
        } else if (Objects.equals(day, "tuesday")){
           addToTuesday(meeting);
        } else if (Objects.equals(day, "wednesday")) {
            addToWensday(meeting);
        } else if (Objects.equals(day, "thursday")) {
            addToThursday(meeting);
        } else if (Objects.equals(day, "friday")){
            addToFriday(meeting);
        } else if (Objects.equals(day, "satarday")) {
            addToSatarday(meeting);
        } else if (Objects.equals(day, "sunday")) {
            addToSunday(meeting);
        }
    }

    public void displayMeeting(String day){
        if (Objects.equals(day, "monday")){
            displayForMonday();
        } else if (Objects.equals(day, "tuesday")){
            displayForTuesday();
        } else if (Objects.equals(day, "wednesday")) {
            displayForWednsday();
        } else if (Objects.equals(day, "thursday")) {
            displayForThursday();
        } else if (Objects.equals(day, "friday")){
            displayForFriday();
        } else if (Objects.equals(day, "satarday")) {
            displayForSaturday();
        } else if (Objects.equals(day, "sunday")) {
            displayForSunday();
        }
    }

    public void deleteMeeting(String day, double id){
        if (Objects.equals(day, "monday")){
            monday.removeIf(meeting -> meeting.getId() == id);
        } else if (Objects.equals(day, "tuesday")){
            tuesday.removeIf(meeting -> meeting.getId() == id);
        } else if (Objects.equals(day, "wednesday")) {
            wednesday.removeIf(meeting -> meeting.getId() == id);
        } else if (Objects.equals(day, "thursday")) {
            thursday.removeIf(meeting -> meeting.getId() == id);
        } else if (Objects.equals(day, "friday")){
            friday.removeIf(meeting -> meeting.getId() == id);
        } else if (Objects.equals(day, "satarday")) {
            saturday.removeIf(meeting -> meeting.getId() == id);
        } else if (Objects.equals(day, "sunday")) {
            sunday.removeIf(meeting -> meeting.getId() == id);
        }
    }

    public void additionalMethod() {
        List<Meeting> meetings = new ArrayList<>();
        meetings.add(new Meeting("desc1", LocalTime.of(9, 0), LocalTime.of(11, 0), 5, 2));
        meetings.add(new Meeting("desc2", LocalTime.of(8, 0), LocalTime.of(12, 0), 6, 1));
        meetings.add(new Meeting("desc3", LocalTime.of(9, 0), LocalTime.of(9, 30), 7, 2));
        meetings.add(new Meeting("desc4", LocalTime.of(9, 0), LocalTime.of(11, 0), 8, 0));
        meetings.add(new Meeting("desc5", LocalTime.of(11, 0), LocalTime.of(11, 50), 9, 2));
        meetings.add(new Meeting("desc6", LocalTime.of(14, 0), LocalTime.of(14, 30), 10, 1));
        meetings.add(new Meeting("desc7", LocalTime.of(15, 0), LocalTime.of(18, 0), 11, 2));

        for (Meeting meeting : meetings) {
            addToMonday(meeting);
        }
    }






}
