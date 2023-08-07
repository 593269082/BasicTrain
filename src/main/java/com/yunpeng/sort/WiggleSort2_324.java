package com.yunpeng.sort;

public class WiggleSort2_324 {
    //O(n)时间复杂度 +O(1)空间复杂度 可能只能用基数排序了
    public static void main(String[] args) {
        int[] testnums={3,5,2,1,6,4};
        Solution324 s=new Solution324();
        s.wiggleSort(testnums);
        for(int i:testnums){
            System.out.print(i+" ");
        }
    }
}
class Solution324 {
    public static void radixSort(int[] array) {
        int max = getMax(array); // 找到数组中的最大值

        // 迭代每个位数，从个位到最高位
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSortByDigit(array, exp);
        }
    }

    public static int getMax(int[] array) {
        int max = array[0];
        for (int num : array) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    public static void countingSortByDigit(int[] array, int exp) {
        int n = array.length;
        int[] output = new int[n];
        int[] count = new int[10];

        // 初始化 count 数组
        for (int i = 0; i < 10; i++) {
            count[i] = 0;
        }

        // 计算每个数字出现的次数
        for (int num : array) {
            count[(num / exp) % 10]++;
        }

        // 将 count 转换为累积次数，此时 count[i] 表示小于等于 i 的元素数量
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // 从后往前遍历数组，根据 count 数组将元素放到正确的位置
        for (int i = n - 1; i >= 0; i--) {
            output[count[(array[i] / exp) % 10] - 1] = array[i];
            count[(array[i] / exp) % 10]--;
        }

        // 将排序后的结果复制回原数组
        for (int i = 0; i < n; i++) {
            array[i] = output[i];
        }
    }

    public void wiggleSort(int[] nums) {
    //基数排序 存在重复 这个题有点太难了

        radixSort(nums);
        int n=nums.length;
        if(n==1){
            return;
        }
        for(int i=1;i<n-1;i+=2){
            int buffer;
            buffer=nums[i+1];
            nums[i+1]=nums[i];
            nums[i]=buffer;
        }

    }
}