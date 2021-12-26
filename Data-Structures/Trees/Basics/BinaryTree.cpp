#include <stdio.h>
#include <conio.h>
#include <stdlib.h>

struct node {
	int data;
	struct node* left;
	struct node* right;
};

struct node* newNode(int newData) {
	struct node* newPtr = (struct node*) malloc(sizeof(struct node));
	newPtr->data = newData;
	newPtr->left = NULL;
	newPtr->right = NULL;
}

void preorder(struct node* root) {
	if(root == NULL) {
		return;
	} else {
		preorder(root->left);
		printf("\t %d", root->data);
		preorder(root->right);
	}
}

void postorder(struct node* root) {
	if(root == NULL) {
		return;
	} else {
		postorder(root->left);
		postorder(root->right);
		printf("\t %d", root->data);
	}
}

void inorder(struct node* root) {
	if(root == NULL) {
		return;
	} else {
		printf("\t %d", root->data);
		inorder(root->left);
		inorder(root->right);
	}
}

int height(struct node* root){
	int lheight, rheight;
	if(root == NULL) {
		return 0;
	} else {
		lheight = height(root->left);
		rheight = height(root->right);
		if(lheight > rheight) {
			return lheight + 1;
		} else {
			return rheight + 1;
		}
	}
}

void printGivenLevel(struct node* root, int level) {
	if(root == NULL) {
		return;
	} else if(level == 1) {
		printf ("\t%d", root->data);
	} else {
		printGivenLevel(root->left, level -1);
		printGivenLevel(root->right, level -1);
	}
}

void printLevelOrder(struct node* root) {
	int depth = height(root);
	for(int i=1; i <= depth; i++) {
		printGivenLevel(root, i);
	}
}

int main() {
	struct node *root  = newNode(1);
	root->left = newNode(5);
	root->left->left = newNode(4);
	root->left->right = newNode(7);
	root->right = newNode(6);
	
	printf("Printing Preorder..");
	preorder(root);
	printf("\nPrinting Inorder..");
	inorder(root);
	printf("\nPrinting Postorder..");
	postorder(root);
	
	printf("\n Height of the tree is : %d", height(root));
	printf("\n Printing Level Order: ");
	printLevelOrder(root);
}

