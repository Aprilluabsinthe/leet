Day 1: Arrays Part 01

## Data Structures

![Arrays](image.png)

An array is a linear data structure that collects elements of the same data type and stores them in contiguous and adjacent memory locations. 

Arrays work on an index system starting from 0 to (n-1), where n is the size of the array.

What Are the Types of Arrays?
There are majorly two types of arrays, they are:

One-Dimensional Arrays: 
![One-Dimensional Arrays](image-1.png)

Two-Dimensional Arrays: 
![Two-Dimensional Arrays](image-2.png)

Three-Dimensional Arrays: 
![Three-Dimensional Arrays](image-3.png)


## How Do You Declare an Array?
![Alt text](image-4.png)

Arrays are typically defined with square brackets with the size of the arrays as its argument.

Here is the syntax for arrays:

> 1D Arrays: int arr[n];
> 
> 2D Arrays: int arr[m][n];
> 
> 3D Arrays: int arr[m][n][o];

## How Do You Initialize an Array?
You can initialize an array in four different ways:

### Method 1:
<code>int a[6] = {2, 3, 5, 7, 11, 13};</code>

### Method 2: 
<code>int arr[]= {2, 3, 5, 7, 11};</code>

### Method 3: 
<pre><code>int n;

scanf(“%d”,&n);

int arr[n];

for(int i=0;i<5;i++)

{

scanf(“%d”,&arr[i]);

}</code></pre>

### Method 4:
<pre><code>int arr[5];

arr[0]=1;

arr[1]=2;

arr[2]=3;

arr[3]=4;

arr[4]=5;
</code></pre>

