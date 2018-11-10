#include<stdlib.h>
#include<stdio.h>
#include<string.h>
typedef char TElemType;
typedef struct  BiTNode {
    TElemType      data;     // ������
    struct BiTNode  *lchild,*rchild;  // ���Һ���ָ��
} BiTNode,*BiTree;   // ��������

typedef enum Status{
	SUCEESS,
	ERROR
}Status;

typedef  struct StackNode
{
	TElemType data;
	struct StackNode *next;
}StackNode, *LinkStackPtr;//����ջ������
const int maxn = 1000;
char newnumber[1000];
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
    else return SUCEESS;
}
Status PopLStack(LinkStackPtr head,TElemType *dataPtr)
{
    LinkStackPtr Pop = NULL;
    if(head->next == NULL ) return ERROR;
    else{
        *(dataPtr) = (head->next->data);//ȡջ�� ���濪ʼfree��pop���
        Pop = head->next;
        head->next = head->next->next;
        free(Pop);
        return SUCEESS;
    }
}

Status PushLStack(LinkStackPtr head,TElemType datas)
{
    LinkStackPtr Push;
    Push = (StackNode *)malloc(sizeof(StackNode));//����ռ�
    if(Push == NULL) return ERROR;
    else{//���濪ʼ����
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
        while( isEmptyLStack(head)== 1)   PopLStack(head,dataPtr);//free��ÿһ����
        return SUCEESS;
    }
}

char nextToken(char infix[])//���š����������������� ��Ϊһ���ַ�
{
    static int pos=0;
    while(infix[pos]!='\0' && infix[pos]==' '){pos++;}//�����ո�
    return infix[pos++];
}
int isOpNum(char ch)//�Ƿ��ǲ�����
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

    if(!isOpNum(x))//�ǲ�������ǰ׺���ʽ�����һ���ַ�һ���ǲ���������������ĵݹ��ֹͣ��
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
        printf("��������Ҫ�����ǰ׺ʽ�� ��ע������Ӣ�����뷨������ʽ�� ����ᱨ��\n");
        printf("***************************************************************\n");
        char strnumber[maxn];
        scanf("%s",strnumber);
        char *str = strnumber;
        while(*(str)!='\0')
        {
            if( (0>*(str) || *(str)>'9') &&  *(str) != '(' && *(str) != ')' && *(str) != '+' && *(str) != '-' && *(str) != '*' && *(str) != '/' )
            {
                printf("��⵽������������ �������¼�鲢��������лл!\n");
                return 0;
            }
            str++;
       }//����Ƿ���������������
       str = strnumber;
       BiTree T = (BiTree)malloc(sizeof(BiTNode));
       createPrefix_recursive(strnumber,T);
       PostOrderTraverse(T);
       //����ת���ɺ�׺ �������ú�׺��ʼ��ɼ���
       LinkStackPtr S1 = InitLStack();
       char *newstr1= newnumber;//ָ��
        while(*(newstr1) != '\0')
        {
            if('0'<=*(newstr1) && '9'>= *(newstr1)){
                PushLStack(S1,*(newstr1)-48);//��Ϊ���ַ��� ����Ҫ-48 ��ջ
            }
            else
            {
                     if(isEmptyLStack(S1) == 1){
                        printf(" �㵱��ʽ������ �������¼�����벢������������!\n");
                        return 0;
                      }
                      TElemType Pdata1 = 0;
                      TElemType *PdataPtr1 = &Pdata1;
                      PopLStack(S1,PdataPtr1);

                      if(isEmptyLStack(S1) == 1){
                        printf(" �㵱��ʽ������ �������¼�����벢������������!\n");
                        return 0;
                      }//����if���Ǽ�鵱�������Ƿ�����
                      TElemType Pdata2 = 0;
                      TElemType *PdataPtr2 = &Pdata2;
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
        TElemType  Last;
        TElemType *LastPtr = &Last;
        int Useless = PopLStack(S1,LastPtr);//ֻΪ�õ�popֵ �����û����
        printf("%d\n",Last);
        getchar();
}
