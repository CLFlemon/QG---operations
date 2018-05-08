#include<BinaryTree.h>
#include<stdlib.h>
#include<stdio.h>
#include<string.h>
int count = 0;
const int maxn = 1e3;
int main()
{
    printf("***********************************************\n");
    printf("  �������Ĳ��� ��������Ϊchar\n");
    printf("***********************************************\n");
    printf("  ��ѡ������Ҫ���еĲ��� 1������������ 2����ֵ 3���ݻٶ�����\n");
    printf("  4��������� 5��������� 6���������  7:������� 0:�˳�\n");
    int type ;
    int flag = -1;
    BiTree T ;
    while(scanf("%d",&type) != EOF && type)
    {
        char  c0 = getchar();
        if(type<0 || type>7 || c0 != '\n')
        {
            printf("  �벻Ҫ������лл\n");
            continue;
        }
        else
        {
           //������������ָ��
            switch(type)
            {
                case 1 :
                {
                   if(flag != -1)
                   {
                       printf("  ��һ����������û���� Ϊ�˽�ʡ�ڴ� ����������һ��������!\n");
                       break;
                   }
                   else
                   {
                       T =(BiTree)malloc(sizeof(BiTNode));
                       int result = InitBiTree(T);
                       if(result == 0)  printf("  �����ɹ�!\n");
                       else printf("  ����ʧ��!\n");
                       flag = 0;
                       break;
                   }
                }
                case 2 :
                {
                    if(flag == -1)
                    {
                        printf("  ���ȳ�ʼ��������!\n");
                        break;
                    }
                    else
                    {
                        printf("  ��������Ӧ���ַ���!\n");
                        char str[maxn];
                        scanf("%s",str+1);
                        int len = strlen(str+1);
                        CreateBiTree(T, str,1,len);
                        printf("  ��ֵ�ɹ���\n");
                        flag = len;
                        break;
                    }
                }
                case 3 :
                {
                    if(flag == -1)
                    {
                        printf("  ���ȳ�ʼ��������!\n");
                        break;
                    }
                    else
                    {
                        T = DestroyBiTree(T);
                        if(T == NULL) printf(" ���ٳɹ�\n");
                        else printf("  ����ʧ��\n");
                        flag = -1;
                        break;
                    }
                }
                case 4 :
                {
                    if(flag == -1 || flag == 0)
                    {
                        printf("  ��������û��ʼ�����߻�û��ֵ");
                        break;
                    }
                    else
                    {
                        printf(" �����:\n");
                        PreOrderTraverse(T);
                        printf(" \n");
                        break;
                    }
                }
                case 5 :
                {
                     if(flag == -1 || flag == 0)
                    {
                        printf("  ��������û��ʼ�����߻�û��ֵ");
                        break;
                    }
                    else
                    {
                        printf(" �����:\n");
                        InOrderTraverse(T);
                        printf(" \n");
                        break;
                    }
                }
                case 6 :
                {
                     if(flag == -1 || flag == 0)
                    {
                        printf("  ��������û��ʼ�����߻�û��ֵ");
                        break;
                    }
                    else
                    {
                        printf(" �����:\n");
                        PostOrderTraverse(T);
                        printf(" \n");
                        break;
                    }
                }
                case 7 :
                {
                   if(flag == -1 || flag == 0)
                    {
                        printf("  ��������û��ʼ�����߻�û��ֵ");
                        break;
                    }
                    else
                    {
                        printf(" �����:\n");
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
