# ProjectOOP 2022/2023
- EL MASRI Sam & SICIM Merve

# General
- How to run the game :
    -compile : javac *.java
    -run : java Game filename
- The file must respect the format (check the bottom to see an example)

# Input errors handled by the program
- The program can detect the root if it is not in the first line of the file and works proprely

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
