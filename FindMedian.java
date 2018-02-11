class FindMedian {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] finalArr = new int[nums1.length + nums2.length];
        int i = 0; 
        int j = 0; 
        int k = 0;
        double median = 0;
        boolean flag = false;
        if(nums1.length == 0 && nums2.length == 0){
            flag = true;
        }else if(nums1.length == 0 && nums2.length != 0){
            finalArr = nums2;
        }else if(nums1.length != 0 && nums2.length == 0){
            finalArr = nums1;
        }else{
            while (i < nums1.length && j < nums2.length){
               if(nums1[i] < nums2[j]){
                   finalArr[k++] = nums1[i++];
               }else{
                   finalArr[k++] = nums2[j++];
               } 
            }  
            while (i < nums1.length){
               finalArr[k++] = nums1[i++]; 
            }  
            while (j < nums2.length){
                finalArr[k++] = nums2[j++];
            }
        }
        if(finalArr.length == 1){
                median = finalArr[0];
        }else if(finalArr.length%2 == 0){
            if(!flag){
                int mid1 = finalArr[(finalArr.length/2) - 1];
                int mid2 = finalArr[finalArr.length/2];
                median =  (double)(mid1+mid2)/(double)2;
            }
        }else{
            median = finalArr[finalArr.length/2];
        }
        return median;
    }
	public static void main(String args[]){
        Solution sol = new Solution();
        int n1[] = {1,2};
        int n2[] = {3,4};
        double median = sol.findMedianSortedArrays(n1, n2);
        System.out.println(median);
    }
}