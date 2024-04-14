# Project: Flirt & Fork

Flirt & Fork is a command-line interface (CLI) application that aims to help users plan for dates. Users will be able to create an itinerary based on specific conditions, let the app suggest one for them based on their personal details or try out something new with a completely random idea. With its extensive database of dining options, activities and gifts, Flirt & Fork will be able to provide a suitable itinerary for all users no matter their budget, preferences or location.
# Summary of Contributions

## Code contributed
An overview of my code contributions can be found [here](https://nus-cs2113-ay2324s2.github.io/tp-dashboard/?search=seandooa&breakdown=true&sort=groupTitle%20dsc&sortWithin=title&since=2024-02-23&timeframe=commit&mergegroup=&groupSelect=groupByRepos&checkedFileTypes=docs~functional-code~test-code~other)

## Enhancements implemented
Here are the enhancements I implemented

- **Improved User Details Command**: Edited the related code to ensure that the command is run automatically at first time start up so the app will always have user data. Implemented error handling for inputting all fields of user data, ranging from strings like Gender to numbers like age. Refactored the `UserDetailsCommand` class to update the existing `UserDetails` object instead of creating a new one to fix a bug in saving to storage.
- **Improved Generate Idea Command**: Implemented a feature where inputting `no` after an idea is generated will regenerate a new idea, and will continue until the user expresses satisfaction or decides to cancel.
- **Base Functions of Initial Codebase**: Created the initial Food and Activity classes, the FoodList and ActivityList classes as well as their respective parsers.

### Testing
- Contributed J-Unit tests for GenerateIdeaCommand, ListOptionsCommand and UserDetailsCommand classes.

### Contributions to the User Guide (UG)
- Update various command sections with their expected outputs.
- Authored the section describing the `me` command.

### Contributions to the Developer Guide (DG)
- Authored the section on `GenerateIdeaCommand` and elaborated on the logic of its execution.
- Added an activity diagram for `GenerateIdeaCommand` to facilitate understanding of its description.
- Added a sequence diagram for `GenerateIdeaCommand` to explain its interactions with other classes during its execution.
- Added an object diagram for `GenerateIdeaCommand` to illustrate the `idea` object more clearly in relation to other objects.

### Contributions to team-based tasks
- Attempted to fix the bug in release v1.0 where the database was not saved as we did not create a resources directory yet. Bug was eventually fixed by @liuyi1103.
- Took charge of the v2.0b release. v2.0b had a bug in the jar file which was not present when the program was run with gradle. Did the last-minute urgent bug fix and was able to publish the release before the stipulated deadline. Link to the issue can be found [here](https://github.com/AY2324S2-CS2113-T11-2/tp/issues/86). Another bug caused by us not knowing data could not be written to the resources directory once the jar file is made was also flagged out by me and slated to be fixed in the next release.
- Helped with maintaining the issue tracker.

### Review/mentoring contributions
- Helped some team members with learning how to use shadowJar
- Try to reply immediately whenever team members are asking for assistance in the group chat.

## Contributions beyond the project team
- Highlighted 7-8 non-trivial bugs for the team I was assigned to during the PE dry run. This ranged from serious issues with the User Guide pdf formatting to feature flaws. Also gave advice on not merging PRs that do not pass the GitHub checks since merged PRs with failed checks could be seen on their User Guide.
- Did [DG Review](https://github.com/nus-cs2113-AY2324S2/tp/pull/18) during tutorial.
- Will be exchanging jar files with another team for one last round of extensive user testing before final submission. Issues raised can be found [here](https://github.com/AY2324S2-CS2113-F15-2/tp/issues/created_by/seandooa).