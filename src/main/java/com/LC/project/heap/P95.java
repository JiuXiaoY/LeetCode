package com.LC.project.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author JXY
 * @version 1.0
 * @since 2024/8/9
 */
public class P95 {
    public static void main(String[] args) {

    }

    class MedianFinder {

        PriorityQueue<Integer> maxHeap;
        PriorityQueue<Integer> minHeap;

        public MedianFinder() {
            maxHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a));
            minHeap = new PriorityQueue<>((a, b) -> b - a);
        }

        public void addNum(int num) {
            if (minHeap.isEmpty() || num <= minHeap.peek()) {
                minHeap.offer(num);
                if (minHeap.size() > maxHeap.size() + 1) {
                    maxHeap.offer(minHeap.poll());
                }
            } else {
                maxHeap.offer(num);
                if (maxHeap.size() > minHeap.size()) {
                    minHeap.offer(maxHeap.poll());
                }
            }
        }

        public double findMedian() {
            if (minHeap.size() > maxHeap.size())
                return minHeap.peek();
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        }
    }
}
