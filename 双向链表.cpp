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

//������������һ��˫�������ɹ��򷵻�ͷ�ڵ㣬ʧ�ܷ��� NULL 
ptr_TNode create(int *arr, int n)
{
	
}

//˫������,ɾ���� index λ�ڵ����Ľڵ㣬��ɾ���Ľ���ֵ���浽��*data���� 
Status delete_T(ptr_TNode *head, int index, int *data)
{
	
}
//˫������,�ڵ� index λ������� node ��� 
//����ɹ����� SUCCESS��ʧ�ܷ��� ERROR 
Status insert_T(ptr_TNode *head, ptr_TNode node, int index)
{
	
}
//���ٸ��������� 
void destroy(ptr_TNode head)
{
	
}
//��������ֵ����һ���ĸ�ʽ�����ÿ�ж��ٸ��Լ����壬��ʽԽƯ��Խ�ã�
void print(ptr_TNode head)
{
	
}

int main()
{
	return 0;
}