package ����;

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
    public static void sort(int[] number, int d) //d��ʾ�������ж���λ
    {
        int k = 0;
        int n = 1;
        int m = 1; //���Ƽ�ֵ������������һλ
        int[][]temp = new int[10][number.length]; //����ĵ�һά��ʾ���ܵ�����0-9
        int[]order = new int[10]; //����orderp[i]������ʾ��λ��i�����ĸ���
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
