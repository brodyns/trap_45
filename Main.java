public class Main {
    public static void main(String[] args) {
        int[] height = {4, 2, 0, 3, 2, 5};
        System.out.println((new Solution()).trap(height));
    }
}

class Solution{
    public int trap(int[] height){
        int length = height.length;
        if(length <= 2) return 0;
        int[] maxLeft = new int[length];
        int[] maxRight = new int[length];

        maxLeft[0] = height[0];
        maxRight[length-1] = height[length-1];

        // 记录每个柱子左边柱子最大高度(要算上自身,和自身一样后面减去h为0则无法积水)
        for(int i = 1; i < length; i++){
            maxLeft[i] = Math.max(height[i], maxLeft[i-1]);
        }
        // 记录每个柱子右边柱子最大高度(同理)
        for(int i = length-2; i >= 0; i--){
            maxRight[i] = Math.max(height[i], maxRight[i+1]);
        }

        int res = 0;
        for(int i = 1; i < length-1; i++){
            int h = Math.min(maxLeft[i], maxRight[i]);
            if(h > height[i]) res += h-height[i];
        }
        return res;
    }
}
