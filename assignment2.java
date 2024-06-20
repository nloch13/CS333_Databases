import java.io.*;
import java.util.Random;

public class assignment2 {
    private static int dobGenerationCount = 0;

    public static void main(String[] args) {
        String[] firstNames = readNamesFromFile("firstnames.txt");
        String[] lastNames = readNamesFromFile("lastnames.txt");

        if (firstNames == null || lastNames == null || firstNames.length < 100 || lastNames.length < 100) {
            System.out.println("Please make sure you have at least 100 first names and 100 last names in your text files.");
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("child&parent_info.txt"))) {
            Random random = new Random();

            for (int i = 0; i < 5000; i++) {
                String childFirstName = getRandomElement(firstNames);
                String childLastName = getRandomElement(lastNames);
                String childDOB = generateRandomDOB(random);
                String parentFirstName = getRandomElement(firstNames);
                String parentLastName = childLastName;
                String parentPhone = generateRandomPhone(random, i);

                String line = String.format("%s, %s, %s, %s, %s, %s",
                        childFirstName, childLastName, childDOB, parentFirstName, parentLastName, parentPhone);

                writer.write(line);
                writer.newLine();
                
                // Randomly duplicate rows
                if (random.nextDouble() < 0.1) {
                    writer.write(line);
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String[] readNamesFromFile(String fileName) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            String[] names = new String[100];
            int index = 0;
            while ((line = reader.readLine()) != null && index < 100) {
                names[index++] = line.trim();
            }
            reader.close();
            return names;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String getRandomElement(String[] array) {
        Random random = new Random();
        int randomIndex = random.nextInt(array.length);
        return array[randomIndex];
    }

    private static String generateRandomDOB(Random random) {
        int month = random.nextInt(12) + 1;
        int day = random.nextInt(28) + 1;
        int year = random.nextInt(13) + 6;

        // Check if it's the 10th generation and format accordingly
        if (dobGenerationCount % 10 == 0) {
            dobGenerationCount++;
            return String.format("%02d/%02d/%04d", month, day, year);
        } else {
            dobGenerationCount++;
            return String.format("%02d/%02d/%02d", month, day, year);
        }
    }

    private static String generateRandomPhone(Random random, int recordIndex) {
        int areaCode = random.nextInt(900) + 100;
        int firstPart = random.nextInt(900) + 100;
        
        // Every 50th record is missing the last digit of the phone number
        if (recordIndex % 50 == 0) {
            String phoneNumber = String.format("%03d-%03d-");
            for (int i = 0; i < 4; i++) {
                phoneNumber += random.nextInt(10);
            }
            return phoneNumber;
        } else {
            int secondPart = random.nextInt(9000) + 1000;
            return String.format("%03d-%03d-%04d", areaCode, firstPart, secondPart);
        }
    }
}