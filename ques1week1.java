public class ques1week1 {

    public static void checkDuplicateSeats(int[] seatNumbers) {
        if (seatNumbers == null || seatNumbers.length == 0) {
            System.out.println("Invalid input.");
            return;
        }

        boolean foundDuplicate = false;
        for (int i = 0; i < seatNumbers.length; i++) {
            boolean alreadyPrinted = false;
            for (int k = 0; k < i; k++) {
                if (seatNumbers[i] == seatNumbers[k]) {
                    alreadyPrinted = true;
                    break;
                }
            }
            if (alreadyPrinted) {
                continue;
            }

            for (int j = i + 1; j < seatNumbers.length; j++) {
                if (seatNumbers[i] == seatNumbers[j]) {
                    System.out.println("Duplicate Seat Number Found: " + seatNumbers[i]);
                    foundDuplicate = true;
                    break;
                }
            }
        }

        if (!foundDuplicate) {
            System.out.println("No Duplicate Seats Found");
        }
    }

    public static void checkTypingAccuracy(String original, String typed) {
        if (original == null || typed == null) {
            System.out.println("Invalid input.");
            return;
        }

        if (original.length() != typed.length()) {
            System.out.println("Error: Strings must be of equal length.");
            return;
        }

        int totalChars = original.length();
        int matchedChars = 0;
        int firstMismatchPos = -1;
        char origMismatchChar = ' ';
        char typedMismatchChar = ' ';

        for (int i = 0; i < totalChars; i++) {
            char c1 = original.charAt(i);
            char c2 = typed.charAt(i);

            if (c1 == c2) {
                matchedChars++;
            } else {
                if (firstMismatchPos == -1) {
                    firstMismatchPos = i + 1;
                    origMismatchChar = c1;
                    typedMismatchChar = c2;
                }
            }
        }

        double accuracy = ((double) matchedChars / totalChars) * 100;
        String result = String.format("Matched: %d/%d | Accuracy: %.2f%% | ", matchedChars, totalChars, accuracy);

        if (firstMismatchPos != -1) {
            result += String.format("First Mismatch at position %d ('%c' vs '%c')", firstMismatchPos, origMismatchChar, typedMismatchChar);
        } else {
            result += "No Mismatches";
        }

        System.out.println(result);
    }

    public static void findLongestStreak(String signalLog) {
        if (signalLog == null || signalLog.length() == 0) {
            System.out.println("Invalid input.");
            return;
        }

        char maxChar = signalLog.charAt(0);
        int maxStreak = 1;

        char currentChar = signalLog.charAt(0);
        int currentStreak = 1;

        for (int i = 1; i < signalLog.length(); i++) {
            if (signalLog.charAt(i) == currentChar) {
                currentStreak++;
            } else {
                if (currentStreak > maxStreak) {
                    maxStreak = currentStreak;
                    maxChar = currentChar;
                }
                currentChar = signalLog.charAt(i);
                currentStreak = 1;
            }
        }

        if (currentStreak > maxStreak) {
            maxStreak = currentStreak;
            maxChar = currentChar;
        }

        System.out.println("Longest Streak: '" + maxChar + "' repeated " + maxStreak + " times");
    }

    public static void main(String[] args) {
        checkDuplicateSeats(new int[]{101, 102, 103, 102, 105});
        checkDuplicateSeats(new int[]{101, 102, 103, 104, 105});

        checkTypingAccuracy("hello world", "hello worlt");
        checkTypingAccuracy("coding", "coding");

        findLongestStreak("RRGGGYRR");
        findLongestStreak("RRRRYYGG");
    }
}