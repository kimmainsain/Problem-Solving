#include <stdio.h>
#include <string.h>
#define max(a, b) (a > b ? a : b)

int lcs[1002][1002];
char str[1002];
char str2[1002];

int main()
{
	scanf("%s %s", str, str2);
	int i, j;
	int size,size2;
	size = strlen(str);
	size2 = strlen(str2);
	i = 1;
	while (i <= size)
	{
		j = 1;
		while (j <= size2)
		{
			if (str2[j - 1] == str[i - 1])
			{
				lcs[i][j] = lcs[i - 1][j - 1] + 1;
			}
			else
			{
				lcs[i][j] = max(lcs[i - 1][j], lcs[i][j - 1]);
			}
			j++;
		}
		i++;
	}
	printf("%d", lcs[size][size2]);
}