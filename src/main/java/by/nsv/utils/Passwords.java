package by.nsv.utils;

public class Passwords {
    public static String generateRandomPassword(int numberOfSymbols) {
        String randomPassword = "";
        for (int i = 1; i <= numberOfSymbols; i++) {
            randomPassword += (int) (Math.random() * 10);
        }
        System.out.println(randomPassword);
        return randomPassword;
    }
}
