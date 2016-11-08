# Design/Code Review 2

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
|What could be improved?| the UI could use a little cleanup to make things a little clearer and easier to use (discussed during code review) |
|**Data model**||
|Does it exist?| Yes |
|Is everything on the screens represented in the model?| Yes |
|Does the model represent good database design? | Mostly |
|What is good?| Simple and comprehensive |
|What could be better?| Didn't have time to cover this portion |
|**Additional design documents**||
|**Application structure in IntelliJ**||
|Does it exist?| Yes |
|Is the structure correct for a Maven project?| Yes |
|Are packages and classs appropriately named? | Yes |
|Other comments/notes?| |
|**JSPs**||
|Do they exist?| Yes |
|Is templating used (for example, header.jsp, footer.jsp, etc.)?| No |
|Is there business logic mixed in the JSPs?| Un |
|CSS?| Yes, nice and simple |
|Other comments/notes?| JSPs could be cleaned up by templating. |
|**Entities/DAOs/Controllers||
|Do they exist?| Yes, but several are empty |
|**Java code quality**||
|Are methods single-purpose?| Yes |
|Are classes appropriately-sized classes (no monster classes)?| Yes |
|Are the same lines of code repeated at all?| Not that I saw |
|Do any classes perform very similar functions that could be candidates for super/subclass relationships?| Not currently |
|Are any values hard-coded that should be in a properties file?| No |
|Are variable names descriptive?| Yes |
|Are there many branches or loops that could be simplified or broken up into smaller methods?| No |
|Do the DAOs use Hibernate? No hard-coded sql!| Yes |
|Other comments/notes?| |
|**Logging**||
|Has log4J been added?| Yes |
|Are there logging statements in the code?| No, but there are Logger instatiated that could be used |
|Are appropriate logging levels used? Info, debug, error, for example.| N/A |
|Are there any System.out.printlns in the code?| No |
|Other comments/notes?| |
|**Unit Tests**||
|Do they exist?| Yes, but a lot of the testing code is commented out |
|Do the tests pass?| Yes, but without actually testing things |
|What is the current code coverage?| Unknown |
|Is each test truly a unit test or are they functional tests?| Neither really |
|Other comments/notes?| |
|**Web Service/API integration**||
|Has a web service/api been selected? | Not covered during review |
|What web services/apis might work well with this application?|  |
|**Independent research topic**||
| Has a topic been selected?| Not covered during this review |
|What topic/s might fit well in this application?|  |
