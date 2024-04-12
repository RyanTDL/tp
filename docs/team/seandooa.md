# Project: Flirt & Fork

Flirt & Fork is a command-line interface (CLI) application that aims to help users plan for dates. Users will be able to create an itinerary based on specific conditions, let the app suggest one for them based on their personal details or try out something new with a completely random idea. With its extensive database of dining options, activities and gifts, Flirt & Fork will be able to provide a suitable itinerary for all users no matter their budget, preferences or location.
# Summary of Contributions

## Code contributed
An overview of my code contributions can be found [here](https://nus-cs2113-ay2324s2.github.io/tp-dashboard/?search=seandooa&breakdown=true&sort=groupTitle%20dsc&sortWithin=title&since=2024-02-23&timeframe=commit&mergegroup=&groupSelect=groupByRepos&checkedFileTypes=docs~functional-code~test-code~other)

## Enhancements implemented
Here are the enhancements I implemented

- **Improved User Details Command**: Edited the related code to ensure that the command is run automatically at first time start up so the app will always have user data. Implemented error handling for inputting all fields of user data, ranging from strings like Gender to numbers like age.
- **Improved Generate Idea Command**: Implemented a feature where inputting `no` after an idea is generated will regenerate a new idea, and will continue until the user expresses satisfaction or decides to cancel.



### Contributions to the User Guide (UG)
- Update various command sections with their expected outputs.

### Contributions to the Developer Guide (DG)
- Created the section on `GenerateIdeaCommand` and elaborated on the logic of its execution.
- Added an activity diagram for `GenerateIdeaCommand` to facilitate understanding of its description.
- Added a sequence diagram for `GenerateIdeaCommand` to explain its interactions with other classes during its execution.
