package ru.helpclasses;

import java.util.Arrays;
import java.util.Date;
import java.util.Random;

/**
 * Simple random (simulated) data generator.
 */
public final class Randomizer {

    static Random random = new Random();

    // Random Strings:

    public static String randomFirstName() {
        return randomString(7, 7);
    }

    public static String randomMiddleName() {
        return randomString(10, 10);
    }

    public static String randomLastName() {
        return randomString(10, 10);
    }

    public static String randomStreet() {
        return randomString(10, 10);
    }

    public static String randomCity() {
        return randomString(10, 10);
    }

    public static String randomZip() {
        return randomNumString(5, 5);
    }

    public static String randomCountry() {
        return randomString(8, 8);
    }

    public static String randomPhone() {
        return randomNumString(10, 10);
    }

    public static String randomEmail() {
        return randomString(5, 5) + "@" +
                randomString(6, 6) + "." + randomString(2, 2);
    }

    public static String randomString(int minLength, int maxLength) {
        return randomString(randomInt(minLength, maxLength), 'A', 'Z');
    }

    public static String randomNumString(int minLength, int maxLength) {
        return randomString(randomInt(minLength, maxLength), '0', '9');
    }

    static String randomString(int length, char from, char to) {
        char[] chars = new char[length];
        for (int i = 0; i < length; i++) {
            chars[i] = (char)randomInt(from, to);
        }
        return new String(chars);
    }

    // Random Dates:

    public static Date[] randomDates(int count) {
        Date[] dates = new Date[count];
        for (int i = 0; i < count; i++)
            dates[i] = randomDate();
        Arrays.sort(dates);
        return dates;
    }

    private static Date randomDate() {
        long time = (random.nextLong() & 0x1FFFFFFFFFFL) - 0xFFFFFFFFFFL;
        return new Date(time);
    }

    // Random Numbers:

    public static int randomInt(int min, int max) {
        return max <= min ? min : (random.nextInt(max - min + 1) + min);
    }
}
