class Trade {
    String id;
    int volume;

    Trade(String id, int volume) {
        this.id = id;
        this.volume = volume;
    }

    public String toString() {
        return id + ":" + volume;
    }
}

public class TradeVolumeAnalysis {

    static void mergeSort(Trade[] arr, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;

            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);

            merge(arr, l, m, r);
        }
    }

    static void merge(Trade[] arr, int l, int m, int r) {

        int n1 = m - l + 1;
        int n2 = r - m;

        Trade[] L = new Trade[n1];
        Trade[] R = new Trade[n2];

        for (int i = 0; i < n1; i++) L[i] = arr[l + i];
        for (int j = 0; j < n2; j++) R[j] = arr[m + 1 + j];

        int i = 0, j = 0, k = l;

        while (i < n1 && j < n2) {
            if (L[i].volume <= R[j].volume) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }

        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }

    static void quickSortDesc(Trade[] arr, int low, int high) {
        if (low < high) {

            int pi = partition(arr, low, high);

            quickSortDesc(arr, low, pi - 1);
            quickSortDesc(arr, pi + 1, high);
        }
    }

    static int partition(Trade[] arr, int low, int high) {

        Trade pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {

            if (arr[j].volume > pivot.volume) {

                i++;
                Trade temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        Trade temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    static Trade[] mergeTwoSorted(Trade[] a, Trade[] b) {

        Trade[] result = new Trade[a.length + b.length];

        int i = 0, j = 0, k = 0;

        while (i < a.length && j < b.length) {
            if (a[i].volume <= b[j].volume) {
                result[k++] = a[i++];
            } else {
                result[k++] = b[j++];
            }
        }

        while (i < a.length) result[k++] = a[i++];
        while (j < b.length) result[k++] = b[j++];

        return result;
    }

    static int totalVolume(Trade[] arr) {
        int sum = 0;
        for (Trade t : arr) {
            sum += t.volume;
        }
        return sum;
    }

    static void print(String msg, Trade[] arr) {
        System.out.println("\n" + msg);
        for (Trade t : arr) {
            System.out.println(t);
        }
    }

    public static void main(String[] args) {

        Trade[] trades = {
                new Trade("trade3", 500),
                new Trade("trade1", 100),
                new Trade("trade2", 300)
        };

        Trade[] mergeArr = trades.clone();
        mergeSort(mergeArr, 0, mergeArr.length - 1);
        print("Merge Sort (Ascending Volume):", mergeArr);

        Trade[] quickArr = trades.clone();
        quickSortDesc(quickArr, 0, quickArr.length - 1);
        print("Quick Sort (Descending Volume):", quickArr);

        Trade[] morning = {
                new Trade("m1", 200),
                new Trade("m2", 300)
        };

        Trade[] afternoon = {
                new Trade("a1", 100),
                new Trade("a2", 400)
        };

        Trade[] merged = mergeTwoSorted(morning, afternoon);
        print("Merged Morning + Afternoon Trades:", merged);

        System.out.println("\nTotal Volume: " + totalVolume(merged));
    }
}