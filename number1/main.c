#include <stdio.h>

int change(char *str,char *p)
{
   int i = 0;
   char temp;

   if(*++p != '\0')
      i =change(str,p);
   if((str+i) <= (--p))
   {
      temp = *(p);
      *(p) = *(str+i);
 *(str+i) = temp;
   }
   return ++i;
}


char *reverse(char *str)
{
   char *p,*q;


   q = p = str;
   change(q,p);
   return str;
}


int main(void)
{
   char s[] = "I want a job,thank you!";

   printf("%s\n",reverse(s));
   return 0;
}
