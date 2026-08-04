package com.williamtrindade.LC0345;

import java.util.Stack;

class SolutionA {
    public String reverseVowels(String s) {
        Stack<Character> stack = new Stack<>();


        for (int i =0; i < s.length(); i++) {
            if (isVowel(s.charAt(i))) {
                stack.push(s.charAt(i));
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            Character ch;
            if (isVowel(s.charAt(i))) {
                ch = stack.pop();
            } else {
                ch = s.charAt(i);
            }
            sb.append(String.valueOf(ch));
        }

        return sb.toString();
    }

    public boolean isVowel(Character ch) {
        return  (
                ch == 'a' ||
                        ch == 'e' ||
                        ch == 'i' ||
                        ch == 'o' ||
                        ch == 'u' ||
                        ch == 'A' ||
                        ch == 'E' ||
                        ch == 'I' ||
                        ch == 'O' ||
                        ch == 'U'
        );
    }
}