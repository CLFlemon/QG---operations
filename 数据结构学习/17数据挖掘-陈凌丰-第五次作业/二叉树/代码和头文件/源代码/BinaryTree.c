#include<BinaryTree.h>
#include<stdlib.h>
#include<stdio.h>
#include<string.h>
Status InitBiTree(BiTree T)
{
        if(T != NULL)
        {
            T->lchild = NULL;
            T->rchild = NULL;
            return SUCEESS;
        }
        else return ERROR;
}//

void CreateBiTree(BiTree T, char* definition,int flag,int len)
{
    T->lchild = NULL;
    T->rchild = NULL;
    if(flag<=len)
    {
        T->data = *(definition+flag);
        if(flag*2 <=len)
        {
            T->lchild =(BiTree )malloc(sizeof(BiTNode));
            CreateBiTree(T->lchild,definition,flag*2,len);
        }
        if(flag*2+1<=len)
       {
            T->rchild = (BiTree )malloc(sizeof(BiTNode));
            CreateBiTree(T->rchild,definition,flag*2+1,len);
       }
    }
}

void visit(char ch)
{
    printf("%c ",ch);
}

void PreOrderTraverse(BiTree T)
{

    if(T!=NULL)
    {
        visit(T->data);
        PreOrderTraverse(T->lchild);
        PreOrderTraverse(T->rchild);
    }
    else return;
}

void InOrderTraverse(BiTree T)
{
    if(T->lchild != NULL)
        InOrderTraverse(T->lchild);

    visit(T->data);//

    if(T->rchild != NULL)
        InOrderTraverse(T->rchild);
}

void PostOrderTraverse(BiTree T)
{
     if(T->lchild != NULL)
        PostOrderTraverse(T->lchild);
    if(T->rchild != NULL)
        PostOrderTraverse(T->rchild);

     visit(T->data);
}

void LevelOrderTraverse(BiTree T)
{
     int head = 0, tail = 0;

    BiTNode *p[1000];

    BiTNode *tmp;

    if (T != NULL) {

        p[head] = T;

        tail++;

        // Do Something with p[head]

    }
    while (head < tail) {

        tmp = p[head];

        // Do Something with p[head]

        if (tmp->lchild != NULL) { // left

            p[tail] = tmp->lchild;

            tail++;

        }

        if (tmp->rchild != NULL) { // right

            p[tail] = tmp->rchild;

            tail++;
        }
        head++;
    }
    for(int i = 0;i<head;i++) printf("%c ",p[i]->data);
}

BiTree DestroyBiTree(BiTree T)
{
    if(T)
    {
        DestroyBiTree(T->lchild);
        DestroyBiTree(T->rchild);
        free(T);
    }
    return NULL;
}

