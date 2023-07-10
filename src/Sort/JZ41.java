package Sort;

import java.util.*;
import java.lang.*;

/**
 * 剑指Offer
 * JZ41 数据流中的中位数
 * 如何得到一个数据流中的中位数？
 * 如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值
 * 我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 * 1 <= 数据流中数的个数 <= 1000
 * 1 <= 数组中所有数字的值 <= 1000
 * 空间复杂度O(n)，时间复杂度O(n log n)
 */

public class JZ41 {

    /**
     * Method 1: Using array to store the numbers and using the insert sort to sort the number array.
     */
    private ArrayList<Integer> val = new ArrayList<Integer>();

    public void Insert1(Integer num) {
        if (val.isEmpty())
            //val中没有数据，直接加入
            val.add(num);
            //val中有数据，需要插入排序
        else {
            int i = 0;
            //遍历找到插入点
            for (; i < val.size(); i++) {
                if (num <= val.get(i))
                    break;
            }
            //插入相应位置
            val.add(i, num);
        }
    }

    public Double GetMedian1() {
        int n = val.size();
        //奇数个数字
        if (n % 2 == 1)
            //类型转换
            return (double) val.get(n / 2);
            //偶数个数字
        else {
            double a = val.get(n / 2);
            double b = val.get(n / 2 - 1);
            return (a + b) / 2;
        }
    }

    /**
     * Method 2: Heapsort. Using PriorityQueue to record the largest elements and smallest elements in the array. And
     * check the length for both queue and maintain the balance.
     */
    //小顶堆，元素数值都比大顶堆大
    private PriorityQueue<Integer> max = new PriorityQueue<>();
    //大顶堆，元素数值较小
    private PriorityQueue<Integer> min = new PriorityQueue<>((o1, o2) -> o2.compareTo(o1));

    //维护两个堆，取两个堆顶部即与中位数相关
    public void Insert2(Integer num) {
        //先加入较小部分
        min.offer(num);
        //将较小部分的最大值取出，送入到较大部分
        max.offer(min.poll());
        //平衡两个堆的数量
        if (min.size() < max.size())
            min.offer(max.poll());
    }

    public Double GetMedian2() {
        //奇数个
        if (min.size() > max.size())
            return (double) min.peek();
        else
            //偶数个
            return (double) (min.peek() + max.peek()) / 2;
    }

}
