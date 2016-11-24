# Word Finder

## To build the program
```
gradle assemble
```
Note: requires Java 8

## To run the program
```
cd build/libs
cp ../resources/main/wordbag .
./wordbag <sequence_of_chars> [<optional_dict_file>]
```

## Solium Programing Competition Nov 2016

Like peasants digging in the filth, your job this competition is to write a program that, when given a collection of letters, will find all of the words it can make with that collection.

This program will be part one of a super secret longer programming competition. If your solution is particularly good, other people may use your program (or a fork of it) to solve the next step in this competition. If it isn't, they could still use your programming anyway, if they wanted to ;-).
 
So given:

* a dictionary of words (use W on linux) <https://en.wikipedia.org/wiki/Words_(Unix)>

  * You may use a file containing a list of words in the English language, separated by new lines. It should be called W and will be located in the same directory as your program. (On GNU/Linux systems and possibly others, you can make W a link to /usr/share/dict/words). You can also choose a restricted subset of words as well and include the file in your submission.

* a collection of letters (a letter can appear more than once)

Output:

* A list of words that can be produced from those letters (not all letters must be used)
 
Example:
```
$ wordbag < eratg
```

Output:
```
great
grate
rate
rat
tag
are
eat
gear
(there's probably more)
```
