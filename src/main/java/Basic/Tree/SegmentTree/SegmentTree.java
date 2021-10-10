package Basic.Tree.SegmentTree;

import java.util.Arrays;

public class SegmentTree {
    public static void main(String[] args) {

    }
    long tree[];
    int size;

    @Override
    public String toString() {
        return "SegmentTree{" +
                "tree=" + Arrays.toString(tree) +
                ", size=" + size +
                '}';
    }

    public SegmentTree(int arrSize) {
        int h = (int) Math.ceil(Math.log(arrSize) / Math.log(2));
        this.size = (int) Math.pow(2, h + 1);
        tree = new long[size];
    }
    // tree 구성.
    public long init(int nums[], int nodeIdx, int start, int end) {
        if (start == end) { // leaf node
            return tree[nodeIdx] = nums[start];
        }

        return tree[nodeIdx] = init(nums, nodeIdx * 2, start, (start + end) >> 1)
                + init(nums, nodeIdx * 2 + 1, (start + end) / 2 + 1, end);
    }

    public void update(int nodeIdx, int start, int end, int idx, long diff) {
        if (idx < start || end > idx) return;

        tree[nodeIdx] += diff;

        if (start != end) {
            update(nodeIdx * 2, start, (start + end) / 2, idx, diff);
            update(nodeIdx * 2 + 1, (start + end)/2 + 1, end, idx, diff);
        }
    }

    public long sum(int nodeIdx,int start,int end,int left,int right){
        if(left>end || right<start){
            return 0;
        }

        if(left<=start && end<=right){
            return tree[nodeIdx];
        }

        return sum(nodeIdx*2,start,(start+end)/2,left,right)
                +sum(nodeIdx*2+1,(start+end)/2+1,end,left,right);
    }
}
