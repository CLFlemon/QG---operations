#include<stdio.h>
#include<stack1.h>
const int maxn = 1000;
int main()
{
    printf("***************************************************************\n");
    printf("请输入你要计算的式子 请注意请在英语输入法下输入式子 否则会报错！\n");
     printf("***************************************************************\n");
    char strnumber[maxn];//中缀数组
    LinkStackPtr S1 = InitLStack();//初始化栈
    scanf("%s",strnumber);//输入字符串
    char *str = strnumber;//指针
    char newstrnumber[maxn];//后缀数组
    while(*(str)!='\0')
    {
        if( (0>*(str) || *(str)>'9') &&  *(str) != '(' && *(str) != ')' && *(str) != '+' && *(str) != '-' && *(str) != '*' && *(str) != '/' )
        {
            printf("检测到你输入有问题 请你重新检查并启动程序谢谢!\n");
            return 0;
        }
        str++;
    }//检测是否有其他错误输入
    str = strnumber;//回归原位

    int len = 0;
    while(*(str) != '\0')
    {
        if('0'<=*(str) && '9'>= *(str)){
            newstrnumber[len++] = *(str);
        }//数字
        else if(*(str) == '(') PushLStack(S1,*(str));//进数组
        else if(*(str)== '+' || *(str) == '-')//最低优先级
        {
            while(1)
            {
                ElemType Tdata = 0;
                ElemType *TdataPtr = &Tdata;
                int TopLS1 = GetTopLStack(S1,TdataPtr);
                if(TopLS1 == 0 || Tdata == '(') {
                    PushLStack(S1,*(str));
                    break;
                }//当Top出来为空或者（时 进栈
                else {
                    ElemType Pdata = 0;
                    ElemType *PdataPtr = &Pdata;
                    PopLStack(S1,PdataPtr);
                    newstrnumber[len++] = Pdata;//Pop出来然后进栈 然后继续循环 直接break出去为止
                }
            }
        }
        else if(*(str) == '*' || *(str) == '/')
        {
              while(1)
              {
                    ElemType Tdata = 0;
                    ElemType *TdataPtr = &Tdata;
                    int TopLS1 = GetTopLStack(S1,TdataPtr);
                    if(TopLS1 == 0 || Tdata == '(' || Tdata == '+' || Tdata == '-') {
                        PushLStack(S1,*(str));
                        break;
                    }//低于乘除的优先级
                    else {
                        ElemType Pdata = 0;
                        ElemType *PdataPtr = &Pdata;
                        PopLStack(S1,PdataPtr);
                        newstrnumber[len++] = Pdata;
                    }//同上
              }
        }
        else if( *(str) == ')')
        {
            while(1)
            {
                ElemType Pdata = 0;
                ElemType *PdataPtr = &Pdata;
                PopLStack(S1,PdataPtr);
                if(Pdata == '(') break;//直到有一个（出来匹配 否则一直Pop
                else {
                    newstrnumber[len++] = Pdata;
                }
            }
        }
        str++;//指针移动
    }

    while(isEmptyLStack(S1) == 1)//挤压栈 知道空栈为止
    {
         ElemType Pdata = 0;
         ElemType *PdataPtr = &Pdata;
         PopLStack(S1,PdataPtr);
         newstrnumber[len++] = Pdata;
    }
//下面开始进行后缀数组计算

    char *newstr1= newstrnumber;//指针
    while(*(newstr1) != '\0')
    {
        if('0'<=*(newstr1) && '9'>= *(newstr1)){
            PushLStack(S1,*(newstr1)-48);//因为是字符串 所以要-48 进栈
        }
        else
        {
                 if(isEmptyLStack(S1) == 0){
                    printf(" 你当初式子有误 请你重新检查输入并重新启动程序!\n");
                    return 0;
                  }
                  ElemType Pdata1 = 0;
                  ElemType *PdataPtr1 = &Pdata1;
                  PopLStack(S1,PdataPtr1);

                  if(isEmptyLStack(S1) == 0){
                    printf(" 你当初式子有误 请你重新检查输入并重新启动程序!\n");
                    return 0;
                  }//两个if都是检查当初输入是否有误
                  ElemType Pdata2 = 0;
                  ElemType *PdataPtr2 = &Pdata2;
                  PopLStack(S1,PdataPtr2);
                   //pOP出来两个数字进行运算
            switch(*(newstr1))
            {
                case '+' : {
                  PushLStack(S1,Pdata1+Pdata2);
                  break;
                }
                case '-' : {
                    PushLStack(S1,Pdata2-Pdata1);
                    break;
                  }
                case '*' : {
                    PushLStack(S1,Pdata2*Pdata1);
                    break;
                }
                case '/' : {
                     PushLStack(S1,Pdata2/Pdata1);
                }
            }
        }
        newstr1++;
    }
    ElemType  Last;
    ElemType *LastPtr = &Last;
    int Useless = PopLStack(S1,LastPtr);//只为得到pop值 结果并没有用
    printf("%d\n",Last);
    getchar();
    return 0;
}
