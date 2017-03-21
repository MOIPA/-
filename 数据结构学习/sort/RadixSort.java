package 排序;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
public class RadixSort {
	public static void main(String[] args) {
		int[] a = { 2,35, 684, 557, 44, 644, 801, 99, 70, 0,54,78,23 };
        RadixSorte sor = null;
        sor.sort(a, 3);
        for (int i = 0; i < a.length; i++){
            System.out.println(a[i]);
        }
	}
	
	}

class RadixSorte
{
    public static void sort(int[] number, int d) //d表示最大的数有多少位
    {
        int k = 0;
        int n = 1;
        int m = 1; //控制键值排序依据在哪一位
        int[][]temp = new int[10][number.length]; //数组的第一维表示可能的余数0-9
        int[]order = new int[10]; //数组orderp[i]用来表示该位是i的数的个数
        while(m <= d)
        {
            for(int i = 0; i < number.length; i++)
            {
                int lsd = ((number[i] / n) % 10);
                temp[lsd][order[lsd]] = number[i];
                order[lsd]++;
            }
            for(int i = 0; i < 10; i++)
            {
                if(order[i] != 0)
                    for(int j = 0; j < order[i]; j++)
                    {
                        number[k] = temp[i][j];
                        k++;
                    }
                order[i] = 0;
            }
            n *= 10;
            k = 0;
            m++;
        }
    }
}
