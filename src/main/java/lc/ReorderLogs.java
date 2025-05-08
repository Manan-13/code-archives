package lc;

import java.util.ArrayList;
import java.util.List;

public class ReorderLogs {
    public String[] reorderLogFiles(String[] logs) {

        List<String[]> identifierLogs = new ArrayList<>();
        for(String s: logs ){
            identifierLogs.add(s.split(" ", 2));
        }
        List<String[]> letterlogs = new ArrayList<>();
        List<String[]> digitlogs = new ArrayList<>();
        for(int i =0; i< identifierLogs.size(); i++){
            String[] s = identifierLogs.get(i);
            int firstletterascii = s[1].charAt(0) - 'a';
            if(firstletterascii >=0 && firstletterascii < 26){
                letterlogs.add(s);
            }else digitlogs.add(s);
        }
        letterlogs.sort((s1, s2) -> {
            if(s1[1].compareTo(s2[1]) == 0){
                return s1[0].compareTo(s2[0]);
            }else return s1[1].compareTo(s2[1]);
        });
        int i;
        for(i =0; i< letterlogs.size(); i++){
            String[] seperatedLetterLog = letterlogs.get(i);
            logs[i] = seperatedLetterLog[0].concat(" ").concat(seperatedLetterLog[1]);
        }
        for(int j = 0; j < digitlogs.size(); j++){
            String[] seperatedDigitLog = digitlogs.get(j);
            logs[i] = seperatedDigitLog[0].concat(" ").concat(seperatedDigitLog[1]);
        }
        return logs;
    }
}

//You are given an array of logs. Each log is a space-delimited string of words, where the first word is the identifier.
//
//There are two types of logs:
//1. Letter-logs: All words (except the identifier) consist of lowercase English letters.
//2. Digit-logs: All words (except the identifier) consist of digits.
//Reorder these logs so that:
//1. The letter-logs come before all digit-logs.
//2. The letter-logs are sorted lexicographically by their contents. If their contents are the same, then sort them lexicographically by their identifiers.
//3. The digit-logs maintain their relative ordering.
//Return the final order of the logs.
//Example 1:
//Input: logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
//Output: ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]
//Explanation:
//The letter-log contents are all different, so their ordering is "art can", "art zero", "own kit dig".
//The digit-logs have a relative order of "dig1 8 1 5 1", "dig2 3 6".
//Example 2:
//Input: logs = ["a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"]
//Output: ["g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"]
//class Solution {
//    public String[] reorderLogFiles(String[] logs) {
//        // seperate identifier and logs as an list/array of 2 items. (seperate loop) -> remove letter logs so digit logs are left in place.
//        // iterate thourgh the list. check if letter log. add in letter-log-list.
//        // sort the list based on custom comparator to compare teh strings.
//        // sorted list then append digitlogs
//    }
//
//    T - li*n + n + nlogn*l + n
//    S - 3*n
//
//    li -> length of identifer
//    n -> logs
//    l -> length of longest string/log.
//}