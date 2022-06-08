package Tink;

import java.util.Scanner;

public class a {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfDenominations;
        int[] denominationsOfBanknotes;
        int amountRequired;
        int begin = 0;
        int end;
        // кодировка 1251 :)
        System.out.println("Ââåäèòå êîëè÷åñòâî íîìèíàëîâ: ");
        numberOfDenominations = scanner.nextInt();
        denominationsOfBanknotes = new int[numberOfDenominations];
        for (int i = 0; i < numberOfDenominations; i++) {
            System.out.print((i+1) + " íîìèíàë = ");
            denominationsOfBanknotes[i] = scanner.nextInt();
        }
        System.out.println("Ââåäèòå òðåáóåìóþ ñóììó: ");
        amountRequired = scanner.nextInt();

        end = numberOfDenominations - 1;
        quickSort(denominationsOfBanknotes, begin, end);

        StringBuilder result = new StringBuilder();
        for (int i = numberOfDenominations - 1; i >= 0; i--) {
            int k = amountRequired / denominationsOfBanknotes[i];
            for (int j = 0; j < k; j++) {
                result.insert(0, " ").insert(0, denominationsOfBanknotes[i]);
            }
            amountRequired = amountRequired - (denominationsOfBanknotes[i] * k);
        }

        if (amountRequired != 0) {
            System.out.println("Íåëüçÿ íàáðàòü êóïþð íà ýòó ñóììó");
        } else {
            System.out.println("Ðåçóëüòàò\n" + result);
        }
    }

    static int partition(int[] array, int begin, int end) {
        int pivot = end;

        int counter = begin;
        for (int i = begin; i < end; i++) {
            if (array[i] < array[pivot]) {
                int temp = array[counter];
                array[counter] = array[i];
                array[i] = temp;
                counter++;
            }
        }
        int temp = array[pivot];
        array[pivot] = array[counter];
        array[counter] = temp;

        return counter;
    }

    public static void quickSort(int[] array, int begin, int end) {
        if (end <= begin) return;
        int pivot = partition(array, begin, end);
        quickSort(array, begin, pivot-1);
        quickSort(array, pivot+1, end);
    }
}
