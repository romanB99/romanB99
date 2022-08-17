#include <stdio.h>
int main(void)
{
int how_much_quarters(int change);
int how_much_dimes(int change);
int how_much_nickels(int change);
int how_much_pennies(int change);
int cost;
int pay;
printf("please enter the cost : ");
scanf("%d", &cost);
printf("how much you pay : ");
scanf("%d", &pay);
int change = pay - cost;
if (cost>0 && change >0)
{
int a = how_much_quarters(change);
int b = how_much_dimes(change);
int c = how_much_nickels(change);
int d = how_much_pennies(change);
printf("the change is:\n Total = %i \n quarters = %i \n dimes = %i \n nickels = %i \n pennies = %i \n" ,change,a,b,c,d);
}
else if(cost<0)
{
    printf("something went wrong\n");
}
else
{
    printf("not enough pay please bring more money\n");
}
}



int how_much_quarters(int change)
{
    int a = change/25;
    return a;
}
int how_much_dimes(int change)
{
   int b = (change%25)/10;
    return b;
}
int how_much_pennies(int change)
{
    int d = (((change%25)%10)%5);
    return d;
}
int how_much_nickels(int change)
{
    int c = ((change%25)%10)/5;
    return c;
}
