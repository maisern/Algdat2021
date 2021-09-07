package Forelesninger_uke_36;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] values = {5, 6, 18, 9, 2, 8, 32, 3, 1, 10, 4, 7, 14, 17};
        BubbleSort(values);
        int index1 = binarySearch(values, 9);
        System.out.println("tallet er på plass: " + index1);

        int index2 = binarySearchRecursive(values, 9, 0, values.length-1);
        System.out.println("fant tallet");
    }

    public static void BubbleSort(int[] values) {
        System.out.println(Arrays.toString(values));
        //to løkker
        //ytre: sorterer ett tall hver gjennomgang
        for (int i = 0; i < values.length - 1; i++) {

            //indre: sjekk om to og to tall er sortert riktig
            for (int j = values.length - 1; j > i; j--) {

                // sjekk om tall og posisjon j og (j-1) er sortert riktig
                if (values[j] < values[j - 1]) {
                    int temp = values[j];
                    values[j] = values[j - 1];
                    values[j - 1] = temp;
                }
            }
            System.out.println(Arrays.toString(values));
        }
        System.out.println(Arrays.toString(values));
    }

    public static int binarySearch(int[] values, int search_value){
        //søk etter tall
        //halvåpent intervall: [8,10) => 8 9
        //lukket intervall: [8, 10] => 8 9 10
        //runder ned ved heltallsdivisjon, opp ved doubbles

        //søk i intervaller l,r

        int l=0;
        int r=values.length-1;
        int m= (l+r)/2;

        while (l <= m) {
            //hvis midt-verdien er større
            //gå til venstre
            if (values[m] > search_value) {
                r = m - 1;
                m= (l+r)/2;

            } else if (values[m] < search_value) {
                l = m + 1;
                m= (l+r)/2;
            } else if (values[m]==search_value){
                break;
        }

        }
        return m;

    }

    public static int binarySearchRecursive(int[]values, int search_value, int l, int r){

        int m=(l+r)/2;

        if(values[m]>search_value){
            r=m-1;
            m = (r+l)/2;
            binarySearchRecursive(values, search_value,1,r);
        }else if (values[m]<search_value){
            l=m+1;
            m=(l+r)/2;
            binarySearchRecursive(values,search_value,1,r);
        }else if(values[m]==search_value){
            return m;
        }
        return m;
    }

}

