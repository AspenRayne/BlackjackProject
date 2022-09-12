# BlackjackProject

## Description

This is a BlackJack replica played in the command line by a user.
Its follows the same based rules, which I have linked here:

https://en.wikipedia.org/wiki/Blackjack


I have not implemented the options to:

- Bet
- Split
- Surrender
- Double Down

## Technologies

Git, Eclipse, Java.

## Lessons Learned

Object-Oriented Programming
is useful for when you want to create models/entities that have multiple use cases. 

For example: 
The cards, hands, and decks can be instantiated for use in different card games. 
This allows code to be DRY and easy to re-implement. 

Enums
is a useful data modeling technique that allows constants to be instantiated throughout
a program.

For Example: 
I used enums classes to instantiate suits and ranks for a card which then I 
implemented into a deck. Using Inheritance, I was then able 
to create a Hand, which I used that predefined Hand to create my BlackJackHand. 


Lastly, being there was a lot of logic in creating this BlackJack Application.
I learned how important it is to break up my code into different methods, to 
keep my code more readable. 
Having readable code is very important and 
doing this project, really helped me understand how to break down 
complexity into smaller code blocks.
