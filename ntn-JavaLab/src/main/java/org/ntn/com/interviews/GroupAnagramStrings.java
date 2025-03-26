package org.ntn.com.interviews;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupAnagramStrings {

    public static void main(String[] args) {

        // Arrays.asLists("eat","tea","tan","ate","nat","bat") // java 8
        List<String> lists = List.of("eat","tea","tan","ate","nat","bat"); // Java 17

        groupAnagramStrings(lists);
    }

    private static void groupAnagramStrings(List<String> lists){

        Map<String, List<String>> collect = lists.stream().collect(Collectors.groupingBy((str1) -> {
            char[] chArray = str1.toCharArray();
            Arrays.sort(chArray);
            return new String(chArray);
        }));

        System.out.println(collect);

    }
}
