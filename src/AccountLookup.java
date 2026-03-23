import java.util.Arrays;

public class AccountLookup {

    static int linearSearchFirst(String[] arr, String target) {
        int comparisons = 0;

        for (int i = 0; i < arr.length; i++) {
            comparisons++;
            if (arr[i].equals(target)) {
                System.out.println("\nLinear Search:");
                System.out.println("First occurrence index: " + i);
                System.out.println("Comparisons: " + comparisons);
                return i;
            }
        }

        System.out.println("\nLinear Search:");
        System.out.println("Not found");
        System.out.println("Comparisons: " + comparisons);
        return -1;
    }

    static int binarySearch(String[] arr, String target) {
        int low = 0, high = arr.length - 1;
        int comparisons = 0;
        int foundIndex = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            comparisons++;

            if (arr[mid].equals(target)) {
                foundIndex = mid;
                break;
            } else if (arr[mid].compareTo(target) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        if (foundIndex == -1) {
            System.out.println("\nBinary Search:");
            System.out.println("Not found");
            System.out.println("Comparisons: " + comparisons);
            return -1;
        }

        int count = 1;
        int i = foundIndex - 1;
        while (i >= 0 && arr[i].equals(target)) {
            count++;
            i--;
        }

        i = foundIndex + 1;
        while (i < arr.length && arr[i].equals(target)) {
            count++;
            i++;
        }

        System.out.println("\nBinary Search:");
        System.out.println("Index found: " + foundIndex);
        System.out.println("Occurrences: " + count);
        System.out.println("Comparisons: " + comparisons);

        return foundIndex;
    }

    public static void main(String[] args) {

        String[] logs = {"accB", "accA", "accB", "accC"};

        linearSearchFirst(logs, "accB");

        Arrays.sort(logs);

        System.out.println("\nSorted Logs: " + Arrays.toString(logs));

        binarySearch(logs, "accB");
    }
}