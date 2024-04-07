# GreekLink

GreekLink is an innovative platform designed to streamline the pairing process within Greek life communities, specifically focusing on the dynamic between "bigs" and "littles." At its core, GreekLink utilizes a modified version of the Gale-Shapley matching algorithm to create pairings that honor the preferences of both parties in an efficient and equitable manner.

## How GreekLink Improves the Matching Process

The traditional Gale-Shapley algorithm, renowned for its application in creating stable matches in scenarios like speed dating, requires each participant to rank all potential matches. This requirement is impractical in the context of Greek life, where the sheer number of "bigs" and "littles" makes comprehensive ranking unfeasible.

GreekLink addresses this challenge by executing a two-phase matching process:

**Initial Gale-Shapley Run:** GreekLink first conducts a "forward" match based on the "littles'" preferences. This phase focuses on creating initial pairings that respect the "littles'" choices, aligning with a smaller, more manageable subset of preferences.

**Reverse Pairing Consideration:** Subsequently, the algorithm incorporates the "bigs'" preferences in a "reverse" pairing phase. This step ensures that the "bigs'" preferences significantly influence the final pairings, refining the initial matches to accommodate mutual preferences wherever possible.
