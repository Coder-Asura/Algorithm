package com.asura.algorithm;

import java.util.Scanner;

/*
小易准备去魔法王国采购魔法神器,购买魔法神器需要使用魔法币,但是小易现在一枚魔法币都没有,但是小易有两台魔法机器可以通过投入x(x可以为0)个魔法币产生更多的魔法币。
魔法机器1:如果投入x个魔法币,魔法机器会将其变为2x+1个魔法币
魔法机器2:如果投入x个魔法币,魔法机器会将其变为2x+2个魔法币
小易采购魔法神器总共需要n个魔法币,所以小易只能通过两台魔法机器产生恰好n个魔法币,小易需要你帮他设计一个投入方案使他最后恰好拥有n个魔法币。
输入描述:
输入包括一行,包括一个正整数n(1 ≤ n ≤ 10^9),表示小易需要的魔法币数量。


输出描述:
输出一个字符串,每个字符表示该次小易选取投入的魔法机器。其中只包含字符'1'和'2'。

输入例子1:
10

输出例子1:
122

思路：如果n为偶数，则最后一步一定是通过机器2产生;如果n为奇数，则最后一步一定是通过机器1产生。倒着往前推回去就可以了，可以使用递归来实现，不过一定要注意递归的终止条件。
*/
public class MagicCoins {

    public static void main(String[] args) {
        getMagicMachine();
    }

    private static void getMagicMachine() {
        System.out.println("请输入你要获取的魔法币数量n，1 ≤ n ≤ 10^9 ：");
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int count = in.nextInt();
            if (Math.pow(10, 9) >= count && count > 0) {
                StringBuilder sb = new StringBuilder();
                chooseMagic(count, sb);
                int b = Integer.parseInt(sb.reverse().toString());
                System.out.println(b);
            } else {
                System.out.print("输入有误！魔法币数量n，1 ≤ n ≤ 10^9 ！");
            }
        }
    }

    private static void chooseMagic(int n, StringBuilder sb) {
        //递归的终止条件
        if (n == 1) {
            sb.append("1");
            return;
        }
        if (n == 2) {
            sb.append("2");
            return;
        }
        //如果是偶数
        if (n % 2 == 0) {
            sb.append("2");
            //这里可以算出是用几个魔法币得到的
            chooseMagic((n - 2) / 2, sb);
        } else {
            sb.append("1");
            chooseMagic((n - 1) / 2, sb);
        }
    }

}
