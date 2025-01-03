package com.study.algo.algorithm;

public class Sort {

	//���� ������ ���� ���� ����
	private static int[] sorted = new int[8];
	
	public static void main(String[] args) {
		
		//int temp; ���� �� �������� ���� ����ϴ� �Ͻ��� ����
				
		int[] arr = {1, 10, 5, 8, 7, 6, 4, 3, 2, 9};
		
		//���� ���� ��� ��� Ȯ��
		System.out.print("���� ���� : ");
		for(int i=0; i<arr.length; i++) {
			System.out.print(selectionSort(arr)[i] + " ");
		}
		System.out.println();
		
		//���� ���� ��� ��� Ȯ��
		System.out.print("���� ���� : ");
		for(int i=0; i<arr.length; i++) {
			System.out.print(bubbleSort(arr)[i] + " ");
		}
		System.out.println();
		
		//���� ���� ��� ��� Ȯ��
		System.out.print("���� ���� : ");
		for(int i=0; i<arr.length; i++) {
			System.out.print(insertionSort(arr)[i] + " ");
		}
		System.out.println();
		
		//�� ���� ��� ��� Ȯ��
		int[] data = {1, 10, 5, 8, 7, 6, 4, 3, 2, 9};
		int number = data.length;
		quickSort(data, 0, number - 1);
		System.out.print("�� ���� : ");
		for(int i=0; i<data.length; i++) {
			System.out.print(data[i] + " ");
		}
		System.out.println();
		
		//���� ���� ��� ��� Ȯ��
		int[] a = {7, 6, 5, 8, 3, 5, 9, 1};
		int num = 8;
		//int[] a = {7, 6, 5, 8};
		//int num = 4;
		mergeSort(a, 0, num - 1);
		System.out.print("���� ���� : ");
		for(int i=0; i<a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();

	}
	
	private static int[] selectionSort(int[] arr) {
		
		//���� ����(Selection Sort)
		//�������� ���� �� ���� ���� ���� �����ؼ� ���� ������ ������ ���
		//�ð����⵵ : O(N^2)
		
		int temp;
		int min;
		int index = 0; //�Ʒ����� �ʱ�ȭ���� �ʰ� �ٷ� ����� �Ǳ� ������ ������ �ʱ�ȭ
		
		for(int i=0; i<arr.length; i++) {
			//������ ū ũ���� ���� ����
			min = 9999;
			for(int j=i; j<arr.length; j++) {
				if(min > arr[j]) {
					//j�� ���� Ȱ���ϱ� ���� min, index�� ���� �ʿ��� ���� �־���
					min = arr[j];
					index = j;
				}
			}
			temp = arr[i];
			arr[i] = arr[index];
			arr[index] = temp;
		}
		
		return arr;
	}
	
	private static int[] bubbleSort(int[] arr) {
		
		//���� ����(Bubble Sort)
		//�������� ���� �� ���� �ִ� ���� ���ؼ� �� ���� ���� ������ ������ ���
		//�ð����⵵ : O(N^2)
		
		int temp;
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<(arr.length-1)-i; j++) {
				if(arr[j] > arr[j+1]) {
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		
		return arr;
	}
	
private static int[] insertionSort(int[] arr) {
		
		//���� ����(Bubble Sort)
		//�������� ���� �� �� ���ڸ� ������ ��ġ�� �����ϴ� ���(�� i�� ���� �ε����� ������ �Ϸ�Ǿ��ٰ� �Ǵ�)
		//�ð����⵵ : O(N^2)
		//�ð����⵵�� N^2������ ���� ����, ���� ���ĺ��� ȿ������ �˰����̴�.
		//�����Ͱ� �̹� ���� ���ĵ� ���¿� ���ؼ��� � �˰��򺸴ٵ� �����ٴ� Ư¡�� �ִ�.
		
		int temp;
		int j = 0;
		
		for(int i=0; i<arr.length-1; i++) {
			j=i; //j�� i�� �ֱ� ������ j+1�� ArrayOutOfIndex ���� �ʵ��� ������ arr.length-1�� ����
			while(arr[j+1] < arr[j]) {
				temp = arr[j];
				arr[j] = arr[j+1];
				arr[j+1] = temp;
				j--;
			}
		}
		
		return arr;
	}
	
	private static void quickSort(int[] data, int start, int end) {
		
		//�� ����(Bubble Sort) = ���Ұ� ����
		//�������� ���� �� Ư���� ���� �������� ū ���ڿ� ���� ���ڸ� ������ ���
		//��� �ð����⵵ : O(N*logN) -> logN �� log2�� N�� �ǹ�
		//�־��� ��쿡�� O(N^2)�� �����⵵ �Ѵ�. -> ��κ� ���ĵǾ��ִ� ���(���Ұ� ������ ������ Ȱ������ ���ϱ� ����)
		//�������� �ð����⵵ �鿡�� ���� �˰��� �� ���� ȿ������ �˰����̶�� �� �� �ִ�.
		//�Ϲ������� ���ذ�(Pivot��)�� �ִ�.(���� ���� ���� ���� ����)
		
		//���� [ (X) = ���ذ� ]
		//(3) 7 8 1 5 9 6 10 2 4 -> 3�� �������� �����ʿ��� 3���� ù ��°�� ū ���� 7 / ���ʿ��� 3���� ���� ���� 2
		//(3) 2 8 1 5 9 6 10 7 4 -> 3�� �������� �����ʿ��� 3���� ù ��°�� ū ���� 8 / ���ʿ��� 3���� ���� ���� 1
		//(3) 2 1 8 5 9 6 10 7 4 -> 3�� �������� �����ʿ��� 3���� ù ��°�� ū ���� 8 / ���ʿ��� 3���� ���� ���� 1
		//							-> 8, 1�� �������� �Ǿ��� �� ���� ���� 3�� ��ġ�� �ٲ��ش�.
		//1 2 [3] 8 5 9 6 10 7 4 -> 3�� ��ġ�� �����ȴ�. (3 ���� ���� ��� 3���� �۰�, 3 ������ ���� ��� 3���� ū ������ ��ġ�Ѵ�.)
		
		//(1) 2 [3] 8 5 9 6 10 7 4 -> 1�� �������� �����ʿ��� 1���� ù ��°�� ū ���� 2 / ���ʿ��� 1���� ���� ���� �����Ƿ� �ڱ� �ڽ��� ����
		//[1] 2 [3] 8 5 9 6 10 7 4 -> ��������� 1�� �ڱ� �ڽ��� �ٲ��ְ� ��(������ ���ذ��� ���ذ����� ���� ���� �ٲ��ִ� ������ ����)
		
		//[1] (2) [3] 8 5 9 6 10 7 4 -> �� ������ �����ϰ� ����
		//...
		
		if(start >= end) {	// ���Ұ� 1���� ���
			return;
		}
		
		int pivot = start;	// ù ��° ����
		int i = start + 1;	// ���� ��� ����(L->R)
		int j = end;		// ������ ��� ����(R->L)
		int temp;
		
		while(i <= j) {	// ������ ������ �ݺ�
			while(i <= end && data[i] <= data[pivot]) {	// Ű ������ ū ���� ���� ������ �ݺ�
				i++;
			}
			while(data[j] >= data[pivot] && j > start) { // Ű ������ ���� ���� ���� ������ �ݺ�
				j--;
			}
			/*
				���������� ��쿡�� ���ذ� �������� �¿츸 �ٲٸ� �Ǳ� ������
				
				data[i] <= data[pivot] -> data[i] >= data[pivot]
				
				data[j] >= data[pivot] -> data[j] <= data[pivot]
				
				�� ���� �ε�ȣ�� �ٲ��ָ� �ȴ�.
			*/
			if(i > j) {	// ���� ������ ���¶�� Ű ���� ��ü
				temp = data[j];
				data[j] = data[pivot];
				data[pivot] = temp;
			}else {		// ������ ���°� �ƴ϶�� i, j ���� ���� ��ü
				temp = data[j];
				data[j] = data[i];
				data[i] = temp;
			}
		}
		
		//��������� �����Ͱ� �������� while���� ���������� Ű ���� ��������
		//����
		quickSort(data, start, j - 1);
		//������
		quickSort(data, j + 1, end);
		//���� ���� �� ������ �ٽ� �����Ѵ�.
		
	}
	
	private static void merge(int a[], int m, int middle, int n) {
		
		//���� ����(Merge Sort)
		//�ϴ� ������ ������ ���߿� ���ļ� �����ϴ� ��� (��ġ�� ������ ����)
		//�ð����⵵ : O(N*logN)
		
		//�迭�� 7,6,5,8,... �� ��
		//7,6 / 5,8 �� �������� �ܰ迡��
		//i���� 7�� �ش��ϴ� �ε����� �ǹ��ϹǷ� m�� ����, middle�� 6�� 5 ���̸� �ǹ��ϹǷ� j���� middle + 1�� ����
		//k�� i �ε������� ä�������Ƿ� i���� ����
		
		int i = m;
		int j = middle + 1;
		int k = m;
		
		//���� �迭(sorted �迭)�� �ݵ�� ���� ������ ����!

		// ���� ������� �迭�� ����
		while(i <= middle && j <= n) {
			if(a[i] <= a[j]) {
				sorted[k] = a[i];
				i++;
			}else {
				sorted[k] = a[j];
				j++;
			}
			k++;
		}

		// ���� �����͵� ����
		if(i > middle) {
			for(int t = j; t <= n; t++) {
				sorted[k] = a[t];
				k++;
			}
		}else {
			for(int t = i; t <= middle; t++) {
				sorted[k] = a[t];
				k++;
			}
		}

		// ���ĵ� �迭�� ����
		for(int t = m; t <= n; t++) {
			a[t] = sorted[t];
		}
	}
	
	private static void mergeSort(int a[], int m, int n) {
		// ũ�Ⱑ 1���� ū ���
		if(m < n) {
			int middle = (m + n) / 2;
			mergeSort(a, m, middle);		// left�� �������� ������ ������������ ����ȴ� -> ù �ܰ�(a,0,3)
			mergeSort(a, middle + 1, n);	// right�� left�� ������ ����ȴ� -> ù �ܰ�(a,4,7)
			merge(a, m, middle, n);			// right�� ������ ������ ����ȴ�
		}
	}

}
