/*
* Fc Codelona is trying to assemble a team from a roster of available players.
* They have a minimum number of players they want to sign and each player needs to have a skill
* rating within a certain range.Given a list of players skill levels with desired upper and
* lower bounds,determine how many teams can be created from the list.
  Example: skills=[12,4,6,13,5,10]
  minPlayers=3
  minLevel=4
  maxLevel=10

The list includes players with skill levels [12,4,6,13,5,10]
They want to hire at least 3 players with the skill levels between 4 and 10 inclusive.
Four the players with the following skill levels {4,6,5,10} meet criteria.
There are 5 ways to form a team of at least 3 players : {4,5,6} ,{4,6,10},{4,5,10},{5,6,10} and { 4,5,6,10}
Return 5.*/

/*
* To determine the number of teams that can be created from the list of players with the given skill levels
* and desired upper and lower bounds, you can use a combination algorithm.

First, filter the list to only include players with skill levels between the minLevel and maxLevel, inclusive.
* Then, use the combination algorithm to find all possible combinations of players that meet the minimum number
* of players required (minPlayers). The number of combinations will be the number of teams that can be created from the list of players.

For example, in the given case, the list of players that meet the criteria is [4, 6, 5, 10].
* Then you can use the combination algorithm to find all possible combinations of players that have at least 3 players, which is 5.*/
