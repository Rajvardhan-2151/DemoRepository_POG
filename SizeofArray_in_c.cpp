#include<stdio.h>

int main()
{
	int arr[] = {10, 20, 30, 40, 50, 60};
	printf("%d",sizeof(arr) / sizeof(*arr));
}
