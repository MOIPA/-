package ����;

import java.util.ArrayList;
import java.util.List;

public class RadixSortExample {

    public void radix(int[] array) {
        int max = array[0];
        for (int i = 0; i < array.length; i++) { // �õ���������ֵ
            if (max < array[i]) {
                max = array[i];
            }
        }

        int time = 0;
        while (max > 0) { // �ж�λ��
            max /= 10;
            time++;
        }

        // ����10������
        List<ArrayList> queue = new ArrayList<ArrayList>();
        for (int i = 0; i < 10; i++) {
            ArrayList<Integer> queue1 = new ArrayList<Integer>();
            queue.add(queue1);
        }

        // ����time�η�����ռ�
        for (int i = 0; i < time; i++) {
            // ��������Ԫ��
            for (int j = 0; j < array.length; j++) {
                // �õ����ֵĵ�time+1λ��
                // Math.pow(double a,double b)Ϊa��b�η�
                int x = array[j] % (int) Math.pow(10, i + 1) / (int) Math.pow(10, i);
                ArrayList<Integer> queue2 = queue.get(x);
                queue2.add(array[j]);
                queue.set(x, queue2);

            }

            int count = 0;// Ԫ�ؼ�����;
            // �ռ�����Ԫ��;
            for (int k = 0; k < 10; k++) {
                while (queue.get(k).size() > 0) {//��k�����еĳ���
                    ArrayList<Integer> queue3 = queue.get(k);//�ѵ�k�����и�queue3
                    array[count] = queue3.get(0);//��queue3�ĵ�һ��ֵֵ��array
                    queue3.remove(0);//��һ�Σ���ɾ��һ�ε�һ��Ԫ��
                    count++;
                }
            }

        }

    }

    public void radixSort() {
        int[] a = { 2,35, 684, 557, 44, 644, 801, 99, 70, 0,54,78,23 };
        radix(a);
        for (int i = 0; i < a.length; i++){
            System.out.println(a[i]);
        }
    }  
}