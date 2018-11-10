#include<stdlib.h>
#include<stdio.h>
#include<string.h>
typedef char TElemType;
typedef struct  BiTNode {
    TElemType      data;     // 数据域
    struct BiTNode  *lchild,*rchild;  // 左、右孩子指针
} BiTNode,*BiTree;   // 二叉链表

typedef enum Status{
	SUCEESS,
	ERROR
}Status;

typedef  struct StackNode
{
	TElemType data;
	struct StackNode *next;
}StackNode, *LinkStackPtr;//引入栈来计算
const int maxn = 1000;
char newnumber[1000];
LinkStackPtr InitLStack()
{
    LinkStackPtr head;
    head = (StackNode *)malloc(sizeof(StackNode));//申请空间
    head->next = NULL;//初始化
    return head;
}
Status isEmptyLStack(LinkStackPtr head)
{
    if(head->next == NULL) return ERROR;//判断是否为0
    else return SUCEESS;
}
Status PopLStack(LinkStackPtr head,TElemType *dataPtr)
{
    LinkStackPtr Pop = NULL;
    if(head->next == NULL ) return ERROR;
    else{
        *(dataPtr) = (head->next->data);//取栈顶 下面开始free掉pop结点
        Pop = head->next;
        head->next = head->next->next;
        free(Pop);
        return SUCEESS;
    }
}

Status PushLStack(LinkStackPtr head,TElemType datas)
{
    LinkStackPtr Push;
    Push = (StackNode *)malloc(sizeof(StackNode));//申请空间
    if(Push == NULL) return ERROR;
    else{//下面开始插入
        Push->data = datas;
        Push->next = head->next;
        head->next = Push;
        return SUCEESS;
    }
}

Status clearLStack(LinkStackPtr head)
{
    int data;
    TElemType *dataPtr = &data;
    if( head == NULL) return ERROR;
    else{
        while( isEmptyLStack(head)== 1)   PopLStack(head,dataPtr);//free掉每一个点
        return SUCEESS;
    }
}

char nextToken(char infix[])//括号、操作数、操作符等 都为一个字符
{
    static int pos=0;
    while(infix[pos]!='\0' && infix[pos]==' '){pos++;}//跳过空格
    return infix[pos++];
}
int isOpNum(char ch)//是否是操作数
{
    if( ch=='(' || ch==')' || ch=='+' || ch=='-' || ch=='*' || ch=='/' )
    {
        return 0;
    }
    return 1;
}

void createPrefix_recursive(char prefix[],BiTree T)
{
    char x=nextToken(prefix);

    T->data=x;
    T->lchild=NULL;
    T->rchild=NULL;

    if(!isOpNum(x))//是操作符。前缀表达式的最后一个字符一定是操作数，所以下面的递归会停止。
    {
        T->lchild = (BiTree)malloc(sizeof(BiTNode));
        createPrefix_recursive(prefix,T->lchild);
        T->rchild = (BiTree)malloc(sizeof(BiTNode));
        createPrefix_recursive(prefix,T->rchild);
    }
}


void visit(char ch)
{
    static int len = 0;
    newnumber[len++] = ch;
}
void PostOrderTraverse(BiTree T)
{
     if(T->lchild != NULL)
        PostOrderTraverse(T->lchild);
    if(T->rchild != NULL)
        PostOrderTraverse(T->rchild);

     visit(T->data);
}

int main()
{
        printf("***************************************************************\n");
        printf("请输入你要计算的前缀式子 请注意请在英语输入法下输入式子 否则会报错！\n");
        printf("***************************************************************\n");
        char strnumber[maxn];
        scanf("%s",strnumber);
        char *str = strnumber;
        while(*(str)!='\0')
        {
            if( (0>*(str) || *(str)>'9') &&  *(str) != '(' && *(str) != ')' && *(str) != '+' && *(str) != '-' && *(str) != '*' && *(str) != '/' )
            {
                printf("检测到你输入有问题 请你重新检查并启动程序谢谢!\n");
                return 0;
            }
            str++;
       }//检测是否有其他错误输入
       str = strnumber;
       BiTree T = (BiTree)malloc(sizeof(BiTNode));
       createPrefix_recursive(strnumber,T);
       PostOrderTraverse(T);
       //以上转换成后缀 下面利用后缀开始完成计算
       LinkStackPtr S1 = InitLStack();
       char *newstr1= newnumber;//指针
        while(*(newstr1) != '\0')
        {
            if('0'<=*(newstr1) && '9'>= *(newstr1)){
                PushLStack(S1,*(newstr1)-48);//因为是字符串 所以要-48 进栈
            }
            else
            {
                     if(isEmptyLStack(S1) == 1){
                        printf(" 你当初式子有误 请你重新检查输入并重新启动程序!\n");
                        return 0;
                      }
                      TElemType Pdata1 = 0;
                      TElemType *PdataPtr1 = &Pdata1;
                      PopLStack(S1,PdataPtr1);

                      if(isEmptyLStack(S1) == 1){
                        printf(" 你当初式子有误 请你重新检查输入并重新启动程序!\n");
                        return 0;
                      }//两个if都是检查当初输入是否有误
                      TElemType Pdata2 = 0;
                      TElemType *PdataPtr2 = &Pdata2;
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
        TElemType  Last;
        TElemType *LastPtr = &Last;
        int Useless = PopLStack(S1,LastPtr);//只为得到pop值 结果并没有用
        printf("%d\n",Last);
        getchar();
}
