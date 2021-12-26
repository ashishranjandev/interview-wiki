/* Program to find height of the tree by Iterative Method */
#include <iostream>
#include <queue>
#include <stdlib.h>
using namespace std;
 
// A Binary Tree Node
struct node
{
    struct node *left;
    int data;
    struct node *right;
};
 
// Iterative method to find height of Bianry Tree
int treeHeight(node *root)
{
    // Base Case
    if (root == NULL)
        return 0;
 
    // Create an empty queue for level order tarversal
    queue<node *> q;
 
    // Enqueue Root and initialize height
    q.push(root);
    int height = 0;
 
    while (1)
    {
        // nodeCount (queue size) indicates number of nodes
        // at current lelvel.
        int nodeCount = q.size();
        if (nodeCount == 0)
            return height;
 
        height++;
 
        // Dequeue all nodes of current level and Enqueue all
        // nodes of next level
        while (nodeCount > 0)
        {
            node *node = q.front();
            q.pop();
            if (node->left != NULL)
                q.push(node->left);
            if (node->right != NULL)
                q.push(node->right);
            nodeCount--;
        }
    }
}
 
// Utility function to create a new tree node
struct node* newNode(int data)
{
     struct node* node = (struct node*)malloc(sizeof(struct node));
     node->data = data;
     node->left = NULL;
     node->right = NULL;
 
     return(node);
}

/* Inorder traversal of a binary tree*/
void inorder(struct node* temp)
{
    if (!temp)
        return;
 
    inorder(temp->left);
    cout << temp->data << " ";
    inorder(temp->right);
}


/*function to insert element in binary tree */
void insert(struct node* temp, int key)
{
    queue<struct node*> q;
    q.push(temp);
 
    // Do level order traversal until we find
    // an empty place. 
    while (!q.empty()) {
        struct node* temp = q.front();
        q.pop();
 
        if (!temp->left) {
            temp->left = newNode(key);
            break;
        } else
            q.push(temp->left);
 
        if (!temp->right) {
            temp->right = newNode(key);
            break;
        } else
            q.push(temp->right);
    }
}
 
// Driver program to test above functions
int main()
{
    // Let us create binary tree shown in above diagram
    node *root = newNode(1);
    root->left = newNode(2);
    root->right = newNode(3);
    root->left->left = newNode(4);
    root->left->right = newNode(5);
 
    cout << "Height of tree is " << treeHeight(root) << "\n";
    
    cout << "Inorder traversal before insertion:";
    inorder(root);
 
    int key = 12;
    insert(root, key);
 
    cout << endl;
    cout << "Inorder traversal after insertion:";
    inorder(root);
    return 0;
}

