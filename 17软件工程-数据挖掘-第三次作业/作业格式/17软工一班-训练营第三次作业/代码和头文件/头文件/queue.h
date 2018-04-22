#ifndef QUEUE_H_INCLUDED
#define QUEUE_H_INCLUDED

const int maxn = 100;
//数组

typedef struct Aqueue
{
    void *data;//void 指针
    int front;//队列头
    int rear;//队列
    int len;//尾
    size_t data_size;//数据大小
    int flag;//表明你的数据是哪一个类型 0是char 1是int 2是double
}AQueue;

//链表
typedef struct node
{
    void *data;
    struct node *next;
    size_t data_size;
}Node;

typedef struct Lqueue
{
    Node *front;
    Node *rear;
    size_t data_size;
    int len;
    int flag;
}LQueue;

typedef enum
{
    FLASE = 0,TRUE = 1,
}Status;

void InitAQueue(AQueue *Q);
void InitLQueue(LQueue *Q);

void DestoryAQueue(AQueue *Q);
void DestoryLQueue(LQueue *Q);

Status IsFullAQueue(AQueue *Q);
Status IsemptyAQueue(AQueue *Q);

Status IsemptyLQueue(LQueue *Q);

Status GetHeadAQueue(AQueue *Q,void *e);
Status GetHeadLQueue(LQueue *Q,Node *,void *e);

Status EnAQueue(AQueue *Q,void *data);
Status EnLQueue(LQueue *Q,Node *,void *data);

Status DeAQueue(AQueue *Q);
Status DeLQueue(LQueue *Q);

void ClearAQueue(AQueue *Q);
void ClearLQueue(LQueue *Q);

Status TraverseAQueue(AQueue *Q,void (*foo)(void *q,int));
Status TraverseLQueue(LQueue *Q,Node *,void (*foo)(void *q,int));

void APrint(void *q,int flag);
void LPrint(void *q,int flag);

#endif // QUEUE_H_INCLUDED
