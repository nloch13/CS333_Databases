import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class cleandata {
    public static void main(String[] args) {
        List<String> records = new ArrayList<>();
        Set<String> uniqueRecords = new HashSet<>();
        int fourDigitYearCount = 0;
        int missingPhoneNumberCount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader("child&parent_info.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                records.add(line);
                uniqueRecords.add(line);
                String[] parts = line.split(", ");
                if (parts.length >= 3) {
                    String yearPart = parts[2].trim().substring(6);
                    if (yearPart.length() == 4) {
                        fourDigitYearCount++;
                    }
                    if (parts.length >= 6 && parts[5].trim().equals("IN")) {
                        missingPhoneNumberCount++;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        int duplicateRecordCount = records.size() - uniqueRecords.size();

        System.out.println("Number of records that have four-digit years: " + fourDigitYearCount);
        System.out.println("Number of records that have missing data in the phone number: " + missingPhoneNumberCount);
        System.out.println("Number of duplicated records: " + duplicateRecordCount);

        // Modify the data cleaning program to address the issues
        List<String> cleanedRecords = records.stream()
                .distinct() // Remove duplicates
                .map(line -> {
                    String[] parts = line.split(", ");
                    if (parts.length >= 3) {
                        String yearPart = parts[2].trim().substring(6);
                        if (yearPart.length() == 2) {
                            parts[2] = parts[2].replace(yearPart, "20" + yearPart); // Assume years in the format YY should be YY -> YYYY
                        }
                        if (parts.length >= 6 && parts[5].trim().equals("IN")) {
                            parts[5] = "INCOMPLETE";
                        }
                    }
                    return String.join(", ", parts);
                })
                .collect(Collectors.toList());

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("cleaned_child_parent_data.txt"))) {
            for (String record : cleanedRecords) {
                writer.write(record);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}