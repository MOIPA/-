package 排序;

import java.util.ArrayList;
import java.util.List;

public class RadixSortExample {

    public void radix(int[] array) {
        int max = array[0];
        for (int i = 0; i < array.length; i++) { // 得到数组的最大值
            if (max < array[i]) {
                max = array[i];
            }
        }

        int time = 0;
        while (max > 0) { // 判断位数
            max /= 10;
            time++;
        }

        // 建立10个队列
        List<ArrayList> queue = new ArrayList<ArrayList>();
        for (int i = 0; i < 10; i++) {
            ArrayList<Integer> queue1 = new ArrayList<Integer>();
            queue.add(queue1);
        }

        // 进行time次分配和收集
        for (int i = 0; i < time; i++) {
            // 分配数组元素
            for (int j = 0; j < array.length; j++) {
                // 得到数字的第time+1位数
                // Math.pow(double a,double b)为a的b次方
                int x = array[j] % (int) Math.pow(10, i + 1) / (int) Math.pow(10, i);
                ArrayList<Integer> queue2 = queue.get(x);
                queue2.add(array[j]);
                queue.set(x, queue2);

            }

            int count = 0;// 元素计数器;
            // 收集队列元素;
            for (int k = 0; k < 10; k++) {
                while (queue.get(k).size() > 0) {//第k个队列的长度
                    ArrayList<Integer> queue3 = queue.get(k);//把第k个对列给queue3
                    array[count] = queue3.get(0);//把queue3的第一个值值给array
                    queue3.remove(0);//给一次，就删除一次第一个元素
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