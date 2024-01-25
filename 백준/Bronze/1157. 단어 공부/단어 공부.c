#include <stdio.h>
#include <string.h>

int main()
{
    int i;
    int len;
    int count;
    int max;
    int select;
    int result = 0;
    char str[1000000];
    int str1[26] = {0,};
    scanf("%s", str);
    len = strlen(str);

    i = 0;
    while(i < len)
    {
        if (str[i] >= 'a' && str[i] <= 'z')
        {
            count = str[i] - 'a';
        }
        if (str[i] >= 'A' && str[i] <= 'Z')
        {
            count = str[i] - 'A';
        }
        str1[count]++;
        i++;
    }
    max = str1[0];
    i = 0;
    select = 0;
    while(i < 26)
    {
        if(max < str1[i])
        {
            max = str1[i];
            select = i;
        }
        i++;
    }
    i = 0;
    while(i < 26)
    {
        if(max == str1[i])
        {
            result++;
        }
        i++;
    }
    if(result > 1)
    printf("?\n");
    else
    printf("%c", select + 'A');
}