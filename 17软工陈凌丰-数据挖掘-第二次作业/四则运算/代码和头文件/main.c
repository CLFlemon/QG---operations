#include<stdio.h>
#include<stack1.h>
const int maxn = 1000;
int main()
{
    printf("***************************************************************\n");
    printf("��������Ҫ�����ʽ�� ��ע������Ӣ�����뷨������ʽ�� ����ᱨ��\n");
     printf("***************************************************************\n");
    char strnumber[maxn];//��׺����
    LinkStackPtr S1 = InitLStack();//��ʼ��ջ
    scanf("%s",strnumber);//�����ַ���
    char *str = strnumber;//ָ��
    char newstrnumber[maxn];//��׺����
    while(*(str)!='\0')
    {
        if( (0>*(str) || *(str)>'9') &&  *(str) != '(' && *(str) != ')' && *(str) != '+' && *(str) != '-' && *(str) != '*' && *(str) != '/' )
        {
            printf("��⵽������������ �������¼�鲢��������лл!\n");
            return 0;
        }
        str++;
    }//����Ƿ���������������
    str = strnumber;//�ع�ԭλ

    int len = 0;
    while(*(str) != '\0')
    {
        if('0'<=*(str) && '9'>= *(str)){
            newstrnumber[len++] = *(str);
        }//����
        else if(*(str) == '(') PushLStack(S1,*(str));//������
        else if(*(str)== '+' || *(str) == '-')//������ȼ�
        {
            while(1)
            {
                ElemType Tdata = 0;
                ElemType *TdataPtr = &Tdata;
                int TopLS1 = GetTopLStack(S1,TdataPtr);
                if(TopLS1 == 0 || Tdata == '(') {
                    PushLStack(S1,*(str));
                    break;
                }//��Top����Ϊ�ջ��ߣ�ʱ ��ջ
                else {
                    ElemType Pdata = 0;
                    ElemType *PdataPtr = &Pdata;
                    PopLStack(S1,PdataPtr);
                    newstrnumber[len++] = Pdata;//Pop����Ȼ���ջ Ȼ�����ѭ�� ֱ��break��ȥΪֹ
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
                    }//���ڳ˳������ȼ�
                    else {
                        ElemType Pdata = 0;
                        ElemType *PdataPtr = &Pdata;
                        PopLStack(S1,PdataPtr);
                        newstrnumber[len++] = Pdata;
                    }//ͬ��
              }
        }
        else if( *(str) == ')')
        {
            while(1)
            {
                ElemType Pdata = 0;
                ElemType *PdataPtr = &Pdata;
                PopLStack(S1,PdataPtr);
                if(Pdata == '(') break;//ֱ����һ��������ƥ�� ����һֱPop
                else {
                    newstrnumber[len++] = Pdata;
                }
            }
        }
        str++;//ָ���ƶ�
    }

    while(isEmptyLStack(S1) == 1)//��ѹջ ֪����ջΪֹ
    {
         ElemType Pdata = 0;
         ElemType *PdataPtr = &Pdata;
         PopLStack(S1,PdataPtr);
         newstrnumber[len++] = Pdata;
    }
//���濪ʼ���к�׺�������

    char *newstr1= newstrnumber;//ָ��
    while(*(newstr1) != '\0')
    {
        if('0'<=*(newstr1) && '9'>= *(newstr1)){
            PushLStack(S1,*(newstr1)-48);//��Ϊ���ַ��� ����Ҫ-48 ��ջ
        }
        else
        {
                 if(isEmptyLStack(S1) == 0){
                    printf(" �㵱��ʽ������ �������¼�����벢������������!\n");
                    return 0;
                  }
                  ElemType Pdata1 = 0;
                  ElemType *PdataPtr1 = &Pdata1;
                  PopLStack(S1,PdataPtr1);

                  if(isEmptyLStack(S1) == 0){
                    printf(" �㵱��ʽ������ �������¼�����벢������������!\n");
                    return 0;
                  }//����if���Ǽ�鵱�������Ƿ�����
                  ElemType Pdata2 = 0;
                  ElemType *PdataPtr2 = &Pdata2;
                  PopLStack(S1,PdataPtr2);
                   //pOP�����������ֽ�������
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
    int Useless = PopLStack(S1,LastPtr);//ֻΪ�õ�popֵ �����û����
    printf("%d\n",Last);
    getchar();
    return 0;
}
