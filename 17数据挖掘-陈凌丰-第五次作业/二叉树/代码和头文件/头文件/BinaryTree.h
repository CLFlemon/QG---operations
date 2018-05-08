#ifndef BINARYTREE_H_INCLUDED
#define BINARYTREE_H_INCLUDED
typedef char TElemType;

typedef struct  BiTNode {
    TElemType      data;     // 数据域
    struct BiTNode  *lchild,*rchild;  // 左、右孩子指针
} BiTNode,*BiTree;   // 二叉链表

typedef enum Status{
	SUCEESS,
	ERROR
}Status;

Status InitBiTree(BiTree T);
BiTree DestroyBiTree(BiTree T);
void CreateBiTree(BiTree T, char* definition,int count,int );
void visit(char );
void PreOrderTraverse(BiTree T );
void InOrderTraverse(BiTree T);
void PostOrderTraverse(BiTree T);
void LevelOrderTraverse(BiTree T);


#endif // BINARYTREE_H_INCLUDED
