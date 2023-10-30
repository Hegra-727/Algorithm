package Daily.Oct2023;

public class H指数II275 {
    /*//末尾元素数量<=citations[i]
    public int hIndex(int[] citations) {
        int l=0,r= citations.length-1;
        while(l<r){
            int mid=l+r>>1;
            if(citations.length-mid<=citations[mid])
                r=mid-1;
            else
                l=mid;
        }
        return citations.length-r;
    }
    public int bsearch(int[] citations,int target){
        int l=0,r= citations.length-1;
        while(l<r){
            int mid=l+r>>1;
            if(citations[r]>target)
                r=mid-1;
            else
                l=mid;
        }
        return l;
    }*/
    public int hIndex(int[] citations) {
        int l=0,r= citations.length-1;
        while(l<=r){
            int mid=l+r>>1;
            if(citations.length-mid<=citations[mid])
                r=mid-1;
            else
                l=mid+1;
        }
        return citations.length-l;
    }
}
