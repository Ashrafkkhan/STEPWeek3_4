public class RiskThresholdLookup {

    static int linearSearch(int[] arr, int target) {
        int comparisons = 0;

        for (int i = 0; i < arr.length; i++) {
            comparisons++;
            if (arr[i] == target) {
                System.out.println("\nLinear Search:");
                System.out.println("Found at index: " + i);
                System.out.println("Comparisons: " + comparisons);
                return i;
            }
        }

        System.out.println("\nLinear Search:");
        System.out.println("Not found");
        System.out.println("Comparisons: " + comparisons);
        return -1;
    }

    static void binaryFloorCeil(int[] arr, int target) {

        int low = 0, high = arr.length - 1;
        int comparisons = 0;

        int floor = -1;
        int ceil = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            comparisons++;

            if (arr[mid] == target) {
                floor = arr[mid];
                ceil = arr[mid];
                break;
            }

            if (arr[mid] < target) {
                floor = arr[mid];
                low = mid + 1;
            } else {
                ceil = arr[mid];
                high = mid - 1;
            }
        }

        System.out.println("\nBinary Search:");
        System.out.println("Floor (<= target): " + floor);
        System.out.println("Ceiling (>= target): " + ceil);
        System.out.println("Comparisons: " + comparisons);
    }

    public static void main(String[] args) {

        int[] riskBands = {10, 25, 50, 100};

        int target = 30;

        linearSearch(riskBands, target);

        binaryFloorCeil(riskBands, target);
    }
}