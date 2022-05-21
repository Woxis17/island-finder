# Island Finder program
## Problem:
Having a matrix input consisting of 1 - island tile and 0 - water tile count number of islands.

Example: <br/>
1 1 0 <br/>
1 0 0 <br/>
0 0 1 <br/>
1 0 0 <br/>

Consist of 3 islands.

## Program constrains
Program will handle up to 1000 x 1000 maps. Bigger maps may cause OOM exceptions/ StackOverFlowErrors.
Bigger maps will require a lot of computing time and a lot more memory.

_**SimpleIslandFinder**_ algorithm have computational complexity about O(N^2) and the more tiles of lands the map contains the more memory this algorithm needs.
In best case scenario the algorithm has complexity of O(N) - only water - and in worst O(N^2) - in case of only land - and needs to store all island tiles. 

## Further improvement/ Possible improvements
- Replace Byte objects with byte simple type.
- Now _**MapParser**_ has different responsibility than _**SimpleIslandFinder**_. _**MapParser**_ is responsible for reading whole map file into memory and deliver whole _**IslandMap**_ eagerly in object-oriented style.
However, for bigger maps to reduce memory footprint  the program could be change to load map line by line and _**SimpleIslandFinder**_ will still count the number of islands correctly. 
But in order to do this finder algorithm would have to be aware of how to read the map from the file.
- Research for other algorithm of solving such problems.