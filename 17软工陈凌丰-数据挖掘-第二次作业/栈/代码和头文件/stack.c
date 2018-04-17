#include<stdio.h>
#include<stack.h>
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


//����������ջ


Status initStack(SqStack *s , ElemType sizes)
{
    s->Array = (ElemType *)malloc(sizes * sizeof(ElemType));//Ϊ��������ռ�
    if(s->Array == NULL) return ERROR;
    s->size = sizes;
    s->top = -1;//�ж��Ƿ�Ϊ��ջ
    return OK;
}

Status isEmptyStack(SqStack *s)
{
    if(s->top == -1) return ERROR;//����0�ǿյ�
    return OK;//����1���ǿյ�
}

Status PushStack(SqStack *s,ElemType data )
{
    if(s ==NULL || s->top >= s->size-1) return ERROR;
    s->Array[++(s->top)] = data;//���� top��ֵ+1
    return OK;
}

Status PopStack(SqStack *s,ElemType *data)
{
  if(s== NULL || s->top == -1) return ERROR;
  *(data) = s->Array[(s->top)--];//pop��ͷ��� top-1;
  return OK;
}

Status GetTopStack(SqStack *s,ElemType *e)
{
    if(s==NULL || s->top == -1) return ERROR;
    *(e) = s->Array[s->top];//��ֵ
    return OK;
}

Status clearStack(SqStack *s)   //�������
{
    if(s == NULL) return ERROR;
    s->top = -1;
    free(s->Array);//free����
    return OK;
}

Status destoryStack(SqStack *s)  //��������
{
    if(s == NULL) return ERROR;
    free(s->Array);//ͬ��
    free(s);//��sҲfree��
    return OK;
}
