package Leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public boolean isValid(String s) {
        // {"[""]"
        Deque<Character> st = new ArrayDeque<>();
        Character openBracket;
        for (char c : s.toCharArray()) {
            switch (c) {
                case '{':
                case '[':
                case '(':
                    st.push(c);
                    break;
                case '}':
                    if (st.isEmpty())
                        return false;
                    openBracket = st.pop();
                    if (openBracket != '{')
                        return false;
                    break;
                case ']':
                    if (st.isEmpty())
                        return false;
                    openBracket = st.pop();
                    if (openBracket != '[')
                        return false;
                    break;
                case ')':
                    if (st.isEmpty())
                        return false;
                    openBracket = st.pop();
                    if (openBracket != '(')
                        return false;
                    break;
            }
        }
        if (!st.isEmpty())
            return false;

        return true;
    }
}