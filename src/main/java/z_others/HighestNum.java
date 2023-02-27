package z_others;

import java.util.ArrayList;

public class HighestNum {
    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();

        ArrayList<Integer> arrayListOne = new ArrayList<>();
        ArrayList<Integer> arrayListTwo = new ArrayList<>();
        ArrayList<Integer> arrayListThree = new ArrayList<>();


        arrayListOne.add(66);
        arrayListOne.add(3);
        arrayListOne.add(9);

        arrayListTwo.add(1);
        arrayListTwo.add(8);
        arrayListTwo.add(98);

        arrayListThree.add(7);
        arrayListThree.add(9);
        arrayListThree.add(7);

        arrayLists.add(arrayListOne);
        arrayLists.add(arrayListTwo);
        arrayLists.add(arrayListThree);

        highestNumber(arrayLists);
    }

    private static void highestNumber(ArrayList<ArrayList<Integer>> arrayLists) {
        int m = arrayLists.get(0).size(); //row
        int n = arrayLists.size(); //column

        ArrayList<Integer> mArr = new ArrayList<>();
        ArrayList<Integer> nArr = new ArrayList<>();

        int mCount = 0;
        int nCount = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < arrayLists.get(i).size(); j++) {

                mCount += arrayLists.get(i).get(j);
                nCount += arrayLists.get(1).get(0);

                if (j == arrayLists.get(i).size() - 1) {
                    mArr.add(mCount);
                    mCount = 0;
                }
            }
        }

        System.out.println(mArr);
        System.out.println(nCount);

    }

}
