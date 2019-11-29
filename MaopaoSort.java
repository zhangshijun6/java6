public class MaopaoSort {

    // 自定义成员方法实现冒泡排序算法
    public static void bubble(int[] arr) {
        // 1.使用外层for循环用于控制比较的轮数
        for(int i = 1; i < arr.length; i++) {
            // 声明boolean类型的标志位
            boolean flag = true;
            // 2.使用内层for循环用于控制每一轮中比较的次数，也就是下标范围
            for(int j = 0; j < arr.length-i; j++) {
                // 3.若第一个元素比第二个元素大，则交换两个元素的位置
                if(arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    flag = false;
                }
            }
            // 若执行到这里时，flag的数值依然是true，则证明没有发生交换
            if(flag) break;//跳出循环 省略剩余比较轮数
        }
    }
    // 自定义成员方法实现快速排序算法
    public static void quick(int[] arr,int left,int right){
        //1 计算中间元素的下标并使用变量记录
        int p = (left+right)/2;
        //2 选择中间元素作为基准值并单独保存
        int pivot = arr[p];
        //3 分别使用左右两边的元素依次与基准值比较大小，将所有小于基准值的元素放在左边,大于放右边
        //定义2个替身 为了递归方便
        int i = left;
        int j = right;
        for(;i<j;){
            //若左边有元素并且左边的元素小于基准值，则使用下一个元素与基准值比较
            while(i<p && arr[i] < pivot){
                i++;
            }
            //直到左边有元素但左边的元素不再小于基准值时,则将左边的元素赋值给p指向的位置，p指向该元素之前位置
            if(i < p){
                arr[p] = arr[i];
                p = i;
            }
            //若右边有元素并且右边的元素大于等于基准值，则使用下一个元素与基准值比较
            while(p < j && arr[j]>= pivot){
                j--;
            }
            //直到右边有元素但右边的元素不再大于等于基准值时，则将右边的元素赋值到p指向的位置，p指向该元素原来位置
            if(p < j){
                arr[p] = arr[j];
                p = j;
            }
        }

        //4 直到左右两边元素下标重合时，将基准值放到重合位置
        arr[p] = pivot;
        //5 分别对左右两边的分组进行再次分组，使用递归思想
        //左右两边的分组分别至少有2个元素才需要递归
        if(p - left >1){
            quick(arr,left,p-1);
        }
        if(right - p > 1){
            quick(arr,p+1,right);
        }
    }

    public static void main(String[] args) {

        int[] arr = {10, 20, 5, 15, 30,16,20, 8, 12};
        // 调用方法进行排序
        //MaopaoSort.bubble(arr);
        MaopaoSort.quick(arr,0,8);
        // 打印排序后的结果
        System.out.print("排序后的结果是：");
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }


}