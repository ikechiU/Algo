*
Rearrange an array of integers so that the calculated value U is maximized. Among the arrangements that satisfy that test,
choose the array with minimal ordering. The value of U for an array with n elements is calculated as:
U = arr[1] x arr[2] x (1 ÷ arr[3]) x arr[4] x ...  x arr[n-1] x (1 ÷ arr[n]) if n is odd
U = arr[1] x arr[2] x (1 ÷ arr[3]) x arr[4] x ... x (1 ÷ arr[n-1]) x arr[n] if n is even
The sequence of operations is the same in either case, but the length of the array, n,
determines whether the calculation ends on arr[n] or (1 ÷ arr[n]).
Arrange the elements to maximize U so the Items are in the numerically smallest possible order.
Example
arr = [21, 34, 5, 7, 9]
To maximize U and minimize the order, arrange the array as [9, 21, 5, 34, 7] so U = 9 x 21 x (1 ÷ 5) x 34 x (1 ÷ 7) = 183.6.
The same U can be achieved using several other orders, eg. [21, 9, 7, 34, 5] = 21 x 9 x (1÷7) x 34 x (1÷5) = 183.6,
but they are not in the minimum order.

Function Description
Complete the function rearrange in the editor.

rearrange has the following parameter(s):
int arr[n]: an array of integers

Returns
int arr[n]: the elements of arr rearranged as described
*/