#include<stdio.h>
#include<stack.h>
#include<stdlib.h>

int main()
{
    printf("***********************************************\n");
    printf("  ��ѡ����Ӧջ�����ࣺ1������ʽջ 2��������ջ\n");
    printf("***********************************************\n");
    int type;
    while(scanf("%d",&type)!=EOF && type != 0)
    {
        char c0 = getchar();
        if(type!=1 && type != 2){
            printf("  ��������� лл��\n");
            printf("  ��������������\n");
            continue;
        }
        if(c0!='\n') {
          printf("  ��������� лл��\n");
          printf("  ��������������\n");
          continue;
        }
        if(type == 1 ){//��ʽջ
            printf("***********************************************\n");
            printf("  �����Ϊ��ʽջ������\n");
            printf("  ��������Ҫ���еĲ��� \n");
            printf("  1: ��ʼ��ջ 2���ж�ջ�Ƿ�Ϊ�� 3���õ�ջ��TOP��ֵ 4: ���ջ \n");
            printf("  5: ����ջ 6���õ�ջ�ĳ��� 7��Push 8��Pop  0Ϊ�˳�����\n");
            printf("***********************************************\n");
            int number;
            char c1;
            LinkStackPtr head = NULL ;//ͷָ��
            int count = -1;//���㳤����ջ������ʱ��ֵΪ-1
            while( scanf("%d",&number)!= EOF && number != 0 )
            {
                c1 =getchar();
                if(c1!='\n' || (number>8 || number<0)){
                   printf("  ��������� лл��\n");
                   printf("  ����������������ţ�\n");
                   continue;
                }
                switch(number)
                {
                    case 1 :{
                        if(count != -1){
                            printf(" ֮ǰ�Ѿ���ջ Ϊ�˲��˷ѿռ� ��������ջлл��\n");
                            break;
                        }
                        head = InitLStack();
                        printf("  ��ʼ������ɹ���\n");
                        count = 0;
                        break;
                    }
                    case 2 :{
                        if(count == -1){
                            printf(" ջ�Ѿ������ٻ���δ����ʼ�� ���飡\n");
                            break;
                        }
                        int ResultisEmptyLStack = isEmptyLStack(head);
                        if(ResultisEmptyLStack == 0) printf(" �ǿ�ջ��\n");
                        else printf(" ���ǿ�ջ��\n");
                        break;
                    }
                    case 3 :{
                        if(count == -1){
                            printf(" ջ�Ѿ������ٻ���δ����ʼ�� ���飡\n");
                            break;
                        }
                        int top;
                        ElemType *TopPtr = &top;
                        int ResultGetTopLStack = GetTopLStack(head,TopPtr);
                        if(ResultGetTopLStack == 1) printf("  �����ɹ� ջ����ֵ = %d \n",*(TopPtr));
                        else printf("  ����ʧ�� �����Ƿ��ջ\n");
                        break;
                    }
                    case 4 :{
                        if(count == -1){
                            printf(" ջ�Ѿ������ٻ���δ����ʼ�� ���飡\n");
                            break;
                        }
                        int ResultClearLStack =  clearLStack(head);
                        if(ResultClearLStack == 1) printf("  �����ɹ� ջ�����\n");
                        else printf("  ����ʧ�� ����ջ�Ƿ�����\n");
                        count = 0;
                        break;
                    }
                    case 5 :{
                        if(count == -1){
                            printf(" ջ�Ѿ������ٻ���δ����ʼ�� ���飡\n");
                            break;
                        }
                       int ResultDestoryLStack = destoryLStack(head);
                       if(ResultDestoryLStack==1) printf("  �����ɹ� ջ���Ѿ�����\n");
                       else printf("  ����ʧ�� ����ջ֮ǰ�Ƿ�����\n");
                       count = -1;
                       break;
                    }
                    case 6 :{
                       printf("  ջ�ĳ���Ϊ %d  ��ջ����Ϊ-1 ֤��ջ�����ٻ���δ����ʼ����\n",count);
                       break;
                    }
                    case 7 :{
                        if(count == -1){
                            printf(" ջ�Ѿ������ٻ���δ����ʼ�� ���飡\n");
                            break;
                        }
                       printf("  ����������push��ȥ�����ݣ�\n");
                       ElemType datas;
                       scanf("%d",&datas);
                       int ResultPushLStack = PushLStack(head,datas);
                       if(ResultPushLStack==1) { printf("  �����ɹ���\n");count++;}
                       else printf("  ����ʧ�� �����Ƿ�ݻ���ջ��δ����ʼ��\n");

                       break;
                    }
                    case 8 :{
                        if(count == -1){
                            printf(" ջ�Ѿ������ٻ���δ����ʼ�� ���飡\n");
                            break;
                        }
                        int data;
                        ElemType *dataPtr = &data;
                        int ResultPopLStack = PopLStack(head,dataPtr);
                        if(ResultPopLStack==1)  { printf("  �����ɹ��� pop������������ %d \n",*(dataPtr)); count--;}
                        else printf("  ����ʧ�� �����Ƿ�ݻ���ջ��δ����ʼ��\n");
                        break;
                   }
                }
            }
        }

        if(type == 2){
            printf("***********************************************\n");
            printf("  �����Ϊ������ʽջ������\n");
            printf("  ��������Ҫ���еĲ��� \n");
            printf("  1: ��ʼ��ջ 2���ж�ջ�Ƿ�Ϊ�� 3���õ�ջ��TOP��ֵ 4: ���ջ \n");
            printf("  5: ����ջ 6���õ�ջ�ĳ��� 7��Push 8��Pop  0Ϊ�˳�����\n");
            printf("***********************************************\n");
            int number;
            char c1;
            SqStack *s =(SqStack *)malloc(sizeof(struct SqStack));//��ʼ��s
            int count = -1;
            while(scanf("%d",&number) != EOF && number != 0)
            {
                c1 =getchar();
                if(c1!='\n' || (number>8 || number<0)){
                   printf("  ��������� лл��\n");
                   printf("  ����������������ţ�\n");
                   continue;
                }
                switch(number)
                {
                    case 1 : {
                        if(count != -1){
                            printf(" ֮ǰ�Ѿ���ջ Ϊ�˲��˷ѿռ� ��������ջлл��\n");
                            break;
                        }
                        printf("  ������ջ�ռ�����ֵ �������²���ע�ⲻҪ����ջ�����ռ�\n");
                        ElemType sizes;
                        scanf("%d",&sizes);
                        int ResultInitStack = initStack(s,sizes);
                        if(ResultInitStack) printf("  ��ʼ���ɹ���\n");
                        else printf(" ��ʼ�����ɹ� ���飡\n");
                        count = 0;
                        break;
                     }
                    case 2 : {
                         if(count == -1){
                            printf(" ջ�Ѿ������ٻ���δ����ʼ�� ���飡\n");
                            break;
                        }
                       int ResultisEmptyStack = isEmptyStack(s);
                       if(ResultisEmptyStack) printf(" ���ǿ�ջ��\n");
                       else printf(" ��ջ��\n");
                       break;
                     }
                    case 3 : {
                        if(count == -1){
                            printf(" ջ�Ѿ������ٻ���δ����ʼ�� ���飡\n");
                            break;
                        }
                        int top;
                        ElemType *TopPtr = &top;
                        int ResultGetTopStack = GetTopStack(s,TopPtr);
                        if(ResultGetTopStack == 1) printf("  �����ɹ� ջ����ֵ = %d \n",*(TopPtr));
                        else printf("  ����ʧ�� �����Ƿ��ջ\n");
                        break;
                    }
                    case 4 : {
                      if(count == -1){
                            printf(" ջ�Ѿ������ٻ���δ����ʼ�� ���飡\n");
                            break;
                        }
                        int ResultClearStack =  clearStack(s);
                        if(ResultClearStack == 1) printf("  �����ɹ� ջ�����\n");
                        else printf("  ����ʧ�� ����ջ�Ƿ�����\n");
                        count = 0;
                        break;
                    }
                    case 5 : {
                        if(count == -1){
                            printf(" ջ�Ѿ������ٻ���δ����ʼ�� ���飡\n");
                            break;
                        }
                       int ResultDestoryStack = destoryStack(s);
                       if(ResultDestoryStack==1) printf("  �����ɹ� ջ���Ѿ�����\n");
                       else printf("  ����ʧ�� ����ջ֮ǰ�Ƿ�����\n");
                       count = -1;
                       break;
                    }
                    case 6 : {
                       printf("  ջ�ĳ���Ϊ %d  ��ջ����Ϊ-1 ֤��ջ�����ٻ���δ����ʼ����\n",count);
                       break;
                    }
                    case 7 : {
                         if(count == -1){
                            printf(" ջ�Ѿ������ٻ���δ����ʼ�� ���飡\n");
                            break;
                        }
                        printf("  ����������push��ȥ�����ݣ�\n");
                        ElemType datas;
                        scanf("%d",&datas);
                        int ResultPushStack = PushStack(s,datas);
                        if(ResultPushStack==1){  printf("  �����ɹ���\n");   count++;}
                        else printf("  ����ʧ�� �����Ƿ�ݻ���ջ��δ����ʼ��\n");
                        break;
                     }
                    case 8 : {
                          if(count == -1){
                            printf(" ջ�Ѿ������ٻ���δ����ʼ�� ���飡\n");
                            break;
                        }
                        int data;
                        ElemType *dataPtr = &data;
                        int ResultPopStack = PopStack(s,dataPtr);
                        if(ResultPopStack==1) { printf("  �����ɹ��� pop������������ %d \n",*(dataPtr)); count--;}
                        else printf("  ����ʧ�� �����Ƿ�ݻ���ջ��δ����ʼ��\n");
                        break;
                     }
                }
            }


        }
        printf(" ��Ҫ�������� �ظ� �������0\n");
    }
    return 0;
}
