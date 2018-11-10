#include<stdio.h>
#include<stdlib.h>
#include"List.h";
const int MAXN = 100;
int len;
int main()
{
	printf("    声明：head结点存数据 且算第一个结点\n\n\n");
	printf("    请输入数组长度（注意不可大于100，可修改）\n");
	int Data[MAXN];
	scanf("%d", &len);
	printf("    请输入数组数据\n");
	for (int i = 1; i <= len; i++) scanf("%d", &Data[i]);//数据数组
	ptr_Node head = create(Data, len);
	printf("    请输入你要操作的相应数字\n");
	printf("    1是插入  2是删除  3是查找  4是修改 5是输出当前链表 6是销毁链表 0是结束操作 \n");
	printf("    注意以上操作只能是单点操作\n");

	int operation;
	while (scanf("%d", &operation) != EOF && operation != 0) {
		switch (operation) {
		case 1: {
			printf("   输入你想插入的结点的数据：\n");
			int number;
			scanf("%d", &number);
			ptr_Node node = (Node *)malloc(sizeof(Node));
			node->data = number;
			node->next = NULL;
			printf("   输入你想插入的结点位置 比如输入0就正头结点插入 输入长度就在末结点插入\n");
			printf("   注意输入位置小于等于长度 否则失败\n");
			int index;
			scanf("%d", &index);
			int result_insert = insert_(&head, node, index);
			if (result_insert == 0) printf("   操作成功\n");
			else printf("    操作失败\n");
			printf("   请继续操作\n");
			len++;
			break;
		}
		case 2: {
			printf("   输入你想删除结点的位置 比如输入0就删除头结点 输入长度-1就删除尾结点\n");
			printf("   删除的数据将保留在data指针里面\n");
			printf("   注意输入位置小于长度 否则失败\n");
			int index;
			scanf("%d", &index);
			int *data = NULL;
			int result_delete = delete_(&head, index, data);
			len--;
			if (result_delete == 0) printf("   操作成功\n");
			else printf("    操作失败\n");
			printf("   请继续操作\n");
			break;
		}
		case 3: {
			printf("   输入你想查到的数据：\n");
			int data;
			scanf("%d", &data);
			printf("   注意输出的结果是与数据相等的结点的前一个位置 比如是头结点就输出0\n");
			printf("   如果结果是-1代表出错 请自行检查输入数据是否有误\n");
			int result_search = search_(head, data);
			printf("   结果是:%d\n", result_search);
			printf("   请继续操作\n");
			break;
		}
		case 4: {
			printf("   输入你想修改的数据: \n");
			int number;
			scanf("%d", &number);
			int *data = &number;
			printf("   输入你想修改的结点的前一位 比如想修改头结点就输入0 想修改末结点就输入长度-1\n");
			int index;
			scanf("%d", &index);
			int resule_edit = edit_(head, index, data);
			if (resule_edit == 0) printf("   操作成功\n");
			else printf("    操作失败\n");
			printf("   请继续操作\n");
			break;
		}
		case 5: {
			printf("当前链表为：\n");
			print(head);
			printf("   请继续操作\n");
			break;
		}
		case 6: {
			printf("    下面开始销毁链表 请按0结束\n");
			destroy(head);
		}
		}
	}
	return 0;
}
