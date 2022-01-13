#include<stdio.h>

void palindrome(char *str);
int main()
{
	char str[] = "mada";
	palindrome(str);
}

void palindrome(char *str)
{
	int i=0;
	int k;
	
	for(k=0; str[k]!=0; k++);
	k=k-1;
	
	while(i<k)
	{
		if(str[i] == str[k])
		{
			i++;
			k--;
		}
		else
		{
			printf("Given String is not palindrome..!!!");
			return;
		}
	}
	printf("Given String is palindrome...!!");
}
