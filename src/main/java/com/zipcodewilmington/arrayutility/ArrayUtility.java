package com.zipcodewilmington.arrayutility;

import java.util.*;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility <T>{

   private T[] inputArray;

    public ArrayUtility(T[] inputArray){
        this.inputArray = inputArray;
    }

    public Integer countDuplicatesInMerge(T[] arrayToMerge,T valueToEvaluate){
        Integer count =0;
        List<T> arrayList = new ArrayList<>();
        arrayList.addAll(Arrays.asList(arrayToMerge));
        arrayList.addAll(Arrays.asList(inputArray));
        return Collections.frequency(arrayList, valueToEvaluate);
    }


    public T getMostCommonFromMerge(T[] arrayToMerge){
        Integer mostCommon = Integer.MIN_VALUE;
        List<T> arrayList = new ArrayList<>();
        T mostCommonValue = null;
        arrayList.addAll(Arrays.asList(arrayToMerge));
        arrayList.addAll(Arrays.asList(inputArray));
        for(T t: arrayList){
          Integer currentValue =  Collections.frequency(arrayList, t);
          if(currentValue>mostCommon){
              mostCommon = currentValue;
              mostCommonValue = t;
          }
        } return mostCommonValue;
    }

   public Integer getNumberOfOccurrences(T valueToEvaluate){
        List<T> arrayList = new ArrayList<>();
        arrayList.addAll(Arrays.asList(inputArray));
        return Collections.frequency(arrayList, valueToEvaluate);

   }

   public T[] removeValue(T valueToRemove){
       int numberOfOccurrences = getNumberOfOccurrences(valueToRemove);
       T[] result = Arrays.copyOf(inputArray, inputArray.length - numberOfOccurrences);
       int j =0;
       for (int i = 0; i < inputArray.length; i++) {
           if (inputArray[i] != valueToRemove) {
               result[j] = inputArray[i];
               j++;
           }
       }
       return result;
   }

}
