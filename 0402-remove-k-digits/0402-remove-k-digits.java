class Solution {
    public String removeKdigits(String num, int k) {
        
        Stack<Integer> st = new Stack<>();
        if(num.length() <= k) return "0";

        for(int i=0; i<num.length(); i++){

            while(!st.isEmpty() && st.peek() > num.charAt(i)-'0' && k > 0){
                k--;
                st.pop();
            }

            st.push(num.charAt(i)-'0');
        }

        while(k-- > 0) st.pop();

        StringBuilder str = new StringBuilder();
        while(!st.isEmpty()){
            str.append(st.pop());
        }
        str.reverse();
        while(str.charAt(0) == '0' && str.length() > 1) str.deleteCharAt(0);
        return str.toString();

    }
}