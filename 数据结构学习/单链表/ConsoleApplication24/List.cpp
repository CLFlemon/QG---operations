#include<stdio.h>
#include<stdlib.h>
#include"List.h"

extern int len;
ptr_Node create(int *arr, int n)
{
	Node *p, *head;
	p = (ptr_Node)malloc(sizeof(Node));//为p分配了空间
	p->data = *(arr + 1);
	head = p;
	for (int i = 2; i <= n; i++) {
		p->next = (ptr_Node)malloc(sizeof(Node));
		p = p->next;
		p->data = *(arr + i);
	}
	p->next = NULL;
	return head;
}

Status insert_(ptr_Node *head, ptr_Node node, int index)
{
	if (index == 0) {
		node->next = *(head);
		*(head) = node;
		return SUCCESS;
	} // 改变了头结点的位置 所以输入二阶指针
	else {
		if (index<0 || index>len) return ERROR;
		else {
			ptr_Node p = *(head);
			for (int i = 1; i<index; i++) {
				p = p->next;
			}
			node->next = p->next;
			p->next = node;
			return SUCCESS;
		}
	}
}

Status delete_(ptr_Node *head, int index, int *data)
{
	if (index == 0) {
		data = &((*(head))->data);
		ptr_Node p = (*(head))->next;
		free(*(head));
		*(head) = p;
		return SUCCESS;
	}
	else {
		if (index<0 || index >= len) return ERROR;
		else {
			ptr_Node p = *(head);
			for (int i = 1; i<index; i++) {
				p = p->next;
			}
			data = &((p->next)->data);
			ptr_Node p1 = (p->next)->next;
			p->next = p1;
			return SUCCESS;
		}
	}
}

int search_(ptr_Node head, int data)
{
	int count = 1;
	for (; head != NULL; head = head->next) {
		if (head->data == data) return count - 1;
		count++;
	}
	return -1;
}

Status edit_(ptr_Node head, int index, int *data)
{
	if (index == 0) {
		int temp;
		temp = head->data;
		head->data = *(data);
		*(data) = temp;
		return SUCCESS;
	}
	else {
		if (index<0 || index >= len) return ERROR;
		ptr_Node p = (head);
		for (int i = 1; i<index; i++) {
			p = p->next;
		}
		ptr_Node p1 = p->next;
		int temp;
		temp = p1->data;
		p1->data = *(data);
		*(data) = temp;
		return SUCCESS;
	}
}

void print(ptr_Node head)
{
	ptr_Node  p;
	p = head;
	for (; head != NULL; head = head->next)
		printf("%d\n", head->data);
	head = p;

	printf("\n");
}
void destroy(ptr_Node head)
{
	ptr_Node p;
	for (; head != NULL; ) {
		p = head;
		head = head->next;
		free(p);
	}
}