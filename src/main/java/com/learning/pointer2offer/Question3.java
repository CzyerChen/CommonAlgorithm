package com.learning.pointer2offer;

import java.util.*;

/**
 * Desciption  回溯法:输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 *
 * @author Claire.Chen
 * @create_time 2019 -03 - 06 15:18
 */
public class Question3 {

    public static void main(String[] args) {
        String str = "abc";
        //Permutation3(str);
      /*  char []ss={'a','a'};
        permutation(ss,0);*/
    }

    public static ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<String>();
        permutation1(str.toCharArray(), 0, res);
        return res;
    }

    public static void permutation1(char[] ss, int i, ArrayList<String> res) {
        if (ss == null || i < 0 || i > ss.length) {
            return;
        }
        if (i == ss.length) {
            if (i == 0) {
                return;
            } else {
                res.add(new String(ss));
                System.out.println(new String(ss));
            }
        } else {
            for (int j = i; j < ss.length; j++) {
                char temp = ss[j];//交换前缀,使之产生下一个前缀
                ss[j] = ss[i];
                ss[i] = temp;
                int index = i + 1;
                for (int k = i + 1; k < ss.length; k++) {
                    if (ss[index] == ss[k]) {
                        index++;
                    }
                }
                if (index < ss.length) {
                    permutation1(ss, index, res);
                    temp = ss[j]; //将前缀换回来,继续做上一个的前缀排列.
                    ss[j] = ss[i];
                    ss[i] = temp;
                }

            }
        }
    }


    public ArrayList<String> Permutation2(String str) {
        List<String> list = new ArrayList<String>();
        for (int i = str.length() - 2; i > 0; i--) {
            List<Character> a = new ArrayList<Character>();
            a.add(str.charAt(str.length() - 1));
            a.add(str.charAt(str.length()));
            if (list != null && list.size() != 0) {

            } else {

            }
        }
        return null;
    }

    public String subTest(String str) {
        if (str.length() <= 2) {

        }
        for (int i = 0; i < str.length(); i++) {
            String subStr1 = "";
            String subStr2 = "";
            if (i == 0) {
                subStr2 = str.substring(i + 1, str.length());
            } else if (i == str.length() - 1) {
                subStr1 = str.substring(0, str.length() - 1);
            } else {
                subStr1 = str.substring(0, i);
                subStr2 = str.substring(i + 1, str.length());
            }
            String sub = subStr1 + subStr2;
            if (sub.length() > 2) {
                String insideSub = subTest(sub);
            }
        }
        return null;
    }

    public static void permutation(char[] ss, int i) {
        if (ss == null || i < 0 || i > ss.length) {
            return;
        }
        if (i == ss.length) {
            System.out.println(new String(ss));
        } else {
            for (int j = i; j < ss.length; j++) {
                char temp = ss[j];//交换前缀,使之产生下一个前缀
                ss[j] = ss[i];
                ss[i] = temp;
                permutation(ss, i + 1);
                temp = ss[j]; //将前缀换回来,继续做上一个的前缀排列.
                ss[j] = ss[i];
                ss[i] = temp;
            }
        }
    }


    public ArrayList<String> Permutation3(String str) {
        List<String> res = new ArrayList<String>();
        if (str != null && str.length() > 0) {
            PermutationHelper(str.toCharArray(), 0, res);
            Collections.sort(res);
        }
        return (ArrayList) res;
    }

    public void PermutationHelper(char[] cs, int i, List<String> list) {
        if (i == cs.length - 1) {
            String val = String.valueOf(cs);
            if (!list.contains(val))
                list.add(val);
        } else {
            for (int j = i; j < cs.length; j++) {
                swap(cs, i, j);
                PermutationHelper(cs, i + 1, list);
                swap(cs, i, j);
            }
        }
    }

    public void swap(char[] cs, int i, int j) {
        char temp = cs[i];
        cs[i] = cs[j];
        cs[j] = temp;
    }

}
