#include <stdio.h>
#include <stdlib.h>


typedef struct node
{
	int number;
	node* left;								
	node* right;
}node ;

void print_tree(node* root);					//
void free_tree(node* root);						//
bool search_tree(node* root, int number);		//	 function declerations
struct node* insert_tree(node* root, int number);
struct node* new_node(int number);



int main(void)
{
	int number = 0;
	int size = 0;
	printf("please enter how many numbers you want to add to the tree : \n");
	scanf_s("%d", &size);
	printf("the amount of numbers you want to add is : %i \n", size);
	node* n = (node*)malloc(sizeof(node));
	if (n == NULL)			//malloc check
	{
		free(n);
		exit(0);
	}
	printf("please enter the numbers you want to add to the tree : \n");
	scanf_s("%d", &number);
	n->left = NULL; 
	n->right = NULL; 
	n->number = number;
	for (int i = 1; i < size  ; i++)
	{
		scanf_s("%d", &number);
	    insert_tree(n, number);
	}
	printf("the inorder numbers of your tree are :\n");
	print_tree(n);
    search_tree(n, 10);
    free_tree(n);
}


struct node* insert_tree(node* root, int number)
{
	if (root == NULL)
	{
		root = new_node(number);
	}
	else if (number < root->number)
	{
		root->left = insert_tree(root->left, number);
	}
	else if (number > root->number)
	{
		root->right = insert_tree(root->right, number);
	}
	return root;
}


struct node* new_node(int number)
{
	node* n = NULL;
	n = (node*)malloc(sizeof(node));		//allocate memory for new node
	if (n == NULL)								//malloc check
	{	
		free(n);
		exit(1);
	}
	n->left = NULL;
	n->right = NULL;
	n->number = number;
	return n;
}


void print_tree(node* root)
{
	if (root != NULL)
	{
		print_tree(root->left);		//print left side
		printf("%i\n", root->number);	//print number
		print_tree(root->right);	//pring right side
	}
	return;
}

void free_tree(node* root)
{
	if (root != NULL)
	{
		free_tree(root->left);	//move throught left
		free_tree(root->right);	//move through right
		free(root);				//free root
	}


}

bool search_tree(node * root, int number)
{	
	if (root == NULL)				// tree is empty
	{
		printf("number %i not in tree\n", number);
	}
	else if (number < root->number)		//move left untill we find the number
	{
		return search_tree(root->left, number);
	}
	else if (number > root->number)		//move right untill we find the number
	{
		return search_tree(root->right, number);	

	}
	else								 //number is root number
		printf("number %i is in tree\n", number);
}

