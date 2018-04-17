#include<stdio.h>
#include<stack.h>
#include<stdlib.h>

LinkStackPtr InitLStack()
{
    LinkStackPtr head;
    head = (StackNode *)malloc(sizeof(StackNode));//申请空间
    head->next = NULL;//初始化
    return head;
}

Status isEmptyLStack(LinkStackPtr head)
{
    if(head->next == NULL) return ERROR;//判断是否为0
    else return OK;
}

Status GetTopLStack(LinkStackPtr head,ElemType *TopPtr )
{
    if(head->next != NULL){
        *(TopPtr) = (head->next->data);//判断是否为空然后去栈顶 赋值
        return OK;
    }
    return ERROR;
}

Status PopLStack(LinkStackPtr head,ElemType *dataPtr)
{
    LinkStackPtr Pop = NULL;
    if(head->next == NULL ) return ERROR;
    else{
        *(dataPtr) = (head->next->data);//取栈顶 下面开始free掉pop结点
        Pop = head->next;
        head->next = head->next->next;
        free(Pop);
        return OK;
    }
}

Status PushLStack(LinkStackPtr head,ElemType datas)
{
    LinkStackPtr Push;
    Push = (StackNode *)malloc(sizeof(StackNode));//申请空间
    if(Push == NULL) return ERROR;
    else{//下面开始插入
        Push->data = datas;
        Push->next = head->next;
        head->next = Push;
        return OK;
    }
}

Status clearLStack(LinkStackPtr head)
{
    int data;
    ElemType *dataPtr = &data;
    if( head == NULL) return ERROR;
    else{
        while( isEmptyLStack(head)== 1)   PopLStack(head,dataPtr);//free掉每一个点
        return OK;
    }
}

Status destoryLStack(LinkStackPtr head)
{
    int data;
    ElemType *dataPtr = &data;
    while( isEmptyLStack(head)== 1)   PopLStack(head,dataPtr);//同上
    free(head);//head也free掉
    return OK;
}


//以上是链表栈


Status initStack(SqStack *s , ElemType sizes)
{
    s->Array = (ElemType *)malloc(sizes * sizeof(ElemType));//为数组申请空间
    if(s->Array == NULL) return ERROR;
    s->size = sizes;
    s->top = -1;//判断是否为空栈
    return OK;
}

Status isEmptyStack(SqStack *s)
{
    if(s->top == -1) return ERROR;//返回0是空的
    return OK;//返回1不是空的
}

Status PushStack(SqStack *s,ElemType data )
{
    if(s ==NULL || s->top >= s->size-1) return ERROR;
    s->Array[++(s->top)] = data;//插入 top的值+1
    return OK;
}

Status PopStack(SqStack *s,ElemType *data)
{
  if(s== NULL || s->top == -1) return ERROR;
  *(data) = s->Array[(s->top)--];//pop出头结点 top-1;
  return OK;
}

Status GetTopStack(SqStack *s,ElemType *e)
{
    if(s==NULL || s->top == -1) return ERROR;
    *(e) = s->Array[s->top];//赋值
    return OK;
}

Status clearStack(SqStack *s)   //清空链表
{
    if(s == NULL) return ERROR;
    s->top = -1;
    free(s->Array);//free数组
    return OK;
}

Status destoryStack(SqStack *s)  //销毁链表
{
    if(s == NULL) return ERROR;
    free(s->Array);//同上
    free(s);//把s也free掉
    return OK;
}
