# Project OOP 2022/2023
- EL MASRI Sam & SICIM Merve

# General
- How to run the game :
    -compile : javac *.java
    -run : java Game filename (for example : tree1.txt)
- The file must respect the format (check the bottom to see an example)

# Input errors handled by the program
- The program can detect the root if it is not in the first line of the file and works proprely
- The program check the number of nodes in the file (first value of the file)
- The program check the real number of nodes in the file
- The program check the value of the children in the file (must be > 0 && < number of nodes)
- The program check the existance of the input file
- The program check if there is an introduction sentence in the input file
- The program check if the "YES" or "NO" input of the user are well written

# Format of the file
-The file is a text file, the first line of which contains the number of nodes of the decision tree, followed
by a space and the message to be displayed at the beginning of the game (without the suffix “, and
then press <return>.”).
- Each subsequent line corresponds to one node. The nodes are numbered sequentially from 1, i.e., for every i ≥ 1, the node with the number i is described by the (i + 1)-th line of the file.
- A leaf node is represented by a line of the form
= Value associated to this node
- An internal node is represented by a line of the form ? n1 n0 Question associated to this node
where n1 and n0 are the numbers of the children nodes associated (respectively) to the yes and no
answers to the question. The question is written without its final question mark.

7 Please choose an animal
? 2 6 Does it have 4 legs
? 7 4 Does it eat grass
= a dog
? 3 5 Does it bark
= a cat
= a chicken
= a cow
