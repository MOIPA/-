package ����;

public class shellSortFV {
			//��������
	public static void swap(int[] num,int x,int y){
		int temp;
		temp = num[x];
		num[x] = num[y];
		num[y] = temp;
	}
			//������
	public static void sort(int[] num,int n){
		int i,j,gap;
		for(gap=n/2;gap>0;gap/=2){	//����������ѭ������ֱ������Ϊ1
			for(i=gap;i<n;i++){	//�ӵڲ���������ʼ������ÿһ���������Ĳ�������������
				for(j=i-gap;j>=0&&num[j]>num[j+gap];j-=gap)//���С���ϸ������� ����λ��
					swap(num,j,j+gap);
			}
		}
	}
public static void main(String[] args) {
	int[] num = { 1, 2, 3, 0 };
	sort(num, 4);
	System.out.println(num[0] + " " + num[1] + " " + num[2] + " " + num[3] + " ");
}
}
