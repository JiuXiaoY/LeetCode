# 二叉搜索树 中序遍历相当于一个升序的数组
## 定义
### 每个节点都有一个值
### 左子树中所有节点的值都小于根节点的值
### 右子树中所有节点的值都大于根节点的值
### 左右子树也分别是二叉搜索树


前序遍历：根节点->左子树->右子树
中序遍历：左子树->根节点->右子树
后序遍历：左子树->右子树->根节点

根前序遍历和中序遍历可以唯一确定一颗二叉树
 基于这些信息：
 - 前序遍历的第一个元素总是根节点
 - 在中序遍历中找到根节点的位置，就可以将中序遍历分为左右子树
 - 递归求解即可
 
