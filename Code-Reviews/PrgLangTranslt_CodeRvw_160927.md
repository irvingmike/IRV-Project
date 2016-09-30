# Design/Code Review 1

## Project: PLT (Programming Language Translator)

### Developer: Vang Lee

#### Reviewer: Aaron Anderson

|Criteria|Rating/Comments|
|---|---------------|
|**Problem Statement**| **Comments** |
| Does it exist?| Yes |
|Does the problem statement accurately describe project purpose?| Yes |
|Is the problem statement professional? Think of prospective employers viewing this as part of the developer's portfolio.| Yes |
|What is good?| Yes |
|What could be improved?| Expanded description of usage pattern and functionality |
|**Design Documentation**||
|Is the navigation/flow through the application logical and easy to use?| Yes |
|Is the order in which the fields are displayed and form fields entered logical and easy to use?| Yes |
|What data is missing?| None comes to mind |
|Is there data that is not used?| No |
|What is good?| I like the split screen design so you can see both what you coded and the resulting code in another language |
|What could be improved?| Only at wire fram stage, looks good at this point |
|**Data model**||
|Does it exist?| Yes |
|Is everything on the screens represented in the model?| Yes |
|Does the model represent good database design? | Mostly |
|What is good?| Simple and comprehensive |
|What could be better?| I think the User_Message table could be done away with by simply store the user_id in the message table |
|**Additional design documents**||
|**Application structure in IntelliJ**||
|Does it exist?| Basic setup |
|Is the structure correct for a Maven project?| Yes |
|Are packages and classs appropriately named? | Yes |
|Other comments/notes?| Only at the very basic level of setup |
|**JSPs**||
|Do they exist?| Not yet |
|Is templating used (for example, header.jsp, footer.jsp, etc.)?| |
|Is there business logic mixed in the JSPs?| |
|CSS?| |
|Other comments/notes?| |
|**Entities/DAOs/Controllers||
|Do they exist?| Not yet |
|**Java code quality**||
|Are methods single-purpose?| Not much to go on at this point |
|Are classes appropriately-sized classes (no monster classes)?| |
|Are the same lines of code repeated at all?| |
|Do any classes perform very similar functions that could be candidates for super/subclass relationships?| |
|Are any values hard-coded that should be in a properties file?| |
|Are variable names descriptive?| |
|Are there many branches or loops that could be simplified or broken up into smaller methods?| |
|Do the DAOs use Hibernate? No hard-coded sql!| |
|Other comments/notes?| |
|**Logging**||
|Has log4J been added?| Not yet |
|Are there logging statements in the code?| |
|Are appropriate logging levels used? Info, debug, error, for example.| |
|Are there any System.out.printlns in the code?| |
|Other comments/notes?| |
|**Unit Tests**||
|Do they exist?| Not yet |
|Do the tests pass?| |
|What is the current code coverage?| |
|Is each test truly a unit test or are they functional tests?| |
|Other comments/notes?| |
|**Web Service/API integration**||
|Has a web service/api been selected? | Kind of, couple in consideration |
|What web services/apis might work well with this application?| None come to mind |
|**Independent research topic**||
| Has a topic been selected?| Yes |
|What topic/s might fit well in this application?| None come to mind |
