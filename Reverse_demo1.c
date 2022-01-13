#include<stdio.h>

void reverse(char *arr);
int main()
{
   char arr[] = "12345";
   
   reverse(arr);
   
  return 0;
}


void reverse(char *arr)
{
	if(*arr == '\0')
	return;
	
	reverse(arr+1);
	
	printf("%c",*(arr));
}
