#include<cstdio>
#include<stdlib.h>
#include<cstring>
#include<queue.h>
int main()
{
    printf("****************************************************\n");
    printf("  请输入相应队的种类： 1代表数组队列 2代表链表队列\n");
    printf("****************************************************\n");
    int type;
    while(scanf("%d",&type) !=EOF && type != 0)
    {
        char c0 = getchar();
        if(type != 1 && type != 2){
            printf("  请别乱输入 谢谢 请重新输入\n");
            continue;
        }
        if(c0!='\n'){
            printf("  请别乱输入 谢谢 请重新输入\n");
            continue;
        }
        if(type == 1){//链式栈
                printf("**************************************\n");
                printf("  下面都是数组队列操作\n");
                printf("  你输入要存储数据的类型 0代表字符 1代表整形 2代表浮点型 \n");
                int Mainflag;
                scanf("%d",&Mainflag);
                printf(" 输入成功！\n");
                printf("  请输入你要进行的操作 \n");
                printf("  1：初始化队列 2：判断队列是否为空  3: 判断队列是为否满 4：得到队列的队列头 \n");
                printf("  5：清空队列  6:销毁队列 7：得到队列的长度 8：Push 9：Pop 10:是输出队列  0为退出 \n");
                int number ;
                char c1;
                AQueue *Q = (AQueue *)malloc(sizeof(AQueue));
                Q->len = -1;
                Q->flag = Mainflag;//确定类型
                if(Q->flag == 0) Q->data_size = sizeof(char);
                else if( Q->flag == 1) Q->data_size = sizeof(int);
                else if(Q->flag == 2) Q->data_size = sizeof(double);//确定类型长度！
                while(scanf("%d",&number)!= EOF && number !=0)
                {
                    c1 = getchar();
                    if(c1 != '\n' || (number >10 || number < 0)){
                        printf("  请别乱输入 谢谢！\n");
                        printf("  请重新输入操作代号！\n");
                        continue;
                    }
                    switch(number)
                    {
                        case 1: {
                            if(Q->len != -1 ) {
                                printf("  之前已经有队列 为了不浪费空间 请先销毁队列谢谢！\n");
                                break;
                            }
                            InitAQueue(Q);
                            printf("  初始化队列成功！\n");
                            break;
                        }
                        case 2 : {
                             if(Q->len == -1){
                                printf("  队列已经被销毁或者未被初始化 请检查！\n");
                                break;
                             }
                             int resultIsemptyAQueue = IsemptyAQueue(Q);
                             if(!resultIsemptyAQueue) printf(" 是空队列\n");
                             else printf("  不是空队列!\n");
                             break;
                        }
                        case 3 : {
                            if(Q->len == -1){
                                printf("  队列已经被销毁或者未被初始化 请检查！\n");
                                break;
                             }
                             int resultIsFullAQueue = IsFullAQueue(Q);
                             if(!resultIsFullAQueue ) printf(" 是满队列\n");
                             else printf("  还没满!\n");
                             break;
                        }
                       case 4 : {
                           if(Q->len == -1){
                                printf("  队列已经被销毁或者未被初始化 请检查！\n");
                                break;
                             }
                             void *e = malloc(Q->data_size);
                             int resultGetHeadAQueue = GetHeadAQueue(Q,e);
                             if(!resultGetHeadAQueue) printf(" 操作失败!\n");
                             break;
                       }
                       case 5 : {
                           if(Q->len == -1){
                                printf("  队列已经被销毁或者未被初始化 请检查！\n");
                                break;
                             }
                             ClearAQueue(Q);
                             printf("  清除成功！\n");
                             break;
                       }
                       case 6 : {
                           if(Q->len == -1){
                                printf("  队列已经被销毁或者未被初始化 请检查！\n");
                                break;
                             }
                             DestoryAQueue(Q);
                             printf(" 销毁成功！\n");
                             break;
                       }
                       case 7 : {
                            if(Q->len == -1){
                                printf("  队列已经被销毁或者未被初始化 请检查！\n");
                                break;
                             }
                             printf("  队列长度为%d\n",Q->len);
                             break;
                       }
                       case 8 : {
                           if(Q->len == -1){
                                printf("  队列已经被销毁或者未被初始化 请检查！\n");
                                break;
                             }
                            void *dataPtr;
                            printf(" 请输入你想入队的数据！\n");
                            if(Mainflag == 0) {
                                char data;
                                scanf("%c",&data);
                                dataPtr = &data;
                            }
                            else if(Mainflag == 1) {
                                int data;
                                scanf("%d",&data);
                                dataPtr = &data;
                            }
                            else if(Mainflag == 2) {
                                double data;
                                scanf("%lf",&data);
                                dataPtr = &data;
                            }
                            int resultEnAQueue = EnAQueue(Q,dataPtr);
                            if(resultEnAQueue==0) printf("  入队失败！\n");
                            else printf(" 插入成功！\n");
                            break;
                       }
                       case 9 : {
                           if(Q->len == -1){
                                printf("  队列已经被销毁或者未被初始化 请检查！\n");
                                break;
                             }
                             int resultDeAQueue = DeAQueue(Q);
                             if(resultDeAQueue) printf(" 出队成功！\n");
                             else printf("  出队失败!\n");
                             break;
                       }
                      case 10 : {
                          if(Q->len == -1){
                                printf("  队列已经被销毁或者未被初始化 请检查！\n");
                                break;
                             }
                           void (*foo)(void *q,int);
                           foo = APrint;
                           int resultTraverseAQueue = TraverseAQueue(Q,foo);
                           if(!resultTraverseAQueue) printf(" 操作失败！\n");
                           break;
                          }

                    }
                 }
        }
        if(type == 2){
                printf("**************************************\n");
                printf("  下面都是链式队列操作\n");
                printf("  你输入要存储数据的类型 0代表字符 1代表整形 2代表浮点型 \n");
                int Mainflag;
                scanf("%d",&Mainflag);
                printf(" 输入成功！\n");
                printf("  请输入你要进行的操作 \n");
                printf("  1：初始化队列 2：判断队列是否为空   3：得到队列的队列头 \n");
                printf("  4：清空队列  5:销毁队列 6：得到队列的长度 7：Push 8：Pop 9: 输出队列  0为退出 \n");
                int number ;
                char c1;
                LQueue *L = (LQueue *)malloc(sizeof(LQueue));
                Node *Node1 = (Node *)malloc(sizeof(Node));
                L->len = -1;
                L->flag = Mainflag;
                if(L->flag == 0) Node1->data_size = sizeof(char);
                else if( L->flag == 1) Node1->data_size = sizeof(int);
                else if(L->flag == 2) Node1->data_size = sizeof(double);

                L->data_size = sizeof(Node1->next)*2;//L的数据域就两个指针大小
                while(scanf("%d",&number)!= EOF && number !=0)
                {
                    c1 = getchar();
                    if(c1 != '\n' || (number >9 || number < 0)){
                        printf("  请别乱输入 谢谢！\n");
                        printf("  请重新输入操作代号！\n");
                        continue;
                    }
                    switch(number)
                    {
                        case 1 : {
                           if(L->len != -1 ) {
                                printf("  之前已经有队列 为了不浪费空间 请先销毁队列谢谢！\n");
                                break;
                            }
                            InitLQueue(L);
                            printf(" 操作成功!\n");
                            break;
                        }
                        case 2 : {
                            if(L->len == -1){
                                printf("  队列已经被销毁或者未被初始化 请检查！\n");
                                break;
                             }
                             int resultIsemptyLQueue = IsemptyLQueue(L);
                             if(!resultIsemptyLQueue) printf(" 是空队列\n");
                             else printf("  不是空队列!\n");
                             break;
                        }
                        case 3 : {
                            if(L->len == -1){
                                printf("  队列已经被销毁或者未被初始化 请检查！\n");
                                break;
                            }
                                void *e = malloc(Node1->data_size);
                                int resultGetHeadLQueue = GetHeadLQueue(L,Node1,e);
                                if(!resultGetHeadLQueue) printf(" 操作失败!\n");
                                break;
                        }
                        case 4 : {
                             if(L->len == -1){
                                printf("  队列已经被销毁或者未被初始化 请检查！\n");
                                break;
                            }
                            ClearLQueue(L);
                            printf(" 清除成功！\n");
                            break;

                        }
                       case 5 : {
                           if(L->len == -1){
                                printf("  队列已经被销毁或者未被初始化 请检查！\n");
                                break;
                            }
                            DestoryLQueue(L);
                            printf("  销毁成功! \n");
                            break;
                       }
                       case 6 : {
                           if(L->len == -1){
                                printf("  队列已经被销毁或者未被初始化 请检查！\n");
                                break;
                            }
                            printf(" 队列长度为 %d\n",L->len);
                            break;
                        }
                       case 7 : {
                            if(L->len == -1){
                                printf("  队列已经被销毁或者未被初始化 请检查！\n");
                                break;
                             }
                             void *dataPtr;
                            printf(" 请输入你想入队的数据！\n");
                            if(Mainflag == 0) {
                                char data;
                                scanf("%c",&data);
                                dataPtr = &data;
                            }
                            else if(Mainflag == 1) {
                                int data;
                                scanf("%d",&data);
                                dataPtr = &data;
                            }
                            else if(Mainflag == 2) {
                                double data;
                                scanf("%lf",&data);
                                dataPtr = &data;
                            }
                            int resultEnLQueue = EnLQueue(L,Node1,dataPtr);
                            if(resultEnLQueue==0) printf("  入队失败！\n");
                            else printf(" 插入成功！\n");
                            break;
                        }
                        case 8 : {
                            if(L->len == -1){
                                printf("  队列已经被销毁或者未被初始化 请检查！\n");
                                break;
                             }
                             int resultDeLQueue = DeLQueue(L);
                             if(resultDeLQueue) printf(" 出队成功！\n");
                             else printf("  出队失败!\n");
                             break;
                        }
                        case 9 : {
                            if(L->len == -1){
                                printf("  队列已经被销毁或者未被初始化 请检查！\n");
                                break;
                             }
                             void (*foo)(void *q,int) = LPrint;
                             int resultTraverseLQueue = TraverseLQueue(L,Node1,foo);
                             if(!resultTraverseLQueue) printf("  操作失败！\n");
                             break;
                        }
                    }
                }
        }
        printf(" 如果要继续 请输入1或者2 否则输入0退出\n");
     }
     return 0;
}
