# User Guide

## Introduction

It's Friday evening, the clock is ticking down the final hours at work, and all you can think about is kicking back and enjoying a great night out. But then, it hits you—it’s your 1-year anniversary and you haven’t planned anything special yet! With just three hours to go before you meet your significant other, panic starts to set in. But wait, there’s no need to worry! Introducing 'Flirt and Fork,' your personalized date night concierge.

Imagine never running out of creative and exciting date night ideas again. Whether you're caught up in work or simply struggling for inspiration, 'Flirt and Fork' takes the stress out of your romantic plans. Our app generates tailor-made, delightful date itineraries with just a few clicks.

Here’s what makes 'Flirt and Fork' an essential tool for anyone wanting to impress their special someone:

1. **Curated Experiences**: From trendy restaurants and cozy cafes to thrilling activities and thoughtful gifts, our app curates a list of experiences that promise to make your date memorable.
2. **Personalized Options**: We understand that uniqueness is key. That's why 'Flirt and Fork' offers customizable options to filter your date plans based on location, budget, and cuisine preferences, ensuring every date is as unique as your relationship.
3. **Simplicity and Speed**: Forget the endless browsing and decision fatigue. Our user-friendly interface provides quick, efficient, and enjoyable planning, so you can focus more on living in the moment and less on the logistics.
4. **Ever-Growing Database**: Our extensive and ever-expanding collection of venues and activities keeps your dating life vibrant and exciting, offering new experiences every time you use the app.

Don’t let another special occasion slip by uncelebrated. Sign up for 'Flirt and Fork' today, and start crafting those perfect evenings that turn into cherished memories. Why wait? Let us help you create a night out that’s as wonderful as your significant other. Embrace the ease of planning, and give your date nights the upgrade they deserve with 'Flirt and Fork'!


## Quick Start

1. Ensure you have Java `11` or above installed in your Computer.
2. Download the latest version of `Flirt and Fork` from [here](http://link.to/FlirtandFork).
3. Copy the file to the folder you want to use as the _home folder_
4. Open a command terminal, `cd` into the folder you put the jar file in, and use the `java -jar Flirt_and_Fork.jar` command to run the bot. The GUI should appear in a few seconds.
5. Type the command in the command box and press Enter to execute it.
6. Refer to the [Features](#Features) section below for an overview of all valid commands.

## Features 

This section provides an overview of the available commands in the application, grouped by their functionality. Detailed usage instructions for each command can be found in the [Usage](#Usage) section.

### Discovering Options
Explore potential dining, activities, and gifts options.
- `list`: View a comprehensive list of restaurants, activities, and gift ideas.

### Searching Options
Search for potential dining. activities, and gift options to add on to your favourites. Search within your favourites list as well.
- `find`: Search the database for potential dining places, activities and gifts. Search your favourites list for specific entries as well.

### Personalisation
Tailor the application experience to your preferences for more customised suggestions.
- `me`: Input personal details and preferences to enable personalised suggestions.
- `itinerary`: Generate a date itinerary based on specified preferences for location and pricing.
- `smart`: Generate a smart itinerary tailored to your personal details.
> Complete `me` before the smart itinerary function can be enabled

### Idea Generation
Stimulate creativity with randomised suggestions for dates and gifts.
- `idea`: Receive a randomised date idea.
- `gift`: Receive a randomised gift suggestion.

### Favourites Management
Manage a personalised list of your favourite foods and activities.
- `food`: Add a food option to your favourites list.
- `activity`: Add an activity to your favourites list.
- `favourites`: List all entries in your current favourites list.
- `delete`: Remove an entry from your favourites list based on its entry number.

### Additional Utilities
Extra commands to facilitate application use.
- `help`: Display help message with a summary of all valid commands at any point in time.
- `history`: List all past marked date restaurants, activities, and gift ideas.

### Exit the program
There is only one command to terminate the program:
- `exit`: Saves all current data and exits the program.

Refer to the [Usage](#Usage) section below for details of each command.

## Usage

### Put in your personal details: `me`
Takes in personal details like cuisine preferences, location and anniversary date if applicable to personalise the user experience. It is also automatically run on first start-up and has to be completed before using the app. Entering `me` subsequently provide the option to update user deatils.

Example of usage: `me`

Expected outcome:

```
Please enter your name:
```

- Expected outcome after inputting name as `Cupid`:

```
Great! Hello there Cupid, it's my pleasure to know you!
____________________________________________________________
Please enter your age:
```

- Expected outcome after inputting age as `22`:

```
Wow, you're 22 years young! This might be handy information.
____________________________________________________________
Please enter your gender(Male/Female/Other):
```

- Expected outcome after inputting gender as `Male`:

```
I see you're a Male!
____________________________________________________________
Where do you stay?

E: East
W: West
C: Central
S: South
NE: NorthEast
```

- Expected outcome after inputting location as `NE`:

```
Thanks! Don't worry, I won't let the rest know where you stay ;)!
____________________________________________________________
What is your favourite cuisine?

W: Western
F: Fusion
J: Japanese
C: Chinese
T: Thai
K: Korean
I: Italian
S: Spanish
```

- Expected outcome after inputting cuisine as `W`:

```
Thanks, this will be useful...
____________________________________________________________
Please enter your relationship status:

Enter 'M' if you are Married
Enter 'R' if you are in a serious relationship
Enter 'F' if you are having a fling
Enter 'D' if you are dating/testing the waters
Enter 'S' if you are single and ready to mingle
Enter 'X' if you are single and only looking to hangout with friends
```

- Expected outcome after inputting relationship status as `R`:

```
Thanks for letting me know your relationship status! :)
____________________________________________________________
Lucky you! Please enter your anniversary in 'dd/mm/yyyy' format:
```

- Expected outcome after inputting anniversary date as `14/02/2024`:

```
User details saved successfully!
Curious about what you can do? Just type 'help' for a sprinkle of tips! 
____________________________________________________________
```

Note: Anniversary option only shows up if `M`, `R` or `D` are set as the relationship status.

### Display all possible commands: `help`
Lists out all possible commands used to interact with Flirt and Fork.

Example of usage: `help`

Expected outcome:
```
I know you are excited to Flirt & Fork :) Here's how: 

----------------------------------------- 
| Command to type | Function of feature | 
----------------------------------------- 
1. list: Take a look at potential restaurants, activities, or gifts 

...
```

### Discovering Options: `list`
Lists out all the restaurants, activities, or gifts within the curated collection.

Example of usage: `list`

Expected outcome:
```
Looking for ideas to spice up your date night?
Choose from the following options:
1. List out delicious dining options (type 'food')
2. Discover exciting activities to do together (type 'activities')
3. Unwrap joy with our curated list of gifts that'll make hearts flutter! (type 'gifts')
4. Changed your mind? Feel free to cancel this command! (type 'cancel')
What's your pleasure?
```
---

- If user input `food`: Displays a list of potential restaurants or eateries.

Expected outcome:
```
HMMMM Let's see what food is theree: 
1. 25 Degrees
2. 49 Seats
...
____________________________________________________________
To discover exciting activities, type 'activities'
To view a curated list of gifts, type 'gifts'
To cancel this command, type 'cancel'
```
---
- If user input `activities`: Shows a list of fun and engaging activities.

Expected outcome:
```
What are some activities you can do as a couple? Let's see..
1. Botanic Garden Tours
2. Gardens by the Bay
...
____________________________________________________________
To list out delicious dining options, type 'food'
To view a curated list of gifts, type 'gifts'
To cancel this command, type 'cancel'
```
---
- If user input `gifts`: Presents a selection of gift ideas.

Expected outcome:
```
Peek into Cupid's own gift collection!
1. [Accessory] Customised pendant necklace
2. [Accessory] Personalised charm bracelets
...
____________________________________________________________
To list out delicious dining options, type 'food'
To discover exciting activities, type 'activities'
To cancel this command, type 'cancel'
```
---
- If user input `cancel`: Terminates and exits the current list viewing session.
  - This command can be used at any point during the list viewing interaction if the user decides not to stop viewing.

Expected outcome:
```
Cancelling listings... 
Cancel success!
```
### Find an entry: `find`
Finds relevant entries from the food, activities, gifts database and your favourites list, based on the keyword inputted.

Format: `find`

Expected Outcome:
```
What are you searching for in this enchanting realm?
Choose from the following options:
1. What delicious food are you craving for today? (type 'food')
2. What exciting activity are you interested in? (type 'activities')
3. On the hunt for the perfect gift? What are you looking for? (type 'gifts')
4. Finding within your own treasures? (type 'favourites')
5. Changed your mind? Feel free to cancel this command! (type 'cancel')
   What's on your mind?
```
- If user inputs 'food': 

Expected Outcome:

```Mmmm food yes. What restaurants would you like to search for?```

User then needs to input their search keyword here.
* The `keyword` is not case-sensitive. `Japanese` will yield the same result as `japanese`.
* The `keyword` can contain multiple words.

Example of usage:
`sushi`
`BBQ`

Expected outcome:
```
Eureka! Your cupid's arrow hit the target! We found these matches for you:
1. BBQ Smokehouse
2. Bulgogi BBQ
```
- If user inputs 'activities':

Expected Outcome:

```Mmmm activities! What kind of activities would you like to search for?```

User then needs to input their search keyword here.
* The `keyword` is not case-sensitive. `Japanese` will yield the same result as `japanese`.
* The `keyword` can contain multiple words.

Example of usage:
`walk`
`concert`

Expected outcome:
```
Eureka! Your cupid's arrow hit the target! We found these matches for you:
1. Esplanade Free Concerts
2. Victoria Theatre Concert Night
3. Private Music Concerts
```

- If user inputs 'gifts':

Expected Outcome:

```Mmmm gifts! What kind of gifts would you like to search for?```

User then needs to input their search keyword here.
* The `keyword` is not case-sensitive. `Japanese` will yield the same result as `japanese`.
* The `keyword` can contain multiple words.

Example of usage:
`bracelet`
`ring`

Expected outcome:
```
Eureka! Your cupid's arrow hit the target! We found these matches for you:
1. [Accessory] Studs or dazzling chandelier earrings
2. [Flower] Orchids: Love, beauty, strength, deep enduring passion
3. [Accessory] Versatile silk scarf featuring a unique design or pattern
```

- If user inputs 'favourites':

Expected Outcome:

```Mmmm finding your own treasures i see. What would you like to search for?```

User then needs to input their search keyword here.
* The `keyword` is not case-sensitive. `Japanese` will yield the same result as `japanese`.
* The `keyword` can contain multiple words.

Example of usage:
`bbq`
`paragliding`

Expected outcome:
```
Eureka! Your cupid's arrow hit the target! We found these matches for you:
1. East Coast BBQ
```

- If user input `cancel`: Terminates and exits the current searching session.

Expected outcome:
```
Cancelling findings... 
Cancel success!
```
### Generate a randomised date idea: `idea`
Generates out a randomised date idea, consisting of 1 restaurant and 1 activity from our curated collection. After receiving the suggestion, users have the option to accept or request for another idea.

Example of usage: `idea`

Expected outcome:
```
You can do Marina Bay Sands Helicopter Tour and have a nice meal at 49 Seats
Satisfied with the date idea? [Yes/No]
```
---
- If user input `no`: Regenerates another date idea for users to consider.

Expected outcome:
```
Regenerating a new date idea..
You can do Punggol Settlement Seafood Dining and have a nice meal at Pura Barsa
Satisfied with the date idea? [Yes/No]
```
---
- If user input `yes`: Choice will be confirmed and saved in view history for ease of reference.

Expected outcome:
```
That's great! Enjoy your date!
```
Note: Saving an idea to history does not work as of v2.0 and will be fixed in the next release.

### Generate a randomised gift suggestion: `gift`
Generates a randomised gift idea either with or without any gender specifications.

Each suggestion comes with a category tag `[Creative]`, `[Food]`, `[Accessory]`, etc. to give users a sense of what type of gift it is.

Example of usage: `gift` / `gift male` / `gift female` / `gift unisex`

Expected outcome:
```
[Creative] Personalised pens engraved with the recipient's name or initials
-> Satisfied with the gift suggestion? [Yes/No]
-> Changed you mind? type 'cancel' to exit this process!
```

---
- If user input `no`: Regenerates another gift suggestion for users to consider.

Expected outcome:
```
[Flower] Red roses: Love and passion (associated with deep affection and desire)
-> Satisfied with the gift suggestion? [Yes/No]
-> Changed you mind? type 'cancel' to exit this process!
```
---
- If user input `yes`: Choice will be confirmed and saved in view history for ease of reference.

Expected outcome:
```
This gift is about to make a love story even sweeter.
```
---
- If user input `cancel`: Terminates the current gift suggestion session and exits the gift generation process. 
  - This command can be used at any point during the gift suggestion interaction if the user decides not to continue or wishes to start over.

Expected outcome:
```
Taking a break? That's okay! 
Remember, great ideas need their own time to unwrap.
```
> **!IMPORTANT**
>
> Be aware that only one type of gift command can be active at a time. If you initiate a gift suggestion command (`gift`, `gift male`, `gift female`, or `gift unisex`), you must follow through with that choice.
>
> If during the process you wish to change the gender specification of the gift, you will need to terminate the current session by typing `cancel`.
>
> Once canceled, you can then start a new gift suggestion session with the desired command to specify a different gender.
>
> **Example scenario:**
>
> Initial command: `gift male`
>
> User response: Wishes to switch to female-oriented gifts.
>
> Required action:
> 1. `cancel` to stop the current process.
> 2. Input `gift female` to start receiving gift suggestions suitable for a female recipient.

### Generate a date itinerary, based on preferred location and budget: `itinerary`
Generates out a date itinerary, consisting of 2 restaurants and 2 activities from our curated collection.
The itinerary selected will be based off the user's indicated location and budget.

Format: `itinerary [preferred_location], [preferred_price]`

> Note: The `preferred location` and `preferred price` must be within the [legend](#Legend).  

Example of usage: `itinerary E, A`

Expected outcome:
```
Here is a rough itinerary for your date: 
We begin with lunch at Five Oars, followed by some fun at Changi Museum Visit.
We proceed to have dinner at Missus, and finish the night at Punggol Promenade Nature Walk.

Are you satisfied with the itinerary? [Yes/No]
```
---
- If user input `no`: Application will prompt user to initiate the generation process again if they wish to try for another option.

Expected outcome:
```
We apologise! Perhaps you could try again?
```
---
- If user input `yes`: Choice will be confirmed and saved in view history for ease of reference.

Expected outcome:
```
That's great! Enjoy your date!
```
Note: Saving an itinerary to history does not work as of v2.0 and will be fixed in the next release.

### Generate a smart itinerary, based on your user profile: `smart`
The smart command generates a personalised itinerary tailored to your preferences, including your favorite cuisine and preferred location. This feature takes into account the details you've provided to Flirt and Fork to recommend a combination of food and activities that align with your tastes and interests.

Format: `smart`

Simply enter smart to let Flirt and Fork create a custom itinerary for you. Ensure your user profile is updated with your current preferences for the best recommendations.

Expected Outcome:

Upon executing the smart command, Flirt & Fork will display a curated itinerary that includes two food options and two activities. The suggestions for the afternoon (lunch + afternoon activity) are specifically tailored to your default location and favourite cuisine, aiming to enhance your experience with personalized options.

If Flirt & Fork successfully generates an itinerary, you'll see something like this:

```
Here is a smart itinerary for your date (the afternoon is planned around your base preferences!): 
We begin with lunch at Five Guys, followed by some fun at Museum of Ice Cream.
We proceed to have dinner at Tolido's Expresso Nook, and finish the night at Haw Par Villa.
```

In cases where your preferences are too unique or if an unexpected error occurs, Flirt & Fork will inform you that it was unable to generate a suitable itinerary, encouraging you to try again or adjust your profile preferences:

```
I could not generate a suitable itinerary based on your personal details!
I'm not smart enough for your default preferences, try 'itinerary' command instead!
```

Notes:

- The itinerary suggestions are based on the current database of foods and activities within Flirt & Fork. For the best experience, make sure your user details are up-to-date.
- If Flirt & Fork encounters difficulty in generating an itinerary due to overly unique preferences or other issues, you will receive a message encouraging you to adjust your preferences or try another command.
By using the smart command, you can discover new and exciting ways to enjoy your day, tailored specifically to what you love.


### Add a restaurant to your favourites: `food`
Adds a new restaurant to your favourites list.

Format: `food [name of eatery], [location], [price], [cuisine]`

> Note: The `location` and `price` must be within the [legend](#Legend).  
> Ensure the formatting is strictly followed, including the spacing. 
> For example, `food Omakase, C, S, J` will be registered, whereas `food Omakase,C,S,J` will result in an error.

Example of usage: 
`food East Coast BBQ, NE, B, J`
`food Omakase, C, S, J`

Expected outcome:
```
Cupid's arrow strikes! This is now in your favourites. 
[Food] East Coast BBQ
You've collected 1 romantic treasures!
```


### Add an activity to your favourites: `activity`
Adds a new activity to your favourites list.

Format: `activity [name of activity], [location], [price]`

> Note: The `location` and `price` must be within the [legend](#Legend).  
> Ensure the formatting is strictly followed, including the spacing. 
> For example, `activity Paragliding, C, S` will be registered, whereas `activity Paragliding,C,S` will result in an error.

Example of usage: 
`activity Paragliding, C, S`
`activity Bungee Jumping at Sentose, S, P`

Expected outcome:
```
Cupid's arrow strikes! This is now in your favourites. 
[Activity] Paragliding
You've collected 2 romantic treasures!
```

### List out all entries in your favourites list: `favourites`
Lists out all the entries within your favourites list.

Format: `favourites`

Expected outcome:
```
Drumroll, please! Presenting the stars of your romantic sky: 
1. [Food] East Coast BBQ
2. [Activity] Paragliding
```

### Delete an entry from your favourites list: `delete`
Deletes an entry from your favourites list, based on the entry index inputted.

Format: `delete [index of entry]`

Example of usage: 
`delete 2`
`delete 7`

Expected outcome:
```
Poof! Sayonara~ This favourite has been removed: 
[Activity] Paragliding
Now you have 1 romantic treasures!
Your journey of love and taste continues~
```

### List out all entries from your past date history: `history`
Lists out all the previous restaurants and activities completed on previous dates. Whenever `yes` is inputted for generating an idea or itinerary, it is assumed that the user will follow that date plan and hence, the suggested locations will be saved in the history.

Format: `history`

Expected outcome:
```
These are the activities you have marked:
1. Singapore River Cruise
2. Katong Food Walk
3. Changi Museum Visit
4. Marina Bay Sands Casino
5. Singapore Flyer Dining

These are the restaurants you have marked:
1. Missus
2. Five Oars
3. Knead To Eat
4. Idaten Udon
5. Watami Japanese Dining

These are the gifts you've marked:
```
Note: This feature does not work correctly as of v2.0 and will be fixed in the next release.

### Exit the program: `exit`
Exits the program.

Format: `exit`

Expected outcome:
```
Love, like a good meal, is all about timing.
Keep your love simmering and your fork ready, see you at the next course!

```

## Legend
Prices:
* C: Cheap
* B: Budget
* A: Affordable
* P: Pricey
* S: Special Occasions Only

Cuisines:
* W: Western
* F: Fusion
* J: Japanese
* C: Chinese
* T: Thai
* K: Korean
* I: Italian
* S: Spanish

Locations:
* E: East
* W: West
* C: Central
* S: South
* NE: NorthEast
* ACC: Accessible (found in multiple places around SG)


## FAQ

**Q: What is 'Flirt and Fork' and how does it help with planning dates?**  
A: 'Flirt and Fork' is a personalized date planning application that generates creative and enjoyable date itineraries tailored to your budget and location. It simplifies the process of coming up with date ideas by providing suggestions for dining, activities, and gifts based on your preferences.

**Q: Do I need any specific software to run 'Flirt and Fork'?**  
A: Yes, you will need to have Java 11 or above installed on your computer to run 'Flirt and Fork'.

**Q: How do I start using 'Flirt and Fork' after installation?**  
A: After downloading and running the .jar file, you can begin by typing commands into the command box. For a complete list of commands, you can type 'help' or refer to the Features and Usage sections of this guide.

**Q: Can I save my favorite restaurants and activities for future reference?**  
A: Absolutely. You can add your favorite dining spots and activities to a favorites list with the 'food' and 'activity' commands. You can also find, list, and delete these favorites as needed.

**Q: Is it possible to modify or delete entries from my favorites list?**  
A: Yes, you can delete any entry from your favorites list using the 'delete' command followed by the index number of the entry you wish to remove.

**Q: How can I view a history of my past date plans?**  
A: You can view all your past marked date restaurants, activities, and gift ideas by using the 'history' command (for suggestions from 'idea', 'itinerary', or 'smart' commands). This feature is perfect for reminiscing or re-visiting successful date ideas.

**Q: Will my data be saved if I close the application?**  
A: Yes, when you use the 'exit' command, 'Flirt and Fork' will automatically save your current data, ensuring that your preferences and favorites are preserved for your next session.

**Q: How can I ensure the best experience with 'Flirt and Fork'?**  
A: Keep your user details updated and regularly add to your favorites list! Ensure that your location and price inputs align with the provided legend for accurate itinerary generation.

## Command Summary

* Display all possible commands: `help`
* List out all restaurants or activities: `list`
* Update your personal information: `me`
* Generate a randomised date idea: `idea`
* Generate a date itinerary, based on preferred location and budget: `itinerary [preferred_location], [preferred_price]`
* Generate a smart date itinerary, based on your user profile: `smart`
* Add a restaurant to your favourites: `food [name of eatery], [location], [price]`
* Add an activity to your favourites: `activity [name of activity], [location], [price]`
* Find an entry from your favourites list: `find [keyword]`
* List out all entries in your favourites list: `favourites`
* Delete an entry from your favourites list: `delete [index of entry]`
* List out all entries from your past date history: `history`
* Exit the program: `exit`