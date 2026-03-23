class Client {
    String name;
    int riskScore;
    double accountBalance;

    Client(String name, int riskScore, double accountBalance) {
        this.name = name;
        this.riskScore = riskScore;
        this.accountBalance = accountBalance;
    }

    public String toString() {
        return name + ":" + riskScore;
    }
}

public class ClientRiskRanking {

    static void bubbleSort(Client[] arr) {
        int n = arr.length;
        int swaps = 0;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j].riskScore > arr[j + 1].riskScore) {

                    Client temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    swapped = true;
                    swaps++;
                }
            }

            if (!swapped) break;
        }

        System.out.println("\nBubble Sort (Ascending) completed");
        System.out.println("Swaps: " + swaps);
    }

    static void insertionSort(Client[] arr) {

        for (int i = 1; i < arr.length; i++) {
            Client key = arr[i];
            int j = i - 1;

            while (j >= 0 &&
                    (arr[j].riskScore < key.riskScore ||
                            (arr[j].riskScore == key.riskScore &&
                                    arr[j].accountBalance < key.accountBalance))) {

                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }

        System.out.println("\nInsertion Sort (Descending) completed");
    }

    static void printArray(String msg, Client[] arr) {
        System.out.println("\n" + msg);
        for (Client c : arr) {
            System.out.println(c);
        }
    }

    static void topRiskClients(Client[] arr, int topN) {
        System.out.println("\nTop " + topN + " Risk Clients:");

        for (int i = 0; i < Math.min(topN, arr.length); i++) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {

        Client[] clients = {
                new Client("ClientC", 80, 5000),
                new Client("ClientA", 20, 2000),
                new Client("ClientB", 50, 3000)
        };

        printArray("Input Clients:", clients);

        Client[] bubbleArr = clients.clone();
        bubbleSort(bubbleArr);
        printArray("Bubble Sorted (Ascending risk):", bubbleArr);

        Client[] insertionArr = clients.clone();
        insertionSort(insertionArr);
        printArray("Insertion Sorted (Descending risk):", insertionArr);

        topRiskClients(insertionArr, 3);
    }
}