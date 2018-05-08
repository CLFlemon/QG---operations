#include<BinaryTree.h>
#include<stdlib.h>
#include<stdio.h>
#include<string.h>
int count = 0;
const int maxn = 1e3;
int main()
{
    printf("***********************************************\n");
    printf("  二叉树的操作 数据类型为char\n");
    printf("***********************************************\n");
    printf("  请选择你所要进行的操作 1：构建二叉树 2：赋值 3：摧毁二叉树\n");
    printf("  4：先序遍历 5：中序遍历 6：后序遍历  7:层序遍历 0:退出\n");
    int type ;
    int flag = -1;
    BiTree T ;
    while(scanf("%d",&type) != EOF && type)
    {
        char  c0 = getchar();
        if(type<0 || type>7 || c0 != '\n')
        {
            printf("  请不要乱输入谢谢\n");
            continue;
        }
        else
        {
           //创建二叉树的指针
            switch(type)
            {
                case 1 :
                {
                   if(flag != -1)
                   {
                       printf("  上一个二叉树还没销毁 为了节省内存 请先销毁上一个二叉树!\n");
                       break;
                   }
                   else
                   {
                       T =(BiTree)malloc(sizeof(BiTNode));
                       int result = InitBiTree(T);
                       if(result == 0)  printf("  创建成功!\n");
                       else printf("  创建失败!\n");
                       flag = 0;
                       break;
                   }
                }
                case 2 :
                {
                    if(flag == -1)
                    {
                        printf("  请先初始化二叉树!\n");
                        break;
                    }
                    else
                    {
                        printf("  请输入相应的字符串!\n");
                        char str[maxn];
                        scanf("%s",str+1);
                        int len = strlen(str+1);
                        CreateBiTree(T, str,1,len);
                        printf("  赋值成功！\n");
                        flag = len;
                        break;
                    }
                }
                case 3 :
                {
                    if(flag == -1)
                    {
                        printf("  请先初始化二叉树!\n");
                        break;
                    }
                    else
                    {
                        T = DestroyBiTree(T);
                        if(T == NULL) printf(" 销毁成功\n");
                        else printf("  销毁失败\n");
                        flag = -1;
                        break;
                    }
                }
                case 4 :
                {
                    if(flag == -1 || flag == 0)
                    {
                        printf("  二叉树还没初始化或者还没赋值");
                        break;
                    }
                    else
                    {
                        printf(" 结果是:\n");
                        PreOrderTraverse(T);
                        printf(" \n");
                        break;
                    }
                }
                case 5 :
                {
                     if(flag == -1 || flag == 0)
                    {
                        printf("  二叉树还没初始化或者还没赋值");
                        break;
                    }
                    else
                    {
                        printf(" 结果是:\n");
                        InOrderTraverse(T);
                        printf(" \n");
                        break;
                    }
                }
                case 6 :
                {
                     if(flag == -1 || flag == 0)
                    {
                        printf("  二叉树还没初始化或者还没赋值");
                        break;
                    }
                    else
                    {
                        printf(" 结果是:\n");
                        PostOrderTraverse(T);
                        printf(" \n");
                        break;
                    }
                }
                case 7 :
                {
                   if(flag == -1 || flag == 0)
                    {
                        printf("  二叉树还没初始化或者还没赋值");
                        break;
                    }
                    else
                    {
                        printf(" 结果是:\n");
                        LevelOrderTraverse(T);
                        printf(" \n");
                        break;
                    }
                }
            }
        }
    }
    return 0;
}
