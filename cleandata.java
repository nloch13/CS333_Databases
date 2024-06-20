import java.io.*;
import java.util.*;


public class cleandata {
    public static void main(String[] args) {
        int numberOfFourDigitYears = 0;
        int numberOfMissingPhoneNumbers = 0;
        int numberOfDuplicatedRecords = 0;

        System.out.println("Number of records that have four-digit years: " + numberOfFourDigitYears);
        System.out.println("Number of records that have missing data in the phone number: " + numberOfMissingPhoneNumbers);
        System.out.println("Number of duplicated records: " + numberOfDuplicatedRecords);
    }
}