#include<stdio.h>
#include<stdlib.h>

typedef struct TNode 
{ 
	int data; 
	struct TNode *next;
	struct TNode *pre;
}TNode, *ptr_TNode;

typedef enum Status 
{
	SUCCESS,
	ERROR 
}Status;

//根据数组生成一条双向链表，成功则返回头节点，失败返回 NULL 
ptr_TNode create(int *arr, int n)
{
	
}

//双向链表,删除第 index 位节点后面的节点，将删除的结点的值保存到（*data）中 
Status delete_T(ptr_TNode *head, int index, int *data)
{
	
}
//双向链表,在第 index 位后面插入 node 结点 
//插入成功返回 SUCCESS，失败返回 ERROR 
Status insert_T(ptr_TNode *head, ptr_TNode node, int index)
{
	
}
//销毁给定的链表 
void destroy(ptr_TNode head)
{
	
}
//将链表结点值按照一定的格式输出（每行多少个自己定义，格式越漂亮越好）
void print(ptr_TNode head)
{
	
}

int main()
{
	return 0;
}