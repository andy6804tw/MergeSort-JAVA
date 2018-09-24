import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>(); //建立一個整數形態的ArrayList串列
		list = Arrays.asList(13, 8, 27, 35, 2, 1, 9, 6, 34, 2, 45, 26); // 賦予初始值
		System.out.println("MergeSort By Recursive Method");
		mergeSort(list, 0, list.size() - 1);//(資料,最左邊索引值,最右邊索引值)
		for (int i = 0; i < list.size(); i++)
			System.out.println(list.get(i));
	}
	public static void mergeSort(List<Integer> list,int left,int right) {
		if(left<right) { //當左邊大於右邊時代表只剩一個元素了
			int mid = (left+right)/2; //每次對切，切到只剩一個為止
			mergeSort(list, left, mid); //左邊等份
			mergeSort(list, mid+1, right); //右邊等份
			System.out.println(left + " " + (mid + 1) + " " + right);
			Merge(list,left,mid+1,right); //排序且合併
		}
	}

	public static void Merge(List<Integer> list, int left, int mid, int right) {
		int[] temp = new int[right+1]; //建立一個temp陣列存放排序後的值
		int left_end = mid - 1; //左邊最後一個位置
		int index = left; //位移起始點
		int origin_left = left; //將最左邊的變數儲存起來(最後搬移元素會用到)
		while ((left <= left_end) && (mid <= right)) { // 左右兩串列比大小依序放入temp陣列中儲存
			if (list.get(left) <= list.get(mid))
				temp[index++] = list.get(left++);
			else
				temp[index++] = list.get(mid++);
		}

		if (left <= left_end) { //若左邊的串列尚未走完將剩餘的數值依序放入temp陣列中
			while (left <= left_end) {
				temp[index++] = list.get(left++);
			}
		} else { //反之若右邊的串列尚未走完將剩餘的數值依序放入temp陣列中
			while (mid <= right) {
				temp[index++] = list.get(mid++);
			}
		}
		//最後將排序好的temp陣列複製到list串列中
		for (int i = origin_left; i <= right; i++) {
			list.set(i, temp[i]);
		}

	}

}
