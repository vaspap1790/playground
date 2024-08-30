package org.example;

/**
    Only under constraint: Nums of the array can take values 1 to n, n+1 being the size of the array
 */
public class NegativeMarking {

    public static int findDuplicateConstantSpace(int[] arr) {
        int duplicate = -1;

        for (int i = 0; i < arr.length; i++) {
            int current = Math.abs(arr[i]);
            if (arr[current] < 0) {
                duplicate = current;
                break;
            }
            arr[current] *= -1;
        }

        return duplicate;
    }

    public static int findDuplicateConstantSpaceNoModification(int[] arr) {
        int slow = arr[0];
        int fast = arr[0];

        do {
            slow = arr[slow];
            fast = arr[arr[fast]];
        } while(slow != fast);

        slow = arr[0];

        while(slow != fast){
            slow = arr[slow];
            fast = arr[fast];
        }

        return slow;
    }
}
