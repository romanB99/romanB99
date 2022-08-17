///#####linked lists######//

#include <stdio.h>
#include <stdlib.h>


typedef struct node
{
	int number;												 // the number
	struct node* next;										 //pointing to the next address (next is the pointer) 
}
node;
int main(void)
{
	int size;
	printf("please enter how many numbers you want to add :");
	scanf_s("%d", &size);
	node* list = (node*)malloc(sizeof(node));
	if (!list)
	{
		exit(1);
	}
	scanf_s("%d", &list->number);
	list->next = NULL;
	node* head = list;
	for (int i = 1; i < size; i++)
	{
		node* n = (node*)malloc(sizeof(node));
		if (!n)				//if the address value of n is not NULL(malloc allocated)
		{
			exit(1);
		}
		n->next = NULL;
		scanf_s("%d", &n->number);
		list->next = n;
		list = list->next;
	}
	list = head;
	while (list != NULL)
	{
		printf("%d\n", list->number);
		list = list->next;
	}


}
