Pawject L

This is a repository for a group project for CSC207 at UofT. 

Pawject L is a pet matching app that allows pet owners to find compatible pets for meetups. Users can
create profiles with both their pets’ information and their own information, and log in and log out
as needed. They will be able to view and edit their profiles, as well as other users’ profiles.
Users are given pet matches based on inputted preferences (e.g. location, availability, species,
owner immunization status). They can swipe on matches, and if both users match with each
other, they can chat using text to set up a meetup. Once the user is given a match, the user will
not see the match again no matter the match status (if they swiped or not). Users can report
other users, and once a threshold is reached, the reported user will be dealt with appropriately.

## Features
-  Account Creation (Sign up system)
-  Pet Profile Creation 
-  Find Potential Matches Algorithm(FPMA). Looks for compatible pets for your pet.
-  Match Manager
-  Chat Management System. Chat with you and your pet's best friends!
-  Data Storage
-  Report System. Help us prevent inappropriate contents in the public.

## How to Start
- Go to src\main\java\ui\Homescreen.java, compile and run the program.
- Type your username and password to sign in. Don't have an account？Sign up button is ready at the bottom of the interface.
- Then you will be taken to the pet profile creation screen. Follow the instructions on it and tell us everything about you sweat heart! Don't forget to upload a picture in jpg format. 
- You will see a queue of pets that might be a perfect match for your pet after profile creation. Decide by yourself whether you like them or not. 
- Then you're done! Chat freely with your favourite pet matches (don't forget to manually update your chat log by closing and reopening the chat screen to), check your pet's profile at your wish, and refresh the app by clicking the "home" button. 
- Enjoy your journey with Pawject L!
## Checklist For Your Project
- [ ] Verify the correct settings for your project repository
- [ ] Set up Github Projects
- [ ] Create the implementation plan using issues and Github Projects
- [ ] Create deveopment branches for your features
- [ ] Use pull requests to merge finished features into main branch
- [ ] Conduct code reviews

**If your team has trouble with any of these steps, please ask on Piazza. For example, with how GitHub Classroom works, your team *may* not have permissions to do some of the first few steps, in which case we'll post alternative instructions as needed.**

## Workflow Documents

* Github Workflow: Please refer to the workflow that was introduced in the first lab. You should follow this when working on your code. The following document provides additional details too.

* [Project Planning and Development Guide](project_plan_dev.md): This document helps you to understand how to create and maintain a project plan for your class project. **This document helps you to complete the Implementation Plan Milestone.**

## Gradle Project
Import this project into your Intellij editor. It should automatically recognise this as a gradle repository.
The starter code was built using SDK version 11.0.1. Ensure that you are using this version for this project. (You can, of course, change the SDK version as per your requirement if your team has all agreed to use a different version)

You have been provided with two starter files for demonstration: HelloWorld and HelloWorldTest.

You will find HelloWorld in `src/main/java/tutorial` directory. Right click on the HelloWorld file and click on `Run HelloWorld.main()`.
This should run the program and print on your console.

You will find HelloWorldTest in `src/test/java/tutorial` directory. Right click on the HelloWorldTest file and click on `Run HelloWorldTest`.
All tests should pass. Your team can remove this sample of how testing works once you start adding your project code to the repo.

Moving forward, we expect you to maintain this project structure. You *should* use Gradle as the build environment, but it is fine if your team prefers to use something else -- just remove the gradle files and push your preferred project setup. Assuming you stick with Gradle, your source code should go into `src/main/java` (you can keep creating more subdirectories as per your project requirement). Every source class can auto-generate a test file for you. For example, open HelloWorld.java file and click on the `HelloWorld` variable as shown in the image below. You should see an option `Generate` and on clicking this your should see an option `Test`. Clicking on this will generate a JUnit test file for `HelloWorld` class. This was used to generate the `HelloWorldTest`.

![image](https://user-images.githubusercontent.com/5333020/196066655-d3c97bf4-fdbd-46b0-b6ae-aeb8dbcf351d.png)

You can create another simple class and try generating a test for this class.
