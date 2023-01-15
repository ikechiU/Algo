1. Characters Swap

Given a string s, repeat this operation zero or more times to create the lexicographically smallest string possible.


1. Select two characters that exist in the string, c1, and c2.

2. Replace all occurrences of c1 with c2 and all Occurrences of c2 with c1.

Note: For two strings x and y of length n x Is lexicographically smaller than y if the first non-matching character
in x is less than the character at that position in y.


Example

s = "bbcacad"

Select c1 = 'b' and c2 = 'a',  after swapping occurrences, s = 'aacbcbd'
Select c1 = 'b' and c2 = 'c',  after swapping occurrences of c1 and c2 we get s = "aabcbcd"

It can be proven that this is the lexicographically smallest string s can be converted to. Return "aabcbcd".

Function Description
Complete the function getString in the editor below.

getString has the following parameter:
string s: the string to process

Returns
string s can be changed to.