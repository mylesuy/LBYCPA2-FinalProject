import javafx.scene.control.Button;

public class InsertionSort {

    void sort(int arr[], int arr2[])
    {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int key2 = arr2[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
               // System.out.println(j);
                arr[j + 1] = arr[j];
               // System.out.println(j);
                arr2[j + 1] = arr2[j];
                j = j - 1;
            }

            arr[j + 1] = key;
            arr2[j + 1] = key2;
        }
    }


    void sortPrice(int arr[], Button arrayOfButtons[])
    {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            Button key2 = arrayOfButtons[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                // System.out.println(j);
                arr[j + 1] = arr[j];
                // System.out.println(j);
                arrayOfButtons[j + 1] = arrayOfButtons[j];
                j = j - 1;
            }

            arr[j + 1] = key;
            arrayOfButtons[j + 1] = key2;
        }
    }

    void sort(String arr3[], int arr[])
    //void sortName(String arr[])
    {
        int n = arr3.length;
        for (int i = 1; i < n; ++i) {
            String key = arr3[i];
            int key2 = arr[i];
            int j = i - 1;
            while (j >= 0 && arr3[j].toLowerCase().compareTo(key)>0) {
                // System.out.println(j);
                arr3[j + 1] = arr3[j];
                // System.out.println(j);
                arr[j + 1] = arr[j];
                j = j - 1;
            }

            arr3[j + 1] = key;
            arr[j + 1] = key2;
        }
    }
    void sortName(String arr[], Button arrayOfButtons[])
    //void sortName(String arr[])
    {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            String key = arr[i];
            Button key2 = arrayOfButtons[i];
            int j = i - 1;
            while (j >= 0 && arr[j].toLowerCase().compareTo(key)>0) {
                // System.out.println(j);
                arr[j + 1] = arr[j];
                // System.out.println(j);
                arrayOfButtons[j + 1] = arrayOfButtons[j];
                j = j - 1;
            }

            arr[j + 1] = key;
            arrayOfButtons[j + 1] = key2;
        }
    }

    public static void main(String[] args){
        InsertionSort insertionSort = new InsertionSort();
        //test
        //int[] arr =  {1,3,5,4,2,6,7,8};
        int[] arr =  {1,3,5,4,2};
        int[] arr2 = {5,3,2,1,4,6,7,8};
        /*
        insertionSort.sort(arr,arr2);
        for(int i =0;i<arr.length;i++){
            System.out.print(arr[i]+"\t");
        }
        System.out.println();
        for(int i =0;i<arr2.length;i++){
           System.out.print(arr2[i]+"\t");
        }
        */
        String[] arr3 = {"lmnop","abc ef","aef ag","cdef","bef"};
        //String[] arr4 = {"Beef","Chicken","Veggie","Coke","Cheese","Super","Fries","Coke zero","Sprite"};
        String[] arr4 = {"beef","chicken","veggie","coke","cheese","super","fries","coke zero","sprite"};

        System.out.println();
        Button[] butts = new Button[10];
        insertionSort.sortName(arr4,butts);
        for(int i =0;i<arr4.length;i++){
            System.out.print(arr4[i]+"\t");
        }

    }
}
