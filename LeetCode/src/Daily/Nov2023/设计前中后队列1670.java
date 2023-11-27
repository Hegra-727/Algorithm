package Daily.Nov2023;

import java.util.LinkedList;

public class 设计前中后队列1670 {
    class FrontMiddleBackQueue {
        LinkedList<Integer> preq;
        LinkedList<Integer> proq;
        int pren,pron;
        public FrontMiddleBackQueue() {
            pren=0;
            pron=0;
            preq=new LinkedList<Integer>();
            proq=new LinkedList<Integer>();
        }

        public void pushFront(int val) {
            preq.offerFirst(val);
            pren++;
            if(pren>pron){
                proq.offerFirst(preq.pollLast());
                pren--;
                pron++;
            }
        }

        public void pushMiddle(int val) {
            preq.offerLast(val);
            pren++;
            if(pren>pron){
                proq.offerFirst(preq.pollLast());
                pren--;
                pron++;
            }
        }

        public void pushBack(int val) {
            proq.offerLast(val);
            pron++;
            if(pron>pren+1){
                preq.offerLast(proq.pollFirst());
                pren++;
                pron--;
            }
        }

        public int popFront() {
            int res=-1;
            if(preq.isEmpty()&&!proq.isEmpty()){
                res=proq.pollFirst();
                pron--;
            }else if(!preq.isEmpty()){
                res=preq.pollFirst();
                pren--;
                if(pron>pren+1){
                    preq.offerLast(proq.pollFirst());
                    pren++;
                    pron--;
                }
            }
            // System.out.println(res);
            return res;
        }

        public int popMiddle() {
            int res=-1;
            if(pron>pren){
                res=proq.pollFirst();
                pron--;
            }else if(pron==pren&&pron!=0){
                res=preq.pollLast();
                pren--;
                if(pron>pren+1){
                    preq.offerLast(proq.pollFirst());
                    pren++;
                    pron--;
                }
            }
            // System.out.println(res);
            return res;
        }

        public int popBack() {
            int res=-1;
            if(!proq.isEmpty()){
                res=proq.pollLast();
                pron--;
                if(pren>pron){
                    proq.offerFirst(preq.pollLast());
                    pren--;
                    pron++;
                }
            }
            // System.out.println(res);
            return res;
        }
    }

/**
 * Your FrontMiddleBackQueue object will be instantiated and called as such:
 * FrontMiddleBackQueue obj = new FrontMiddleBackQueue();
 * obj.pushFront(val);
 * obj.pushMiddle(val);
 * obj.pushBack(val);
 * int param_4 = obj.popFront();
 * int param_5 = obj.popMiddle();
 * int param_6 = obj.popBack();
 */
}
