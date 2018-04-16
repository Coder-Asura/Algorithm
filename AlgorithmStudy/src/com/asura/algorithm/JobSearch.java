package com.asura.algorithm;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

/**
 * 牛牛找工作
 * <p>
 * 时间限制：2秒
 * 空间限制：65536K
 * <p>
 * 为了找到自己满意的工作，牛牛收集了每种工作的难度和报酬。牛牛选工作的标准是在难度不超过自身能力值的情况下，牛牛选择报酬最高的工作。在牛牛选定了自己的工作后，牛牛的小伙伴们来找牛牛帮忙选工作，牛牛依然使用自己的标准来帮助小伙伴们。牛牛的小伙伴太多了，于是他只好把这个任务交给了你。
 * 输入描述:
 * 每个输入包含一个测试用例。
 * 每个测试用例的第一行包含两个正整数，分别表示工作的数量N(N<=100000)和小伙伴的数量M(M<=100000)。
 * 接下来的N行每行包含两个正整数，分别表示该项工作的难度Di(Di<=1000000000)和报酬Pi(Pi<=1000000000)。
 * 接下来的一行包含M个正整数，分别表示M个小伙伴的能力值Ai(Ai<=1000000000)。
 * 保证不存在两项工作的报酬相同。
 * <p>
 * <p>
 * 输出描述:
 * 对于每个小伙伴，在单独的一行输出一个正整数表示他能得到的最高报酬。一个工作可以被多个人选择。
 * <p>
 * 输入例子1:
 * 3 3
 * 1 100
 * 10 1000
 * 1000000000 1001
 * 9 10 1000000000
 * <p>
 * 输出例子1:
 * 100
 * 1000
 * 1001
 */
public class JobSearch {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        //工作的数量
        int N = sc.nextInt();
        //小伙伴数量
        int M = sc.nextInt();

        //难度 - 报酬
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int di = sc.nextInt();
            int pi = sc.nextInt();
            hashMap.put(di, pi);
        }

        //能力值
        int[] Ai = new int[M];
        for (int i = 0; i < M; i++) {
            int ai = sc.nextInt();
            Ai[i] = ai;
        }

        //结果
        int[] result = new int[M];
        for (int i = 0; i < M; i++) {
            Iterator<Integer> iterator = hashMap.keySet().iterator();
            int max = 0;
            while (iterator.hasNext()) {
                int di = iterator.next();
                //防止 hashMap 的可以没有排序
                if (Ai[i] >= di && max < di) {
                    max = di;
                }
            }
            result[i] = max;
        }

        for (int i = 0; i < M; i++) {
            System.out.println(hashMap.get(result[i]));
        }
    }
}
