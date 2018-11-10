#include<stdio.h>
#include<stack.h>
#include<stdlib.h>

int main()
{
    printf("***********************************************\n");
    printf("  请选择相应栈的种类：1代表链式栈 2代表数组栈\n");
    printf("***********************************************\n");
    int type;
    while(scanf("%d",&type)!=EOF && type != 0)
    {
        char c0 = getchar();
        if(type!=1 && type != 2){
            printf("  请别乱输入 谢谢！\n");
            printf("  请重新启动程序！\n");
            continue;
        }
        if(c0!='\n') {
          printf("  请别乱输入 谢谢！\n");
          printf("  请重新启动程序！\n");
          continue;
        }
        if(type == 1 ){//链式栈
            printf("***********************************************\n");
            printf("  下面均为链式栈操作！\n");
            printf("  请输入你要进行的操作 \n");
            printf("  1: 初始化栈 2：判断栈是否为空 3：得到栈的TOP数值 4: 清空栈 \n");
            printf("  5: 销毁栈 6：得到栈的长度 7：Push 8：Pop  0为退出操作\n");
            printf("***********************************************\n");
            int number;
            char c1;
            LinkStackPtr head = NULL ;//头指针
            int count = -1;//计算长度且栈被销毁时候赋值为-1
            while( scanf("%d",&number)!= EOF && number != 0 )
            {
                c1 =getchar();
                if(c1!='\n' || (number>8 || number<0)){
                   printf("  请别乱输入 谢谢！\n");
                   printf("  请重新输入操作代号！\n");
                   continue;
                }
                switch(number)
                {
                    case 1 :{
                        if(count != -1){
                            printf(" 之前已经有栈 为了不浪费空间 请先销毁栈谢谢！\n");
                            break;
                        }
                        head = InitLStack();
                        printf("  初始化链表成功！\n");
                        count = 0;
                        break;
                    }
                    case 2 :{
                        if(count == -1){
                            printf(" 栈已经被销毁或者未被初始化 请检查！\n");
                            break;
                        }
                        int ResultisEmptyLStack = isEmptyLStack(head);
                        if(ResultisEmptyLStack == 0) printf(" 是空栈！\n");
                        else printf(" 不是空栈！\n");
                        break;
                    }
                    case 3 :{
                        if(count == -1){
                            printf(" 栈已经被销毁或者未被初始化 请检查！\n");
                            break;
                        }
                        int top;
                        ElemType *TopPtr = &top;
                        int ResultGetTopLStack = GetTopLStack(head,TopPtr);
                        if(ResultGetTopLStack == 1) printf("  操作成功 栈顶的值 = %d \n",*(TopPtr));
                        else printf("  操作失败 请检查是否空栈\n");
                        break;
                    }
                    case 4 :{
                        if(count == -1){
                            printf(" 栈已经被销毁或者未被初始化 请检查！\n");
                            break;
                        }
                        int ResultClearLStack =  clearLStack(head);
                        if(ResultClearLStack == 1) printf("  操作成功 栈表清空\n");
                        else printf("  操作失败 请检查栈是否被销毁\n");
                        count = 0;
                        break;
                    }
                    case 5 :{
                        if(count == -1){
                            printf(" 栈已经被销毁或者未被初始化 请检查！\n");
                            break;
                        }
                       int ResultDestoryLStack = destoryLStack(head);
                       if(ResultDestoryLStack==1) printf("  操作成功 栈表已经销毁\n");
                       else printf("  操作失败 请检查栈之前是否被销毁\n");
                       count = -1;
                       break;
                    }
                    case 6 :{
                       printf("  栈的长度为 %d  如栈长度为-1 证明栈被销毁或者未被初始化！\n",count);
                       break;
                    }
                    case 7 :{
                        if(count == -1){
                            printf(" 栈已经被销毁或者未被初始化 请检查！\n");
                            break;
                        }
                       printf("  请输入你想push进去的数据：\n");
                       ElemType datas;
                       scanf("%d",&datas);
                       int ResultPushLStack = PushLStack(head,datas);
                       if(ResultPushLStack==1) { printf("  操作成功！\n");count++;}
                       else printf("  操作失败 请检查是否摧毁了栈或未被初始化\n");

                       break;
                    }
                    case 8 :{
                        if(count == -1){
                            printf(" 栈已经被销毁或者未被初始化 请检查！\n");
                            break;
                        }
                        int data;
                        ElemType *dataPtr = &data;
                        int ResultPopLStack = PopLStack(head,dataPtr);
                        if(ResultPopLStack==1)  { printf("  操作成功！ pop出来的数据是 %d \n",*(dataPtr)); count--;}
                        else printf("  操作失败 请检查是否摧毁了栈或未被初始化\n");
                        break;
                   }
                }
            }
        }

        if(type == 2){
            printf("***********************************************\n");
            printf("  下面均为数组链式栈操作！\n");
            printf("  请输入你要进行的操作 \n");
            printf("  1: 初始化栈 2：判断栈是否为空 3：得到栈的TOP数值 4: 清空栈 \n");
            printf("  5: 销毁栈 6：得到栈的长度 7：Push 8：Pop  0为退出操作\n");
            printf("***********************************************\n");
            int number;
            char c1;
            SqStack *s =(SqStack *)malloc(sizeof(struct SqStack));//初始化s
            int count = -1;
            while(scanf("%d",&number) != EOF && number != 0)
            {
                c1 =getchar();
                if(c1!='\n' || (number>8 || number<0)){
                   printf("  请别乱输入 谢谢！\n");
                   printf("  请重新输入操作代号！\n");
                   continue;
                }
                switch(number)
                {
                    case 1 : {
                        if(count != -1){
                            printf(" 之前已经有栈 为了不浪费空间 请先销毁栈谢谢！\n");
                            break;
                        }
                        printf("  请输入栈空间的最大值 并在以下操作注意不要超过栈的最大空间\n");
                        ElemType sizes;
                        scanf("%d",&sizes);
                        int ResultInitStack = initStack(s,sizes);
                        if(ResultInitStack) printf("  初始化成功！\n");
                        else printf(" 初始化不成功 请检查！\n");
                        count = 0;
                        break;
                     }
                    case 2 : {
                         if(count == -1){
                            printf(" 栈已经被销毁或者未被初始化 请检查！\n");
                            break;
                        }
                       int ResultisEmptyStack = isEmptyStack(s);
                       if(ResultisEmptyStack) printf(" 不是空栈！\n");
                       else printf(" 空栈！\n");
                       break;
                     }
                    case 3 : {
                        if(count == -1){
                            printf(" 栈已经被销毁或者未被初始化 请检查！\n");
                            break;
                        }
                        int top;
                        ElemType *TopPtr = &top;
                        int ResultGetTopStack = GetTopStack(s,TopPtr);
                        if(ResultGetTopStack == 1) printf("  操作成功 栈顶的值 = %d \n",*(TopPtr));
                        else printf("  操作失败 请检查是否空栈\n");
                        break;
                    }
                    case 4 : {
                      if(count == -1){
                            printf(" 栈已经被销毁或者未被初始化 请检查！\n");
                            break;
                        }
                        int ResultClearStack =  clearStack(s);
                        if(ResultClearStack == 1) printf("  操作成功 栈表清空\n");
                        else printf("  操作失败 请检查栈是否被销毁\n");
                        count = 0;
                        break;
                    }
                    case 5 : {
                        if(count == -1){
                            printf(" 栈已经被销毁或者未被初始化 请检查！\n");
                            break;
                        }
                       int ResultDestoryStack = destoryStack(s);
                       if(ResultDestoryStack==1) printf("  操作成功 栈表已经销毁\n");
                       else printf("  操作失败 请检查栈之前是否被销毁\n");
                       count = -1;
                       break;
                    }
                    case 6 : {
                       printf("  栈的长度为 %d  如栈长度为-1 证明栈被销毁或者未被初始化！\n",count);
                       break;
                    }
                    case 7 : {
                         if(count == -1){
                            printf(" 栈已经被销毁或者未被初始化 请检查！\n");
                            break;
                        }
                        printf("  请输入你想push进去的数据：\n");
                        ElemType datas;
                        scanf("%d",&datas);
                        int ResultPushStack = PushStack(s,datas);
                        if(ResultPushStack==1){  printf("  操作成功！\n");   count++;}
                        else printf("  操作失败 请检查是否摧毁了栈或未被初始化\n");
                        break;
                     }
                    case 8 : {
                          if(count == -1){
                            printf(" 栈已经被销毁或者未被初始化 请检查！\n");
                            break;
                        }
                        int data;
                        ElemType *dataPtr = &data;
                        int ResultPopStack = PopStack(s,dataPtr);
                        if(ResultPopStack==1) { printf("  操作成功！ pop出来的数据是 %d \n",*(dataPtr)); count--;}
                        else printf("  操作失败 请检查是否摧毁了栈或未被初始化\n");
                        break;
                     }
                }
            }


        }
        printf(" 如要继续操作 重复 或者输出0\n");
    }
    return 0;
}
