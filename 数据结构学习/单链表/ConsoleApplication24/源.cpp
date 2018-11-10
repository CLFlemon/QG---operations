#include<stdio.h>
#include<stdlib.h>
#include"List.h";
const int MAXN = 100;
int len;
int main()
{
	printf("    ������head�������� �����һ�����\n\n\n");
	printf("    ���������鳤�ȣ�ע�ⲻ�ɴ���100�����޸ģ�\n");
	int Data[MAXN];
	scanf("%d", &len);
	printf("    ��������������\n");
	for (int i = 1; i <= len; i++) scanf("%d", &Data[i]);//��������
	ptr_Node head = create(Data, len);
	printf("    ��������Ҫ��������Ӧ����\n");
	printf("    1�ǲ���  2��ɾ��  3�ǲ���  4���޸� 5�������ǰ���� 6���������� 0�ǽ������� \n");
	printf("    ע�����ϲ���ֻ���ǵ������\n");

	int operation;
	while (scanf("%d", &operation) != EOF && operation != 0) {
		switch (operation) {
		case 1: {
			printf("   �����������Ľ������ݣ�\n");
			int number;
			scanf("%d", &number);
			ptr_Node node = (Node *)malloc(sizeof(Node));
			node->data = number;
			node->next = NULL;
			printf("   �����������Ľ��λ�� ��������0����ͷ������ ���볤�Ⱦ���ĩ������\n");
			printf("   ע������λ��С�ڵ��ڳ��� ����ʧ��\n");
			int index;
			scanf("%d", &index);
			int result_insert = insert_(&head, node, index);
			if (result_insert == 0) printf("   �����ɹ�\n");
			else printf("    ����ʧ��\n");
			printf("   ���������\n");
			len++;
			break;
		}
		case 2: {
			printf("   ��������ɾ������λ�� ��������0��ɾ��ͷ��� ���볤��-1��ɾ��β���\n");
			printf("   ɾ�������ݽ�������dataָ������\n");
			printf("   ע������λ��С�ڳ��� ����ʧ��\n");
			int index;
			scanf("%d", &index);
			int *data = NULL;
			int result_delete = delete_(&head, index, data);
			len--;
			if (result_delete == 0) printf("   �����ɹ�\n");
			else printf("    ����ʧ��\n");
			printf("   ���������\n");
			break;
		}
		case 3: {
			printf("   ��������鵽�����ݣ�\n");
			int data;
			scanf("%d", &data);
			printf("   ע������Ľ������������ȵĽ���ǰһ��λ�� ������ͷ�������0\n");
			printf("   ��������-1������� �����м�����������Ƿ�����\n");
			int result_search = search_(head, data);
			printf("   �����:%d\n", result_search);
			printf("   ���������\n");
			break;
		}
		case 4: {
			printf("   ���������޸ĵ�����: \n");
			int number;
			scanf("%d", &number);
			int *data = &number;
			printf("   ���������޸ĵĽ���ǰһλ �������޸�ͷ��������0 ���޸�ĩ�������볤��-1\n");
			int index;
			scanf("%d", &index);
			int resule_edit = edit_(head, index, data);
			if (resule_edit == 0) printf("   �����ɹ�\n");
			else printf("    ����ʧ��\n");
			printf("   ���������\n");
			break;
		}
		case 5: {
			printf("��ǰ����Ϊ��\n");
			print(head);
			printf("   ���������\n");
			break;
		}
		case 6: {
			printf("    ���濪ʼ�������� �밴0����\n");
			destroy(head);
		}
		}
	}
	return 0;
}
