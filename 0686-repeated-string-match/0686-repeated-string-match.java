class Solution {
    public int repeatedStringMatch(String a, String b) {
        
        int lena = a.length();
        int lenb = b.length();
        int rep = lenb/lena + (lenb%lena == 0 ? 0 : 1);
        int i = rep;
        String a2 = a;
        while(i-- > 1) a2 += a;
        if(checkIfSubstring(a2, b)) return rep;
        a2+=a;
        rep++;
        if(checkIfSubstring(a2, b)) return rep;
        return -1;
    }

    public boolean checkIfSubstring(String a, String b){
        for(int i=0; i<=a.length()-b.length(); i++){
            if(b.equals(a.substring(i, i+b.length()))) return true;
        }
        return false;
    }
}