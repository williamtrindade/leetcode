# 71. Simplify Path

## 📝 Problem Description

You are given an absolute path for a Unix-style file system, which always begins with a slash `/`. Your task is to transform this absolute path into its simplified canonical path.

### 📌 Unix-style File System Rules
* A single period `.` represents the current directory.
* A double period `..` represents the previous/parent directory.
* Multiple consecutive slashes such as `//` and `///` are treated as a single slash `/`.
* Any sequence of periods that does not match the rules above should be treated as a valid directory or file name. For example, `...` and `....` are valid directory or file names.

### 🎯 Canonical Path Rules
The simplified canonical path should follow these strict rules:
* The path **must start** with a single slash `/`.
* Directories within the path **must be separated** by exactly one slash `/`.
* The path **must not end** with a slash `/`, unless it is the root directory.
* The path **must not have** any single or double periods (`.` and `..`) used to denote current or parent directories.

---

## 💡 Examples

| Example | Input | Output | Explanation |
| :--- | :--- | :--- | :--- |
| **1** | `path = "/home/"` | `"/home"` | The trailing slash should be removed. |
| **2** | `path = "/home//foo/"` | `"/home/foo"` | Multiple consecutive slashes are replaced by a single one. |
| **3** | `path = "/home/user/Documents/../Pictures"` | `"/home/user/Pictures"` | A double period `..` refers to the directory up a level (the parent directory). |
| **4** | `path = "/../"` | `"/"` | Going one level up from the root directory is not possible. |
| **5** | `path = "/.../a/../b/c/../d/./"` | `"/.../b/d"` | `...` is a valid name for a directory in this problem. |

---

## ⚠️ Constraints

* `1 <= path.length <= 3000`
* `path` consists of English letters, digits, period `.`, slash `/` or `_`.
* `path` is a valid absolute Unix path.