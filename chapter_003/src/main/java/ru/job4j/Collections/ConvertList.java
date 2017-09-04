package ru.job4j.Collections;
import java.util.*;

public class ConvertList {

    public List<Integer> toList (int[][] array) {
        List<Integer> newList = new ArrayList<>();
        for(int[] arr : array)
        {
            for(int val : arr){
            newList.add(val);
            }
        }
        System.out.println(newList);
        return newList;
    }

    public int[][] toArray (List<Integer> list, int rows) {
        int elements = list.size() % rows ;
        while (elements != rows){
            list.add(0);
            elements++;
        }
        int[][] rowArray = new int[rows][elements];
        int row = 0;
        int elementInRow=0;
        for (Integer i : list) {
            if (i == null) {
                rowArray[row][elementInRow] = 0;
                elementInRow++;
            } else {
                    rowArray[row][elementInRow] = i;
                    elementInRow++;
                }
            if (elementInRow == elements){
                row++;
                elementInRow=0;
            }
        }
        return rowArray;
    }

    public static void main(String[] args){
        ConvertList convert = new ConvertList();
        int[][] array = {{1,2,3,4},{5,6,7}};
        List<Integer> rowList = convert.toList(array);
        int[][] toArray = convert.toArray(rowList, 3);
        System.out.println(Arrays.deepToString(toArray));
    }
}
