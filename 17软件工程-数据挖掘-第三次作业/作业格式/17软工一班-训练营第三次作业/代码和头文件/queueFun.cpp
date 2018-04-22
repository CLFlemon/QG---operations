#include<cstdio>
#include<stdlib.h>
#include<cstring>
#include<queue.h>
void InitAQueue(AQueue *Q)
{
    Q->data = malloc(Q->data_size * maxn);
    Q->front = 0;
    Q->rear = 0;
    Q->len = 0;
}

Status EnAQueue(AQueue *Q , void *dataPtr)
{
   if(Q->len>=maxn) return FLASE;
   else{
       void *target = (Q->data)+  (Q->rear)%maxn *(Q->data_size);
       memcpy(target,dataPtr,Q->data_size);
       (Q->rear)++;
       (Q->len)++;
       return TRUE;
   }
}

Status IsFullAQueue(AQueue *Q)
{
    if(Q->len==maxn) return FLASE;//0是满
    else return TRUE;//非0即不满
}

Status IsemptyAQueue(AQueue *Q)
{
    if(Q->len == 0) return FLASE;// 0 是空
    else return TRUE;//1不为空
}

Status GetHeadAQueue(AQueue *Q,void *e)
{
    if(Q->len==0) return FLASE;
    else{
        void *target = (Q->data)+ Q->front * Q->data_size;
        memcpy(e,target,Q->data_size);
        printf(" 操作成功 数据为：\n");
        if(Q->flag == 0) printf("%c\n",   *((char *)e)    );
        else if(Q->flag == 1) printf("%d\n", *((int *)e));
        else if(Q->flag == 2) printf("%lf\n",*((double *)e));
        free(e);
        return TRUE;
    }
}

Status DeAQueue(AQueue *Q)
{
    if(Q->len == 0) return FLASE;
    else{
        (Q->front)++;
        Q->len--;
        return TRUE;
    }
}

void ClearAQueue(AQueue *Q)
{
    free(Q->data);
    Q->front = 0;
    Q->rear = 0;
    Q->len = 0;
}

void DestoryAQueue(AQueue *Q)
{
    free(Q->data);
    Q->front = 0;
    Q->rear = 0;
    Q->len = -1;
    free(Q);
}

Status TraverseAQueue(AQueue *Q,void (*foo)(void *q,int))
{
    if(Q->len == 0) return FLASE;
    int TLEN = Q->len;
    int TFRONT = Q->front;
    while(TLEN)
    {
        void *target = (Q->data)+ TFRONT * Q->data_size;
        foo(target,Q->flag);
        TFRONT++;
        TLEN--;
    }
    return TRUE;
}

void APrint(void *q,int flag)
{
    if(flag == 0) printf("%c\n",*((char *)q));
    else if( flag == 1) printf("%d\n",*((int *)q));
    else if( flag == 2) printf("%lf\n",*((double *)q));
}

//下面是链表队列
void InitLQueue(LQueue *L)
{
    L->rear= L->front = (Node *)malloc(L->data_size);//指向同一个地方
    L->len = 0;
}

Status IsemptyLQueue(LQueue *L)
{
    if(L->len == 0) return FLASE;
    else return TRUE;
}

Status EnLQueue(LQueue *L,Node * Node1,void *data)
{

    L->rear->data = malloc(Node1->data_size);
    void *target = L->rear->data + Node1->data_size;
    memcpy(target,data,Node1->data_size);
    L->rear->next =(Node *) malloc(L->data_size);
    L->rear = L->rear->next =(Node *) malloc(Node1->data_size);
    L->rear->next = NULL;
    L->len++;

    return TRUE;
}

Status DeLQueue(LQueue *L)
{
    if(L->len == 0) return FLASE;
    else{
        L->front = L->front->next;//移动
        L->len--;
        return TRUE;
    }
}

Status GetHeadLQueue(LQueue *L,Node *Node1,void *e)
{
    if(L->len==0) return FLASE;
    else
    {
        void *target = L->front->data + Node1->data_size;
        memcpy(e,target,Node1->data_size);
        printf(" 操作成功 数据为：\n");
        if(L->flag == 0) printf("%c\n",   *((char *)e)    );
        else if(L->flag == 1) printf("%d\n", *((int *)e));
        else if(L->flag == 2) printf("%lf\n",*((double *)e));
        free(e);
        return TRUE;
    }
}

void ClearLQueue(LQueue *L)
{
    Node *q;//移动指针
    while(L->front->next)
    {
        q = L->front->next;
        free(L->front->data);
        L->front = q;
        L->len--;
    }
    L->len = 0; //双重保障
}

void DestoryLQueue(LQueue *L)
{
    Node *q;//移动指针
    while(L->front->next)
    {
        q = L->front->next;
        free(L->front->data);
        L->front = q;
        L->len--;
    }
    L->len = -1;
    free(L->front);
    free(L);
}

Status TraverseLQueue(LQueue *L,Node *Node1,void (*foo)(void *q,int))
{
    if(L->len == 0) return FLASE;
    int TLEN = L->len;
    Node *TFRONT = L->front;
    printf("  队列为：\n");
    while(TLEN)
    {
        void *target = (TFRONT->data)+ Node1->data_size;
        foo(target,L->flag);
        TFRONT = TFRONT->next;
        TLEN--;
    }
}

void LPrint(void *q,int flag)
{
    if(flag == 0) printf("%c\n",*((char *)q));
    else if( flag == 1) printf("%d\n",*((int *)q));
    else if( flag == 2) printf("%lf\n",*((double *)q));

}
