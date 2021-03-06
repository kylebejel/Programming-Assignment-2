# Programming-Assignment-2
Kyle Bejel

## Problem 1

For problem 1, I decided to treat the running process of the child threads (those of the guests) as the action of eating the cupcake. Originally, I was trying to implement the program in a way such that the threads would be called each time the minotaur called upon that guest (random integer used for this). However, I did not know how to go about using Java to reuse threads; once you call start(), it is illegal to call it again and calling run() alone is not recommended (as it is only supposed to be called by start()). So, I checked my protocol conditions and based on those conditions started each thread. The protocol I used worked as follows:

Counter: the person who was in charge of counting the cupcakes (arbitrarily set this to the first guest aka guests[0])
- if this guest saw a cupcake, they would leave it (could optionally also eat one at some point if they wanted to please the minotaur by each eating a cupake, but for the sake of knowing that everyone had visited the labyrinth this was not necessary; if he was in there to see a cupcake, he wouldn't need to eat one to count himself)
- if this guest saw no cupcake, they were the sole person in charge of requesting a new one (and then they would not eat that cupcake)

Other Guests: anyone not tasked with counting (everyone else)
- can only eat cupcake once
- if there is no cupcake at the end, take no action
- if there is a cupcake and you have not eaten one, eat it; if you have, don't eat it

This would ensure that the counter (when seeing that a cupcake was gone) knew that one person had been in the maze

This solution surpasses O(n^2) because of repeat calls and randomization.

## Problem 2

Strategy 1 automatically seems ineffective because there is no guarentee that all guests will see the vase

Strategy 2 sounds better but relies on the communication of one guest to the entirety of the rest of the guests; on top of that, while it allows for all guests to see the vase, does not guarentee a reasonable, nor consistent, amount of time.

Strategy 3 would be the best approach due to its organized nature; there is a guarenteed opportunity for everyone to see the vase. In addition, it requires only the communication between 2 guests at any given moment.

I was going to implement an array based queue lock, but haven't managed my time well enough recently (work and Senior Design got the best of me), handling the re-entry into the queue with very small probabilities. I was going to terminate this program once the queue was empty. I'll just have to do better next time!

### Resources
- the textbook (primarily chapters 1 and 7; 1 for the prisoners example and 7 for reviewing locks)
- Java Runnable interface docs: https://docs.oracle.com/javase/7/docs/api/java/lang/Runnable.html 
- GeeksforGeeks post on Runnable interface: https://www.geeksforgeeks.org/runnable-interface-in-java/
