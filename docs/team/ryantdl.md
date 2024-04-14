# Project: Flirt & Fork

Flirt & Fork is a command-line interface (CLI) application designed to simplify the date planning process for busy couples. Flirt & Fork offers a seamless, personalised date planning experience, that guarantees fun and engaging date ideas!

# Summary of Contributions

## Code contributed
An overview of my code contributions can be found [here](https://nus-cs2113-ay2324s2.github.io/tp-dashboard/?search=ryantdl&breakdown=true)

## Enhancements implemented
Given below are my contributions to the project enhancements

- **New Feature**: Generating a date idea
    - What it does: generates out a random date activity and restaurant that the user can visit. No repeated activities or restaurants will be generated, so as to keep date ideas fresh and exciting
    - Justification: This feature improves the product significantly as it addresses the main value proposition of our application, which is streamlining the date planning process. If users remain unsatisfied with the current idea, they can continuously regenerate new ideas. Moreover, as we populated our database with a sufficiently large amount of restaurant and activities, a diverse range of date ideas can be generated.

- **New Feature**: Generating a date itinerary
    - What it does: allows the user to generate out a full-day date itinerary, consisting of 2 meals and 2 activities. Based on the user's input for preferred location and pricing, our food/activity database is filtered through and a randomised itinerary is generated 
    - Justification: This feature builds upon the functionality offered by the 'idea' command. Through scanning user inputs and understanding their preferences, a more personalised date plan can be generated for them. Similar to the date idea generation feature, as we populated our database with a sufficiently large amount of restaurant and activities, a diverse range of date itineraries can be generated

- **New Feature**: Tracking user's past date history
    - What it does: automatically updates the relevant food/activity/gift entries in our database, marking them as completed. The system registers these entries as having been done, and thus will not reuse them in future idea/itinerary generations.
    - Justification: This feature improves the product significantly as users will not have to revisit restaurants and activities previously completed. It ensures that the system can continue to provide fresh date ideas to couples


## Documentation
- Contributions to the User Guide
    - Authored the introduction, providing users with a brief overview of the features and value proposition of our application.
    - Authored the section on the `food` command.
    - Authored the section on the `activity` command.
    - Extended the "Legend" section and the "Command Summary" section.
    - Updated the relevant sections based on changes due to code refactoring.

- Contributions to the Developer Guide
    - Described the `ViewHistoryCommand` and its interaction within the system, which displays and updates user's previous date itineraries within the database.
    - Detailed the implementation of the `Food` and `Activity` classes, detailing the logic behind the classes.
    - Added a sequence diagram for `ViewHistoryCommand` to explain its interactions with other classes during its execution.
    - Added class diagrams for `Food` and `Activity` to describe their structure.    
    - Authored the "Product scope" section and the "Non-Functional Requirements" section to outline the features and functionalities required by our users, and how these were derived by the team  

## Contributions to team-based tasks
- Project Management: 
    - Setting up thr GitHub team organisation/repository
    - Maintaining the issue tracker
    - Documenting product scope and requirements  