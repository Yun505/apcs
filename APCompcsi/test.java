public class test{
public static void increment (int start, int inc, int[] values)
{
while (start < values.length) {
values[start] += inc;
start++;
}
}
public static void increment (int m, int n)
{
m++;
n+=5;
System.out.println(m++);
System.out.println(--n);
}
public static void increment (int inc, int[] values) {
int[] newvalues = new int[values.length];
for (int i=0; i<values.length;i++) {
newvalues[i] = values[i] + inc;
}
values = newvalues;
printArray(values);
}
public static void printArray(int[] array) {
for (int i=0; i<array.length; i++) {
System.out.print(array[i] + ", ");
}
System.out.println();
}
public static void main(String[] args) {
    int x = 10;

int y = 20;

System.out.print(y + x / y);
}
}