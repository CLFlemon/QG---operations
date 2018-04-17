#ifndef STACK1_H_INCLUDED
#define STACK1_H_INCLUDED

typedef enum Status
{
    ERROR = 0,OK = 1
}Status;

typedef int ElemType;

typedef  struct StackNode
{
	ElemType data;
	struct StackNode *next;
}StackNode, *LinkStackPtr;

LinkStackPtr InitLStack();
Status isEmptyLStack(LinkStackPtr head);
Status GetTopLStack(LinkStackPtr head,ElemType *TopPtr);
Status clearLStack(LinkStackPtr head);
Status destoryLStack(LinkStackPtr head);
Status PushLStack(LinkStackPtr head,ElemType datas);
Status PopLStack(LinkStackPtr head,ElemType *datas);


#endif // STACK1_H_INCLUDED
