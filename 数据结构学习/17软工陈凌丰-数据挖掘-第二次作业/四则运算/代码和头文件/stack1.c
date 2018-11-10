#include<stdio.h>
#include<stack1.h>
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


