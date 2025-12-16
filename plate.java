import java.util.Scanner;

public class PlateCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Standard barbell weight
        final int BAR_WEIGHT = 45;

        System.out.print("Enter total weight (including the bar): ");
        int totalWeight = scanner.nextInt();

        if (totalWeight < BAR_WEIGHT) {
            System.out.println("Weight must be at least 45 lbs (the bar).");
            return;
        }

        int plateWeight = totalWeight - BAR_WEIGHT; // remove bar weight
        int perSide = plateWeight / 2; // weight per side

        System.out.println("Plates needed per side for " + totalWeight + " lbs:");

        int[] plates = {45, 25, 10, 5};
        int[] counts = new int[plates.length];

        for (int i = 0; i < plates.length; i++) {
            counts[i] = perSide / plates[i];
            perSide %= plates[i];
        }

        System.out.println("45 lbs: " + counts[0]);
        System.out.println("25 lbs: " + counts[1]);
        System.out.println("10 lbs: " + counts[2]);
        System.out.println("5 lbs: " + counts[3]);

        if (perSide > 0) {
            System.out.println("Remaining weight not matched by available plates: " + perSide + " lbs");
        }
    }
}
