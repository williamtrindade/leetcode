package com.williamtrindade.LC0071SimplifyPath;

import java.util.Stack;

class Solution {
    public String simplifyPath(String path) {
        // being with /
        // . is a the curr dir
        // .. is the prev dir
        // sequenced // or /// is a single / - ok by split
        // ... or more are treated as a valid dirr or file name

        // start with /
        // separate dirs with /
        // must not end with a /
        // cant have . or ..

        String[] splitted = path.split("/");

        Stack<String> stackControl = new Stack<>();


        for (String part : splitted) {
            if (part.equals(".") ) {
                continue;
            }
            if (!stackControl.isEmpty()) {
                if (part.equals("..")) {
                    stackControl.pop();
                    continue;
                }
            }

            if (!part.isEmpty() && !part.equals("..")) {
                stackControl.push(part);
            }

        }

        if (stackControl.isEmpty()) {
            return "/";
        }

        return "/" + String.join("/", stackControl);
    }
}