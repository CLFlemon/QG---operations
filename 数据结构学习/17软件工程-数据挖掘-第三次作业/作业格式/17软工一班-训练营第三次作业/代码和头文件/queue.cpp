#include<cstdio>
#include<stdlib.h>
#include<cstring>
#include<queue.h>
int main()
{
    printf("****************************************************\n");
    printf("  ��������Ӧ�ӵ����ࣺ 1����������� 2�����������\n");
    printf("****************************************************\n");
    int type;
    while(scanf("%d",&type) !=EOF && type != 0)
    {
        char c0 = getchar();
        if(type != 1 && type != 2){
            printf("  ��������� лл ����������\n");
            continue;
        }
        if(c0!='\n'){
            printf("  ��������� лл ����������\n");
            continue;
        }
        if(type == 1){//��ʽջ
                printf("**************************************\n");
                printf("  ���涼��������в���\n");
                printf("  ������Ҫ�洢���ݵ����� 0�����ַ� 1�������� 2�������� \n");
                int Mainflag;
                scanf("%d",&Mainflag);
                printf(" ����ɹ���\n");
                printf("  ��������Ҫ���еĲ��� \n");
                printf("  1����ʼ������ 2���ж϶����Ƿ�Ϊ��  3: �ж϶�����Ϊ���� 4���õ����еĶ���ͷ \n");
                printf("  5����ն���  6:���ٶ��� 7���õ����еĳ��� 8��Push 9��Pop 10:���������  0Ϊ�˳� \n");
                int number ;
                char c1;
                AQueue *Q = (AQueue *)malloc(sizeof(AQueue));
                Q->len = -1;
                Q->flag = Mainflag;//ȷ������
                if(Q->flag == 0) Q->data_size = sizeof(char);
                else if( Q->flag == 1) Q->data_size = sizeof(int);
                else if(Q->flag == 2) Q->data_size = sizeof(double);//ȷ�����ͳ��ȣ�
                while(scanf("%d",&number)!= EOF && number !=0)
                {
                    c1 = getchar();
                    if(c1 != '\n' || (number >10 || number < 0)){
                        printf("  ��������� лл��\n");
                        printf("  ����������������ţ�\n");
                        continue;
                    }
                    switch(number)
                    {
                        case 1: {
                            if(Q->len != -1 ) {
                                printf("  ֮ǰ�Ѿ��ж��� Ϊ�˲��˷ѿռ� �������ٶ���лл��\n");
                                break;
                            }
                            InitAQueue(Q);
                            printf("  ��ʼ�����гɹ���\n");
                            break;
                        }
                        case 2 : {
                             if(Q->len == -1){
                                printf("  �����Ѿ������ٻ���δ����ʼ�� ���飡\n");
                                break;
                             }
                             int resultIsemptyAQueue = IsemptyAQueue(Q);
                             if(!resultIsemptyAQueue) printf(" �ǿն���\n");
                             else printf("  ���ǿն���!\n");
                             break;
                        }
                        case 3 : {
                            if(Q->len == -1){
                                printf("  �����Ѿ������ٻ���δ����ʼ�� ���飡\n");
                                break;
                             }
                             int resultIsFullAQueue = IsFullAQueue(Q);
                             if(!resultIsFullAQueue ) printf(" ��������\n");
                             else printf("  ��û��!\n");
                             break;
                        }
                       case 4 : {
                           if(Q->len == -1){
                                printf("  �����Ѿ������ٻ���δ����ʼ�� ���飡\n");
                                break;
                             }
                             void *e = malloc(Q->data_size);
                             int resultGetHeadAQueue = GetHeadAQueue(Q,e);
                             if(!resultGetHeadAQueue) printf(" ����ʧ��!\n");
                             break;
                       }
                       case 5 : {
                           if(Q->len == -1){
                                printf("  �����Ѿ������ٻ���δ����ʼ�� ���飡\n");
                                break;
                             }
                             ClearAQueue(Q);
                             printf("  ����ɹ���\n");
                             break;
                       }
                       case 6 : {
                           if(Q->len == -1){
                                printf("  �����Ѿ������ٻ���δ����ʼ�� ���飡\n");
                                break;
                             }
                             DestoryAQueue(Q);
                             printf(" ���ٳɹ���\n");
                             break;
                       }
                       case 7 : {
                            if(Q->len == -1){
                                printf("  �����Ѿ������ٻ���δ����ʼ�� ���飡\n");
                                break;
                             }
                             printf("  ���г���Ϊ%d\n",Q->len);
                             break;
                       }
                       case 8 : {
                           if(Q->len == -1){
                                printf("  �����Ѿ������ٻ���δ����ʼ�� ���飡\n");
                                break;
                             }
                            void *dataPtr;
                            printf(" ������������ӵ����ݣ�\n");
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
                            if(resultEnAQueue==0) printf("  ���ʧ�ܣ�\n");
                            else printf(" ����ɹ���\n");
                            break;
                       }
                       case 9 : {
                           if(Q->len == -1){
                                printf("  �����Ѿ������ٻ���δ����ʼ�� ���飡\n");
                                break;
                             }
                             int resultDeAQueue = DeAQueue(Q);
                             if(resultDeAQueue) printf(" ���ӳɹ���\n");
                             else printf("  ����ʧ��!\n");
                             break;
                       }
                      case 10 : {
                          if(Q->len == -1){
                                printf("  �����Ѿ������ٻ���δ����ʼ�� ���飡\n");
                                break;
                             }
                           void (*foo)(void *q,int);
                           foo = APrint;
                           int resultTraverseAQueue = TraverseAQueue(Q,foo);
                           if(!resultTraverseAQueue) printf(" ����ʧ�ܣ�\n");
                           break;
                          }

                    }
                 }
        }
        if(type == 2){
                printf("**************************************\n");
                printf("  ���涼����ʽ���в���\n");
                printf("  ������Ҫ�洢���ݵ����� 0�����ַ� 1�������� 2�������� \n");
                int Mainflag;
                scanf("%d",&Mainflag);
                printf(" ����ɹ���\n");
                printf("  ��������Ҫ���еĲ��� \n");
                printf("  1����ʼ������ 2���ж϶����Ƿ�Ϊ��   3���õ����еĶ���ͷ \n");
                printf("  4����ն���  5:���ٶ��� 6���õ����еĳ��� 7��Push 8��Pop 9: �������  0Ϊ�˳� \n");
                int number ;
                char c1;
                LQueue *L = (LQueue *)malloc(sizeof(LQueue));
                Node *Node1 = (Node *)malloc(sizeof(Node));
                L->len = -1;
                L->flag = Mainflag;
                if(L->flag == 0) Node1->data_size = sizeof(char);
                else if( L->flag == 1) Node1->data_size = sizeof(int);
                else if(L->flag == 2) Node1->data_size = sizeof(double);

                L->data_size = sizeof(Node1->next)*2;//L�������������ָ���С
                while(scanf("%d",&number)!= EOF && number !=0)
                {
                    c1 = getchar();
                    if(c1 != '\n' || (number >9 || number < 0)){
                        printf("  ��������� лл��\n");
                        printf("  ����������������ţ�\n");
                        continue;
                    }
                    switch(number)
                    {
                        case 1 : {
                           if(L->len != -1 ) {
                                printf("  ֮ǰ�Ѿ��ж��� Ϊ�˲��˷ѿռ� �������ٶ���лл��\n");
                                break;
                            }
                            InitLQueue(L);
                            printf(" �����ɹ�!\n");
                            break;
                        }
                        case 2 : {
                            if(L->len == -1){
                                printf("  �����Ѿ������ٻ���δ����ʼ�� ���飡\n");
                                break;
                             }
                             int resultIsemptyLQueue = IsemptyLQueue(L);
                             if(!resultIsemptyLQueue) printf(" �ǿն���\n");
                             else printf("  ���ǿն���!\n");
                             break;
                        }
                        case 3 : {
                            if(L->len == -1){
                                printf("  �����Ѿ������ٻ���δ����ʼ�� ���飡\n");
                                break;
                            }
                                void *e = malloc(Node1->data_size);
                                int resultGetHeadLQueue = GetHeadLQueue(L,Node1,e);
                                if(!resultGetHeadLQueue) printf(" ����ʧ��!\n");
                                break;
                        }
                        case 4 : {
                             if(L->len == -1){
                                printf("  �����Ѿ������ٻ���δ����ʼ�� ���飡\n");
                                break;
                            }
                            ClearLQueue(L);
                            printf(" ����ɹ���\n");
                            break;

                        }
                       case 5 : {
                           if(L->len == -1){
                                printf("  �����Ѿ������ٻ���δ����ʼ�� ���飡\n");
                                break;
                            }
                            DestoryLQueue(L);
                            printf("  ���ٳɹ�! \n");
                            break;
                       }
                       case 6 : {
                           if(L->len == -1){
                                printf("  �����Ѿ������ٻ���δ����ʼ�� ���飡\n");
                                break;
                            }
                            printf(" ���г���Ϊ %d\n",L->len);
                            break;
                        }
                       case 7 : {
                            if(L->len == -1){
                                printf("  �����Ѿ������ٻ���δ����ʼ�� ���飡\n");
                                break;
                             }
                             void *dataPtr;
                            printf(" ������������ӵ����ݣ�\n");
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
                            if(resultEnLQueue==0) printf("  ���ʧ�ܣ�\n");
                            else printf(" ����ɹ���\n");
                            break;
                        }
                        case 8 : {
                            if(L->len == -1){
                                printf("  �����Ѿ������ٻ���δ����ʼ�� ���飡\n");
                                break;
                             }
                             int resultDeLQueue = DeLQueue(L);
                             if(resultDeLQueue) printf(" ���ӳɹ���\n");
                             else printf("  ����ʧ��!\n");
                             break;
                        }
                        case 9 : {
                            if(L->len == -1){
                                printf("  �����Ѿ������ٻ���δ����ʼ�� ���飡\n");
                                break;
                             }
                             void (*foo)(void *q,int) = LPrint;
                             int resultTraverseLQueue = TraverseLQueue(L,Node1,foo);
                             if(!resultTraverseLQueue) printf("  ����ʧ�ܣ�\n");
                             break;
                        }
                    }
                }
        }
        printf(" ���Ҫ���� ������1����2 ��������0�˳�\n");
     }
     return 0;
}
