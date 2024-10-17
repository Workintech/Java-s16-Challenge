package Shared;

import java.time.LocalDate;

public class CustomDate {
    private int day;
    private int month;
    private int year;

    // Constructor
    public  CustomDate(int day, int month, int year) {
        if (isValidDate(day, month, year)) {
            this.day = day;
            this.month = month;
            this.year = year;
        } else {
            throw new IllegalArgumentException("Invalid date");
        }
    }

    public static CustomDate now(){
        LocalDate currentDate = LocalDate.now();
        int year = currentDate.getYear();
        int month = currentDate.getMonthValue();
        int day = currentDate.getDayOfMonth();
        return new CustomDate(day,month,year);
    }

    // Getters
    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    // Setters with validation
    public void setDay(int day) {
        if (isValidDate(day, this.month, this.year)) {
            this.day = day;
        } else {
            throw new IllegalArgumentException("Invalid day");
        }
    }

    public void setMonth(int month) {
        if (isValidDate(this.day, month, this.year)) {
            this.month = month;
        } else {
            throw new IllegalArgumentException("Invalid month");
        }
    }

    public void setYear(int year) {
        if (isValidDate(this.day, this.month, year)) {
            this.year = year;
        } else {
            throw new IllegalArgumentException("Invalid year");
        }
    }

    // Method to check if the date is valid
    private boolean isValidDate(int day, int month, int year) {
        if (year < 0) {
            return false;
        }
        if (month < 1 || month > 12) {
            return false;
        }
        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        // Check for leap year
        if (isLeapYear(year)) {
            daysInMonth[1] = 29; // February has 29 days in leap year
        }

        return day > 0 && day <= daysInMonth[month - 1];
    }

    // Leap year checker
    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    // Method to display the date as a string
    @Override
    public String toString() {
        return String.format("%02d/%02d/%04d", day, month, year);
    }

    // Compare two dates (returns true if this date is earlier than another)
    public boolean isEarlierThan(CustomDate other) {
        if (this.year < other.year) {
            return true;
        } else if (this.year == other.year) {
            if (this.month < other.month) {
                return true;
            } else if (this.month == other.month) {
                return this.day < other.day;
            }
        }
        return false;
    }
    // Check if two dates are equal
    public boolean equals(CustomDate other) {
        return this.day == other.day && this.month == other.month && this.year == other.year;
    }
}
