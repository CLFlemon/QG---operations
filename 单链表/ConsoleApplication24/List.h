#pragma once

#include<stdio.h>
#include<stdlib.h>

typedef struct Node
{
	int data;
	struct Node *next;
}Node, *ptr_Node;

typedef enum Status
{
	SUCCESS,
	ERROR
}Status;

ptr_Node create(int *arr, int n);
Status insert_(ptr_Node *head, ptr_Node node, int index);
Status delete_(ptr_Node *head, int index, int *data);
int search_(ptr_Node head, int data);
Status edit_(ptr_Node head, int index, int *data);
void print(ptr_Node head);
void destroy(ptr_Node head);