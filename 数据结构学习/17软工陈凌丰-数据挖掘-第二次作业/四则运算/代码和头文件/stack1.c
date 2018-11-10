#include<stdio.h>
#include<stack1.h>
#include<stdlib.h>

LinkStackPtr InitLStack()
{
    LinkStackPtr head;
    head = (StackNode *)malloc(sizeof(StackNode));//����ռ�
    head->next = NULL;//��ʼ��
    return head;
}

Status isEmptyLStack(LinkStackPtr head)
{
    if(head->next == NULL) return ERROR;//�ж��Ƿ�Ϊ0
    else return OK;
}

Status GetTopLStack(LinkStackPtr head,ElemType *TopPtr )
{
    if(head->next != NULL){
        *(TopPtr) = (head->next->data);//�ж��Ƿ�Ϊ��Ȼ��ȥջ�� ��ֵ
        return OK;
    }
    return ERROR;
}

Status PopLStack(LinkStackPtr head,ElemType *dataPtr)
{
    LinkStackPtr Pop = NULL;
    if(head->next == NULL ) return ERROR;
    else{
        *(dataPtr) = (head->next->data);//ȡջ�� ���濪ʼfree��pop���
        Pop = head->next;
        head->next = head->next->next;
        free(Pop);
        return OK;
    }
}

Status PushLStack(LinkStackPtr head,ElemType datas)
{
    LinkStackPtr Push;
    Push = (StackNode *)malloc(sizeof(StackNode));//����ռ�
    if(Push == NULL) return ERROR;
    else{//���濪ʼ����
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
        while( isEmptyLStack(head)== 1)   PopLStack(head,dataPtr);//free��ÿһ����
        return OK;
    }
}

Status destoryLStack(LinkStackPtr head)
{
    int data;
    ElemType *dataPtr = &data;
    while( isEmptyLStack(head)== 1)   PopLStack(head,dataPtr);//ͬ��
    free(head);//headҲfree��
    return OK;
}


