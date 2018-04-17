#ifndef STACK_H_INCLUDED
#define STACK_H_INCLUDED
typedef enum Status
{
    ERROR = 0,OK = 1
}Status;
typedef int ElemType;
typedef struct SqStack
{
    ElemType size;
    ElemType top;
    ElemType *Array;
}SqStack;

typedef  struct StackNode
{
	ElemType data;
	struct StackNode *next;
}StackNode, *LinkStackPtr;

//Á´±í
LinkStackPtr InitLStack();
Status isEmptyLStack(LinkStackPtr head);
Status GetTopLStack(LinkStackPtr head,ElemType *TopPtr);
Status clearLStack(LinkStackPtr head);
Status destoryLStack(LinkStackPtr head);
Status PushLStack(LinkStackPtr head,ElemType datas);
Status PopLStack(LinkStackPtr head,ElemType *datas);

//Êý×é

Status initStack(SqStack *s,int sizes);
Status isEmptyStack(SqStack *s);
Status GetTopStack(SqStack *s,ElemType *e);
Status clearStack(SqStack *s);
Status destoryStack(SqStack *s);
Status PushStack(SqStack *s,ElemType datas);
Status PopStack(SqStack *s,ElemType *datas);
#endif // STACK_H_INCLUDED
