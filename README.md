# Aaron Anderson Individual Project

This project is to create a Ranked Choice Voting Website for simple elections to familiarize people with ranked voting.

### Problem Statement

There are other election systems besides the two party system used by the United States of America for goverment elections. One of the alternative election systems is called Instant Runoff Voting, a type of Ranked Choice Voting. The main idea behind this system is to get the choice that the most voters like.

For more information:
[InstantRunOff.com](http://instantrunoff.com/instant-runoff-home/)
[FairVote.org's Ranked Choice Voting](http://www.fairvote.org/rcv#rcvbenefits)

A Video Example:
[Instant Runoff Voting Example (1.5 minutes)](https://www.youtube.com/watch?v=_5SLQXNpzsk)

### Project Technologies/Techniques
* Security/Authentication
  * Election Admin: create/close/report result
  * Voter: cast vote in election they
  * All, just view information about Instant Run Off Voting or demo election
* Database
  * voters
  * candidates
  * elections
  * votes
* Web Services/API
  * Group project API
* SASS
* Logging
  * Configurable logging using Log4J. In production, only errors will normally be logged, but logging at a debug level can be turned on to facilitate trouble-shooting.
* Site and database hosted on Digital Ocean
* Unit Testing
  * JUnit tests to achieve 80% code coverage
* Independant Research Topic
  * Sass with transpiling in Intellij

### Feature List
* Voter Account
  * Creating election
    **Add candidates/choices
    * Election code
    * Open election for voting
    * Close voting
  * Vote in election
* Admin Account
  * Everything Voter account can do
  * Delete election
  * Add/Remove Elections

### Extra features for future/extra time
* Anonymouse voting with code
* Email results to voters
* Admin - Lock out user
* Email vallidation
* Option to allow voting for only some of candidates
* Option to update votes
* Manually adding voters by email
* connect to google cal for scheduling of votes

### Design

* [Screen Mockups](Design-Docs/IRV-MockUp-160907.pdf)
* [Database Design](Design-Docs/IRV-DB-Design_v1.pdf)

### [Time Log](IRV-TimeLog.md)


