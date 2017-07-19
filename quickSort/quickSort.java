package quickSort;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
/**
 * Created by CalvinNguyen on 7/18/17.
 */
public class quickSort {

    int[] numbers;
    long totalComparision;

    quickSort(int input) {
        numbers = new int[input];
    }

    public int[] getNumbers() {
        return numbers;
    }

    public void setNumbers(int[] input) {
        numbers = input;
    }
    public long getTotalComparision() {
        return totalComparision;
    }
    public void addTotalComparision(long input) {
        totalComparision += input;
    }

    int chooseFirstElement(int[] input) {
        return input[0];
    }
    int chooseLastElement(int[] input) {
        return input[input.length - 1];
    }
    int chooseMidPivot(int[] input) {
        return 0;
    }

    void quickSort(int[] input, int length) {
        if (length == 1) return;
        int p = chooseFirstElement(input);
        partition(input, p);


    }
    void partition(int[] input, int pivot) {

    }

    public static void main(String[] args) {
        quickSort a = new quickSort(10000);

        try(BufferedReader br = new BufferedReader(new FileReader("assignment3.txt"))) {
            String line;
            int count = 0;

            while ((line = br.readLine()) != null && count < 10000) {
                a.numbers[count] = Integer.parseInt(line);
                count++;
            }
            a.quickSort(a.numbers, a.numbers.length);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
