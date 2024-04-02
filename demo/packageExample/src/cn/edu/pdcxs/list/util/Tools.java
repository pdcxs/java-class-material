package cn.edu.pdcxs.list.util;

import cn.edu.pdcxs.list.List;

public class Tools {
    public static List toList(double[] arr) {
        int[] a = new int[arr.length];
        for (int i = 0; i < a.length; i++) {
            a[i] = (int)arr[i];
        }
        return new List(a);
    }
}
