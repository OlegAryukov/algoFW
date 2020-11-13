package leetcode.explore.array.explore;

public class RemoveElements {

    //Solution from leetcode
    public int removeElement(int[] nums, int val) {
        int i = 0;
        for (int elem: nums){
            if (elem != val){
                nums[i] = elem;
                i++;
            }
        }
        return i;
    }

    public int removeElementInSortedArray(int[] nums) {
        int val = nums[0];
        int i = 1;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != val){
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
//        int val = nums[0];
//        int i = 0;
//        for (int j = 1; j < nums.length; j++) {
//            if(nums[j] == val){
//                continue;
//            }
//            i++;
//            nums[i] = nums[j];
//            val = nums[j];
//        }
//        return nums.length-i;
    }

    public int removeElement2(int[] nums, int val) {
        if (nums.length==1 && nums[0] == val){
            nums = new int[0];
            return 1;
        }
        int startToReplIndex = -1;
        int tempCoutnOfvals = 0;
        int coutnOfvals = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val && i < nums.length) {
                if(i >= 1 && nums[i-1]==val){
                    tempCoutnOfvals++;
                    coutnOfvals++;
                    continue;
                }
                startToReplIndex = i;
                tempCoutnOfvals++;
                coutnOfvals++;
                continue;
            }
            if (startToReplIndex >= 0) {
                i = startToReplIndex;
                for (int j = startToReplIndex+tempCoutnOfvals; j < nums.length; j++) {
                    nums[startToReplIndex] = nums[j];
                    startToReplIndex++;
                }
                for (int j = nums.length-1; j > nums.length-1-coutnOfvals ; j--) {
                    nums[j]=0;
                }
                startToReplIndex = -1;
                tempCoutnOfvals = 0;
            }
        }

        return nums.length - coutnOfvals;
    }

    public static void main(String[] args) {
        RemoveElements re = new RemoveElements();
        int[] nums = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        int val = 2;
        System.out.println(re.removeElement2(nums, val));
        System.out.println("----------");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " : ");
        }
        System.out.println("\n ************");
        int[] nums2 = new int[]{3, 2, 2, 3};
        int val2 = 3;
        System.out.println(re.removeElement2(nums2, val2));
        System.out.println("----------");
        for (int i = 0; i < nums2.length; i++) {
            System.out.print(nums2[i] + " : ");
        }
        System.out.println("\n ************");
        int[] nums3 = new int[]{0,4,4,0,4,4,4,0,2};
        int val3 = 4;
        System.out.println(re.removeElement2(nums3, val3));
        System.out.println("----------");
        for (int i = 0; i < nums3.length; i++) {
            System.out.print(nums3[i] + " : ");
        }
    }
}
