```java
public class MaxHeap {

    // 输入：整数数组 a，堆大小 heapSize
    public void buildMaxHeap(int[] a, int heapSize) {
        for (int i = heapSize / 2; i >= 0; --i) {
            // 从 heapSize / 2 开始，逐步向上遍历每一个节点，调用maxHeapify方法来调整每一个节点，使其符合最大堆的性质。
            // 为什么从 heapSize / 2 开始呢？因为二叉堆中，从heapSize / 2位置开始的节点都是叶子节点或空节点，
            // 而叶子节点天然满足堆的性质（即每个节点的值都大于或等于其子节点的值）。因此，我们只需要从最后一个非叶子节点开始调整堆的结构，
            // 其实 heapSize / 2 - 1 更加准确，但不影响
            maxHeapify(a, i, heapSize);
        }
    }
    
    // 输入：整数数组 a，需要调整的节点索引 i，堆大小 heapSize
    public void maxHeapify(int[] a, int i, int heapSize) {
        // l表示左子节点的索引，r表示右子节点的索引。largest 表示当前需要调整节点索引
        int l = i * 2 + 1, r = i * 2 + 2, largest = i;
        // 找到当前节点及其子节点中最大的节点。
        if (l < heapSize && a[l] > a[largest]) {
            largest = l;
        }
        if (r < heapSize && a[r] > a[largest]) {
            largest = r;
        }
        // 如果最大的节点不是当前节点，交换它们的位置，并递归地调用maxHeapify，确保交换后的子树也满足最大堆的性质。
        if (largest != i) {
            swap(a, i, largest);
            maxHeapify(a, largest, heapSize);
        }
    }

    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
```

# 构建最大堆的过程
## 构建最大堆的过程可以分为两个步骤：
### 从无序数组中创建一个堆。
### 通过调整堆来维护最大堆的性质。

# 创建堆的过程
构建最大堆的第一步是从一个无序数组开始。
假设我们有一个长度为n的数组，我们可以认为这个数组已经是一个二叉树的结构。
为了使这个二叉树成为一个最大堆，我们需要从最后一个非叶子节点开始，
逐步向上调整每一个节点，直到根节点。
这是通过buildMaxHeap方法完成的。

# 通过调整堆来维护最大堆的性质
buildMaxHeap方法通过调用maxHeapify方法来维护最大堆的性质。
maxHeapify的作用是确保以某个节点为根的子树满足最大堆的性质。